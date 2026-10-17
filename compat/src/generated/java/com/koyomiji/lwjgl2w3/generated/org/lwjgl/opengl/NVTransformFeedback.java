package com.koyomiji.lwjgl2w3.generated.org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Todo;
import java.nio.IntBuffer;

public final class NVTransformFeedback {
	@Todo("gl")
	public static String glGetActiveVaryingNV(int program, int index, int bufSize, IntBuffer sizeType) {
		throw new UnsupportedOperationException();
	}
	@Todo("gl")
	public static String glGetActiveVaryingNV(int program, int index, int bufSize) {
		throw new UnsupportedOperationException();
	}
	public static int glGetActiveVaryingSizeNV(int program, int index) {
		try (org.lwjgl.system.MemoryStack __stack = org.lwjgl.system.MemoryStack.stackPush()) {
			java.nio.IntBuffer __t3 = __stack.mallocInt(1);
			java.nio.IntBuffer __t4 = __stack.mallocInt(1);
			java.nio.ByteBuffer __t5 = __stack.malloc(0);
			org.lwjgl.opengl.NVTransformFeedback.glGetActiveVaryingNV(program, index, (java.nio.IntBuffer)null, __t3, __t4, __t5);
			return __t3.get(0);
		}
	}
	public static int glGetActiveVaryingTypeNV(int program, int index) {
		try (org.lwjgl.system.MemoryStack __stack = org.lwjgl.system.MemoryStack.stackPush()) {
			java.nio.IntBuffer __t3 = __stack.mallocInt(1);
			java.nio.IntBuffer __t4 = __stack.mallocInt(1);
			java.nio.ByteBuffer __t5 = __stack.malloc(0);
			org.lwjgl.opengl.NVTransformFeedback.glGetActiveVaryingNV(program, index, (java.nio.IntBuffer)null, __t3, __t4, __t5);
			return __t4.get(0);
		}
	}
}
