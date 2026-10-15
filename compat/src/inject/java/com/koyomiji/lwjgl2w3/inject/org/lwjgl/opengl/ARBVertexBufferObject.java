package com.koyomiji.lwjgl2w3.inject.org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Hidden;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public final class ARBVertexBufferObject {
	public static void glGetBufferParameterARB(int target, int pname, IntBuffer params) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	@Deprecated
	public static int glGetBufferParameterARB(int target, int pname) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	@Hidden
	public static ByteBuffer glGetBufferPointerARB(int target, int pname) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
}
