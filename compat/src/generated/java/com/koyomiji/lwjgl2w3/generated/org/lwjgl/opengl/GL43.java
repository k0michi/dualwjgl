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
	@Todo("gl")
	public static void glObjectPtrLabel(PointerWrapper ptr, ByteBuffer label) {
		throw new UnsupportedOperationException();
	}
	@Todo("gl")
	public static void glObjectPtrLabel(PointerWrapper ptr, CharSequence label) {
		throw new UnsupportedOperationException();
	}
	@Todo("gl")
	public static void glGetObjectPtrLabel(PointerWrapper ptr, IntBuffer length, ByteBuffer label) {
		throw new UnsupportedOperationException();
	}
	@Todo("gl")
	public static String glGetObjectPtrLabel(PointerWrapper ptr, int bufSize) {
		throw new UnsupportedOperationException();
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
