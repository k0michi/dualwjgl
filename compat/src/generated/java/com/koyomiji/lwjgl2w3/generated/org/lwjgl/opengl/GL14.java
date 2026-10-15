package com.koyomiji.lwjgl2w3.generated.org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Todo;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public final class GL14 {
	@Todo("gl")
	public static void glFogCoordPointer(int stride, DoubleBuffer data) {
		throw new UnsupportedOperationException();
	}
	@Todo("gl")
	public static void glFogCoordPointer(int stride, FloatBuffer data) {
		throw new UnsupportedOperationException();
	}
	public static void glPointParameter(int pname, IntBuffer params) {
		org.lwjgl.opengl.GL14.glPointParameteriv(pname, params);
	}
	public static void glPointParameter(int pname, FloatBuffer params) {
		org.lwjgl.opengl.GL14.glPointParameterfv(pname, params);
	}
	@Todo("gl")
	public static void glSecondaryColorPointer(int size, int stride, DoubleBuffer data) {
		throw new UnsupportedOperationException();
	}
	@Todo("gl")
	public static void glSecondaryColorPointer(int size, int stride, FloatBuffer data) {
		throw new UnsupportedOperationException();
	}
	@Todo("gl")
	public static void glSecondaryColorPointer(int size, boolean unsigned, int stride, ByteBuffer data) {
		throw new UnsupportedOperationException();
	}
}
