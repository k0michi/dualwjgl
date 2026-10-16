package com.koyomiji.lwjgl2w3.merger;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.commons.ClassRemapper;
import org.objectweb.asm.commons.Remapper;
import org.objectweb.asm.tree.*;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.jar.*;
import java.util.stream.*;

/**
 * Produces LWJGL 3 jars that also carry the LWJGL 2 API.
 *
 * <p>Classes from {@code --classes} are sorted by what they are:</p>
 * <ul>
 * <li>Fragments ({@code com/koyomiji/lwjgl2w3/inject/<pkg>/<Name>} hand-written, or
 * {@code com/koyomiji/lwjgl2w3/generated/<pkg>/<Name>} written by stubgen; {@code @Into} overrides the target) are
 * merged into {@code <pkg>/<Name>}: their members are copied in and references to the fragment are remapped.</li>
 * <li>Other classes (LWJGL 2-only classes in their real package; {@code @Generated} if stubgen wrote them) are added
 * to the LWJGL 3 jar that owns the package, or to the extra jar when no LWJGL 3 jar does.</li>
 * </ul>
 * <p>Classes from {@code --replace} replace the LWJGL 3 class of the same name wholesale.</p>
 *
 * <p>Generated code may only add members. A hand-written fragment may override a generated member; that is how
 * hand-written code takes over from stubgen without editing generated files. Members of generated code still marked
 * {@code @Todo} after that are reported per area.</p>
 *
 * <p>Usage: {@code Merger --jar IN=OUT ... --replace DIR --classes DIR ... --extra OUT}</p>
 */
public final class Merger {

	static final String INJECT_PREFIX = "com/koyomiji/lwjgl2w3/inject/";
	static final String GENERATED_PREFIX = "com/koyomiji/lwjgl2w3/generated/";
	static final String ANNOTATION_PREFIX = "L" + INJECT_PREFIX;
	static final String WIDEN = ANNOTATION_PREFIX + "Widen;";
	static final String HIDDEN = ANNOTATION_PREFIX + "Hidden;";
	static final String WRAP = ANNOTATION_PREFIX + "Wrap;";
	static final String AROUND = ANNOTATION_PREFIX + "Around;";
	/** Suffix of the original method a @Wrap method replaces */
	static final String WRAPPED_SUFFIX = "$lwjgl3";
	static final String INTO = ANNOTATION_PREFIX + "Into;";
	static final String GENERATED = ANNOTATION_PREFIX + "Generated;";
	static final String TODO = ANNOTATION_PREFIX + "Todo;";
	static final String CLINIT_ALIAS = "lwjgl2w3$clinit";
	static final String VERSIONS = "META-INF/versions/";

	static final class JarImage {
		final Path out;
		final Map<String, byte[]> entries = new LinkedHashMap<>();
		Manifest manifest;

		JarImage(Path out) {
			this.out = out;
		}
	}

	final List<JarImage> jars = new ArrayList<>();
	final Map<String, JarImage> packageOwner = new HashMap<>();
	final Map<String, JarImage> classOwner = new HashMap<>();
	final List<String> log = new ArrayList<>();
	/** fragment -> target class, from @Into or from the fragment's prefix */
	final Map<String, String> injectTargets = new HashMap<>();
	final Set<String> replaced = new HashSet<>();
	/** members (class.name+desc, class.name for fields) that came from generated code and may be overridden */
	final Set<String> generatedMembers = new HashSet<>();
	/** generated members still marked @Todo -> area */
	final Map<String, String> todos = new TreeMap<>();
	int overrides;
	/** target -> {enter, exit} from @Around, applied once every inject class is merged */
	final Map<String, String[]> arounds = new TreeMap<>();

	public static void main(String[] args) throws IOException {
		Merger m = new Merger();
		List<Path> classDirs = new ArrayList<>(), replaceDirs = new ArrayList<>();
		Path extra = null;
		for (int i = 0; i < args.length; i++) {
			switch (args[i]) {
				case "--jar": {
					String[] io = args[++i].split("=", 2);
					m.read(Paths.get(io[0]), Paths.get(io[1]));
					break;
				}
				case "--classes":
					classDirs.add(Paths.get(args[++i]));
					break;
				case "--replace":
					replaceDirs.add(Paths.get(args[++i]));
					break;
				case "--extra":
					extra = Paths.get(args[++i]);
					break;
				default:
					throw new IllegalArgumentException("Unknown argument: " + args[i]);
			}
		}
		JarImage extraJar = new JarImage(Objects.requireNonNull(extra, "--extra is required"));
		List<byte[]> replacements = new ArrayList<>();
		for (Path dir : replaceDirs) {
			for (Path f : classFiles(dir)) {
				replacements.add(Files.readAllBytes(f));
			}
		}
		m.replace(replacements);

		List<byte[]> generatedClasses = new ArrayList<>(), manualClasses = new ArrayList<>();
		List<byte[]> generatedFragments = new ArrayList<>(), manualFragments = new ArrayList<>();
		for (Path dir : classDirs) {
			for (Path f : classFiles(dir)) {
				byte[] b = Files.readAllBytes(f);
				ClassNode cn = new ClassNode();
				new ClassReader(b).accept(cn, ClassReader.SKIP_CODE);
				String target = fragmentTarget(cn);
				if (target != null) {
					m.injectTargets.put(cn.name, target);
					(cn.name.startsWith(GENERATED_PREFIX) ? generatedFragments : manualFragments).add(b);
				} else {
					(has(cn.invisibleAnnotations, GENERATED) ? generatedClasses : manualClasses).add(b);
				}
			}
		}
		for (byte[] b : generatedClasses) {
			m.add(b, extraJar, true);
		}
		for (byte[] b : manualClasses) {
			m.add(b, extraJar, false);
		}
		for (byte[] b : generatedFragments) {
			m.inject(b, true);
		}
		for (byte[] b : manualFragments) {
			m.inject(b, false);
		}
		m.instrument();
		for (JarImage j : m.jars) {
			write(j);
		}
		if (!extraJar.entries.isEmpty()) {
			write(extraJar);
		}
		m.log.forEach(System.out::println);
		m.report();
	}

	void report() {
		Map<String, Integer> byArea = new TreeMap<>();
		todos.values().forEach(a -> byArea.merge(a, 1, Integer::sum));
		System.out.println("Hand-written members overriding generated ones: " + overrides);
		System.out.println("Remaining TODOs: " + todos.size() + " " + byArea);
	}

	static List<Path> classFiles(Path dir) throws IOException {
		if (!Files.isDirectory(dir)) {
			return Collections.emptyList();
		}
		try (Stream<Path> s = Files.walk(dir)) {
			return s.filter(p -> p.toString().endsWith(".class")).sorted().collect(Collectors.toList());
		}
	}

	void read(Path in, Path out) throws IOException {
		JarImage j = new JarImage(out);
		try (JarFile jf = new JarFile(in.toFile())) {
			j.manifest = jf.getManifest();
			for (Enumeration<JarEntry> e = jf.entries(); e.hasMoreElements(); ) {
				JarEntry je = e.nextElement();
				if (je.isDirectory() || je.getName().equals(JarFile.MANIFEST_NAME)) {
					continue;
				}
				try (InputStream is = jf.getInputStream(je)) {
					j.entries.put(je.getName(), is.readAllBytes());
				}
				String n = je.getName();
				if (n.endsWith(".class") && !n.startsWith("META-INF/")) {
					String cls = n.substring(0, n.length() - 6);
					classOwner.put(cls, j);
					packageOwner.putIfAbsent(packageOf(cls), j);
				}
			}
		}
		jars.add(j);
	}

	static String packageOf(String internalName) {
		int i = internalName.lastIndexOf('/');
		return i < 0 ? "" : internalName.substring(0, i);
	}

	/** The class a fragment merges into, or null when {@code cn} is a whole class. */
	static String fragmentTarget(ClassNode cn) {
		if (cn.invisibleAnnotations != null) {
			for (AnnotationNode a : cn.invisibleAnnotations) {
				if (a.desc.equals(INTO)) {
					return ((org.objectweb.asm.Type)a.values.get(1)).getInternalName();
				}
			}
		}
		// <prefix><pkg>/<Name> is a fragment; <prefix><Name> (no package) would be inject-api itself
		for (String prefix : new String[] {INJECT_PREFIX, GENERATED_PREFIX}) {
			if (cn.name.startsWith(prefix) && cn.name.indexOf('/', prefix.length()) >= 0) {
				return cn.name.substring(prefix.length());
			}
		}
		return null;
	}

	static String todoArea(List<AnnotationNode> anns) {
		if (anns != null) {
			for (AnnotationNode a : anns) {
				if (a.desc.equals(TODO)) {
					return (String)a.values.get(1);
				}
			}
		}
		return null;
	}

	ClassNode readInject(byte[] bytes) {
		Remapper toTarget = new Remapper() {
			@Override
			public String map(String internalName) {
				return injectTargets.getOrDefault(internalName, internalName);
			}
		};
		ClassNode inj = new ClassNode();
		new ClassReader(bytes).accept(new ClassRemapper(inj, toTarget), 0);
		return inj;
	}

	void replace(List<byte[]> classes) {
		Map<String, byte[]> byName = new TreeMap<>();
		for (byte[] b : classes) {
			byName.put(new ClassReader(b).getClassName(), b);
		}
		for (String name : byName.keySet()) {
			if (name.contains("$")) {
				continue;
			}
			JarImage owner = classOwner.get(name);
			if (owner == null) {
				throw new IllegalStateException("Replace target " + name + " does not exist in LWJGL 3; it belongs in compat's main source set");
			}
			// LWJGL 3's anonymous classes of the replaced class are only reachable from its old code
			for (String entry : new ArrayList<>(owner.entries.keySet())) {
				String cls = entry.substring(0, Math.max(0, entry.length() - 6));
				if (entry.matches(java.util.regex.Pattern.quote(name) + "\\$\\d+\\.class") && !byName.containsKey(cls)) {
					owner.entries.remove(entry);
					log.add(owner.out.getFileName() + ": - class " + cls);
				}
			}
		}
		for (Map.Entry<String, byte[]> e : byName.entrySet()) {
			String top = e.getKey().contains("$") ? e.getKey().substring(0, e.getKey().indexOf('$')) : e.getKey();
			JarImage owner = classOwner.get(top);
			owner.entries.put(e.getKey() + ".class", e.getValue());
			replaced.add(e.getKey());
			log.add(owner.out.getFileName() + ": replace class " + e.getKey());
		}
	}

	void inject(byte[] bytes, boolean generated) {
		String target = readInject(bytes).name;
		if (replaced.contains(target)) {
			throw new IllegalStateException(target + " is both replaced and injected into");
		}
		JarImage owner = classOwner.get(target);
		if (owner == null) {
			throw new IllegalStateException("Fragment target " + target + " exists neither in LWJGL 3 nor in compat");
		}
		if (target.contains("$")) {
			throw new IllegalStateException("Nested inject classes are not supported yet: " + target);
		}
		// the class itself and any multi-release variants of it
		for (String entry : new ArrayList<>(owner.entries.keySet())) {
			if (entry.equals(target + ".class") || (entry.startsWith(VERSIONS) && entry.endsWith("/" + target + ".class"))) {
				// a fresh copy per target: merge() moves and edits the inject's members
				owner.entries.put(entry, merge(owner.entries.get(entry), readInject(bytes), entry, generated));
			}
		}
	}

	byte[] merge(byte[] targetBytes, ClassNode inj, String entry, boolean generated) {
		ClassNode t = new ClassNode();
		new ClassReader(targetBytes).accept(t, 0);
		recordInstrumentation(t.name, inj);

		if (!inj.superName.equals("java/lang/Object") && !inj.superName.equals(t.superName)) {
			throw new IllegalStateException(entry + ": inject class extends " + inj.superName + " but target extends " + t.superName);
		}
		for (String itf : inj.interfaces) {
			if (!t.interfaces.contains(itf)) {
				t.interfaces.add(itf);
				log.add(entry + ": + implements " + itf);
			}
		}

		for (FieldNode f : inj.fields) {
			FieldNode existing = t.fields.stream().filter(x -> x.name.equals(f.name)).findFirst().orElse(null);
			boolean widenField = has(f.invisibleAnnotations, WIDEN);
			boolean hiddenField = has(f.invisibleAnnotations, HIDDEN);
			String todo = todoArea(f.invisibleAnnotations);
			String key = t.name + "." + f.name;
			f.invisibleAnnotations = strip(f.invisibleAnnotations);
			if (widenField) {
				if (existing == null || !existing.desc.equals(f.desc)) {
					throw new IllegalStateException(entry + ": @Widen field " + f.name + " " + f.desc + " not found in target");
				}
				existing.access = widen(existing.access, f.access);
				log.add(entry + ": widen field " + f.name);
				continue;
			}
			if (existing != null) {
				if (generated || !generatedMembers.contains(key)) {
					throw new IllegalStateException(entry + ": field " + f.name + " already exists in target");
				}
				t.fields.remove(existing);
				override(key, entry + ": override field " + f.name);
			}
			if (hiddenField) {
				f.access |= Opcodes.ACC_SYNTHETIC;
			}
			t.fields.add(f);
			track(key, generated, todo);
			log.add(entry + ": + field " + f.name + " " + f.desc);
		}

		List<MethodNode> declaredOnly = new ArrayList<>();
		for (MethodNode m : inj.methods) {
			MethodNode existing = find(t, m.name, m.desc);
			boolean widen = has(m.invisibleAnnotations, WIDEN);
			boolean wrap = has(m.invisibleAnnotations, WRAP);
			boolean hidden = has(m.invisibleAnnotations, HIDDEN);
			String todo = (m.access & Opcodes.ACC_BRIDGE) != 0 ? null : todoArea(m.invisibleAnnotations);
			String key = t.name + "." + m.name + m.desc;
			m.invisibleAnnotations = strip(m.invisibleAnnotations);

			if ((m.access & Opcodes.ACC_BRIDGE) != 0 && (inherits(t, m.name, m.desc) || existing != null)) {
				// javac's bridge for an inject class that overrides a generic superclass method (PointerBufferFragment's
				// PointerBuffer position(int) over CustomBuffer's SELF position(int)): merged, it would reroute LWJGL 3's
				// calls to the inherited method into the LWJGL 2 member. When the target has the bridge already (a @Wrap
				// of create(...)), the target's calls the wrapped method by name and keeps working.
				log.add(entry + ": skip bridge " + m.name + m.desc);
				continue;
			}
			if ((m.access & (Opcodes.ACC_ABSTRACT | Opcodes.ACC_NATIVE)) != 0) {
				// declared so that the inject class compiles (e.g. the original of a @Wrap method, native when static):
				// must exist in the target
				declaredOnly.add(m);
				continue;
			}
			if (wrap) {
				if (existing == null || generatedMembers.contains(key)) {
					throw new IllegalStateException(entry + ": @Wrap method " + m.name + m.desc + " not found in LWJGL 3's target");
				}
				if (find(t, m.name + WRAPPED_SUFFIX, m.desc) != null) {
					throw new IllegalStateException(entry + ": " + m.name + m.desc + " is wrapped twice");
				}
				existing.name = m.name + WRAPPED_SUFFIX;
				existing.access |= Opcodes.ACC_SYNTHETIC;
				// the wrapper takes the original's place, and its visibility to javac
				int visibility = Opcodes.ACC_PUBLIC | Opcodes.ACC_PROTECTED | Opcodes.ACC_PRIVATE;
				m.access = (m.access & ~(visibility | Opcodes.ACC_SYNTHETIC)) | (existing.access & visibility);
				t.methods.add(m);
				log.add(entry + ": wrap " + m.name + m.desc + " (original renamed " + existing.name + ")");
				continue;
			}
			if (widen) {
				if (existing == null) {
					throw new IllegalStateException(entry + ": @Widen method " + m.name + m.desc + " not found in target");
				}
				existing.access = widen(existing.access, m.access);
				log.add(entry + ": widen " + m.name + m.desc + " -> " + access(existing.access));
				continue;
			}
			if (m.name.equals("<init>")) {
				if (isTrivialConstructor(m, inj.superName)) {
					continue; // the inject class's own default constructor
				}
				if (!inj.superName.equals(t.superName)) {
					// its super(...) call would not target the target's superclass
					throw new IllegalStateException(entry + ": constructor " + m.desc + " needs an inject class that extends "
						+ t.superName + " (see @Into), or @Widen");
				}
			}
			if (m.name.equals("<clinit>")) {
				m.name = CLINIT_ALIAS;
				m.access = Opcodes.ACC_PRIVATE | Opcodes.ACC_STATIC | Opcodes.ACC_SYNTHETIC;
				callFromClinit(t, t.name, CLINIT_ALIAS);
				existing = find(t, m.name, m.desc);
			}
			if (existing != null) {
				if (generated || !generatedMembers.contains(key)) {
					throw new IllegalStateException(entry + ": " + m.name + m.desc + " already exists in target "
						+ "(use @Widen, or give the LWJGL 2 member a different descriptor)");
				}
				// keep the generated member's synthetic flag: whether javac may see it is a property of the API
				hidden |= (existing.access & Opcodes.ACC_SYNTHETIC) != 0;
				t.methods.remove(existing);
				override(key, entry + ": override " + m.name + m.desc);
			}
			if (hidden) {
				m.access |= Opcodes.ACC_SYNTHETIC;
			}
			t.methods.add(m);
			track(key, generated, todo);
			log.add(entry + ": + " + access(m.access) + " " + m.name + m.desc);
		}

		for (MethodNode m : declaredOnly) {
			MethodNode found = find(t, m.name, m.desc);
			if (found == null && !inherits(t, m.name, m.desc) && !declaredAbstract(t, m.name, m.desc)) {
				throw new IllegalStateException(entry + ": abstract " + m.name + m.desc + " is neither in the target nor merged");
			}
		}

		ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
		t.accept(cw);
		return cw.toByteArray();
	}

	void recordInstrumentation(String target, ClassNode inj) {
		if (inj.invisibleAnnotations != null) {
			for (AnnotationNode a : inj.invisibleAnnotations) {
				if (a.desc.equals(AROUND)) {
					String[] hooks = {(String)value(a, "enter"), (String)value(a, "exit")};
					String[] before = arounds.put(target, hooks);
					if (before != null && !Arrays.equals(before, hooks)) {
						throw new IllegalStateException(target + ": two different @Around");
					}
				}
			}
		}
	}

	static Object value(AnnotationNode a, String name) {
		for (int i = 0; i < a.values.size(); i += 2) {
			if (a.values.get(i).equals(name)) {
				return a.values.get(i + 1);
			}
		}
		throw new IllegalStateException(a.desc + " has no " + name);
	}

	/** @Around on each target, once all inject classes are merged into it. */
	void instrument() {
		for (Map.Entry<String, String[]> e : arounds.entrySet()) {
			String target = e.getKey();
			String[] hooks = e.getValue();
			JarImage owner = classOwner.get(target);
			String entry = target + ".class";
			ClassNode t = new ClassNode();
			new ClassReader(owner.entries.get(entry)).accept(t, 0);
			Set<String> skip = Set.of(hooks[0] + "()V", hooks[1] + "()V");
			int overridden = overrideInherited(t);
			int wrapped = 0;
			for (MethodNode m : t.methods) {
				if (!skip.contains(m.name + m.desc) && wrap(t, m, hooks)) {
					wrapped++;
				}
			}
			log.add(entry + ": around " + hooks[0] + "/" + hooks[1] + ": " + overridden + " inherited methods overridden, "
				+ wrapped + " methods wrapped");
			ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
			t.accept(cw);
			owner.entries.put(entry, cw.toByteArray());
		}
	}

	/** A synthetic override, calling super, of every inherited overridable instance method {@code t} does not declare. */
	int overrideInherited(ClassNode t) {
		int n = 0;
		Set<String> seen = new HashSet<>();
		t.methods.forEach(m -> seen.add(m.name + m.desc));
		for (String s = t.superName; s != null; ) {
			JarImage owner = classOwner.get(s);
			if (owner == null) {
				break;
			}
			ClassNode sc = new ClassNode();
			new ClassReader(owner.entries.get(s + ".class")).accept(sc, ClassReader.SKIP_CODE);
			for (MethodNode sm : sc.methods) {
				boolean overridable = (sm.access & (Opcodes.ACC_PUBLIC | Opcodes.ACC_PROTECTED)) != 0
					&& (sm.access & (Opcodes.ACC_STATIC | Opcodes.ACC_FINAL | Opcodes.ACC_PRIVATE | Opcodes.ACC_SYNTHETIC)) == 0
					&& !sm.name.startsWith("<");
				if (!seen.add(sm.name + sm.desc)) {
					continue;
				}
				if (!overridable) {
					if ((sm.access & Opcodes.ACC_FINAL) != 0 && (sm.access & Opcodes.ACC_STATIC) == 0 && !sm.name.startsWith("<")) {
						log.add(t.name + ": final " + s + "." + sm.name + sm.desc + " cannot be wrapped");
					}
					continue;
				}
				if ((sm.access & Opcodes.ACC_ABSTRACT) != 0) {
					continue; // t implements it, or t is abstract
				}
				MethodNode m = new MethodNode((sm.access & (Opcodes.ACC_PUBLIC | Opcodes.ACC_PROTECTED)) | Opcodes.ACC_SYNTHETIC,
					sm.name, sm.desc, null, sm.exceptions == null ? null : sm.exceptions.toArray(new String[0]));
				m.instructions.add(new VarInsnNode(Opcodes.ALOAD, 0));
				int slot = 1;
				for (org.objectweb.asm.Type a : org.objectweb.asm.Type.getArgumentTypes(sm.desc)) {
					m.instructions.add(new VarInsnNode(a.getOpcode(Opcodes.ILOAD), slot));
					slot += a.getSize();
				}
				m.instructions.add(new MethodInsnNode(Opcodes.INVOKESPECIAL, s, sm.name, sm.desc, false));
				m.instructions.add(new InsnNode(org.objectweb.asm.Type.getReturnType(sm.desc).getOpcode(Opcodes.IRETURN)));
				m.maxLocals = slot;
				t.methods.add(m);
				n++;
			}
			s = sc.superName;
		}
		return n;
	}

	/** enter at the start, exit before every return and on any exception. */
	static boolean wrap(ClassNode t, MethodNode m, String[] hooks) {
		if ((m.access & (Opcodes.ACC_STATIC | Opcodes.ACC_ABSTRACT | Opcodes.ACC_NATIVE | Opcodes.ACC_BRIDGE)) != 0
			|| m.name.startsWith("<")) {
			return false;
		}
		LabelNode start = new LabelNode();
		InsnList entry = new InsnList();
		entry.add(new VarInsnNode(Opcodes.ALOAD, 0));
		entry.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, t.name, hooks[0], "()V", false));
		entry.add(start);
		m.instructions.insert(entry);
		for (AbstractInsnNode i : m.instructions.toArray()) {
			if (i.getOpcode() >= Opcodes.IRETURN && i.getOpcode() <= Opcodes.RETURN) {
				InsnList exit = new InsnList();
				exit.add(new VarInsnNode(Opcodes.ALOAD, 0));
				exit.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, t.name, hooks[1], "()V", false));
				m.instructions.insertBefore(i, exit);
			}
		}
		LabelNode end = new LabelNode();
		LabelNode handler = new LabelNode();
		m.instructions.add(end);
		m.instructions.add(handler);
		// at the handler only this and the parameters are known: javac never stores another type into a parameter slot
		List<Object> locals = new ArrayList<>();
		locals.add(t.name);
		for (org.objectweb.asm.Type a : org.objectweb.asm.Type.getArgumentTypes(m.desc)) {
			locals.add(switch (a.getSort()) {
				case org.objectweb.asm.Type.BOOLEAN, org.objectweb.asm.Type.BYTE, org.objectweb.asm.Type.CHAR,
					org.objectweb.asm.Type.SHORT, org.objectweb.asm.Type.INT -> Opcodes.INTEGER;
				case org.objectweb.asm.Type.LONG -> Opcodes.LONG;
				case org.objectweb.asm.Type.FLOAT -> Opcodes.FLOAT;
				case org.objectweb.asm.Type.DOUBLE -> Opcodes.DOUBLE;
				default -> a.getInternalName();
			});
		}
		m.instructions.add(new FrameNode(Opcodes.F_FULL, locals.size(), locals.toArray(), 1, new Object[] {"java/lang/Throwable"}));
		m.instructions.add(new VarInsnNode(Opcodes.ALOAD, 0));
		m.instructions.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, t.name, hooks[1], "()V", false));
		m.instructions.add(new InsnNode(Opcodes.ATHROW));
		m.tryCatchBlocks.add(new TryCatchBlockNode(start, end, handler, null));
		return true;
	}

	void track(String key, boolean generated, String todo) {
		if (generated) {
			generatedMembers.add(key);
			if (todo != null) {
				todos.put(key, todo);
			}
		}
	}

	void override(String key, String message) {
		generatedMembers.remove(key);
		todos.remove(key);
		overrides++;
		log.add(message);
	}

	static void callFromClinit(ClassNode t, String owner, String alias) {
		MethodNode clinit = find(t, "<clinit>", "()V");
		if (clinit == null) {
			clinit = new MethodNode(Opcodes.ACC_STATIC, "<clinit>", "()V", null, null);
			clinit.instructions.add(new InsnNode(Opcodes.RETURN));
			t.methods.add(clinit);
		}
		clinit.instructions.insert(new MethodInsnNode(Opcodes.INVOKESTATIC, owner, alias, "()V", false));
	}

	static boolean isTrivialConstructor(MethodNode m, String superName) {
		if (!m.desc.equals("()V")) {
			return false;
		}
		List<Integer> ops = new ArrayList<>();
		for (AbstractInsnNode i : m.instructions) {
			if (i.getOpcode() >= 0) {
				ops.add(i.getOpcode());
			}
		}
		return ops.equals(Arrays.asList(Opcodes.ALOAD, Opcodes.INVOKESPECIAL, Opcodes.RETURN));
	}

	/** Whether a superclass of {@code t} (in the jars being patched) implements {@code name desc}. */
	boolean inherits(ClassNode t, String name, String desc) {
		for (String s = t.superName; s != null; ) {
			JarImage owner = classOwner.get(s);
			if (owner == null) {
				return false;
			}
			ClassNode sc = new ClassNode();
			new ClassReader(owner.entries.get(s + ".class")).accept(sc, ClassReader.SKIP_CODE);
			MethodNode m = find(sc, name, desc);
			if (m != null) {
				return (m.access & Opcodes.ACC_ABSTRACT) == 0;
			}
			s = sc.superName;
		}
		return false;
	}

	/** Whether a superclass of {@code t} declares {@code name desc} abstract (implemented by the target, or a subclass). */
	boolean declaredAbstract(ClassNode t, String name, String desc) {
		for (String s = t.superName; s != null; ) {
			JarImage owner = classOwner.get(s);
			if (owner == null) {
				return false;
			}
			ClassNode sc = new ClassNode();
			new ClassReader(owner.entries.get(s + ".class")).accept(sc, ClassReader.SKIP_CODE);
			if (find(sc, name, desc) != null) {
				return true;
			}
			s = sc.superName;
		}
		return false;
	}

	static MethodNode find(ClassNode c, String name, String desc) {
		return c.methods.stream().filter(m -> m.name.equals(name) && m.desc.equals(desc)).findFirst().orElse(null);
	}

	static boolean has(List<AnnotationNode> anns, String desc) {
		return anns != null && anns.stream().anyMatch(a -> a.desc.equals(desc));
	}

	static List<AnnotationNode> strip(List<AnnotationNode> anns) {
		if (anns == null) {
			return null;
		}
		List<AnnotationNode> kept = anns.stream().filter(a -> !a.desc.startsWith(ANNOTATION_PREFIX)).collect(Collectors.toList());
		return kept.isEmpty() ? null : kept;
	}

	static int rank(int access) {
		if ((access & Opcodes.ACC_PUBLIC) != 0) {
			return 3;
		}
		if ((access & Opcodes.ACC_PROTECTED) != 0) {
			return 2;
		}
		return (access & Opcodes.ACC_PRIVATE) != 0 ? 0 : 1;
	}

	static int widen(int existing, int wanted) {
		if (rank(wanted) <= rank(existing)) {
			return existing;
		}
		int vis = Opcodes.ACC_PUBLIC | Opcodes.ACC_PROTECTED | Opcodes.ACC_PRIVATE;
		return (existing & ~vis) | (wanted & vis);
	}

	static String access(int a) {
		return new String[] {"private", "package", "protected", "public"}[rank(a)]
			+ ((a & Opcodes.ACC_STATIC) != 0 ? " static" : "")
			+ ((a & Opcodes.ACC_SYNTHETIC) != 0 ? " synthetic" : "");
	}

	void add(byte[] bytes, JarImage extra, boolean generated) {
		ClassNode cn = new ClassNode();
		new ClassReader(bytes).accept(cn, 0);
		if (classOwner.containsKey(cn.name)) {
			throw new IllegalStateException(cn.name + " already exists; write members of LWJGL 3 classes as a fragment");
		}
		cn.invisibleAnnotations = strip(cn.invisibleAnnotations);
		for (FieldNode f : cn.fields) {
			track(cn.name + "." + f.name, generated, todoArea(f.invisibleAnnotations));
			f.invisibleAnnotations = strip(f.invisibleAnnotations);
		}
		for (MethodNode m : cn.methods) {
			// javac copies annotations onto bridge methods; count the real method only
			boolean bridge = (m.access & Opcodes.ACC_BRIDGE) != 0;
			track(cn.name + "." + m.name + m.desc, generated, bridge ? null : todoArea(m.invisibleAnnotations));
			m.invisibleAnnotations = strip(m.invisibleAnnotations);
		}
		ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
		cn.accept(cw);
		JarImage owner = packageOwner.getOrDefault(packageOf(cn.name), extra);
		owner.entries.put(cn.name + ".class", cw.toByteArray());
		classOwner.put(cn.name, owner);
		log.add(owner.out.getFileName() + ": + class " + cn.name);
	}

	static void write(JarImage j) throws IOException {
		Files.createDirectories(j.out.getParent());
		Manifest mf = j.manifest != null ? j.manifest : new Manifest();
		mf.getMainAttributes().putIfAbsent(Attributes.Name.MANIFEST_VERSION, "1.0");
		try (JarOutputStream jos = new JarOutputStream(Files.newOutputStream(j.out), mf)) {
			Set<String> dirs = new HashSet<>();
			for (Map.Entry<String, byte[]> e : j.entries.entrySet()) {
				String n = e.getKey();
				for (int i = n.indexOf('/'); i >= 0; i = n.indexOf('/', i + 1)) {
					String d = n.substring(0, i + 1);
					if (dirs.add(d)) {
						jos.putNextEntry(new JarEntry(d));
						jos.closeEntry();
					}
				}
				jos.putNextEntry(new JarEntry(n));
				jos.write(e.getValue());
				jos.closeEntry();
			}
		}
	}

}
