package com.koyomiji.dualwjgl.stubgen;

import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * DEVIATION(unbound): GL and CL functions LWJGL 3 no longer binds at all (mostly vendor extensions superseded long ago). They are left
 * unsupported the way LWJGL 2 reports a function the driver lacks: {@code IllegalStateException("Function is not
 * supported")}. Only gl/cl entry points count, which LWJGL 2 calls through function pointers; LWJGL 2's own natives
 * (e.g. {@code alGenBuffers2}) are not API. Only LWJGL 3's binding in the same package counts: OpenGL ES binding
 * {@code glMultiDrawArraysEXT} does not make the desktop OpenGL one supported.
 */
final class UnsupportedRule implements Rule {

	/** package -> native functions LWJGL 3 binds there */
	private final Map<String, Set<String>> lwjgl3Functions = new HashMap<>();

	UnsupportedRule(Lwjgl3Api lwjgl3, NativeTrace trace3) {
		for (ClassNode cn : lwjgl3.all()) {
			for (MethodNode m : cn.methods) {
				NativeTrace.Summary s = trace3.summarize(cn.name, m.name, m.desc, 0);
				if (!s.unresolved) {
					Set<String> fns = lwjgl3Functions.computeIfAbsent(packageOf(cn.name), k -> new HashSet<>());
					for (String call : s.natives) {
						fns.add(call.substring(0, call.indexOf('(')));
					}
				}
			}
		}
	}

	@Override
	public String name() {
		return "unsupported";
	}

	@Override
	public boolean unsupported() {
		return true;
	}

	@Override
	public String apply(Target t) {
		Set<String> bound = lwjgl3Functions.getOrDefault(packageOf(t.cls()), Set.of());
		for (String call : t.calls()) {
			String fn = call.substring(0, call.indexOf('('));
			if (!(fn.startsWith("gl") || fn.startsWith("cl")) || bound.contains(fn)) {
				return null;
			}
		}
		return "throw new IllegalStateException(\"Function is not supported\");";
	}

	private static String packageOf(String cls) {
		return cls.substring(0, cls.lastIndexOf('/'));
	}

}
