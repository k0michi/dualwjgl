package com.koyomiji.dualwjgl.generated.org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public final class GL14 {
	public static void glFogCoordPointer(int stride, DoubleBuffer data) {
		org.lwjgl.opengl.GL14.glFogCoordPointer(5130, stride, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(data), (org.lwjgl.system.Checks.remainingSafe(data) << 3)));
	}
	public static void glFogCoordPointer(int stride, FloatBuffer data) {
		org.lwjgl.opengl.GL14.glFogCoordPointer(5126, stride, data);
	}
	public static void glPointParameter(int pname, IntBuffer params) {
		org.lwjgl.opengl.GL14.glPointParameteriv(pname, params);
	}
	public static void glPointParameter(int pname, FloatBuffer params) {
		org.lwjgl.opengl.GL14.glPointParameterfv(pname, params);
	}
	public static void glSecondaryColorPointer(int size, int stride, DoubleBuffer data) {
		org.lwjgl.opengl.GL14.glSecondaryColorPointer(size, 5130, stride, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(data), (org.lwjgl.system.Checks.remainingSafe(data) << 3)));
	}
	public static void glSecondaryColorPointer(int size, int stride, FloatBuffer data) {
		org.lwjgl.opengl.GL14.glSecondaryColorPointer(size, 5126, stride, data);
	}
	public static void glSecondaryColorPointer(int size, boolean unsigned, int stride, ByteBuffer data) {
		org.lwjgl.opengl.GL14.glSecondaryColorPointer(size, (unsigned ? 5121 : 5120), stride, data);
	}
}
