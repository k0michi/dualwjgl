package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

public final class EXTDrawRangeElements {
	public static final int GL_MAX_ELEMENTS_VERTICES_EXT = 0x80E8;
	public static final int GL_MAX_ELEMENTS_INDICES_EXT = 0x80E9;

	private EXTDrawRangeElements() {
	}

	public static void glDrawRangeElementsEXT(int mode, int start, int end, ByteBuffer pIndices) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glDrawRangeElementsEXT(int mode, int start, int end, IntBuffer pIndices) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glDrawRangeElementsEXT(int mode, int start, int end, ShortBuffer pIndices) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glDrawRangeElementsEXT(int mode, int start, int end, int pIndices_count, int type, long pIndices_buffer_offset) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
}
