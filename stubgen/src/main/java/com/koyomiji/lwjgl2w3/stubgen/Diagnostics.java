package com.koyomiji.lwjgl2w3.stubgen;

import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Why no rule implemented a static method, one TSV row each: class, method, descriptor, reason, LWJGL 2 trace, and the
 * LWJGL 3 methods that call the same native functions (what a next rule would map to).
 */
final class Diagnostics {

	private final Lwjgl3Api lwjgl3;
	private final NativeTrace trace3;
	private final List<String> rows = new ArrayList<>();

	Diagnostics(Lwjgl3Api lwjgl3, NativeTrace trace3) {
		this.lwjgl3 = lwjgl3;
		this.trace3 = trace3;
	}

	/** The LWJGL 2 method could not be traced, or makes no native call. */
	void untraced(String cls, String name, String desc, NativeTrace.Summary s2) {
		rows.add(String.join("\t", cls, name, desc, s2.unresolved ? "unresolved" : "no-native", NativeTrace.fmt(s2), ""));
	}

	void unmatched(Rule.Target t, NativeTrace.Summary s2) {
		String fns = NativeTrace.fnNames(t.calls());
		List<String> near = new ArrayList<>();
		for (String owner3 : lwjgl3.selfAndSupers(t.cls())) {
			ClassNode cn = lwjgl3.get(owner3);
			if (cn == null) {
				continue;
			}
			for (MethodNode c : cn.methods) {
				if (!Lwjgl3Api.isPublicStatic(c)) {
					continue;
				}
				NativeTrace.Summary s3 = trace3.summarize(owner3, c.name, c.desc, 0);
				if (!s3.unresolved && NativeTrace.fnNames(NativeTrace.norm(s3)).equals(fns)) {
					near.add(c.name + c.desc + " = " + NativeTrace.fmt(s3));
				}
			}
		}
		rows.add(String.join("\t", t.cls(), t.name(), t.desc(), near.isEmpty() ? "no-same-fn" : "same-fn",
			NativeTrace.fmt(s2), String.join(" || ", near)));
	}

	void write(Path file) throws IOException {
		Files.createDirectories(file.getParent());
		Files.write(file, rows);
	}

}
