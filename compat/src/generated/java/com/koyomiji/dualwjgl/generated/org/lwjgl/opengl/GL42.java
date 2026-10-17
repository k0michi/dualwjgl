package com.koyomiji.dualwjgl.generated.org.lwjgl.opengl;

import java.nio.IntBuffer;

public final class GL42 {
	public static final int IMAGE_FORMAT_COMPATIBILITY_BY_CLASS = 0x90C9;
	public static void glGetActiveAtomicCounterBuffer(int program, int bufferIndex, int pname, IntBuffer params) {
		org.lwjgl.opengl.GL42.glGetActiveAtomicCounterBufferiv(program, bufferIndex, pname, params);
	}
	public static int glGetActiveAtomicCounterBuffer(int program, int bufferIndex, int pname) {
		return org.lwjgl.opengl.GL42.glGetActiveAtomicCounterBufferi(program, bufferIndex, pname);
	}
	public static void glGetInternalformat(int target, int internalformat, int pname, IntBuffer params) {
		org.lwjgl.opengl.GL42.glGetInternalformativ(target, internalformat, pname, params);
	}
	public static int glGetInternalformat(int target, int internalformat, int pname) {
		return org.lwjgl.opengl.GL42.glGetInternalformati(target, internalformat, pname);
	}
}
