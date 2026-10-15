package org.lwjgl.opengl;

import java.nio.IntBuffer;

public final class NVOcclusionQuery {
	public static final int GL_OCCLUSION_TEST_HP = 0x8165;
	public static final int GL_OCCLUSION_TEST_RESULT_HP = 0x8166;
	public static final int GL_PIXEL_COUNTER_BITS_NV = 0x8864;
	public static final int GL_CURRENT_OCCLUSION_QUERY_ID_NV = 0x8865;
	public static final int GL_PIXEL_COUNT_NV = 0x8866;
	public static final int GL_PIXEL_COUNT_AVAILABLE_NV = 0x8867;

	private NVOcclusionQuery() {
	}

	public static void glGenOcclusionQueriesNV(IntBuffer piIDs) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static int glGenOcclusionQueriesNV() {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glDeleteOcclusionQueriesNV(IntBuffer piIDs) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glDeleteOcclusionQueriesNV(int piID) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static boolean glIsOcclusionQueryNV(int id) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glBeginOcclusionQueryNV(int id) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glEndOcclusionQueryNV() {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glGetOcclusionQueryuNV(int id, int pname, IntBuffer params) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static int glGetOcclusionQueryuiNV(int id, int pname) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glGetOcclusionQueryNV(int id, int pname, IntBuffer params) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static int glGetOcclusionQueryiNV(int id, int pname) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
}
