package com.koyomiji.dualwjgl.generated.org.lwjgl.opengl;

import com.koyomiji.dualwjgl.inject.Hidden;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import org.lwjgl.opengl.GLSync;

public final class ARBSync {
	@Hidden
	public static GLSync glFenceSync(int condition, int flags) {
		return new org.lwjgl.opengl.GLSync(org.lwjgl.opengl.ARBSync.glFenceSync(condition, flags));
	}
	public static boolean glIsSync(GLSync sync) {
		return org.lwjgl.opengl.ARBSync.glIsSync(sync.getPointer());
	}
	public static void glDeleteSync(GLSync sync) {
		org.lwjgl.opengl.ARBSync.glDeleteSync(sync.getPointer());
	}
	public static int glClientWaitSync(GLSync sync, int flags, long timeout) {
		return org.lwjgl.opengl.ARBSync.glClientWaitSync(sync.getPointer(), flags, timeout);
	}
	public static void glWaitSync(GLSync sync, int flags, long timeout) {
		org.lwjgl.opengl.ARBSync.glWaitSync(sync.getPointer(), flags, timeout);
	}
	public static void glGetInteger64(int pname, LongBuffer params) {
		org.lwjgl.opengl.ARBSync.glGetInteger64v(pname, params);
	}
	public static void glGetSync(GLSync sync, int pname, IntBuffer length, IntBuffer values) {
		org.lwjgl.opengl.ARBSync.glGetSynciv(sync.getPointer(), pname, length, values);
	}
	@Deprecated
	public static int glGetSync(GLSync sync, int pname) {
		return org.lwjgl.opengl.ARBSync.glGetSynci(sync.getPointer(), pname, (java.nio.IntBuffer)null);
	}
	public static int glGetSynci(GLSync sync, int pname) {
		return org.lwjgl.opengl.ARBSync.glGetSynci(sync.getPointer(), pname, (java.nio.IntBuffer)null);
	}
}
