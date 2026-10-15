package org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Generated;
import com.koyomiji.lwjgl2w3.inject.Todo;
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

	@Todo("gl")
	public NVProgram() {
		throw new UnsupportedOperationException();
	}

	@Todo("gl")
	public static void glLoadProgramNV(int target, int programID, ByteBuffer string) {
		throw new UnsupportedOperationException();
	}

	@Todo("gl")
	public static void glLoadProgramNV(int target, int programID, CharSequence string) {
		throw new UnsupportedOperationException();
	}

	@Todo("gl")
	public static void glBindProgramNV(int target, int programID) {
		throw new UnsupportedOperationException();
	}

	@Todo("gl")
	public static void glDeleteProgramsNV(IntBuffer programs) {
		throw new UnsupportedOperationException();
	}

	@Todo("gl")
	public static void glDeleteProgramsNV(int program) {
		throw new UnsupportedOperationException();
	}

	@Todo("gl")
	public static void glGenProgramsNV(IntBuffer programs) {
		throw new UnsupportedOperationException();
	}

	@Todo("gl")
	public static int glGenProgramsNV() {
		throw new UnsupportedOperationException();
	}

	@Todo("gl")
	public static void glGetProgramNV(int programID, int parameterName, IntBuffer params) {
		throw new UnsupportedOperationException();
	}

	@Deprecated
	@Todo("gl")
	public static int glGetProgramNV(int programID, int parameterName) {
		throw new UnsupportedOperationException();
	}

	@Todo("gl")
	public static int glGetProgramiNV(int programID, int parameterName) {
		throw new UnsupportedOperationException();
	}

	@Todo("gl")
	public static void glGetProgramStringNV(int programID, int parameterName, ByteBuffer paramString) {
		throw new UnsupportedOperationException();
	}

	@Todo("gl")
	public static String glGetProgramStringNV(int programID, int parameterName) {
		throw new UnsupportedOperationException();
	}

	@Todo("gl")
	public static boolean glIsProgramNV(int programID) {
		throw new UnsupportedOperationException();
	}

	@Todo("gl")
	public static boolean glAreProgramsResidentNV(IntBuffer programIDs, ByteBuffer programResidences) {
		throw new UnsupportedOperationException();
	}

	@Todo("gl")
	public static void glRequestResidentProgramsNV(IntBuffer programIDs) {
		throw new UnsupportedOperationException();
	}

	@Todo("gl")
	public static void glRequestResidentProgramsNV(int programID) {
		throw new UnsupportedOperationException();
	}
}
