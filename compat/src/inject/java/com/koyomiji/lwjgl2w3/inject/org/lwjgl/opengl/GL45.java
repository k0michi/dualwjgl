package com.koyomiji.lwjgl2w3.inject.org.lwjgl.opengl;

public final class GL45 {

	/**
	 * LWJGL 2 follows a draft of the spec without {@code drawbuffer} and calls the 5-parameter function with 4 arguments.
	 * Here it is an overload of LWJGL 3's: {@code drawbuffer} must be zero for {@code GL_DEPTH_STENCIL}, the only buffer
	 * this function clears.
	 */
	public static void glClearNamedFramebufferfi(int framebuffer, int buffer, float depth, int stencil) {
		org.lwjgl.opengl.GL45C.glClearNamedFramebufferfi(framebuffer, buffer, 0, depth, stencil);
	}

}
