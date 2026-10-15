package com.koyomiji.lwjgl2w3.inject.org.lwjgl.opengl;

import java.nio.IntBuffer;

public final class ARBOcclusionQuery {
	public static void glGetQueryARB(int target, int pname, IntBuffer params) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	@Deprecated
	public static int glGetQueryARB(int target, int pname) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glGetQueryObjectARB(int id, int pname, IntBuffer params) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glGetQueryObjectuARB(int id, int pname, IntBuffer params) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
}
