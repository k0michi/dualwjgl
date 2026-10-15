package com.koyomiji.lwjgl2w3.generated.org.lwjgl.opengl;

import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

public final class NVPixelDataRange {
	public static void glPixelDataRangeNV(int target, DoubleBuffer data) {
		org.lwjgl.opengl.NVPixelDataRange.nglPixelDataRangeNV(target, (org.lwjgl.system.Checks.remainingSafe(data) << 3), org.lwjgl.system.MemoryUtil.memAddressSafe(data));
	}
	public static void glPixelDataRangeNV(int target, FloatBuffer data) {
		org.lwjgl.opengl.NVPixelDataRange.nglPixelDataRangeNV(target, (org.lwjgl.system.Checks.remainingSafe(data) << 2), org.lwjgl.system.MemoryUtil.memAddressSafe(data));
	}
	public static void glPixelDataRangeNV(int target, IntBuffer data) {
		org.lwjgl.opengl.NVPixelDataRange.nglPixelDataRangeNV(target, (org.lwjgl.system.Checks.remainingSafe(data) << 2), org.lwjgl.system.MemoryUtil.memAddressSafe(data));
	}
	public static void glPixelDataRangeNV(int target, ShortBuffer data) {
		org.lwjgl.opengl.NVPixelDataRange.nglPixelDataRangeNV(target, (org.lwjgl.system.Checks.remainingSafe(data) << 1), org.lwjgl.system.MemoryUtil.memAddressSafe(data));
	}
}
