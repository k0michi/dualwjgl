package com.koyomiji.lwjgl2w3.inject.org.lwjgl.opengl;

public final class ARBDirectStateAccess {

	/** As {@link GL45#glClearNamedFramebufferfi(int, int, float, int)}, which LWJGL 2 reuses here. */
	public static void glClearNamedFramebufferfi(int framebuffer, int buffer, float depth, int stencil) {
		org.lwjgl.opengl.GL45C.glClearNamedFramebufferfi(framebuffer, buffer, 0, depth, stencil);
	}

}
