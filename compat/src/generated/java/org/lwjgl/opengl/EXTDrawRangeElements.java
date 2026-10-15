package org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Generated;
import com.koyomiji.lwjgl2w3.inject.Todo;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

@Generated
public final class EXTDrawRangeElements {
	public static final int GL_MAX_ELEMENTS_VERTICES_EXT = 0x80E8;
	public static final int GL_MAX_ELEMENTS_INDICES_EXT = 0x80E9;

	private EXTDrawRangeElements() {
	}

	@Todo("gl")
	public static void glDrawRangeElementsEXT(int mode, int start, int end, ByteBuffer pIndices) {
		throw new UnsupportedOperationException();
	}

	@Todo("gl")
	public static void glDrawRangeElementsEXT(int mode, int start, int end, IntBuffer pIndices) {
		throw new UnsupportedOperationException();
	}

	@Todo("gl")
	public static void glDrawRangeElementsEXT(int mode, int start, int end, ShortBuffer pIndices) {
		throw new UnsupportedOperationException();
	}

	@Todo("gl")
	public static void glDrawRangeElementsEXT(int mode, int start, int end, int pIndices_count, int type, long pIndices_buffer_offset) {
		throw new UnsupportedOperationException();
	}
}
