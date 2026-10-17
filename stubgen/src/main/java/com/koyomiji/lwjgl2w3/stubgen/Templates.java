package com.koyomiji.lwjgl2w3.stubgen;

import com.sun.source.tree.*;
import com.sun.source.util.JavacTask;

import javax.tools.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * LWJGL 2's generator templates ({@code src/templates} of the LWJGL 2 source archive): the annotated interfaces its
 * generator expanded into the binding classes. Only parsed, never compiled, so annotations are kept as source text.
 */
final class Templates {

	/** An annotation: simple name and arguments ({@code value} for the single-argument form), string literals unquoted. */
	record Ann(String name, Map<String, String> args) {

		String value() {
			return args.get("value");
		}

		String get(String key, String otherwise) {
			return args.getOrDefault(key, otherwise);
		}

		boolean flag(String key, boolean otherwise) {
			String v = args.get(key);
			return v == null ? otherwise : v.equals("true");
		}

	}

	/** A template parameter; {@code type} is the source type, e.g. {@code IntBuffer}, {@code Buffer}, {@code int}. */
	record Param(String name, String type, Map<String, Ann> anns) {

		Ann ann(String name) {
			return anns.get(name);
		}

		boolean has(String name) {
			return anns.containsKey(name);
		}

	}

	record Method(String name, String ret, Map<String, Ann> anns, List<Param> params, Iface owner) {

		Ann ann(String name) {
			return anns.get(name);
		}

		boolean has(String name) {
			return anns.containsKey(name);
		}

		/** The C function: {@code @Alternate} points at the main method, whose name is the function. */
		String function() {
			Ann alt = ann("Alternate");
			return alt == null ? name : alt.value();
		}

		Param param(String name) {
			return params.stream().filter(p -> p.name.equals(name)).findFirst().orElse(null);
		}

	}

	record Iface(String pkg, String name, List<String> supers, Map<String, Ann> anns, List<Method> methods) {

		/** The generated class: {@code @Extension(className)}, or the name with {@code _x} turned into {@code X}. */
		String className() {
			Ann ext = anns.get("Extension");
			if (ext != null && !ext.get("className", "").isEmpty()) {
				return ext.get("className", "");
			}
			StringBuilder out = new StringBuilder();
			for (int i = 0; i < name.length(); i++) {
				char c = name.charAt(i);
				if (c == '_' && i + 1 < name.length()) {
					out.append(Character.toUpperCase(name.charAt(++i)));
				} else {
					out.append(c);
				}
			}
			return out.toString();
		}

		/** What {@code @StripPostfix} keeps at the end of a name: the extension suffix (e.g. {@code ARB}). */
		String extensionPostfix() {
			Ann ext = anns.get("Extension");
			if (ext != null && ext.args().containsKey("postfix")) {
				return ext.get("postfix", "");
			}
			int u = name.indexOf('_');
			return u < 0 ? "" : name.substring(0, u);
		}

	}

	/** Internal name of the generated class -> its template. */
	private final Map<String, Iface> byClass = new HashMap<>();
	/** Package/interface name -> template, for super-interfaces. */
	private final Map<String, Iface> byName = new HashMap<>();

	Templates(Path archive, Set<String> packages) throws IOException {
		List<JavaFileObject> files = new ArrayList<>();
		try (ZipFile z = new ZipFile(archive.toFile())) {
			for (ZipEntry e : Collections.list(z.entries())) {
				String n = e.getName();
				int at = n.indexOf("/src/templates/");
				if (at < 0 || !n.endsWith(".java")) {
					continue;
				}
				String rel = n.substring(at + "/src/templates/".length());
				if (!packages.contains(rel.substring(0, rel.lastIndexOf('/')))) {
					continue;
				}
				String text;
				try (InputStream in = z.getInputStream(e)) {
					text = new String(in.readAllBytes(), StandardCharsets.UTF_8);
				}
				files.add(new SimpleJavaFileObject(URI.create("string:///" + rel), JavaFileObject.Kind.SOURCE) {
					@Override
					public CharSequence getCharContent(boolean ignoreEncodingErrors) {
						return text;
					}
				});
			}
		}
		JavaCompiler jc = ToolProvider.getSystemJavaCompiler();
		JavacTask task = (JavacTask)jc.getTask(null, null, d -> {
		}, List.of("-proc:none"), null, files);
		for (CompilationUnitTree cu : task.parse()) {
			String pkg = cu.getPackageName() == null ? "" : cu.getPackageName().toString().replace('.', '/');
			for (Tree t : cu.getTypeDecls()) {
				if (t instanceof ClassTree ct && ct.getKind() == Tree.Kind.INTERFACE) {
					Iface iface = iface(pkg, ct);
					byName.put(pkg + "/" + iface.name(), iface);
					byClass.put(pkg + "/" + iface.className(), iface);
				}
			}
		}
	}

	/** The template generating LWJGL 2 class {@code cls} (internal name), or null. */
	Iface of(String cls) {
		return byClass.get(cls);
	}

	/** {@code iface}'s methods, then those of its super-interfaces. */
	List<Method> methods(Iface iface) {
		List<Method> out = new ArrayList<>(iface.methods());
		for (String s : iface.supers()) {
			Iface sup = byName.get(iface.pkg() + "/" + s);
			if (sup != null) {
				out.addAll(methods(sup));
			}
		}
		return out;
	}

	private static Iface iface(String pkg, ClassTree ct) {
		List<String> supers = ct.getImplementsClause().stream().map(Tree::toString).toList();
		List<Method> methods = new ArrayList<>();
		Iface iface = new Iface(pkg, ct.getSimpleName().toString(), supers, anns(ct.getModifiers()), methods);
		for (Tree m : ct.getMembers()) {
			if (m instanceof MethodTree mt) {
				List<Param> params = new ArrayList<>();
				for (VariableTree v : mt.getParameters()) {
					params.add(new Param(v.getName().toString(), v.getType().toString(), anns(v.getModifiers())));
				}
				methods.add(new Method(mt.getName().toString(), mt.getReturnType().toString(), anns(mt.getModifiers()), params, iface));
			}
		}
		return iface;
	}

	private static Map<String, Ann> anns(ModifiersTree mods) {
		Map<String, Ann> out = new LinkedHashMap<>();
		for (AnnotationTree a : mods.getAnnotations()) {
			String name = a.getAnnotationType().toString();
			name = name.substring(name.lastIndexOf('.') + 1);
			Map<String, String> args = new LinkedHashMap<>();
			for (ExpressionTree e : a.getArguments()) {
				if (e instanceof AssignmentTree as) {
					args.put(as.getVariable().toString(), text(as.getExpression()));
				} else {
					args.put("value", text(e));
				}
			}
			out.put(name, new Ann(name, args));
		}
		return out;
	}

	/** A string literal's value (concatenations joined), otherwise the source text. */
	private static String text(ExpressionTree e) {
		if (e instanceof LiteralTree l) {
			return String.valueOf(l.getValue());
		}
		if (e instanceof BinaryTree b && b.getKind() == Tree.Kind.PLUS) {
			return text(b.getLeftOperand()) + text(b.getRightOperand());
		}
		return e.toString();
	}

}
