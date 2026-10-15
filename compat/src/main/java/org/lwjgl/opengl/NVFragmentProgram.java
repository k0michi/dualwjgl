package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;

public final class NVFragmentProgram extends NVProgram {
	public static final int GL_FRAGMENT_PROGRAM_NV = 0x8870;
	public static final int GL_MAX_TEXTURE_COORDS_NV = 0x8871;
	public static final int GL_MAX_TEXTURE_IMAGE_UNITS_NV = 0x8872;
	public static final int GL_FRAGMENT_PROGRAM_BINDING_NV = 0x8873;
	public static final int GL_MAX_FRAGMENT_PROGRAM_LOCAL_PARAMETERS_NV = 0x8868;

	private NVFragmentProgram() {
	}

	public static void glProgramNamedParameter4fNV(int id, ByteBuffer name, float x, float y, float z, float w) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glProgramNamedParameter4dNV(int id, ByteBuffer name, double x, double y, double z, double w) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glGetProgramNamedParameterNV(int id, ByteBuffer name, FloatBuffer params) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glGetProgramNamedParameterNV(int id, ByteBuffer name, DoubleBuffer params) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
}
