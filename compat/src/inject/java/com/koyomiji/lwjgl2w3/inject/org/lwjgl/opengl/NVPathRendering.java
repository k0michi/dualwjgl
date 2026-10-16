package com.koyomiji.lwjgl2w3.inject.org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Hidden;

public final class NVPathRendering {

	/**
	 * LWJGL 2 declares {@code units} as an int and passes it where the function takes a float. Here it is an overload of
	 * LWJGL 3's that converts it; hidden, so that LWJGL 3 source passing an int still calls the float version.
	 */
	@Hidden
	public static void glPathStencilDepthOffsetNV(float factor, int units) {
		org.lwjgl.opengl.NVPathRendering.glPathStencilDepthOffsetNV(factor, (float)units);
	}

}
