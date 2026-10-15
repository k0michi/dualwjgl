package com.koyomiji.lwjgl2w3.inject.org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import org.lwjgl.PointerWrapper;
import org.lwjgl.opengl.KHRDebugCallback;

public final class GL43 {
	public static final int GL_SRGB_DECODE_ARB = 0x8299;
	public static void glDebugMessageCallback(KHRDebugCallback callback) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glObjectPtrLabel(PointerWrapper ptr, ByteBuffer label) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glObjectPtrLabel(PointerWrapper ptr, CharSequence label) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glGetObjectPtrLabel(PointerWrapper ptr, IntBuffer length, ByteBuffer label) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static String glGetObjectPtrLabel(PointerWrapper ptr, int bufSize) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glGetFramebufferParameter(int target, int pname, IntBuffer params) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glGetInternalformat(int target, int internalformat, int pname, LongBuffer params) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glGetProgramInterface(int program, int programInterface, int pname, IntBuffer params) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glGetProgramResource(int program, int programInterface, int index, IntBuffer props, IntBuffer length, IntBuffer params) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
}
