package com.koyomiji.lwjgl2w3.inject.org.lwjgl.opengl;

import org.lwjgl.system.MemoryUtil;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

// TODO(verify): hand-written; DelegationTest only compares generated members.
public final class GL11 {

	/** LWJGL 2 wraps the pointer in a buffer of {@code result_size} bytes, or returns null for a null pointer. */
	public static ByteBuffer glGetPointer(int pname, long result_size) {
		ByteBuffer buffer = MemoryUtil.memByteBufferSafe(org.lwjgl.opengl.GL11.glGetPointer(pname), (int)result_size);
		return buffer == null ? null : buffer.order(ByteOrder.nativeOrder());
	}

}
