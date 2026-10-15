package org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Generated;
import com.koyomiji.lwjgl2w3.inject.Todo;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

@Generated
public final class NVEvaluators {
	public static final int GL_EVAL_2D_NV = 0x86C0;
	public static final int GL_EVAL_TRIANGULAR_2D_NV = 0x86C1;
	public static final int GL_MAP_TESSELLATION_NV = 0x86C2;
	public static final int GL_MAP_ATTRIB_U_ORDER_NV = 0x86C3;
	public static final int GL_MAP_ATTRIB_V_ORDER_NV = 0x86C4;
	public static final int GL_EVAL_FRACTIONAL_TESSELLATION_NV = 0x86C5;
	public static final int GL_EVAL_VERTEX_ATTRIB0_NV = 0x86C6;
	public static final int GL_EVAL_VERTEX_ATTRIB1_NV = 0x86C7;
	public static final int GL_EVAL_VERTEX_ATTRIB2_NV = 0x86C8;
	public static final int GL_EVAL_VERTEX_ATTRIB3_NV = 0x86C9;
	public static final int GL_EVAL_VERTEX_ATTRIB4_NV = 0x86CA;
	public static final int GL_EVAL_VERTEX_ATTRIB5_NV = 0x86CB;
	public static final int GL_EVAL_VERTEX_ATTRIB6_NV = 0x86CC;
	public static final int GL_EVAL_VERTEX_ATTRIB7_NV = 0x86CD;
	public static final int GL_EVAL_VERTEX_ATTRIB8_NV = 0x86CE;
	public static final int GL_EVAL_VERTEX_ATTRIB9_NV = 0x86CF;
	public static final int GL_EVAL_VERTEX_ATTRIB10_NV = 0x86D0;
	public static final int GL_EVAL_VERTEX_ATTRIB11_NV = 0x86D1;
	public static final int GL_EVAL_VERTEX_ATTRIB12_NV = 0x86D2;
	public static final int GL_EVAL_VERTEX_ATTRIB13_NV = 0x86D3;
	public static final int GL_EVAL_VERTEX_ATTRIB14_NV = 0x86D4;
	public static final int GL_EVAL_VERTEX_ATTRIB15_NV = 0x86D5;
	public static final int GL_MAX_MAP_TESSELLATION_NV = 0x86D6;
	public static final int GL_MAX_RATIONAL_EVAL_ORDER_NV = 0x86D7;

	private NVEvaluators() {
	}

	@Todo("gl")
	public static void glGetMapControlPointsNV(int target, int index, int type, int ustride, int vstride, boolean packed, FloatBuffer pPoints) {
		throw new UnsupportedOperationException();
	}

	@Todo("gl")
	public static void glMapControlPointsNV(int target, int index, int type, int ustride, int vstride, int uorder, int vorder, boolean packed, FloatBuffer pPoints) {
		throw new UnsupportedOperationException();
	}

	@Todo("gl")
	public static void glMapParameterNV(int target, int pname, FloatBuffer params) {
		throw new UnsupportedOperationException();
	}

	@Todo("gl")
	public static void glMapParameterNV(int target, int pname, IntBuffer params) {
		throw new UnsupportedOperationException();
	}

	@Todo("gl")
	public static void glGetMapParameterNV(int target, int pname, FloatBuffer params) {
		throw new UnsupportedOperationException();
	}

	@Todo("gl")
	public static void glGetMapParameterNV(int target, int pname, IntBuffer params) {
		throw new UnsupportedOperationException();
	}

	@Todo("gl")
	public static void glGetMapAttribParameterNV(int target, int index, int pname, FloatBuffer params) {
		throw new UnsupportedOperationException();
	}

	@Todo("gl")
	public static void glGetMapAttribParameterNV(int target, int index, int pname, IntBuffer params) {
		throw new UnsupportedOperationException();
	}

	@Todo("gl")
	public static void glEvalMapsNV(int target, int mode) {
		throw new UnsupportedOperationException();
	}
}
