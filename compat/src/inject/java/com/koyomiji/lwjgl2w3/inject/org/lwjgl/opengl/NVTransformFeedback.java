package com.koyomiji.lwjgl2w3.inject.org.lwjgl.opengl;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

// TODO(verify): hand-written; DelegationTest only compares generated members.
public final class NVTransformFeedback {

	/** sizeType holds the size, then the type (LWJGL 2's packing); the name is decoded as ASCII (DEVIATION(text-encoding)). */
	public static String glGetActiveVaryingNV(int program, int index, int bufSize, IntBuffer sizeType) {
		IntBuffer type = MemoryUtil.memIntBuffer(MemoryUtil.memAddress(sizeType) + 4, 1);
		return activeVarying(program, index, bufSize, sizeType, type);
	}

	public static String glGetActiveVaryingNV(int program, int index, int bufSize) {
		try (MemoryStack stack = MemoryStack.stackPush()) {
			return activeVarying(program, index, bufSize, stack.mallocInt(1), stack.mallocInt(1));
		}
	}

	private static String activeVarying(int program, int index, int bufSize, IntBuffer size, IntBuffer type) {
		ByteBuffer name = MemoryUtil.memAlloc(Math.max(bufSize, 1));
		try (MemoryStack stack = MemoryStack.stackPush()) {
			IntBuffer length = stack.mallocInt(1);
			name.limit(bufSize);
			org.lwjgl.opengl.NVTransformFeedback.glGetActiveVaryingNV(program, index, length, size, type, name);
			return MemoryUtil.memASCII(name, length.get(0));
		} finally {
			MemoryUtil.memFree(name);
		}
	}
}
