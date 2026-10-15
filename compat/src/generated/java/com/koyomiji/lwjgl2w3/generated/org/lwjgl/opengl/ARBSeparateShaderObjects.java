package com.koyomiji.lwjgl2w3.generated.org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Todo;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public final class ARBSeparateShaderObjects {
	@Todo("gl")
	public static int glCreateShaderProgram(int type, ByteBuffer string) {
		throw new UnsupportedOperationException();
	}
	@Todo("gl")
	public static int glCreateShaderProgram(int type, int count, ByteBuffer strings) {
		throw new UnsupportedOperationException();
	}
	@Todo("gl")
	public static int glCreateShaderProgram(int type, ByteBuffer[] strings) {
		throw new UnsupportedOperationException();
	}
	@Todo("gl")
	public static int glCreateShaderProgram(int type, CharSequence string) {
		throw new UnsupportedOperationException();
	}
	public static int glCreateShaderProgram(int type, CharSequence[] strings) {
		return org.lwjgl.opengl.ARBSeparateShaderObjects.glCreateShaderProgramv(type, strings);
	}
	public static void glGetProgramPipeline(int pipeline, int pname, IntBuffer params) {
		org.lwjgl.opengl.ARBSeparateShaderObjects.glGetProgramPipelineiv(pipeline, pname, params);
	}
	public static void glProgramUniform1(int program, int location, IntBuffer value) {
		org.lwjgl.opengl.ARBSeparateShaderObjects.glProgramUniform1iv(program, location, value);
	}
	public static void glProgramUniform2(int program, int location, IntBuffer value) {
		org.lwjgl.opengl.ARBSeparateShaderObjects.glProgramUniform2iv(program, location, value);
	}
	public static void glProgramUniform3(int program, int location, IntBuffer value) {
		org.lwjgl.opengl.ARBSeparateShaderObjects.glProgramUniform3iv(program, location, value);
	}
	public static void glProgramUniform4(int program, int location, IntBuffer value) {
		org.lwjgl.opengl.ARBSeparateShaderObjects.glProgramUniform4iv(program, location, value);
	}
	public static void glProgramUniform1(int program, int location, FloatBuffer value) {
		org.lwjgl.opengl.ARBSeparateShaderObjects.glProgramUniform1fv(program, location, value);
	}
	public static void glProgramUniform2(int program, int location, FloatBuffer value) {
		org.lwjgl.opengl.ARBSeparateShaderObjects.glProgramUniform2fv(program, location, value);
	}
	public static void glProgramUniform3(int program, int location, FloatBuffer value) {
		org.lwjgl.opengl.ARBSeparateShaderObjects.glProgramUniform3fv(program, location, value);
	}
	public static void glProgramUniform4(int program, int location, FloatBuffer value) {
		org.lwjgl.opengl.ARBSeparateShaderObjects.glProgramUniform4fv(program, location, value);
	}
	public static void glProgramUniform1(int program, int location, DoubleBuffer value) {
		org.lwjgl.opengl.ARBSeparateShaderObjects.glProgramUniform1dv(program, location, value);
	}
	public static void glProgramUniform2(int program, int location, DoubleBuffer value) {
		org.lwjgl.opengl.ARBSeparateShaderObjects.glProgramUniform2dv(program, location, value);
	}
	public static void glProgramUniform3(int program, int location, DoubleBuffer value) {
		org.lwjgl.opengl.ARBSeparateShaderObjects.glProgramUniform3dv(program, location, value);
	}
	public static void glProgramUniform4(int program, int location, DoubleBuffer value) {
		org.lwjgl.opengl.ARBSeparateShaderObjects.glProgramUniform4dv(program, location, value);
	}
	public static void glProgramUniform1u(int program, int location, IntBuffer value) {
		org.lwjgl.opengl.ARBSeparateShaderObjects.glProgramUniform1uiv(program, location, value);
	}
	public static void glProgramUniform2u(int program, int location, IntBuffer value) {
		org.lwjgl.opengl.ARBSeparateShaderObjects.glProgramUniform2uiv(program, location, value);
	}
	public static void glProgramUniform3u(int program, int location, IntBuffer value) {
		org.lwjgl.opengl.ARBSeparateShaderObjects.glProgramUniform3uiv(program, location, value);
	}
	public static void glProgramUniform4u(int program, int location, IntBuffer value) {
		org.lwjgl.opengl.ARBSeparateShaderObjects.glProgramUniform4uiv(program, location, value);
	}
	public static void glProgramUniformMatrix2(int program, int location, boolean transpose, FloatBuffer value) {
		org.lwjgl.opengl.ARBSeparateShaderObjects.glProgramUniformMatrix2fv(program, location, transpose, value);
	}
	public static void glProgramUniformMatrix3(int program, int location, boolean transpose, FloatBuffer value) {
		org.lwjgl.opengl.ARBSeparateShaderObjects.glProgramUniformMatrix3fv(program, location, transpose, value);
	}
	public static void glProgramUniformMatrix4(int program, int location, boolean transpose, FloatBuffer value) {
		org.lwjgl.opengl.ARBSeparateShaderObjects.glProgramUniformMatrix4fv(program, location, transpose, value);
	}
	public static void glProgramUniformMatrix2(int program, int location, boolean transpose, DoubleBuffer value) {
		org.lwjgl.opengl.ARBSeparateShaderObjects.glProgramUniformMatrix2dv(program, location, transpose, value);
	}
	public static void glProgramUniformMatrix3(int program, int location, boolean transpose, DoubleBuffer value) {
		org.lwjgl.opengl.ARBSeparateShaderObjects.glProgramUniformMatrix3dv(program, location, transpose, value);
	}
	public static void glProgramUniformMatrix4(int program, int location, boolean transpose, DoubleBuffer value) {
		org.lwjgl.opengl.ARBSeparateShaderObjects.glProgramUniformMatrix4dv(program, location, transpose, value);
	}
	public static void glProgramUniformMatrix2x3(int program, int location, boolean transpose, FloatBuffer value) {
		org.lwjgl.opengl.ARBSeparateShaderObjects.glProgramUniformMatrix2x3fv(program, location, transpose, value);
	}
	public static void glProgramUniformMatrix3x2(int program, int location, boolean transpose, FloatBuffer value) {
		org.lwjgl.opengl.ARBSeparateShaderObjects.glProgramUniformMatrix3x2fv(program, location, transpose, value);
	}
	public static void glProgramUniformMatrix2x4(int program, int location, boolean transpose, FloatBuffer value) {
		org.lwjgl.opengl.ARBSeparateShaderObjects.glProgramUniformMatrix2x4fv(program, location, transpose, value);
	}
	public static void glProgramUniformMatrix4x2(int program, int location, boolean transpose, FloatBuffer value) {
		org.lwjgl.opengl.ARBSeparateShaderObjects.glProgramUniformMatrix4x2fv(program, location, transpose, value);
	}
	public static void glProgramUniformMatrix3x4(int program, int location, boolean transpose, FloatBuffer value) {
		org.lwjgl.opengl.ARBSeparateShaderObjects.glProgramUniformMatrix3x4fv(program, location, transpose, value);
	}
	public static void glProgramUniformMatrix4x3(int program, int location, boolean transpose, FloatBuffer value) {
		org.lwjgl.opengl.ARBSeparateShaderObjects.glProgramUniformMatrix4x3fv(program, location, transpose, value);
	}
	public static void glProgramUniformMatrix2x3(int program, int location, boolean transpose, DoubleBuffer value) {
		org.lwjgl.opengl.ARBSeparateShaderObjects.glProgramUniformMatrix2x3dv(program, location, transpose, value);
	}
	public static void glProgramUniformMatrix3x2(int program, int location, boolean transpose, DoubleBuffer value) {
		org.lwjgl.opengl.ARBSeparateShaderObjects.glProgramUniformMatrix3x2dv(program, location, transpose, value);
	}
	public static void glProgramUniformMatrix2x4(int program, int location, boolean transpose, DoubleBuffer value) {
		org.lwjgl.opengl.ARBSeparateShaderObjects.glProgramUniformMatrix2x4dv(program, location, transpose, value);
	}
	public static void glProgramUniformMatrix4x2(int program, int location, boolean transpose, DoubleBuffer value) {
		org.lwjgl.opengl.ARBSeparateShaderObjects.glProgramUniformMatrix4x2dv(program, location, transpose, value);
	}
	public static void glProgramUniformMatrix3x4(int program, int location, boolean transpose, DoubleBuffer value) {
		org.lwjgl.opengl.ARBSeparateShaderObjects.glProgramUniformMatrix3x4dv(program, location, transpose, value);
	}
	public static void glProgramUniformMatrix4x3(int program, int location, boolean transpose, DoubleBuffer value) {
		org.lwjgl.opengl.ARBSeparateShaderObjects.glProgramUniformMatrix4x3dv(program, location, transpose, value);
	}
}
