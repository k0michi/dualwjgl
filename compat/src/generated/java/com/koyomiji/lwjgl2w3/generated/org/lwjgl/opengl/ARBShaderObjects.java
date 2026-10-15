package com.koyomiji.lwjgl2w3.generated.org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Todo;
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
	@Todo("gl")
	public static float glGetObjectParameterfARB(int obj, int pname) {
		throw new UnsupportedOperationException();
	}
	public static void glGetObjectParameterARB(int obj, int pname, IntBuffer params) {
		org.lwjgl.opengl.ARBShaderObjects.glGetObjectParameterivARB(obj, pname, params);
	}
	@Todo("gl")
	public static String glGetActiveUniformARB(int programObj, int index, int maxLength, IntBuffer sizeType) {
		throw new UnsupportedOperationException();
	}
	@Todo("gl")
	public static String glGetActiveUniformARB(int programObj, int index, int maxLength) {
		throw new UnsupportedOperationException();
	}
	@Todo("gl")
	public static int glGetActiveUniformSizeARB(int programObj, int index) {
		throw new UnsupportedOperationException();
	}
	@Todo("gl")
	public static int glGetActiveUniformTypeARB(int programObj, int index) {
		throw new UnsupportedOperationException();
	}
	public static void glGetUniformARB(int programObj, int location, FloatBuffer params) {
		org.lwjgl.opengl.ARBShaderObjects.glGetUniformfvARB(programObj, location, params);
	}
	public static void glGetUniformARB(int programObj, int location, IntBuffer params) {
		org.lwjgl.opengl.ARBShaderObjects.glGetUniformivARB(programObj, location, params);
	}
}
