package org.lwjgl.opengl;

import com.koyomiji.dualwjgl.inject.Generated;
import java.nio.DoubleBuffer;

@Generated
public final class ARBGpuShaderFp64 {
	public static final int GL_DOUBLE_VEC2 = 0x8FFC;
	public static final int GL_DOUBLE_VEC3 = 0x8FFD;
	public static final int GL_DOUBLE_VEC4 = 0x8FFE;
	public static final int GL_DOUBLE_MAT2 = 0x8F46;
	public static final int GL_DOUBLE_MAT3 = 0x8F47;
	public static final int GL_DOUBLE_MAT4 = 0x8F48;
	public static final int GL_DOUBLE_MAT2x3 = 0x8F49;
	public static final int GL_DOUBLE_MAT2x4 = 0x8F4A;
	public static final int GL_DOUBLE_MAT3x2 = 0x8F4B;
	public static final int GL_DOUBLE_MAT3x4 = 0x8F4C;
	public static final int GL_DOUBLE_MAT4x2 = 0x8F4D;
	public static final int GL_DOUBLE_MAT4x3 = 0x8F4E;

	private ARBGpuShaderFp64() {
	}

	public static void glUniform1d(int location, double x) {
		org.lwjgl.opengl.ARBGPUShaderFP64.glUniform1d(location, x);
	}

	public static void glUniform2d(int location, double x, double y) {
		org.lwjgl.opengl.ARBGPUShaderFP64.glUniform2d(location, x, y);
	}

	public static void glUniform3d(int location, double x, double y, double z) {
		org.lwjgl.opengl.ARBGPUShaderFP64.glUniform3d(location, x, y, z);
	}

	public static void glUniform4d(int location, double x, double y, double z, double w) {
		org.lwjgl.opengl.ARBGPUShaderFP64.glUniform4d(location, x, y, z, w);
	}

	public static void glUniform1(int location, DoubleBuffer value) {
		org.lwjgl.opengl.ARBGPUShaderFP64.glUniform1dv(location, value);
	}

	public static void glUniform2(int location, DoubleBuffer value) {
		org.lwjgl.opengl.ARBGPUShaderFP64.glUniform2dv(location, value);
	}

	public static void glUniform3(int location, DoubleBuffer value) {
		org.lwjgl.opengl.ARBGPUShaderFP64.glUniform3dv(location, value);
	}

	public static void glUniform4(int location, DoubleBuffer value) {
		org.lwjgl.opengl.ARBGPUShaderFP64.glUniform4dv(location, value);
	}

	public static void glUniformMatrix2(int location, boolean transpose, DoubleBuffer value) {
		org.lwjgl.opengl.ARBGPUShaderFP64.glUniformMatrix2dv(location, transpose, value);
	}

	public static void glUniformMatrix3(int location, boolean transpose, DoubleBuffer value) {
		org.lwjgl.opengl.ARBGPUShaderFP64.glUniformMatrix3dv(location, transpose, value);
	}

	public static void glUniformMatrix4(int location, boolean transpose, DoubleBuffer value) {
		org.lwjgl.opengl.ARBGPUShaderFP64.glUniformMatrix4dv(location, transpose, value);
	}

	public static void glUniformMatrix2x3(int location, boolean transpose, DoubleBuffer value) {
		org.lwjgl.opengl.ARBGPUShaderFP64.glUniformMatrix2x3dv(location, transpose, value);
	}

	public static void glUniformMatrix2x4(int location, boolean transpose, DoubleBuffer value) {
		org.lwjgl.opengl.ARBGPUShaderFP64.glUniformMatrix2x4dv(location, transpose, value);
	}

	public static void glUniformMatrix3x2(int location, boolean transpose, DoubleBuffer value) {
		org.lwjgl.opengl.ARBGPUShaderFP64.glUniformMatrix3x2dv(location, transpose, value);
	}

	public static void glUniformMatrix3x4(int location, boolean transpose, DoubleBuffer value) {
		org.lwjgl.opengl.ARBGPUShaderFP64.glUniformMatrix3x4dv(location, transpose, value);
	}

	public static void glUniformMatrix4x2(int location, boolean transpose, DoubleBuffer value) {
		org.lwjgl.opengl.ARBGPUShaderFP64.glUniformMatrix4x2dv(location, transpose, value);
	}

	public static void glUniformMatrix4x3(int location, boolean transpose, DoubleBuffer value) {
		org.lwjgl.opengl.ARBGPUShaderFP64.glUniformMatrix4x3dv(location, transpose, value);
	}

	public static void glGetUniform(int program, int location, DoubleBuffer params) {
		org.lwjgl.opengl.ARBGPUShaderFP64.glGetUniformdv(program, location, params);
	}

	public static void glProgramUniform1dEXT(int program, int location, double x) {
		org.lwjgl.opengl.ARBGPUShaderFP64.glProgramUniform1dEXT(program, location, x);
	}

	public static void glProgramUniform2dEXT(int program, int location, double x, double y) {
		org.lwjgl.opengl.ARBGPUShaderFP64.glProgramUniform2dEXT(program, location, x, y);
	}

	public static void glProgramUniform3dEXT(int program, int location, double x, double y, double z) {
		org.lwjgl.opengl.ARBGPUShaderFP64.glProgramUniform3dEXT(program, location, x, y, z);
	}

	public static void glProgramUniform4dEXT(int program, int location, double x, double y, double z, double w) {
		org.lwjgl.opengl.ARBGPUShaderFP64.glProgramUniform4dEXT(program, location, x, y, z, w);
	}

	public static void glProgramUniform1EXT(int program, int location, DoubleBuffer value) {
		org.lwjgl.opengl.ARBGPUShaderFP64.glProgramUniform1dvEXT(program, location, value);
	}

	public static void glProgramUniform2EXT(int program, int location, DoubleBuffer value) {
		org.lwjgl.opengl.ARBGPUShaderFP64.glProgramUniform2dvEXT(program, location, value);
	}

	public static void glProgramUniform3EXT(int program, int location, DoubleBuffer value) {
		org.lwjgl.opengl.ARBGPUShaderFP64.glProgramUniform3dvEXT(program, location, value);
	}

	public static void glProgramUniform4EXT(int program, int location, DoubleBuffer value) {
		org.lwjgl.opengl.ARBGPUShaderFP64.glProgramUniform4dvEXT(program, location, value);
	}

	public static void glProgramUniformMatrix2EXT(int program, int location, boolean transpose, DoubleBuffer value) {
		org.lwjgl.opengl.ARBGPUShaderFP64.glProgramUniformMatrix2dvEXT(program, location, transpose, value);
	}

	public static void glProgramUniformMatrix3EXT(int program, int location, boolean transpose, DoubleBuffer value) {
		org.lwjgl.opengl.ARBGPUShaderFP64.glProgramUniformMatrix3dvEXT(program, location, transpose, value);
	}

	public static void glProgramUniformMatrix4EXT(int program, int location, boolean transpose, DoubleBuffer value) {
		org.lwjgl.opengl.ARBGPUShaderFP64.glProgramUniformMatrix4dvEXT(program, location, transpose, value);
	}

	public static void glProgramUniformMatrix2x3EXT(int program, int location, boolean transpose, DoubleBuffer value) {
		org.lwjgl.opengl.ARBGPUShaderFP64.glProgramUniformMatrix2x3dvEXT(program, location, transpose, value);
	}

	public static void glProgramUniformMatrix2x4EXT(int program, int location, boolean transpose, DoubleBuffer value) {
		org.lwjgl.opengl.ARBGPUShaderFP64.glProgramUniformMatrix2x4dvEXT(program, location, transpose, value);
	}

	public static void glProgramUniformMatrix3x2EXT(int program, int location, boolean transpose, DoubleBuffer value) {
		org.lwjgl.opengl.ARBGPUShaderFP64.glProgramUniformMatrix3x2dvEXT(program, location, transpose, value);
	}

	public static void glProgramUniformMatrix3x4EXT(int program, int location, boolean transpose, DoubleBuffer value) {
		org.lwjgl.opengl.ARBGPUShaderFP64.glProgramUniformMatrix3x4dvEXT(program, location, transpose, value);
	}

	public static void glProgramUniformMatrix4x2EXT(int program, int location, boolean transpose, DoubleBuffer value) {
		org.lwjgl.opengl.ARBGPUShaderFP64.glProgramUniformMatrix4x2dvEXT(program, location, transpose, value);
	}

	public static void glProgramUniformMatrix4x3EXT(int program, int location, boolean transpose, DoubleBuffer value) {
		org.lwjgl.opengl.ARBGPUShaderFP64.glProgramUniformMatrix4x3dvEXT(program, location, transpose, value);
	}
}
