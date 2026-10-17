package com.koyomiji.lwjgl2w3.generated.org.lwjgl.opengl;

import java.nio.IntBuffer;
import java.nio.LongBuffer;
import org.lwjgl.PointerBuffer;

public final class GL44 {
	public static void glBufferStorage(int target, LongBuffer data, int flags) {
		org.lwjgl.opengl.GL44.glBufferStorage(target, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(data), (org.lwjgl.system.Checks.remainingSafe(data) << 3)), flags);
	}
	public static void glClearTexImage(int texture, int level, int format, int type, LongBuffer data) {
		org.lwjgl.opengl.GL44.glClearTexImage(texture, level, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(data), (org.lwjgl.system.Checks.remainingSafe(data) << 3)));
	}
	public static void glClearTexSubImage(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, LongBuffer data) {
		org.lwjgl.opengl.GL44.glClearTexSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(data), (org.lwjgl.system.Checks.remainingSafe(data) << 3)));
	}
	public static void glBindBuffersBase(int target, int first, int count, IntBuffer buffers) {
		org.lwjgl.opengl.GL44.glBindBuffersBase(target, first, org.lwjgl.system.MemoryUtil.memIntBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(buffers), count));
	}
	public static void glBindBuffersRange(int target, int first, int count, IntBuffer buffers, PointerBuffer offsets, PointerBuffer sizes) {
		org.lwjgl.opengl.GL44.glBindBuffersRange(target, first, org.lwjgl.system.MemoryUtil.memIntBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(buffers), count), offsets, sizes);
	}
	public static void glBindTextures(int first, int count, IntBuffer textures) {
		org.lwjgl.opengl.GL44.glBindTextures(first, org.lwjgl.system.MemoryUtil.memIntBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(textures), count));
	}
	public static void glBindSamplers(int first, int count, IntBuffer samplers) {
		org.lwjgl.opengl.GL44.glBindSamplers(first, org.lwjgl.system.MemoryUtil.memIntBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(samplers), count));
	}
	public static void glBindImageTextures(int first, int count, IntBuffer textures) {
		org.lwjgl.opengl.GL44.glBindImageTextures(first, org.lwjgl.system.MemoryUtil.memIntBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(textures), count));
	}
	public static void glBindVertexBuffers(int first, int count, IntBuffer buffers, PointerBuffer offsets, IntBuffer strides) {
		org.lwjgl.opengl.GL44.glBindVertexBuffers(first, org.lwjgl.system.MemoryUtil.memIntBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(buffers), count), offsets, strides);
	}
}
