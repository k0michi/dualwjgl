package org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Generated;
import com.koyomiji.lwjgl2w3.inject.Todo;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;

@Generated
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

	@Todo("gl")
	public static void glFogCoordfEXT(float coord) {
		throw new UnsupportedOperationException();
	}

	@Todo("gl")
	public static void glFogCoorddEXT(double coord) {
		throw new UnsupportedOperationException();
	}

	@Todo("gl")
	public static void glFogCoordPointerEXT(int stride, DoubleBuffer data) {
		throw new UnsupportedOperationException();
	}

	@Todo("gl")
	public static void glFogCoordPointerEXT(int stride, FloatBuffer data) {
		throw new UnsupportedOperationException();
	}

	@Todo("gl")
	public static void glFogCoordPointerEXT(int type, int stride, long data_buffer_offset) {
		throw new UnsupportedOperationException();
	}
}
