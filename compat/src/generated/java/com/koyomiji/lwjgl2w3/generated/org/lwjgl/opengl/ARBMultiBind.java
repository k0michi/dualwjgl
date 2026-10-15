package com.koyomiji.lwjgl2w3.generated.org.lwjgl.opengl;

import java.nio.IntBuffer;
import org.lwjgl.PointerBuffer;

public final class ARBMultiBind {
	public static void glBindBuffersBase(int target, int first, int count, IntBuffer buffers) {
		org.lwjgl.opengl.ARBMultiBind.nglBindBuffersBase(target, first, count, org.lwjgl.system.MemoryUtil.memAddressSafe(buffers));
	}
	public static void glBindBuffersRange(int target, int first, int count, IntBuffer buffers, PointerBuffer offsets, PointerBuffer sizes) {
		org.lwjgl.opengl.ARBMultiBind.nglBindBuffersRange(target, first, count, org.lwjgl.system.MemoryUtil.memAddressSafe(buffers), org.lwjgl.system.MemoryUtil.memAddressSafe(offsets), org.lwjgl.system.MemoryUtil.memAddressSafe(sizes));
	}
	public static void glBindTextures(int first, int count, IntBuffer textures) {
		org.lwjgl.opengl.ARBMultiBind.nglBindTextures(first, count, org.lwjgl.system.MemoryUtil.memAddressSafe(textures));
	}
	public static void glBindSamplers(int first, int count, IntBuffer samplers) {
		org.lwjgl.opengl.ARBMultiBind.nglBindSamplers(first, count, org.lwjgl.system.MemoryUtil.memAddressSafe(samplers));
	}
	public static void glBindImageTextures(int first, int count, IntBuffer textures) {
		org.lwjgl.opengl.ARBMultiBind.nglBindImageTextures(first, count, org.lwjgl.system.MemoryUtil.memAddressSafe(textures));
	}
	public static void glBindVertexBuffers(int first, int count, IntBuffer buffers, PointerBuffer offsets, IntBuffer strides) {
		org.lwjgl.opengl.ARBMultiBind.nglBindVertexBuffers(first, count, org.lwjgl.system.MemoryUtil.memAddressSafe(buffers), org.lwjgl.system.MemoryUtil.memAddressSafe(offsets), org.lwjgl.system.MemoryUtil.memAddressSafe(strides));
	}
}
