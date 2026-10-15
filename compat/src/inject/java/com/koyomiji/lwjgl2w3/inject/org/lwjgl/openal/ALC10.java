package com.koyomiji.lwjgl2w3.inject.org.lwjgl.openal;

import com.koyomiji.lwjgl2w3.inject.Hidden;
import com.koyomiji.lwjgl2w3.inject.Widen;
import java.nio.IntBuffer;
import org.lwjgl.openal.ALCcontext;
import org.lwjgl.openal.ALCdevice;

public final class ALC10 {
	@Widen
	public ALC10() {
	}
	public static String alcGetString(ALCdevice device, int pname) {
		// TODO(al)
		throw new UnsupportedOperationException();
	}
	public static void alcGetInteger(ALCdevice device, int pname, IntBuffer integerdata) {
		// TODO(al)
		throw new UnsupportedOperationException();
	}
	@Hidden
	public static ALCdevice alcOpenDevice(String devicename) {
		// TODO(al)
		throw new UnsupportedOperationException();
	}
	public static boolean alcCloseDevice(ALCdevice device) {
		// TODO(al)
		throw new UnsupportedOperationException();
	}
	public static ALCcontext alcCreateContext(ALCdevice device, IntBuffer attrList) {
		// TODO(al)
		throw new UnsupportedOperationException();
	}
	public static int alcMakeContextCurrent(ALCcontext context) {
		// TODO(al)
		throw new UnsupportedOperationException();
	}
	public static void alcProcessContext(ALCcontext context) {
		// TODO(al)
		throw new UnsupportedOperationException();
	}
	@Hidden
	public static ALCcontext alcGetCurrentContext() {
		// TODO(al)
		throw new UnsupportedOperationException();
	}
	public static ALCdevice alcGetContextsDevice(ALCcontext context) {
		// TODO(al)
		throw new UnsupportedOperationException();
	}
	public static void alcSuspendContext(ALCcontext context) {
		// TODO(al)
		throw new UnsupportedOperationException();
	}
	public static void alcDestroyContext(ALCcontext context) {
		// TODO(al)
		throw new UnsupportedOperationException();
	}
	public static int alcGetError(ALCdevice device) {
		// TODO(al)
		throw new UnsupportedOperationException();
	}
	public static boolean alcIsExtensionPresent(ALCdevice device, String extName) {
		// TODO(al)
		throw new UnsupportedOperationException();
	}
	public static int alcGetEnumValue(ALCdevice device, String enumName) {
		// TODO(al)
		throw new UnsupportedOperationException();
	}
}
