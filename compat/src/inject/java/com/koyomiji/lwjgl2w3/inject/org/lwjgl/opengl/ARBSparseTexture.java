package com.koyomiji.lwjgl2w3.inject.org.lwjgl.opengl;

public final class ARBSparseTexture {

	/**
	 * DEVIATION(spec-fix): LWJGL 2 declares the EXT_direct_state_access variant with a {@code target} the function does not take, and calls it
	 * with 10 arguments. Here it is an overload of LWJGL 3's that drops {@code target}: the texture name identifies it.
	 */
	public static void glTexturePageCommitmentEXT(int texture, int target, int level, int xoffset, int yoffset, int zoffset,
	                                              int width, int height, int depth, boolean commit) {
		org.lwjgl.opengl.ARBSparseTexture.glTexturePageCommitmentEXT(texture, level, xoffset, yoffset, zoffset, width, height, depth, commit);
	}

}
