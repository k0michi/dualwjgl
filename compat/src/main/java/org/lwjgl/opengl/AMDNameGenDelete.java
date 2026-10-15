package org.lwjgl.opengl;

import java.nio.IntBuffer;

public final class AMDNameGenDelete {
	public static final int GL_DATA_BUFFER_AMD = 0x9151;
	public static final int GL_PERFORMANCE_MONITOR_AMD = 0x9152;
	public static final int GL_QUERY_OBJECT_AMD = 0x9153;
	public static final int GL_VERTEX_ARRAY_OBJECT_AMD = 0x9154;
	public static final int GL_SAMPLER_OBJECT_AMD = 0x9155;

	private AMDNameGenDelete() {
	}

	public static void glGenNamesAMD(int identifier, IntBuffer names) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static int glGenNamesAMD(int identifier) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glDeleteNamesAMD(int identifier, IntBuffer names) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glDeleteNamesAMD(int identifier, int name) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static boolean glIsNameAMD(int identifier, int name) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
}
