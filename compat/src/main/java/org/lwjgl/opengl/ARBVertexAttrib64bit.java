package org.lwjgl.opengl;

import java.nio.DoubleBuffer;

public final class ARBVertexAttrib64bit {
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

	private ARBVertexAttrib64bit() {
	}

	public static void glVertexAttribL1d(int index, double x) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glVertexAttribL2d(int index, double x, double y) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glVertexAttribL3d(int index, double x, double y, double z) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glVertexAttribL4d(int index, double x, double y, double z, double w) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glVertexAttribL1(int index, DoubleBuffer v) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glVertexAttribL2(int index, DoubleBuffer v) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glVertexAttribL3(int index, DoubleBuffer v) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glVertexAttribL4(int index, DoubleBuffer v) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glVertexAttribLPointer(int index, int size, int stride, DoubleBuffer pointer) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glVertexAttribLPointer(int index, int size, int stride, long pointer_buffer_offset) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glGetVertexAttribL(int index, int pname, DoubleBuffer params) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glVertexArrayVertexAttribLOffsetEXT(int vaobj, int buffer, int index, int size, int type, int stride, long offset) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
}
