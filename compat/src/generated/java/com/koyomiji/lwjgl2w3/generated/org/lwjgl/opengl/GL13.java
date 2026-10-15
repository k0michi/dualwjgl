package com.koyomiji.lwjgl2w3.generated.org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Todo;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

public final class GL13 {
	@Todo("gl")
	public static void glCompressedTexImage1D(int target, int level, int internalformat, int width, int border, int imageSize) {
		throw new UnsupportedOperationException();
	}
	@Todo("gl")
	public static void glCompressedTexImage2D(int target, int level, int internalformat, int width, int height, int border, int imageSize) {
		throw new UnsupportedOperationException();
	}
	@Todo("gl")
	public static void glCompressedTexImage3D(int target, int level, int internalformat, int width, int height, int depth, int border, int imageSize) {
		throw new UnsupportedOperationException();
	}
	@Todo("gl")
	public static void glGetCompressedTexImage(int target, int lod, IntBuffer img) {
		throw new UnsupportedOperationException();
	}
	@Todo("gl")
	public static void glGetCompressedTexImage(int target, int lod, ShortBuffer img) {
		throw new UnsupportedOperationException();
	}
	public static void glLoadTransposeMatrix(FloatBuffer m) {
		org.lwjgl.opengl.GL13.glLoadTransposeMatrixf(m);
	}
	public static void glLoadTransposeMatrix(DoubleBuffer m) {
		org.lwjgl.opengl.GL13.glLoadTransposeMatrixd(m);
	}
	public static void glMultTransposeMatrix(FloatBuffer m) {
		org.lwjgl.opengl.GL13.glMultTransposeMatrixf(m);
	}
	public static void glMultTransposeMatrix(DoubleBuffer m) {
		org.lwjgl.opengl.GL13.glMultTransposeMatrixd(m);
	}
}
