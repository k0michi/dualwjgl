package com.koyomiji.lwjgl2w3.inject.org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.PointerWrapper;
import org.lwjgl.opengl.KHRDebugCallback;

public final class KHRDebug {
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
}
