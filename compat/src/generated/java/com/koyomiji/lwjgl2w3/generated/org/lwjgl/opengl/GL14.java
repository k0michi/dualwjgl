package com.koyomiji.lwjgl2w3.generated.org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Todo;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public final class GL14 {
	public static void glFogCoordPointer(int stride, DoubleBuffer data) {
		org.lwjgl.opengl.GL14.nglFogCoordPointer(5130, stride, org.lwjgl.system.MemoryUtil.memAddressSafe(data));
	}
	public static void glFogCoordPointer(int stride, FloatBuffer data) {
		org.lwjgl.opengl.GL14.nglFogCoordPointer(5126, stride, org.lwjgl.system.MemoryUtil.memAddressSafe(data));
	}
	public static void glPointParameter(int pname, IntBuffer params) {
		org.lwjgl.opengl.GL14.glPointParameteriv(pname, params);
	}
	public static void glPointParameter(int pname, FloatBuffer params) {
		org.lwjgl.opengl.GL14.glPointParameterfv(pname, params);
	}
	public static void glSecondaryColorPointer(int size, int stride, DoubleBuffer data) {
		org.lwjgl.opengl.GL14.nglSecondaryColorPointer(size, 5130, stride, org.lwjgl.system.MemoryUtil.memAddressSafe(data));
	}
	public static void glSecondaryColorPointer(int size, int stride, FloatBuffer data) {
		org.lwjgl.opengl.GL14.nglSecondaryColorPointer(size, 5126, stride, org.lwjgl.system.MemoryUtil.memAddressSafe(data));
	}
	@Todo("gl")
	public static void glSecondaryColorPointer(int size, boolean unsigned, int stride, ByteBuffer data) {
		throw new UnsupportedOperationException();
	}
}
