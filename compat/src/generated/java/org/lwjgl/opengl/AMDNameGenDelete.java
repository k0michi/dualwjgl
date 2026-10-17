package org.lwjgl.opengl;

import com.koyomiji.dualwjgl.inject.Generated;
import java.nio.IntBuffer;

@Generated
public final class AMDNameGenDelete {
	public static final int GL_DATA_BUFFER_AMD = 0x9151;
	public static final int GL_PERFORMANCE_MONITOR_AMD = 0x9152;
	public static final int GL_QUERY_OBJECT_AMD = 0x9153;
	public static final int GL_VERTEX_ARRAY_OBJECT_AMD = 0x9154;
	public static final int GL_SAMPLER_OBJECT_AMD = 0x9155;

	private AMDNameGenDelete() {
	}

	public static void glGenNamesAMD(int identifier, IntBuffer names) {
		throw new IllegalStateException("Function is not supported");
	}

	public static int glGenNamesAMD(int identifier) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glDeleteNamesAMD(int identifier, IntBuffer names) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glDeleteNamesAMD(int identifier, int name) {
		throw new IllegalStateException("Function is not supported");
	}

	public static boolean glIsNameAMD(int identifier, int name) {
		throw new IllegalStateException("Function is not supported");
	}
}
