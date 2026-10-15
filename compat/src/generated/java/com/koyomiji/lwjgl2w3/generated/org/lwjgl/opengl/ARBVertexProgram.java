package com.koyomiji.lwjgl2w3.generated.org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Todo;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

public final class ARBVertexProgram {
	@Todo("gl")
	public static void glVertexAttribPointerARB(int index, int size, boolean normalized, int stride, DoubleBuffer buffer) {
		throw new UnsupportedOperationException();
	}
	@Todo("gl")
	public static void glVertexAttribPointerARB(int index, int size, boolean normalized, int stride, FloatBuffer buffer) {
		throw new UnsupportedOperationException();
	}
	@Todo("gl")
	public static void glVertexAttribPointerARB(int index, int size, boolean unsigned, boolean normalized, int stride, ByteBuffer buffer) {
		throw new UnsupportedOperationException();
	}
	@Todo("gl")
	public static void glVertexAttribPointerARB(int index, int size, boolean unsigned, boolean normalized, int stride, IntBuffer buffer) {
		throw new UnsupportedOperationException();
	}
	@Todo("gl")
	public static void glVertexAttribPointerARB(int index, int size, boolean unsigned, boolean normalized, int stride, ShortBuffer buffer) {
		throw new UnsupportedOperationException();
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
	@Todo("gl")
	public static void glProgramStringARB(int target, int format, CharSequence string) {
		throw new UnsupportedOperationException();
	}
	@Todo("gl")
	public static void glDeleteProgramsARB(int program) {
		throw new UnsupportedOperationException();
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
