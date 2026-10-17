package org.lwjgl.opengl;

import com.koyomiji.dualwjgl.inject.Generated;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

@Generated
public final class NVVertexProgram extends NVProgram {
	public static final int GL_VERTEX_PROGRAM_NV = 0x8620;
	public static final int GL_VERTEX_PROGRAM_POINT_SIZE_NV = 0x8642;
	public static final int GL_VERTEX_PROGRAM_TWO_SIDE_NV = 0x8643;
	public static final int GL_VERTEX_STATE_PROGRAM_NV = 0x8621;
	public static final int GL_ATTRIB_ARRAY_SIZE_NV = 0x8623;
	public static final int GL_ATTRIB_ARRAY_STRIDE_NV = 0x8624;
	public static final int GL_ATTRIB_ARRAY_TYPE_NV = 0x8625;
	public static final int GL_CURRENT_ATTRIB_NV = 0x8626;
	public static final int GL_PROGRAM_PARAMETER_NV = 0x8644;
	public static final int GL_ATTRIB_ARRAY_POINTER_NV = 0x8645;
	public static final int GL_TRACK_MATRIX_NV = 0x8648;
	public static final int GL_TRACK_MATRIX_TRANSFORM_NV = 0x8649;
	public static final int GL_MAX_TRACK_MATRIX_STACK_DEPTH_NV = 0x862E;
	public static final int GL_MAX_TRACK_MATRICES_NV = 0x862F;
	public static final int GL_CURRENT_MATRIX_STACK_DEPTH_NV = 0x8640;
	public static final int GL_CURRENT_MATRIX_NV = 0x8641;
	public static final int GL_VERTEX_PROGRAM_BINDING_NV = 0x864A;
	public static final int GL_MODELVIEW_PROJECTION_NV = 0x8629;
	public static final int GL_MATRIX0_NV = 0x8630;
	public static final int GL_MATRIX1_NV = 0x8631;
	public static final int GL_MATRIX2_NV = 0x8632;
	public static final int GL_MATRIX3_NV = 0x8633;
	public static final int GL_MATRIX4_NV = 0x8634;
	public static final int GL_MATRIX5_NV = 0x8635;
	public static final int GL_MATRIX6_NV = 0x8636;
	public static final int GL_MATRIX7_NV = 0x8637;
	public static final int GL_IDENTITY_NV = 0x862A;
	public static final int GL_INVERSE_NV = 0x862B;
	public static final int GL_TRANSPOSE_NV = 0x862C;
	public static final int GL_INVERSE_TRANSPOSE_NV = 0x862D;
	public static final int GL_VERTEX_ATTRIB_ARRAY0_NV = 0x8650;
	public static final int GL_VERTEX_ATTRIB_ARRAY1_NV = 0x8651;
	public static final int GL_VERTEX_ATTRIB_ARRAY2_NV = 0x8652;
	public static final int GL_VERTEX_ATTRIB_ARRAY3_NV = 0x8653;
	public static final int GL_VERTEX_ATTRIB_ARRAY4_NV = 0x8654;
	public static final int GL_VERTEX_ATTRIB_ARRAY5_NV = 0x8655;
	public static final int GL_VERTEX_ATTRIB_ARRAY6_NV = 0x8656;
	public static final int GL_VERTEX_ATTRIB_ARRAY7_NV = 0x8657;
	public static final int GL_VERTEX_ATTRIB_ARRAY8_NV = 0x8658;
	public static final int GL_VERTEX_ATTRIB_ARRAY9_NV = 0x8659;
	public static final int GL_VERTEX_ATTRIB_ARRAY10_NV = 0x865A;
	public static final int GL_VERTEX_ATTRIB_ARRAY11_NV = 0x865B;
	public static final int GL_VERTEX_ATTRIB_ARRAY12_NV = 0x865C;
	public static final int GL_VERTEX_ATTRIB_ARRAY13_NV = 0x865D;
	public static final int GL_VERTEX_ATTRIB_ARRAY14_NV = 0x865E;
	public static final int GL_VERTEX_ATTRIB_ARRAY15_NV = 0x865F;
	public static final int GL_MAP1_VERTEX_ATTRIB0_4_NV = 0x8660;
	public static final int GL_MAP1_VERTEX_ATTRIB1_4_NV = 0x8661;
	public static final int GL_MAP1_VERTEX_ATTRIB2_4_NV = 0x8662;
	public static final int GL_MAP1_VERTEX_ATTRIB3_4_NV = 0x8663;
	public static final int GL_MAP1_VERTEX_ATTRIB4_4_NV = 0x8664;
	public static final int GL_MAP1_VERTEX_ATTRIB5_4_NV = 0x8665;
	public static final int GL_MAP1_VERTEX_ATTRIB6_4_NV = 0x8666;
	public static final int GL_MAP1_VERTEX_ATTRIB7_4_NV = 0x8667;
	public static final int GL_MAP1_VERTEX_ATTRIB8_4_NV = 0x8668;
	public static final int GL_MAP1_VERTEX_ATTRIB9_4_NV = 0x8669;
	public static final int GL_MAP1_VERTEX_ATTRIB10_4_NV = 0x866A;
	public static final int GL_MAP1_VERTEX_ATTRIB11_4_NV = 0x866B;
	public static final int GL_MAP1_VERTEX_ATTRIB12_4_NV = 0x866C;
	public static final int GL_MAP1_VERTEX_ATTRIB13_4_NV = 0x866D;
	public static final int GL_MAP1_VERTEX_ATTRIB14_4_NV = 0x866E;
	public static final int GL_MAP1_VERTEX_ATTRIB15_4_NV = 0x866F;
	public static final int GL_MAP2_VERTEX_ATTRIB0_4_NV = 0x8670;
	public static final int GL_MAP2_VERTEX_ATTRIB1_4_NV = 0x8671;
	public static final int GL_MAP2_VERTEX_ATTRIB2_4_NV = 0x8672;
	public static final int GL_MAP2_VERTEX_ATTRIB3_4_NV = 0x8673;
	public static final int GL_MAP2_VERTEX_ATTRIB4_4_NV = 0x8674;
	public static final int GL_MAP2_VERTEX_ATTRIB5_4_NV = 0x8675;
	public static final int GL_MAP2_VERTEX_ATTRIB6_4_NV = 0x8676;
	public static final int GL_MAP2_VERTEX_ATTRIB7_4_NV = 0x8677;
	public static final int GL_MAP2_VERTEX_ATTRIB8_4_NV = 0x8678;
	public static final int GL_MAP2_VERTEX_ATTRIB9_4_NV = 0x8679;
	public static final int GL_MAP2_VERTEX_ATTRIB10_4_NV = 0x867A;
	public static final int GL_MAP2_VERTEX_ATTRIB11_4_NV = 0x867B;
	public static final int GL_MAP2_VERTEX_ATTRIB12_4_NV = 0x867C;
	public static final int GL_MAP2_VERTEX_ATTRIB13_4_NV = 0x867D;
	public static final int GL_MAP2_VERTEX_ATTRIB14_4_NV = 0x867E;
	public static final int GL_MAP2_VERTEX_ATTRIB15_4_NV = 0x867F;

	private NVVertexProgram() {
	}

	public static void glExecuteProgramNV(int target, int id, FloatBuffer params) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glGetProgramParameterNV(int target, int index, int parameterName, FloatBuffer params) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glGetProgramParameterNV(int target, int index, int parameterName, DoubleBuffer params) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glGetTrackMatrixNV(int target, int address, int parameterName, IntBuffer params) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glGetVertexAttribNV(int index, int parameterName, FloatBuffer params) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glGetVertexAttribNV(int index, int parameterName, DoubleBuffer params) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glGetVertexAttribNV(int index, int parameterName, IntBuffer params) {
		throw new IllegalStateException("Function is not supported");
	}

	public static ByteBuffer glGetVertexAttribPointerNV(int index, int parameterName, long result_size) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glProgramParameter4fNV(int target, int index, float x, float y, float z, float w) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glProgramParameter4dNV(int target, int index, double x, double y, double z, double w) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glProgramParameters4NV(int target, int index, FloatBuffer params) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glProgramParameters4NV(int target, int index, DoubleBuffer params) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glTrackMatrixNV(int target, int address, int matrix, int transform) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glVertexAttribPointerNV(int index, int size, int type, int stride, DoubleBuffer buffer) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glVertexAttribPointerNV(int index, int size, int type, int stride, FloatBuffer buffer) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glVertexAttribPointerNV(int index, int size, int type, int stride, ByteBuffer buffer) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glVertexAttribPointerNV(int index, int size, int type, int stride, IntBuffer buffer) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glVertexAttribPointerNV(int index, int size, int type, int stride, ShortBuffer buffer) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glVertexAttribPointerNV(int index, int size, int type, int stride, long buffer_buffer_offset) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glVertexAttrib1sNV(int index, short x) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glVertexAttrib1fNV(int index, float x) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glVertexAttrib1dNV(int index, double x) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glVertexAttrib2sNV(int index, short x, short y) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glVertexAttrib2fNV(int index, float x, float y) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glVertexAttrib2dNV(int index, double x, double y) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glVertexAttrib3sNV(int index, short x, short y, short z) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glVertexAttrib3fNV(int index, float x, float y, float z) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glVertexAttrib3dNV(int index, double x, double y, double z) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glVertexAttrib4sNV(int index, short x, short y, short z, short w) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glVertexAttrib4fNV(int index, float x, float y, float z, float w) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glVertexAttrib4dNV(int index, double x, double y, double z, double w) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glVertexAttrib4ubNV(int index, byte x, byte y, byte z, byte w) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glVertexAttribs1NV(int index, ShortBuffer v) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glVertexAttribs1NV(int index, FloatBuffer v) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glVertexAttribs1NV(int index, DoubleBuffer v) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glVertexAttribs2NV(int index, ShortBuffer v) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glVertexAttribs2NV(int index, FloatBuffer v) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glVertexAttribs2NV(int index, DoubleBuffer v) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glVertexAttribs3NV(int index, ShortBuffer v) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glVertexAttribs3NV(int index, FloatBuffer v) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glVertexAttribs3NV(int index, DoubleBuffer v) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glVertexAttribs4NV(int index, ShortBuffer v) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glVertexAttribs4NV(int index, FloatBuffer v) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glVertexAttribs4NV(int index, DoubleBuffer v) {
		throw new IllegalStateException("Function is not supported");
	}
}
