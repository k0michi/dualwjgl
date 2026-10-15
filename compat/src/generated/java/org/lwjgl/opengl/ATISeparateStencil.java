package org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Generated;
import com.koyomiji.lwjgl2w3.inject.Todo;

@Generated
public final class ATISeparateStencil {
	public static final int GL_STENCIL_BACK_FUNC_ATI = 0x8800;
	public static final int GL_STENCIL_BACK_FAIL_ATI = 0x8801;
	public static final int GL_STENCIL_BACK_PASS_DEPTH_FAIL_ATI = 0x8802;
	public static final int GL_STENCIL_BACK_PASS_DEPTH_PASS_ATI = 0x8803;

	private ATISeparateStencil() {
	}

	@Todo("gl")
	public static void glStencilOpSeparateATI(int face, int sfail, int dpfail, int dppass) {
		throw new UnsupportedOperationException();
	}

	@Todo("gl")
	public static void glStencilFuncSeparateATI(int frontfunc, int backfunc, int ref, int mask) {
		throw new UnsupportedOperationException();
	}
}
