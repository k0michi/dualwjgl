package com.koyomiji.lwjgl2w3.inject.org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public final class ARBUniformBufferObject {
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
	public static void glGetInteger(int value, int index, IntBuffer data) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static int glGetInteger(int value, int index) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
}
