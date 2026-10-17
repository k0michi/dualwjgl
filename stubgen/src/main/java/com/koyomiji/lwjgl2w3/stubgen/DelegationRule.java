package com.koyomiji.lwjgl2w3.stubgen;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.VarInsnNode;

import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeKind;
import java.math.BigInteger;
import java.util.*;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The delegation rule: an LWJGL 2 method becomes a call to one of LWJGL 3's public methods (never a raw {@code n}
 * method) that makes the same native calls with the same arguments and returns the same thing.
 *
 * <p>Both sides are reduced to {@link NativeTrace}s. For each LWJGL 3 public method calling the same native functions,
 * every LWJGL 3 parameter is solved as an expression of LWJGL 2's parameters, from a fixed set of adapters:</p>
 * <ul>
 * <li>the value itself (with Java's widening), a constant, a PointerWrapper's pointer, a buffer's address or count;</li>
 * <li>a buffer of another element type, or of a count LWJGL 2 passed separately, viewed over the same memory;</li>
 * <li>null, for an absent buffer LWJGL 3 takes null-safely;</li>
 * <li>the type constant LWJGL 2 chose with its {@code unsigned} flag;</li>
 * <li>a stack temporary, for an output LWJGL 2 returned (its value is the return value);</li>
 * <li>a string encoded on the stack, where LWJGL 3 only takes the encoded bytes (ASCII, as LWJGL 2 encoded them);</li>
 * <li>a struct over the bytes LWJGL 2 took, a CL object's pointer in a stack temporary, a callback as its interface.</li>
 * </ul>
 * <p>LWJGL 2's templates add what the traces cannot show: for OpenCL, LWJGL 2's Java around the native call (@Code,
 * @PointerWrapper, @Constant), laid out as its generator did with the call delegated; everywhere, the parameters its C
 * transformed (@Indirect, @PointerArray), which are never delegated.</p>
 * <p>A candidate is taken when the LWJGL 3 trace, with the solution put in, equals LWJGL 2's; LWJGL 3 methods with
 * LWJGL 2's parameter types and the same trace take the arguments as they are. The candidate with the fewest adapters
 * wins, LWJGL 2's own class and its supertypes first.</p>
 *
 * <p>DEVIATION(checks): LWJGL 3's public methods check their arguments as LWJGL 3 does, not as LWJGL 2 did.</p>
 */
final class DelegationRule implements Rule {

	private static final Map<String, Integer> ELEMENT_SIZE = Map.of(
		"java.nio.ByteBuffer", 1, "java.nio.ShortBuffer", 2, "java.nio.CharBuffer", 2, "java.nio.IntBuffer", 4,
		"java.nio.FloatBuffer", 4, "java.nio.LongBuffer", 8, "java.nio.DoubleBuffer", 8, "org.lwjgl.PointerBuffer", 8);
	private static final Map<String, String> BUFFER_KIND = Map.of(
		"java.nio.ByteBuffer", "Byte", "java.nio.ShortBuffer", "Short", "java.nio.CharBuffer", "Char",
		"java.nio.IntBuffer", "Int", "java.nio.FloatBuffer", "Float", "java.nio.LongBuffer", "Long",
		"java.nio.DoubleBuffer", "Double", "org.lwjgl.PointerBuffer", "Pointer");
	private static final Pattern PARAM = Pattern.compile("^\\$(\\d+)\\$$");
	private static final Pattern ADDR = Pattern.compile("^addr\\(\\$(\\d+)\\$\\)$");
	private static final Pattern TMP = Pattern.compile("^addr\\(TMP(?:,(\\d+))?\\)$");
	private static final Pattern VAL = Pattern.compile("^addr\\(VAL\\((.*)\\)\\)$");
	private static final Pattern STR = Pattern.compile("^str\\(\\$(\\d+)\\$\\)$");
	private static final Pattern POINTER = Pattern.compile("^\\$(\\d+)\\$\\.getPointer\\(\\)$");
	/** a buffer's address some elements past its position: addr($3$,($3$.position()+1)) */
	private static final Pattern OFFSET = Pattern.compile("^addr\\(\\$(\\d+)\\$,\\(\\$\\1\\$\\.position\\(\\)\\+(\\d+)\\)\\)$");
	private static final Pattern PHI2 = Pattern.compile("^phi\\((-?\\d+)\\|(-?\\d+)\\)$");
	private static final Pattern COUNT = Pattern.compile("^(rem|len|strlen)\\(\\$(\\d+)\\$\\)$");
	private static final Pattern ARG = Pattern.compile(
		"\\$(\\d+)\\$|(addr|rem|len)\\(\\$(\\d+)\\$\\)|(-?\\d+)|\\((rem|len)\\(\\$(\\d+)\\$\\)(<<|>>|/|\\*)(\\d+)\\)");
	private static final String MU = "org.lwjgl.system.MemoryUtil.";

	private final Lwjgl2Api lwjgl2;
	private final Lwjgl3Api lwjgl3;
	private final NativeTrace trace2;
	private final NativeTrace trace3;
	/** LWJGL 2's generator templates, for the Java code its CL bindings carry (@Code, @PointerWrapper, @Constant) */
	private final Templates templates;
	/** package -> native function -> LWJGL 3 public methods calling it, in Lwjgl3Api.owners order */
	private final Map<String, Map<String, List<Candidate>>> index = new HashMap<>();
	private String lastReason;

	DelegationRule(Lwjgl2Api lwjgl2, Lwjgl3Api lwjgl3, NativeTrace trace2, NativeTrace trace3, Templates templates) {
		this.lwjgl2 = lwjgl2;
		this.lwjgl3 = lwjgl3;
		this.trace2 = trace2;
		this.trace3 = trace3;
		this.templates = templates;
	}

	@Override
	public String name() {
		return "R";
	}

	/** An LWJGL 3 public method, its trace, and that trace with temporaries kept. */
	private record Candidate(String owner, MethodNode method, NativeTrace.Summary summary, List<String> calls, String ret) {
	}

	@Override
	public String apply(Target t) {
		ExecutableElement m = t.method();
		String owner2 = lwjgl2.internalName((TypeElement)m.getEnclosingElement());
		NativeTrace.Summary s2 = trace2.summarize(owner2, m.getSimpleName().toString(), t.desc(), 0);
		boolean debug = m.getSimpleName().toString().equals(System.getenv("LWJGL2W3_DEBUG"));
		if (s2.unresolved || s2.natives.isEmpty()) {
			if (debug) {
				System.err.println("[R] " + owner2 + "." + m.getSimpleName() + t.desc() + ": trace " + (s2.unresolved ? "unresolved" : "empty"));
			}
			return null;
		}
		Templates.Method declared = template(t.cls(), m, false);
		if (declared != null && declared.params().stream().anyMatch(p -> p.has("Indirect") || p.has("PointerArray"))) {
			// LWJGL 2's C made the function's argument from the one its native took (&string, a pointer array from
			// packed strings), which the trace cannot see: equal native arguments would not be the same call
			if (debug) {
				System.err.println("[R] " + owner2 + "." + m.getSimpleName() + t.desc() + ": @Indirect or @PointerArray");
			}
			return null;
		}
		String effect = javaSideEffect(trace2.find(owner2, m.getSimpleName().toString(), t.desc()));
		Templates.Method template = null;
		if (effect != null) {
			// LWJGL 2's own Java around the native call, from its template: kept, with the call delegated
			template = template(t.cls(), m, true);
			if (template == null) {
				if (m.getSimpleName().toString().equals(System.getenv("LWJGL2W3_DEBUG"))) {
					System.err.println("[R] " + owner2 + "." + m.getSimpleName() + t.desc() + ": LWJGL 2 also calls " + effect);
				}
				return null;
			}
		}
		List<String> owners = lwjgl3.owners(t.cls());
		List<String> own = lwjgl3.selfAndSupers(t.cls());
		Map<String, List<Candidate>> byFunction = index(t.cls());
		List<String> natives2 = new ArrayList<>(s2.natives);
		if (template != null) {
			// only the binding's own call: the template's Java makes others (CallbackUtil's natives, releaseObjects)
			String function = template.function();
			natives2.removeIf(n -> !fn(n).equals(function));
			if (natives2.size() != 1) {
				if (debug) {
					System.err.println("[R] " + owner2 + "." + m.getSimpleName() + t.desc() + ": " + function + " in " + s2.natives);
				}
				return null;
			}
			natives2.set(0, reassigned(m, template, natives2.get(0)));
		}
		// the template's @Constant arguments (APIUtil.getPointer(event)), also where its Java is only that
		Templates.Method constants = template != null ? template : template(t.cls(), m, true);
		if (constants != null && constants.params().size() != args(natives2.get(0)).size()) {
			constants = null;
		}
		String ret2 = singleValue(natives2, s2.ret(), byFunction);
		List<String> calls2 = raw(natives2);
		if (debug) {
			System.err.println("[R] " + owner2 + "." + m.getSimpleName() + t.desc() + "\n  2: " + calls2 + " => " + ret2);
		}
		String best = null;
		int bestCost = Integer.MAX_VALUE;
		for (Candidate c : byFunction.getOrDefault(fn(calls2.get(0)), List.of())) {
			if (c.calls.size() != calls2.size() || !owners.contains(c.owner)) {
				continue;
			}
			lastReason = "different shape";
			Solution sol = template != null ? null : sameShape(m, t, natives2, ret2, c);
			if (sol == null) {
				sol = solve(m, calls2, ret2, c, template, constants);
			}
			if (debug) {
				System.err.println("  3: " + c.owner + "." + c.method.name + c.method.desc + " " + c.calls + " => " + c.ret
					+ (sol == null ? "  -- " + lastReason : "  OK " + sol.adapters));
			}
			if (sol == null) {
				continue;
			}
			boolean inherited = own.contains(c.owner);
			int cost = sol.adapters * 4 + (inherited ? 0 : 2) + (c.method.name.equals(m.getSimpleName().toString()) ? 0 : 1);
			if (cost < bestCost) {
				bestCost = cost;
				best = sol.render(t, inherited ? t.cls() : c.owner, c.method.name);
			}
		}
		return best;
	}

	/**
	 * What LWJGL 2's method calls besides its checks, temporaries and the native call, or null: NativeTrace only compares
	 * native calls, so a method that also updates LWJGL 2's object model (CLContext.release, registerCLEvent, new
	 * CLKernel, CallbackUtil) cannot be a plain delegation.
	 */
	private String javaSideEffect(MethodNode m) {
		if (m == null) {
			return null;
		}
		for (AbstractInsnNode insn = m.instructions.getFirst(); insn != null; insn = insn.getNext()) {
			if (insn instanceof org.objectweb.asm.tree.TypeInsnNode ti && ti.getOpcode() == Opcodes.NEW && ti.desc.startsWith("org/lwjgl/opencl/")) {
				return "new " + ti.desc;
			}
			if (!(insn instanceof MethodInsnNode mi) || !mi.owner.startsWith("org/lwjgl/")) {
				continue;
			}
			MethodNode target = trace2.find(mi.owner, mi.name, mi.desc);
			if (target != null && (target.access & Opcodes.ACC_NATIVE) != 0 || pure(mi)) {
				continue;
			}
			return mi.owner + "." + mi.name;
		}
		return null;
	}

	private static final Set<String> PURE_OWNERS = Set.of("org/lwjgl/BufferChecks", "org/lwjgl/MemoryUtil", "org/lwjgl/LWJGLUtil",
		"org/lwjgl/PointerBuffer", "org/lwjgl/opengl/GLChecks", "org/lwjgl/opengl/GLContext", "org/lwjgl/opengl/StateTracker",
		"org/lwjgl/opencl/CLChecks", "org/lwjgl/opengl/Util", "org/lwjgl/openal/Util", "org/lwjgl/opencl/Util");

	/** Checks, address and string helpers, temporaries, and reading a PointerWrapper's pointer. */
	private static boolean pure(MethodInsnNode mi) {
		if (PURE_OWNERS.contains(mi.owner) || mi.name.equals("getPointer") || mi.name.equals("<init>") && mi.owner.equals("org/lwjgl/opengl/GLSync")) {
			return true;
		}
		if (mi.owner.endsWith("/APIUtil")) {
			return mi.name.startsWith("get") && !mi.name.equals("getCLPlatform") || mi.name.equals("isDevicesParam");
		}
		// a function of the same class or another binding class calling on (KHRDebug.glDebugMessageCallback -> GL43)
		return mi.getOpcode() == Opcodes.INVOKESTATIC && (mi.owner.startsWith("org/lwjgl/opengl/") || mi.owner.startsWith("org/lwjgl/openal/"))
			&& (mi.name.startsWith("gl") || mi.name.startsWith("al"));
	}

	// ---- index of LWJGL 3 public methods by the native functions they call

	private Map<String, List<Candidate>> index(String cls) {
		String pkg = cls.substring(0, cls.lastIndexOf('/') + 1);
		return index.computeIfAbsent(pkg, p -> {
			Map<String, List<Candidate>> out = new HashMap<>();
			for (String owner : lwjgl3.owners(cls)) {
				ClassNode cn = lwjgl3.get(owner);
				if (cn == null) {
					continue;
				}
				Set<String> names = new HashSet<>();
				cn.methods.forEach(mn -> names.add(mn.name));
				for (MethodNode mn : cn.methods) {
					if (!Lwjgl3Api.isPublicStatic(mn) || (mn.access & (Opcodes.ACC_SYNTHETIC | Opcodes.ACC_BRIDGE)) != 0
						|| rawEntry(mn, names) || mn.name.startsWith("<")) {
						continue;
					}
					NativeTrace.Summary s = trace3.summarize(owner, mn.name, mn.desc, 0);
					if (mn.name.equals(System.getenv("LWJGL2W3_DEBUG"))) {
						System.err.println("[index] " + owner + "." + mn.name + mn.desc + " " + NativeTrace.fmt(s));
					}
					if (s.unresolved || s.natives.isEmpty()) {
						continue;
					}
					Candidate c = new Candidate(owner, mn, s, raw(s.natives), s.ret());
					out.computeIfAbsent(fn(c.calls.get(0)), k -> new ArrayList<>()).add(c);
				}
			}
			return out;
		});
	}

	/** LWJGL 3's raw entry points: n + the name of another method of the class (nglFogfv next to glFogfv). */
	static boolean rawEntry(MethodNode mn, Set<String> names) {
		return mn.name.length() > 1 && mn.name.charAt(0) == 'n' && names.contains(mn.name.substring(1));
	}

	private static List<String> raw(List<String> natives) {
		List<String> out = new ArrayList<>();
		for (String n : natives) {
			out.add(n.replace("TMP.position()", "0"));
		}
		Collections.sort(out);
		return out;
	}

	/**
	 * A buffer parameter the template's javaBeforeNative replaces when null (num_devices = APIUtil.getBufferInt()): the
	 * template's Java passes the variable, whichever buffer it holds, so its trace's branches are the parameter's.
	 */
	private static String reassigned(ExecutableElement m, Templates.Method template, String call) {
		Templates.Ann code = template.ann("Code");
		String before = code == null ? "" : code.get("javaBeforeNative", "");
		List<String> as = args(call);
		boolean changed = false;
		for (int i = 0; i < m.getParameters().size(); i++) {
			String name = m.getParameters().get(i).getSimpleName().toString();
			if (!Pattern.compile("(?<![.\\w])" + name + "\\s*=(?!=)").matcher(before).find()) {
				continue;
			}
			for (int j = 0; j < as.size(); j++) {
				if (as.get(j).contains("$" + i + "$") && as.get(j).contains("TMP")) {
					as.set(j, "addr($" + i + "$)");
					changed = true;
				}
			}
		}
		return changed ? fn(call) + "(" + String.join(",", as) + ")" : call;
	}

	private static String fn(String call) {
		return call.substring(0, call.indexOf('('));
	}

	private static List<String> args(String call) {
		return splitArgs(call.substring(call.indexOf('(') + 1, call.length() - 1));
	}

	/** Top-level comma-separated arguments. */
	static List<String> splitArgs(String s) {
		List<String> out = new ArrayList<>();
		int depth = 0;
		StringBuilder cur = new StringBuilder();
		for (char ch : s.toCharArray()) {
			if (ch == '(' || ch == '[') {
				depth++;
			} else if (ch == ')' || ch == ']') {
				depth--;
			}
			if (ch == ',' && depth == 0) {
				out.add(cur.toString());
				cur.setLength(0);
			} else {
				cur.append(ch);
			}
		}
		if (cur.length() > 0) {
			out.add(cur.toString());
		}
		return out;
	}

	// ---- the solution: how each LWJGL 3 parameter is computed

	private enum Kind {VALUE, BUFFER, NULL, TEMP, INPUT, STRING, POINTER}

	private final class Solution {
		final ExecutableElement m2;
		final Type[] params3;
		final String[] exprs;
		final Kind[] kinds;
		/** BUFFER: the LWJGL 2 buffer parameter; TEMP: LWJGL 2's temporary slot; STRING and VALUE strings: the parameter */
		final int[] from;
		/** VALUE: the LWJGL 2 trace expression; BUFFER: an explicit element count (Java source), or null */
		final String[] source;
		/** BUFFER with an explicit count: that count as an LWJGL 2 trace expression */
		final String[] countExpr;
		/** BUFFER: elements past the LWJGL 2 buffer's position */
		final int[] offset;
		/** TEMP: its element count */
		final int[] tempCount;
		/** STRING: whether the encoded string is null-terminated */
		final boolean[] terminated;
		/** the element count LWJGL 3 checks a buffer parameter for (Checks.check(buffer, n)), or 0 */
		int[] minimum = new int[0];
		int adapters;
		/** the return statement, if not the call itself (temporaries, PointerWrapper results) */
		String returns;
		/** template mode: the template, and its @Constant expressions by native argument */
		Templates.Method template;
		final Map<Integer, String> constants = new HashMap<>();

		Solution(ExecutableElement m2, Type[] params3) {
			this.m2 = m2;
			this.params3 = params3;
			int n = params3.length;
			exprs = new String[n];
			kinds = new Kind[n];
			from = new int[n];
			source = new String[n];
			countExpr = new String[n];
			offset = new int[n];
			tempCount = new int[n];
			Arrays.fill(tempCount, 1);
			terminated = new boolean[n];
			Arrays.fill(from, -1);
			Arrays.fill(terminated, true);
		}

		boolean set(int j, Kind kind, String expr, int from, String source, int adapters) {
			if (kinds[j] != null) {
				return kinds[j] == kind && Objects.equals(exprs[j], expr) && this.from[j] == from;
			}
			kinds[j] = kind;
			exprs[j] = expr;
			this.from[j] = from;
			this.source[j] = source;
			this.adapters += adapters;
			return true;
		}

		String name2(int i) {
			return m2.getParameters().get(i).getSimpleName().toString();
		}

		/** Java source for parameter j. */
		String arg(int j) {
			switch (kinds[j]) {
				case BUFFER -> {
					String p = name2(from[j]);
					String type3 = params3[j].getClassName();
					String type2 = lwjgl2.types.erasure(m2.getParameters().get(from[j]).asType()).toString();
					if (source[j] == null && offset[j] == 0 && type3.equals(type2)) {
						return p;
					}
					String count = source[j] != null ? source[j]
						: scale("org.lwjgl.system.Checks.remainingSafe(" + p + ")", ELEMENT_SIZE.get(type2), ELEMENT_SIZE.get(type3));
					if (offset[j] != 0) {
						count = "(" + count + " - " + offset[j] + ")";
					}
					String address = MU + "memAddressSafe(" + p + ")" + (offset[j] == 0 ? "" : " + " + offset[j] * ELEMENT_SIZE.get(type2));
					return MU + "mem" + BUFFER_KIND.get(type3) + "BufferSafe(" + address + ", " + count + ")";
				}
				case TEMP -> {
					return "__t" + j;
				}
				case INPUT -> {
					return "__v" + j;
				}
				case STRING -> {
					return "__s" + j;
				}
				case POINTER -> {
					return "__p" + j;
				}
				case NULL -> {
					return "(" + params3[j].getClassName() + ")null"; // the overload, not another taking an object there
				}
				default -> {
					return exprs[j];
				}
			}
		}

		/** LWJGL 2's generator's method body (JavaMethodsGenerator), with the delegated call in place of the native one. */
		String templateBody(String call) {
			Templates.Ann code = template.ann("Code");
			Templates.Ann wrapper = template.ann("PointerWrapper");
			boolean tryBlock = code != null && code.flag("tryBlock", false);
			TypeKind kind = m2.getReturnType().getKind();
			boolean result = kind != TypeKind.VOID;
			String type = m2.getReturnType().toString();
			String expr = call;
			if (wrapper != null && result) {
				String factory = wrapper.get("factory", "");
				String params = wrapper.get("params", "");
				expr = (factory.isEmpty() ? "new " + type : factory) + "(" + call + (params.isEmpty() ? "" : ", " + params) + ")";
			}
			StringBuilder b = new StringBuilder();
			snippet(b, code, "value");
			StringBuilder before = new StringBuilder();
			snippet(before, code, "javaBeforeNative");
			// an else to the generator's null check of the parameter it assigns, which LWJGL 3's checks replace
			Matcher orElse = Pattern.compile("^else\n(\\w+)\\s*=").matcher(before);
			if (orElse.find()) {
				before.replace(0, 5, "if ( " + orElse.group(1) + " == null )\n\t");
			}
			b.append(before);
			String inner = tryBlock ? "\t" : "";
			if (result) {
				String zero = kind.isPrimitive() ? (kind == TypeKind.BOOLEAN ? "false" : "0") : "null";
				if (tryBlock) {
					b.append(type).append(" __result = ").append(zero).append(";\ntry {\n\t__result = ").append(expr).append(";\n");
				} else {
					b.append(type).append(" __result = ").append(expr).append(";\n");
				}
			} else {
				b.append(tryBlock ? "try {\n\t" : "").append(expr).append(";\n");
			}
			StringBuilder after = new StringBuilder();
			snippet(after, code, "javaAfterNative");
			for (String line : after.toString().split("\n")) {
				if (!line.isEmpty()) {
					b.append(inner).append(line).append("\n");
				}
			}
			if (result) {
				b.append(inner).append("return __result;\n");
			}
			if (tryBlock) {
				b.append("} finally {\n");
				StringBuilder fin = new StringBuilder();
				snippet(fin, code, "javaFinally");
				for (String line : fin.toString().split("\n")) {
					if (!line.isEmpty()) {
						b.append("\t").append(line).append("\n");
					}
				}
				b.append("}\n");
			}
			return b.toString().stripTrailing();
		}

		/** One of @Code's strings, a line per line without its indentation, its class's own constants qualified. */
		void snippet(StringBuilder b, Templates.Ann code, String key) {
			String text = code == null ? "" : code.get(key, "");
			String cls = template.owner().className();
			for (String line : text.replace("\\n", "\n").replace("\\t", "\t").split("\n")) {
				line = line.strip();
				if (!line.isEmpty()) {
					b.append(line.replaceAll("(?<![.\\w])(CL_[A-Z0-9_]+)\\b", cls + ".$1")).append("\n");
				}
			}
		}

		String render(Target t, String owner, String name) {
			List<String> as = new ArrayList<>();
			for (int j = 0; j < exprs.length; j++) {
				as.add(arg(j));
			}
			String call = owner.replace('/', '.').replace('$', '.') + "." + name + "(" + String.join(", ", as) + ")";
			boolean stack = false;
			StringBuilder decls = new StringBuilder();
			for (int j = 0; j < exprs.length; j++) {
				if (kinds[j] == Kind.TEMP) {
					stack = true;
					String kind = BUFFER_KIND.get(params3[j].getClassName());
					decls.append("\t").append(params3[j].getClassName()).append(" __t").append(j).append(" = __stack.")
						.append(kind.equals("Byte") ? "malloc" : "malloc" + kind).append("(").append(tempCount[j]).append(");\n");
				} else if (kinds[j] == Kind.INPUT) {
					stack = true;
					int n = Math.max(1, minimum[j]);
					decls.append("\tjava.nio.IntBuffer __v").append(j).append(" = ")
						.append(n == 1 ? "__stack.ints(" + exprs[j] + ")" : "__stack.callocInt(" + n + ").put(0, " + exprs[j] + ")").append(";\n");
				} else if (kinds[j] == Kind.POINTER) {
					stack = true;
					decls.append("\torg.lwjgl.PointerBuffer __p").append(j).append(" = __stack.pointers(").append(exprs[j]).append(");\n");
				} else if (kinds[j] == Kind.STRING) {
					stack = true;
					decls.append("\tjava.nio.ByteBuffer __s").append(j).append(" = __stack.ASCII(").append(name2(from[j]))
						.append(", ").append(terminated[j]).append(");\n");
				}
			}
			String body;
			if (template != null) {
				body = templateBody(call);
			} else if (returns == null) {
				body = t.call(owner, name, String.join(", ", as));
			} else if (returns.contains("$CALL$")) {
				body = "return " + returns.replace("$CALL$", call) + ";";
			} else {
				body = call + ";\nreturn " + returns + ";";
			}
			if (!stack) {
				return body;
			}
			StringBuilder sb = new StringBuilder("try (org.lwjgl.system.MemoryStack __stack = org.lwjgl.system.MemoryStack.stackPush()) {\n");
			sb.append(decls);
			for (String line : body.split("\n")) {
				sb.append("\t").append(line).append("\n");
			}
			return sb.append("}").toString();
		}
	}

	private static String scale(String elements, int from, int to) {
		if (from == to) {
			return elements;
		}
		return from > to ? "(" + elements + " << " + log2(from / to) + ")" : "(" + elements + " >> " + log2(to / from) + ")";
	}

	private static int log2(int n) {
		return Integer.numberOfTrailingZeros(n);
	}

	private Solution fail(String why) {
		lastReason = why;
		return null;
	}

	/**
	 * LWJGL 2's natives for one value (OpenAL's nalGenSources2(1), nalDeleteEffects2(1, effect)) made the temporary in
	 * C: written here as the call with the temporary they stand for, as LWJGL 3 makes it.
	 */
	private static String singleValue(List<String> natives, String ret, Map<String, List<Candidate>> byFunction) {
		if (natives.size() != 1) {
			return ret;
		}
		String call = natives.get(0);
		String f = fn(call);
		if (!f.endsWith("2") || byFunction.containsKey(f) || !byFunction.containsKey(f.substring(0, f.length() - 1))) {
			return ret;
		}
		List<String> as = args(call);
		String base = f.substring(0, f.length() - 1);
		if (as.size() == 1 && ret.equals("R:" + call)) {
			natives.set(0, base + "(" + as.get(0) + ",addr(TMP))");
			return "TMP.get(0)";
		}
		if (as.size() == 2 && ret.isEmpty()) {
			natives.set(0, base + "(" + as.get(0) + ",addr(VAL(" + as.get(1) + ")))");
		}
		return ret;
	}

	/** An LWJGL 3 method with LWJGL 2's parameter types and the same calls takes the arguments as they are. */
	private Solution sameShape(ExecutableElement m2, Target t, List<String> natives2, String ret2, Candidate c) {
		String desc3 = c.method.desc;
		if (!desc3.substring(0, desc3.indexOf(')')).equals(t.desc().substring(0, t.desc().indexOf(')')))) {
			return null;
		}
		boolean returns2 = m2.getReturnType().getKind() != TypeKind.VOID;
		if (returns2 && !Type.getReturnType(desc3).getDescriptor().equals(lwjgl2.desc(m2.getReturnType()))) {
			return null;
		}
		if (!NativeTrace.norm(natives2).equals(NativeTrace.norm(c.summary))
			|| returns2 && !NativeTrace.normRet(ret2, natives2).equals(NativeTrace.normRet(c.summary))) {
			return null;
		}
		Type[] params3 = Type.getArgumentTypes(desc3);
		Solution sol = new Solution(m2, params3);
		for (int j = 0; j < params3.length; j++) {
			sol.set(j, Kind.VALUE, sol.name2(j), -1, "$" + j + "$", 0);
		}
		return sol;
	}

	private Solution solve(ExecutableElement m2, List<String> calls2, String ret2, Candidate c, Templates.Method template,
		Templates.Method constants) {
		Type[] params3 = Type.getArgumentTypes(c.method.desc);
		Type ret3t = Type.getReturnType(c.method.desc);
		boolean returns2 = m2.getReturnType().getKind() != TypeKind.VOID;
		Solution sol = new Solution(m2, params3);
		sol.template = template;
		if (constants != null && fn(calls2.get(0)).equals(constants.function())) {
			List<Templates.Param> ps = constants.params();
			if (ps.size() == args(calls2.get(0)).size()) {
				for (int k = 0; k < ps.size(); k++) {
					Templates.Ann constant = ps.get(k).ann("Constant");
					if (constant != null) {
						sol.constants.put(k, constant.value().replaceAll("(?<![.\\w])MemoryUtil\\.", "org.lwjgl.MemoryUtil."));
					}
				}
			}
		}
		// Lwjgl3Api reads classes without code: the code is NativeTrace's
		MethodNode code = trace3.find(c.owner, c.method.name, c.method.desc);
		Set<Integer> nullable = code == null ? Set.of() : nullableBuffers(c.owner, code, 0);
		sol.minimum = code == null ? new int[params3.length] : minimumCounts(c.owner, code, 0);
		List<String[]> deferred = new ArrayList<>();
		for (int k = 0; k < calls2.size(); k++) {
			String a2call = calls2.get(k);
			String a3call = c.calls.get(k);
			if (!fn(a2call).equals(fn(a3call))) {
				return fail("calls differ");
			}
			List<String> as = args(a2call);
			List<String> bs = args(a3call);
			if (as.size() != bs.size()) {
				return fail("argument counts differ");
			}
			for (int i = 0; i < as.size(); i++) {
				Boolean r = match(sol, as.get(i), bs.get(i), nullable, i);
				if (r == null) {
					return fail("conflict at " + as.get(i) + " / " + bs.get(i));
				}
				if (!r) {
					deferred.add(new String[] {as.get(i), bs.get(i)});
				}
			}
		}
		// a boolean LWJGL 3 parameter passed as 0 or 1, which loses which parameter it is: the only one left unset
		for (Iterator<String[]> it = deferred.iterator(); it.hasNext(); ) {
			String[] d = it.next();
			if (d[1].equals("phi(0|1)")) {
				int j = -1;
				for (int q = 0; q < params3.length; q++) {
					if (sol.kinds[q] == null && params3[q].getSort() == Type.BOOLEAN) {
						j = j == -1 ? q : -2;
					}
				}
				String v = j >= 0 ? renderValue(sol, d[0], Type.INT_TYPE) : null;
				if (v != null) {
					sol.set(j, Kind.VALUE, "(" + v + " != 0)", -1, null, 1);
					it.remove();
				}
			}
		}
		for (String[] d : deferred) {
			if (!sameValue(sol, d[0], d[1]) && !explicitCount(sol, d[0], d[1])) {
				return fail("value differs: " + d[0] + " / " + d[1]);
			}
		}
		for (int j = 0; j < params3.length; j++) {
			if (sol.kinds[j] == null) {
				return fail("parameter " + j + " undetermined");
			}
		}
		for (String[] d : deferred) {
			if (!sameValue(sol, d[0], d[1])) {
				return fail("value differs after counts: " + d[0] + " / " + d[1]);
			}
		}
		if (template != null) {
			// the template says what is returned: the native call's value, wrapped or not
			// (LWJGL 3's own branches, e.g. on a boolean it passes as 0 or 1, may leave several forms of the same call)
			boolean sameCall = c.calls.size() == 1 && (c.ret.equals("R:" + c.calls.get(0))
				|| c.ret.startsWith("phi(R:" + fn(c.calls.get(0)) + "("));
			if (returns2 && !(sameCall && (template.has("PointerWrapper")
				? ret3t.getSort() == Type.LONG : ret3t.getDescriptor().equals(lwjgl2.desc(m2.getReturnType()))))) {
				return fail("return differs from the template's");
			}
		} else if (returns2 && !returns(sol, ret2, c, calls2, ret3t)) {
			return fail("return differs: " + ret2 + " / " + c.ret);
		}
		// temporaries are only taken for LWJGL 2's outputs: what an input temporary held is not traced, so a method
		// using them must return from one (the others it passed are then outputs it dropped, glGetActiveUniformSize)
		boolean fromTemp = sol.returns != null && sol.returns.startsWith("__t") || ret2.equals("string") && c.ret.equals("string");
		for (int j = 0; j < params3.length; j++) {
			if (sol.kinds[j] == Kind.TEMP && !fromTemp) {
				return fail("temporary " + j + " without a return from temporaries");
			}
		}
		return sol;
	}

	/** Sets the LWJGL 3 parameter argument {@code b} is; true if set, false to compare the pair later, null on conflict. */
	private Boolean match(Solution sol, String a, String b, Set<Integer> nullable, int k) {
		Matcher pb = PARAM.matcher(b);
		if (pb.matches()) {
			int j = Integer.parseInt(pb.group(1));
			String e = renderValue(sol, a, sol.params3[j]);
			if (e == null && sol.constants.containsKey(k)) {
				// the template's @Constant: a local its Java made (user_data), passed as it is
				return sol.set(j, Kind.VALUE, sol.constants.get(k), -1, null, 0) ? true : null;
			}
			if (e == null) {
				return false;
			}
			return sol.set(j, Kind.VALUE, e, -1, a, e.equals(paramName(sol, a)) ? 0 : 1) ? true : null;
		}
		Matcher sb3 = STRUCT.matcher(b);
		if (sb3.matches()) {
			// a struct LWJGL 2 took as its bytes (cl_image_format as a ByteBuffer): LWJGL 3's struct at the same address
			int j = Integer.parseInt(sb3.group(1));
			Matcher aa = ADDR.matcher(a);
			if (!lwjgl3.isStruct(sol.params3[j].getInternalName())) {
				// or a callback LWJGL 3 takes as its interface and passes as its address
				Integer i = callback(sol, a, sol.params3[j]);
				return i == null ? false : sol.set(j, Kind.VALUE, sol.name2(i), i, a, 0) ? true : null;
			}
			if (!aa.matches()) {
				return false;
			}
			int i = Integer.parseInt(aa.group(1));
			if (!lwjgl2.types.erasure(sol.m2.getParameters().get(i).asType()).toString().equals("java.nio.ByteBuffer")) {
				return false;
			}
			String e = sol.params3[j].getClassName() + ".create(" + MU + "memAddress(" + sol.name2(i) + "))";
			return sol.set(j, Kind.VALUE, e, i, a, 1) ? true : null;
		}
		Matcher ab = ADDR.matcher(b);
		if (ab.matches()) {
			int j = Integer.parseInt(ab.group(1));
			String type3 = sol.params3[j].getClassName();
			if (!ELEMENT_SIZE.containsKey(type3)) {
				// a callback LWJGL 3 takes as its interface, which compat's callback classes implement
				Integer i = callback(sol, a, sol.params3[j]);
				return i == null ? false : sol.set(j, Kind.VALUE, sol.name2(i), i, a, 0) ? true : null;
			}
			if (a.equals("0") && nullable.contains(j)) {
				return sol.set(j, Kind.NULL, "null", -1, null, 1) ? true : null;
			}
			Matcher ac = OBJECT_POINTER.matcher(sol.constants.getOrDefault(k, ""));
			if (ac.matches() && type3.equals("org.lwjgl.PointerBuffer")) {
				// the template's APIUtil.getPointer(event): one CL object's pointer in a temporary, here on the stack
				String p = ac.group(2);
				String v = ac.group(1) == null ? p + ".getPointer()" : "(" + p + " == null ? 0L : " + p + ".getPointer())";
				return sol.set(j, Kind.POINTER, v, -1, null, 1) ? true : null;
			}
			Matcher av = VAL.matcher(a);
			if (av.matches()) {
				// LWJGL 2 passed one value through a temporary (glDeleteTextures(int)): so does this, on the stack
				String v = renderValue(sol, av.group(1), Type.INT_TYPE);
				return v != null && type3.equals("java.nio.IntBuffer") && sol.set(j, Kind.INPUT, v, -1, null, 1) ? true : null;
			}
			Matcher at = TMP.matcher(a);
			if (at.matches()) {
				int slot = at.group(1) == null ? 0 : Integer.parseInt(at.group(1));
				return sol.set(j, Kind.TEMP, null, slot, null, 1) ? true : null;
			}
			Matcher sa = STR.matcher(a);
			if (sa.matches() && type3.equals("java.nio.ByteBuffer")) {
				return sol.set(j, Kind.STRING, null, Integer.parseInt(sa.group(1)), null, 2) ? true : null;
			}
			Matcher aa = ADDR.matcher(a);
			Matcher ao = OFFSET.matcher(a);
			if (!aa.matches() && !ao.matches()) {
				return false;
			}
			int i = Integer.parseInt(aa.matches() ? aa.group(1) : ao.group(1));
			String type2 = lwjgl2.types.erasure(sol.m2.getParameters().get(i).asType()).toString();
			if (!ELEMENT_SIZE.containsKey(type2)) {
				return false;
			}
			int off = aa.matches() ? 0 : Integer.parseInt(ao.group(2));
			if (sol.kinds[j] == null) {
				sol.offset[j] = off;
			} else if (sol.offset[j] != off) {
				return null;
			}
			return sol.set(j, Kind.BUFFER, null, i, null, type2.equals(type3) && off == 0 ? 0 : 1) ? true : null;
		}
		Matcher sb = STR.matcher(b);
		// the string's parameter is lost when LWJGL 3 encodes on the stack or wraps it in an array (str(*), str(newarray[1]))
		if (sb.matches() || b.startsWith("str(") && !b.contains("$") || b.equals("str")) {
			int j = sb.matches() ? Integer.parseInt(sb.group(1)) : onlyCharSequence(sol.params3);
			Matcher sa = STR.matcher(a);
			// or an LWJGL 2 native that took the String itself (AL10.alIsExtensionPresent(String)) and encoded it in C
			Matcher pa = PARAM.matcher(a);
			boolean string2 = pa.matches() && sol.m2.getParameters().get(Integer.parseInt(pa.group(1))).asType().toString()
				.matches("java\\.lang\\.(String|CharSequence)");
			if (j < 0 || !sa.matches() && !string2 || !sol.params3[j].getDescriptor().equals("Ljava/lang/CharSequence;")) {
				return false;
			}
			int i = Integer.parseInt(sa.matches() ? sa.group(1) : pa.group(1));
			return sol.set(j, Kind.VALUE, sol.name2(i), i, a, 0) ? true : null;
		}
		return false;
	}

	private static final Pattern STRUCT = Pattern.compile("^\\$(\\d+)\\$\\.address\\(\\)$");

	private static final Pattern OBJECT_POINTER = Pattern.compile("^APIUtil\\.getPointer(Safe)?\\((\\w+)\\)$");

	private static final Pattern CALLBACK = Pattern.compile("^(?:phi\\()?\\$(\\d+)\\$\\.getPointer\\(\\)(?:\\|0\\))?$");

	/** The LWJGL 2 callback parameter whose pointer {@code a} is, if LWJGL 3 takes it as {@code to}: CLXxxCallback -> CLXxxCallbackI. */
	private Integer callback(Solution sol, String a, Type to) {
		Matcher cm = CALLBACK.matcher(a);
		if (!cm.matches() || to.getSort() != Type.OBJECT) {
			return null;
		}
		int i = Integer.parseInt(cm.group(1));
		String simple3 = to.getClassName().substring(to.getClassName().lastIndexOf('.') + 1);
		javax.lang.model.type.TypeMirror tm = sol.m2.getParameters().get(i).asType();
		while (tm instanceof DeclaredType dt) {
			TypeElement te = (TypeElement)dt.asElement();
			if ((te.getSimpleName() + "I").equals(simple3)) {
				return i;
			}
			tm = te.getSuperclass();
		}
		return null;
	}

	/**
	 * The template of an LWJGL 2 method, or null; with {@code code}, only one whose Java the template writes (@Code,
	 * @PointerWrapper, @Constant) in a package whose Java this lays out (OpenCL).
	 */
	private Templates.Method template(String cls, ExecutableElement m, boolean code) {
		if (code && !cls.startsWith("org/lwjgl/opencl/")) {
			return null;
		}
		Templates.Iface iface = templates == null ? null : templates.of(cls);
		if (iface == null) {
			return null;
		}
		List<String> names = m.getParameters().stream().map(p -> p.getSimpleName().toString()).toList();
		for (Templates.Method tm : templates.methods(iface)) {
			if (!tm.name().equals(m.getSimpleName().toString())) {
				continue;
			}
			List<String> java = tm.params().stream()
				.filter(p -> !p.has("AutoSize") && !(p.has("Constant") && !p.ann("Constant").flag("keepParam", false)))
				.map(Templates.Param::name).toList();
			boolean writes = !code || tm.has("Code") || tm.has("PointerWrapper") || tm.params().stream().anyMatch(p -> p.has("Constant"));
			if (java.equals(names) && writes) {
				return tm;
			}
			// @GenerateAutos: the variant taking the size in place of the buffer it sizes (clCreateBuffer(..., size, ...))
			Set<String> sized = tm.params().stream().filter(p -> p.has("AutoSize")).map(p -> p.ann("AutoSize").value())
				.collect(Collectors.toSet());
			List<String> autos = tm.params().stream()
				.filter(p -> !sized.contains(p.name()) && !(p.has("Constant") && !p.ann("Constant").flag("keepParam", false)))
				.map(p -> p.has("AutoSize") ? p.ann("AutoSize").value() + "_size" : p.name()).toList();
			if (tm.has("GenerateAutos") && autos.equals(names) && writes) {
				return tm;
			}
		}
		return null;
	}

	private static int onlyCharSequence(Type[] params) {
		int found = -1;
		for (int j = 0; j < params.length; j++) {
			if (params[j].getDescriptor().equals("Ljava/lang/CharSequence;")) {
				if (found >= 0) {
					return -1;
				}
				found = j;
			}
		}
		return found;
	}

	private static String paramName(Solution sol, String a) {
		Matcher pm = PARAM.matcher(a);
		return pm.matches() ? sol.name2(Integer.parseInt(pm.group(1))) : null;
	}

	/** Java source for LWJGL 2 argument expression {@code a}, passed to a parameter of type {@code to}; null if none. */
	private String renderValue(Solution sol, String a, Type to) {
		ExecutableElement m2 = sol.m2;
		Matcher pm = PARAM.matcher(a);
		if (pm.matches()) {
			VariableElement p = m2.getParameters().get(Integer.parseInt(pm.group(1)));
			String from = lwjgl2.desc(p.asType());
			// widening that keeps the kind of number: the native function gets the same value in the same kind of register
			boolean integral2 = "BSCIJ".contains(from), integral3 = "BSCIJ".contains(to.getDescriptor());
			return from.length() == 1 && Overloads.WIDENING.get(from).contains(to.getDescriptor()) && integral2 == integral3
				? p.getSimpleName().toString() : null;
		}
		Matcher ptr = POINTER.matcher(a);
		if (ptr.matches() && to.getSort() == Type.LONG) {
			return m2.getParameters().get(Integer.parseInt(ptr.group(1))).getSimpleName() + ".getPointer()";
		}
		Matcher np = Pattern.compile("^phi\\(\\$(\\d+)\\$\\.getPointer\\(\\)\\|0\\)$").matcher(a);
		if (np.matches() && to.getSort() == Type.LONG) {
			String p = m2.getParameters().get(Integer.parseInt(np.group(1))).getSimpleName().toString();
			return "(" + p + " == null ? 0L : " + p + ".getPointer())"; // a PointerWrapper that may be absent
		}
		Matcher phi = PHI2.matcher(a);
		if (phi.matches() && to.getSort() == Type.INT) {
			// LWJGL 2's unsigned flag choosing a type constant: the signed one is even, the unsigned the next (GL_BYTE, GL_UNSIGNED_BYTE)
			long x = Long.parseLong(phi.group(1)), y = Long.parseLong(phi.group(2));
			boolean flag = m2.getParameters().stream()
				.anyMatch(p -> p.asType().getKind() == TypeKind.BOOLEAN && p.getSimpleName().contentEquals("unsigned"));
			if (!flag || Math.abs(x - y) != 1 || Math.min(x, y) % 2 != 0) {
				return null;
			}
			return "(unsigned ? " + Math.max(x, y) + " : " + Math.min(x, y) + ")";
		}
		if (a.matches("-?\\d+")) {
			return switch (to.getSort()) {
				case Type.LONG -> a + "L";
				case Type.INT -> a;
				case Type.SHORT, Type.BYTE, Type.CHAR -> "(" + to.getClassName() + ")" + a;
				case Type.BOOLEAN -> a.equals("0") ? "false" : a.equals("1") ? "true" : null;
				case Type.FLOAT -> a + "f";
				case Type.DOUBLE -> a + ".0";
				default -> null;
			};
		}
		return renderCount(a, m2, to);
	}

	/** A buffer's address, a buffer's remaining count or an array's length, maybe shifted or scaled, for type {@code to}. */
	private String renderCount(String arg, ExecutableElement m, Type to) {
		Matcher a = ARG.matcher(arg);
		if (!a.matches() || a.group(1) != null || a.group(4) != null) {
			return null;
		}
		boolean toLong = to.getSort() == Type.LONG;
		String kind = a.group(2) != null ? a.group(2) : a.group(5);
		VariableElement p = m.getParameters().get(Integer.parseInt(a.group(2) != null ? a.group(3) : a.group(6)));
		String name = p.getSimpleName().toString();
		String type = lwjgl2.types.erasure(p.asType()).toString();
		String base;
		switch (kind) {
			case "addr" -> {
				if (!ELEMENT_SIZE.containsKey(type) || !toLong) {
					return null;
				}
				return MU + "memAddressSafe(" + name + ")";
			}
			case "rem" -> {
				if (!ELEMENT_SIZE.containsKey(type)) {
					return null;
				}
				base = "org.lwjgl.system.Checks.remainingSafe(" + name + ")";
			}
			default -> {
				if (p.asType().getKind() != TypeKind.ARRAY) {
					return null;
				}
				base = "(" + name + " == null ? 0 : " + name + ".length)";
			}
		}
		if (to.getSort() != Type.INT && !toLong) {
			return null;
		}
		if (a.group(7) == null) {
			return base;
		}
		return "(" + (toLong ? "(long)" : "") + base + " " + a.group(7) + " " + a.group(8) + ")";
	}

	/**
	 * LWJGL 3 parameters a method passes through a MemoryUtil or Checks *Safe helper: they may be null. A method that
	 * only forwards to another of the same descriptor (GL32.glGetSynci -> GL32C.glGetSynci) is followed.
	 */
	private Set<Integer> nullableBuffers(String owner, MethodNode mn, int depth) {
		Set<Integer> out = new HashSet<>();
		for (AbstractInsnNode insn = mn.instructions.getFirst(); insn != null && depth < 4; insn = insn.getNext()) {
			if (insn instanceof MethodInsnNode mi && mi.getOpcode() == Opcodes.INVOKESTATIC && mi.desc.equals(mn.desc)
				&& mi.name.equals(mn.name) && !mi.owner.equals(owner)) {
				MethodNode target = trace3.find(mi.owner, mi.name, mi.desc);
				if (target != null) {
					return nullableBuffers(mi.owner, target, depth + 1);
				}
			}
		}
		Type[] ts = Type.getArgumentTypes(mn.desc);
		Map<Integer, Integer> slotToParam = new HashMap<>();
		int slot = 0;
		for (int i = 0; i < ts.length; i++) {
			slotToParam.put(slot, i);
			slot += ts[i].getSize();
		}
		for (AbstractInsnNode insn = mn.instructions.getFirst(); insn != null; insn = insn.getNext()) {
			if (insn instanceof MethodInsnNode mi && mi.name.endsWith("Safe")
				&& (mi.owner.equals("org/lwjgl/system/MemoryUtil") || mi.owner.equals("org/lwjgl/system/Checks"))
				&& insn.getPrevious() instanceof VarInsnNode v && v.getOpcode() == Opcodes.ALOAD) {
				Integer p = slotToParam.get(v.var);
				if (p != null) {
					out.add(p);
				}
			}
		}
		return out;
	}

	/** The constant element counts a method (or the one it forwards to) checks its buffer parameters for. */
	private int[] minimumCounts(String owner, MethodNode mn, int depth) {
		Type[] ts = Type.getArgumentTypes(mn.desc);
		int[] out = new int[ts.length];
		Map<Integer, Integer> slotToParam = new HashMap<>();
		int slot = 0;
		for (int i = 0; i < ts.length; i++) {
			slotToParam.put(slot, i);
			slot += ts[i].getSize();
		}
		for (AbstractInsnNode insn = mn.instructions.getFirst(); insn != null; insn = insn.getNext()) {
			if (insn instanceof MethodInsnNode mi && mi.getOpcode() == Opcodes.INVOKESTATIC && mi.desc.equals(mn.desc)
				&& mi.name.equals(mn.name) && !mi.owner.equals(owner) && depth < 4) {
				MethodNode target = trace3.find(mi.owner, mi.name, mi.desc);
				if (target != null) {
					return minimumCounts(mi.owner, target, depth + 1);
				}
			}
			if (insn instanceof MethodInsnNode mi && mi.owner.equals("org/lwjgl/system/Checks") && mi.name.equals("check")
				&& mi.desc.endsWith("I)V") && insn.getPrevious() != null && insn.getPrevious().getPrevious() instanceof VarInsnNode v
				&& v.getOpcode() == Opcodes.ALOAD) {
				Integer n = constant(insn.getPrevious());
				Integer p = slotToParam.get(v.var);
				if (n != null && p != null) {
					out[p] = Math.max(out[p], n);
				}
			}
		}
		return out;
	}

	private static Integer constant(AbstractInsnNode insn) {
		int op = insn.getOpcode();
		if (op >= Opcodes.ICONST_0 && op <= Opcodes.ICONST_5) {
			return op - Opcodes.ICONST_0;
		}
		if (insn instanceof org.objectweb.asm.tree.IntInsnNode in && (op == Opcodes.BIPUSH || op == Opcodes.SIPUSH)) {
			return in.operand;
		}
		return null;
	}

	// ---- values the parameters did not set directly

	private boolean sameValue(Solution sol, String a, String b) {
		Boolean pointer = pointerCount(sol, a, b);
		if (pointer != null) {
			return pointer;
		}
		IntFunction<VariableElement> params2 = i -> sol.m2.getParameters().get(i);
		Linear la = linear(a, params2, null);
		Linear lb = linear(b, params2, sol);
		if (la != null && lb != null) {
			return la.equals(lb);
		}
		return !b.contains("$") && a.equals(b);
	}

	private static final Pattern POINTER_COUNT = Pattern.compile("^\\(?rem\\(\\$(\\d+)\\$\\)(<<S:MemoryStack\\.POINTER_SHIFT\\))?$");

	/** A count of a POINTER temporary: one pointer, or its bytes (PointerBuffer.getPointerSize()); null if b is none. */
	private static Boolean pointerCount(Solution sol, String a, String b) {
		Matcher bp = POINTER_COUNT.matcher(b);
		if (!bp.matches() || sol.kinds[Integer.parseInt(bp.group(1))] != Kind.POINTER || b.startsWith("(") != (bp.group(2) != null)) {
			return null;
		}
		return bp.group(2) == null ? a.equals("1") : a.equals("phi(4|phi(4|8))") || a.equals("phi(4|8)");
	}

	/**
	 * A count LWJGL 3 takes from a buffer's remaining() where LWJGL 2 passed it separately (glBindBuffersBase(target,
	 * first, count, buffers)): the buffer becomes a view of that many elements. For a string encoded here, a length
	 * means no null terminator.
	 */
	private boolean explicitCount(Solution sol, String a, String b) {
		Boolean pointer = pointerCount(sol, a, b);
		if (pointer != null) {
			return pointer;
		}
		Matcher bm = Pattern.compile("^rem\\(\\$(\\d+)\\$\\)$").matcher(b);
		Matcher bs = Pattern.compile("^\\(rem\\(\\$(\\d+)\\$\\)(<<|>>|\\*|/)(\\d+)\\)$").matcher(b);
		int j;
		String inverse = null;
		if (bm.matches()) {
			j = Integer.parseInt(bm.group(1));
		} else if (bs.matches()) {
			j = Integer.parseInt(bs.group(1));
			inverse = switch (bs.group(2)) {
				case "<<" -> ">>";
				case ">>" -> "<<";
				case "*" -> "/";
				default -> "*";
			} + " " + bs.group(3);
		} else {
			return false;
		}
		if (sol.kinds[j] == Kind.STRING) {
			Matcher sa = COUNT.matcher(a);
			if (sa.matches() && sa.group(1).equals("strlen") && Integer.parseInt(sa.group(2)) == sol.from[j] && inverse == null) {
				sol.terminated[j] = false;
				return true;
			}
			return false;
		}
		if (sol.kinds[j] == Kind.POINTER) {
			return inverse == null && a.equals("1");
		}
		if (sol.kinds[j] == Kind.TEMP && inverse == null && a.matches("\\d+")) {
			sol.tempCount[j] = Integer.parseInt(a); // a temporary of the size LWJGL 2 passed
			return true;
		}
		if (sol.kinds[j] != Kind.BUFFER || sol.source[j] != null) {
			return false;
		}
		String count = renderValue(sol, a, Type.INT_TYPE);
		if (count == null || linear(a, i -> sol.m2.getParameters().get(i), null) == null) {
			return false;
		}
		sol.source[j] = inverse == null ? count : "(" + count + " " + inverse + ")";
		sol.countExpr[j] = inverse == null ? a : "(" + a + inverse.replace(" ", "") + ")";
		sol.adapters++;
		return true;
	}

	/** Whether LWJGL 3's return, with the solution, is LWJGL 2's; sets the return statement when it is not the call. */
	private boolean returns(Solution sol, String ret2, Candidate c, List<String> calls2, Type ret3t) {
		String ret3 = c.ret;
		for (int k = 0; k < c.calls.size(); k++) {
			ret3 = ret3.replace(c.calls.get(k), calls2.get(k));
		}
		String type2 = lwjgl2.desc(sol.m2.getReturnType());
		if (ret3.equals(ret2) && ret3t.getDescriptor().equals(type2)) {
			return true;
		}
		// LWJGL 2's branches (a PointerWrapper that may be null) leave several forms of the same call's value
		if (calls2.size() == 1 && ret2.startsWith("phi(R:" + fn(calls2.get(0)) + "(") && c.ret.equals("R:" + c.calls.get(0))
			&& ret3t.getDescriptor().equals(type2)) {
			return true;
		}
		// LWJGL 2 read the value from its temporary: so does this, from the one passed in its place
		Matcher tm = Pattern.compile("^(\\()?TMP\\.get\\((\\d+)\\)(!=0\\))?$").matcher(ret2);
		if (tm.matches()) {
			int slot = Integer.parseInt(tm.group(2));
			for (int j = 0; j < sol.kinds.length; j++) {
				if (sol.kinds[j] == Kind.TEMP && sol.from[j] == slot) {
					sol.returns = "__t" + j + ".get(0)" + (tm.group(3) != null ? " != 0" : "");
					return true;
				}
			}
			return false;
		}
		// LWJGL 2 wrapped the returned pointer (new GLSync(pointer))
		if (ret2.startsWith("new ") && ret3t.getSort() == Type.LONG && c.calls.size() == 1 && c.ret.equals("R:" + c.calls.get(0))
			&& sol.m2.getReturnType() instanceof DeclaredType dt && hasPointerConstructor((TypeElement)dt.asElement())) {
			sol.returns = "new " + ((TypeElement)dt.asElement()).getQualifiedName() + "($CALL$)";
			sol.adapters++;
			return true;
		}
		return false;
	}

	private static boolean hasPointerConstructor(TypeElement te) {
		for (var e : te.getEnclosedElements()) {
			// compat makes LWJGL 2's package-private ones (GLSync(long)) public
			if (e.getKind() == ElementKind.CONSTRUCTOR && !e.getModifiers().contains(Modifier.PRIVATE)) {
				List<? extends VariableElement> ps = ((ExecutableElement)e).getParameters();
				if (ps.size() == 1 && ps.get(0).asType().getKind() == TypeKind.LONG) {
					return true;
				}
			}
		}
		return false;
	}

	// ---- counts as linear forms: bytes of LWJGL 2's buffers, LWJGL 2's primitive parameters, string lengths

	private record Linear(Map<String, Fraction> terms) {
		static Linear atom(String atom, Fraction c) {
			Map<String, Fraction> m = new TreeMap<>();
			if (!c.isZero()) {
				m.put(atom, c);
			}
			return new Linear(m);
		}

		Linear times(Fraction f) {
			Map<String, Fraction> m = new TreeMap<>();
			terms.forEach((k, v) -> m.put(k, v.times(f)));
			m.values().removeIf(Fraction::isZero);
			return new Linear(m);
		}

		Linear plus(Linear o) {
			Map<String, Fraction> m = new TreeMap<>(terms);
			o.terms.forEach((k, v) -> m.merge(k, v, Fraction::plus));
			m.values().removeIf(Fraction::isZero);
			return new Linear(m);
		}
	}

	private record Fraction(BigInteger num, BigInteger den) {
		static Fraction of(long n, long d) {
			BigInteger nn = BigInteger.valueOf(n), dd = BigInteger.valueOf(d);
			if (nn.signum() == 0) {
				return new Fraction(BigInteger.ZERO, BigInteger.ONE);
			}
			BigInteger g = nn.gcd(dd);
			if (dd.signum() < 0) {
				g = g.negate();
			}
			return new Fraction(nn.divide(g), dd.divide(g));
		}

		Fraction times(Fraction o) {
			return of(num.multiply(o.num).longValueExact(), den.multiply(o.den).longValueExact());
		}

		Fraction plus(Fraction o) {
			return of(num.multiply(o.den).add(o.num.multiply(den)).longValueExact(), den.multiply(o.den).longValueExact());
		}

		boolean isZero() {
			return num.signum() == 0;
		}
	}

	/**
	 * {@code e} as a linear form, or null. LWJGL 2 side ({@code sol == null}): its parameters. LWJGL 3 side: LWJGL 3
	 * parameters, resolved through the solution.
	 */
	private Linear linear(String e, IntFunction<VariableElement> params2, Solution sol) {
		e = e.trim();
		if (e.matches("-?\\d+")) {
			return Linear.atom("1", Fraction.of(Long.parseLong(e), 1));
		}
		Matcher pm = PARAM.matcher(e);
		if (pm.matches()) {
			int n = Integer.parseInt(pm.group(1));
			if (sol == null) {
				return Linear.atom("p" + n, Fraction.of(1, 1));
			}
			return sol.kinds[n] == Kind.VALUE && sol.source[n] != null ? linear(sol.source[n], params2, null) : null;
		}
		Matcher cm = COUNT.matcher(e);
		if (cm.matches()) {
			int n = Integer.parseInt(cm.group(2));
			String what = cm.group(1);
			if (sol == null) {
				if (!what.equals("rem")) {
					return Linear.atom(what + n, Fraction.of(1, 1));
				}
				Integer size = ELEMENT_SIZE.get(lwjgl2.types.erasure(params2.apply(n).asType()).toString());
				return size == null ? null : Linear.atom("bytes" + n, Fraction.of(1, size));
			}
			if (sol.kinds[n] == null) {
				return null;
			}
			switch (sol.kinds[n]) {
				case NULL -> {
					return new Linear(new TreeMap<>());
				}
				case TEMP, INPUT -> {
					return what.equals("rem") ? Linear.atom("1", Fraction.of(sol.kinds[n] == Kind.TEMP ? sol.tempCount[n] : 1, 1)) : null;
				}
				case STRING -> {
					Linear l = Linear.atom("strlen" + sol.from[n], Fraction.of(1, 1));
					return sol.terminated[n] ? l.plus(Linear.atom("1", Fraction.of(1, 1))) : l;
				}
				case VALUE -> {
					// a CharSequence LWJGL 3 encodes: its length is the LWJGL 2 string's
					return what.equals("strlen") && sol.from[n] >= 0 ? Linear.atom("strlen" + sol.from[n], Fraction.of(1, 1)) : null;
				}
				default -> {
					if (!what.equals("rem")) {
						return null;
					}
					if (sol.countExpr[n] != null) {
						return linear(sol.countExpr[n], params2, null);
					}
					Integer size3 = ELEMENT_SIZE.get(sol.params3[n].getClassName());
					return Linear.atom("bytes" + sol.from[n], Fraction.of(1, size3));
				}
			}
		}
		if (e.startsWith("(") && e.endsWith(")") && balanced(e.substring(1, e.length() - 1))) {
			return linear(e.substring(1, e.length() - 1), params2, sol);
		}
		int depth = 0;
		for (int k = 0; k < e.length(); k++) {
			char ch = e.charAt(k);
			if (ch == '(') {
				depth++;
			} else if (ch == ')') {
				depth--;
			} else if (depth == 0 && k > 0) {
				for (String op : new String[] {"<<", ">>", "*", "/", "+"}) {
					if (e.startsWith(op, k)) {
						Linear l = linear(e.substring(0, k), params2, sol);
						String rest = e.substring(k + op.length()).trim();
						if (l == null) {
							return null;
						}
						if (op.equals("+")) {
							Linear r = linear(rest, params2, sol);
							return r == null ? null : l.plus(r);
						}
						if (!rest.matches("\\d+")) {
							return null;
						}
						long n = Long.parseLong(rest);
						return switch (op) {
							case "<<" -> l.times(Fraction.of(1L << n, 1));
							case ">>" -> l.times(Fraction.of(1, 1L << n));
							case "*" -> l.times(Fraction.of(n, 1));
							default -> l.times(Fraction.of(1, n));
						};
					}
				}
			}
		}
		return null;
	}

	private static boolean balanced(String s) {
		int depth = 0;
		for (char ch : s.toCharArray()) {
			if (ch == '(') {
				depth++;
			} else if (ch == ')' && --depth < 0) {
				return false;
			}
		}
		return depth == 0;
	}

}
