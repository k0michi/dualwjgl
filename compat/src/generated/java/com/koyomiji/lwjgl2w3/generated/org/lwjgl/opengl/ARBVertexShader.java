package com.koyomiji.lwjgl2w3.generated.org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Todo;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

public final class ARBVertexShader {
	public static void glVertexAttribPointerARB(int index, int size, boolean normalized, int stride, DoubleBuffer buffer) {
		org.lwjgl.opengl.ARBVertexShader.nglVertexAttribPointerARB(index, size, 5130, normalized, stride, org.lwjgl.system.MemoryUtil.memAddressSafe(buffer));
	}
	public static void glVertexAttribPointerARB(int index, int size, boolean normalized, int stride, FloatBuffer buffer) {
		org.lwjgl.opengl.ARBVertexShader.nglVertexAttribPointerARB(index, size, 5126, normalized, stride, org.lwjgl.system.MemoryUtil.memAddressSafe(buffer));
	}
	public static void glVertexAttribPointerARB(int index, int size, boolean unsigned, boolean normalized, int stride, ByteBuffer buffer) {
		org.lwjgl.opengl.ARBVertexShader.nglVertexAttribPointerARB(index, size, (unsigned ? 5121 : 5120), normalized, stride, org.lwjgl.system.MemoryUtil.memAddress(buffer));
	}
	public static void glVertexAttribPointerARB(int index, int size, boolean unsigned, boolean normalized, int stride, IntBuffer buffer) {
		org.lwjgl.opengl.ARBVertexShader.nglVertexAttribPointerARB(index, size, (unsigned ? 5125 : 5124), normalized, stride, org.lwjgl.system.MemoryUtil.memAddress(buffer));
	}
	public static void glVertexAttribPointerARB(int index, int size, boolean unsigned, boolean normalized, int stride, ShortBuffer buffer) {
		org.lwjgl.opengl.ARBVertexShader.nglVertexAttribPointerARB(index, size, (unsigned ? 5123 : 5122), normalized, stride, org.lwjgl.system.MemoryUtil.memAddress(buffer));
	}
	public static String glGetActiveAttribARB(int programObj, int index, int maxLength, IntBuffer sizeType) {
		if (org.lwjgl.system.Checks.CHECKS) org.lwjgl.system.Checks.check(sizeType, 2);
		try (org.lwjgl.system.MemoryStack __stack = org.lwjgl.system.MemoryStack.stackPush()) {
			java.nio.IntBuffer __name_length = __stack.mallocInt(1);
			java.nio.ByteBuffer __name = org.lwjgl.system.MemoryUtil.memAlloc(Math.max(maxLength, 1));
			try {
				org.lwjgl.opengl.ARBVertexShader.nglGetActiveAttribARB(programObj, index, maxLength, org.lwjgl.system.MemoryUtil.memAddress(__name_length), org.lwjgl.system.MemoryUtil.memAddress(sizeType), org.lwjgl.system.MemoryUtil.memAddress(sizeType, sizeType.position() + 1), org.lwjgl.system.MemoryUtil.memAddress(__name));
				return org.lwjgl.system.MemoryUtil.memASCII(__name, __name_length.get(0));
			} finally {
				org.lwjgl.system.MemoryUtil.memFree(__name);
			}
		}
	}
	public static String glGetActiveAttribARB(int programObj, int index, int maxLength) {
		try (org.lwjgl.system.MemoryStack __stack = org.lwjgl.system.MemoryStack.stackPush()) {
			java.nio.IntBuffer __name_length = __stack.mallocInt(1);
			java.nio.ByteBuffer __name = org.lwjgl.system.MemoryUtil.memAlloc(Math.max(maxLength, 1));
			java.nio.IntBuffer __scratch = __stack.mallocInt(2);
			try {
				org.lwjgl.opengl.ARBVertexShader.nglGetActiveAttribARB(programObj, index, maxLength, org.lwjgl.system.MemoryUtil.memAddress(__name_length), org.lwjgl.system.MemoryUtil.memAddress(__scratch), org.lwjgl.system.MemoryUtil.memAddress(__scratch, 1), org.lwjgl.system.MemoryUtil.memAddress(__name));
				return org.lwjgl.system.MemoryUtil.memASCII(__name, __name_length.get(0));
			} finally {
				org.lwjgl.system.MemoryUtil.memFree(__name);
			}
		}
	}
	public static int glGetActiveAttribSizeARB(int programObj, int index) {
		try (org.lwjgl.system.MemoryStack __stack = org.lwjgl.system.MemoryStack.stackPush()) {
			java.nio.IntBuffer __size = __stack.mallocInt(2);
			org.lwjgl.opengl.ARBVertexShader.nglGetActiveAttribARB(programObj, index, 0, 0, org.lwjgl.system.MemoryUtil.memAddress(__size), org.lwjgl.system.MemoryUtil.memAddress(__size, 1), org.lwjgl.system.MemoryUtil.memAddress(__stack.malloc(1)));
			return __size.get(0);
		}
	}
	public static int glGetActiveAttribTypeARB(int programObj, int index) {
		try (org.lwjgl.system.MemoryStack __stack = org.lwjgl.system.MemoryStack.stackPush()) {
			java.nio.IntBuffer __type = __stack.mallocInt(2);
			org.lwjgl.opengl.ARBVertexShader.nglGetActiveAttribARB(programObj, index, 0, 0, org.lwjgl.system.MemoryUtil.memAddress(__type, 1), org.lwjgl.system.MemoryUtil.memAddress(__type), org.lwjgl.system.MemoryUtil.memAddress(__stack.malloc(1)));
			return __type.get(0);
		}
	}
	public static void glGetVertexAttribARB(int index, int pname, FloatBuffer params) {
		org.lwjgl.opengl.ARBVertexShader.glGetVertexAttribfvARB(index, pname, params);
	}
	public static void glGetVertexAttribARB(int index, int pname, DoubleBuffer params) {
		org.lwjgl.opengl.ARBVertexShader.glGetVertexAttribdvARB(index, pname, params);
	}
	public static void glGetVertexAttribARB(int index, int pname, IntBuffer params) {
		org.lwjgl.opengl.ARBVertexShader.glGetVertexAttribivARB(index, pname, params);
	}
	@Todo("gl")
	public static ByteBuffer glGetVertexAttribPointerARB(int index, int pname, long result_size) {
		throw new UnsupportedOperationException();
	}
}
