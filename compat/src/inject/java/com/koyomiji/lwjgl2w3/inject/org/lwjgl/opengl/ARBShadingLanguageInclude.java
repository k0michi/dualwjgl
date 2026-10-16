package com.koyomiji.lwjgl2w3.inject.org.lwjgl.opengl;

import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;

import java.nio.IntBuffer;

// TODO(verify): hand-written; DelegationTest only compares generated members.
public final class ARBShadingLanguageInclude {

	/** Each path as ASCII with its length, as LWJGL 2 and LWJGL 3 (GLcharASCII) encode it. */
	public static void glCompileShaderIncludeARB(int shader, CharSequence[] path) {
		if (path == null || path.length == 0) {
			throw new IllegalArgumentException("Invalid array");
		}
		try (MemoryStack stack = MemoryStack.stackPush()) {
			PointerBuffer pointers = stack.callocPointer(path.length);
			IntBuffer lengths = stack.mallocInt(path.length);
			try {
				for (int i = 0; i < path.length; i++) {
					// null-terminated only so that an empty path still gets memory
					pointers.put(i, MemoryUtil.memASCII(path[i], true));
					lengths.put(i, path[i].length());
				}
				org.lwjgl.opengl.ARBShadingLanguageInclude.glCompileShaderIncludeARB(shader, pointers, lengths);
			} finally {
				for (int i = 0; i < path.length; i++) {
					MemoryUtil.nmemFree(pointers.get(i));
				}
			}
		}
	}

}
