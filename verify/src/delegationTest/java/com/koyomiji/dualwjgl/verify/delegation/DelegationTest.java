package com.koyomiji.dualwjgl.verify.delegation;

import org.junit.jupiter.api.Test;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.*;
import sun.misc.Unsafe;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.*;
import java.net.URL;
import java.nio.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Every LWJGL 2 method stubgen implemented by delegation must make the same native calls, with the same arguments, as
 * LWJGL 2's own implementation. Both run here without a driver: the original LWJGL 2 jars and the patched jars are
 * each loaded with their natives rewritten to report to {@link Recorder}, and called with the same arguments.
 */
@SuppressWarnings("deprecation") // sun.misc.Unsafe: the only way to fake final capability fields
class DelegationTest {

	private static final String GENERATED = "Lcom/koyomiji/dualwjgl/inject/Generated;";
	private static final String TODO = "Lcom/koyomiji/dualwjgl/inject/Todo;";
	private static final String GENERATED_PACKAGE = "com/koyomiji/dualwjgl/generated/";
	private static final List<String> PACKAGES = List.of("org/lwjgl/opengl/", "org/lwjgl/openal/", "org/lwjgl/opencl/");

	/** fake function addresses: far from any buffer address, and from the small numbers passed as arguments */
	private static final long FN_BASE = 0x7E00_0000_0000L;

	private static final Unsafe UNSAFE;
	private static final long ADDRESS;

	static {
		try {
			Field f = Unsafe.class.getDeclaredField("theUnsafe");
			f.setAccessible(true);
			UNSAFE = (Unsafe)f.get(null);
			ADDRESS = UNSAFE.objectFieldOffset(Buffer.class.getDeclaredField("address"));
		} catch (ReflectiveOperationException e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	record Target(String cls, String name, String desc) {
		@Override
		public String toString() {
			return cls.replace('/', '.') + "." + name + desc;
		}
	}

	/** One side: its loader, and its fake function addresses -> function names. */
	static final class Side {
		final String label;
		final ClassLoader loader;
		final Map<Long, String> functions = new HashMap<>();

		Side(String label, ClassLoader loader) {
			this.label = label;
			this.loader = loader;
		}

		/** An instance of {@code cls} with every long field a distinct fake function address, every boolean true. */
		Object capabilities(String cls) throws ReflectiveOperationException {
			Class<?> c = Class.forName(cls, true, loader);
			Object o = UNSAFE.allocateInstance(c);
			for (Field f : c.getDeclaredFields()) {
				if (Modifier.isStatic(f.getModifiers())) {
					continue;
				}
				long off = UNSAFE.objectFieldOffset(f);
				if (f.getType() == long.class) {
					long fn = FN_BASE + functions.size() + 1;
					functions.put(fn, f.getName());
					UNSAFE.putLong(o, off, fn);
				} else if (f.getType() == boolean.class) {
					UNSAFE.putBoolean(o, off, true);
				}
			}
			return o;
		}

		Object set(Object o, String field, String type) throws ReflectiveOperationException {
			Constructor<?> k = Class.forName(type, true, loader).getDeclaredConstructor();
			k.setAccessible(true);
			Object v = k.newInstance();
			UNSAFE.putObject(o, UNSAFE.objectFieldOffset(o.getClass().getDeclaredField(field)), v);
			return v;
		}
	}

	@Test
	void delegationsMakeTheSameNativeCalls() throws Exception {
		List<Target> targets = targets(paths("com.koyomiji.dualwjgl.compat.classes"));
		Side two = lwjgl2();
		Side three = lwjgl3();
		// pointers either side allocated itself: big, and not one of the fake function addresses
		Recorder.peekable = v -> Math.abs(v) > (1L << 32) && (v < FN_BASE || v > FN_BASE + (1 << 21));

		Map<String, Integer> skipped = new TreeMap<>();
		List<String> mismatches = new ArrayList<>();
		int compared = 0;
		int run = 0;
		for (Target t : targets) {
			String outcome = null;
			for (boolean flag : new boolean[] {true, false}) {
				// fresh ints every run: temporary memory left over from the previous call must not look like an argument
				int seed = ++run;
				Args args2 = Args.of(t.desc, flag, seed, two.loader);
				if (args2 == null) {
					outcome = "skip: parameter type";
					break;
				}
				Args args3 = Args.of(t.desc, flag, seed, three.loader);
				Run r2 = run(two, t, args2);
				Run r3 = run(three, t, args3);
				if (r2.error != null) {
					outcome = "skip: LWJGL 2 throws " + r2.error.getClass().getSimpleName() + ": "
						+ String.valueOf(r2.error.getMessage()).replaceAll("\\d+", "N").replaceAll("\\. .*", "");
					break;
				}
				if (r3.error != null && r3.error.getMessage() != null && r3.error.getMessage().contains("Function is not supported")) {
					outcome = "skip: unsupported";
					break;
				}
				List<String> c2 = normalize(two, r2.calls, args2);
				List<String> c3 = r3.error != null ? List.of("throws " + r3.error) : normalize(three, r3.calls, args3);
				if (c2.isEmpty() && c3.isEmpty()) {
					outcome = "skip: no native call on either side";
					break;
				}
				if (!same(c2, c3, args2.intValues())) {
					mismatches.add(t + (flag ? "" : " [booleans false]") + "\n    LWJGL 2: " + c2 + "\n    patched: " + c3);
					outcome = "mismatch";
					break;
				}
			}
			if (outcome == null) {
				compared++;
			} else if (outcome.startsWith("skip")) {
				skipped.merge(outcome, 1, Integer::sum);
			}
		}

		Path report = Paths.get(System.getProperty("com.koyomiji.dualwjgl.report"));
		Files.createDirectories(report.getParent());
		Files.write(report, mismatches);
		System.out.println("Delegations: " + targets.size() + ", same native calls: " + compared + ", mismatches: "
			+ mismatches.size() + ", skipped: " + skipped);
		assertTrue(mismatches.isEmpty(), mismatches.size() + " delegations differ from LWJGL 2 (all in " + report + "):\n"
			+ mismatches.stream().limit(20).collect(Collectors.joining("\n")));
	}

	// ---- sides

	private static Side lwjgl2() throws Exception {
		RewritingLoader l = new RewritingLoader(urls("com.koyomiji.dualwjgl.lwjgl2.jars"), cls -> cls.startsWith("org/lwjgl/"),
			Map.of("org/lwjgl/opengl/GLContext.getCapabilities", "lwjgl2GL", "org/lwjgl/opencl/CL.getFunctionAddress", "#clFunction"),
			// state checks (e.g. "Cannot use offsets when Array Buffer Object is disabled"), not argument mapping; and
			// Sys's check that liblwjgl matches the jar
			List.of("org/lwjgl/opengl/GLChecks.ensure", "org/lwjgl/Sys.<clinit>"));
		Side s = new Side("LWJGL 2", l);
		// Sys.<clinit> is emptied, which also skips setting Sys.is64Bit: PointerBuffer would count 32-bit pointers
		Field is64Bit = Class.forName("org.lwjgl.Sys", true, l).getDeclaredField("is64Bit");
		UNSAFE.putBoolean(UNSAFE.staticFieldBase(is64Bit), UNSAFE.staticFieldOffset(is64Bit), UNSAFE.addressSize() == 8);
		Object caps = s.capabilities("org.lwjgl.opengl.ContextCapabilities");
		Recorder.lwjgl2GL = caps;
		s.set(caps, "util", "org.lwjgl.opengl.APIUtil");
		Object tracker = s.set(caps, "tracker", "org.lwjgl.opengl.StateTracker");
		Method init = tracker.getClass().getDeclaredMethod("init");
		init.setAccessible(true);
		init.invoke(tracker);
		return s;
	}

	private static Side lwjgl3() throws Exception {
		RewritingLoader l = new RewritingLoader(urls("com.koyomiji.dualwjgl.patched.jars"),
			cls -> cls.equals("org/lwjgl/system/JNI") || PACKAGES.stream().anyMatch(cls::startsWith),
			Map.of("org/lwjgl/opengl/GL.getICD", "lwjgl3GL", "org/lwjgl/opengl/GL.getCapabilities", "lwjgl3GL",
				"org/lwjgl/openal/AL.getICD", "lwjgl3AL", "org/lwjgl/openal/AL.getCapabilities", "lwjgl3AL",
				"org/lwjgl/openal/ALC.getICD", "lwjgl3ALC", "org/lwjgl/openal/ALC.getCapabilities", "lwjgl3ALC",
				"org/lwjgl/opencl/CL.getICD", "lwjgl3CL"),
			// they load liblwjgl_opengl / OpenAL / OpenCL and create the ICD; every native is rewritten and the accessors replaced
			List.of("org/lwjgl/opengl/GL.<clinit>", "org/lwjgl/openal/AL.<clinit>", "org/lwjgl/openal/ALC.<clinit>",
				"org/lwjgl/opencl/CL.<clinit>"));
		Side s = new Side("patched", l);
		Recorder.lwjgl3GL = s.capabilities("org.lwjgl.opengl.GLCapabilities");
		Recorder.lwjgl3AL = s.capabilities("org.lwjgl.openal.ALCapabilities");
		Recorder.lwjgl3ALC = s.capabilities("org.lwjgl.openal.ALCCapabilities");
		Recorder.lwjgl3CL = s.capabilities("org.lwjgl.opencl.CLCapabilities");
		return s;
	}

	record Run(List<Recorder.Call> calls, Throwable error) {
	}

	private static Run run(Side side, Target t, Args args) {
		Recorder.calls.clear();
		try {
			Class<?> c = Class.forName(t.cls.replace('/', '.'), true, side.loader);
			Method m = Stream.of(c.getMethods())
				.filter(x -> x.getName().equals(t.name) && Type.getMethodDescriptor(x).equals(t.desc)).findFirst()
				.orElseThrow(() -> new NoSuchMethodException(t.toString()));
			m.invoke(null, args.values);
			return new Run(new ArrayList<>(Recorder.calls), null);
		} catch (InvocationTargetException e) {
			return new Run(List.of(), e.getCause());
		} catch (ReflectiveOperationException | LinkageError e) {
			return new Run(List.of(), e);
		}
	}

	// ---- arguments

	/** Arguments for one call; buffers keep their base address so pointers into them compare across sides. */
	static final class Args {
		final Object[] values;
		final List<long[]> buffers = new ArrayList<>(); // {base address, byte size, parameter index}

		private Args(int n) {
			values = new Object[n];
		}

		/** Distinct, recognizable values per parameter; null if a parameter type is not handled. */
		static Args of(String desc, boolean flag, int seed, ClassLoader loader) {
			Type[] ts = Type.getArgumentTypes(desc);
			Args a = new Args(ts.length);
			for (int k = 0; k < ts.length; k++) {
				Object v = a.value(ts[k], k, flag, seed, loader);
				if (v == null) {
					return null;
				}
				a.values[k] = v;
			}
			return a;
		}

		private Object value(Type t, int k, boolean flag, int seed, ClassLoader loader) {
			switch (t.getSort()) {
				case Type.BOOLEAN: return flag;
				case Type.BYTE: return (byte)(3 + k);
				case Type.CHAR: return (char)(3 + k);
				case Type.SHORT: return (short)(300 + k);
				// small (counts must fit LWJGL 2's minimum buffer sizes), odd step per parameter, even step per run
				case Type.INT: return 101 + 13 * k + 2 * (seed % 1000);
				case Type.LONG: return 100_000L + 31 * k;
				case Type.FLOAT: return 0.5f + k;
				case Type.DOUBLE: return 0.25 + k;
				case Type.ARRAY: return array(t, k);
				default: break;
			}
			if (t.getClassName().equals("org.lwjgl.opengl.GLSync") || t.getClassName().equals("org.lwjgl.PointerWrapper")) {
				// a handle wrapper (package-private constructor in LWJGL 2): a small handle shows as itself in the calls
				try {
					Constructor<?> c = Class.forName("org.lwjgl.opengl.GLSync", true, loader).getDeclaredConstructor(long.class);
					c.setAccessible(true);
					return c.newInstance(7000L + k);
				} catch (ReflectiveOperationException e) {
					throw new IllegalStateException(e);
				}
			}
			if (t.getClassName().startsWith("org.lwjgl.opencl.CL")) {
				// a CL object (CLContext, CLMem, ...): allocated without its constructor, which registers it with a
				// parent; only its handle, and a reference count that makes it valid, matter to the bindings
				try {
					Class<?> c = Class.forName(t.getClassName(), true, loader);
					Class<?> wrapper = Class.forName("org.lwjgl.PointerWrapperAbstract", true, loader);
					if (!wrapper.isAssignableFrom(c) || Modifier.isAbstract(c.getModifiers())) {
						return null;
					}
					Object o = UNSAFE.allocateInstance(c);
					UNSAFE.putLong(o, UNSAFE.objectFieldOffset(wrapper.getDeclaredField("pointer")), 7000L + k);
					for (Class<?> s = c; s != null; s = s.getSuperclass()) {
						for (Field f : s.getDeclaredFields()) {
							if (f.getName().equals("refCount") && f.getType() == int.class) {
								UNSAFE.putInt(o, UNSAFE.objectFieldOffset(f), 1);
							}
						}
					}
					return o;
				} catch (ReflectiveOperationException e) {
					throw new IllegalStateException(e);
				}
			}
			// remaining: 4201 + 6k elements, not a multiple of 2, 3, 4, 8 or 12, so a wrong shift or divisor shows; and
			// more than LWJGL 2's minimums for getters
			int position = k + 1;
			int remaining = 4201 + 6 * k;
			ByteBuffer bb = ByteBuffer.allocateDirect(8 * (position + remaining + 8)).order(ByteOrder.nativeOrder());
			buffers.add(new long[] {UNSAFE.getLong(bb, ADDRESS), bb.capacity(), k});
			Buffer b = switch (t.getClassName()) {
				case "java.nio.ByteBuffer" -> bb;
				case "java.nio.ShortBuffer" -> bb.asShortBuffer();
				case "java.nio.CharBuffer" -> bb.asCharBuffer();
				case "java.nio.IntBuffer" -> bb.asIntBuffer();
				case "java.nio.FloatBuffer" -> bb.asFloatBuffer();
				case "java.nio.LongBuffer" -> bb.asLongBuffer();
				case "java.nio.DoubleBuffer" -> bb.asDoubleBuffer();
				case "java.nio.Buffer" -> bb;
				case "org.lwjgl.PointerBuffer" -> null;
				default -> {
					buffers.remove(buffers.size() - 1);
					yield null;
				}
			};
			if (t.getClassName().equals("org.lwjgl.PointerBuffer")) {
				try {
					// both PointerBuffer(ByteBuffer) constructors view the source's remaining bytes
					bb.limit(8 * (position + remaining)).position(8 * position);
					return Class.forName("org.lwjgl.PointerBuffer", true, loader).getConstructor(ByteBuffer.class).newInstance(bb);
				} catch (ReflectiveOperationException e) {
					throw new IllegalStateException(e);
				}
			}
			if (b == null) {
				return t.getClassName().equals("java.lang.CharSequence") || t.getClassName().equals("java.lang.String") ? "s" + k : null;
			}
			b.limit(position + remaining).position(position);
			return b;
		}

		private Object array(Type t, int k) {
			int n = 5 + k;
			return switch (t.getDescriptor()) {
				case "[I" -> new int[n];
				case "[J" -> new long[n];
				case "[F" -> new float[n];
				case "[D" -> new double[n];
				case "[S" -> new short[n];
				default -> null;
			};
		}

		/** The int arguments, as the calls render them. */
		Set<String> intValues() {
			Set<String> out = new HashSet<>();
			for (Object v : values) {
				if (v instanceof Integer x) {
					out.add(x.toString());
				}
			}
			return out;
		}

		/** "p1+16" for an address 16 bytes into parameter 1's buffer, null if outside every buffer. */
		String pointer(long v) {
			for (long[] b : buffers) {
				if (v >= b[0] && v <= b[0] + b[1]) {
					return "p" + b[2] + "+" + (v - b[0]);
				}
			}
			return null;
		}
	}

	// ---- comparison

	/** Each native call as {@code function(arg, ...)}, independent of how each side reaches it. */
	private static List<String> normalize(Side side, List<Recorder.Call> calls, Args args) {
		List<String> out = new ArrayList<>();
		for (Recorder.Call c : calls) {
			String simple = c.method().substring(c.method().lastIndexOf('.') + 1);
			List<Object> as = new ArrayList<>(Arrays.asList(c.args()));
			String fn = null;
			if (!as.isEmpty() && as.get(as.size() - 1) instanceof Long a
				&& (side.functions.containsKey(a) || Recorder.lwjgl2CLFunctions.containsKey(a))) {
				fn = side.functions.containsKey(a) ? side.functions.get(a) : Recorder.lwjgl2CLFunctions.get(a);
				as.remove(as.size() - 1);
			}
			if (fn == null) {
				// natives that find the function themselves: LWJGL 2's nalGenSources, LWJGL 3's glEnable and nglSetMultisamplefvAMD
				fn = simple.startsWith("ngl") || simple.startsWith("nal") ? simple.substring(1) : simple;
			}
			List<String> rendered = new ArrayList<>();
			for (int i = 0; i < as.size(); i++) {
				rendered.add(arg(as.get(i), c.peeked()[i], args));
			}
			// LWJGL 2's OpenAL natives for one value (nalGenSources2(1), nalDeleteEffects2(1, effect)) make the
			// temporary in C: written as the call with that temporary, as LWJGL 3 makes it
			if (simple.startsWith("nal") && simple.endsWith("2") && (as.size() == 1 || as.size() == 2)) {
				fn = fn.substring(0, fn.length() - 1);
				if (as.size() == 1) {
					rendered.add("tmp");
				} else {
					String value = "tmp";
					for (int i = 0; i < args.values.length; i++) {
						if (args.values[i] instanceof Integer x && x.equals(as.get(1))) {
							value = "tmp=arg" + i;
						}
					}
					rendered.set(1, value);
				}
			}
			out.add(fn + "(" + String.join(", ", rendered) + ")");
		}
		return out;
	}

	/**
	 * LWJGL 2's natives for single-value getters (nalGetEffecti) return the value and take the address in C; LWJGL 3
	 * passes stack memory and reads it. Otherwise the calls must be equal.
	 */
	private static boolean same(List<String> c2, List<String> c3, Set<String> ints) {
		if (c2.size() != c3.size()) {
			return false;
		}
		for (int i = 0; i < c2.size(); i++) {
			String a = c2.get(i);
			String b = c3.get(i);
			if (!a.equals(b) && !b.equals(a.substring(0, a.length() - 1) + (a.endsWith("()") ? "tmp)" : ", tmp)"))
				&& !boolArguments(a, b, ints)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * DEVIATION(bool-arguments): a cl_bool LWJGL 2 took as an int (blocking_read) LWJGL 3 takes as a boolean, and passes
	 * as 1: equal where only such arguments differ, an int argument on LWJGL 2's side and 1 on the patched one.
	 */
	private static boolean boolArguments(String a, String b, Set<String> ints) {
		int pa = a.indexOf('('), pb = b.indexOf('(');
		if (pa < 0 || pb < 0 || !a.substring(0, pa).equals(b.substring(0, pb))) {
			return false;
		}
		String[] xs = a.substring(pa + 1, a.length() - 1).split(", ");
		String[] ys = b.substring(pb + 1, b.length() - 1).split(", ");
		if (xs.length != ys.length) {
			return false;
		}
		for (int i = 0; i < xs.length; i++) {
			if (!xs[i].equals(ys[i]) && !(ints.contains(xs[i]) && ys[i].equals("1"))) {
				return false;
			}
		}
		return true;
	}

	private static String arg(Object a, Integer peeked, Args args) {
		if (a instanceof Boolean b) {
			return b ? "1" : "0";
		}
		if (a instanceof Float || a instanceof Double) {
			return Double.toString(((Number)a).doubleValue());
		}
		if (a instanceof Character ch) {
			return Integer.toString(ch);
		}
		if (a instanceof Number n) {
			long v = n.longValue();
			String p = args.pointer(v);
			if (p != null) {
				return p;
			}
			if (Math.abs(v) <= (1L << 32)) {
				return Long.toString(v);
			}
			// memory either side allocated itself (LWJGL 2's APIUtil buffers, LWJGL 3's stack): what it holds compares
			// when it is one of the arguments (glDeleteTextures(int) passes its argument in it); otherwise it is output
			for (int i = 0; peeked != null && i < args.values.length; i++) {
				if (args.values[i] instanceof Integer x && x.intValue() == peeked) {
					return "tmp=arg" + i;
				}
			}
			return "tmp";
		}
		if (a == null) {
			return "null";
		}
		for (int i = 0; i < args.values.length; i++) {
			if (args.values[i] == a) {
				// an LWJGL 2 native that took a String (AL10.alIsExtensionPresent) encoded it in C; LWJGL 3 encodes it on
				// the stack: the string's own text is not compared, as for any temporary
				return a instanceof CharSequence ? "tmp" : "arg" + i;
			}
		}
		return a.getClass().getSimpleName();
	}

	// ---- what stubgen generated as delegations

	private static List<Target> targets(List<Path> dirs) throws IOException {
		List<Target> out = new ArrayList<>();
		for (Path dir : dirs) {
			List<Path> files;
			try (Stream<Path> s = Files.walk(dir)) {
				files = s.filter(f -> f.toString().endsWith(".class")).sorted().toList();
			}
			for (Path f : files) {
				ClassNode cn = new ClassNode();
				new ClassReader(Files.readAllBytes(f)).accept(cn, 0);
				// fragments are generated by package, whole classes by annotation
				if (!cn.name.startsWith(GENERATED_PACKAGE) && !has(cn.invisibleAnnotations, GENERATED)) {
					continue;
				}
				String target = cn.name.startsWith(GENERATED_PACKAGE) ? cn.name.substring(GENERATED_PACKAGE.length()) : into(cn);
				if (PACKAGES.stream().noneMatch(target::startsWith)) {
					continue;
				}
				for (MethodNode m : cn.methods) {
					if ((m.access & (Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC)) != (Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC)
						|| has(m.invisibleAnnotations, TODO) || throwsFirst(m)) {
						continue;
					}
					out.add(new Target(target, m.name, m.desc));
				}
			}
		}
		return out;
	}

	/** A fragment stubgen wrote into the target's package names its target with @Into; a whole class is itself. */
	private static String into(ClassNode cn) {
		if (cn.invisibleAnnotations != null) {
			for (AnnotationNode a : cn.invisibleAnnotations) {
				if (a.desc.equals("Lcom/koyomiji/dualwjgl/inject/Into;") && a.values != null) {
					return ((Type)a.values.get(1)).getInternalName();
				}
			}
		}
		return cn.name;
	}

	private static boolean has(List<AnnotationNode> as, String desc) {
		return as != null && as.stream().anyMatch(a -> a.desc.equals(desc));
	}

	/** An unsupported function: the body only throws. */
	private static boolean throwsFirst(MethodNode m) {
		for (AbstractInsnNode i : m.instructions) {
			if (i.getOpcode() >= 0) {
				return i.getOpcode() == Opcodes.NEW && ((TypeInsnNode)i).desc.endsWith("Exception");
			}
		}
		return false;
	}

	private static List<Path> paths(String property) {
		return Stream.of(System.getProperty(property).split(File.pathSeparator)).filter(s -> !s.isEmpty()).map(Paths::get).toList();
	}

	private static URL[] urls(String property) throws IOException {
		List<URL> out = new ArrayList<>();
		for (Path p : paths(property)) {
			out.add(p.toUri().toURL());
		}
		return out.toArray(new URL[0]);
	}

}
