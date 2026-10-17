package com.koyomiji.lwjgl2w3.generated.org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Todo;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

public final class GL20 {
	public static final int GL_SHADER_OBJECT = 0x8B48;
	@Todo("gl")
	public static void glShaderSource(int shader, ByteBuffer string) {
		throw new UnsupportedOperationException();
	}
	public static void glUniform1(int location, FloatBuffer values) {
		org.lwjgl.opengl.GL20.glUniform1fv(location, values);
	}
	public static void glUniform2(int location, FloatBuffer values) {
		org.lwjgl.opengl.GL20.glUniform2fv(location, values);
	}
	public static void glUniform3(int location, FloatBuffer values) {
		org.lwjgl.opengl.GL20.glUniform3fv(location, values);
	}
	public static void glUniform4(int location, FloatBuffer values) {
		org.lwjgl.opengl.GL20.glUniform4fv(location, values);
	}
	public static void glUniform1(int location, IntBuffer values) {
		org.lwjgl.opengl.GL20.glUniform1iv(location, values);
	}
	public static void glUniform2(int location, IntBuffer values) {
		org.lwjgl.opengl.GL20.glUniform2iv(location, values);
	}
	public static void glUniform3(int location, IntBuffer values) {
		org.lwjgl.opengl.GL20.glUniform3iv(location, values);
	}
	public static void glUniform4(int location, IntBuffer values) {
		org.lwjgl.opengl.GL20.glUniform4iv(location, values);
	}
	public static void glUniformMatrix2(int location, boolean transpose, FloatBuffer matrices) {
		org.lwjgl.opengl.GL20.glUniformMatrix2fv(location, transpose, matrices);
	}
	public static void glUniformMatrix3(int location, boolean transpose, FloatBuffer matrices) {
		org.lwjgl.opengl.GL20.glUniformMatrix3fv(location, transpose, matrices);
	}
	public static void glUniformMatrix4(int location, boolean transpose, FloatBuffer matrices) {
		org.lwjgl.opengl.GL20.glUniformMatrix4fv(location, transpose, matrices);
	}
	public static void glGetShader(int shader, int pname, IntBuffer params) {
		org.lwjgl.opengl.GL20.glGetShaderiv(shader, pname, params);
	}
	@Deprecated
	public static int glGetShader(int shader, int pname) {
		return org.lwjgl.opengl.GL20.glGetShaderi(shader, pname);
	}
	public static void glGetProgram(int program, int pname, IntBuffer params) {
		org.lwjgl.opengl.GL20.glGetProgramiv(program, pname, params);
	}
	@Deprecated
	public static int glGetProgram(int program, int pname) {
		return org.lwjgl.opengl.GL20.glGetProgrami(program, pname);
	}
	public static String glGetActiveUniform(int program, int index, int maxLength, IntBuffer sizeType) {
		return org.lwjgl.opengl.GL20.glGetActiveUniform(program, index, maxLength, sizeType, org.lwjgl.system.MemoryUtil.memIntBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(sizeType) + 4, (org.lwjgl.system.Checks.remainingSafe(sizeType) - 1)));
	}
	public static String glGetActiveUniform(int program, int index, int maxLength) {
		try (org.lwjgl.system.MemoryStack __stack = org.lwjgl.system.MemoryStack.stackPush()) {
			java.nio.IntBuffer __t3 = __stack.mallocInt(1);
			java.nio.IntBuffer __t4 = __stack.mallocInt(1);
			return org.lwjgl.opengl.GL20.glGetActiveUniform(program, index, maxLength, __t3, __t4);
		}
	}
	public static int glGetActiveUniformSize(int program, int index) {
		try (org.lwjgl.system.MemoryStack __stack = org.lwjgl.system.MemoryStack.stackPush()) {
			java.nio.IntBuffer __t3 = __stack.mallocInt(1);
			java.nio.IntBuffer __t4 = __stack.mallocInt(1);
			java.nio.ByteBuffer __t5 = __stack.malloc(1);
			org.lwjgl.opengl.GL20.glGetActiveUniform(program, index, (java.nio.IntBuffer)null, __t3, __t4, __t5);
			return __t3.get(0);
		}
	}
	public static int glGetActiveUniformType(int program, int index) {
		try (org.lwjgl.system.MemoryStack __stack = org.lwjgl.system.MemoryStack.stackPush()) {
			java.nio.IntBuffer __t3 = __stack.mallocInt(1);
			java.nio.IntBuffer __t4 = __stack.mallocInt(1);
			java.nio.ByteBuffer __t5 = __stack.malloc(0);
			org.lwjgl.opengl.GL20.glGetActiveUniform(program, index, (java.nio.IntBuffer)null, __t3, __t4, __t5);
			return __t4.get(0);
		}
	}
	public static void glGetUniform(int program, int location, FloatBuffer params) {
		org.lwjgl.opengl.GL20.glGetUniformfv(program, location, params);
	}
	public static void glGetUniform(int program, int location, IntBuffer params) {
		org.lwjgl.opengl.GL20.glGetUniformiv(program, location, params);
	}
	public static void glVertexAttribPointer(int index, int size, boolean normalized, int stride, DoubleBuffer buffer) {
		org.lwjgl.opengl.GL20.glVertexAttribPointer(index, size, 5130, normalized, stride, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(buffer), (org.lwjgl.system.Checks.remainingSafe(buffer) << 3)));
	}
	public static void glVertexAttribPointer(int index, int size, boolean normalized, int stride, FloatBuffer buffer) {
		org.lwjgl.opengl.GL20.glVertexAttribPointer(index, size, 5126, normalized, stride, buffer);
	}
	public static void glVertexAttribPointer(int index, int size, boolean unsigned, boolean normalized, int stride, ByteBuffer buffer) {
		org.lwjgl.opengl.GL20.glVertexAttribPointer(index, size, (unsigned ? 5121 : 5120), normalized, stride, buffer);
	}
	public static void glVertexAttribPointer(int index, int size, boolean unsigned, boolean normalized, int stride, IntBuffer buffer) {
		org.lwjgl.opengl.GL20.glVertexAttribPointer(index, size, (unsigned ? 5125 : 5124), normalized, stride, buffer);
	}
	public static void glVertexAttribPointer(int index, int size, boolean unsigned, boolean normalized, int stride, ShortBuffer buffer) {
		org.lwjgl.opengl.GL20.glVertexAttribPointer(index, size, (unsigned ? 5123 : 5122), normalized, stride, buffer);
	}
	public static void glGetVertexAttrib(int index, int pname, FloatBuffer params) {
		org.lwjgl.opengl.GL20.glGetVertexAttribfv(index, pname, params);
	}
	public static void glGetVertexAttrib(int index, int pname, DoubleBuffer params) {
		org.lwjgl.opengl.GL20.glGetVertexAttribdv(index, pname, params);
	}
	public static void glGetVertexAttrib(int index, int pname, IntBuffer params) {
		org.lwjgl.opengl.GL20.glGetVertexAttribiv(index, pname, params);
	}
	@Todo("gl")
	public static ByteBuffer glGetVertexAttribPointer(int index, int pname, long result_size) {
		throw new UnsupportedOperationException();
	}
	public static void glGetVertexAttribPointer(int index, int pname, ByteBuffer pointer) {
		org.lwjgl.opengl.GL20.glGetVertexAttribPointerv(index, pname, org.lwjgl.system.MemoryUtil.memPointerBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(pointer), (org.lwjgl.system.Checks.remainingSafe(pointer) >> 3)));
	}
	public static String glGetActiveAttrib(int program, int index, int maxLength, IntBuffer sizeType) {
		return org.lwjgl.opengl.GL20.glGetActiveAttrib(program, index, maxLength, sizeType, org.lwjgl.system.MemoryUtil.memIntBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(sizeType) + 4, (org.lwjgl.system.Checks.remainingSafe(sizeType) - 1)));
	}
	public static String glGetActiveAttrib(int program, int index, int maxLength) {
		try (org.lwjgl.system.MemoryStack __stack = org.lwjgl.system.MemoryStack.stackPush()) {
			java.nio.IntBuffer __t3 = __stack.mallocInt(1);
			java.nio.IntBuffer __t4 = __stack.mallocInt(1);
			return org.lwjgl.opengl.GL20.glGetActiveAttrib(program, index, maxLength, __t3, __t4);
		}
	}
	public static int glGetActiveAttribSize(int program, int index) {
		try (org.lwjgl.system.MemoryStack __stack = org.lwjgl.system.MemoryStack.stackPush()) {
			java.nio.IntBuffer __t3 = __stack.mallocInt(1);
			java.nio.IntBuffer __t4 = __stack.mallocInt(1);
			java.nio.ByteBuffer __t5 = __stack.malloc(0);
			org.lwjgl.opengl.GL20.glGetActiveAttrib(program, index, (java.nio.IntBuffer)null, __t3, __t4, __t5);
			return __t3.get(0);
		}
	}
	public static int glGetActiveAttribType(int program, int index) {
		try (org.lwjgl.system.MemoryStack __stack = org.lwjgl.system.MemoryStack.stackPush()) {
			java.nio.IntBuffer __t3 = __stack.mallocInt(1);
			java.nio.IntBuffer __t4 = __stack.mallocInt(1);
			java.nio.ByteBuffer __t5 = __stack.malloc(0);
			org.lwjgl.opengl.GL20.glGetActiveAttrib(program, index, (java.nio.IntBuffer)null, __t3, __t4, __t5);
			return __t4.get(0);
		}
	}
}
