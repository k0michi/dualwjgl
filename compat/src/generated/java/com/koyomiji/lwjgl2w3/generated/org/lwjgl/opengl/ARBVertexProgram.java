package com.koyomiji.lwjgl2w3.generated.org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Todo;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

public final class ARBVertexProgram {
	public static void glVertexAttribPointerARB(int index, int size, boolean normalized, int stride, DoubleBuffer buffer) {
		org.lwjgl.opengl.ARBVertexProgram.nglVertexAttribPointerARB(index, size, 5130, normalized, stride, org.lwjgl.system.MemoryUtil.memAddressSafe(buffer));
	}
	public static void glVertexAttribPointerARB(int index, int size, boolean normalized, int stride, FloatBuffer buffer) {
		org.lwjgl.opengl.ARBVertexProgram.nglVertexAttribPointerARB(index, size, 5126, normalized, stride, org.lwjgl.system.MemoryUtil.memAddressSafe(buffer));
	}
	public static void glVertexAttribPointerARB(int index, int size, boolean unsigned, boolean normalized, int stride, ByteBuffer buffer) {
		org.lwjgl.opengl.ARBVertexProgram.nglVertexAttribPointerARB(index, size, (unsigned ? 5121 : 5120), normalized, stride, org.lwjgl.system.MemoryUtil.memAddress(buffer));
	}
	public static void glVertexAttribPointerARB(int index, int size, boolean unsigned, boolean normalized, int stride, IntBuffer buffer) {
		org.lwjgl.opengl.ARBVertexProgram.nglVertexAttribPointerARB(index, size, (unsigned ? 5125 : 5124), normalized, stride, org.lwjgl.system.MemoryUtil.memAddress(buffer));
	}
	public static void glVertexAttribPointerARB(int index, int size, boolean unsigned, boolean normalized, int stride, ShortBuffer buffer) {
		org.lwjgl.opengl.ARBVertexProgram.nglVertexAttribPointerARB(index, size, (unsigned ? 5123 : 5122), normalized, stride, org.lwjgl.system.MemoryUtil.memAddress(buffer));
	}
	public static void glGetVertexAttribARB(int index, int pname, FloatBuffer params) {
		org.lwjgl.opengl.ARBVertexProgram.glGetVertexAttribfvARB(index, pname, params);
	}
	public static void glGetVertexAttribARB(int index, int pname, DoubleBuffer params) {
		org.lwjgl.opengl.ARBVertexProgram.glGetVertexAttribdvARB(index, pname, params);
	}
	public static void glGetVertexAttribARB(int index, int pname, IntBuffer params) {
		org.lwjgl.opengl.ARBVertexProgram.glGetVertexAttribivARB(index, pname, params);
	}
	@Todo("gl")
	public static ByteBuffer glGetVertexAttribPointerARB(int index, int pname, long result_size) {
		throw new UnsupportedOperationException();
	}
	public static void glProgramStringARB(int target, int format, CharSequence string) {
		try (org.lwjgl.system.MemoryStack __stack = org.lwjgl.system.MemoryStack.stackPush()) {
			int __stringEncodedLength = __stack.nASCII(string, false);
			long __stringEncodedAddress = __stack.getPointerAddress();
			org.lwjgl.opengl.ARBVertexProgram.nglProgramStringARB(target, format, __stringEncodedLength, __stringEncodedAddress);
		}
	}
	public static void glDeleteProgramsARB(int program) {
		try (org.lwjgl.system.MemoryStack __stack = org.lwjgl.system.MemoryStack.stackPush()) {
			org.lwjgl.opengl.ARBVertexProgram.nglDeleteProgramsARB(1, org.lwjgl.system.MemoryUtil.memAddress(__stack.ints(program)));
		}
	}
	public static void glProgramEnvParameter4ARB(int target, int index, FloatBuffer params) {
		org.lwjgl.opengl.ARBVertexProgram.glProgramEnvParameter4fvARB(target, index, params);
	}
	public static void glProgramEnvParameter4ARB(int target, int index, DoubleBuffer params) {
		org.lwjgl.opengl.ARBVertexProgram.glProgramEnvParameter4dvARB(target, index, params);
	}
	public static void glProgramLocalParameter4ARB(int target, int index, FloatBuffer params) {
		org.lwjgl.opengl.ARBVertexProgram.glProgramLocalParameter4fvARB(target, index, params);
	}
	public static void glProgramLocalParameter4ARB(int target, int index, DoubleBuffer params) {
		org.lwjgl.opengl.ARBVertexProgram.glProgramLocalParameter4dvARB(target, index, params);
	}
	public static void glGetProgramEnvParameterARB(int target, int index, FloatBuffer params) {
		org.lwjgl.opengl.ARBVertexProgram.glGetProgramEnvParameterfvARB(target, index, params);
	}
	public static void glGetProgramEnvParameterARB(int target, int index, DoubleBuffer params) {
		org.lwjgl.opengl.ARBVertexProgram.glGetProgramEnvParameterdvARB(target, index, params);
	}
	public static void glGetProgramLocalParameterARB(int target, int index, FloatBuffer params) {
		org.lwjgl.opengl.ARBVertexProgram.glGetProgramLocalParameterfvARB(target, index, params);
	}
	public static void glGetProgramLocalParameterARB(int target, int index, DoubleBuffer params) {
		org.lwjgl.opengl.ARBVertexProgram.glGetProgramLocalParameterdvARB(target, index, params);
	}
	public static void glGetProgramARB(int target, int parameterName, IntBuffer params) {
		org.lwjgl.opengl.ARBVertexProgram.glGetProgramivARB(target, parameterName, params);
	}
	@Deprecated
	public static int glGetProgramARB(int target, int parameterName) {
		return org.lwjgl.opengl.ARBVertexProgram.glGetProgramiARB(target, parameterName);
	}
	@Todo("gl")
	public static String glGetProgramStringARB(int target, int parameterName) {
		throw new UnsupportedOperationException();
	}
}
