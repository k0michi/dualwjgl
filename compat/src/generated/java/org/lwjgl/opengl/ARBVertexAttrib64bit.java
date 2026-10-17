package org.lwjgl.opengl;

import com.koyomiji.dualwjgl.inject.Generated;
import java.nio.DoubleBuffer;

@Generated
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
		org.lwjgl.opengl.ARBVertexAttrib64Bit.glVertexAttribL1d(index, x);
	}

	public static void glVertexAttribL2d(int index, double x, double y) {
		org.lwjgl.opengl.ARBVertexAttrib64Bit.glVertexAttribL2d(index, x, y);
	}

	public static void glVertexAttribL3d(int index, double x, double y, double z) {
		org.lwjgl.opengl.ARBVertexAttrib64Bit.glVertexAttribL3d(index, x, y, z);
	}

	public static void glVertexAttribL4d(int index, double x, double y, double z, double w) {
		org.lwjgl.opengl.ARBVertexAttrib64Bit.glVertexAttribL4d(index, x, y, z, w);
	}

	public static void glVertexAttribL1(int index, DoubleBuffer v) {
		org.lwjgl.opengl.ARBVertexAttrib64Bit.glVertexAttribL1dv(index, v);
	}

	public static void glVertexAttribL2(int index, DoubleBuffer v) {
		org.lwjgl.opengl.ARBVertexAttrib64Bit.glVertexAttribL2dv(index, v);
	}

	public static void glVertexAttribL3(int index, DoubleBuffer v) {
		org.lwjgl.opengl.ARBVertexAttrib64Bit.glVertexAttribL3dv(index, v);
	}

	public static void glVertexAttribL4(int index, DoubleBuffer v) {
		org.lwjgl.opengl.ARBVertexAttrib64Bit.glVertexAttribL4dv(index, v);
	}

	public static void glVertexAttribLPointer(int index, int size, int stride, DoubleBuffer pointer) {
		org.lwjgl.opengl.ARBVertexAttrib64Bit.glVertexAttribLPointer(index, size, stride, pointer);
	}

	public static void glVertexAttribLPointer(int index, int size, int stride, long pointer_buffer_offset) {
		org.lwjgl.opengl.ARBVertexAttrib64Bit.glVertexAttribLPointer(index, size, 5130, stride, pointer_buffer_offset);
	}

	public static void glGetVertexAttribL(int index, int pname, DoubleBuffer params) {
		org.lwjgl.opengl.ARBVertexAttrib64Bit.glGetVertexAttribLdv(index, pname, params);
	}

	public static void glVertexArrayVertexAttribLOffsetEXT(int vaobj, int buffer, int index, int size, int type, int stride, long offset) {
		org.lwjgl.opengl.ARBVertexAttrib64Bit.glVertexArrayVertexAttribLOffsetEXT(vaobj, buffer, index, size, type, stride, offset);
	}
}
