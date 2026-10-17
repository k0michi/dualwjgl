package com.koyomiji.dualwjgl.generated.org.lwjgl.opengl;

import com.koyomiji.dualwjgl.inject.Todo;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.PointerWrapper;
import org.lwjgl.opengl.KHRDebugCallback;

public final class KHRDebug {
	@Todo("gl")
	public static void glDebugMessageCallback(KHRDebugCallback callback) {
		throw new UnsupportedOperationException();
	}
	public static void glObjectPtrLabel(PointerWrapper ptr, ByteBuffer label) {
		org.lwjgl.opengl.KHRDebug.glObjectPtrLabel(ptr.getPointer(), label);
	}
	public static void glObjectPtrLabel(PointerWrapper ptr, CharSequence label) {
		org.lwjgl.opengl.KHRDebug.glObjectPtrLabel(ptr.getPointer(), label);
	}
	public static void glGetObjectPtrLabel(PointerWrapper ptr, IntBuffer length, ByteBuffer label) {
		org.lwjgl.opengl.KHRDebug.glGetObjectPtrLabel(ptr.getPointer(), length, label);
	}
	public static String glGetObjectPtrLabel(PointerWrapper ptr, int bufSize) {
		return org.lwjgl.opengl.KHRDebug.glGetObjectPtrLabel(ptr.getPointer(), bufSize);
	}
}
