package com.koyomiji.dualwjgl.generated.org.lwjgl.opengl;

import java.nio.IntBuffer;
import org.lwjgl.PointerBuffer;

public final class ARBMultiBind {
	public static void glBindBuffersBase(int target, int first, int count, IntBuffer buffers) {
		org.lwjgl.opengl.ARBMultiBind.glBindBuffersBase(target, first, org.lwjgl.system.MemoryUtil.memIntBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(buffers), count));
	}
	public static void glBindBuffersRange(int target, int first, int count, IntBuffer buffers, PointerBuffer offsets, PointerBuffer sizes) {
		org.lwjgl.opengl.ARBMultiBind.glBindBuffersRange(target, first, org.lwjgl.system.MemoryUtil.memIntBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(buffers), count), offsets, sizes);
	}
	public static void glBindTextures(int first, int count, IntBuffer textures) {
		org.lwjgl.opengl.ARBMultiBind.glBindTextures(first, org.lwjgl.system.MemoryUtil.memIntBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(textures), count));
	}
	public static void glBindSamplers(int first, int count, IntBuffer samplers) {
		org.lwjgl.opengl.ARBMultiBind.glBindSamplers(first, org.lwjgl.system.MemoryUtil.memIntBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(samplers), count));
	}
	public static void glBindImageTextures(int first, int count, IntBuffer textures) {
		org.lwjgl.opengl.ARBMultiBind.glBindImageTextures(first, org.lwjgl.system.MemoryUtil.memIntBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(textures), count));
	}
	public static void glBindVertexBuffers(int first, int count, IntBuffer buffers, PointerBuffer offsets, IntBuffer strides) {
		org.lwjgl.opengl.ARBMultiBind.glBindVertexBuffers(first, org.lwjgl.system.MemoryUtil.memIntBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(buffers), count), offsets, strides);
	}
}
