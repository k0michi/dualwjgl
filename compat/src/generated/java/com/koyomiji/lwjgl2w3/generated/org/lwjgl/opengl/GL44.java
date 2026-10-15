package com.koyomiji.lwjgl2w3.generated.org.lwjgl.opengl;

import java.nio.IntBuffer;
import java.nio.LongBuffer;
import org.lwjgl.PointerBuffer;

public final class GL44 {
	public static void glBufferStorage(int target, LongBuffer data, int flags) {
		org.lwjgl.opengl.GL44.nglBufferStorage(target, ((long)org.lwjgl.system.Checks.remainingSafe(data) << 3), org.lwjgl.system.MemoryUtil.memAddressSafe(data), flags);
	}
	public static void glClearTexImage(int texture, int level, int format, int type, LongBuffer data) {
		org.lwjgl.opengl.GL44.nglClearTexImage(texture, level, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(data));
	}
	public static void glClearTexSubImage(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, LongBuffer data) {
		org.lwjgl.opengl.GL44.nglClearTexSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(data));
	}
	public static void glBindBuffersBase(int target, int first, int count, IntBuffer buffers) {
		org.lwjgl.opengl.GL44.nglBindBuffersBase(target, first, count, org.lwjgl.system.MemoryUtil.memAddressSafe(buffers));
	}
	public static void glBindBuffersRange(int target, int first, int count, IntBuffer buffers, PointerBuffer offsets, PointerBuffer sizes) {
		org.lwjgl.opengl.GL44.nglBindBuffersRange(target, first, count, org.lwjgl.system.MemoryUtil.memAddressSafe(buffers), org.lwjgl.system.MemoryUtil.memAddressSafe(offsets), org.lwjgl.system.MemoryUtil.memAddressSafe(sizes));
	}
	public static void glBindTextures(int first, int count, IntBuffer textures) {
		org.lwjgl.opengl.GL44.nglBindTextures(first, count, org.lwjgl.system.MemoryUtil.memAddressSafe(textures));
	}
	public static void glBindSamplers(int first, int count, IntBuffer samplers) {
		org.lwjgl.opengl.GL44.nglBindSamplers(first, count, org.lwjgl.system.MemoryUtil.memAddressSafe(samplers));
	}
	public static void glBindImageTextures(int first, int count, IntBuffer textures) {
		org.lwjgl.opengl.GL44.nglBindImageTextures(first, count, org.lwjgl.system.MemoryUtil.memAddressSafe(textures));
	}
	public static void glBindVertexBuffers(int first, int count, IntBuffer buffers, PointerBuffer offsets, IntBuffer strides) {
		org.lwjgl.opengl.GL44.nglBindVertexBuffers(first, count, org.lwjgl.system.MemoryUtil.memAddressSafe(buffers), org.lwjgl.system.MemoryUtil.memAddressSafe(offsets), org.lwjgl.system.MemoryUtil.memAddressSafe(strides));
	}
}
