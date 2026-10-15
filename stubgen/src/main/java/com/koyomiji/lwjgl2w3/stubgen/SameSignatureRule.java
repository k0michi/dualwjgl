package com.koyomiji.lwjgl2w3.stubgen;

import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * R1: LWJGL 3 has a public static method with the same descriptor, and both make the same native calls with the same
 * arguments and return the same thing. In LWJGL 3's class (or a superclass) it has another name (e.g. {@code
 * glFog(int, FloatBuffer)} and {@code glFogfv(int, FloatBuffer)}); in another class of the package it has the same name
 * (e.g. {@code ARBBufferObject.glBufferDataARB} in {@code ARBVertexBufferObject}).
 */
final class SameSignatureRule implements Rule {

	private final Lwjgl3Api lwjgl3;
	private final NativeTrace trace3;

	SameSignatureRule(Lwjgl3Api lwjgl3, NativeTrace trace3) {
		this.lwjgl3 = lwjgl3;
		this.trace3 = trace3;
	}

	@Override
	public String name() {
		return "R1";
	}

	@Override
	public String apply(Target t) {
		List<String> own = lwjgl3.selfAndSupers(t.cls());
		for (String owner3 : lwjgl3.owners(t.cls())) {
			ClassNode cn = lwjgl3.get(owner3);
			if (cn == null) {
				continue;
			}
			boolean inherited = own.contains(owner3);
			List<MethodNode> candidates = cn.methods.stream()
				.filter(c -> c.desc.equals(t.desc()) && c.name.equals(t.name()) != inherited && Lwjgl3Api.isPublicStatic(c))
				.sorted(Comparator.comparing(c -> c.name)).toList();
			for (MethodNode c : candidates) {
				NativeTrace.Summary s3 = trace3.summarize(owner3, c.name, c.desc, 0);
				if (!s3.unresolved && NativeTrace.norm(s3).equals(t.calls()) && NativeTrace.normRet(s3).equals(t.ret())) {
					String args = t.method().getParameters().stream().map(p -> p.getSimpleName().toString()).collect(Collectors.joining(", "));
					return t.call(inherited ? t.cls() : owner3, c.name, args);
				}
			}
		}
		return null;
	}

}
