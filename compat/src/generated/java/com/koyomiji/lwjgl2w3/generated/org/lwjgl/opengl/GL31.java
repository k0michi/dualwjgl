package com.koyomiji.lwjgl2w3.generated.org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public final class GL31 {
	public static final int GL_RED_SNORM = 0x8F90;
	public static final int GL_RG_SNORM = 0x8F91;
	public static final int GL_RGB_SNORM = 0x8F92;
	public static final int GL_RGBA_SNORM = 0x8F93;
	public static final int GL_COPY_READ_BUFFER_BINDING = 0x8F36;
	public static final int GL_COPY_WRITE_BUFFER_BINDING = 0x8F37;
	public static final int GL_TEXTURE_BUFFER_FORMAT = 0x8C2E;
	public static void glGetUniformIndices(int program, ByteBuffer uniformNames, IntBuffer uniformIndices) {
		org.lwjgl.opengl.GL31.glGetUniformIndices(program, org.lwjgl.system.MemoryUtil.memPointerBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(uniformNames), org.lwjgl.system.Checks.remainingSafe(uniformIndices)), uniformIndices);
	}
	public static void glGetActiveUniforms(int program, IntBuffer uniformIndices, int pname, IntBuffer params) {
		org.lwjgl.opengl.GL31.glGetActiveUniformsiv(program, uniformIndices, pname, params);
	}
	@Deprecated
	public static int glGetActiveUniforms(int program, int uniformIndex, int pname) {
		try (org.lwjgl.system.MemoryStack __stack = org.lwjgl.system.MemoryStack.stackPush()) {
			java.nio.IntBuffer __t1 = __stack.mallocInt(1);
			java.nio.IntBuffer __t3 = __stack.mallocInt(1);
			org.lwjgl.opengl.GL31.glGetActiveUniformsiv(program, __t1, pname, __t3);
			return __t3.get(0);
		}
	}
	public static void glGetActiveUniformBlock(int program, int uniformBlockIndex, int pname, IntBuffer params) {
		org.lwjgl.opengl.GL31.glGetActiveUniformBlockiv(program, uniformBlockIndex, pname, params);
	}
	@Deprecated
	public static int glGetActiveUniformBlock(int program, int uniformBlockIndex, int pname) {
		return org.lwjgl.opengl.GL31.glGetActiveUniformBlocki(program, uniformBlockIndex, pname);
	}
}
