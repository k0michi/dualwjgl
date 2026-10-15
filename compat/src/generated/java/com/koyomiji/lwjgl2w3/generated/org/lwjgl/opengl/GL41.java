package com.koyomiji.lwjgl2w3.generated.org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Todo;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public final class GL41 {
	public static int glCreateShaderProgram(int type, ByteBuffer string) {
		return org.lwjgl.opengl.GL41.nglCreateShaderProgramv(type, 1, org.lwjgl.system.MemoryUtil.memAddressSafe(string));
	}
	public static int glCreateShaderProgram(int type, int count, ByteBuffer strings) {
		return org.lwjgl.opengl.GL41.nglCreateShaderProgramv(type, count, org.lwjgl.system.MemoryUtil.memAddressSafe(strings));
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
		return org.lwjgl.opengl.GL41.glCreateShaderProgramv(type, strings);
	}
	public static void glGetProgramPipeline(int pipeline, int pname, IntBuffer params) {
		org.lwjgl.opengl.GL41.glGetProgramPipelineiv(pipeline, pname, params);
	}
	public static void glProgramUniform1(int program, int location, IntBuffer value) {
		org.lwjgl.opengl.GL41.glProgramUniform1iv(program, location, value);
	}
	public static void glProgramUniform2(int program, int location, IntBuffer value) {
		org.lwjgl.opengl.GL41.glProgramUniform2iv(program, location, value);
	}
	public static void glProgramUniform3(int program, int location, IntBuffer value) {
		org.lwjgl.opengl.GL41.glProgramUniform3iv(program, location, value);
	}
	public static void glProgramUniform4(int program, int location, IntBuffer value) {
		org.lwjgl.opengl.GL41.glProgramUniform4iv(program, location, value);
	}
	public static void glProgramUniform1(int program, int location, FloatBuffer value) {
		org.lwjgl.opengl.GL41.glProgramUniform1fv(program, location, value);
	}
	public static void glProgramUniform2(int program, int location, FloatBuffer value) {
		org.lwjgl.opengl.GL41.glProgramUniform2fv(program, location, value);
	}
	public static void glProgramUniform3(int program, int location, FloatBuffer value) {
		org.lwjgl.opengl.GL41.glProgramUniform3fv(program, location, value);
	}
	public static void glProgramUniform4(int program, int location, FloatBuffer value) {
		org.lwjgl.opengl.GL41.glProgramUniform4fv(program, location, value);
	}
	public static void glProgramUniform1(int program, int location, DoubleBuffer value) {
		org.lwjgl.opengl.GL41.glProgramUniform1dv(program, location, value);
	}
	public static void glProgramUniform2(int program, int location, DoubleBuffer value) {
		org.lwjgl.opengl.GL41.glProgramUniform2dv(program, location, value);
	}
	public static void glProgramUniform3(int program, int location, DoubleBuffer value) {
		org.lwjgl.opengl.GL41.glProgramUniform3dv(program, location, value);
	}
	public static void glProgramUniform4(int program, int location, DoubleBuffer value) {
		org.lwjgl.opengl.GL41.glProgramUniform4dv(program, location, value);
	}
	public static void glProgramUniform1u(int program, int location, IntBuffer value) {
		org.lwjgl.opengl.GL41.glProgramUniform1uiv(program, location, value);
	}
	public static void glProgramUniform2u(int program, int location, IntBuffer value) {
		org.lwjgl.opengl.GL41.glProgramUniform2uiv(program, location, value);
	}
	public static void glProgramUniform3u(int program, int location, IntBuffer value) {
		org.lwjgl.opengl.GL41.glProgramUniform3uiv(program, location, value);
	}
	public static void glProgramUniform4u(int program, int location, IntBuffer value) {
		org.lwjgl.opengl.GL41.glProgramUniform4uiv(program, location, value);
	}
	public static void glProgramUniformMatrix2(int program, int location, boolean transpose, FloatBuffer value) {
		org.lwjgl.opengl.GL41.glProgramUniformMatrix2fv(program, location, transpose, value);
	}
	public static void glProgramUniformMatrix3(int program, int location, boolean transpose, FloatBuffer value) {
		org.lwjgl.opengl.GL41.glProgramUniformMatrix3fv(program, location, transpose, value);
	}
	public static void glProgramUniformMatrix4(int program, int location, boolean transpose, FloatBuffer value) {
		org.lwjgl.opengl.GL41.glProgramUniformMatrix4fv(program, location, transpose, value);
	}
	public static void glProgramUniformMatrix2(int program, int location, boolean transpose, DoubleBuffer value) {
		org.lwjgl.opengl.GL41.glProgramUniformMatrix2dv(program, location, transpose, value);
	}
	public static void glProgramUniformMatrix3(int program, int location, boolean transpose, DoubleBuffer value) {
		org.lwjgl.opengl.GL41.glProgramUniformMatrix3dv(program, location, transpose, value);
	}
	public static void glProgramUniformMatrix4(int program, int location, boolean transpose, DoubleBuffer value) {
		org.lwjgl.opengl.GL41.glProgramUniformMatrix4dv(program, location, transpose, value);
	}
	public static void glProgramUniformMatrix2x3(int program, int location, boolean transpose, FloatBuffer value) {
		org.lwjgl.opengl.GL41.glProgramUniformMatrix2x3fv(program, location, transpose, value);
	}
	public static void glProgramUniformMatrix3x2(int program, int location, boolean transpose, FloatBuffer value) {
		org.lwjgl.opengl.GL41.glProgramUniformMatrix3x2fv(program, location, transpose, value);
	}
	public static void glProgramUniformMatrix2x4(int program, int location, boolean transpose, FloatBuffer value) {
		org.lwjgl.opengl.GL41.glProgramUniformMatrix2x4fv(program, location, transpose, value);
	}
	public static void glProgramUniformMatrix4x2(int program, int location, boolean transpose, FloatBuffer value) {
		org.lwjgl.opengl.GL41.glProgramUniformMatrix4x2fv(program, location, transpose, value);
	}
	public static void glProgramUniformMatrix3x4(int program, int location, boolean transpose, FloatBuffer value) {
		org.lwjgl.opengl.GL41.glProgramUniformMatrix3x4fv(program, location, transpose, value);
	}
	public static void glProgramUniformMatrix4x3(int program, int location, boolean transpose, FloatBuffer value) {
		org.lwjgl.opengl.GL41.glProgramUniformMatrix4x3fv(program, location, transpose, value);
	}
	public static void glProgramUniformMatrix2x3(int program, int location, boolean transpose, DoubleBuffer value) {
		org.lwjgl.opengl.GL41.glProgramUniformMatrix2x3dv(program, location, transpose, value);
	}
	public static void glProgramUniformMatrix3x2(int program, int location, boolean transpose, DoubleBuffer value) {
		org.lwjgl.opengl.GL41.glProgramUniformMatrix3x2dv(program, location, transpose, value);
	}
	public static void glProgramUniformMatrix2x4(int program, int location, boolean transpose, DoubleBuffer value) {
		org.lwjgl.opengl.GL41.glProgramUniformMatrix2x4dv(program, location, transpose, value);
	}
	public static void glProgramUniformMatrix4x2(int program, int location, boolean transpose, DoubleBuffer value) {
		org.lwjgl.opengl.GL41.glProgramUniformMatrix4x2dv(program, location, transpose, value);
	}
	public static void glProgramUniformMatrix3x4(int program, int location, boolean transpose, DoubleBuffer value) {
		org.lwjgl.opengl.GL41.glProgramUniformMatrix3x4dv(program, location, transpose, value);
	}
	public static void glProgramUniformMatrix4x3(int program, int location, boolean transpose, DoubleBuffer value) {
		org.lwjgl.opengl.GL41.glProgramUniformMatrix4x3dv(program, location, transpose, value);
	}
	public static void glVertexAttribL1(int index, DoubleBuffer v) {
		org.lwjgl.opengl.GL41.glVertexAttribL1dv(index, v);
	}
	public static void glVertexAttribL2(int index, DoubleBuffer v) {
		org.lwjgl.opengl.GL41.glVertexAttribL2dv(index, v);
	}
	public static void glVertexAttribL3(int index, DoubleBuffer v) {
		org.lwjgl.opengl.GL41.glVertexAttribL3dv(index, v);
	}
	public static void glVertexAttribL4(int index, DoubleBuffer v) {
		org.lwjgl.opengl.GL41.glVertexAttribL4dv(index, v);
	}
	public static void glVertexAttribLPointer(int index, int size, int stride, long pointer_buffer_offset) {
		org.lwjgl.opengl.GL41.nglVertexAttribLPointer(index, size, 5130, stride, pointer_buffer_offset);
	}
	public static void glGetVertexAttribL(int index, int pname, DoubleBuffer params) {
		org.lwjgl.opengl.GL41.glGetVertexAttribLdv(index, pname, params);
	}
	public static void glViewportArray(int first, FloatBuffer v) {
		org.lwjgl.opengl.GL41.glViewportArrayv(first, v);
	}
	public static void glViewportIndexed(int index, FloatBuffer v) {
		org.lwjgl.opengl.GL41.glViewportIndexedfv(index, v);
	}
	public static void glScissorArray(int first, IntBuffer v) {
		org.lwjgl.opengl.GL41.glScissorArrayv(first, v);
	}
	public static void glScissorIndexed(int index, IntBuffer v) {
		org.lwjgl.opengl.GL41.glScissorIndexedv(index, v);
	}
	public static void glDepthRangeArray(int first, DoubleBuffer v) {
		org.lwjgl.opengl.GL41.glDepthRangeArrayv(first, v);
	}
	public static void glGetFloat(int target, int index, FloatBuffer data) {
		org.lwjgl.opengl.GL41.glGetFloati_v(target, index, data);
	}
	public static float glGetFloat(int target, int index) {
		return org.lwjgl.opengl.GL41.glGetFloati(target, index);
	}
	public static void glGetDouble(int target, int index, DoubleBuffer data) {
		org.lwjgl.opengl.GL41.glGetDoublei_v(target, index, data);
	}
	public static double glGetDouble(int target, int index) {
		return org.lwjgl.opengl.GL41.glGetDoublei(target, index);
	}
}
