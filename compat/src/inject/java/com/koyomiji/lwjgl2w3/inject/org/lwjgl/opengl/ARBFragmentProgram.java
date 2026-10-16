package com.koyomiji.lwjgl2w3.inject.org.lwjgl.opengl;

import org.lwjgl.opengl.ARBVertexProgram;
import org.lwjgl.system.MemoryUtil;

import java.nio.ByteBuffer;

// TODO(verify): hand-written; DelegationTest only compares generated members.
/** LWJGL 2's ARBProgram function, which LWJGL 3 binds in ARBVertexProgram. */
public final class ARBFragmentProgram {

	/** LWJGL 2 asks for {@code GL_PROGRAM_LENGTH_ARB} first and decodes that many bytes. */
	public static String glGetProgramStringARB(int target, int parameterName) {
		int length = ARBVertexProgram.glGetProgramiARB(target, ARBVertexProgram.GL_PROGRAM_LENGTH_ARB);
		ByteBuffer paramString = MemoryUtil.memAlloc(Math.max(length, 1));
		try {
			ARBVertexProgram.glGetProgramStringARB(target, parameterName, paramString);
			return MemoryUtil.memASCII(paramString, length);
		} finally {
			MemoryUtil.memFree(paramString);
		}
	}

}
