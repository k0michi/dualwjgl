package com.koyomiji.lwjgl2w3.inject.org.lwjgl.opencl;

import java.nio.IntBuffer;
import org.lwjgl.opencl.CLContext;
import org.lwjgl.opencl.CLMem;

public final class CL12GL {
	public static final int CL_GL_OBJECT_TEXTURE2D_ARRAY = 0x200E;
	public static CLMem clCreateFromGLTexture(CLContext context, long flags, int target, int miplevel, int texture, IntBuffer errcode_ret) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}
}
