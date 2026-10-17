package com.koyomiji.lwjgl2w3.generated.org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Todo;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

public final class ARBImaging {
	public static final int GL_IGNORE_BORDER = 0x8150;
	public static void glColorTable(int target, int internalFormat, int width, int format, int type, DoubleBuffer data) {
		org.lwjgl.opengl.ARBImaging.glColorTable(target, internalFormat, width, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(data), (org.lwjgl.system.Checks.remainingSafe(data) << 3)));
	}
	public static void glColorSubTable(int target, int start, int count, int format, int type, DoubleBuffer data) {
		org.lwjgl.opengl.ARBImaging.glColorSubTable(target, start, count, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(data), (org.lwjgl.system.Checks.remainingSafe(data) << 3)));
	}
	public static void glColorSubTable(int target, int start, int count, int format, int type, FloatBuffer data) {
		org.lwjgl.opengl.ARBImaging.glColorSubTable(target, start, count, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(data), (org.lwjgl.system.Checks.remainingSafe(data) << 2)));
	}
	public static void glColorTableParameter(int target, int pname, IntBuffer params) {
		org.lwjgl.opengl.ARBImaging.glColorTableParameteriv(target, pname, params);
	}
	public static void glColorTableParameter(int target, int pname, FloatBuffer params) {
		org.lwjgl.opengl.ARBImaging.glColorTableParameterfv(target, pname, params);
	}
	public static void glGetColorTable(int target, int format, int type, DoubleBuffer data) {
		org.lwjgl.opengl.ARBImaging.glGetColorTable(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(data), (org.lwjgl.system.Checks.remainingSafe(data) << 3)));
	}
	public static void glGetColorTableParameter(int target, int pname, IntBuffer params) {
		org.lwjgl.opengl.ARBImaging.glGetColorTableParameteriv(target, pname, params);
	}
	public static void glGetColorTableParameter(int target, int pname, FloatBuffer params) {
		org.lwjgl.opengl.ARBImaging.glGetColorTableParameterfv(target, pname, params);
	}
	public static void glGetHistogram(int target, boolean reset, int format, int type, DoubleBuffer values) {
		org.lwjgl.opengl.ARBImaging.glGetHistogram(target, reset, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(values), (org.lwjgl.system.Checks.remainingSafe(values) << 3)));
	}
	public static void glGetHistogram(int target, boolean reset, int format, int type, FloatBuffer values) {
		org.lwjgl.opengl.ARBImaging.glGetHistogram(target, reset, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(values), (org.lwjgl.system.Checks.remainingSafe(values) << 2)));
	}
	public static void glGetHistogram(int target, boolean reset, int format, int type, IntBuffer values) {
		org.lwjgl.opengl.ARBImaging.glGetHistogram(target, reset, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(values), (org.lwjgl.system.Checks.remainingSafe(values) << 2)));
	}
	public static void glGetHistogram(int target, boolean reset, int format, int type, ShortBuffer values) {
		org.lwjgl.opengl.ARBImaging.glGetHistogram(target, reset, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(values), (org.lwjgl.system.Checks.remainingSafe(values) << 1)));
	}
	public static void glGetHistogramParameter(int target, int pname, FloatBuffer params) {
		org.lwjgl.opengl.ARBImaging.glGetHistogramParameterfv(target, pname, params);
	}
	public static void glGetHistogramParameter(int target, int pname, IntBuffer params) {
		org.lwjgl.opengl.ARBImaging.glGetHistogramParameteriv(target, pname, params);
	}
	public static void glGetMinmax(int target, boolean reset, int format, int types, DoubleBuffer values) {
		org.lwjgl.opengl.ARBImaging.glGetMinmax(target, reset, format, types, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(values), (org.lwjgl.system.Checks.remainingSafe(values) << 3)));
	}
	public static void glGetMinmax(int target, boolean reset, int format, int types, FloatBuffer values) {
		org.lwjgl.opengl.ARBImaging.glGetMinmax(target, reset, format, types, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(values), (org.lwjgl.system.Checks.remainingSafe(values) << 2)));
	}
	public static void glGetMinmax(int target, boolean reset, int format, int types, IntBuffer values) {
		org.lwjgl.opengl.ARBImaging.glGetMinmax(target, reset, format, types, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(values), (org.lwjgl.system.Checks.remainingSafe(values) << 2)));
	}
	public static void glGetMinmax(int target, boolean reset, int format, int types, ShortBuffer values) {
		org.lwjgl.opengl.ARBImaging.glGetMinmax(target, reset, format, types, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(values), (org.lwjgl.system.Checks.remainingSafe(values) << 1)));
	}
	public static void glGetMinmaxParameter(int target, int pname, FloatBuffer params) {
		org.lwjgl.opengl.ARBImaging.glGetMinmaxParameterfv(target, pname, params);
	}
	public static void glGetMinmaxParameter(int target, int pname, IntBuffer params) {
		org.lwjgl.opengl.ARBImaging.glGetMinmaxParameteriv(target, pname, params);
	}
	public static void glConvolutionFilter1D(int target, int internalformat, int width, int format, int type, DoubleBuffer image) {
		org.lwjgl.opengl.ARBImaging.glConvolutionFilter1D(target, internalformat, width, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(image), (org.lwjgl.system.Checks.remainingSafe(image) << 3)));
	}
	public static void glConvolutionFilter1D(int target, int internalformat, int width, int format, int type, FloatBuffer image) {
		org.lwjgl.opengl.ARBImaging.glConvolutionFilter1D(target, internalformat, width, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(image), (org.lwjgl.system.Checks.remainingSafe(image) << 2)));
	}
	public static void glConvolutionFilter1D(int target, int internalformat, int width, int format, int type, IntBuffer image) {
		org.lwjgl.opengl.ARBImaging.glConvolutionFilter1D(target, internalformat, width, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(image), (org.lwjgl.system.Checks.remainingSafe(image) << 2)));
	}
	public static void glConvolutionFilter1D(int target, int internalformat, int width, int format, int type, ShortBuffer image) {
		org.lwjgl.opengl.ARBImaging.glConvolutionFilter1D(target, internalformat, width, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(image), (org.lwjgl.system.Checks.remainingSafe(image) << 1)));
	}
	public static void glConvolutionFilter2D(int target, int internalformat, int width, int height, int format, int type, IntBuffer image) {
		org.lwjgl.opengl.ARBImaging.glConvolutionFilter2D(target, internalformat, width, height, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(image), (org.lwjgl.system.Checks.remainingSafe(image) << 2)));
	}
	public static void glConvolutionFilter2D(int target, int internalformat, int width, int height, int format, int type, ShortBuffer image) {
		org.lwjgl.opengl.ARBImaging.glConvolutionFilter2D(target, internalformat, width, height, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(image), (org.lwjgl.system.Checks.remainingSafe(image) << 1)));
	}
	public static void glConvolutionParameter(int target, int pname, FloatBuffer params) {
		org.lwjgl.opengl.ARBImaging.glConvolutionParameterfv(target, pname, params);
	}
	public static void glConvolutionParameter(int target, int pname, IntBuffer params) {
		org.lwjgl.opengl.ARBImaging.glConvolutionParameteriv(target, pname, params);
	}
	public static void glGetConvolutionFilter(int target, int format, int type, DoubleBuffer image) {
		org.lwjgl.opengl.ARBImaging.glGetConvolutionFilter(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(image), (org.lwjgl.system.Checks.remainingSafe(image) << 3)));
	}
	public static void glGetConvolutionFilter(int target, int format, int type, FloatBuffer image) {
		org.lwjgl.opengl.ARBImaging.glGetConvolutionFilter(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(image), (org.lwjgl.system.Checks.remainingSafe(image) << 2)));
	}
	public static void glGetConvolutionFilter(int target, int format, int type, IntBuffer image) {
		org.lwjgl.opengl.ARBImaging.glGetConvolutionFilter(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(image), (org.lwjgl.system.Checks.remainingSafe(image) << 2)));
	}
	public static void glGetConvolutionFilter(int target, int format, int type, ShortBuffer image) {
		org.lwjgl.opengl.ARBImaging.glGetConvolutionFilter(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(image), (org.lwjgl.system.Checks.remainingSafe(image) << 1)));
	}
	public static void glGetConvolutionParameter(int target, int pname, FloatBuffer params) {
		org.lwjgl.opengl.ARBImaging.glGetConvolutionParameterfv(target, pname, params);
	}
	public static void glGetConvolutionParameter(int target, int pname, IntBuffer params) {
		org.lwjgl.opengl.ARBImaging.glGetConvolutionParameteriv(target, pname, params);
	}
	public static void glSeparableFilter2D(int target, int internalformat, int width, int height, int format, int type, ByteBuffer row, DoubleBuffer column) {
		org.lwjgl.opengl.ARBImaging.glSeparableFilter2D(target, internalformat, width, height, format, type, row, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 3)));
	}
	public static void glSeparableFilter2D(int target, int internalformat, int width, int height, int format, int type, ByteBuffer row, FloatBuffer column) {
		org.lwjgl.opengl.ARBImaging.glSeparableFilter2D(target, internalformat, width, height, format, type, row, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)));
	}
	public static void glSeparableFilter2D(int target, int internalformat, int width, int height, int format, int type, ByteBuffer row, IntBuffer column) {
		org.lwjgl.opengl.ARBImaging.glSeparableFilter2D(target, internalformat, width, height, format, type, row, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)));
	}
	public static void glSeparableFilter2D(int target, int internalformat, int width, int height, int format, int type, ByteBuffer row, ShortBuffer column) {
		org.lwjgl.opengl.ARBImaging.glSeparableFilter2D(target, internalformat, width, height, format, type, row, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 1)));
	}
	public static void glSeparableFilter2D(int target, int internalformat, int width, int height, int format, int type, DoubleBuffer row, ByteBuffer column) {
		org.lwjgl.opengl.ARBImaging.glSeparableFilter2D(target, internalformat, width, height, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 3)), column);
	}
	public static void glSeparableFilter2D(int target, int internalformat, int width, int height, int format, int type, DoubleBuffer row, DoubleBuffer column) {
		org.lwjgl.opengl.ARBImaging.glSeparableFilter2D(target, internalformat, width, height, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 3)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 3)));
	}
	public static void glSeparableFilter2D(int target, int internalformat, int width, int height, int format, int type, DoubleBuffer row, FloatBuffer column) {
		org.lwjgl.opengl.ARBImaging.glSeparableFilter2D(target, internalformat, width, height, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 3)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)));
	}
	public static void glSeparableFilter2D(int target, int internalformat, int width, int height, int format, int type, DoubleBuffer row, IntBuffer column) {
		org.lwjgl.opengl.ARBImaging.glSeparableFilter2D(target, internalformat, width, height, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 3)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)));
	}
	public static void glSeparableFilter2D(int target, int internalformat, int width, int height, int format, int type, DoubleBuffer row, ShortBuffer column) {
		org.lwjgl.opengl.ARBImaging.glSeparableFilter2D(target, internalformat, width, height, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 3)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 1)));
	}
	public static void glSeparableFilter2D(int target, int internalformat, int width, int height, int format, int type, FloatBuffer row, ByteBuffer column) {
		org.lwjgl.opengl.ARBImaging.glSeparableFilter2D(target, internalformat, width, height, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), column);
	}
	public static void glSeparableFilter2D(int target, int internalformat, int width, int height, int format, int type, FloatBuffer row, DoubleBuffer column) {
		org.lwjgl.opengl.ARBImaging.glSeparableFilter2D(target, internalformat, width, height, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 3)));
	}
	public static void glSeparableFilter2D(int target, int internalformat, int width, int height, int format, int type, FloatBuffer row, FloatBuffer column) {
		org.lwjgl.opengl.ARBImaging.glSeparableFilter2D(target, internalformat, width, height, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)));
	}
	public static void glSeparableFilter2D(int target, int internalformat, int width, int height, int format, int type, FloatBuffer row, IntBuffer column) {
		org.lwjgl.opengl.ARBImaging.glSeparableFilter2D(target, internalformat, width, height, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)));
	}
	public static void glSeparableFilter2D(int target, int internalformat, int width, int height, int format, int type, FloatBuffer row, ShortBuffer column) {
		org.lwjgl.opengl.ARBImaging.glSeparableFilter2D(target, internalformat, width, height, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 1)));
	}
	public static void glSeparableFilter2D(int target, int internalformat, int width, int height, int format, int type, IntBuffer row, ByteBuffer column) {
		org.lwjgl.opengl.ARBImaging.glSeparableFilter2D(target, internalformat, width, height, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), column);
	}
	public static void glSeparableFilter2D(int target, int internalformat, int width, int height, int format, int type, IntBuffer row, DoubleBuffer column) {
		org.lwjgl.opengl.ARBImaging.glSeparableFilter2D(target, internalformat, width, height, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 3)));
	}
	public static void glSeparableFilter2D(int target, int internalformat, int width, int height, int format, int type, IntBuffer row, FloatBuffer column) {
		org.lwjgl.opengl.ARBImaging.glSeparableFilter2D(target, internalformat, width, height, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)));
	}
	public static void glSeparableFilter2D(int target, int internalformat, int width, int height, int format, int type, IntBuffer row, IntBuffer column) {
		org.lwjgl.opengl.ARBImaging.glSeparableFilter2D(target, internalformat, width, height, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)));
	}
	public static void glSeparableFilter2D(int target, int internalformat, int width, int height, int format, int type, IntBuffer row, ShortBuffer column) {
		org.lwjgl.opengl.ARBImaging.glSeparableFilter2D(target, internalformat, width, height, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 1)));
	}
	public static void glSeparableFilter2D(int target, int internalformat, int width, int height, int format, int type, ShortBuffer row, ByteBuffer column) {
		org.lwjgl.opengl.ARBImaging.glSeparableFilter2D(target, internalformat, width, height, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 1)), column);
	}
	public static void glSeparableFilter2D(int target, int internalformat, int width, int height, int format, int type, ShortBuffer row, DoubleBuffer column) {
		org.lwjgl.opengl.ARBImaging.glSeparableFilter2D(target, internalformat, width, height, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 1)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 3)));
	}
	public static void glSeparableFilter2D(int target, int internalformat, int width, int height, int format, int type, ShortBuffer row, FloatBuffer column) {
		org.lwjgl.opengl.ARBImaging.glSeparableFilter2D(target, internalformat, width, height, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 1)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)));
	}
	public static void glSeparableFilter2D(int target, int internalformat, int width, int height, int format, int type, ShortBuffer row, IntBuffer column) {
		org.lwjgl.opengl.ARBImaging.glSeparableFilter2D(target, internalformat, width, height, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 1)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)));
	}
	public static void glSeparableFilter2D(int target, int internalformat, int width, int height, int format, int type, ShortBuffer row, ShortBuffer column) {
		org.lwjgl.opengl.ARBImaging.glSeparableFilter2D(target, internalformat, width, height, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 1)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 1)));
	}
	public static void glGetSeparableFilter(int target, int format, int type, ByteBuffer row, ByteBuffer column, DoubleBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, row, column, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 3)));
	}
	public static void glGetSeparableFilter(int target, int format, int type, ByteBuffer row, ByteBuffer column, IntBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, row, column, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 2)));
	}
	public static void glGetSeparableFilter(int target, int format, int type, ByteBuffer row, ByteBuffer column, ShortBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, row, column, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 1)));
	}
	public static void glGetSeparableFilter(int target, int format, int type, ByteBuffer row, DoubleBuffer column, ByteBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, row, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 3)), span);
	}
	public static void glGetSeparableFilter(int target, int format, int type, ByteBuffer row, DoubleBuffer column, DoubleBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, row, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 3)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 3)));
	}
	public static void glGetSeparableFilter(int target, int format, int type, ByteBuffer row, DoubleBuffer column, IntBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, row, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 3)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 2)));
	}
	public static void glGetSeparableFilter(int target, int format, int type, ByteBuffer row, DoubleBuffer column, ShortBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, row, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 3)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 1)));
	}
	public static void glGetSeparableFilter(int target, int format, int type, ByteBuffer row, IntBuffer column, ByteBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, row, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)), span);
	}
	public static void glGetSeparableFilter(int target, int format, int type, ByteBuffer row, IntBuffer column, DoubleBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, row, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 3)));
	}
	public static void glGetSeparableFilter(int target, int format, int type, ByteBuffer row, IntBuffer column, IntBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, row, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 2)));
	}
	public static void glGetSeparableFilter(int target, int format, int type, ByteBuffer row, IntBuffer column, ShortBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, row, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 1)));
	}
	public static void glGetSeparableFilter(int target, int format, int type, ByteBuffer row, ShortBuffer column, ByteBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, row, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 1)), span);
	}
	public static void glGetSeparableFilter(int target, int format, int type, ByteBuffer row, ShortBuffer column, DoubleBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, row, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 1)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 3)));
	}
	public static void glGetSeparableFilter(int target, int format, int type, ByteBuffer row, ShortBuffer column, IntBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, row, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 1)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 2)));
	}
	public static void glGetSeparableFilter(int target, int format, int type, ByteBuffer row, ShortBuffer column, ShortBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, row, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 1)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 1)));
	}
	public static void glGetSeparableFilter(int target, int format, int type, DoubleBuffer row, ByteBuffer column, ByteBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 3)), column, span);
	}
	public static void glGetSeparableFilter(int target, int format, int type, DoubleBuffer row, ByteBuffer column, DoubleBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 3)), column, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 3)));
	}
	public static void glGetSeparableFilter(int target, int format, int type, DoubleBuffer row, ByteBuffer column, IntBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 3)), column, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 2)));
	}
	public static void glGetSeparableFilter(int target, int format, int type, DoubleBuffer row, ByteBuffer column, ShortBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 3)), column, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 1)));
	}
	public static void glGetSeparableFilter(int target, int format, int type, DoubleBuffer row, DoubleBuffer column, ByteBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 3)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 3)), span);
	}
	public static void glGetSeparableFilter(int target, int format, int type, DoubleBuffer row, DoubleBuffer column, DoubleBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 3)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 3)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 3)));
	}
	public static void glGetSeparableFilter(int target, int format, int type, DoubleBuffer row, DoubleBuffer column, IntBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 3)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 3)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 2)));
	}
	public static void glGetSeparableFilter(int target, int format, int type, DoubleBuffer row, DoubleBuffer column, ShortBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 3)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 3)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 1)));
	}
	public static void glGetSeparableFilter(int target, int format, int type, DoubleBuffer row, IntBuffer column, ByteBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 3)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)), span);
	}
	public static void glGetSeparableFilter(int target, int format, int type, DoubleBuffer row, IntBuffer column, DoubleBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 3)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 3)));
	}
	public static void glGetSeparableFilter(int target, int format, int type, DoubleBuffer row, IntBuffer column, IntBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 3)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 2)));
	}
	public static void glGetSeparableFilter(int target, int format, int type, DoubleBuffer row, IntBuffer column, ShortBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 3)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 1)));
	}
	public static void glGetSeparableFilter(int target, int format, int type, DoubleBuffer row, ShortBuffer column, ByteBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 3)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 1)), span);
	}
	public static void glGetSeparableFilter(int target, int format, int type, DoubleBuffer row, ShortBuffer column, DoubleBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 3)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 1)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 3)));
	}
	public static void glGetSeparableFilter(int target, int format, int type, DoubleBuffer row, ShortBuffer column, IntBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 3)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 1)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 2)));
	}
	public static void glGetSeparableFilter(int target, int format, int type, DoubleBuffer row, ShortBuffer column, ShortBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 3)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 1)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 1)));
	}
	public static void glGetSeparableFilter(int target, int format, int type, FloatBuffer row, ByteBuffer column, ByteBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), column, span);
	}
	public static void glGetSeparableFilter(int target, int format, int type, FloatBuffer row, ByteBuffer column, DoubleBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), column, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 3)));
	}
	public static void glGetSeparableFilter(int target, int format, int type, FloatBuffer row, ByteBuffer column, IntBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), column, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 2)));
	}
	public static void glGetSeparableFilter(int target, int format, int type, FloatBuffer row, ByteBuffer column, ShortBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), column, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 1)));
	}
	public static void glGetSeparableFilter(int target, int format, int type, FloatBuffer row, DoubleBuffer column, ByteBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 3)), span);
	}
	public static void glGetSeparableFilter(int target, int format, int type, FloatBuffer row, DoubleBuffer column, DoubleBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 3)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 3)));
	}
	public static void glGetSeparableFilter(int target, int format, int type, FloatBuffer row, DoubleBuffer column, IntBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 3)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 2)));
	}
	public static void glGetSeparableFilter(int target, int format, int type, FloatBuffer row, DoubleBuffer column, ShortBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 3)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 1)));
	}
	public static void glGetSeparableFilter(int target, int format, int type, FloatBuffer row, IntBuffer column, ByteBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)), span);
	}
	public static void glGetSeparableFilter(int target, int format, int type, FloatBuffer row, IntBuffer column, DoubleBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 3)));
	}
	public static void glGetSeparableFilter(int target, int format, int type, FloatBuffer row, IntBuffer column, IntBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 2)));
	}
	public static void glGetSeparableFilter(int target, int format, int type, FloatBuffer row, IntBuffer column, ShortBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 1)));
	}
	public static void glGetSeparableFilter(int target, int format, int type, FloatBuffer row, ShortBuffer column, ByteBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 1)), span);
	}
	public static void glGetSeparableFilter(int target, int format, int type, FloatBuffer row, ShortBuffer column, DoubleBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 1)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 3)));
	}
	public static void glGetSeparableFilter(int target, int format, int type, FloatBuffer row, ShortBuffer column, IntBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 1)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 2)));
	}
	public static void glGetSeparableFilter(int target, int format, int type, FloatBuffer row, ShortBuffer column, ShortBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 1)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 1)));
	}
	public static void glGetSeparableFilter(int target, int format, int type, IntBuffer row, ByteBuffer column, ByteBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), column, span);
	}
	public static void glGetSeparableFilter(int target, int format, int type, IntBuffer row, ByteBuffer column, DoubleBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), column, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 3)));
	}
	public static void glGetSeparableFilter(int target, int format, int type, IntBuffer row, ByteBuffer column, IntBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), column, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 2)));
	}
	public static void glGetSeparableFilter(int target, int format, int type, IntBuffer row, ByteBuffer column, ShortBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), column, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 1)));
	}
	public static void glGetSeparableFilter(int target, int format, int type, IntBuffer row, DoubleBuffer column, ByteBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 3)), span);
	}
	public static void glGetSeparableFilter(int target, int format, int type, IntBuffer row, DoubleBuffer column, DoubleBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 3)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 3)));
	}
	public static void glGetSeparableFilter(int target, int format, int type, IntBuffer row, DoubleBuffer column, IntBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 3)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 2)));
	}
	public static void glGetSeparableFilter(int target, int format, int type, IntBuffer row, DoubleBuffer column, ShortBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 3)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 1)));
	}
	public static void glGetSeparableFilter(int target, int format, int type, IntBuffer row, IntBuffer column, ByteBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)), span);
	}
	public static void glGetSeparableFilter(int target, int format, int type, IntBuffer row, IntBuffer column, DoubleBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 3)));
	}
	public static void glGetSeparableFilter(int target, int format, int type, IntBuffer row, IntBuffer column, IntBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 2)));
	}
	public static void glGetSeparableFilter(int target, int format, int type, IntBuffer row, IntBuffer column, ShortBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 1)));
	}
	public static void glGetSeparableFilter(int target, int format, int type, IntBuffer row, ShortBuffer column, ByteBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 1)), span);
	}
	public static void glGetSeparableFilter(int target, int format, int type, IntBuffer row, ShortBuffer column, DoubleBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 1)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 3)));
	}
	public static void glGetSeparableFilter(int target, int format, int type, IntBuffer row, ShortBuffer column, IntBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 1)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 2)));
	}
	public static void glGetSeparableFilter(int target, int format, int type, IntBuffer row, ShortBuffer column, ShortBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 1)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 1)));
	}
	public static void glGetSeparableFilter(int target, int format, int type, ShortBuffer row, ByteBuffer column, ByteBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 1)), column, span);
	}
	public static void glGetSeparableFilter(int target, int format, int type, ShortBuffer row, ByteBuffer column, DoubleBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 1)), column, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 3)));
	}
	public static void glGetSeparableFilter(int target, int format, int type, ShortBuffer row, ByteBuffer column, IntBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 1)), column, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 2)));
	}
	public static void glGetSeparableFilter(int target, int format, int type, ShortBuffer row, ByteBuffer column, ShortBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 1)), column, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 1)));
	}
	public static void glGetSeparableFilter(int target, int format, int type, ShortBuffer row, DoubleBuffer column, ByteBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 1)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 3)), span);
	}
	public static void glGetSeparableFilter(int target, int format, int type, ShortBuffer row, DoubleBuffer column, DoubleBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 1)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 3)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 3)));
	}
	public static void glGetSeparableFilter(int target, int format, int type, ShortBuffer row, DoubleBuffer column, IntBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 1)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 3)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 2)));
	}
	public static void glGetSeparableFilter(int target, int format, int type, ShortBuffer row, DoubleBuffer column, ShortBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 1)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 3)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 1)));
	}
	public static void glGetSeparableFilter(int target, int format, int type, ShortBuffer row, IntBuffer column, ByteBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 1)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)), span);
	}
	public static void glGetSeparableFilter(int target, int format, int type, ShortBuffer row, IntBuffer column, DoubleBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 1)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 3)));
	}
	public static void glGetSeparableFilter(int target, int format, int type, ShortBuffer row, IntBuffer column, IntBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 1)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 2)));
	}
	public static void glGetSeparableFilter(int target, int format, int type, ShortBuffer row, IntBuffer column, ShortBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 1)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 1)));
	}
	public static void glGetSeparableFilter(int target, int format, int type, ShortBuffer row, ShortBuffer column, ByteBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 1)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 1)), span);
	}
	public static void glGetSeparableFilter(int target, int format, int type, ShortBuffer row, ShortBuffer column, DoubleBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 1)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 1)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 3)));
	}
	public static void glGetSeparableFilter(int target, int format, int type, ShortBuffer row, ShortBuffer column, IntBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 1)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 1)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 2)));
	}
	public static void glGetSeparableFilter(int target, int format, int type, ShortBuffer row, ShortBuffer column, ShortBuffer span) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 1)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 1)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 1)));
	}
	@Todo("gl")
	public static void glGetSeparableFilter(int target, int format, int type, long row_buffer_offset, long column_buffer_offset, long span_buffer_offset) {
		throw new UnsupportedOperationException();
	}
}
