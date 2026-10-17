package com.koyomiji.lwjgl2w3.inject.org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Hidden;
import org.lwjgl.BufferChecks;

import java.nio.FloatBuffer;

public final class NVPathRendering {

	/**
	 * DEVIATION(spec-fix): LWJGL 2 declares {@code units} as an int and passes it where the function takes a float. Here it is an overload of
	 * LWJGL 3's that converts it; hidden, so that LWJGL 3 source passing an int still calls the float version.
	 */
	@Hidden
	public static void glPathStencilDepthOffsetNV(float factor, int units) {
		org.lwjgl.opengl.NVPathRendering.glPathStencilDepthOffsetNV(factor, (float)units);
	}

	/**
	 * LWJGL 2 derives the component count from the coefficients, as GLChecks.calculatePathTextGenCoeffsPerComponent did;
	 * LWJGL 3 takes it. GL_NONE takes no coefficients: LWJGL 2 allowed null there, which LWJGL 3's buffer overload does not.
	 */
	public static void glPathTexGenNV(int texCoordSet, int genMode, FloatBuffer coeffs) {
		if (coeffs != null) {
			BufferChecks.checkDirect(coeffs);
		}
		if (genMode == org.lwjgl.opengl.GL11.GL_NONE) {
			org.lwjgl.opengl.NVPathRendering.glPathTexGenNV(texCoordSet, genMode, 0, new float[0]);
			return;
		}
		int components = coeffs.remaining() / coefficientsPerComponent(genMode);
		org.lwjgl.opengl.NVPathRendering.glPathTexGenNV(texCoordSet, genMode, components, coeffs);
	}

	/** LWJGL 2's GLChecks.calculatePathGenCoeffsPerComponent. */
	private static int coefficientsPerComponent(int genMode) {
		switch (genMode) {
			case org.lwjgl.opengl.GL11.GL_OBJECT_LINEAR:
			case org.lwjgl.opengl.NVPathRendering.GL_PATH_OBJECT_BOUNDING_BOX_NV:
				return 3;
			case org.lwjgl.opengl.GL11.GL_EYE_LINEAR:
				return 4;
			default:
				throw new IllegalArgumentException("Unsupported gen mode: " + genMode);
		}
	}

}
