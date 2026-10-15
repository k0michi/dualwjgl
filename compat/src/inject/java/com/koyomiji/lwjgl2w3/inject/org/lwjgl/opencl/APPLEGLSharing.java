package com.koyomiji.lwjgl2w3.inject.org.lwjgl.opencl;

import java.nio.ByteBuffer;
import org.lwjgl.PointerBuffer;
import org.lwjgl.opencl.CLContext;

public final class APPLEGLSharing {
	public static int clGetGLContextInfoAPPLE(CLContext context, PointerBuffer platform_gl_ctx, int param_name, ByteBuffer param_value, PointerBuffer param_value_size_ret) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}
}
