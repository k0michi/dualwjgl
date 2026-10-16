package com.koyomiji.lwjgl2w3.generated.org.lwjgl.opengl;

import java.nio.IntBuffer;

public final class NVTransformFeedback {
	public static String glGetActiveVaryingNV(int program, int index, int bufSize, IntBuffer sizeType) {
		if (org.lwjgl.system.Checks.CHECKS) org.lwjgl.system.Checks.check(sizeType, 2);
		try (org.lwjgl.system.MemoryStack __stack = org.lwjgl.system.MemoryStack.stackPush()) {
			java.nio.IntBuffer __name_length = __stack.mallocInt(1);
			java.nio.ByteBuffer __name = org.lwjgl.system.MemoryUtil.memAlloc(Math.max(bufSize, 1));
			try {
				org.lwjgl.opengl.NVTransformFeedback.nglGetActiveVaryingNV(program, index, bufSize, org.lwjgl.system.MemoryUtil.memAddress(__name_length), org.lwjgl.system.MemoryUtil.memAddress(sizeType), org.lwjgl.system.MemoryUtil.memAddress(sizeType, sizeType.position() + 1), org.lwjgl.system.MemoryUtil.memAddress(__name));
				return org.lwjgl.system.MemoryUtil.memASCII(__name, __name_length.get(0));
			} finally {
				org.lwjgl.system.MemoryUtil.memFree(__name);
			}
		}
	}
	public static String glGetActiveVaryingNV(int program, int index, int bufSize) {
		try (org.lwjgl.system.MemoryStack __stack = org.lwjgl.system.MemoryStack.stackPush()) {
			java.nio.IntBuffer __name_length = __stack.mallocInt(1);
			java.nio.ByteBuffer __name = org.lwjgl.system.MemoryUtil.memAlloc(Math.max(bufSize, 1));
			java.nio.IntBuffer __scratch = __stack.mallocInt(2);
			try {
				org.lwjgl.opengl.NVTransformFeedback.nglGetActiveVaryingNV(program, index, bufSize, org.lwjgl.system.MemoryUtil.memAddress(__name_length), org.lwjgl.system.MemoryUtil.memAddress(__scratch), org.lwjgl.system.MemoryUtil.memAddress(__scratch, 1), org.lwjgl.system.MemoryUtil.memAddress(__name));
				return org.lwjgl.system.MemoryUtil.memASCII(__name, __name_length.get(0));
			} finally {
				org.lwjgl.system.MemoryUtil.memFree(__name);
			}
		}
	}
	public static int glGetActiveVaryingSizeNV(int program, int index) {
		try (org.lwjgl.system.MemoryStack __stack = org.lwjgl.system.MemoryStack.stackPush()) {
			java.nio.IntBuffer __size = __stack.mallocInt(2);
			org.lwjgl.opengl.NVTransformFeedback.nglGetActiveVaryingNV(program, index, 0, 0, org.lwjgl.system.MemoryUtil.memAddress(__size), org.lwjgl.system.MemoryUtil.memAddress(__size, 1), org.lwjgl.system.MemoryUtil.memAddress(__stack.malloc(1)));
			return __size.get(0);
		}
	}
	public static int glGetActiveVaryingTypeNV(int program, int index) {
		try (org.lwjgl.system.MemoryStack __stack = org.lwjgl.system.MemoryStack.stackPush()) {
			java.nio.IntBuffer __type = __stack.mallocInt(2);
			org.lwjgl.opengl.NVTransformFeedback.nglGetActiveVaryingNV(program, index, 0, 0, org.lwjgl.system.MemoryUtil.memAddress(__type, 1), org.lwjgl.system.MemoryUtil.memAddress(__type), org.lwjgl.system.MemoryUtil.memAddress(__stack.malloc(1)));
			return __type.get(0);
		}
	}
}
