package com.koyomiji.dualwjgl.stubgen;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AnnotationNode;
import org.objectweb.asm.tree.ClassNode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/** What hand-written compat code already provides, so stubgen neither generates nor reports it. */
final class HandWritten {

	private final Path mainDir;
	private final Path copiedDir;
	private final Path replaceDir;
	/** LWJGL 3 class -> constructor descriptors that @Into fragments add */
	private final Map<String, Set<String>> constructors = new HashMap<>();

	HandWritten(Path mainDir, Path copiedDir, Path replaceDir, Path injectClasses) throws IOException {
		this.mainDir = mainDir;
		this.copiedDir = copiedDir;
		this.replaceDir = replaceDir;
		if (!Files.isDirectory(injectClasses)) {
			return;
		}
		List<Path> files;
		try (var s = Files.walk(injectClasses)) {
			files = s.filter(f -> f.toString().endsWith(".class")).toList();
		}
		for (Path f : files) {
			ClassNode cn = new ClassNode();
			new ClassReader(Files.readAllBytes(f)).accept(cn, ClassReader.SKIP_CODE);
			if (cn.invisibleAnnotations == null) {
				continue;
			}
			for (AnnotationNode an : cn.invisibleAnnotations) {
				if (an.desc.equals("L" + StubGen.INJECT_PACKAGE.replace('.', '/') + "/Into;")) {
					String target = ((Type)an.values.get(1)).getInternalName();
					cn.methods.stream().filter(m -> m.name.equals("<init>"))
						.forEach(m -> constructors.computeIfAbsent(target, k -> new HashSet<>()).add(m.desc));
				}
			}
		}
	}

	/** A whole LWJGL 2-only class in compat/src/main, or one of the LWJGL 2 sources compat compiles unchanged. */
	boolean wholeClass(String pkg, String simple) {
		Path file = Path.of(pkg.replace('.', '/'), simple + ".java");
		return Files.exists(mainDir.resolve(file)) || Files.exists(copiedDir.resolve(file));
	}

	/** A class that replaces LWJGL 3's in compat/src/replace. */
	boolean replaced(String pkg, String simple) {
		return Files.exists(replaceDir.resolve(pkg.replace('.', '/')).resolve(simple + ".java"));
	}

	boolean addsConstructor(String cls, String desc) {
		return constructors.getOrDefault(cls, Set.of()).contains(desc);
	}

}
