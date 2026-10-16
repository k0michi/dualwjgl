package org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Generated;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

@Generated
public class NVProgram {
	public static final int GL_PROGRAM_TARGET_NV = 0x8646;
	public static final int GL_PROGRAM_LENGTH_NV = 0x8627;
	public static final int GL_PROGRAM_RESIDENT_NV = 0x8647;
	public static final int GL_PROGRAM_STRING_NV = 0x8628;
	public static final int GL_PROGRAM_ERROR_POSITION_NV = 0x864B;
	public static final int GL_PROGRAM_ERROR_STRING_NV = 0x8874;

	public NVProgram() {
	}

	public static void glLoadProgramNV(int target, int programID, ByteBuffer string) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glLoadProgramNV(int target, int programID, CharSequence string) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glBindProgramNV(int target, int programID) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glDeleteProgramsNV(IntBuffer programs) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glDeleteProgramsNV(int program) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glGenProgramsNV(IntBuffer programs) {
		throw new IllegalStateException("Function is not supported");
	}

	public static int glGenProgramsNV() {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glGetProgramNV(int programID, int parameterName, IntBuffer params) {
		throw new IllegalStateException("Function is not supported");
	}

	@Deprecated
	public static int glGetProgramNV(int programID, int parameterName) {
		throw new IllegalStateException("Function is not supported");
	}

	public static int glGetProgramiNV(int programID, int parameterName) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glGetProgramStringNV(int programID, int parameterName, ByteBuffer paramString) {
		throw new IllegalStateException("Function is not supported");
	}

	public static String glGetProgramStringNV(int programID, int parameterName) {
		throw new IllegalStateException("Function is not supported");
	}

	public static boolean glIsProgramNV(int programID) {
		throw new IllegalStateException("Function is not supported");
	}

	public static boolean glAreProgramsResidentNV(IntBuffer programIDs, ByteBuffer programResidences) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glRequestResidentProgramsNV(IntBuffer programIDs) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glRequestResidentProgramsNV(int programID) {
		throw new IllegalStateException("Function is not supported");
	}
}
