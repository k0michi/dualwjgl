package com.koyomiji.dualwjgl.generated.org.lwjgl.opengl;

import com.koyomiji.dualwjgl.inject.Todo;
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
		org.lwjgl.opengl.GL43.glObjectPtrLabel(ptr.getPointer(), label);
	}
	public static void glObjectPtrLabel(PointerWrapper ptr, CharSequence label) {
		org.lwjgl.opengl.GL43.glObjectPtrLabel(ptr.getPointer(), label);
	}
	public static void glGetObjectPtrLabel(PointerWrapper ptr, IntBuffer length, ByteBuffer label) {
		org.lwjgl.opengl.GL43.glGetObjectPtrLabel(ptr.getPointer(), length, label);
	}
	public static String glGetObjectPtrLabel(PointerWrapper ptr, int bufSize) {
		return org.lwjgl.opengl.GL43.glGetObjectPtrLabel(ptr.getPointer(), bufSize);
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
