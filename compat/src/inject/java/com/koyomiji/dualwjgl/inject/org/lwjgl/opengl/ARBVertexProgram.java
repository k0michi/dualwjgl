package com.koyomiji.dualwjgl.inject.org.lwjgl.opengl;

import org.lwjgl.system.MemoryUtil;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

// TODO(verify): hand-written; DelegationTest only compares generated members.
public final class ARBVertexProgram {

	/** LWJGL 2 wraps the pointer in a buffer of {@code result_size} bytes, or returns null for a null pointer. */
	public static ByteBuffer glGetVertexAttribPointerARB(int index, int pname, long result_size) {
		ByteBuffer buffer = MemoryUtil.memByteBufferSafe(org.lwjgl.opengl.ARBVertexProgram.glGetVertexAttribPointerARB(index, pname), (int)result_size);
		return buffer == null ? null : buffer.order(ByteOrder.nativeOrder());
	}

	/** LWJGL 2 asks for {@code GL_PROGRAM_LENGTH_ARB} first and decodes that many bytes. */
	public static String glGetProgramStringARB(int target, int parameterName) {
		int length = org.lwjgl.opengl.ARBVertexProgram.glGetProgramiARB(target, org.lwjgl.opengl.ARBVertexProgram.GL_PROGRAM_LENGTH_ARB);
		ByteBuffer paramString = MemoryUtil.memAlloc(Math.max(length, 1));
		try {
			org.lwjgl.opengl.ARBVertexProgram.glGetProgramStringARB(target, parameterName, paramString);
			return MemoryUtil.memASCII(paramString, length);
		} finally {
			MemoryUtil.memFree(paramString);
		}
	}

}
