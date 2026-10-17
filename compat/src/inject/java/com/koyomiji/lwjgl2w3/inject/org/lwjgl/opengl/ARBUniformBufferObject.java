package com.koyomiji.lwjgl2w3.inject.org.lwjgl.opengl;



// TODO(verify): hand-written; DelegationTest only compares generated members.
public final class ARBUniformBufferObject {

	/** LWJGL 2's deprecated name for glGetActiveUniformsi. */
	@Deprecated
	public static int glGetActiveUniforms(int program, int uniformIndex, int pname) {
		return org.lwjgl.opengl.ARBUniformBufferObject.glGetActiveUniformsi(program, uniformIndex, pname);
	}

}
