package com.koyomiji.lwjgl2w3.inject.org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Hidden;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public final class GL15 {
	public static void glGetBufferParameter(int target, int pname, IntBuffer params) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	@Deprecated
	public static int glGetBufferParameter(int target, int pname) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	@Hidden
	public static ByteBuffer glGetBufferPointer(int target, int pname) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glGetQuery(int target, int pname, IntBuffer params) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	@Deprecated
	public static int glGetQuery(int target, int pname) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glGetQueryObject(int id, int pname, IntBuffer params) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glGetQueryObjectu(int id, int pname, IntBuffer params) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
}
