package com.koyomiji.lwjgl2w3.stubgen;

import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;

import java.util.HashSet;
import java.util.Set;

/**
 * GL and CL functions LWJGL 3 no longer binds at all (mostly vendor extensions superseded long ago). They are left
 * unsupported the way LWJGL 2 reports a function the driver lacks: {@code IllegalStateException("Function is not
 * supported")}. Only gl/cl entry points count, which LWJGL 2 calls through function pointers; LWJGL 2's own natives
 * (e.g. {@code alGenBuffers2}) are not API.
 */
final class UnsupportedRule implements Rule {

	private final Set<String> lwjgl3Functions = new HashSet<>();

	UnsupportedRule(Lwjgl3Api lwjgl3, NativeTrace trace3) {
		for (ClassNode cn : lwjgl3.all()) {
			for (MethodNode m : cn.methods) {
				NativeTrace.Summary s = trace3.summarize(cn.name, m.name, m.desc, 0);
				if (!s.unresolved) {
					for (String call : s.natives) {
						lwjgl3Functions.add(call.substring(0, call.indexOf('(')));
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
		for (String call : t.calls()) {
			String fn = call.substring(0, call.indexOf('('));
			if (!(fn.startsWith("gl") || fn.startsWith("cl")) || lwjgl3Functions.contains(fn)) {
				return null;
			}
		}
		return "throw new IllegalStateException(\"Function is not supported\");";
	}

}
