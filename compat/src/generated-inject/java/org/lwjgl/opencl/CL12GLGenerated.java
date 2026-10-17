package org.lwjgl.opencl;

import com.koyomiji.lwjgl2w3.inject.Generated;
import com.koyomiji.lwjgl2w3.inject.Into;
import java.nio.IntBuffer;

@Generated
@Into(CL12GL.class)
final class CL12GLGenerated {
	public static final int CL_GL_OBJECT_TEXTURE2D_ARRAY = 0x200E;
	public static CLMem clCreateFromGLTexture(CLContext context, long flags, int target, int miplevel, int texture, IntBuffer errcode_ret) {
		org.lwjgl.opencl.CLMem __result = new org.lwjgl.opencl.CLMem(org.lwjgl.opencl.CL12GL.clCreateFromGLTexture(context.getPointer(), flags, target, miplevel, texture, errcode_ret), context);
		return __result;
	}
}
