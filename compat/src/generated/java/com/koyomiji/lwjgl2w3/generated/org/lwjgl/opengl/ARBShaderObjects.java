package com.koyomiji.lwjgl2w3.generated.org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Todo;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public final class ARBShaderObjects {
	@Todo("gl")
	public static void glShaderSourceARB(int shader, ByteBuffer string) {
		throw new UnsupportedOperationException();
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
			java.nio.FloatBuffer __t2 = __stack.mallocFloat(1);
			org.lwjgl.opengl.ARBShaderObjects.glGetObjectParameterfvARB(obj, pname, __t2);
			return __t2.get(0);
		}
	}
	public static void glGetObjectParameterARB(int obj, int pname, IntBuffer params) {
		org.lwjgl.opengl.ARBShaderObjects.glGetObjectParameterivARB(obj, pname, params);
	}
	public static String glGetActiveUniformARB(int programObj, int index, int maxLength, IntBuffer sizeType) {
		return org.lwjgl.opengl.ARBShaderObjects.glGetActiveUniformARB(programObj, index, maxLength, sizeType, org.lwjgl.system.MemoryUtil.memIntBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(sizeType) + 4, (org.lwjgl.system.Checks.remainingSafe(sizeType) - 1)));
	}
	public static String glGetActiveUniformARB(int programObj, int index, int maxLength) {
		try (org.lwjgl.system.MemoryStack __stack = org.lwjgl.system.MemoryStack.stackPush()) {
			java.nio.IntBuffer __t3 = __stack.mallocInt(1);
			java.nio.IntBuffer __t4 = __stack.mallocInt(1);
			return org.lwjgl.opengl.ARBShaderObjects.glGetActiveUniformARB(programObj, index, maxLength, __t3, __t4);
		}
	}
	public static int glGetActiveUniformSizeARB(int programObj, int index) {
		try (org.lwjgl.system.MemoryStack __stack = org.lwjgl.system.MemoryStack.stackPush()) {
			java.nio.IntBuffer __t3 = __stack.mallocInt(1);
			java.nio.IntBuffer __t4 = __stack.mallocInt(1);
			java.nio.ByteBuffer __t5 = __stack.malloc(0);
			org.lwjgl.opengl.ARBShaderObjects.glGetActiveUniformARB(programObj, index, (java.nio.IntBuffer)null, __t3, __t4, __t5);
			return __t3.get(0);
		}
	}
	public static int glGetActiveUniformTypeARB(int programObj, int index) {
		try (org.lwjgl.system.MemoryStack __stack = org.lwjgl.system.MemoryStack.stackPush()) {
			java.nio.IntBuffer __t3 = __stack.mallocInt(1);
			java.nio.IntBuffer __t4 = __stack.mallocInt(1);
			java.nio.ByteBuffer __t5 = __stack.malloc(0);
			org.lwjgl.opengl.ARBShaderObjects.glGetActiveUniformARB(programObj, index, (java.nio.IntBuffer)null, __t3, __t4, __t5);
			return __t4.get(0);
		}
	}
	public static void glGetUniformARB(int programObj, int location, FloatBuffer params) {
		org.lwjgl.opengl.ARBShaderObjects.glGetUniformfvARB(programObj, location, params);
	}
	public static void glGetUniformARB(int programObj, int location, IntBuffer params) {
		org.lwjgl.opengl.ARBShaderObjects.glGetUniformivARB(programObj, location, params);
	}
}
