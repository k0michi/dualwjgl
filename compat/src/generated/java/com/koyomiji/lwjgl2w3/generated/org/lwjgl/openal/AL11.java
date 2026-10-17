package com.koyomiji.lwjgl2w3.generated.org.lwjgl.openal;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public final class AL11 {
	public static void alGetListeneri(int pname, FloatBuffer intdata) {
		org.lwjgl.openal.AL11.alGetListeneriv(pname, org.lwjgl.system.MemoryUtil.memIntBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(intdata), org.lwjgl.system.Checks.remainingSafe(intdata)));
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
