package com.koyomiji.lwjgl2w3.inject.org.lwjgl.opengl;

import org.lwjgl.system.MemoryUtil;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

// TODO(verify): hand-written; DelegationTest only compares generated members.
public final class EXTDirectStateAccess {

	/**
	 * DEVIATION(unbound): LWJGL 3 does not bind glGetNamedBufferPointervEXT: unsupported, as LWJGL 2 reports a function
	 * the driver lacks.
	 */
	public static ByteBuffer glGetNamedBufferPointerEXT(int buffer, int pname) {
		throw new IllegalStateException("Function is not supported");
	}

	/** LWJGL 2 wraps the pointer in a buffer of {@code result_size} bytes, or returns null for a null pointer. */
	public static ByteBuffer glGetPointerEXT(int pname, int index, long result_size) {
		ByteBuffer buffer = MemoryUtil.memByteBufferSafe(org.lwjgl.opengl.EXTDirectStateAccess.glGetPointeriEXT(pname, index), (int)result_size);
		return buffer == null ? null : buffer.order(ByteOrder.nativeOrder());
	}

	public static ByteBuffer glGetPointerIndexedEXT(int pname, int index, long result_size) {
		ByteBuffer buffer = MemoryUtil.memByteBufferSafe(org.lwjgl.opengl.EXTDirectStateAccess.glGetPointerIndexedEXT(pname, index), (int)result_size);
		return buffer == null ? null : buffer.order(ByteOrder.nativeOrder());
	}

	public static ByteBuffer glGetVertexArrayPointerEXT(int vaobj, int pname, long result_size) {
		ByteBuffer buffer = MemoryUtil.memByteBufferSafe(org.lwjgl.opengl.EXTDirectStateAccess.glGetVertexArrayPointerEXT(vaobj, pname), (int)result_size);
		return buffer == null ? null : buffer.order(ByteOrder.nativeOrder());
	}

	public static ByteBuffer glGetVertexArrayPointerEXT(int vaobj, int index, int pname, long result_size) {
		ByteBuffer buffer = MemoryUtil.memByteBufferSafe(org.lwjgl.opengl.EXTDirectStateAccess.glGetVertexArrayPointeriEXT(vaobj, index, pname), (int)result_size);
		return buffer == null ? null : buffer.order(ByteOrder.nativeOrder());
	}

	/** LWJGL 2 asks for {@code GL_PROGRAM_LENGTH_ARB} first and decodes that many bytes. */
	public static String glGetNamedProgramStringEXT(int program, int target, int pname) {
		int length = org.lwjgl.opengl.EXTDirectStateAccess.glGetNamedProgramiEXT(program, target, org.lwjgl.opengl.ARBVertexProgram.GL_PROGRAM_LENGTH_ARB);
		ByteBuffer string = MemoryUtil.memAlloc(Math.max(length, 1));
		try {
			org.lwjgl.opengl.EXTDirectStateAccess.glGetNamedProgramStringEXT(program, target, pname, string);
			return MemoryUtil.memASCII(string, length);
		} finally {
			MemoryUtil.memFree(string);
		}
	}

}
