package com.koyomiji.lwjgl2w3.inject.org.lwjgl.opengl;

import java.nio.FloatBuffer;

// TODO(verify): hand-written; DelegationTest only compares generated members.
public final class GL40 {

	/** LWJGL 3 checks values for the size pname needs (DEVIATION(checks)). */
	public static void glPatchParameter(int pname, FloatBuffer values) {
		org.lwjgl.opengl.GL40.glPatchParameterfv(pname, values);
	}
}
