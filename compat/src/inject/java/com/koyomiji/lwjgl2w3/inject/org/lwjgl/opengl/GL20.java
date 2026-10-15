package com.koyomiji.lwjgl2w3.inject.org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

public final class GL20 {
	public static final int GL_SHADER_OBJECT = 0x8B48;
	public static void glShaderSource(int shader, ByteBuffer string) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glUniform1(int location, FloatBuffer values) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glUniform2(int location, FloatBuffer values) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glUniform3(int location, FloatBuffer values) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glUniform4(int location, FloatBuffer values) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glUniform1(int location, IntBuffer values) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glUniform2(int location, IntBuffer values) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glUniform3(int location, IntBuffer values) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glUniform4(int location, IntBuffer values) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glUniformMatrix2(int location, boolean transpose, FloatBuffer matrices) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glUniformMatrix3(int location, boolean transpose, FloatBuffer matrices) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glUniformMatrix4(int location, boolean transpose, FloatBuffer matrices) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glGetShader(int shader, int pname, IntBuffer params) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	@Deprecated
	public static int glGetShader(int shader, int pname) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glGetProgram(int program, int pname, IntBuffer params) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	@Deprecated
	public static int glGetProgram(int program, int pname) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static String glGetActiveUniform(int program, int index, int maxLength, IntBuffer sizeType) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static String glGetActiveUniform(int program, int index, int maxLength) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static int glGetActiveUniformSize(int program, int index) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static int glGetActiveUniformType(int program, int index) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glGetUniform(int program, int location, FloatBuffer params) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glGetUniform(int program, int location, IntBuffer params) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glVertexAttribPointer(int index, int size, boolean normalized, int stride, DoubleBuffer buffer) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glVertexAttribPointer(int index, int size, boolean normalized, int stride, FloatBuffer buffer) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glVertexAttribPointer(int index, int size, boolean unsigned, boolean normalized, int stride, ByteBuffer buffer) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glVertexAttribPointer(int index, int size, boolean unsigned, boolean normalized, int stride, IntBuffer buffer) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glVertexAttribPointer(int index, int size, boolean unsigned, boolean normalized, int stride, ShortBuffer buffer) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glGetVertexAttrib(int index, int pname, FloatBuffer params) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glGetVertexAttrib(int index, int pname, DoubleBuffer params) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glGetVertexAttrib(int index, int pname, IntBuffer params) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static ByteBuffer glGetVertexAttribPointer(int index, int pname, long result_size) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glGetVertexAttribPointer(int index, int pname, ByteBuffer pointer) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static String glGetActiveAttrib(int program, int index, int maxLength, IntBuffer sizeType) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static String glGetActiveAttrib(int program, int index, int maxLength) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static int glGetActiveAttribSize(int program, int index) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static int glGetActiveAttribType(int program, int index) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
}
