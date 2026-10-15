package com.koyomiji.lwjgl2w3.inject.org.lwjgl.openal;

import com.koyomiji.lwjgl2w3.inject.Hidden;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public final class AL10 {
	public static final int AL_CHANNEL_MASK = 0x3000;
	public static final int AL_FORMAT_VORBIS_EXT = 0x10003;
	public static final int AL_DATA = 0x2005;
	public static final int AL_DOPPLER_VELOCITY = 0xC001;
	public static void alGetInteger(int pname, IntBuffer data) {
		// TODO(al)
		throw new UnsupportedOperationException();
	}
	public static void alGetFloat(int pname, FloatBuffer data) {
		// TODO(al)
		throw new UnsupportedOperationException();
	}
	public static void alGetDouble(int pname, DoubleBuffer data) {
		// TODO(al)
		throw new UnsupportedOperationException();
	}
	@Hidden
	public static boolean alIsExtensionPresent(String fname) {
		// TODO(al)
		throw new UnsupportedOperationException();
	}
	@Hidden
	public static int alGetEnumValue(String ename) {
		// TODO(al)
		throw new UnsupportedOperationException();
	}
	public static void alListener(int pname, FloatBuffer value) {
		// TODO(al)
		throw new UnsupportedOperationException();
	}
	public static void alGetListener(int pname, FloatBuffer floatdata) {
		// TODO(al)
		throw new UnsupportedOperationException();
	}
	public static void alSource(int source, int pname, FloatBuffer value) {
		// TODO(al)
		throw new UnsupportedOperationException();
	}
	public static void alGetSource(int source, int pname, FloatBuffer floatdata) {
		// TODO(al)
		throw new UnsupportedOperationException();
	}
	public static void alSourcePlay(IntBuffer sources) {
		// TODO(al)
		throw new UnsupportedOperationException();
	}
	public static void alSourcePause(IntBuffer sources) {
		// TODO(al)
		throw new UnsupportedOperationException();
	}
	public static void alSourceStop(IntBuffer sources) {
		// TODO(al)
		throw new UnsupportedOperationException();
	}
	public static void alSourceRewind(IntBuffer sources) {
		// TODO(al)
		throw new UnsupportedOperationException();
	}
}
