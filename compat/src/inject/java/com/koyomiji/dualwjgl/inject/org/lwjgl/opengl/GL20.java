package com.koyomiji.dualwjgl.inject.org.lwjgl.opengl;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

// TODO(verify): hand-written; DelegationTest only compares generated members.
public final class GL20 {

	/** LWJGL 2 wraps the pointer in a buffer of {@code result_size} bytes, or returns null for a null pointer. */
	public static ByteBuffer glGetVertexAttribPointer(int index, int pname, long result_size) {
		ByteBuffer buffer = MemoryUtil.memByteBufferSafe(org.lwjgl.opengl.GL20.glGetVertexAttribPointer(index, pname), (int)result_size);
		return buffer == null ? null : buffer.order(ByteOrder.nativeOrder());
	}

	/** LWJGL 2's native took the string's address and length; LWJGL 3's takes arrays of both. */
	public static void glShaderSource(int shader, ByteBuffer string) {
		try (MemoryStack stack = MemoryStack.stackPush()) {
			org.lwjgl.opengl.GL20.glShaderSource(shader, stack.pointers(MemoryUtil.memAddress(string)), stack.ints(string.remaining()));
		}
	}
}
