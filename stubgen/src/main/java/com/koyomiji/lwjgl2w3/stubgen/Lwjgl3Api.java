package com.koyomiji.lwjgl2w3.stubgen;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldNode;
import org.objectweb.asm.tree.MethodNode;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/** The LWJGL 3 API, read from its jars with ASM. Class names are internal names. */
final class Lwjgl3Api {

	private final Map<String, ClassNode> classes = new HashMap<>();

	Lwjgl3Api(List<String> jars) throws IOException {
		for (String jar : jars) {
			try (ZipFile z = new ZipFile(jar)) {
				for (ZipEntry e : Collections.list(z.entries())) {
					if (!e.getName().endsWith(".class") || e.getName().startsWith("META-INF/")) {
						continue;
					}
					try (InputStream in = z.getInputStream(e)) {
						ClassNode cn = new ClassNode();
						new ClassReader(in).accept(cn, ClassReader.SKIP_CODE | ClassReader.SKIP_DEBUG | ClassReader.SKIP_FRAMES);
						classes.put(cn.name, cn);
					}
				}
			}
		}
	}

	Collection<ClassNode> all() {
		return classes.values();
	}

	boolean contains(String cls) {
		return classes.containsKey(cls);
	}

	ClassNode get(String cls) {
		return classes.get(cls);
	}

	MethodNode declared(String cls, String name, String desc) {
		ClassNode cn = classes.get(cls);
		return cn == null ? null : cn.methods.stream().filter(m -> m.name.equals(name) && m.desc.equals(desc)).findFirst().orElse(null);
	}

	/** Superclasses and interfaces, transitively. */
	List<String> supers(String cls) {
		List<String> out = new ArrayList<>();
		Deque<String> todo = new ArrayDeque<>(List.of(cls));
		while (!todo.isEmpty()) {
			ClassNode cn = classes.get(todo.poll());
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

	/** {@code cls} followed by its supertypes: where a call through {@code cls} can resolve. */
	List<String> selfAndSupers(String cls) {
		List<String> out = new ArrayList<>();
		out.add(cls);
		out.addAll(supers(cls));
		return out;
	}

	/**
	 * Where LWJGL 3 may implement a function of {@code cls}: {@code cls} and its supertypes, its {@code C} class, then
	 * the other public classes of its package, because LWJGL 3 moved functions between classes (ARBProgram's into
	 * ARBVertexProgram, EFX10's into EXTEfx, EXTGpuShader4's into EXTGPUShader4). Same name ignoring case first.
	 */
	List<String> owners(String cls) {
		List<String> out = selfAndSupers(cls);
		if (contains(cls + "C")) {
			out.add(cls + "C");
		}
		String pkg = cls.substring(0, cls.lastIndexOf('/') + 1);
		String simple = cls.substring(pkg.length());
		classes.values().stream()
			.filter(cn -> cn.name.startsWith(pkg) && cn.name.indexOf('/', pkg.length()) < 0 && !cn.name.contains("$")
				&& (cn.access & Opcodes.ACC_PUBLIC) != 0 && !out.contains(cn.name))
			.map(cn -> cn.name)
			.sorted(Comparator.comparing((String n) -> !n.substring(pkg.length()).equalsIgnoreCase(simple)).thenComparing(n -> n))
			.forEach(out::add);
		return out;
	}

	/** Methods {@code cls} declares or inherits, as name + descriptor. */
	Set<String> methods(String cls) {
		Set<String> out = new HashSet<>();
		classes.get(cls).methods.forEach(m -> out.add(m.name + m.desc));
		for (String s : supers(cls)) {
			ClassNode cn = classes.get(s);
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

	/** Field names {@code cls} declares or inherits. */
	Set<String> fields(String cls) {
		Set<String> out = new HashSet<>();
		classes.get(cls).fields.forEach(f -> out.add(f.name));
		for (String s : supers(cls)) {
			ClassNode cn = classes.get(s);
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

	static boolean isPublicStatic(MethodNode m) {
		return (m.access & (Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC)) == (Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC);
	}

	/** 0 private, 1 package, 2 protected, 3 public. */
	static int rank(int access) {
		return (access & Opcodes.ACC_PUBLIC) != 0 ? 3 : (access & Opcodes.ACC_PROTECTED) != 0 ? 2 : (access & Opcodes.ACC_PRIVATE) != 0 ? 0 : 1;
	}

}
