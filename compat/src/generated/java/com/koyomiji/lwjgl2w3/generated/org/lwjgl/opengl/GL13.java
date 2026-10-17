package com.koyomiji.lwjgl2w3.generated.org.lwjgl.opengl;

import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

public final class GL13 {
	public static void glCompressedTexImage1D(int target, int level, int internalformat, int width, int border, int imageSize) {
		org.lwjgl.opengl.GL13.glCompressedTexImage1D(target, level, internalformat, width, border, imageSize, 0L);
	}
	public static void glCompressedTexImage2D(int target, int level, int internalformat, int width, int height, int border, int imageSize) {
		org.lwjgl.opengl.GL13.glCompressedTexImage2D(target, level, internalformat, width, height, border, imageSize, 0L);
	}
	public static void glCompressedTexImage3D(int target, int level, int internalformat, int width, int height, int depth, int border, int imageSize) {
		org.lwjgl.opengl.GL13.glCompressedTexImage3D(target, level, internalformat, width, height, depth, border, imageSize, 0L);
	}
	public static void glGetCompressedTexImage(int target, int lod, IntBuffer img) {
		org.lwjgl.opengl.GL13.glGetCompressedTexImage(target, lod, org.lwjgl.system.MemoryUtil.memAddressSafe(img));
	}
	public static void glGetCompressedTexImage(int target, int lod, ShortBuffer img) {
		org.lwjgl.opengl.GL13.glGetCompressedTexImage(target, lod, org.lwjgl.system.MemoryUtil.memAddressSafe(img));
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
