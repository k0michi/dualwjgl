package com.koyomiji.lwjgl2w3.generated.org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Hidden;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import org.lwjgl.opengl.GLSync;

public final class GL32 {
	public static void glGetBufferParameter(int target, int pname, LongBuffer params) {
		org.lwjgl.opengl.GL32.glGetBufferParameteri64v(target, pname, params);
	}
	@Deprecated
	public static long glGetBufferParameter(int target, int pname) {
		return org.lwjgl.opengl.GL32.glGetBufferParameteri64(target, pname);
	}
	public static void glGetMultisample(int pname, int index, FloatBuffer val) {
		org.lwjgl.opengl.GL32.glGetMultisamplefv(pname, index, val);
	}
	@Hidden
	public static GLSync glFenceSync(int condition, int flags) {
		return new org.lwjgl.opengl.GLSync(org.lwjgl.opengl.GL32.glFenceSync(condition, flags));
	}
	public static boolean glIsSync(GLSync sync) {
		return org.lwjgl.opengl.GL32.glIsSync(sync.getPointer());
	}
	public static void glDeleteSync(GLSync sync) {
		org.lwjgl.opengl.GL32.glDeleteSync(sync.getPointer());
	}
	public static int glClientWaitSync(GLSync sync, int flags, long timeout) {
		return org.lwjgl.opengl.GL32.glClientWaitSync(sync.getPointer(), flags, timeout);
	}
	public static void glWaitSync(GLSync sync, int flags, long timeout) {
		org.lwjgl.opengl.GL32.glWaitSync(sync.getPointer(), flags, timeout);
	}
	public static void glGetInteger64(int pname, LongBuffer data) {
		org.lwjgl.opengl.GL32.glGetInteger64v(pname, data);
	}
	public static void glGetInteger64(int value, int index, LongBuffer data) {
		org.lwjgl.opengl.GL32.glGetInteger64i_v(value, index, data);
	}
	public static long glGetInteger64(int value, int index) {
		return org.lwjgl.opengl.GL32.glGetInteger64i(value, index);
	}
	public static void glGetSync(GLSync sync, int pname, IntBuffer length, IntBuffer values) {
		org.lwjgl.opengl.GL32.glGetSynciv(sync.getPointer(), pname, length, values);
	}
	@Deprecated
	public static int glGetSync(GLSync sync, int pname) {
		return org.lwjgl.opengl.GL32.glGetSynci(sync.getPointer(), pname, (java.nio.IntBuffer)null);
	}
	public static int glGetSynci(GLSync sync, int pname) {
		return org.lwjgl.opengl.GL32.glGetSynci(sync.getPointer(), pname, (java.nio.IntBuffer)null);
	}
}
