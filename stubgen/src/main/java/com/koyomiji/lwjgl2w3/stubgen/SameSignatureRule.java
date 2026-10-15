package com.koyomiji.lwjgl2w3.stubgen;

import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * R1: LWJGL 3's class (or a superclass) has a public static method with the same descriptor under another name, and
 * both make the same native calls with the same arguments and return the same thing (e.g. {@code glFog(int,
 * FloatBuffer)} and {@code glFogfv(int, FloatBuffer)}).
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
		for (String owner3 : lwjgl3.selfAndSupers(t.cls())) {
			ClassNode cn = lwjgl3.get(owner3);
			if (cn == null) {
				continue;
			}
			List<MethodNode> candidates = cn.methods.stream()
				.filter(c -> c.desc.equals(t.desc()) && !c.name.equals(t.name()) && Lwjgl3Api.isPublicStatic(c))
				.sorted(Comparator.comparing(c -> c.name)).toList();
			for (MethodNode c : candidates) {
				NativeTrace.Summary s3 = trace3.summarize(owner3, c.name, c.desc, 0);
				if (!s3.unresolved && NativeTrace.norm(s3).equals(t.calls()) && NativeTrace.normRet(s3).equals(t.ret())) {
					String args = t.method().getParameters().stream().map(p -> p.getSimpleName().toString()).collect(Collectors.joining(", "));
					return t.call(t.cls(), c.name, args);
				}
			}
		}
		return null;
	}

}
