package com.koyomiji.lwjgl2w3.inject.org.lwjgl.opengl;

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
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glGetActiveUniforms(int program, IntBuffer uniformIndices, int pname, IntBuffer params) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	@Deprecated
	public static int glGetActiveUniforms(int program, int uniformIndex, int pname) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glGetActiveUniformBlock(int program, int uniformBlockIndex, int pname, IntBuffer params) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	@Deprecated
	public static int glGetActiveUniformBlock(int program, int uniformBlockIndex, int pname) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
}
