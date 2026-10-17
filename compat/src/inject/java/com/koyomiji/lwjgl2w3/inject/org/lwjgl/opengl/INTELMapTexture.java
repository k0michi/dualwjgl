package com.koyomiji.lwjgl2w3.inject.org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;

// TODO(verify): hand-written; DelegationTest only compares generated members.
public final class INTELMapTexture {

	/** LWJGL 2 takes the mapped length before access; LWJGL 3's explicit-length overload, after layout. */
	public static ByteBuffer glMapTexture2DINTEL(int texture, int level, long length, int access, IntBuffer stride, IntBuffer layout,
		ByteBuffer old_buffer) {
		ByteBuffer buffer = org.lwjgl.opengl.INTELMapTexture.glMapTexture2DINTEL(texture, level, access, stride, layout, length, old_buffer);
		return buffer == null ? null : buffer.order(ByteOrder.nativeOrder());
	}

}
