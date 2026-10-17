package com.koyomiji.lwjgl2w3.generated.org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public final class ARBUniformBufferObject {
	public static void glGetUniformIndices(int program, ByteBuffer uniformNames, IntBuffer uniformIndices) {
		org.lwjgl.opengl.ARBUniformBufferObject.glGetUniformIndices(program, org.lwjgl.system.MemoryUtil.memPointerBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(uniformNames), org.lwjgl.system.Checks.remainingSafe(uniformIndices)), uniformIndices);
	}
	public static void glGetActiveUniforms(int program, IntBuffer uniformIndices, int pname, IntBuffer params) {
		org.lwjgl.opengl.ARBUniformBufferObject.glGetActiveUniformsiv(program, uniformIndices, pname, params);
	}
	@Deprecated
	public static int glGetActiveUniforms(int program, int uniformIndex, int pname) {
		try (org.lwjgl.system.MemoryStack __stack = org.lwjgl.system.MemoryStack.stackPush()) {
			java.nio.IntBuffer __t1 = __stack.mallocInt(1);
			java.nio.IntBuffer __t3 = __stack.mallocInt(1);
			org.lwjgl.opengl.ARBUniformBufferObject.glGetActiveUniformsiv(program, __t1, pname, __t3);
			return __t3.get(0);
		}
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
