package com.koyomiji.lwjgl2w3.inject.org.lwjgl.opengl;

public final class ARBDirectStateAccess {

	/** As {@link GL45#glClearNamedFramebufferfi(int, int, float, int)}, through LWJGL 3's ARB_direct_state_access binding. */
	public static void glClearNamedFramebufferfi(int framebuffer, int buffer, float depth, int stencil) {
		org.lwjgl.opengl.ARBDirectStateAccess.glClearNamedFramebufferfi(framebuffer, buffer, 0, depth, stencil);
	}

}
