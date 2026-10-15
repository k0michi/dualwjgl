package com.koyomiji.lwjgl2w3.generated.org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Todo;
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
	@Todo("gl")
	public static void glGetUniformIndices(int program, ByteBuffer uniformNames, IntBuffer uniformIndices) {
		throw new UnsupportedOperationException();
	}
	public static void glGetActiveUniforms(int program, IntBuffer uniformIndices, int pname, IntBuffer params) {
		org.lwjgl.opengl.GL31.glGetActiveUniformsiv(program, uniformIndices, pname, params);
	}
	@Deprecated
	@Todo("gl")
	public static int glGetActiveUniforms(int program, int uniformIndex, int pname) {
		throw new UnsupportedOperationException();
	}
	public static void glGetActiveUniformBlock(int program, int uniformBlockIndex, int pname, IntBuffer params) {
		org.lwjgl.opengl.GL31.glGetActiveUniformBlockiv(program, uniformBlockIndex, pname, params);
	}
	@Deprecated
	public static int glGetActiveUniformBlock(int program, int uniformBlockIndex, int pname) {
		return org.lwjgl.opengl.GL31.glGetActiveUniformBlocki(program, uniformBlockIndex, pname);
	}
}
