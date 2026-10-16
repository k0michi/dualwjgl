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
		return org.lwjgl.opengl.GL32.nglIsSync(sync.getPointer());
	}
	public static void glDeleteSync(GLSync sync) {
		org.lwjgl.opengl.GL32.glDeleteSync(sync.getPointer());
	}
	public static int glClientWaitSync(GLSync sync, int flags, long timeout) {
		return org.lwjgl.opengl.GL32.nglClientWaitSync(sync.getPointer(), flags, timeout);
	}
	public static void glWaitSync(GLSync sync, int flags, long timeout) {
		org.lwjgl.opengl.GL32.nglWaitSync(sync.getPointer(), flags, timeout);
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
		if (org.lwjgl.system.Checks.CHECKS && length != null) org.lwjgl.system.Checks.check(length, 1);
		org.lwjgl.opengl.GL32.nglGetSynciv(sync.getPointer(), pname, values.remaining(), org.lwjgl.system.MemoryUtil.memAddressSafe(length), org.lwjgl.system.MemoryUtil.memAddress(values));
	}
	@Deprecated
	public static int glGetSync(GLSync sync, int pname) {
		try (org.lwjgl.system.MemoryStack __stack = org.lwjgl.system.MemoryStack.stackPush()) {
			java.nio.IntBuffer __values = __stack.mallocInt(2);
			org.lwjgl.opengl.GL32.nglGetSynciv(sync.getPointer(), pname, 1, 0, org.lwjgl.system.MemoryUtil.memAddress(__values));
			return __values.get(0);
		}
	}
	public static int glGetSynci(GLSync sync, int pname) {
		try (org.lwjgl.system.MemoryStack __stack = org.lwjgl.system.MemoryStack.stackPush()) {
			java.nio.IntBuffer __values = __stack.mallocInt(2);
			org.lwjgl.opengl.GL32.nglGetSynciv(sync.getPointer(), pname, 1, 0, org.lwjgl.system.MemoryUtil.memAddress(__values));
			return __values.get(0);
		}
	}
}
