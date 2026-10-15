package com.koyomiji.lwjgl2w3.generated.org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Todo;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public final class ARBUniformBufferObject {
	@Todo("gl")
	public static void glGetUniformIndices(int program, ByteBuffer uniformNames, IntBuffer uniformIndices) {
		throw new UnsupportedOperationException();
	}
	public static void glGetActiveUniforms(int program, IntBuffer uniformIndices, int pname, IntBuffer params) {
		org.lwjgl.opengl.ARBUniformBufferObject.glGetActiveUniformsiv(program, uniformIndices, pname, params);
	}
	@Deprecated
	@Todo("gl")
	public static int glGetActiveUniforms(int program, int uniformIndex, int pname) {
		throw new UnsupportedOperationException();
	}
	public static void glGetActiveUniformBlock(int program, int uniformBlockIndex, int pname, IntBuffer params) {
		org.lwjgl.opengl.ARBUniformBufferObject.glGetActiveUniformBlockiv(program, uniformBlockIndex, pname, params);
	}
	@Deprecated
	public static int glGetActiveUniformBlock(int program, int uniformBlockIndex, int pname) {
		return org.lwjgl.opengl.ARBUniformBufferObject.glGetActiveUniformBlocki(program, uniformBlockIndex, pname);
	}
	public static void glGetInteger(int value, int index, IntBuffer data) {
		org.lwjgl.opengl.ARBUniformBufferObject.glGetIntegeri_v(value, index, data);
	}
	public static int glGetInteger(int value, int index) {
		return org.lwjgl.opengl.ARBUniformBufferObject.glGetIntegeri(value, index);
	}
}
