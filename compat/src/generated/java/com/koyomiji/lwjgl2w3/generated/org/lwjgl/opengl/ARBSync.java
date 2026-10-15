package com.koyomiji.lwjgl2w3.generated.org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Hidden;
import com.koyomiji.lwjgl2w3.inject.Todo;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import org.lwjgl.opengl.GLSync;

public final class ARBSync {
	@Hidden
	@Todo("gl")
	public static GLSync glFenceSync(int condition, int flags) {
		throw new UnsupportedOperationException();
	}
	@Todo("gl")
	public static boolean glIsSync(GLSync sync) {
		throw new UnsupportedOperationException();
	}
	@Todo("gl")
	public static void glDeleteSync(GLSync sync) {
		throw new UnsupportedOperationException();
	}
	@Todo("gl")
	public static int glClientWaitSync(GLSync sync, int flags, long timeout) {
		throw new UnsupportedOperationException();
	}
	@Todo("gl")
	public static void glWaitSync(GLSync sync, int flags, long timeout) {
		throw new UnsupportedOperationException();
	}
	public static void glGetInteger64(int pname, LongBuffer params) {
		org.lwjgl.opengl.ARBSync.glGetInteger64v(pname, params);
	}
	@Todo("gl")
	public static void glGetSync(GLSync sync, int pname, IntBuffer length, IntBuffer values) {
		throw new UnsupportedOperationException();
	}
	@Deprecated
	@Todo("gl")
	public static int glGetSync(GLSync sync, int pname) {
		throw new UnsupportedOperationException();
	}
	@Todo("gl")
	public static int glGetSynci(GLSync sync, int pname) {
		throw new UnsupportedOperationException();
	}
}
