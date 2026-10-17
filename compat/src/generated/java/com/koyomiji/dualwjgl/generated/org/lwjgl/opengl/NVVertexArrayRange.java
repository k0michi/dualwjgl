package com.koyomiji.dualwjgl.generated.org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

public final class NVVertexArrayRange {
	public static void glVertexArrayRangeNV(DoubleBuffer pPointer) {
		org.lwjgl.opengl.NVVertexArrayRange.glVertexArrayRangeNV(org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(pPointer), (org.lwjgl.system.Checks.remainingSafe(pPointer) << 3)));
	}
	public static void glVertexArrayRangeNV(FloatBuffer pPointer) {
		org.lwjgl.opengl.NVVertexArrayRange.glVertexArrayRangeNV(org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(pPointer), (org.lwjgl.system.Checks.remainingSafe(pPointer) << 2)));
	}
	public static void glVertexArrayRangeNV(IntBuffer pPointer) {
		org.lwjgl.opengl.NVVertexArrayRange.glVertexArrayRangeNV(org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(pPointer), (org.lwjgl.system.Checks.remainingSafe(pPointer) << 2)));
	}
	public static void glVertexArrayRangeNV(ShortBuffer pPointer) {
		org.lwjgl.opengl.NVVertexArrayRange.glVertexArrayRangeNV(org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(pPointer), (org.lwjgl.system.Checks.remainingSafe(pPointer) << 1)));
	}
	public static ByteBuffer glAllocateMemoryNV(int size, float readFrequency, float writeFrequency, float priority) {
		throw new IllegalStateException("Function is not supported");
	}
	public static void glFreeMemoryNV(ByteBuffer pointer) {
		throw new IllegalStateException("Function is not supported");
	}
}
