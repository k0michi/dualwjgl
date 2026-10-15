package com.koyomiji.lwjgl2w3.generated.org.lwjgl.opengl;

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
		org.lwjgl.opengl.GL40.glUniform1dv(location, value);
	}
	public static void glUniform2(int location, DoubleBuffer value) {
		org.lwjgl.opengl.GL40.glUniform2dv(location, value);
	}
	public static void glUniform3(int location, DoubleBuffer value) {
		org.lwjgl.opengl.GL40.glUniform3dv(location, value);
	}
	public static void glUniform4(int location, DoubleBuffer value) {
		org.lwjgl.opengl.GL40.glUniform4dv(location, value);
	}
	public static void glUniformMatrix2(int location, boolean transpose, DoubleBuffer value) {
		org.lwjgl.opengl.GL40.glUniformMatrix2dv(location, transpose, value);
	}
	public static void glUniformMatrix3(int location, boolean transpose, DoubleBuffer value) {
		org.lwjgl.opengl.GL40.glUniformMatrix3dv(location, transpose, value);
	}
	public static void glUniformMatrix4(int location, boolean transpose, DoubleBuffer value) {
		org.lwjgl.opengl.GL40.glUniformMatrix4dv(location, transpose, value);
	}
	public static void glUniformMatrix2x3(int location, boolean transpose, DoubleBuffer value) {
		org.lwjgl.opengl.GL40.glUniformMatrix2x3dv(location, transpose, value);
	}
	public static void glUniformMatrix2x4(int location, boolean transpose, DoubleBuffer value) {
		org.lwjgl.opengl.GL40.glUniformMatrix2x4dv(location, transpose, value);
	}
	public static void glUniformMatrix3x2(int location, boolean transpose, DoubleBuffer value) {
		org.lwjgl.opengl.GL40.glUniformMatrix3x2dv(location, transpose, value);
	}
	public static void glUniformMatrix3x4(int location, boolean transpose, DoubleBuffer value) {
		org.lwjgl.opengl.GL40.glUniformMatrix3x4dv(location, transpose, value);
	}
	public static void glUniformMatrix4x2(int location, boolean transpose, DoubleBuffer value) {
		org.lwjgl.opengl.GL40.glUniformMatrix4x2dv(location, transpose, value);
	}
	public static void glUniformMatrix4x3(int location, boolean transpose, DoubleBuffer value) {
		org.lwjgl.opengl.GL40.glUniformMatrix4x3dv(location, transpose, value);
	}
	public static void glGetUniform(int program, int location, DoubleBuffer params) {
		org.lwjgl.opengl.GL40.glGetUniformdv(program, location, params);
	}
	public static void glGetActiveSubroutineUniform(int program, int shadertype, int index, int pname, IntBuffer values) {
		org.lwjgl.opengl.GL40.glGetActiveSubroutineUniformiv(program, shadertype, index, pname, values);
	}
	@Deprecated
	public static int glGetActiveSubroutineUniform(int program, int shadertype, int index, int pname) {
		return org.lwjgl.opengl.GL40.glGetActiveSubroutineUniformi(program, shadertype, index, pname);
	}
	public static void glUniformSubroutinesu(int shadertype, IntBuffer indices) {
		org.lwjgl.opengl.GL40.glUniformSubroutinesuiv(shadertype, indices);
	}
	public static void glGetUniformSubroutineu(int shadertype, int location, IntBuffer params) {
		org.lwjgl.opengl.GL40.glGetUniformSubroutineuiv(shadertype, location, params);
	}
	@Deprecated
	public static int glGetUniformSubroutineu(int shadertype, int location) {
		return org.lwjgl.opengl.GL40.glGetUniformSubroutineui(shadertype, location);
	}
	public static void glGetProgramStage(int program, int shadertype, int pname, IntBuffer values) {
		org.lwjgl.opengl.GL40.glGetProgramStageiv(program, shadertype, pname, values);
	}
	@Deprecated
	public static int glGetProgramStage(int program, int shadertype, int pname) {
		return org.lwjgl.opengl.GL40.glGetProgramStagei(program, shadertype, pname);
	}
	public static void glPatchParameter(int pname, FloatBuffer values) {
		org.lwjgl.opengl.GL40.nglPatchParameterfv(pname, org.lwjgl.system.MemoryUtil.memAddressSafe(values));
	}
	public static void glGetQueryIndexed(int target, int index, int pname, IntBuffer params) {
		org.lwjgl.opengl.GL40.glGetQueryIndexediv(target, index, pname, params);
	}
	@Deprecated
	public static int glGetQueryIndexed(int target, int index, int pname) {
		return org.lwjgl.opengl.GL40.glGetQueryIndexedi(target, index, pname);
	}
}
