package com.koyomiji.lwjgl2w3.generated.org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Todo;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

public final class ARBVertexShader {
	public static void glVertexAttribPointerARB(int index, int size, boolean normalized, int stride, DoubleBuffer buffer) {
		org.lwjgl.opengl.ARBVertexShader.glVertexAttribPointerARB(index, size, 5130, normalized, stride, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(buffer), (org.lwjgl.system.Checks.remainingSafe(buffer) << 3)));
	}
	public static void glVertexAttribPointerARB(int index, int size, boolean normalized, int stride, FloatBuffer buffer) {
		org.lwjgl.opengl.ARBVertexShader.glVertexAttribPointerARB(index, size, 5126, normalized, stride, buffer);
	}
	public static void glVertexAttribPointerARB(int index, int size, boolean unsigned, boolean normalized, int stride, ByteBuffer buffer) {
		org.lwjgl.opengl.ARBVertexShader.glVertexAttribPointerARB(index, size, (unsigned ? 5121 : 5120), normalized, stride, buffer);
	}
	public static void glVertexAttribPointerARB(int index, int size, boolean unsigned, boolean normalized, int stride, IntBuffer buffer) {
		org.lwjgl.opengl.ARBVertexShader.glVertexAttribPointerARB(index, size, (unsigned ? 5125 : 5124), normalized, stride, buffer);
	}
	public static void glVertexAttribPointerARB(int index, int size, boolean unsigned, boolean normalized, int stride, ShortBuffer buffer) {
		org.lwjgl.opengl.ARBVertexShader.glVertexAttribPointerARB(index, size, (unsigned ? 5123 : 5122), normalized, stride, buffer);
	}
	public static String glGetActiveAttribARB(int programObj, int index, int maxLength, IntBuffer sizeType) {
		return org.lwjgl.opengl.ARBVertexShader.glGetActiveAttribARB(programObj, index, maxLength, sizeType, org.lwjgl.system.MemoryUtil.memIntBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(sizeType) + 4, (org.lwjgl.system.Checks.remainingSafe(sizeType) - 1)));
	}
	public static String glGetActiveAttribARB(int programObj, int index, int maxLength) {
		try (org.lwjgl.system.MemoryStack __stack = org.lwjgl.system.MemoryStack.stackPush()) {
			java.nio.IntBuffer __t3 = __stack.mallocInt(1);
			java.nio.IntBuffer __t4 = __stack.mallocInt(1);
			return org.lwjgl.opengl.ARBVertexShader.glGetActiveAttribARB(programObj, index, maxLength, __t3, __t4);
		}
	}
	public static int glGetActiveAttribSizeARB(int programObj, int index) {
		try (org.lwjgl.system.MemoryStack __stack = org.lwjgl.system.MemoryStack.stackPush()) {
			java.nio.IntBuffer __t3 = __stack.mallocInt(1);
			java.nio.IntBuffer __t4 = __stack.mallocInt(1);
			java.nio.ByteBuffer __t5 = __stack.malloc(0);
			org.lwjgl.opengl.ARBVertexShader.glGetActiveAttribARB(programObj, index, (java.nio.IntBuffer)null, __t3, __t4, __t5);
			return __t3.get(0);
		}
	}
	public static int glGetActiveAttribTypeARB(int programObj, int index) {
		try (org.lwjgl.system.MemoryStack __stack = org.lwjgl.system.MemoryStack.stackPush()) {
			java.nio.IntBuffer __t3 = __stack.mallocInt(1);
			java.nio.IntBuffer __t4 = __stack.mallocInt(1);
			java.nio.ByteBuffer __t5 = __stack.malloc(0);
			org.lwjgl.opengl.ARBVertexShader.glGetActiveAttribARB(programObj, index, (java.nio.IntBuffer)null, __t3, __t4, __t5);
			return __t4.get(0);
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
