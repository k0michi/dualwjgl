package com.koyomiji.lwjgl2w3.generated.org.lwjgl.openal;

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
		org.lwjgl.openal.AL10.alGetIntegerv(pname, data);
	}
	public static void alGetFloat(int pname, FloatBuffer data) {
		org.lwjgl.openal.AL10.alGetFloatv(pname, data);
	}
	public static void alGetDouble(int pname, DoubleBuffer data) {
		org.lwjgl.openal.AL10.alGetDoublev(pname, data);
	}
	@Hidden
	public static boolean alIsExtensionPresent(String fname) {
		return org.lwjgl.openal.AL10.alIsExtensionPresent(fname);
	}
	@Hidden
	public static int alGetEnumValue(String ename) {
		return org.lwjgl.openal.AL10.alGetEnumValue(ename);
	}
	public static void alListener(int pname, FloatBuffer value) {
		org.lwjgl.openal.AL10.alListenerfv(pname, value);
	}
	public static void alGetListener(int pname, FloatBuffer floatdata) {
		org.lwjgl.openal.AL10.alGetListenerfv(pname, floatdata);
	}
	public static void alSource(int source, int pname, FloatBuffer value) {
		org.lwjgl.openal.AL10.alSourcefv(source, pname, value);
	}
	public static void alGetSource(int source, int pname, FloatBuffer floatdata) {
		org.lwjgl.openal.AL10.alGetSourcefv(source, pname, floatdata);
	}
	public static void alSourcePlay(IntBuffer sources) {
		org.lwjgl.openal.AL10.alSourcePlayv(sources);
	}
	public static void alSourcePause(IntBuffer sources) {
		org.lwjgl.openal.AL10.alSourcePausev(sources);
	}
	public static void alSourceStop(IntBuffer sources) {
		org.lwjgl.openal.AL10.alSourceStopv(sources);
	}
	public static void alSourceRewind(IntBuffer sources) {
		org.lwjgl.openal.AL10.alSourceRewindv(sources);
	}
}
