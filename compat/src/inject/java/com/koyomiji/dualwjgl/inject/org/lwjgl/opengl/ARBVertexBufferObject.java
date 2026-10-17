package com.koyomiji.dualwjgl.inject.org.lwjgl.opengl;

import com.koyomiji.dualwjgl.inject.Hidden;
import org.lwjgl.system.MemoryUtil;

import java.nio.ByteBuffer;

// TODO(verify): hand-written; DelegationTest only compares generated members.
public final class ARBVertexBufferObject {

	/** The buffer's whole store, or null if it is not mapped. Hidden: LWJGL 3's returns the address (same parameters). */
	@Hidden
	public static ByteBuffer glGetBufferPointerARB(int target, int pname) {
		int size = org.lwjgl.opengl.ARBVertexBufferObject.glGetBufferParameteriARB(target, org.lwjgl.opengl.ARBVertexBufferObject.GL_BUFFER_SIZE_ARB);
		return MemoryUtil.memByteBufferSafe(org.lwjgl.opengl.ARBVertexBufferObject.glGetBufferPointerARB(target, pname), size);
	}

}
