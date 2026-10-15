package com.koyomiji.lwjgl2w3.stubgen;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Command line: {@code --name value} pairs, see stubgen/build.gradle. */
record Options(
	List<String> sources, String classpath, List<String> lwjgl3, Path main, Path replace, Path generated,
	Path injectClasses, Path diagnostics
) {

	static Options parse(String[] args) {
		Map<String, String> a = new HashMap<>();
		for (int i = 0; i < args.length; i += 2) {
			a.put(args[i], args[i + 1]);
		}
		return new Options(
			split(a.get("--sources")), a.get("--classpath"), split(a.get("--lwjgl3")),
			Paths.get(a.get("--main")), Paths.get(a.get("--replace")), Paths.get(a.get("--generated")),
			Paths.get(a.get("--inject-classes")), a.containsKey("--diagnostics") ? Paths.get(a.get("--diagnostics")) : null);
	}

	private static List<String> split(String paths) {
		return Arrays.asList(paths.split(File.pathSeparator));
	}

	/** The LWJGL 2 binary jars on the classpath (not jinput etc.): the API to reproduce. */
	List<String> lwjgl2Jars() {
		return split(classpath).stream().filter(j -> Paths.get(j).getFileName().toString().startsWith("lwjgl")).toList();
	}

}
