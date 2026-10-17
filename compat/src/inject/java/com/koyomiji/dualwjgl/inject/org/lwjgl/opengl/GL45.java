package com.koyomiji.dualwjgl.inject.org.lwjgl.opengl;

import com.koyomiji.dualwjgl.inject.Hidden;
import org.lwjgl.system.MemoryUtil;

import java.nio.ByteBuffer;

// TODO(verify): hand-written; DelegationTest only compares generated members.
public final class GL45 {

	/**
	 * DEVIATION(spec-fix): LWJGL 2 follows a draft of the spec without {@code drawbuffer} and calls the 5-parameter function with 4 arguments.
	 * Here it is an overload of LWJGL 3's: {@code drawbuffer} must be zero for {@code GL_DEPTH_STENCIL}, the only buffer
	 * this function clears.
	 */
	public static void glClearNamedFramebufferfi(int framebuffer, int buffer, float depth, int stencil) {
		org.lwjgl.opengl.GL45.glClearNamedFramebufferfi(framebuffer, buffer, 0, depth, stencil);
	}

	/** The buffer's whole store, or null if it is not mapped. Hidden: LWJGL 3's returns the address (same parameters). */
	@Hidden
	public static ByteBuffer glGetNamedBufferPointer(int buffer, int pname) {
		int size = org.lwjgl.opengl.GL45.glGetNamedBufferParameteri(buffer, org.lwjgl.opengl.GL15.GL_BUFFER_SIZE);
		return MemoryUtil.memByteBufferSafe(org.lwjgl.opengl.GL45.glGetNamedBufferPointer(buffer, pname), size);
	}

}
