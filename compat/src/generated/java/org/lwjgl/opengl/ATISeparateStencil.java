package org.lwjgl.opengl;

import com.koyomiji.dualwjgl.inject.Generated;

@Generated
public final class ATISeparateStencil {
	public static final int GL_STENCIL_BACK_FUNC_ATI = 0x8800;
	public static final int GL_STENCIL_BACK_FAIL_ATI = 0x8801;
	public static final int GL_STENCIL_BACK_PASS_DEPTH_FAIL_ATI = 0x8802;
	public static final int GL_STENCIL_BACK_PASS_DEPTH_PASS_ATI = 0x8803;

	private ATISeparateStencil() {
	}

	public static void glStencilOpSeparateATI(int face, int sfail, int dpfail, int dppass) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glStencilFuncSeparateATI(int frontfunc, int backfunc, int ref, int mask) {
		throw new IllegalStateException("Function is not supported");
	}
}
