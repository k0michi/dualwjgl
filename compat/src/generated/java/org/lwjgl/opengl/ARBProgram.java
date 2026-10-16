package org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Generated;
import com.koyomiji.lwjgl2w3.inject.Todo;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

@Generated
public class ARBProgram {
	public static final int GL_PROGRAM_FORMAT_ASCII_ARB = 0x8875;
	public static final int GL_PROGRAM_LENGTH_ARB = 0x8627;
	public static final int GL_PROGRAM_FORMAT_ARB = 0x8876;
	public static final int GL_PROGRAM_BINDING_ARB = 0x8677;
	public static final int GL_PROGRAM_INSTRUCTIONS_ARB = 0x88A0;
	public static final int GL_MAX_PROGRAM_INSTRUCTIONS_ARB = 0x88A1;
	public static final int GL_PROGRAM_NATIVE_INSTRUCTIONS_ARB = 0x88A2;
	public static final int GL_MAX_PROGRAM_NATIVE_INSTRUCTIONS_ARB = 0x88A3;
	public static final int GL_PROGRAM_TEMPORARIES_ARB = 0x88A4;
	public static final int GL_MAX_PROGRAM_TEMPORARIES_ARB = 0x88A5;
	public static final int GL_PROGRAM_NATIVE_TEMPORARIES_ARB = 0x88A6;
	public static final int GL_MAX_PROGRAM_NATIVE_TEMPORARIES_ARB = 0x88A7;
	public static final int GL_PROGRAM_PARAMETERS_ARB = 0x88A8;
	public static final int GL_MAX_PROGRAM_PARAMETERS_ARB = 0x88A9;
	public static final int GL_PROGRAM_NATIVE_PARAMETERS_ARB = 0x88AA;
	public static final int GL_MAX_PROGRAM_NATIVE_PARAMETERS_ARB = 0x88AB;
	public static final int GL_PROGRAM_ATTRIBS_ARB = 0x88AC;
	public static final int GL_MAX_PROGRAM_ATTRIBS_ARB = 0x88AD;
	public static final int GL_PROGRAM_NATIVE_ATTRIBS_ARB = 0x88AE;
	public static final int GL_MAX_PROGRAM_NATIVE_ATTRIBS_ARB = 0x88AF;
	public static final int GL_MAX_PROGRAM_LOCAL_PARAMETERS_ARB = 0x88B4;
	public static final int GL_MAX_PROGRAM_ENV_PARAMETERS_ARB = 0x88B5;
	public static final int GL_PROGRAM_UNDER_NATIVE_LIMITS_ARB = 0x88B6;
	public static final int GL_PROGRAM_STRING_ARB = 0x8628;
	public static final int GL_PROGRAM_ERROR_POSITION_ARB = 0x864B;
	public static final int GL_CURRENT_MATRIX_ARB = 0x8641;
	public static final int GL_TRANSPOSE_CURRENT_MATRIX_ARB = 0x88B7;
	public static final int GL_CURRENT_MATRIX_STACK_DEPTH_ARB = 0x8640;
	public static final int GL_MAX_PROGRAM_MATRICES_ARB = 0x862F;
	public static final int GL_MAX_PROGRAM_MATRIX_STACK_DEPTH_ARB = 0x862E;
	public static final int GL_PROGRAM_ERROR_STRING_ARB = 0x8874;
	public static final int GL_MATRIX0_ARB = 0x88C0;
	public static final int GL_MATRIX1_ARB = 0x88C1;
	public static final int GL_MATRIX2_ARB = 0x88C2;
	public static final int GL_MATRIX3_ARB = 0x88C3;
	public static final int GL_MATRIX4_ARB = 0x88C4;
	public static final int GL_MATRIX5_ARB = 0x88C5;
	public static final int GL_MATRIX6_ARB = 0x88C6;
	public static final int GL_MATRIX7_ARB = 0x88C7;
	public static final int GL_MATRIX8_ARB = 0x88C8;
	public static final int GL_MATRIX9_ARB = 0x88C9;
	public static final int GL_MATRIX10_ARB = 0x88CA;
	public static final int GL_MATRIX11_ARB = 0x88CB;
	public static final int GL_MATRIX12_ARB = 0x88CC;
	public static final int GL_MATRIX13_ARB = 0x88CD;
	public static final int GL_MATRIX14_ARB = 0x88CE;
	public static final int GL_MATRIX15_ARB = 0x88CF;
	public static final int GL_MATRIX16_ARB = 0x88D0;
	public static final int GL_MATRIX17_ARB = 0x88D1;
	public static final int GL_MATRIX18_ARB = 0x88D2;
	public static final int GL_MATRIX19_ARB = 0x88D3;
	public static final int GL_MATRIX20_ARB = 0x88D4;
	public static final int GL_MATRIX21_ARB = 0x88D5;
	public static final int GL_MATRIX22_ARB = 0x88D6;
	public static final int GL_MATRIX23_ARB = 0x88D7;
	public static final int GL_MATRIX24_ARB = 0x88D8;
	public static final int GL_MATRIX25_ARB = 0x88D9;
	public static final int GL_MATRIX26_ARB = 0x88DA;
	public static final int GL_MATRIX27_ARB = 0x88DB;
	public static final int GL_MATRIX28_ARB = 0x88DC;
	public static final int GL_MATRIX29_ARB = 0x88DD;
	public static final int GL_MATRIX30_ARB = 0x88DE;
	public static final int GL_MATRIX31_ARB = 0x88DF;

	@Todo("gl")
	public ARBProgram() {
		throw new UnsupportedOperationException();
	}

	public static void glProgramStringARB(int target, int format, ByteBuffer string) {
		org.lwjgl.opengl.ARBVertexProgram.glProgramStringARB(target, format, string);
	}

	public static void glProgramStringARB(int target, int format, CharSequence string) {
		try (org.lwjgl.system.MemoryStack __stack = org.lwjgl.system.MemoryStack.stackPush()) {
			org.lwjgl.opengl.ARBVertexProgram.nglProgramStringARB(target, format, string.length(), org.lwjgl.system.MemoryUtil.memAddress(__stack.ASCII(string, false)));
		}
	}

	public static void glBindProgramARB(int target, int program) {
		org.lwjgl.opengl.ARBVertexProgram.glBindProgramARB(target, program);
	}

	public static void glDeleteProgramsARB(IntBuffer programs) {
		org.lwjgl.opengl.ARBVertexProgram.glDeleteProgramsARB(programs);
	}

	public static void glDeleteProgramsARB(int program) {
		try (org.lwjgl.system.MemoryStack __stack = org.lwjgl.system.MemoryStack.stackPush()) {
			org.lwjgl.opengl.ARBVertexProgram.nglDeleteProgramsARB(1, org.lwjgl.system.MemoryUtil.memAddress(__stack.ints(program)));
		}
	}

	public static void glGenProgramsARB(IntBuffer programs) {
		org.lwjgl.opengl.ARBVertexProgram.glGenProgramsARB(programs);
	}

	public static int glGenProgramsARB() {
		return org.lwjgl.opengl.ARBVertexProgram.glGenProgramsARB();
	}

	public static void glProgramEnvParameter4fARB(int target, int index, float x, float y, float z, float w) {
		org.lwjgl.opengl.ARBVertexProgram.glProgramEnvParameter4fARB(target, index, x, y, z, w);
	}

	public static void glProgramEnvParameter4dARB(int target, int index, double x, double y, double z, double w) {
		org.lwjgl.opengl.ARBVertexProgram.glProgramEnvParameter4dARB(target, index, x, y, z, w);
	}

	public static void glProgramEnvParameter4ARB(int target, int index, FloatBuffer params) {
		org.lwjgl.opengl.ARBVertexProgram.nglProgramEnvParameter4fvARB(target, index, org.lwjgl.system.MemoryUtil.memAddressSafe(params));
	}

	public static void glProgramEnvParameter4ARB(int target, int index, DoubleBuffer params) {
		org.lwjgl.opengl.ARBVertexProgram.nglProgramEnvParameter4dvARB(target, index, org.lwjgl.system.MemoryUtil.memAddressSafe(params));
	}

	public static void glProgramLocalParameter4fARB(int target, int index, float x, float y, float z, float w) {
		org.lwjgl.opengl.ARBVertexProgram.glProgramLocalParameter4fARB(target, index, x, y, z, w);
	}

	public static void glProgramLocalParameter4dARB(int target, int index, double x, double y, double z, double w) {
		org.lwjgl.opengl.ARBVertexProgram.glProgramLocalParameter4dARB(target, index, x, y, z, w);
	}

	public static void glProgramLocalParameter4ARB(int target, int index, FloatBuffer params) {
		org.lwjgl.opengl.ARBVertexProgram.nglProgramLocalParameter4fvARB(target, index, org.lwjgl.system.MemoryUtil.memAddressSafe(params));
	}

	public static void glProgramLocalParameter4ARB(int target, int index, DoubleBuffer params) {
		org.lwjgl.opengl.ARBVertexProgram.nglProgramLocalParameter4dvARB(target, index, org.lwjgl.system.MemoryUtil.memAddressSafe(params));
	}

	public static void glGetProgramEnvParameterARB(int target, int index, FloatBuffer params) {
		org.lwjgl.opengl.ARBVertexProgram.nglGetProgramEnvParameterfvARB(target, index, org.lwjgl.system.MemoryUtil.memAddressSafe(params));
	}

	public static void glGetProgramEnvParameterARB(int target, int index, DoubleBuffer params) {
		org.lwjgl.opengl.ARBVertexProgram.nglGetProgramEnvParameterdvARB(target, index, org.lwjgl.system.MemoryUtil.memAddressSafe(params));
	}

	public static void glGetProgramLocalParameterARB(int target, int index, FloatBuffer params) {
		org.lwjgl.opengl.ARBVertexProgram.nglGetProgramLocalParameterfvARB(target, index, org.lwjgl.system.MemoryUtil.memAddressSafe(params));
	}

	public static void glGetProgramLocalParameterARB(int target, int index, DoubleBuffer params) {
		org.lwjgl.opengl.ARBVertexProgram.nglGetProgramLocalParameterdvARB(target, index, org.lwjgl.system.MemoryUtil.memAddressSafe(params));
	}

	public static void glGetProgramARB(int target, int parameterName, IntBuffer params) {
		org.lwjgl.opengl.ARBVertexProgram.nglGetProgramivARB(target, parameterName, org.lwjgl.system.MemoryUtil.memAddressSafe(params));
	}

	@Deprecated
	public static int glGetProgramARB(int target, int parameterName) {
		try (org.lwjgl.system.MemoryStack __stack = org.lwjgl.system.MemoryStack.stackPush()) {
			java.nio.IntBuffer __params = __stack.mallocInt(2);
			org.lwjgl.opengl.ARBVertexProgram.nglGetProgramivARB(target, parameterName, org.lwjgl.system.MemoryUtil.memAddress(__params));
			return __params.get(0);
		}
	}

	public static int glGetProgramiARB(int target, int parameterName) {
		return org.lwjgl.opengl.ARBVertexProgram.glGetProgramiARB(target, parameterName);
	}

	public static void glGetProgramStringARB(int target, int parameterName, ByteBuffer paramString) {
		org.lwjgl.opengl.ARBVertexProgram.nglGetProgramStringARB(target, parameterName, org.lwjgl.system.MemoryUtil.memAddressSafe(paramString));
	}

	@Todo("gl")
	public static String glGetProgramStringARB(int target, int parameterName) {
		throw new UnsupportedOperationException();
	}

	public static boolean glIsProgramARB(int program) {
		return org.lwjgl.opengl.ARBVertexProgram.glIsProgramARB(program);
	}
}
