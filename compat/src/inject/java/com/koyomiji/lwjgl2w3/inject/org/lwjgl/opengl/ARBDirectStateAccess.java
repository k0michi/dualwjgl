package com.koyomiji.lwjgl2w3.inject.org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Hidden;
import org.lwjgl.system.MemoryUtil;

import java.nio.ByteBuffer;

// TODO(verify): hand-written; DelegationTest only compares generated members.
public final class ARBDirectStateAccess {

	/** As {@link GL45#glClearNamedFramebufferfi(int, int, float, int)}, through LWJGL 3's ARB_direct_state_access binding. */
	public static void glClearNamedFramebufferfi(int framebuffer, int buffer, float depth, int stencil) {
		org.lwjgl.opengl.ARBDirectStateAccess.glClearNamedFramebufferfi(framebuffer, buffer, 0, depth, stencil);
	}

	/** The buffer's whole store, or null if it is not mapped. Hidden: LWJGL 3's returns the address (same parameters). */
	@Hidden
	public static ByteBuffer glGetNamedBufferPointer(int buffer, int pname) {
		int size = org.lwjgl.opengl.ARBDirectStateAccess.glGetNamedBufferParameteri(buffer, org.lwjgl.opengl.GL15.GL_BUFFER_SIZE);
		return MemoryUtil.memByteBufferSafe(org.lwjgl.opengl.ARBDirectStateAccess.glGetNamedBufferPointer(buffer, pname), size);
	}

}
