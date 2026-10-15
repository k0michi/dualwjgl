package com.koyomiji.lwjgl2w3.inject.org.lwjgl.opengl;

import java.nio.IntBuffer;
import java.nio.LongBuffer;
import org.lwjgl.PointerBuffer;

public final class GL44 {
	public static void glBufferStorage(int target, LongBuffer data, int flags) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glClearTexImage(int texture, int level, int format, int type, LongBuffer data) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glClearTexSubImage(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, LongBuffer data) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glBindBuffersBase(int target, int first, int count, IntBuffer buffers) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glBindBuffersRange(int target, int first, int count, IntBuffer buffers, PointerBuffer offsets, PointerBuffer sizes) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glBindTextures(int first, int count, IntBuffer textures) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glBindSamplers(int first, int count, IntBuffer samplers) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glBindImageTextures(int first, int count, IntBuffer textures) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glBindVertexBuffers(int first, int count, IntBuffer buffers, PointerBuffer offsets, IntBuffer strides) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
}
