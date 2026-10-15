package org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Generated;
import com.koyomiji.lwjgl2w3.inject.Todo;
import java.nio.IntBuffer;

@Generated
public final class NVOcclusionQuery {
	public static final int GL_OCCLUSION_TEST_HP = 0x8165;
	public static final int GL_OCCLUSION_TEST_RESULT_HP = 0x8166;
	public static final int GL_PIXEL_COUNTER_BITS_NV = 0x8864;
	public static final int GL_CURRENT_OCCLUSION_QUERY_ID_NV = 0x8865;
	public static final int GL_PIXEL_COUNT_NV = 0x8866;
	public static final int GL_PIXEL_COUNT_AVAILABLE_NV = 0x8867;

	private NVOcclusionQuery() {
	}

	@Todo("gl")
	public static void glGenOcclusionQueriesNV(IntBuffer piIDs) {
		throw new UnsupportedOperationException();
	}

	@Todo("gl")
	public static int glGenOcclusionQueriesNV() {
		throw new UnsupportedOperationException();
	}

	@Todo("gl")
	public static void glDeleteOcclusionQueriesNV(IntBuffer piIDs) {
		throw new UnsupportedOperationException();
	}

	@Todo("gl")
	public static void glDeleteOcclusionQueriesNV(int piID) {
		throw new UnsupportedOperationException();
	}

	@Todo("gl")
	public static boolean glIsOcclusionQueryNV(int id) {
		throw new UnsupportedOperationException();
	}

	@Todo("gl")
	public static void glBeginOcclusionQueryNV(int id) {
		throw new UnsupportedOperationException();
	}

	@Todo("gl")
	public static void glEndOcclusionQueryNV() {
		throw new UnsupportedOperationException();
	}

	@Todo("gl")
	public static void glGetOcclusionQueryuNV(int id, int pname, IntBuffer params) {
		throw new UnsupportedOperationException();
	}

	@Todo("gl")
	public static int glGetOcclusionQueryuiNV(int id, int pname) {
		throw new UnsupportedOperationException();
	}

	@Todo("gl")
	public static void glGetOcclusionQueryNV(int id, int pname, IntBuffer params) {
		throw new UnsupportedOperationException();
	}

	@Todo("gl")
	public static int glGetOcclusionQueryiNV(int id, int pname) {
		throw new UnsupportedOperationException();
	}
}
