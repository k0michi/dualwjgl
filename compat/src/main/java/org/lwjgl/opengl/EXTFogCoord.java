package org.lwjgl.opengl;

import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;

public final class EXTFogCoord {
	public static final int GL_FOG_COORDINATE_SOURCE_EXT = 0x8450;
	public static final int GL_FOG_COORDINATE_EXT = 0x8451;
	public static final int GL_FRAGMENT_DEPTH_EXT = 0x8452;
	public static final int GL_CURRENT_FOG_COORDINATE_EXT = 0x8453;
	public static final int GL_FOG_COORDINATE_ARRAY_TYPE_EXT = 0x8454;
	public static final int GL_FOG_COORDINATE_ARRAY_STRIDE_EXT = 0x8455;
	public static final int GL_FOG_COORDINATE_ARRAY_POINTER_EXT = 0x8456;
	public static final int GL_FOG_COORDINATE_ARRAY_EXT = 0x8457;

	private EXTFogCoord() {
	}

	public static void glFogCoordfEXT(float coord) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glFogCoorddEXT(double coord) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glFogCoordPointerEXT(int stride, DoubleBuffer data) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glFogCoordPointerEXT(int stride, FloatBuffer data) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glFogCoordPointerEXT(int type, int stride, long data_buffer_offset) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
}
