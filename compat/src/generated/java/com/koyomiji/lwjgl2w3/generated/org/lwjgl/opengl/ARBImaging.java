package com.koyomiji.lwjgl2w3.generated.org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

public final class ARBImaging {
	public static final int GL_IGNORE_BORDER = 0x8150;
	public static void glColorTable(int target, int internalFormat, int width, int format, int type, DoubleBuffer data) {
		org.lwjgl.opengl.ARBImaging.nglColorTable(target, internalFormat, width, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(data));
	}
	public static void glColorSubTable(int target, int start, int count, int format, int type, DoubleBuffer data) {
		org.lwjgl.opengl.ARBImaging.nglColorSubTable(target, start, count, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(data));
	}
	public static void glColorSubTable(int target, int start, int count, int format, int type, FloatBuffer data) {
		org.lwjgl.opengl.ARBImaging.nglColorSubTable(target, start, count, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(data));
	}
	public static void glColorTableParameter(int target, int pname, IntBuffer params) {
		org.lwjgl.opengl.ARBImaging.glColorTableParameteriv(target, pname, params);
	}
	public static void glColorTableParameter(int target, int pname, FloatBuffer params) {
		org.lwjgl.opengl.ARBImaging.glColorTableParameterfv(target, pname, params);
	}
	public static void glGetColorTable(int target, int format, int type, DoubleBuffer data) {
		org.lwjgl.opengl.ARBImaging.nglGetColorTable(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(data));
	}
	public static void glGetColorTableParameter(int target, int pname, IntBuffer params) {
		org.lwjgl.opengl.ARBImaging.glGetColorTableParameteriv(target, pname, params);
	}
	public static void glGetColorTableParameter(int target, int pname, FloatBuffer params) {
		org.lwjgl.opengl.ARBImaging.glGetColorTableParameterfv(target, pname, params);
	}
	public static void glGetHistogram(int target, boolean reset, int format, int type, DoubleBuffer values) {
		org.lwjgl.opengl.ARBImaging.nglGetHistogram(target, reset, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(values));
	}
	public static void glGetHistogram(int target, boolean reset, int format, int type, FloatBuffer values) {
		org.lwjgl.opengl.ARBImaging.nglGetHistogram(target, reset, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(values));
	}
	public static void glGetHistogram(int target, boolean reset, int format, int type, IntBuffer values) {
		org.lwjgl.opengl.ARBImaging.nglGetHistogram(target, reset, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(values));
	}
	public static void glGetHistogram(int target, boolean reset, int format, int type, ShortBuffer values) {
		org.lwjgl.opengl.ARBImaging.nglGetHistogram(target, reset, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(values));
	}
	public static void glGetHistogramParameter(int target, int pname, FloatBuffer params) {
		org.lwjgl.opengl.ARBImaging.glGetHistogramParameterfv(target, pname, params);
	}
	public static void glGetHistogramParameter(int target, int pname, IntBuffer params) {
		org.lwjgl.opengl.ARBImaging.glGetHistogramParameteriv(target, pname, params);
	}
	public static void glGetMinmax(int target, boolean reset, int format, int types, DoubleBuffer values) {
		org.lwjgl.opengl.ARBImaging.nglGetMinmax(target, reset, format, types, org.lwjgl.system.MemoryUtil.memAddressSafe(values));
	}
	public static void glGetMinmax(int target, boolean reset, int format, int types, FloatBuffer values) {
		org.lwjgl.opengl.ARBImaging.nglGetMinmax(target, reset, format, types, org.lwjgl.system.MemoryUtil.memAddressSafe(values));
	}
	public static void glGetMinmax(int target, boolean reset, int format, int types, IntBuffer values) {
		org.lwjgl.opengl.ARBImaging.nglGetMinmax(target, reset, format, types, org.lwjgl.system.MemoryUtil.memAddressSafe(values));
	}
	public static void glGetMinmax(int target, boolean reset, int format, int types, ShortBuffer values) {
		org.lwjgl.opengl.ARBImaging.nglGetMinmax(target, reset, format, types, org.lwjgl.system.MemoryUtil.memAddressSafe(values));
	}
	public static void glGetMinmaxParameter(int target, int pname, FloatBuffer params) {
		org.lwjgl.opengl.ARBImaging.glGetMinmaxParameterfv(target, pname, params);
	}
	public static void glGetMinmaxParameter(int target, int pname, IntBuffer params) {
		org.lwjgl.opengl.ARBImaging.glGetMinmaxParameteriv(target, pname, params);
	}
	public static void glConvolutionFilter1D(int target, int internalformat, int width, int format, int type, DoubleBuffer image) {
		org.lwjgl.opengl.ARBImaging.nglConvolutionFilter1D(target, internalformat, width, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(image));
	}
	public static void glConvolutionFilter1D(int target, int internalformat, int width, int format, int type, FloatBuffer image) {
		org.lwjgl.opengl.ARBImaging.nglConvolutionFilter1D(target, internalformat, width, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(image));
	}
	public static void glConvolutionFilter1D(int target, int internalformat, int width, int format, int type, IntBuffer image) {
		org.lwjgl.opengl.ARBImaging.nglConvolutionFilter1D(target, internalformat, width, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(image));
	}
	public static void glConvolutionFilter1D(int target, int internalformat, int width, int format, int type, ShortBuffer image) {
		org.lwjgl.opengl.ARBImaging.nglConvolutionFilter1D(target, internalformat, width, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(image));
	}
	public static void glConvolutionFilter2D(int target, int internalformat, int width, int height, int format, int type, IntBuffer image) {
		org.lwjgl.opengl.ARBImaging.nglConvolutionFilter2D(target, internalformat, width, height, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(image));
	}
	public static void glConvolutionFilter2D(int target, int internalformat, int width, int height, int format, int type, ShortBuffer image) {
		org.lwjgl.opengl.ARBImaging.nglConvolutionFilter2D(target, internalformat, width, height, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(image));
	}
	public static void glConvolutionParameter(int target, int pname, FloatBuffer params) {
		org.lwjgl.opengl.ARBImaging.glConvolutionParameterfv(target, pname, params);
	}
	public static void glConvolutionParameter(int target, int pname, IntBuffer params) {
		org.lwjgl.opengl.ARBImaging.glConvolutionParameteriv(target, pname, params);
	}
	public static void glGetConvolutionFilter(int target, int format, int type, DoubleBuffer image) {
		org.lwjgl.opengl.ARBImaging.nglGetConvolutionFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(image));
	}
	public static void glGetConvolutionFilter(int target, int format, int type, FloatBuffer image) {
		org.lwjgl.opengl.ARBImaging.nglGetConvolutionFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(image));
	}
	public static void glGetConvolutionFilter(int target, int format, int type, IntBuffer image) {
		org.lwjgl.opengl.ARBImaging.nglGetConvolutionFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(image));
	}
	public static void glGetConvolutionFilter(int target, int format, int type, ShortBuffer image) {
		org.lwjgl.opengl.ARBImaging.nglGetConvolutionFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(image));
	}
	public static void glGetConvolutionParameter(int target, int pname, FloatBuffer params) {
		org.lwjgl.opengl.ARBImaging.glGetConvolutionParameterfv(target, pname, params);
	}
	public static void glGetConvolutionParameter(int target, int pname, IntBuffer params) {
		org.lwjgl.opengl.ARBImaging.glGetConvolutionParameteriv(target, pname, params);
	}
	public static void glSeparableFilter2D(int target, int internalformat, int width, int height, int format, int type, ByteBuffer row, DoubleBuffer column) {
		org.lwjgl.opengl.ARBImaging.nglSeparableFilter2D(target, internalformat, width, height, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column));
	}
	public static void glSeparableFilter2D(int target, int internalformat, int width, int height, int format, int type, ByteBuffer row, FloatBuffer column) {
		org.lwjgl.opengl.ARBImaging.nglSeparableFilter2D(target, internalformat, width, height, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column));
	}
	public static void glSeparableFilter2D(int target, int internalformat, int width, int height, int format, int type, ByteBuffer row, IntBuffer column) {
		org.lwjgl.opengl.ARBImaging.nglSeparableFilter2D(target, internalformat, width, height, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column));
	}
	public static void glSeparableFilter2D(int target, int internalformat, int width, int height, int format, int type, ByteBuffer row, ShortBuffer column) {
		org.lwjgl.opengl.ARBImaging.nglSeparableFilter2D(target, internalformat, width, height, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column));
	}
	public static void glSeparableFilter2D(int target, int internalformat, int width, int height, int format, int type, DoubleBuffer row, ByteBuffer column) {
		org.lwjgl.opengl.ARBImaging.nglSeparableFilter2D(target, internalformat, width, height, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column));
	}
	public static void glSeparableFilter2D(int target, int internalformat, int width, int height, int format, int type, DoubleBuffer row, DoubleBuffer column) {
		org.lwjgl.opengl.ARBImaging.nglSeparableFilter2D(target, internalformat, width, height, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column));
	}
	public static void glSeparableFilter2D(int target, int internalformat, int width, int height, int format, int type, DoubleBuffer row, FloatBuffer column) {
		org.lwjgl.opengl.ARBImaging.nglSeparableFilter2D(target, internalformat, width, height, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column));
	}
	public static void glSeparableFilter2D(int target, int internalformat, int width, int height, int format, int type, DoubleBuffer row, IntBuffer column) {
		org.lwjgl.opengl.ARBImaging.nglSeparableFilter2D(target, internalformat, width, height, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column));
	}
	public static void glSeparableFilter2D(int target, int internalformat, int width, int height, int format, int type, DoubleBuffer row, ShortBuffer column) {
		org.lwjgl.opengl.ARBImaging.nglSeparableFilter2D(target, internalformat, width, height, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column));
	}
	public static void glSeparableFilter2D(int target, int internalformat, int width, int height, int format, int type, FloatBuffer row, ByteBuffer column) {
		org.lwjgl.opengl.ARBImaging.nglSeparableFilter2D(target, internalformat, width, height, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column));
	}
	public static void glSeparableFilter2D(int target, int internalformat, int width, int height, int format, int type, FloatBuffer row, DoubleBuffer column) {
		org.lwjgl.opengl.ARBImaging.nglSeparableFilter2D(target, internalformat, width, height, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column));
	}
	public static void glSeparableFilter2D(int target, int internalformat, int width, int height, int format, int type, FloatBuffer row, FloatBuffer column) {
		org.lwjgl.opengl.ARBImaging.nglSeparableFilter2D(target, internalformat, width, height, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column));
	}
	public static void glSeparableFilter2D(int target, int internalformat, int width, int height, int format, int type, FloatBuffer row, IntBuffer column) {
		org.lwjgl.opengl.ARBImaging.nglSeparableFilter2D(target, internalformat, width, height, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column));
	}
	public static void glSeparableFilter2D(int target, int internalformat, int width, int height, int format, int type, FloatBuffer row, ShortBuffer column) {
		org.lwjgl.opengl.ARBImaging.nglSeparableFilter2D(target, internalformat, width, height, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column));
	}
	public static void glSeparableFilter2D(int target, int internalformat, int width, int height, int format, int type, IntBuffer row, ByteBuffer column) {
		org.lwjgl.opengl.ARBImaging.nglSeparableFilter2D(target, internalformat, width, height, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column));
	}
	public static void glSeparableFilter2D(int target, int internalformat, int width, int height, int format, int type, IntBuffer row, DoubleBuffer column) {
		org.lwjgl.opengl.ARBImaging.nglSeparableFilter2D(target, internalformat, width, height, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column));
	}
	public static void glSeparableFilter2D(int target, int internalformat, int width, int height, int format, int type, IntBuffer row, FloatBuffer column) {
		org.lwjgl.opengl.ARBImaging.nglSeparableFilter2D(target, internalformat, width, height, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column));
	}
	public static void glSeparableFilter2D(int target, int internalformat, int width, int height, int format, int type, IntBuffer row, IntBuffer column) {
		org.lwjgl.opengl.ARBImaging.nglSeparableFilter2D(target, internalformat, width, height, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column));
	}
	public static void glSeparableFilter2D(int target, int internalformat, int width, int height, int format, int type, IntBuffer row, ShortBuffer column) {
		org.lwjgl.opengl.ARBImaging.nglSeparableFilter2D(target, internalformat, width, height, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column));
	}
	public static void glSeparableFilter2D(int target, int internalformat, int width, int height, int format, int type, ShortBuffer row, ByteBuffer column) {
		org.lwjgl.opengl.ARBImaging.nglSeparableFilter2D(target, internalformat, width, height, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column));
	}
	public static void glSeparableFilter2D(int target, int internalformat, int width, int height, int format, int type, ShortBuffer row, DoubleBuffer column) {
		org.lwjgl.opengl.ARBImaging.nglSeparableFilter2D(target, internalformat, width, height, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column));
	}
	public static void glSeparableFilter2D(int target, int internalformat, int width, int height, int format, int type, ShortBuffer row, FloatBuffer column) {
		org.lwjgl.opengl.ARBImaging.nglSeparableFilter2D(target, internalformat, width, height, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column));
	}
	public static void glSeparableFilter2D(int target, int internalformat, int width, int height, int format, int type, ShortBuffer row, IntBuffer column) {
		org.lwjgl.opengl.ARBImaging.nglSeparableFilter2D(target, internalformat, width, height, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column));
	}
	public static void glSeparableFilter2D(int target, int internalformat, int width, int height, int format, int type, ShortBuffer row, ShortBuffer column) {
		org.lwjgl.opengl.ARBImaging.nglSeparableFilter2D(target, internalformat, width, height, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column));
	}
	public static void glGetSeparableFilter(int target, int format, int type, ByteBuffer row, ByteBuffer column, DoubleBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, ByteBuffer row, ByteBuffer column, IntBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, ByteBuffer row, ByteBuffer column, ShortBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, ByteBuffer row, DoubleBuffer column, ByteBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, ByteBuffer row, DoubleBuffer column, DoubleBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, ByteBuffer row, DoubleBuffer column, IntBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, ByteBuffer row, DoubleBuffer column, ShortBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, ByteBuffer row, IntBuffer column, ByteBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, ByteBuffer row, IntBuffer column, DoubleBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, ByteBuffer row, IntBuffer column, IntBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, ByteBuffer row, IntBuffer column, ShortBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, ByteBuffer row, ShortBuffer column, ByteBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, ByteBuffer row, ShortBuffer column, DoubleBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, ByteBuffer row, ShortBuffer column, IntBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, ByteBuffer row, ShortBuffer column, ShortBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, DoubleBuffer row, ByteBuffer column, ByteBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, DoubleBuffer row, ByteBuffer column, DoubleBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, DoubleBuffer row, ByteBuffer column, IntBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, DoubleBuffer row, ByteBuffer column, ShortBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, DoubleBuffer row, DoubleBuffer column, ByteBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, DoubleBuffer row, DoubleBuffer column, DoubleBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, DoubleBuffer row, DoubleBuffer column, IntBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, DoubleBuffer row, DoubleBuffer column, ShortBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, DoubleBuffer row, IntBuffer column, ByteBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, DoubleBuffer row, IntBuffer column, DoubleBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, DoubleBuffer row, IntBuffer column, IntBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, DoubleBuffer row, IntBuffer column, ShortBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, DoubleBuffer row, ShortBuffer column, ByteBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, DoubleBuffer row, ShortBuffer column, DoubleBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, DoubleBuffer row, ShortBuffer column, IntBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, DoubleBuffer row, ShortBuffer column, ShortBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, FloatBuffer row, ByteBuffer column, ByteBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, FloatBuffer row, ByteBuffer column, DoubleBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, FloatBuffer row, ByteBuffer column, IntBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, FloatBuffer row, ByteBuffer column, ShortBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, FloatBuffer row, DoubleBuffer column, ByteBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, FloatBuffer row, DoubleBuffer column, DoubleBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, FloatBuffer row, DoubleBuffer column, IntBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, FloatBuffer row, DoubleBuffer column, ShortBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, FloatBuffer row, IntBuffer column, ByteBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, FloatBuffer row, IntBuffer column, DoubleBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, FloatBuffer row, IntBuffer column, IntBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, FloatBuffer row, IntBuffer column, ShortBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, FloatBuffer row, ShortBuffer column, ByteBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, FloatBuffer row, ShortBuffer column, DoubleBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, FloatBuffer row, ShortBuffer column, IntBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, FloatBuffer row, ShortBuffer column, ShortBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, IntBuffer row, ByteBuffer column, ByteBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, IntBuffer row, ByteBuffer column, DoubleBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, IntBuffer row, ByteBuffer column, IntBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, IntBuffer row, ByteBuffer column, ShortBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, IntBuffer row, DoubleBuffer column, ByteBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, IntBuffer row, DoubleBuffer column, DoubleBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, IntBuffer row, DoubleBuffer column, IntBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, IntBuffer row, DoubleBuffer column, ShortBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, IntBuffer row, IntBuffer column, ByteBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, IntBuffer row, IntBuffer column, DoubleBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, IntBuffer row, IntBuffer column, IntBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, IntBuffer row, IntBuffer column, ShortBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, IntBuffer row, ShortBuffer column, ByteBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, IntBuffer row, ShortBuffer column, DoubleBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, IntBuffer row, ShortBuffer column, IntBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, IntBuffer row, ShortBuffer column, ShortBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, ShortBuffer row, ByteBuffer column, ByteBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, ShortBuffer row, ByteBuffer column, DoubleBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, ShortBuffer row, ByteBuffer column, IntBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, ShortBuffer row, ByteBuffer column, ShortBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, ShortBuffer row, DoubleBuffer column, ByteBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, ShortBuffer row, DoubleBuffer column, DoubleBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, ShortBuffer row, DoubleBuffer column, IntBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, ShortBuffer row, DoubleBuffer column, ShortBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, ShortBuffer row, IntBuffer column, ByteBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, ShortBuffer row, IntBuffer column, DoubleBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, ShortBuffer row, IntBuffer column, IntBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, ShortBuffer row, IntBuffer column, ShortBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, ShortBuffer row, ShortBuffer column, ByteBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, ShortBuffer row, ShortBuffer column, DoubleBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, ShortBuffer row, ShortBuffer column, IntBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, ShortBuffer row, ShortBuffer column, ShortBuffer span) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(row), org.lwjgl.system.MemoryUtil.memAddressSafe(column), org.lwjgl.system.MemoryUtil.memAddressSafe(span));
	}
	public static void glGetSeparableFilter(int target, int format, int type, long row_buffer_offset, long column_buffer_offset, long span_buffer_offset) {
		org.lwjgl.opengl.ARBImaging.nglGetSeparableFilter(target, format, type, row_buffer_offset, column_buffer_offset, span_buffer_offset);
	}
}
