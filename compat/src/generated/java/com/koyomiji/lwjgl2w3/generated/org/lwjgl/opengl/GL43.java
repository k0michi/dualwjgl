package com.koyomiji.lwjgl2w3.generated.org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Todo;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import org.lwjgl.PointerWrapper;
import org.lwjgl.opengl.KHRDebugCallback;

public final class GL43 {
	public static final int GL_SRGB_DECODE_ARB = 0x8299;
	@Todo("gl")
	public static void glDebugMessageCallback(KHRDebugCallback callback) {
		throw new UnsupportedOperationException();
	}
	public static void glObjectPtrLabel(PointerWrapper ptr, ByteBuffer label) {
		org.lwjgl.opengl.GL43.nglObjectPtrLabel(ptr.getPointer(), (label == null ? 0 : label.remaining()), org.lwjgl.system.MemoryUtil.memAddressSafe(label));
	}
	public static void glObjectPtrLabel(PointerWrapper ptr, CharSequence label) {
		try (org.lwjgl.system.MemoryStack __stack = org.lwjgl.system.MemoryStack.stackPush()) {
			int __labelEncodedLength = __stack.nUTF8(label, false);
			long __labelEncodedAddress = __stack.getPointerAddress();
			org.lwjgl.opengl.GL43.nglObjectPtrLabel(ptr.getPointer(), __labelEncodedLength, __labelEncodedAddress);
		}
	}
	public static void glGetObjectPtrLabel(PointerWrapper ptr, IntBuffer length, ByteBuffer label) {
		if (org.lwjgl.system.Checks.CHECKS && length != null) org.lwjgl.system.Checks.check(length, 1);
		org.lwjgl.opengl.GL43.nglGetObjectPtrLabel(ptr.getPointer(), label.remaining(), org.lwjgl.system.MemoryUtil.memAddressSafe(length), org.lwjgl.system.MemoryUtil.memAddress(label));
	}
	public static String glGetObjectPtrLabel(PointerWrapper ptr, int bufSize) {
		try (org.lwjgl.system.MemoryStack __stack = org.lwjgl.system.MemoryStack.stackPush()) {
			java.nio.IntBuffer __label_length = __stack.mallocInt(1);
			java.nio.ByteBuffer __label = org.lwjgl.system.MemoryUtil.memAlloc(Math.max(bufSize, 1));
			try {
				org.lwjgl.opengl.GL43.nglGetObjectPtrLabel(ptr.getPointer(), bufSize, org.lwjgl.system.MemoryUtil.memAddress(__label_length), org.lwjgl.system.MemoryUtil.memAddress(__label));
				return org.lwjgl.system.MemoryUtil.memUTF8(__label, __label_length.get(0));
			} finally {
				org.lwjgl.system.MemoryUtil.memFree(__label);
			}
		}
	}
	public static void glGetFramebufferParameter(int target, int pname, IntBuffer params) {
		org.lwjgl.opengl.GL43.glGetFramebufferParameteriv(target, pname, params);
	}
	public static void glGetInternalformat(int target, int internalformat, int pname, LongBuffer params) {
		org.lwjgl.opengl.GL43.glGetInternalformati64v(target, internalformat, pname, params);
	}
	public static void glGetProgramInterface(int program, int programInterface, int pname, IntBuffer params) {
		org.lwjgl.opengl.GL43.glGetProgramInterfaceiv(program, programInterface, pname, params);
	}
	public static void glGetProgramResource(int program, int programInterface, int index, IntBuffer props, IntBuffer length, IntBuffer params) {
		org.lwjgl.opengl.GL43.glGetProgramResourceiv(program, programInterface, index, props, length, params);
	}
}
