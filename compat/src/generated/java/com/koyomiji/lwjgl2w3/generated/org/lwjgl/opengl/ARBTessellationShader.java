package com.koyomiji.lwjgl2w3.generated.org.lwjgl.opengl;

import java.nio.FloatBuffer;

public final class ARBTessellationShader {
	public static void glPatchParameter(int pname, FloatBuffer values) {
		org.lwjgl.opengl.ARBTessellationShader.nglPatchParameterfv(pname, org.lwjgl.system.MemoryUtil.memAddressSafe(values));
	}
}
