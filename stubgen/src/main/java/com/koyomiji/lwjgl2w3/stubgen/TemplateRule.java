package com.koyomiji.lwjgl2w3.stubgen;

import org.objectweb.asm.Type;
import org.objectweb.asm.Handle;
import org.objectweb.asm.tree.*;

import javax.lang.model.element.VariableElement;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * R3: expand the LWJGL 2 generator template of the method the way LWJGL 2's generator did (multi-typed buffers,
 * {@code @AutoType}, {@code @AutoSize}, {@code @Constant}, {@code @GLreturn}, buffer-object offsets) into one native call,
 * and make that call through LWJGL 3's raw {@code n<function>}, with stack temporaries where LWJGL 2 used APIUtil's.
 *
 * <p>The template only says what LWJGL 2 meant to do; the expansion must also produce exactly LWJGL 2's
 * {@link NativeTrace}, and the {@code n} method must pass its arguments straight to the same function, or the rule
 * declines. Expressions it cannot translate make it decline too, with the reason in {@code template-declines.tsv}.</p>
 */
final class TemplateRule implements Rule {

	/** Where this rule is tried for now. */
	static boolean inScope(String cls) {
		return cls.startsWith("org/lwjgl/opengl/");
	}

	// ---- LWJGL 2's GLTypeMap

	/** Native type annotation -> primitive kind. */
	private static final Map<String, String> KIND = new HashMap<>();
	private static final Map<String, String> SIGNED = new HashMap<>();
	private static final Map<String, String> INVERSE = new HashMap<>();
	private static final Map<String, String> AUTO_TYPE = Map.of(
		"GLint", "GL11.GL_INT", "GLbyte", "GL11.GL_BYTE", "GLshort", "GL11.GL_SHORT", "GLuint", "GL11.GL_UNSIGNED_INT",
		"GLubyte", "GL11.GL_UNSIGNED_BYTE", "GLushort", "GL11.GL_UNSIGNED_SHORT", "GLfloat", "GL11.GL_FLOAT",
		"GLdouble", "GL11.GL_DOUBLE");
	private static final Set<String> POINTER_TYPES = Set.of("GLintptr", "GLintptrARB", "GLsizeiptr", "GLsizeiptrARB");

	static {
		for (String[] e : new String[][] {
			{"GLbitfield", "INT"}, {"GLcharARB", "BYTE"}, {"GLclampf", "FLOAT"}, {"GLfloat", "FLOAT"}, {"GLint", "INT"},
			{"GLshort", "SHORT"}, {"GLsizeiptr", "LONG"}, {"GLuint", "INT"}, {"GLboolean", "BOOLEAN"}, {"GLchar", "BYTE"},
			{"GLdouble", "DOUBLE"}, {"GLhalf", "SHORT"}, {"GLintptrARB", "LONG"}, {"GLsizei", "INT"}, {"GLushort", "SHORT"},
			{"GLbyte", "BYTE"}, {"GLclampd", "DOUBLE"}, {"GLenum", "INT"}, {"GLhandleARB", "INT"}, {"GLintptr", "LONG"},
			{"GLsizeiptrARB", "LONG"}, {"GLubyte", "BYTE"}, {"GLvoid", "BYTE"}, {"GLint64EXT", "LONG"},
			{"GLuint64EXT", "LONG"}, {"GLint64", "LONG"}, {"GLuint64", "LONG"}}) {
			KIND.put(e[0], e[1]);
		}
		for (String[] p : new String[][] {{"GLuint", "GLint"}, {"GLushort", "GLshort"}, {"GLubyte", "GLbyte"},
			{"GLuint64EXT", "GLint64EXT"}, {"GLuint64", "GLint64"}}) {
			SIGNED.put(p[0], "UNSIGNED");
			SIGNED.put(p[1], "SIGNED");
			INVERSE.put(p[0], p[1]);
			INVERSE.put(p[1], p[0]);
		}
	}

	private static final Set<String> BUFFERS = Set.of("Buffer", "ByteBuffer", "ShortBuffer", "CharBuffer", "IntBuffer",
		"LongBuffer", "FloatBuffer", "DoubleBuffer", "PointerBuffer");

	/** One expansion of a multi-typed parameter (LWJGL 2's TypeInfo): Java type, signedness, auto type expression. */
	private record TypeInfo(String type, String signedness, String autoType) {
	}

	private enum Mode {NORMAL, BUFFEROBJECT}

	/** Thrown to decline, with the reason. */
	private static final class Decline extends Exception {
		Decline(String why) {
			super(why, null, false, false);
		}
	}

	private final Templates templates;
	private final Lwjgl2Api lwjgl2;
	private final Lwjgl3Api lwjgl3;
	private final NativeTrace trace3;
	private final List<String> declines = new ArrayList<>();

	TemplateRule(Templates templates, Lwjgl2Api lwjgl2, Lwjgl3Api lwjgl3, NativeTrace trace3) {
		this.templates = templates;
		this.lwjgl2 = lwjgl2;
		this.lwjgl3 = lwjgl3;
		this.trace3 = trace3;
	}

	@Override
	public String name() {
		return "R3";
	}

	@Override
	public String apply(Target t) {
		if (!inScope(t.cls())) {
			return null;
		}
		try {
			return implement(t);
		} catch (Decline d) {
			declines.add(String.join("\t", t.cls(), t.name(), t.desc(), d.getMessage()));
			return null;
		}
	}

	/** Rows for methods in scope this rule declined: class, method, descriptor, reason. */
	void writeDeclines(Path file) throws IOException {
		Files.createDirectories(file.getParent());
		Files.write(file, declines);
	}

	private String implement(Target t) throws Decline {
		if (t.calls().size() != 1) {
			throw new Decline("makes " + t.calls().size() + " native calls");
		}
		Templates.Iface iface = templates.of(t.cls());
		if (iface == null) {
			throw new Decline("no template");
		}
		String call2 = t.calls().get(0);
		String fn = call2.substring(0, call2.indexOf('('));
		Set<String> found = new LinkedHashSet<>();
		Decline last = new Decline("no template method expands to this overload");
		for (Templates.Method tm : candidates(iface, fn)) {
			List<Mode> modes = tm.params().stream().anyMatch(p -> p.has("BufferObject"))
				? List.of(Mode.NORMAL, Mode.BUFFEROBJECT) : List.of(Mode.NORMAL);
			for (Mode mode : modes) {
				for (Map<String, TypeInfo> instance : instances(tm)) {
					try {
						List<Templates.Param> java = javaParams(tm, mode, instance);
						if (!matches(t, tm, mode, java, instance)) {
							continue;
						}
						found.add(new Binder(t, tm, mode, instance, java).bind());
					} catch (Decline d) {
						last = d;
					}
				}
			}
		}
		if (found.size() > 1) {
			throw new Decline("ambiguous: " + found.size() + " expansions");
		}
		if (found.isEmpty()) {
			throw last;
		}
		return found.iterator().next();
	}

	/** The template methods for C function {@code fn}; a {@code @Reuse} one stands for the methods it reuses. */
	private List<Templates.Method> candidates(Templates.Iface iface, String fn) {
		List<Templates.Method> out = new ArrayList<>();
		for (Templates.Method tm : templates.methods(iface)) {
			if (!tm.function().equals(fn)) {
				continue;
			}
			Templates.Ann reuse = tm.ann("Reuse");
			if (reuse == null) {
				out.add(tm);
				continue;
			}
			Templates.Iface other = templates.of(iface.pkg() + "/" + reuse.value());
			String name = reuse.get("method", "").isEmpty() ? tm.name() : reuse.get("method", "");
			if (other != null) {
				templates.methods(other).stream()
					.filter(o -> o.name().equals(name) && !o.has("Reuse") && o.params().size() == tm.params().size())
					.forEach(out::add);
			}
		}
		return out;
	}

	// ---- the Java overloads LWJGL 2's generator wrote for a template method

	private static List<Map<String, TypeInfo>> instances(Templates.Method tm) {
		List<Map<String, TypeInfo>> out = new ArrayList<>();
		out.add(new HashMap<>());
		for (Templates.Param p : tm.params()) {
			List<Map<String, TypeInfo>> next = new ArrayList<>();
			for (TypeInfo ti : typeInfos(tm, p)) {
				for (Map<String, TypeInfo> m : out) {
					Map<String, TypeInfo> n = new HashMap<>(m);
					n.put(p.name(), ti);
					next.add(n);
				}
			}
			out = next;
		}
		return out;
	}

	/** LWJGL 2's TypeInfo.getTypeInfos. */
	private static List<TypeInfo> typeInfos(Templates.Method tm, Templates.Param p) {
		List<String> natives = p.anns().keySet().stream().filter(KIND::containsKey).sorted().toList();
		if (natives.isEmpty()) {
			return List.of(new TypeInfo(qualify(p.type(), tm.owner()), "NONE", null));
		}
		Templates.Ann glvoid = p.ann("GLvoid");
		String voidKind = glvoid == null ? null : glvoid.value() == null ? "BYTE" : glvoid.value().substring(glvoid.value().lastIndexOf('.') + 1);
		Map<String, TypeInfo> byAnn = new LinkedHashMap<>();
		for (String a : natives) {
			String signedness = SIGNED.getOrDefault(a, "NONE");
			String auto = AUTO_TYPE.get(a);
			String inverse = INVERSE.get(a);
			if (inverse != null && byAnn.containsKey(inverse)) {
				String inverseAuto = byAnn.remove(inverse).autoType();
				auto = "unsigned ? " + (signedness.equals("UNSIGNED") ? auto + " : " + inverseAuto : inverseAuto + " : " + auto);
				signedness = "BOTH";
			}
			String kind = voidKind != null ? voidKind : KIND.get(a);
			String type = BUFFERS.contains(p.type()) ? bufferType(kind, a) : primitive(kind);
			byAnn.put(a, new TypeInfo(type, signedness, auto));
		}
		return new ArrayList<>(byAnn.values());
	}

	private static String bufferType(String kind, String ann) {
		return switch (kind) {
			case "INT" -> "java.nio.IntBuffer";
			case "FLOAT" -> "java.nio.FloatBuffer";
			case "DOUBLE" -> "java.nio.DoubleBuffer";
			case "SHORT" -> "java.nio.ShortBuffer";
			case "LONG" -> POINTER_TYPES.contains(ann) ? "org.lwjgl.PointerBuffer" : "java.nio.LongBuffer";
			default -> "java.nio.ByteBuffer";
		};
	}

	private static String primitive(String kind) {
		return kind.toLowerCase(Locale.ROOT);
	}

	private static String qualify(String type, Templates.Iface owner) {
		if (type.endsWith("[]")) {
			return qualify(type.substring(0, type.length() - 2), owner) + "[]";
		}
		if (Character.isLowerCase(type.charAt(0))) {
			return type;
		}
		if (type.equals("PointerBuffer") || type.equals("PointerWrapper")) {
			return "org.lwjgl." + type;
		}
		if (BUFFERS.contains(type)) {
			return "java.nio." + type;
		}
		if (type.equals("CharSequence") || type.equals("String")) {
			return "java.lang." + type;
		}
		return owner.pkg().replace('/', '.') + "." + type;
	}

	/**
	 * LWJGL 2's generateParametersJava: the template parameters the Java method takes, in order; {@code null} stands for
	 * the {@code boolean unsigned} an {@code @AutoType} adds.
	 */
	private static List<Templates.Param> javaParams(Templates.Method tm, Mode mode, Map<String, TypeInfo> instance) throws Decline {
		List<Templates.Param> out = new ArrayList<>();
		for (Templates.Param p : tm.params()) {
			if (p.has("Helper")) {
				throw new Decline("@Helper");
			}
			Templates.Ann c = p.ann("Constant");
			if (c != null && c.flag("isNative", false)) {
				continue;
			}
			boolean auto = p.has("AutoType") || p.has("AutoSize");
			if (mode == Mode.NORMAL && auto) {
				if (p.has("AutoType") && instance.get(p.ann("AutoType").value()).signedness().equals("BOTH")) {
					out.add(null);
				}
			} else if (!p.has("Result") && (c == null || c.flag("keepParam", false)) && !isReturnParameter(tm, p)) {
				out.add(p);
			}
		}
		return out;
	}

	private static boolean isReturnParameter(Templates.Method tm, Templates.Param p) {
		Templates.Ann r = tm.ann("GLreturn");
		return r != null && r.value().equals(p.name());
	}

	private boolean matches(Target t, Templates.Method tm, Mode mode, List<Templates.Param> java, Map<String, TypeInfo> instance) {
		List<? extends VariableElement> ps = t.method().getParameters();
		if (ps.size() != java.size() || !nameMatches(t.name(), tm, mode)) {
			return false;
		}
		for (int i = 0; i < ps.size(); i++) {
			Templates.Param p = java.get(i);
			String type = p == null ? "boolean"
				: mode == Mode.BUFFEROBJECT && p.has("BufferObject") ? "long" : instance.get(p.name()).type();
			if (!lwjgl2.types.erasure(ps.get(i).asType()).toString().equals(type)) {
				return false;
			}
		}
		return true;
	}

	/** The Java name; for {@code @StripPostfix}, any type postfix the generator may have stripped. */
	private static boolean nameMatches(String name, Templates.Method tm, Mode mode) {
		Templates.Ann alt = tm.ann("Alternate");
		String own = alt == null || alt.flag("javaAlt", false) ? tm.name() : alt.value();
		if (own.equals(name)) {
			return true;
		}
		Templates.Ann strip = tm.ann("StripPostfix");
		if (strip == null || mode != Mode.NORMAL) {
			return false;
		}
		String ext = strip.get("extension", "NULL").equals("NULL") ? tm.owner().extensionPostfix() : strip.get("extension", "");
		if (!own.endsWith(ext) || !name.endsWith(ext)) {
			return false;
		}
		String base = own.substring(0, own.length() - ext.length());
		String stripped = name.substring(0, name.length() - ext.length());
		return base.startsWith(stripped) && base.substring(stripped.length()).matches("[a-z0-9_]+");
	}

	// ---- binding the native call

	/** A native argument: Java source, trace notation, and descriptor of its Java type. */
	private record Arg(String java, String trace, String desc) {
	}

	private static final String MU = "org.lwjgl.system.MemoryUtil.";

	private final class Binder {

		final Target t;
		final Templates.Method tm;
		final Mode mode;
		final Map<String, TypeInfo> instance;
		final List<Templates.Param> java;
		/** Java declarations of temporaries, inside the stack frame. */
		final List<String> temps = new ArrayList<>();
		/** Buffer size checks, before anything else. */
		final List<String> checks = new ArrayList<>();
		boolean stack;
		boolean scratch;
		final Set<String> encodedStrings = new HashSet<>();
		/** @GLreturn: the temporary holding the result, and whether it is a string (heap-allocated, freed after). */
		Templates.Param returned;
		String returnedType;
		/** For a string result: how LWJGL 3 decodes it. */
		String returnedEncoding;

		Binder(Target t, Templates.Method tm, Mode mode, Map<String, TypeInfo> instance, List<Templates.Param> java) {
			this.t = t;
			this.tm = tm;
			this.mode = mode;
			this.instance = instance;
			this.java = java;
		}

		String bind() throws Decline {
			for (String a : List.of("Reuse", "Code", "CachedResult", "AutoSize")) {
				if (tm.has(a)) {
					throw new Decline("@" + a + " on the method");
				}
			}
			String ret = t.method().getReturnType().toString();
			Templates.Ann glreturn = tm.ann("GLreturn");
			Templates.Ann wrapper = tm.ann("PointerWrapper");
			if (wrapper != null) {
				// LWJGL 2 wraps the returned handle: new GLSync(handle)
				if (!wrapper.get("factory", "").isEmpty() || !wrapper.get("params", "").isEmpty() || !qualify(tm.ret(), tm.owner()).equals(ret)) {
					throw new Decline("@PointerWrapper result with a factory or parameters");
				}
			} else if (glreturn != null) {
				glReturn(glreturn, ret);
			} else if (!qualify(tm.ret(), tm.owner()).equals(ret) || !(tm.ret().equals("void") || Character.isLowerCase(tm.ret().charAt(0)))) {
				throw new Decline("returns " + ret);
			}

			List<Arg> args = new ArrayList<>();
			for (Templates.Param p : tm.params()) {
				if (p.has("Result")) {
					throw new Decline("@Result");
				}
				Templates.Ann c = p.ann("Constant");
				if (c != null) {
					if (!c.flag("isNative", false)) {
						args.addAll(constant(c.value()));
					}
				} else if (mode == Mode.NORMAL && p.has("AutoType")) {
					args.add(autoType(p));
				} else if (mode == Mode.NORMAL && p.has("AutoSize")) {
					args.add(autoSize(p));
				} else {
					args.add(explicit(p));
				}
			}

			String fn = tm.function();
			boolean returns = glreturn == null && !ret.equals("void");
			String call = fn + "(" + args.stream().map(Arg::trace).collect(Collectors.joining(",")) + ")";
			NativeTrace.Summary mine = new NativeTrace.Summary();
			mine.natives.add(call);
			String myRet = returned != null ? (returnedType.equals("String") ? "string" : "TMP.get(0)")
				: wrapper != null ? "new " + ret.substring(ret.lastIndexOf('.') + 1) : returns ? "R:" + call : "";
			if (!myRet.isEmpty()) {
				mine.returns.add(myRet);
			}
			if (!NativeTrace.norm(mine).equals(t.calls()) || !NativeTrace.normRet(mine).equals(t.ret())) {
				throw new Decline("expansion " + NativeTrace.fmt(mine) + " differs from LWJGL 2's " + String.join(" ; ", t.calls()) + " => " + t.ret());
			}

			String target = raw(fn, args, wrapper != null ? "J" : returns ? lwjgl2.desc(t.method().getReturnType()) : null);
			return render(wrapper != null ? "new " + ret + "(" + target + ")" : target, returns);
		}

		// -- @GLreturn: the value comes back through a temporary

		void glReturn(Templates.Ann r, String ret) throws Decline {
			returned = tm.param(r.value());
			if (returned == null) {
				throw new Decline("@GLreturn names no parameter");
			}
			String bufferType = returned.type();
			boolean string = bufferType.equals("ByteBuffer") && (returned.has("GLchar") || returned.has("GLcharARB"));
			returnedType = string ? "String" : returned.has("GLboolean") ? "boolean" : switch (bufferType) {
				case "IntBuffer" -> "int";
				case "FloatBuffer" -> "float";
				case "LongBuffer" -> "long";
				case "DoubleBuffer" -> "double";
				case "ShortBuffer" -> "short";
				case "ByteBuffer" -> "byte";
				default -> throw new Decline("@GLreturn " + bufferType);
			};
			if (!(string ? "java.lang.String" : returnedType).equals(ret)) {
				throw new Decline("@GLreturn " + returnedType + " but returns " + ret);
			}
			stack = true;
			String v = "__" + returned.name();
			if (string) {
				if (r.flag("forceMaxLength", false) || stringOffset(null)) {
					throw new Decline("@GLreturn string with forceMaxLength or offset");
				}
				int j = javaIndex(r.get("maxLength", ""));
				returnedEncoding = encodingOf(tm.function(), t.cls());
				temps.add("java.nio.IntBuffer " + v + "_length = __stack.mallocInt(1);");
				// memAlloc(0) may return null
				temps.add("java.nio.ByteBuffer " + v + " = " + MU + "memAlloc(Math.max(" + paramName(j) + ", 1));");
			} else if (returnedType.equals("boolean") || returnedType.equals("byte")) {
				temps.add("java.nio.ByteBuffer " + v + " = __stack.malloc(2);");
			} else {
				// two elements: templates also pass the element after the result (glGetActiveUniformSize's type)
				String t = Character.toUpperCase(returnedType.charAt(0)) + returnedType.substring(1);
				temps.add("java.nio." + t + "Buffer " + v + " = __stack.malloc" + t + "(2);");
			}
		}

		// -- arguments

		Arg autoType(Templates.Param p) throws Decline {
			String auto = instance.get(p.ann("AutoType").value()).autoType();
			if (auto == null) {
				throw new Decline("no auto type for " + p.name());
			}
			Matcher m = Pattern.compile("unsigned \\? (\\S+) : (\\S+)").matcher(auto);
			if (m.matches()) {
				int u = java.indexOf(null);
				long a = glConstant(m.group(1));
				long b = glConstant(m.group(2));
				String phi = new TreeSet<>(List.of(String.valueOf(a), String.valueOf(b))).stream().collect(Collectors.joining("|", "phi(", ")"));
				return new Arg("(" + paramName(u) + " ? " + a + " : " + b + ")", phi, "I");
			}
			long v = glConstant(auto);
			return new Arg(String.valueOf(v), String.valueOf(v), "I");
		}

		Arg autoSize(Templates.Param p) throws Decline {
			Templates.Ann s = p.ann("AutoSize");
			if (s.flag("useExpression", false)) {
				throw new Decline("@AutoSize(useExpression)");
			}
			Templates.Param q = tm.param(s.value());
			int j = javaIndex(s.value());
			if (q == null || !BUFFERS.contains(q.type())) {
				throw new Decline("@AutoSize of " + s.value());
			}
			String x = paramName(j);
			String java = s.flag("canBeNull", false) ? "(" + x + " == null ? 0 : " + x + ".remaining())" : x + ".remaining()";
			String trace = "rem($" + j + "$)";
			boolean typed = tm.params().stream().anyMatch(o -> o.has("AutoType") && o.ann("AutoType").value().equals(q.name()));
			if (!typed && q.type().equals("Buffer")) {
				int shift = switch (instance.get(q.name()).type()) {
					case "java.nio.ByteBuffer" -> 0;
					case "java.nio.ShortBuffer" -> 1;
					case "java.nio.IntBuffer", "java.nio.FloatBuffer" -> 2;
					case "java.nio.LongBuffer", "java.nio.DoubleBuffer" -> 3;
					default -> throw new Decline("@AutoSize of " + instance.get(q.name()).type());
				};
				if (shift > 0) {
					java = "(" + java + " << " + shift + ")";
					trace = "(" + trace + "<<" + shift + ")";
				}
			}
			String expression = s.get("expression", "").trim();
			if (!expression.isEmpty()) {
				Matcher m = Pattern.compile("(>>|<<|/|\\*)\\s*(.+)").matcher(expression);
				if (!m.matches()) {
					throw new Decline("@AutoSize expression " + expression);
				}
				long n = fold(m.group(2));
				java = "(" + java + " " + m.group(1) + " " + n + ")";
				trace = "(" + trace + m.group(1) + n + ")";
			}
			return new Arg(java, trace, "I");
		}

		Arg explicit(Templates.Param p) throws Decline {
			if (p == returned) {
				return new Arg(MU + "memAddress(__" + p.name() + ")", "addr(TMP)", "J");
			}
			int j = java.indexOf(p);
			if (j < 0) {
				throw new Decline("parameter " + p.name() + " is not in the Java method");
			}
			String x = paramName(j);
			if (mode == Mode.BUFFEROBJECT && p.has("BufferObject")) {
				return new Arg(x, "$" + j + "$", "J");
			}
			if (p.has("PointerWrapper")) {
				// the handle inside LWJGL 2's wrapper object (GLSync, or any PointerWrapper for glObjectPtrLabel)
				if (p.ann("PointerWrapper").flag("canBeNull", false)) {
					return new Arg("(" + x + " == null ? 0L : " + x + ".getPointer())", "phi($" + j + "$.getPointer()|0)", "J");
				}
				return new Arg(x + ".getPointer()", "$" + j + "$.getPointer()", "J");
			}
			String type = instance.get(p.name()).type();
			if (type.equals("java.lang.CharSequence")) {
				if (stringOffset(p)) {
					throw new Decline("string offset");
				}
				return new Arg(encoded(p) + "Address", "str($" + j + "$)", "J");
			}
			if (type.startsWith("java.nio.") || type.equals("org.lwjgl.PointerBuffer")) {
				Templates.Ann check = p.ann("Check");
				boolean safe = check != null && check.flag("canBeNull", false);
				if (check != null && check.value() != null && check.value().matches("\\d+") && !type.equals("java.nio.Buffer")) {
					// LWJGL 2 checked the size of buffers the call writes a fixed number of elements to
					checks.add((safe ? "if (org.lwjgl.system.Checks.CHECKS && " + x + " != null) " : "if (org.lwjgl.system.Checks.CHECKS) ")
						+ "org.lwjgl.system.Checks.check(" + x + ", " + check.value() + ");");
				}
				return new Arg(MU + (safe ? "memAddressSafe(" : "memAddress(") + x + ")", "addr($" + j + "$)", "J");
			}
			if (Character.isLowerCase(type.charAt(0)) && !type.endsWith("[]")) {
				return new Arg(x, "$" + j + "$", lwjgl2.desc(t.method().getParameters().get(j).asType()));
			}
			throw new Decline("parameter type " + type);
		}

		/** A {@code @Constant} value: LWJGL 2 Java source, possibly several arguments. */
		List<Arg> constant(String value) throws Decline {
			List<Arg> out = new ArrayList<>();
			for (String part : RawNativeCallRule.splitArgs(value)) {
				out.add(constantArg(part.trim()));
			}
			return out;
		}

		Arg constantArg(String v) throws Decline {
			Matcher m;
			if (v.matches("-?\\d+L?")) {
				String n = v.replace("L", "");
				return new Arg(n, n, "I");
			}
			if (v.matches("GL\\w+\\.GL_\\w+")) {
				long n = glConstant(v);
				return new Arg(String.valueOf(n), String.valueOf(n), "I");
			}
			if ((m = Pattern.compile("(\\w+)\\.length\\(\\)").matcher(v)).matches()) {
				int j = javaIndex(m.group(1));
				if (instance.get(java.get(j).name()).type().equals("java.lang.CharSequence")) {
					// the encoded length: in UTF-8, bytes are not chars
					return new Arg(encoded(java.get(j)) + "Length", "strlen($" + j + "$)", "I");
				}
				return new Arg(paramName(j) + ".length()", "strlen($" + j + "$)", "I");
			}
			if ((m = Pattern.compile("(\\w+)\\.remaining\\(\\) << (\\d)").matcher(v)).matches()) {
				int j = javaIndex(m.group(1));
				return new Arg("(" + paramName(j) + ".remaining() << " + m.group(2) + ")", "(rem($" + j + "$)<<" + m.group(2) + ")", "I");
			}
			if ((m = Pattern.compile("MemoryUtil\\.getAddress0\\((\\w+)_length\\)").matcher(v)).matches()) {
				if (returned == null || !returned.name().equals(m.group(1)) || !returnedType.equals("String")) {
					throw new Decline("constant " + v);
				}
				return new Arg(MU + "memAddress(__" + m.group(1) + "_length)", "addr(TMP)", "J");
			}
			if (v.equals("MemoryUtil.getAddress0(APIUtil.getBufferInt(caps))") || v.equals("MemoryUtil.getAddress(APIUtil.getBufferInt(caps), 1)")) {
				// LWJGL 2's per-context int scratch buffer: both refer to the same one
				useScratch();
				boolean second = v.endsWith(", 1)");
				return new Arg(MU + "memAddress(__scratch" + (second ? ", 1)" : ")"), second ? "addr(TMP,1)" : "addr(TMP)", "J");
			}
			if (v.equals("APIUtil.getBufferByte0(caps)")) {
				stack = true;
				return new Arg(MU + "memAddress(__stack.malloc(1))", "addr(TMP)", "J");
			}
			if ((m = Pattern.compile("APIUtil\\.getInt\\(caps, (\\w+)\\)").matcher(v)).matches()) {
				int j = javaIndex(m.group(1));
				stack = true;
				return new Arg(MU + "memAddress(__stack.ints(" + paramName(j) + "))", "addr(TMP)", "J");
			}
			if ((m = Pattern.compile("MemoryUtil\\.getAddress\\((\\w+), 1\\)").matcher(v)).matches()) {
				if (returned != null && returned.name().equals(m.group(1))) {
					return new Arg(MU + "memAddress(__" + m.group(1) + ", 1)", "addr(TMP,1)", "J");
				}
				int j = javaIndex(m.group(1));
				return new Arg(MU + "memAddress(" + paramName(j) + ", 1)", "addr($" + j + "$,1)", "J");
			}
			if ((m = Pattern.compile("MemoryUtil\\.getAddress\\((\\w+), \\1\\.position\\(\\) \\+ 1\\)").matcher(v)).matches()) {
				int j = javaIndex(m.group(1));
				String x = paramName(j);
				return new Arg(MU + "memAddress(" + x + ", " + x + ".position() + 1)", "addr($" + j + "$,($" + j + "$.position()+1))", "J");
			}
			if (v.matches("\\w+")) {
				int j = javaIndex(v);
				return new Arg(paramName(j), "$" + j + "$", lwjgl2.desc(t.method().getParameters().get(j).asType()));
			}
			throw new Decline("constant " + v);
		}

		/**
		 * The variable prefix of string parameter {@code p} encoded on the stack, as LWJGL 3 encodes that function's
		 * strings: {@code <prefix>Length} bytes (without the terminator) at {@code <prefix>Address}.
		 */
		String encoded(Templates.Param p) throws Decline {
			String v = "__" + p.name() + "Encoded";
			if (encodedStrings.add(p.name())) {
				stack = true;
				int j = java.indexOf(p);
				temps.add("int " + v + "Length = __stack.n" + encodingOf(tm.function(), t.cls()) + "(" + paramName(j) + ", " + p.has("NullTerminated") + ");");
				temps.add("long " + v + "Address = __stack.getPointerAddress();");
			}
			return v;
		}

		void useScratch() {
			stack = true;
			if (!scratch) {
				scratch = true;
				temps.add("java.nio.IntBuffer __scratch = __stack.mallocInt(2);");
			}
		}

		/** LWJGL 2's getStringOffset: whether non-null-terminated strings before {@code p} share its buffer. */
		boolean stringOffset(Templates.Param p) {
			for (Templates.Param o : tm.params()) {
				if (o == p) {
					break;
				}
				if (!o.has("NullTerminated") && (o.type().equals("CharSequence") || o.type().equals("CharSequence[]"))) {
					return true;
				}
			}
			return false;
		}

		int javaIndex(String templateParam) throws Decline {
			for (int i = 0; i < java.size(); i++) {
				if (java.get(i) != null && java.get(i).name().equals(templateParam)) {
					return i;
				}
			}
			throw new Decline("refers to " + templateParam + ", which the Java method does not take");
		}

		String paramName(int j) {
			return t.method().getParameters().get(j).getSimpleName().toString();
		}

		// -- LWJGL 3's side

		/** A call to LWJGL 3's raw method for {@code fn}, which passes its arguments straight through. */
		String raw(String fn, List<Arg> args, String returnDesc) throws Decline {
			String identity = fn + "(" + IntStream.range(0, args.size()).mapToObj(i -> "$" + i + "$").collect(Collectors.joining(",")) + ")";
			for (String owner3 : lwjgl3.owners(t.cls())) {
				ClassNode cn = lwjgl3.get(owner3);
				if (cn == null) {
					continue;
				}
				for (MethodNode n : cn.methods) {
					if (!(n.name.equals("n" + fn) || n.name.equals(fn)) || !Lwjgl3Api.isPublicStatic(n)) {
						continue;
					}
					Type[] pts = Type.getArgumentTypes(n.desc);
					if (pts.length != args.size() || returnDesc != null && !Type.getReturnType(n.desc).getDescriptor().equals(returnDesc)) {
						continue;
					}
					boolean fits = true;
					for (int i = 0; i < pts.length && fits; i++) {
						String from = args.get(i).desc();
						// integral widening only: an int where LWJGL 3 takes a float means the template's native type was
						// wrong (NVPathRendering.glPathStencilDepthOffsetNV), and converting would change what C receives
						String to = pts[i].getDescriptor();
						fits = from.equals(to) || "BSCI".contains(from) && "IJ".contains(to) && Overloads.WIDENING.get(from).contains(to);
					}
					NativeTrace.Summary s3 = trace3.summarize(owner3, n.name, n.desc, 0);
					if (!fits || s3.unresolved || !NativeTrace.norm(s3).equals(List.of(identity))
						|| returnDesc != null && !NativeTrace.normRet(s3).equals("R:" + identity)) {
						continue;
					}
					return owner3.replace('/', '.') + "." + n.name + "(" + args.stream().map(Arg::java).collect(Collectors.joining(", ")) + ")";
				}
			}
			throw new Decline("LWJGL 3 has no raw method for " + fn + " taking " + args.size() + " arguments");
		}

		String render(String call, boolean returns) {
			List<String> lines = new ArrayList<>(checks);
			if (!stack) {
				lines.add((returns ? "return " : "") + call + ";");
				return String.join("\n", lines);
			}
			lines.add("try (org.lwjgl.system.MemoryStack __stack = org.lwjgl.system.MemoryStack.stackPush()) {");
			temps.forEach(d -> lines.add("\t" + d));
			if (returned == null) {
				lines.add("\t" + (returns ? "return " : "") + call + ";");
			} else if (returnedType.equals("String")) {
				String v = "__" + returned.name();
				lines.add("\ttry {");
				lines.add("\t\t" + call + ";");
				lines.add("\t\treturn " + MU + "mem" + returnedEncoding + "(" + v + ", " + v + "_length.get(0));");
				lines.add("\t} finally {");
				lines.add("\t\t" + MU + "memFree(" + v + ");");
				lines.add("\t}");
			} else {
				lines.add("\t" + call + ";");
				lines.add("\treturn __" + returned.name() + ".get(0)" + (returnedType.equals("boolean") ? " == 1" : "") + ";");
			}
			lines.add("}");
			return String.join("\n", lines);
		}

	}

	private final Map<String, String> encodings = new HashMap<>();

	/**
	 * How LWJGL 3 encodes strings of {@code fn}: {@code UTF8} or {@code ASCII}, read from the MemoryStack/MemoryUtil
	 * helpers its own methods for {@code fn} call (its templates' GLcharUTF8 and GLcharASCII). ASCII, as LWJGL 2 and the
	 * extension specs have it, when LWJGL 3 has no string form of {@code fn} (glProgramStringARB takes bytes); null when
	 * its methods use both.
	 */
	private String encoding(String fn, String cls) {
		return encodings.computeIfAbsent(fn, k -> {
			Set<String> found = new HashSet<>();
			for (String owner3 : lwjgl3.owners(cls)) {
				ClassNode cn = trace3.classes.get(owner3);
				if (cn == null) {
					continue;
				}
				for (MethodNode m : cn.methods) {
					if (!Lwjgl3Api.isPublicStatic(m) || m.name.equals("n" + fn)) {
						continue;
					}
					boolean calls = false;
					Set<String> used = new HashSet<>();
					for (AbstractInsnNode i : m.instructions) {
						if (i instanceof MethodInsnNode mi) {
							calls |= mi.name.equals("n" + fn) || mi.name.equals(fn) && !mi.owner.startsWith("org/lwjgl/system/");
							if (mi.owner.equals("org/lwjgl/system/MemoryStack") || mi.owner.equals("org/lwjgl/system/MemoryUtil")) {
								used.add(textEncoding(mi.name));
							}
						} else if (i instanceof InvokeDynamicInsnNode d) {
							// encoders passed as method references, e.g. apiArray(stack, MemoryUtil::memUTF8, strings)
							for (Object a : d.bsmArgs) {
								if (a instanceof Handle h) {
									used.add(textEncoding(h.getName()));
								}
							}
						}
					}
					if (calls) {
						found.addAll(used);
					}
				}
			}
			found.remove(null);
			return found.size() > 1 ? null : found.contains("UTF8") ? "UTF8" : "ASCII";
		});
	}

	/** {@link #encoding}, declining when LWJGL 3's methods for {@code fn} encode strings both ways. */
	private String encodingOf(String fn, String cls) throws Decline {
		String e = encoding(fn, cls);
		if (e == null) {
			throw new Decline("LWJGL 3 encodes strings of " + fn + " both as ASCII and as UTF-8");
		}
		return e;
	}

	private static String textEncoding(String helper) {
		return helper.contains("UTF8") ? "UTF8" : helper.contains("ASCII") ? "ASCII" : null;
	}

	/** A GL constant such as {@code GL11.GL_FLOAT}, from LWJGL 3's class or its {@code C} class. */
	private long glConstant(String ref) throws Decline {
		String[] parts = ref.split("\\.");
		for (String cls : List.of("org/lwjgl/opengl/" + parts[0], "org/lwjgl/opengl/" + parts[0] + "C")) {
			for (String c : lwjgl3.contains(cls) ? lwjgl3.selfAndSupers(cls) : List.<String>of()) {
				ClassNode cn = lwjgl3.get(c);
				if (cn == null) {
					continue;
				}
				for (FieldNode f : cn.fields) {
					if (f.name.equals(parts[1]) && f.value instanceof Number n) {
						return n.longValue();
					}
				}
			}
		}
		throw new Decline("constant " + ref + " not in LWJGL 3");
	}

	/** {@code 3}, {@code (3 * 4)}: what javac folds an @AutoSize expression operand to. */
	private static long fold(String e) throws Decline {
		e = e.trim();
		if (e.startsWith("(") && e.endsWith(")")) {
			e = e.substring(1, e.length() - 1).trim();
		}
		long out = 1;
		for (String f : e.split("\\*")) {
			if (!f.trim().matches("\\d+")) {
				throw new Decline("@AutoSize expression " + e);
			}
			out *= Long.parseLong(f.trim());
		}
		return out;
	}

}
