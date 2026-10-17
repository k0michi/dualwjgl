package com.koyomiji.dualwjgl.generated.org.lwjgl.opengl;

import java.nio.LongBuffer;

public final class NVVertexBufferUnifiedMemory {
	public static void glGetIntegeruNV(int value, int index, LongBuffer result) {
		org.lwjgl.opengl.NVVertexBufferUnifiedMemory.glGetIntegerui64i_vNV(value, index, result);
	}
	public static long glGetIntegerui64NV(int value, int index) {
		return org.lwjgl.opengl.NVVertexBufferUnifiedMemory.glGetIntegerui64iNV(value, index);
	}
}
