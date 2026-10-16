package com.koyomiji.lwjgl2w3.inject.org.lwjgl.opengl;

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

}
