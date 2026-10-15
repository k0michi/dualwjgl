package com.koyomiji.lwjgl2w3.generated.org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Todo;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

public final class ARBVertexShader {
	@Todo("gl")
	public static void glVertexAttribPointerARB(int index, int size, boolean normalized, int stride, DoubleBuffer buffer) {
		throw new UnsupportedOperationException();
	}
	@Todo("gl")
	public static void glVertexAttribPointerARB(int index, int size, boolean normalized, int stride, FloatBuffer buffer) {
		throw new UnsupportedOperationException();
	}
	@Todo("gl")
	public static void glVertexAttribPointerARB(int index, int size, boolean unsigned, boolean normalized, int stride, ByteBuffer buffer) {
		throw new UnsupportedOperationException();
	}
	@Todo("gl")
	public static void glVertexAttribPointerARB(int index, int size, boolean unsigned, boolean normalized, int stride, IntBuffer buffer) {
		throw new UnsupportedOperationException();
	}
	@Todo("gl")
	public static void glVertexAttribPointerARB(int index, int size, boolean unsigned, boolean normalized, int stride, ShortBuffer buffer) {
		throw new UnsupportedOperationException();
	}
	@Todo("gl")
	public static String glGetActiveAttribARB(int programObj, int index, int maxLength, IntBuffer sizeType) {
		throw new UnsupportedOperationException();
	}
	@Todo("gl")
	public static String glGetActiveAttribARB(int programObj, int index, int maxLength) {
		throw new UnsupportedOperationException();
	}
	@Todo("gl")
	public static int glGetActiveAttribSizeARB(int programObj, int index) {
		throw new UnsupportedOperationException();
	}
	@Todo("gl")
	public static int glGetActiveAttribTypeARB(int programObj, int index) {
		throw new UnsupportedOperationException();
	}
	public static void glGetVertexAttribARB(int index, int pname, FloatBuffer params) {
		org.lwjgl.opengl.ARBVertexShader.glGetVertexAttribfvARB(index, pname, params);
	}
	public static void glGetVertexAttribARB(int index, int pname, DoubleBuffer params) {
		org.lwjgl.opengl.ARBVertexShader.glGetVertexAttribdvARB(index, pname, params);
	}
	public static void glGetVertexAttribARB(int index, int pname, IntBuffer params) {
		org.lwjgl.opengl.ARBVertexShader.glGetVertexAttribivARB(index, pname, params);
	}
	@Todo("gl")
	public static ByteBuffer glGetVertexAttribPointerARB(int index, int pname, long result_size) {
		throw new UnsupportedOperationException();
	}
}
