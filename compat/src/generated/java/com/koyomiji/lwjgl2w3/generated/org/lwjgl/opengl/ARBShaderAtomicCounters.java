package com.koyomiji.lwjgl2w3.generated.org.lwjgl.opengl;

import java.nio.IntBuffer;

public final class ARBShaderAtomicCounters {
	public static void glGetActiveAtomicCounterBuffer(int program, int bufferIndex, int pname, IntBuffer params) {
		org.lwjgl.opengl.ARBShaderAtomicCounters.glGetActiveAtomicCounterBufferiv(program, bufferIndex, pname, params);
	}
	public static int glGetActiveAtomicCounterBuffer(int program, int bufferIndex, int pname) {
		return org.lwjgl.opengl.ARBShaderAtomicCounters.glGetActiveAtomicCounterBufferi(program, bufferIndex, pname);
	}
}
