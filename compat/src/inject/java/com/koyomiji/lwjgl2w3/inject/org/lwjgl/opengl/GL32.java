package com.koyomiji.lwjgl2w3.inject.org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Hidden;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import org.lwjgl.opengl.GLSync;

public final class GL32 {
	public static void glGetBufferParameter(int target, int pname, LongBuffer params) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	@Deprecated
	public static long glGetBufferParameter(int target, int pname) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glGetMultisample(int pname, int index, FloatBuffer val) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	@Hidden
	public static GLSync glFenceSync(int condition, int flags) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static boolean glIsSync(GLSync sync) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glDeleteSync(GLSync sync) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static int glClientWaitSync(GLSync sync, int flags, long timeout) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glWaitSync(GLSync sync, int flags, long timeout) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glGetInteger64(int pname, LongBuffer data) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glGetInteger64(int value, int index, LongBuffer data) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static long glGetInteger64(int value, int index) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glGetSync(GLSync sync, int pname, IntBuffer length, IntBuffer values) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	@Deprecated
	public static int glGetSync(GLSync sync, int pname) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static int glGetSynci(GLSync sync, int pname) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
}
