package com.koyomiji.lwjgl2w3.stubgen;

import com.sun.source.tree.ClassTree;
import com.sun.source.tree.CompilationUnitTree;
import com.sun.source.tree.Tree;
import com.sun.source.util.JavacTask;
import com.sun.source.util.TreePath;
import com.sun.source.util.Trees;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldNode;
import org.objectweb.asm.tree.MethodNode;

import javax.lang.model.element.*;
import javax.lang.model.type.*;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.*;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Writes TODO stubs into compat for the LWJGL 2.9.3 API.
 *
 * <p>The LWJGL 2 API is read from its source jars through javac (for parameter names, generics and constant values);
 * the LWJGL 3 API is read from its jars through ASM. A member gets a stub only if LWJGL 3 does not already provide it
 * (declared or inherited) and no file for its class exists in compat yet.</p>
 */
public final class StubGen {

	static final String INJECT_PACKAGE = "com.koyomiji.lwjgl2w3.inject";
	static final String GENERATED_PACKAGE = "com.koyomiji.lwjgl2w3.generated";

	/** LWJGL 2 classes whose LWJGL 3 counterpart has an incompatible superclass; see poc/callback in the research repo. */
	static final Set<String> CALLBACKS = Set.of(
		"org.lwjgl.opencl.CLContextCallback", "org.lwjgl.opencl.CLEventCallback",
		"org.lwjgl.opencl.CLMemObjectDestructorCallback", "org.lwjgl.opencl.CLNativeKernel",
		"org.lwjgl.opencl.CLProgramCallback");

	static final Set<String> SDL_CLASSES = Set.of(
		"Display", "DisplayMode", "PixelFormat", "PixelFormatLWJGL", "Pbuffer", "Drawable", "SharedDrawable",
		"AWTGLCanvas", "XRandR", "RenderTexture");
	static final Set<String> CONTEXT_CLASSES = Set.of("GLContext", "ContextCapabilities", "ContextAttribs");

	static final Map<String, String> AREAS = new LinkedHashMap<>();

	static {
		AREAS.put("core", "org.lwjgl: Sys-level utilities, PointerBuffer, MemoryUtil");
		AREAS.put("context", "GLContext / ContextCapabilities on top of GL.getCapabilities()");
		AREAS.put("gl", "OpenGL bindings: mostly mechanical delegation to LWJGL 3 (e.g. glFog -> glFogfv)");
		AREAS.put("gles", "OpenGL ES");
		AREAS.put("sdl", "Display, input, pbuffers: SDL-based reimplementation");
		AREAS.put("al", "OpenAL: AL/ALC object model over LWJGL 3 handles");
		AREAS.put("cl", "OpenCL: CL object model (CLPlatform, CLDevice, ...) over LWJGL 3 handles");
		AREAS.put("port", "Pure Java utilities from lwjgl_util: port from the LWJGL 2 sources (BSD)");
	}

	final Map<String, ClassNode> l3 = new HashMap<>();
	Elements elements;
	Types types;

	final List<String> design = new ArrayList<>();
	/** Class files shipped in the LWJGL 2 binary jars: the API to reproduce (the sources jar has more, e.g. GLES). */
	final Set<String> shipped = new HashSet<>();
	/** Package-private LWJGL 2 types that inject classes (in another package) must reference, emitted as public. */
	final Set<String> forcePublic = new TreeSet<>();
	/** LWJGL 3 class -> constructor descriptors that compat adds through @Into inject classes */
	final Map<String, Set<String>> addedConstructors = new HashMap<>();
	/** Native-call traces of the LWJGL 2 and LWJGL 3 binaries, for the delegation rules. */
	NativeTrace trace2, trace3;

	/** area -> {TODO stubs, delegations} written this run */
	final Map<String, int[]> counts = new TreeMap<>();
	Path mainDir, replaceDir, generatedDir;

	public static void main(String[] args) throws IOException {
		Map<String, String> a = new HashMap<>();
		for (int i = 0; i < args.length; i += 2) {
			a.put(args[i], args[i + 1]);
		}
		StubGen g = new StubGen();
		g.mainDir = Paths.get(a.get("--main"));
		g.replaceDir = Paths.get(a.get("--replace"));
		g.generatedDir = Paths.get(a.get("--generated"));
		deleteRecursively(g.generatedDir);
		g.readAddedConstructors(Paths.get(a.get("--inject-classes")));
		for (String jar : a.get("--lwjgl3").split(java.io.File.pathSeparator)) {
			g.readLwjgl3(Paths.get(jar));
		}
		g.trace3 = new NativeTrace(a.get("--lwjgl3"));
		List<String> lwjgl2Jars = new ArrayList<>();
		for (String jar : a.get("--classpath").split(java.io.File.pathSeparator)) {
			if (Paths.get(jar).getFileName().toString().startsWith("lwjgl")) {
				lwjgl2Jars.add(jar);
				try (ZipFile z = new ZipFile(jar)) {
					Collections.list(z.entries()).stream().map(ZipEntry::getName).filter(n -> n.endsWith(".class"))
						.forEach(n -> g.shipped.add(n.substring(0, n.length() - 6)));
				}
			}
		}
		g.trace2 = new NativeTrace(String.join(java.io.File.pathSeparator, lwjgl2Jars));
		List<TypeElement> api = g.readLwjgl2(a.get("--sources").split(java.io.File.pathSeparator), a.get("--classpath"));
		for (TypeElement te : api) {
			g.generate(te);
		}
		g.printSummary();
	}

	void readLwjgl3(Path jar) throws IOException {
		try (ZipFile z = new ZipFile(jar.toFile())) {
			for (ZipEntry e : Collections.list(z.entries())) {
				if (!e.getName().endsWith(".class") || e.getName().startsWith("META-INF/")) {
					continue;
				}
				try (InputStream in = z.getInputStream(e)) {
					ClassNode cn = new ClassNode();
					new ClassReader(in).accept(cn, ClassReader.SKIP_CODE | ClassReader.SKIP_DEBUG | ClassReader.SKIP_FRAMES);
					l3.put(cn.name, cn);
				}
			}
		}
	}

	static void deleteRecursively(Path dir) throws IOException {
		if (!Files.exists(dir)) {
			return;
		}
		try (var s = Files.walk(dir)) {
			for (Path p : s.sorted(Comparator.reverseOrder()).toList()) {
				Files.delete(p);
			}
		}
	}

	void readAddedConstructors(Path dir) throws IOException {
		if (!Files.isDirectory(dir)) {
			return;
		}
		List<Path> files;
		try (var s = Files.walk(dir)) {
			files = s.filter(f -> f.toString().endsWith(".class")).toList();
		}
		for (Path f : files) {
			ClassNode cn = new ClassNode();
			new ClassReader(Files.readAllBytes(f)).accept(cn, ClassReader.SKIP_CODE);
			if (cn.invisibleAnnotations == null) {
				continue;
			}
			for (var an : cn.invisibleAnnotations) {
				if (an.desc.equals("L" + INJECT_PACKAGE.replace('.', '/') + "/Into;")) {
					String target = ((org.objectweb.asm.Type)an.values.get(1)).getInternalName();
					cn.methods.stream().filter(m -> m.name.equals("<init>"))
						.forEach(m -> addedConstructors.computeIfAbsent(target, k -> new HashSet<>()).add(m.desc));
				}
			}
		}
	}

	List<TypeElement> readLwjgl2(String[] sourceJars, String classpath) throws IOException {
		Path dir = Files.createTempDirectory("lwjgl2-sources");
		List<java.io.File> files = new ArrayList<>();
		for (String jar : sourceJars) {
			try (ZipFile z = new ZipFile(jar)) {
				for (ZipEntry e : Collections.list(z.entries())) {
					if (!e.getName().endsWith(".java")) {
						continue;
					}
					Path out = dir.resolve(e.getName());
					Files.createDirectories(out.getParent());
					try (InputStream in = z.getInputStream(e)) {
						Files.copy(in, out, StandardCopyOption.REPLACE_EXISTING);
					}
					files.add(out.toFile());
				}
			}
		}
		JavaCompiler jc = ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager fm = jc.getStandardFileManager(null, null, StandardCharsets.UTF_8);
		// Errors in method bodies (e.g. sun.misc.Unsafe) do not matter: only declarations are used.
		DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<>();
		JavacTask task = (JavacTask)jc.getTask(null, fm, diagnostics,
			List.of("--release", "8", "-proc:none", "-classpath", classpath),
			null, fm.getJavaFileObjectsFromFiles(files));
		Iterable<? extends CompilationUnitTree> units = task.parse();
		task.analyze();
		elements = task.getElements();
		types = task.getTypes();
		Trees trees = Trees.instance(task);

		Map<String, TypeElement> all = new HashMap<>();
		for (CompilationUnitTree cu : units) {
			for (Tree decl : cu.getTypeDecls()) {
				if (decl instanceof ClassTree && trees.getElement(TreePath.getPath(cu, decl)) instanceof TypeElement te) {
					all.put(te.getQualifiedName().toString(), te);
				}
			}
		}
		// Public types, plus every LWJGL 2-only type their API mentions: package-private supertypes they inherit
		// public API from (e.g. CLObjectChild), and types only present in the binary jar (e.g. opengles.ContextAttribs).
		Set<TypeElement> out = new TreeSet<>(Comparator.comparing(te -> te.getQualifiedName().toString()));
		Deque<TypeElement> todo = all.values().stream().filter(te -> te.getModifiers().contains(Modifier.PUBLIC))
			.collect(Collectors.toCollection(ArrayDeque::new));
		while (!todo.isEmpty()) {
			TypeElement te = todo.poll();
			if (!shipped.contains(internalName(te)) || !out.add(te)) {
				continue;
			}
			Set<TypeElement> refs = new HashSet<>();
			references(te, refs);
			for (TypeElement r : refs) {
				TypeElement top = r;
				while (top.getNestingKind() == NestingKind.MEMBER) {
					top = (TypeElement)top.getEnclosingElement();
				}
				if (top.getQualifiedName().toString().startsWith("org.lwjgl.") && !out.contains(top)) {
					todo.add(top);
				}
				if (inLwjgl3(te) && !inLwjgl3(top) && !top.getModifiers().contains(Modifier.PUBLIC)
					&& top.getQualifiedName().toString().startsWith("org.lwjgl.")) {
					forcePublic.add(top.getQualifiedName().toString());
				}
			}
		}
		return new ArrayList<>(out);
	}

	/** Types mentioned by {@code te}'s supertypes and API members, including nested API types. */
	void references(TypeElement te, Set<TypeElement> refs) {
		List<TypeMirror> ts = new ArrayList<>(te.getInterfaces());
		ts.add(te.getSuperclass());
		for (Element e : te.getEnclosedElements()) {
			if (!isApi(e)) {
				continue;
			}
			if (e instanceof ExecutableElement m) {
				ts.add(m.getReturnType());
				m.getParameters().forEach(p -> ts.add(p.asType()));
				ts.addAll(m.getThrownTypes());
			} else if (e instanceof VariableElement v) {
				ts.add(v.asType());
			} else if (e instanceof TypeElement n) {
				references(n, refs);
			}
		}
		ts.forEach(t -> collect(t, refs, new HashSet<>()));
	}

	static void collect(TypeMirror t, Set<TypeElement> refs, Set<TypeMirror> seen) {
		if (!seen.add(t)) {
			return;
		}
		switch (t.getKind()) {
			case DECLARED -> {
				refs.add((TypeElement)((DeclaredType)t).asElement());
				((DeclaredType)t).getTypeArguments().forEach(a -> collect(a, refs, seen));
			}
			case ARRAY -> collect(((ArrayType)t).getComponentType(), refs, seen);
			case WILDCARD -> {
				WildcardType w = (WildcardType)t;
				if (w.getExtendsBound() != null) {
					collect(w.getExtendsBound(), refs, seen);
				}
				if (w.getSuperBound() != null) {
					collect(w.getSuperBound(), refs, seen);
				}
			}
			case TYPEVAR -> collect(((TypeVariable)t).getUpperBound(), refs, seen);
			default -> {
			}
		}
	}

	static String area(String pkg, String simple) {
		if (pkg.startsWith("org.lwjgl.util")) {
			return "port";
		}
		return switch (pkg) {
			case "org.lwjgl.input" -> "sdl";
			case "org.lwjgl.opengl" -> SDL_CLASSES.contains(simple) ? "sdl" : CONTEXT_CLASSES.contains(simple) ? "context" : "gl";
			case "org.lwjgl.opengles" -> "gles";
			case "org.lwjgl.openal" -> "al";
			case "org.lwjgl.opencl" -> "cl";
			default -> "core";
		};
	}

	String binaryName(TypeElement te) {
		return elements.getBinaryName(te).toString();
	}

	String internalName(TypeElement te) {
		return binaryName(te).replace('.', '/');
	}

	boolean inLwjgl3(TypeElement te) {
		return l3.containsKey(internalName(te));
	}

	String desc(TypeMirror t) {
		TypeMirror e = types.erasure(t);
		return switch (e.getKind()) {
			case BOOLEAN -> "Z";
			case BYTE -> "B";
			case CHAR -> "C";
			case SHORT -> "S";
			case INT -> "I";
			case LONG -> "J";
			case FLOAT -> "F";
			case DOUBLE -> "D";
			case VOID -> "V";
			case ARRAY -> "[" + desc(((ArrayType)e).getComponentType());
			case DECLARED -> "L" + internalName((TypeElement)((DeclaredType)e).asElement()) + ";";
			default -> "L?;";
		};
	}

	String desc(ExecutableElement m) {
		StringBuilder sb = new StringBuilder("(");
		for (VariableElement p : m.getParameters()) {
			sb.append(desc(p.asType()));
		}
		return sb.append(')').append(m.getKind() == ElementKind.CONSTRUCTOR ? "V" : desc(m.getReturnType())).toString();
	}

	static boolean isApi(Element e) {
		Set<Modifier> m = e.getModifiers();
		return m.contains(Modifier.PUBLIC) || m.contains(Modifier.PROTECTED)
			|| e.getEnclosingElement().getKind() == ElementKind.INTERFACE
			|| e.getEnclosingElement().getKind() == ElementKind.ANNOTATION_TYPE;
	}

	MethodNode declared3(String cls, String name, String desc) {
		ClassNode cn = l3.get(cls);
		return cn == null ? null : cn.methods.stream().filter(m -> m.name.equals(name) && m.desc.equals(desc)).findFirst().orElse(null);
	}

	List<String> supers3(String cls) {
		List<String> out = new ArrayList<>();
		Deque<String> todo = new ArrayDeque<>(List.of(cls));
		while (!todo.isEmpty()) {
			ClassNode cn = l3.get(todo.poll());
			if (cn == null) {
				continue;
			}
			if (cn.superName != null && !out.contains(cn.superName)) {
				out.add(cn.superName);
				todo.add(cn.superName);
			}
			for (String i : cn.interfaces) {
				if (!out.contains(i)) {
					out.add(i);
					todo.add(i);
				}
			}
		}
		return out;
	}

	/** Methods LWJGL 3's {@code cls} declares or inherits (name + descriptor). */
	Set<String> methods3(String cls) {
		Set<String> out = new HashSet<>();
		ClassNode self = l3.get(cls);
		self.methods.forEach(m -> out.add(m.name + m.desc));
		for (String s : supers3(cls)) {
			ClassNode cn = l3.get(s);
			if (cn == null) {
				continue;
			}
			boolean itf = (cn.access & Opcodes.ACC_INTERFACE) != 0;
			for (MethodNode m : cn.methods) {
				if ((m.access & Opcodes.ACC_PRIVATE) == 0 && !m.name.startsWith("<") && !(itf && (m.access & Opcodes.ACC_STATIC) != 0)) {
					out.add(m.name + m.desc);
				}
			}
		}
		return out;
	}

	Set<String> fields3(String cls) {
		Set<String> out = new HashSet<>();
		l3.get(cls).fields.forEach(f -> out.add(f.name));
		for (String s : supers3(cls)) {
			ClassNode cn = l3.get(s);
			if (cn != null) {
				for (FieldNode f : cn.fields) {
					if ((f.access & Opcodes.ACC_PRIVATE) == 0) {
						out.add(f.name);
					}
				}
			}
		}
		return out;
	}

	static final Map<String, String> WIDENING = Map.of(
		"B", "BSIJFD", "S", "SIJFD", "C", "CIJFD", "I", "IJFD", "J", "JFD", "F", "FD", "D", "D", "Z", "Z");

	static List<String> params(String desc) {
		List<String> out = new ArrayList<>();
		String s = desc.substring(1, desc.indexOf(')'));
		for (int i = 0; i < s.length(); ) {
			int j = i;
			while (s.charAt(j) == '[') {
				j++;
			}
			j = s.charAt(j) == 'L' ? s.indexOf(';', j) + 1 : j + 1;
			out.add(s.substring(i, j));
			i = j;
		}
		return out;
	}

	boolean assignable(String a, String b) {
		if (a.equals(b)) {
			return true;
		}
		if (a.length() == 1 || b.length() == 1) {
			return a.length() == 1 && b.length() == 1 && WIDENING.get(a).contains(b);
		}
		if (b.equals("Ljava/lang/Object;")) {
			return true;
		}
		if (a.startsWith("[") || b.startsWith("[")) {
			return false;
		}
		String an = a.substring(1, a.length() - 1), bn = b.substring(1, b.length() - 1);
		if (an.equals("java/lang/String") && bn.equals("java/lang/CharSequence")) {
			return true;
		}
		if (an.startsWith("java/nio/") && an.endsWith("Buffer") && bn.equals("java/nio/Buffer")) {
			return true;
		}
		return l3.containsKey(an) && supers3(an).contains(bn);
	}

	/**
	 * Hide from javac (keep linkable): when LWJGL 3 has the same parameters with another return type, or when this
	 * overload is more specific than an LWJGL 3 one and would silently take over LWJGL 3 calls.
	 */
	boolean needsHidden(Set<String> methods3, String name, String desc) {
		String ps = desc.substring(0, desc.indexOf(')') + 1);
		List<String> p2 = params(desc);
		for (String m : methods3) {
			if (!m.startsWith(name + "(")) {
				continue;
			}
			String d3 = m.substring(name.length());
			if (d3.startsWith(ps)) {
				return true;
			}
			List<String> p3 = params(d3);
			if (p3.size() == p2.size()) {
				boolean all = true;
				for (int i = 0; i < p2.size() && all; i++) {
					all = assignable(p2.get(i), p3.get(i));
				}
				if (all) {
					return true;
				}
			}
		}
		return false;
	}

	void generate(TypeElement te) throws IOException {
		String fqn = te.getQualifiedName().toString();
		String pkg = elements.getPackageOf(te).getQualifiedName().toString();
		String simple = te.getSimpleName().toString();
		String area = area(pkg, simple);

		if (CALLBACKS.contains(fqn)) {
			if (!Files.exists(replaceDir.resolve(pkg.replace('.', '/')).resolve(simple + ".java"))) {
				design.add(fqn + ": superclass conflicts with LWJGL 3 (PointerWrapperAbstract vs Callback); write a replace class");
			}
			return;
		}
		TypeMirror sup = te.getSuperclass();
		if (sup.getKind() == TypeKind.DECLARED) {
			TypeElement st = (TypeElement)((DeclaredType)sup).asElement();
			String sp = elements.getPackageOf(st).getQualifiedName().toString();
			if (CALLBACKS.contains(st.getQualifiedName().toString())
				&& !Files.exists(replaceDir.resolve(sp.replace('.', '/')).resolve(st.getSimpleName() + ".java"))) {
				design.add(fqn + ": extends " + st.getQualifiedName() + ", which needs a replace class first");
			}
		}

		if (inLwjgl3(te)) {
			generateInject(te, pkg, simple, area);
		} else {
			if (Files.exists(mainDir.resolve(pkg.replace('.', '/')).resolve(simple + ".java"))) {
				return; // hand-written as a whole class
			}
			Path file = generatedDir.resolve(pkg.replace('.', '/')).resolve(simple + ".java");
			if (sup.getKind() == TypeKind.DECLARED && inLwjgl3((TypeElement)((DeclaredType)sup).asElement())
				&& !CALLBACKS.contains(((TypeElement)((DeclaredType)sup).asElement()).getQualifiedName().toString())
				&& !types.erasure(sup).toString().equals("java.lang.Object")) {
				design.add(fqn + ": LWJGL 2-only class extending " + sup + ", which LWJGL 3 also has");
				return;
			}
			Writer w = new Writer(pkg, area);
			w.local(te);
			w.type(te, "");
			write(file, w.file());
			w.count();
		}
	}

	void generateInject(TypeElement te, String pkg, String simple, String area) throws IOException {
		String fqn = te.getQualifiedName().toString();
		Path file = generatedDir.resolve((GENERATED_PACKAGE + "." + pkg).replace('.', '/')).resolve(simple + ".java");
		String cls = internalName(te);
		Set<String> methods3 = methods3(cls);
		Set<String> fields3 = fields3(cls);

		// LWJGL 2 members, plus statics inherited from LWJGL 2-only superclasses (LWJGL 3 does not have that superclass)
		List<Element> members = new ArrayList<>(te.getEnclosedElements());
		for (TypeMirror s = te.getSuperclass(); s.getKind() == TypeKind.DECLARED; ) {
			TypeElement st = (TypeElement)((DeclaredType)s).asElement();
			if (inLwjgl3(st) || st.getQualifiedName().contentEquals("java.lang.Object")) {
				break;
			}
			for (Element e : st.getEnclosedElements()) {
				if (e.getModifiers().contains(Modifier.STATIC) && (e.getKind() == ElementKind.METHOD || e.getKind() == ElementKind.FIELD)) {
					members.add(e);
				} else if (e.getKind() == ElementKind.METHOD && isApi(e)) {
					design.add(fqn + ": inherits instance method " + e + " from LWJGL 2-only " + st.getQualifiedName() + "");
				}
			}
			s = st.getSuperclass();
		}
		for (TypeMirror itf : te.getInterfaces()) {
			TypeElement it = (TypeElement)((DeclaredType)itf).asElement();
			if (!supers3(cls).contains(internalName(it))) {
				design.add(fqn + ": LWJGL 2 implements " + it.getQualifiedName() + ", LWJGL 3 does not");
			}
		}

		Writer w = new Writer(GENERATED_PACKAGE + "." + pkg, area);
		w.localInject(simple);
		StringBuilder body = new StringBuilder();
		for (Element e : members) {
			if (!isApi(e)) {
				continue;
			}
			switch (e.getKind()) {
				case FIELD -> {
					if (!fields3.contains(e.getSimpleName().toString())) {
						body.append(w.field((VariableElement)e, "\t", false));
					}
				}
				case METHOD -> {
					ExecutableElement m = (ExecutableElement)e;
					String d = desc(m);
					String key = m.getSimpleName() + d;
					MethodNode own = declared3(cls, m.getSimpleName().toString(), d);
					if (own != null) {
						if (rank(own.access) < rank(m.getModifiers())) {
							body.append(w.method(m, "\t", false, "@Widen", false));
						}
					} else if (methods3.contains(key)) {
						// LWJGL 3 inherits it from a supertype: that implementation serves both
					} else if (m.getModifiers().contains(Modifier.ABSTRACT)) {
						design.add(fqn + ": abstract LWJGL 2 method " + m + " would break LWJGL 3 subclasses");
					} else {
						boolean hidden = needsHidden(methods3, m.getSimpleName().toString(), d);
						body.append(w.method(m, "\t", false, hidden ? "@Hidden" : null, true, delegate(m, cls, d)));
					}
				}
				case CONSTRUCTOR -> {
					ExecutableElement c = (ExecutableElement)e;
					MethodNode own = declared3(cls, "<init>", desc(c));
					if (own == null) {
						if (!addedConstructors.getOrDefault(cls, Set.of()).contains(desc(c))) {
							design.add(fqn + ": constructor " + c + " does not exist in LWJGL 3; add it from an @Into inject class extending the same superclass");
						}
					} else if (rank(own.access) < rank(c.getModifiers())) {
						body.append(w.constructor(c, simple, "\t", "@Widen", false));
					}
				}
				default -> {
				}
			}
		}
		if (body.length() == 0) {
			return;
		}
		w.out.append("public final class ").append(simple).append(" {\n").append(body).append("}\n");
		write(file, w.file());
		w.count();
	}

	/**
	 * Delegation rules: a statement implementing LWJGL 2 method {@code m} with LWJGL 3 code, or null.
	 *
	 * <p>R1: LWJGL 3's class (or a superclass) has a public static method with the same descriptor under another name,
	 * and both make the same native calls with the same arguments and return the same thing
	 * (e.g. {@code glFog(int, FloatBuffer)} and {@code glFogfv(int, FloatBuffer)}).</p>
	 */
	String delegate(ExecutableElement m, String cls, String desc) {
		if (!m.getModifiers().contains(Modifier.STATIC) || !m.getTypeParameters().isEmpty()) {
			return null;
		}
		String owner2 = internalName((TypeElement)m.getEnclosingElement());
		NativeTrace.Summary s2 = trace2.summarize(owner2, m.getSimpleName().toString(), desc, 0);
		if (s2.unresolved || s2.natives.isEmpty()) {
			return null;
		}
		List<String> calls2 = NativeTrace.norm(s2);
		String ret2 = NativeTrace.normRet(s2);
		List<String> owners = new ArrayList<>();
		owners.add(cls);
		owners.addAll(supers3(cls));
		for (String owner3 : owners) {
			ClassNode cn = l3.get(owner3);
			if (cn == null) {
				continue;
			}
			List<MethodNode> candidates = cn.methods.stream()
				.filter(c -> c.desc.equals(desc) && !c.name.equals(m.getSimpleName().toString())
					&& (c.access & (Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC)) == (Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC))
				.sorted(Comparator.comparing(c -> c.name)).toList();
			for (MethodNode c : candidates) {
				NativeTrace.Summary s3 = trace3.summarize(owner3, c.name, c.desc, 0);
				if (!s3.unresolved && NativeTrace.norm(s3).equals(calls2) && NativeTrace.normRet(s3).equals(ret2)) {
					String args = m.getParameters().stream().map(p -> p.getSimpleName().toString()).collect(Collectors.joining(", "));
					String call = cls.replace('/', '.').replace('$', '.') + "." + c.name + "(" + args + ");";
					return m.getReturnType().getKind() == TypeKind.VOID ? call : "return " + call;
				}
			}
		}
		return null;
	}

	static int rank(int access) {
		return (access & Opcodes.ACC_PUBLIC) != 0 ? 3 : (access & Opcodes.ACC_PROTECTED) != 0 ? 2 : (access & Opcodes.ACC_PRIVATE) != 0 ? 0 : 1;
	}

	static int rank(Set<Modifier> m) {
		return m.contains(Modifier.PUBLIC) ? 3 : m.contains(Modifier.PROTECTED) ? 2 : m.contains(Modifier.PRIVATE) ? 0 : 1;
	}

	static void write(Path file, String content) throws IOException {
		Files.createDirectories(file.getParent());
		Files.writeString(file, content);
	}

	void printSummary() {
		System.out.println("Generated members (TODO stubs / delegations); the merger reports what hand-written code leaves:");
		int tt = 0, td = 0;
		for (Map.Entry<String, String> a : AREAS.entrySet()) {
			int[] c = counts.getOrDefault(a.getKey(), new int[2]);
			System.out.printf("  %-8s %5d / %5d  %s%n", a.getKey(), c[0], c[1], a.getValue());
			tt += c[0];
			td += c[1];
		}
		System.out.printf("  %-8s %5d / %5d%n", "total", tt, td);
		System.out.println("Needs design (no stub generated):");
		design.stream().distinct().sorted().forEach(d -> System.out.println("  - " + d));
		System.out.println("Package-private in LWJGL 2, made public because inject classes mention them:");
		forcePublic.forEach(f -> System.out.println("  - " + f));
	}

	final class Writer {
		final String pkg;
		final String area;
		final StringBuilder out = new StringBuilder();
		final Map<String, String> taken = new HashMap<>(); // simple name -> fqn rendered as that simple name
		final TreeSet<String> imports = new TreeSet<>();
		int todos, delegations;

		Writer(String pkg, String area) {
			this.pkg = pkg;
			this.area = area;
		}

		void count() {
			int[] c = counts.computeIfAbsent(area, k -> new int[2]);
			c[0] += todos;
			c[1] += delegations;
		}

		/** Reserve the simple names declared in this file (the class and its nested types). */
		void local(TypeElement te) {
			taken.put(te.getSimpleName().toString(), te.getQualifiedName().toString());
			for (Element e : te.getEnclosedElements()) {
				if (e instanceof TypeElement n) {
					local(n);
				}
			}
		}

		/** The inject class shares its simple name with the LWJGL 3 target, so the target is always written in full. */
		void localInject(String simple) {
			taken.put(simple, pkg + "." + simple);
		}

		String file() {
			StringBuilder sb = new StringBuilder("package ").append(pkg).append(";\n\n");
			if (out.indexOf("@Widen") >= 0) {
				imports.add(INJECT_PACKAGE + ".Widen");
			}
			for (String a : List.of("Hidden", "Todo", "Generated")) {
				if (out.indexOf("@" + a) >= 0) {
					imports.add(INJECT_PACKAGE + "." + a);
				}
			}
			if (!imports.isEmpty()) {
				imports.forEach(i -> sb.append("import ").append(i).append(";\n"));
				sb.append('\n');
			}
			return sb.append(out).toString();
		}

		String name(TypeElement te) {
			if (te.getNestingKind() == NestingKind.MEMBER) {
				return name((TypeElement)te.getEnclosingElement()) + "." + te.getSimpleName();
			}
			String fqn = te.getQualifiedName().toString();
			String simple = te.getSimpleName().toString();
			String p = elements.getPackageOf(te).getQualifiedName().toString();
			String owner = taken.get(simple);
			if (owner != null) {
				return owner.equals(fqn) ? simple : fqn;
			}
			taken.put(simple, fqn);
			if (!p.equals("java.lang") && !p.equals(pkg)) {
				imports.add(fqn);
			}
			return simple;
		}

		String type(TypeMirror t) {
			return switch (t.getKind()) {
				case ARRAY -> type(((ArrayType)t).getComponentType()) + "[]";
				case DECLARED -> {
					DeclaredType dt = (DeclaredType)t;
					String base = name((TypeElement)dt.asElement());
					yield dt.getTypeArguments().isEmpty() ? base
						: base + dt.getTypeArguments().stream().map(this::type).collect(Collectors.joining(", ", "<", ">"));
				}
				case WILDCARD -> {
					WildcardType wt = (WildcardType)t;
					yield wt.getExtendsBound() != null ? "? extends " + type(wt.getExtendsBound())
						: wt.getSuperBound() != null ? "? super " + type(wt.getSuperBound()) : "?";
				}
				default -> t.toString();
			};
		}

		String typeParams(List<? extends TypeParameterElement> tps) {
			if (tps.isEmpty()) {
				return "";
			}
			return tps.stream().map(tp -> {
				List<String> bounds = tp.getBounds().stream()
					.filter(b -> !b.toString().equals("java.lang.Object")).map(this::type).toList();
				return tp.getSimpleName() + (bounds.isEmpty() ? "" : " extends " + String.join(" & ", bounds));
			}).collect(Collectors.joining(", ", "<", "> "));
		}

		String modifiers(Element e, boolean inInterface) {
			if (inInterface) {
				return "";
			}
			StringBuilder sb = new StringBuilder();
			for (Modifier m : List.of(Modifier.PUBLIC, Modifier.PROTECTED, Modifier.PRIVATE, Modifier.ABSTRACT, Modifier.STATIC, Modifier.FINAL)) {
				if (e.getModifiers().contains(m)) {
					sb.append(m).append(' ');
				}
			}
			return sb.toString();
		}

		String deprecated(Element e, String indent) {
			return e.getAnnotation(Deprecated.class) != null ? indent + "@Deprecated\n" : "";
		}

		String todoAnnotation(String indent) {
			todos++;
			return indent + "@Todo(\"" + area + "\")\n";
		}

		void type(TypeElement te, String indent) {
			out.append(indent).append("@Generated\n");
			out.append(deprecated(te, indent));
			for (AnnotationMirror am : te.getAnnotationMirrors()) {
				String at = am.getAnnotationType().toString();
				if (at.startsWith("java.lang.annotation.")) {
					out.append(indent).append(annotation(am)).append('\n');
				}
			}
			boolean nested = te.getNestingKind() == NestingKind.MEMBER;
			boolean parentItf = nested && te.getEnclosingElement().getKind().isInterface();
			String kind = switch (te.getKind()) {
				case INTERFACE -> "interface";
				case ANNOTATION_TYPE -> "@interface";
				default -> "class";
			};
			out.append(indent);
			if (forcePublic.contains(te.getQualifiedName().toString())) {
				out.append("public ");
			}
			if (!parentItf) {
				for (Modifier m : List.of(Modifier.PUBLIC, Modifier.PROTECTED, Modifier.PRIVATE, Modifier.STATIC, Modifier.FINAL)) {
					if (te.getModifiers().contains(m)) {
						out.append(m).append(' ');
					}
				}
				if (kind.equals("class") && te.getModifiers().contains(Modifier.ABSTRACT)) {
					out.append("abstract ");
				}
			}
			out.append(kind).append(' ').append(te.getSimpleName());
			String tps = typeParams(te.getTypeParameters());
			if (!tps.isEmpty()) {
				out.append(tps.stripTrailing());
			}
			if (kind.equals("class") && te.getSuperclass().getKind() == TypeKind.DECLARED
				&& !te.getSuperclass().toString().equals("java.lang.Object")) {
				out.append(" extends ").append(type(te.getSuperclass()));
			}
			if (!te.getInterfaces().isEmpty() && !kind.equals("@interface")) {
				out.append(kind.equals("interface") ? " extends " : " implements ")
					.append(te.getInterfaces().stream().map(this::type).collect(Collectors.joining(", ")));
			}
			out.append(" {\n");

			boolean itf = te.getKind().isInterface();
			boolean first = true;
			for (Element e : te.getEnclosedElements()) {
				if (e.getKind() == ElementKind.FIELD && isApi(e)) {
					out.append(field((VariableElement)e, indent + "\t", itf));
					first = false;
				}
			}
			List<ExecutableElement> ctors = te.getEnclosedElements().stream()
				.filter(e -> e.getKind() == ElementKind.CONSTRUCTOR).map(e -> (ExecutableElement)e).toList();
			if (kind.equals("class")) {
				List<ExecutableElement> visible = ctors.stream().filter(c -> !c.getModifiers().contains(Modifier.PRIVATE)).toList();
				if (!first) {
					out.append('\n');
				}
				if (visible.isEmpty()) {
					out.append(indent).append("\tprivate ").append(te.getSimpleName()).append("() {\n")
						.append(superCall(te, indent + "\t")).append(indent).append("\t}\n");
				}
				for (ExecutableElement c : visible) {
					out.append(constructor(c, te.getSimpleName().toString(), indent + "\t", null, true));
				}
				first = false;
			}
			for (Element e : te.getEnclosedElements()) {
				if (e.getKind() == ElementKind.METHOD && isApi(e)) {
					if (!first) {
						out.append('\n');
					}
					out.append(method((ExecutableElement)e, indent + "\t", itf, null, true));
					first = false;
				}
			}
			for (Element e : te.getEnclosedElements()) {
				if (e instanceof TypeElement n && isApi(n)) {
					out.append('\n');
					type(n, indent + "\t");
				}
			}
			out.append(indent).append("}\n");
		}

		String field(VariableElement f, String indent, boolean inInterface) {
			StringBuilder sb = new StringBuilder(deprecated(f, indent));
			Object cv = f.getConstantValue();
			boolean isFinal = f.getModifiers().contains(Modifier.FINAL);
			boolean isStatic = f.getModifiers().contains(Modifier.STATIC);
			sb.append(indent).append(modifiers(f, inInterface));
			if (!inInterface && isFinal && !isStatic && cv == null) {
				// cannot be assigned without a constructor body; LWJGL 2 binaries do not care about final
				sb.setLength(sb.length() - "final ".length());
			}
			sb.append(type(f.asType())).append(' ').append(f.getSimpleName());
			if (cv != null) {
				sb.append(" = ").append(literal(cv, f.asType())).append(";\n");
			} else if (isFinal && isStatic || inInterface) {
				sb.insert(0, todoAnnotation(indent));
				sb.append(" = ").append(defaultValue(f.asType())).append(";\n");
			} else {
				sb.append(";\n");
			}
			return sb.toString();
		}

		String constructor(ExecutableElement c, String simple, String indent, String annotation, boolean stub) {
			StringBuilder sb = new StringBuilder(deprecated(c, indent));
			if (annotation != null) {
				sb.append(indent).append(annotation).append('\n');
			}
			if (stub) {
				sb.append(todoAnnotation(indent));
			}
			sb.append(indent).append(modifiers(c, false)).append(typeParams(c.getTypeParameters())).append(simple)
				.append(parameters(c)).append(throwsClause(c)).append(" {\n");
			if (stub) {
				sb.append(superCall((TypeElement)c.getEnclosingElement(), indent)).append(indent).append("\tthrow new UnsupportedOperationException();\n");
			}
			return sb.append(indent).append("}\n").toString();
		}

		String method(ExecutableElement m, String indent, boolean inInterface, String annotation, boolean stub) {
			return method(m, indent, inInterface, annotation, stub, null);
		}

		/** {@code delegate}: a statement implementing the method; otherwise a stub that throws. */
		String method(ExecutableElement m, String indent, boolean inInterface, String annotation, boolean stub, String delegate) {
			StringBuilder sb = new StringBuilder(deprecated(m, indent));
			if (annotation != null) {
				sb.append(indent).append(annotation).append('\n');
			}
			boolean concrete = !inInterface && !m.getModifiers().contains(Modifier.ABSTRACT) && m.getDefaultValue() == null;
			if (concrete && stub && delegate == null) {
				sb.append(todoAnnotation(indent));
			}
			sb.append(indent).append(modifiers(m, inInterface)).append(typeParams(m.getTypeParameters()))
				.append(type(m.getReturnType())).append(' ').append(m.getSimpleName()).append(parameters(m)).append(throwsClause(m));
			if (m.getDefaultValue() != null) {
				return sb.append(" default ").append(value(m.getDefaultValue())).append(";\n").toString();
			}
			if (inInterface || m.getModifiers().contains(Modifier.ABSTRACT)) {
				return sb.append(";\n").toString();
			}
			if (delegate != null) {
				delegations++;
				sb.append(" {\n").append(indent).append('\t').append(delegate).append('\n');
			} else {
				sb.append(" {\n").append(indent).append("\tthrow new UnsupportedOperationException();\n");
			}
			return sb.append(indent).append("}\n").toString();
		}

		String annotation(AnnotationMirror am) {
			String values = am.getElementValues().entrySet().stream()
				.map(e -> e.getKey().getSimpleName() + " = " + value(e.getValue())).collect(Collectors.joining(", "));
			return "@" + type(am.getAnnotationType()) + (values.isEmpty() ? "" : "(" + values + ")");
		}

		String value(AnnotationValue v) {
			Object o = v.getValue();
			if (o instanceof VariableElement c) {
				return type(c.asType()) + "." + c.getSimpleName();
			} else if (o instanceof TypeMirror t) {
				return type(t) + ".class";
			} else if (o instanceof AnnotationMirror am) {
				return annotation(am);
			} else if (o instanceof List<?> l) {
				return l.stream().map(x -> value((AnnotationValue)x)).collect(Collectors.joining(", ", "{", "}"));
			} else if (o instanceof String) {
				return v.toString();
			}
			return v.toString();
		}

		String parameters(ExecutableElement m) {
			List<? extends VariableElement> ps = m.getParameters();
			StringBuilder sb = new StringBuilder("(");
			for (int i = 0; i < ps.size(); i++) {
				if (i > 0) {
					sb.append(", ");
				}
				TypeMirror t = ps.get(i).asType();
				if (m.isVarArgs() && i == ps.size() - 1) {
					sb.append(type(((ArrayType)t).getComponentType())).append("...");
				} else {
					sb.append(type(t));
				}
				sb.append(' ').append(ps.get(i).getSimpleName());
			}
			return sb.append(')').toString();
		}

		String throwsClause(ExecutableElement m) {
			return m.getThrownTypes().isEmpty() ? ""
				: " throws " + m.getThrownTypes().stream().map(this::type).collect(Collectors.joining(", "));
		}

		/** An explicit super(...) call when the superclass has no no-arg constructor. */
		String superCall(TypeElement te, String indent) {
			TypeMirror sup = te.getSuperclass();
			if (sup.getKind() != TypeKind.DECLARED) {
				return "";
			}
			TypeElement st = (TypeElement)((DeclaredType)sup).asElement();
			List<ExecutableElement> cs = st.getEnclosedElements().stream()
				.filter(e -> e.getKind() == ElementKind.CONSTRUCTOR && !e.getModifiers().contains(Modifier.PRIVATE))
				.map(e -> (ExecutableElement)e).sorted(Comparator.comparingInt(c -> c.getParameters().size())).toList();
			if (cs.isEmpty() || cs.get(0).getParameters().isEmpty()) {
				return "";
			}
			ExecutableType ct = (ExecutableType)types.asMemberOf((DeclaredType)sup, cs.get(0));
			String args = ct.getParameterTypes().stream()
				.map(p -> "(" + type(types.erasure(p)) + ") " + defaultValue(p))
				.collect(Collectors.joining(", "));
			return indent + "\tsuper(" + args + ");\n";
		}
	}

	static String defaultValue(TypeMirror t) {
		return switch (t.getKind()) {
			case BOOLEAN -> "false";
			case CHAR -> "'\\0'";
			case LONG -> "0L";
			case FLOAT -> "0f";
			case DOUBLE -> "0d";
			case BYTE, SHORT, INT -> "0";
			default -> "null";
		};
	}

	static String literal(Object v, TypeMirror t) {
		return switch (t.getKind()) {
			case BOOLEAN -> v.toString();
			case CHAR -> String.format("'\\u%04x'", (int)(Character)v);
			case BYTE -> "(byte) " + v;
			case SHORT -> "(short) " + v;
			case INT -> {
				int i = ((Number)v).intValue();
				yield (i >= 0x100 || i < 0) ? "0x" + Integer.toHexString(i).toUpperCase() : Integer.toString(i);
			}
			case LONG -> {
				long l = ((Number)v).longValue();
				yield (l >= 0x100 || l < 0) ? "0x" + Long.toHexString(l).toUpperCase() + "L" : l + "L";
			}
			case FLOAT -> {
				float f = (Float)v;
				yield Float.isNaN(f) ? "Float.NaN" : Float.isInfinite(f) ? (f > 0 ? "Float.POSITIVE_INFINITY" : "Float.NEGATIVE_INFINITY") : f + "f";
			}
			case DOUBLE -> {
				double d = (Double)v;
				yield Double.isNaN(d) ? "Double.NaN" : Double.isInfinite(d) ? (d > 0 ? "Double.POSITIVE_INFINITY" : "Double.NEGATIVE_INFINITY") : d + "d";
			}
			default -> "\"" + v.toString().replace("\\", "\\\\").replace("\"", "\\\"").replace("\n", "\\n").replace("\r", "\\r").replace("\t", "\\t") + "\"";
		};
	}

}
