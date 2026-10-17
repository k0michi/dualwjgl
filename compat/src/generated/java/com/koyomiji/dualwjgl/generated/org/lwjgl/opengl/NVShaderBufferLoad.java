package com.koyomiji.dualwjgl.generated.org.lwjgl.opengl;

import java.nio.LongBuffer;

public final class NVShaderBufferLoad {
	public static void glGetBufferParameteruNV(int target, int pname, LongBuffer params) {
		org.lwjgl.opengl.NVShaderBufferLoad.glGetBufferParameterui64vNV(target, pname, params);
	}
	public static void glGetNamedBufferParameteruNV(int buffer, int pname, LongBuffer params) {
		org.lwjgl.opengl.NVShaderBufferLoad.glGetNamedBufferParameterui64vNV(buffer, pname, params);
	}
	public static void glGetIntegeruNV(int value, LongBuffer result) {
		org.lwjgl.opengl.NVShaderBufferLoad.glGetIntegerui64vNV(value, result);
	}
	public static void glUniformuNV(int location, LongBuffer value) {
		org.lwjgl.opengl.NVShaderBufferLoad.glUniformui64vNV(location, value);
	}
	public static void glGetUniformuNV(int program, int location, LongBuffer params) {
		org.lwjgl.opengl.NVShaderBufferLoad.glGetUniformui64vNV(program, location, params);
	}
	public static void glProgramUniformuNV(int program, int location, LongBuffer value) {
		org.lwjgl.opengl.NVShaderBufferLoad.glProgramUniformui64vNV(program, location, value);
	}
}
