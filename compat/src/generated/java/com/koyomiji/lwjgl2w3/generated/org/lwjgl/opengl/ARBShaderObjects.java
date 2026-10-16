package com.koyomiji.lwjgl2w3.generated.org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public final class ARBShaderObjects {
	public static void glShaderSourceARB(int shader, ByteBuffer string) {
		org.lwjgl.opengl.ARBShaderObjects.nglShaderSourceARB(shader, 1, org.lwjgl.system.MemoryUtil.memAddressSafe(string), org.lwjgl.system.Checks.remainingSafe(string));
	}
	public static void glUniform1ARB(int location, FloatBuffer values) {
		org.lwjgl.opengl.ARBShaderObjects.glUniform1fvARB(location, values);
	}
	public static void glUniform2ARB(int location, FloatBuffer values) {
		org.lwjgl.opengl.ARBShaderObjects.glUniform2fvARB(location, values);
	}
	public static void glUniform3ARB(int location, FloatBuffer values) {
		org.lwjgl.opengl.ARBShaderObjects.glUniform3fvARB(location, values);
	}
	public static void glUniform4ARB(int location, FloatBuffer values) {
		org.lwjgl.opengl.ARBShaderObjects.glUniform4fvARB(location, values);
	}
	public static void glUniform1ARB(int location, IntBuffer values) {
		org.lwjgl.opengl.ARBShaderObjects.glUniform1ivARB(location, values);
	}
	public static void glUniform2ARB(int location, IntBuffer values) {
		org.lwjgl.opengl.ARBShaderObjects.glUniform2ivARB(location, values);
	}
	public static void glUniform3ARB(int location, IntBuffer values) {
		org.lwjgl.opengl.ARBShaderObjects.glUniform3ivARB(location, values);
	}
	public static void glUniform4ARB(int location, IntBuffer values) {
		org.lwjgl.opengl.ARBShaderObjects.glUniform4ivARB(location, values);
	}
	public static void glUniformMatrix2ARB(int location, boolean transpose, FloatBuffer matrices) {
		org.lwjgl.opengl.ARBShaderObjects.glUniformMatrix2fvARB(location, transpose, matrices);
	}
	public static void glUniformMatrix3ARB(int location, boolean transpose, FloatBuffer matrices) {
		org.lwjgl.opengl.ARBShaderObjects.glUniformMatrix3fvARB(location, transpose, matrices);
	}
	public static void glUniformMatrix4ARB(int location, boolean transpose, FloatBuffer matrices) {
		org.lwjgl.opengl.ARBShaderObjects.glUniformMatrix4fvARB(location, transpose, matrices);
	}
	public static void glGetObjectParameterARB(int obj, int pname, FloatBuffer params) {
		org.lwjgl.opengl.ARBShaderObjects.glGetObjectParameterfvARB(obj, pname, params);
	}
	public static float glGetObjectParameterfARB(int obj, int pname) {
		try (org.lwjgl.system.MemoryStack __stack = org.lwjgl.system.MemoryStack.stackPush()) {
			java.nio.FloatBuffer __params = __stack.mallocFloat(2);
			org.lwjgl.opengl.ARBShaderObjects.nglGetObjectParameterfvARB(obj, pname, org.lwjgl.system.MemoryUtil.memAddress(__params));
			return __params.get(0);
		}
	}
	public static void glGetObjectParameterARB(int obj, int pname, IntBuffer params) {
		org.lwjgl.opengl.ARBShaderObjects.glGetObjectParameterivARB(obj, pname, params);
	}
	public static String glGetActiveUniformARB(int programObj, int index, int maxLength, IntBuffer sizeType) {
		if (org.lwjgl.system.Checks.CHECKS) org.lwjgl.system.Checks.check(sizeType, 2);
		try (org.lwjgl.system.MemoryStack __stack = org.lwjgl.system.MemoryStack.stackPush()) {
			java.nio.IntBuffer __name_length = __stack.mallocInt(1);
			java.nio.ByteBuffer __name = org.lwjgl.system.MemoryUtil.memAlloc(Math.max(maxLength, 1));
			try {
				org.lwjgl.opengl.ARBShaderObjects.nglGetActiveUniformARB(programObj, index, maxLength, org.lwjgl.system.MemoryUtil.memAddress(__name_length), org.lwjgl.system.MemoryUtil.memAddress(sizeType), org.lwjgl.system.MemoryUtil.memAddress(sizeType, sizeType.position() + 1), org.lwjgl.system.MemoryUtil.memAddress(__name));
				return org.lwjgl.system.MemoryUtil.memASCII(__name, __name_length.get(0));
			} finally {
				org.lwjgl.system.MemoryUtil.memFree(__name);
			}
		}
	}
	public static String glGetActiveUniformARB(int programObj, int index, int maxLength) {
		try (org.lwjgl.system.MemoryStack __stack = org.lwjgl.system.MemoryStack.stackPush()) {
			java.nio.IntBuffer __name_length = __stack.mallocInt(1);
			java.nio.ByteBuffer __name = org.lwjgl.system.MemoryUtil.memAlloc(Math.max(maxLength, 1));
			java.nio.IntBuffer __scratch = __stack.mallocInt(2);
			try {
				org.lwjgl.opengl.ARBShaderObjects.nglGetActiveUniformARB(programObj, index, maxLength, org.lwjgl.system.MemoryUtil.memAddress(__name_length), org.lwjgl.system.MemoryUtil.memAddress(__scratch), org.lwjgl.system.MemoryUtil.memAddress(__scratch, 1), org.lwjgl.system.MemoryUtil.memAddress(__name));
				return org.lwjgl.system.MemoryUtil.memASCII(__name, __name_length.get(0));
			} finally {
				org.lwjgl.system.MemoryUtil.memFree(__name);
			}
		}
	}
	public static int glGetActiveUniformSizeARB(int programObj, int index) {
		try (org.lwjgl.system.MemoryStack __stack = org.lwjgl.system.MemoryStack.stackPush()) {
			java.nio.IntBuffer __size = __stack.mallocInt(2);
			org.lwjgl.opengl.ARBShaderObjects.nglGetActiveUniformARB(programObj, index, 0, 0, org.lwjgl.system.MemoryUtil.memAddress(__size), org.lwjgl.system.MemoryUtil.memAddress(__size, 1), org.lwjgl.system.MemoryUtil.memAddress(__stack.malloc(1)));
			return __size.get(0);
		}
	}
	public static int glGetActiveUniformTypeARB(int programObj, int index) {
		try (org.lwjgl.system.MemoryStack __stack = org.lwjgl.system.MemoryStack.stackPush()) {
			java.nio.IntBuffer __type = __stack.mallocInt(2);
			org.lwjgl.opengl.ARBShaderObjects.nglGetActiveUniformARB(programObj, index, 0, 0, org.lwjgl.system.MemoryUtil.memAddress(__type, 1), org.lwjgl.system.MemoryUtil.memAddress(__type), org.lwjgl.system.MemoryUtil.memAddress(__stack.malloc(1)));
			return __type.get(0);
		}
	}
	public static void glGetUniformARB(int programObj, int location, FloatBuffer params) {
		org.lwjgl.opengl.ARBShaderObjects.glGetUniformfvARB(programObj, location, params);
	}
	public static void glGetUniformARB(int programObj, int location, IntBuffer params) {
		org.lwjgl.opengl.ARBShaderObjects.glGetUniformivARB(programObj, location, params);
	}
}
