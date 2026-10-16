package com.koyomiji.lwjgl2w3.inject.org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Hidden;
import org.lwjgl.system.MemoryUtil;

import java.nio.ByteBuffer;

// TODO(verify): hand-written; DelegationTest only compares generated members.
public final class GL15 {

	/** The buffer's whole store, or null if it is not mapped. Hidden: LWJGL 3's returns the address (same parameters). */
	@Hidden
	public static ByteBuffer glGetBufferPointer(int target, int pname) {
		int size = org.lwjgl.opengl.GL15.glGetBufferParameteri(target, org.lwjgl.opengl.GL15.GL_BUFFER_SIZE);
		return MemoryUtil.memByteBufferSafe(org.lwjgl.opengl.GL15.glGetBufferPointer(target, pname), size);
	}

}
