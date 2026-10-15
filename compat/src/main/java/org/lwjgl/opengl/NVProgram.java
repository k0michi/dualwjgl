package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class NVProgram {
	public static final int GL_PROGRAM_TARGET_NV = 0x8646;
	public static final int GL_PROGRAM_LENGTH_NV = 0x8627;
	public static final int GL_PROGRAM_RESIDENT_NV = 0x8647;
	public static final int GL_PROGRAM_STRING_NV = 0x8628;
	public static final int GL_PROGRAM_ERROR_POSITION_NV = 0x864B;
	public static final int GL_PROGRAM_ERROR_STRING_NV = 0x8874;

	public NVProgram() {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glLoadProgramNV(int target, int programID, ByteBuffer string) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glLoadProgramNV(int target, int programID, CharSequence string) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glBindProgramNV(int target, int programID) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glDeleteProgramsNV(IntBuffer programs) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glDeleteProgramsNV(int program) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glGenProgramsNV(IntBuffer programs) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static int glGenProgramsNV() {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glGetProgramNV(int programID, int parameterName, IntBuffer params) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	@Deprecated
	public static int glGetProgramNV(int programID, int parameterName) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static int glGetProgramiNV(int programID, int parameterName) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glGetProgramStringNV(int programID, int parameterName, ByteBuffer paramString) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static String glGetProgramStringNV(int programID, int parameterName) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static boolean glIsProgramNV(int programID) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static boolean glAreProgramsResidentNV(IntBuffer programIDs, ByteBuffer programResidences) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glRequestResidentProgramsNV(IntBuffer programIDs) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glRequestResidentProgramsNV(int programID) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
}
