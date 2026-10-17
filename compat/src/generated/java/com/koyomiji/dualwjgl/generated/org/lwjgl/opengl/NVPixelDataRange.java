package com.koyomiji.dualwjgl.generated.org.lwjgl.opengl;

import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

public final class NVPixelDataRange {
	public static void glPixelDataRangeNV(int target, DoubleBuffer data) {
		org.lwjgl.opengl.NVPixelDataRange.glPixelDataRangeNV(target, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(data), (org.lwjgl.system.Checks.remainingSafe(data) << 3)));
	}
	public static void glPixelDataRangeNV(int target, FloatBuffer data) {
		org.lwjgl.opengl.NVPixelDataRange.glPixelDataRangeNV(target, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(data), (org.lwjgl.system.Checks.remainingSafe(data) << 2)));
	}
	public static void glPixelDataRangeNV(int target, IntBuffer data) {
		org.lwjgl.opengl.NVPixelDataRange.glPixelDataRangeNV(target, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(data), (org.lwjgl.system.Checks.remainingSafe(data) << 2)));
	}
	public static void glPixelDataRangeNV(int target, ShortBuffer data) {
		org.lwjgl.opengl.NVPixelDataRange.glPixelDataRangeNV(target, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(data), (org.lwjgl.system.Checks.remainingSafe(data) << 1)));
	}
}
