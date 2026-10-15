package com.koyomiji.lwjgl2w3.generated.org.lwjgl.openal;

import com.koyomiji.lwjgl2w3.inject.Todo;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public final class AL11 {
	@Todo("al")
	public static void alGetListeneri(int pname, FloatBuffer intdata) {
		throw new UnsupportedOperationException();
	}
	public static void alSource(int source, int pname, IntBuffer value) {
		org.lwjgl.openal.AL11.alSourceiv(source, pname, value);
	}
	public static void alBuffer(int buffer, int pname, FloatBuffer value) {
		org.lwjgl.openal.AL11.alBufferfv(buffer, pname, value);
	}
	public static void alBuffer(int buffer, int pname, IntBuffer value) {
		org.lwjgl.openal.AL11.alBufferiv(buffer, pname, value);
	}
	public static void alGetBuffer(int buffer, int pname, IntBuffer values) {
		org.lwjgl.openal.AL11.alGetBufferiv(buffer, pname, values);
	}
	public static void alGetBuffer(int buffer, int pname, FloatBuffer values) {
		org.lwjgl.openal.AL11.alGetBufferfv(buffer, pname, values);
	}
}
