package com.koyomiji.lwjgl2w3.stubgen;

import com.sun.source.tree.ClassTree;
import com.sun.source.tree.CompilationUnitTree;
import com.sun.source.tree.Tree;
import com.sun.source.util.JavacTask;
import com.sun.source.util.TreePath;
import com.sun.source.util.Trees;

import javax.lang.model.element.*;
import javax.lang.model.type.*;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.*;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * The LWJGL 2.9.3 API, read from its source jars through javac (for parameter names, generics and constant values) and
 * limited to the classes its binary jars ship.
 */
final class Lwjgl2Api {

	final Elements elements;
	final Types types;
	/** The types to reproduce, ordered by name. */
	final List<TypeElement> apiTypes;
	/** Package-private LWJGL 2 types that fragments (in another package) must reference, emitted as public. */
	final Set<String> forcePublic = new TreeSet<>();

	Lwjgl2Api(List<String> sourceJars, String classpath, List<String> binaryJars, Lwjgl3Api lwjgl3) throws IOException {
		Set<String> shipped = new HashSet<>();
		for (String jar : binaryJars) {
			try (ZipFile z = new ZipFile(jar)) {
				Collections.list(z.entries()).stream().map(ZipEntry::getName).filter(n -> n.endsWith(".class"))
					.forEach(n -> shipped.add(n.substring(0, n.length() - 6)));
			}
		}

		Path dir = Files.createTempDirectory("lwjgl2-sources");
		List<File> files = new ArrayList<>();
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
				if (lwjgl3.contains(internalName(te)) && !lwjgl3.contains(internalName(top))
					&& !top.getModifiers().contains(Modifier.PUBLIC) && top.getQualifiedName().toString().startsWith("org.lwjgl.")) {
					forcePublic.add(top.getQualifiedName().toString());
				}
			}
		}
		apiTypes = new ArrayList<>(out);
	}

	/** Types mentioned by {@code te}'s supertypes and API members, including nested API types. */
	private static void references(TypeElement te, Set<TypeElement> refs) {
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

	private static void collect(TypeMirror t, Set<TypeElement> refs, Set<TypeMirror> seen) {
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

	/** Public or protected, or a member of an interface or annotation type. */
	static boolean isApi(Element e) {
		Set<Modifier> m = e.getModifiers();
		return m.contains(Modifier.PUBLIC) || m.contains(Modifier.PROTECTED)
			|| e.getEnclosingElement().getKind() == ElementKind.INTERFACE
			|| e.getEnclosingElement().getKind() == ElementKind.ANNOTATION_TYPE;
	}

	/** 0 private, 1 package, 2 protected, 3 public. */
	static int rank(Set<Modifier> m) {
		return m.contains(Modifier.PUBLIC) ? 3 : m.contains(Modifier.PROTECTED) ? 2 : m.contains(Modifier.PRIVATE) ? 0 : 1;
	}

	String packageOf(TypeElement te) {
		return elements.getPackageOf(te).getQualifiedName().toString();
	}

	String internalName(TypeElement te) {
		return elements.getBinaryName(te).toString().replace('.', '/');
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

}
