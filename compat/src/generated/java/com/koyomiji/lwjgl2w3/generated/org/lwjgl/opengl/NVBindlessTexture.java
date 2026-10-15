package com.koyomiji.lwjgl2w3.generated.org.lwjgl.opengl;

import java.nio.LongBuffer;

public final class NVBindlessTexture {
	public static void glUniformHandleuNV(int location, LongBuffer value) {
		org.lwjgl.opengl.NVBindlessTexture.glUniformHandleui64vNV(location, value);
	}
	public static void glProgramUniformHandleuNV(int program, int location, LongBuffer values) {
		org.lwjgl.opengl.NVBindlessTexture.glProgramUniformHandleui64vNV(program, location, values);
	}
}
