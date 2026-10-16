package com.koyomiji.lwjgl2w3.generated.org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Hidden;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import org.lwjgl.opengl.GLSync;

public final class ARBSync {
	@Hidden
	public static GLSync glFenceSync(int condition, int flags) {
		return new org.lwjgl.opengl.GLSync(org.lwjgl.opengl.ARBSync.glFenceSync(condition, flags));
	}
	public static boolean glIsSync(GLSync sync) {
		return org.lwjgl.opengl.ARBSync.nglIsSync(sync.getPointer());
	}
	public static void glDeleteSync(GLSync sync) {
		org.lwjgl.opengl.ARBSync.glDeleteSync(sync.getPointer());
	}
	public static int glClientWaitSync(GLSync sync, int flags, long timeout) {
		return org.lwjgl.opengl.ARBSync.nglClientWaitSync(sync.getPointer(), flags, timeout);
	}
	public static void glWaitSync(GLSync sync, int flags, long timeout) {
		org.lwjgl.opengl.ARBSync.nglWaitSync(sync.getPointer(), flags, timeout);
	}
	public static void glGetInteger64(int pname, LongBuffer params) {
		org.lwjgl.opengl.ARBSync.glGetInteger64v(pname, params);
	}
	public static void glGetSync(GLSync sync, int pname, IntBuffer length, IntBuffer values) {
		if (org.lwjgl.system.Checks.CHECKS && length != null) org.lwjgl.system.Checks.check(length, 1);
		org.lwjgl.opengl.ARBSync.nglGetSynciv(sync.getPointer(), pname, values.remaining(), org.lwjgl.system.MemoryUtil.memAddressSafe(length), org.lwjgl.system.MemoryUtil.memAddress(values));
	}
	@Deprecated
	public static int glGetSync(GLSync sync, int pname) {
		try (org.lwjgl.system.MemoryStack __stack = org.lwjgl.system.MemoryStack.stackPush()) {
			java.nio.IntBuffer __values = __stack.mallocInt(2);
			org.lwjgl.opengl.ARBSync.nglGetSynciv(sync.getPointer(), pname, 1, 0, org.lwjgl.system.MemoryUtil.memAddress(__values));
			return __values.get(0);
		}
	}
	public static int glGetSynci(GLSync sync, int pname) {
		try (org.lwjgl.system.MemoryStack __stack = org.lwjgl.system.MemoryStack.stackPush()) {
			java.nio.IntBuffer __values = __stack.mallocInt(2);
			org.lwjgl.opengl.ARBSync.nglGetSynciv(sync.getPointer(), pname, 1, 0, org.lwjgl.system.MemoryUtil.memAddress(__values));
			return __values.get(0);
		}
	}
}
