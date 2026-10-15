package org.lwjgl.opengl;

import java.nio.FloatBuffer;

public final class NVRegisterCombiners2 {
	public static final int GL_PER_STAGE_CONSTANTS_NV = 0x8535;

	private NVRegisterCombiners2() {
	}

	public static void glCombinerStageParameterNV(int stage, int pname, FloatBuffer params) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glGetCombinerStageParameterNV(int stage, int pname, FloatBuffer params) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
}
