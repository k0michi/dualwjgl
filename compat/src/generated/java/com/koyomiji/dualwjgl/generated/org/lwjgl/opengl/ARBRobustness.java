package com.koyomiji.dualwjgl.generated.org.lwjgl.opengl;

import com.koyomiji.dualwjgl.inject.Todo;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

public final class ARBRobustness {
	public static void glReadnPixelsARB(int x, int y, int width, int height, int format, int type, DoubleBuffer data) {
		org.lwjgl.opengl.ARBRobustness.glReadnPixelsARB(x, y, width, height, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(data), (org.lwjgl.system.Checks.remainingSafe(data) << 3)));
	}
	public static void glGetnColorTableARB(int target, int format, int type, DoubleBuffer table) {
		org.lwjgl.opengl.ARBRobustness.glGetnColorTableARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(table), (org.lwjgl.system.Checks.remainingSafe(table) << 3)));
	}
	public static void glGetnConvolutionFilterARB(int target, int format, int type, DoubleBuffer image) {
		org.lwjgl.opengl.ARBRobustness.glGetnConvolutionFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(image), (org.lwjgl.system.Checks.remainingSafe(image) << 3)));
	}
	public static void glGetnConvolutionFilterARB(int target, int format, int type, FloatBuffer image) {
		org.lwjgl.opengl.ARBRobustness.glGetnConvolutionFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(image), (org.lwjgl.system.Checks.remainingSafe(image) << 2)));
	}
	public static void glGetnConvolutionFilterARB(int target, int format, int type, IntBuffer image) {
		org.lwjgl.opengl.ARBRobustness.glGetnConvolutionFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(image), (org.lwjgl.system.Checks.remainingSafe(image) << 2)));
	}
	public static void glGetnConvolutionFilterARB(int target, int format, int type, ShortBuffer image) {
		org.lwjgl.opengl.ARBRobustness.glGetnConvolutionFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(image), (org.lwjgl.system.Checks.remainingSafe(image) << 1)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, ByteBuffer row, ByteBuffer column, DoubleBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, row, column, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 3)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, ByteBuffer row, ByteBuffer column, FloatBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, row, column, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 2)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, ByteBuffer row, ByteBuffer column, IntBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, row, column, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 2)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, ByteBuffer row, ByteBuffer column, ShortBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, row, column, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 1)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, ByteBuffer row, DoubleBuffer column, ByteBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, row, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 3)), span);
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, ByteBuffer row, DoubleBuffer column, DoubleBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, row, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 3)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 3)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, ByteBuffer row, DoubleBuffer column, FloatBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, row, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 3)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 2)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, ByteBuffer row, DoubleBuffer column, IntBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, row, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 3)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 2)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, ByteBuffer row, DoubleBuffer column, ShortBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, row, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 3)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 1)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, ByteBuffer row, FloatBuffer column, ByteBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, row, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)), span);
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, ByteBuffer row, FloatBuffer column, DoubleBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, row, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 3)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, ByteBuffer row, FloatBuffer column, FloatBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, row, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 2)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, ByteBuffer row, FloatBuffer column, IntBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, row, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 2)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, ByteBuffer row, FloatBuffer column, ShortBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, row, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 1)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, ByteBuffer row, IntBuffer column, ByteBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, row, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)), span);
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, ByteBuffer row, IntBuffer column, DoubleBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, row, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 3)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, ByteBuffer row, IntBuffer column, FloatBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, row, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 2)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, ByteBuffer row, IntBuffer column, IntBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, row, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 2)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, ByteBuffer row, IntBuffer column, ShortBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, row, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 1)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, ByteBuffer row, ShortBuffer column, ByteBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, row, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 1)), span);
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, ByteBuffer row, ShortBuffer column, DoubleBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, row, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 1)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 3)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, ByteBuffer row, ShortBuffer column, FloatBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, row, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 1)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 2)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, ByteBuffer row, ShortBuffer column, IntBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, row, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 1)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 2)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, ByteBuffer row, ShortBuffer column, ShortBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, row, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 1)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 1)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, DoubleBuffer row, ByteBuffer column, ByteBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 3)), column, span);
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, DoubleBuffer row, ByteBuffer column, DoubleBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 3)), column, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 3)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, DoubleBuffer row, ByteBuffer column, FloatBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 3)), column, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 2)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, DoubleBuffer row, ByteBuffer column, IntBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 3)), column, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 2)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, DoubleBuffer row, ByteBuffer column, ShortBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 3)), column, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 1)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, DoubleBuffer row, DoubleBuffer column, ByteBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 3)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 3)), span);
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, DoubleBuffer row, DoubleBuffer column, DoubleBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 3)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 3)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 3)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, DoubleBuffer row, DoubleBuffer column, FloatBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 3)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 3)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 2)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, DoubleBuffer row, DoubleBuffer column, IntBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 3)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 3)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 2)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, DoubleBuffer row, DoubleBuffer column, ShortBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 3)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 3)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 1)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, DoubleBuffer row, FloatBuffer column, ByteBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 3)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)), span);
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, DoubleBuffer row, FloatBuffer column, DoubleBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 3)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 3)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, DoubleBuffer row, FloatBuffer column, FloatBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 3)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 2)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, DoubleBuffer row, FloatBuffer column, IntBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 3)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 2)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, DoubleBuffer row, FloatBuffer column, ShortBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 3)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 1)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, DoubleBuffer row, IntBuffer column, ByteBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 3)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)), span);
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, DoubleBuffer row, IntBuffer column, DoubleBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 3)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 3)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, DoubleBuffer row, IntBuffer column, FloatBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 3)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 2)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, DoubleBuffer row, IntBuffer column, IntBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 3)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 2)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, DoubleBuffer row, IntBuffer column, ShortBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 3)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 1)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, DoubleBuffer row, ShortBuffer column, ByteBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 3)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 1)), span);
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, DoubleBuffer row, ShortBuffer column, DoubleBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 3)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 1)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 3)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, DoubleBuffer row, ShortBuffer column, FloatBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 3)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 1)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 2)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, DoubleBuffer row, ShortBuffer column, IntBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 3)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 1)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 2)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, DoubleBuffer row, ShortBuffer column, ShortBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 3)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 1)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 1)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, FloatBuffer row, ByteBuffer column, ByteBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), column, span);
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, FloatBuffer row, ByteBuffer column, DoubleBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), column, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 3)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, FloatBuffer row, ByteBuffer column, FloatBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), column, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 2)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, FloatBuffer row, ByteBuffer column, IntBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), column, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 2)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, FloatBuffer row, ByteBuffer column, ShortBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), column, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 1)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, FloatBuffer row, DoubleBuffer column, ByteBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 3)), span);
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, FloatBuffer row, DoubleBuffer column, DoubleBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 3)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 3)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, FloatBuffer row, DoubleBuffer column, FloatBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 3)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 2)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, FloatBuffer row, DoubleBuffer column, IntBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 3)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 2)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, FloatBuffer row, DoubleBuffer column, ShortBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 3)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 1)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, FloatBuffer row, FloatBuffer column, ByteBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)), span);
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, FloatBuffer row, FloatBuffer column, DoubleBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 3)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, FloatBuffer row, FloatBuffer column, FloatBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 2)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, FloatBuffer row, FloatBuffer column, IntBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 2)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, FloatBuffer row, FloatBuffer column, ShortBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 1)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, FloatBuffer row, IntBuffer column, ByteBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)), span);
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, FloatBuffer row, IntBuffer column, DoubleBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 3)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, FloatBuffer row, IntBuffer column, FloatBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 2)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, FloatBuffer row, IntBuffer column, IntBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 2)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, FloatBuffer row, IntBuffer column, ShortBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 1)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, FloatBuffer row, ShortBuffer column, ByteBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 1)), span);
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, FloatBuffer row, ShortBuffer column, DoubleBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 1)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 3)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, FloatBuffer row, ShortBuffer column, FloatBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 1)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 2)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, FloatBuffer row, ShortBuffer column, IntBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 1)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 2)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, FloatBuffer row, ShortBuffer column, ShortBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 1)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 1)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, IntBuffer row, ByteBuffer column, ByteBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), column, span);
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, IntBuffer row, ByteBuffer column, DoubleBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), column, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 3)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, IntBuffer row, ByteBuffer column, FloatBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), column, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 2)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, IntBuffer row, ByteBuffer column, IntBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), column, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 2)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, IntBuffer row, ByteBuffer column, ShortBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), column, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 1)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, IntBuffer row, DoubleBuffer column, ByteBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 3)), span);
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, IntBuffer row, DoubleBuffer column, DoubleBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 3)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 3)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, IntBuffer row, DoubleBuffer column, FloatBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 3)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 2)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, IntBuffer row, DoubleBuffer column, IntBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 3)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 2)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, IntBuffer row, DoubleBuffer column, ShortBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 3)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 1)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, IntBuffer row, FloatBuffer column, ByteBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)), span);
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, IntBuffer row, FloatBuffer column, DoubleBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 3)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, IntBuffer row, FloatBuffer column, FloatBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 2)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, IntBuffer row, FloatBuffer column, IntBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 2)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, IntBuffer row, FloatBuffer column, ShortBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 1)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, IntBuffer row, IntBuffer column, ByteBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)), span);
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, IntBuffer row, IntBuffer column, DoubleBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 3)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, IntBuffer row, IntBuffer column, FloatBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 2)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, IntBuffer row, IntBuffer column, IntBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 2)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, IntBuffer row, IntBuffer column, ShortBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 1)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, IntBuffer row, ShortBuffer column, ByteBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 1)), span);
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, IntBuffer row, ShortBuffer column, DoubleBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 1)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 3)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, IntBuffer row, ShortBuffer column, FloatBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 1)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 2)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, IntBuffer row, ShortBuffer column, IntBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 1)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 2)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, IntBuffer row, ShortBuffer column, ShortBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 1)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 1)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, ShortBuffer row, ByteBuffer column, ByteBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 1)), column, span);
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, ShortBuffer row, ByteBuffer column, DoubleBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 1)), column, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 3)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, ShortBuffer row, ByteBuffer column, FloatBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 1)), column, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 2)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, ShortBuffer row, ByteBuffer column, IntBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 1)), column, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 2)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, ShortBuffer row, ByteBuffer column, ShortBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 1)), column, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 1)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, ShortBuffer row, DoubleBuffer column, ByteBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 1)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 3)), span);
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, ShortBuffer row, DoubleBuffer column, DoubleBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 1)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 3)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 3)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, ShortBuffer row, DoubleBuffer column, FloatBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 1)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 3)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 2)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, ShortBuffer row, DoubleBuffer column, IntBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 1)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 3)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 2)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, ShortBuffer row, DoubleBuffer column, ShortBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 1)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 3)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 1)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, ShortBuffer row, FloatBuffer column, ByteBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 1)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)), span);
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, ShortBuffer row, FloatBuffer column, DoubleBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 1)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 3)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, ShortBuffer row, FloatBuffer column, FloatBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 1)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 2)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, ShortBuffer row, FloatBuffer column, IntBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 1)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 2)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, ShortBuffer row, FloatBuffer column, ShortBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 1)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 1)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, ShortBuffer row, IntBuffer column, ByteBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 1)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)), span);
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, ShortBuffer row, IntBuffer column, DoubleBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 1)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 3)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, ShortBuffer row, IntBuffer column, FloatBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 1)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 2)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, ShortBuffer row, IntBuffer column, IntBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 1)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 2)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, ShortBuffer row, IntBuffer column, ShortBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 1)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 2)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 1)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, ShortBuffer row, ShortBuffer column, ByteBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 1)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 1)), span);
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, ShortBuffer row, ShortBuffer column, DoubleBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 1)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 1)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 3)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, ShortBuffer row, ShortBuffer column, FloatBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 1)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 1)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 2)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, ShortBuffer row, ShortBuffer column, IntBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 1)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 1)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 2)));
	}
	public static void glGetnSeparableFilterARB(int target, int format, int type, ShortBuffer row, ShortBuffer column, ShortBuffer span) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(row), (org.lwjgl.system.Checks.remainingSafe(row) << 1)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(column), (org.lwjgl.system.Checks.remainingSafe(column) << 1)), org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(span), (org.lwjgl.system.Checks.remainingSafe(span) << 1)));
	}
	@Todo("gl")
	public static void glGetnSeparableFilterARB(int target, int format, int type, int row_rowBufSize, long row_buffer_offset, int column_columnBufSize, long column_buffer_offset, long span_buffer_offset) {
		throw new UnsupportedOperationException();
	}
	public static void glGetnHistogramARB(int target, boolean reset, int format, int type, DoubleBuffer values) {
		org.lwjgl.opengl.ARBRobustness.glGetnHistogramARB(target, reset, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(values), (org.lwjgl.system.Checks.remainingSafe(values) << 3)));
	}
	public static void glGetnHistogramARB(int target, boolean reset, int format, int type, FloatBuffer values) {
		org.lwjgl.opengl.ARBRobustness.glGetnHistogramARB(target, reset, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(values), (org.lwjgl.system.Checks.remainingSafe(values) << 2)));
	}
	public static void glGetnHistogramARB(int target, boolean reset, int format, int type, IntBuffer values) {
		org.lwjgl.opengl.ARBRobustness.glGetnHistogramARB(target, reset, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(values), (org.lwjgl.system.Checks.remainingSafe(values) << 2)));
	}
	public static void glGetnHistogramARB(int target, boolean reset, int format, int type, ShortBuffer values) {
		org.lwjgl.opengl.ARBRobustness.glGetnHistogramARB(target, reset, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(values), (org.lwjgl.system.Checks.remainingSafe(values) << 1)));
	}
	public static void glGetnMinmaxARB(int target, boolean reset, int format, int type, DoubleBuffer values) {
		org.lwjgl.opengl.ARBRobustness.glGetnMinmaxARB(target, reset, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(values), (org.lwjgl.system.Checks.remainingSafe(values) << 3)));
	}
	public static void glGetnMinmaxARB(int target, boolean reset, int format, int type, FloatBuffer values) {
		org.lwjgl.opengl.ARBRobustness.glGetnMinmaxARB(target, reset, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(values), (org.lwjgl.system.Checks.remainingSafe(values) << 2)));
	}
	public static void glGetnMinmaxARB(int target, boolean reset, int format, int type, IntBuffer values) {
		org.lwjgl.opengl.ARBRobustness.glGetnMinmaxARB(target, reset, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(values), (org.lwjgl.system.Checks.remainingSafe(values) << 2)));
	}
	public static void glGetnMinmaxARB(int target, boolean reset, int format, int type, ShortBuffer values) {
		org.lwjgl.opengl.ARBRobustness.glGetnMinmaxARB(target, reset, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(values), (org.lwjgl.system.Checks.remainingSafe(values) << 1)));
	}
	public static void glGetnCompressedTexImageARB(int target, int lod, IntBuffer img) {
		org.lwjgl.opengl.ARBRobustness.glGetnCompressedTexImageARB(target, lod, (org.lwjgl.system.Checks.remainingSafe(img) << 2), org.lwjgl.system.MemoryUtil.memAddressSafe(img));
	}
	public static void glGetnCompressedTexImageARB(int target, int lod, ShortBuffer img) {
		org.lwjgl.opengl.ARBRobustness.glGetnCompressedTexImageARB(target, lod, (org.lwjgl.system.Checks.remainingSafe(img) << 1), org.lwjgl.system.MemoryUtil.memAddressSafe(img));
	}
}
