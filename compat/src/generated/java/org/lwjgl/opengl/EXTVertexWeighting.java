package org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Generated;
import com.koyomiji.lwjgl2w3.inject.Todo;
import java.nio.FloatBuffer;

@Generated
public final class EXTVertexWeighting {
	public static final int GL_MODELVIEW0_STACK_DEPTH_EXT = 0xBA3;
	public static final int GL_MODELVIEW1_STACK_DEPTH_EXT = 0x8502;
	public static final int GL_MODELVIEW0_MATRIX_EXT = 0xBA6;
	public static final int GL_MODELVIEW1_MATRIX_EXT = 0x8506;
	public static final int GL_VERTEX_WEIGHTING_EXT = 0x8509;
	public static final int GL_MODELVIEW0_EXT = 0x1700;
	public static final int GL_MODELVIEW1_EXT = 0x850A;
	public static final int GL_CURRENT_VERTEX_WEIGHT_EXT = 0x850B;
	public static final int GL_VERTEX_WEIGHT_ARRAY_EXT = 0x850C;
	public static final int GL_VERTEX_WEIGHT_ARRAY_SIZE_EXT = 0x850D;
	public static final int GL_VERTEX_WEIGHT_ARRAY_TYPE_EXT = 0x850E;
	public static final int GL_VERTEX_WEIGHT_ARRAY_STRIDE_EXT = 0x850F;
	public static final int GL_VERTEX_WEIGHT_ARRAY_POINTER_EXT = 0x8510;

	private EXTVertexWeighting() {
	}

	@Todo("gl")
	public static void glVertexWeightfEXT(float weight) {
		throw new UnsupportedOperationException();
	}

	@Todo("gl")
	public static void glVertexWeightPointerEXT(int size, int stride, FloatBuffer pPointer) {
		throw new UnsupportedOperationException();
	}

	@Todo("gl")
	public static void glVertexWeightPointerEXT(int size, int type, int stride, long pPointer_buffer_offset) {
		throw new UnsupportedOperationException();
	}
}
