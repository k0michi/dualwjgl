package com.koyomiji.lwjgl2w3.inject.org.lwjgl.opengl;

import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public final class GL40 {
	public static final int GL_MIN_PROGRAM_TEXTURE_GATHER_OFFSET_ARB = 0x8E5E;
	public static final int GL_MAX_PROGRAM_TEXTURE_GATHER_OFFSET_ARB = 0x8E5F;
	public static final int GL_MAX_PROGRAM_TEXTURE_GATHER_COMPONENTS_ARB = 0x8F9F;
	public static final int GL_TRANSFORM_FEEDBACK_PAUSED = 0x8E23;
	public static final int GL_TRANSFORM_FEEDBACK_ACTIVE = 0x8E24;
	public static void glUniform1(int location, DoubleBuffer value) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glUniform2(int location, DoubleBuffer value) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glUniform3(int location, DoubleBuffer value) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glUniform4(int location, DoubleBuffer value) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glUniformMatrix2(int location, boolean transpose, DoubleBuffer value) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glUniformMatrix3(int location, boolean transpose, DoubleBuffer value) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glUniformMatrix4(int location, boolean transpose, DoubleBuffer value) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glUniformMatrix2x3(int location, boolean transpose, DoubleBuffer value) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glUniformMatrix2x4(int location, boolean transpose, DoubleBuffer value) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glUniformMatrix3x2(int location, boolean transpose, DoubleBuffer value) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glUniformMatrix3x4(int location, boolean transpose, DoubleBuffer value) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glUniformMatrix4x2(int location, boolean transpose, DoubleBuffer value) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glUniformMatrix4x3(int location, boolean transpose, DoubleBuffer value) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glGetUniform(int program, int location, DoubleBuffer params) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glGetActiveSubroutineUniform(int program, int shadertype, int index, int pname, IntBuffer values) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	@Deprecated
	public static int glGetActiveSubroutineUniform(int program, int shadertype, int index, int pname) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glUniformSubroutinesu(int shadertype, IntBuffer indices) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glGetUniformSubroutineu(int shadertype, int location, IntBuffer params) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	@Deprecated
	public static int glGetUniformSubroutineu(int shadertype, int location) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glGetProgramStage(int program, int shadertype, int pname, IntBuffer values) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	@Deprecated
	public static int glGetProgramStage(int program, int shadertype, int pname) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glPatchParameter(int pname, FloatBuffer values) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glGetQueryIndexed(int target, int index, int pname, IntBuffer params) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	@Deprecated
	public static int glGetQueryIndexed(int target, int index, int pname) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
}
