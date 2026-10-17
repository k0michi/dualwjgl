package com.koyomiji.dualwjgl.generated.org.lwjgl.openal;

import com.koyomiji.dualwjgl.inject.Hidden;
import com.koyomiji.dualwjgl.inject.Todo;
import com.koyomiji.dualwjgl.inject.Widen;
import java.nio.IntBuffer;
import org.lwjgl.openal.ALCcontext;
import org.lwjgl.openal.ALCdevice;

public final class ALC10 {
	@Widen
	public ALC10() {
	}
	@Todo("al")
	public static String alcGetString(ALCdevice device, int pname) {
		throw new UnsupportedOperationException();
	}
	@Todo("al")
	public static void alcGetInteger(ALCdevice device, int pname, IntBuffer integerdata) {
		throw new UnsupportedOperationException();
	}
	@Hidden
	@Todo("al")
	public static ALCdevice alcOpenDevice(String devicename) {
		throw new UnsupportedOperationException();
	}
	@Todo("al")
	public static boolean alcCloseDevice(ALCdevice device) {
		throw new UnsupportedOperationException();
	}
	@Todo("al")
	public static ALCcontext alcCreateContext(ALCdevice device, IntBuffer attrList) {
		throw new UnsupportedOperationException();
	}
	@Todo("al")
	public static int alcMakeContextCurrent(ALCcontext context) {
		throw new UnsupportedOperationException();
	}
	@Todo("al")
	public static void alcProcessContext(ALCcontext context) {
		throw new UnsupportedOperationException();
	}
	@Hidden
	@Todo("al")
	public static ALCcontext alcGetCurrentContext() {
		throw new UnsupportedOperationException();
	}
	@Todo("al")
	public static ALCdevice alcGetContextsDevice(ALCcontext context) {
		throw new UnsupportedOperationException();
	}
	@Todo("al")
	public static void alcSuspendContext(ALCcontext context) {
		throw new UnsupportedOperationException();
	}
	@Todo("al")
	public static void alcDestroyContext(ALCcontext context) {
		throw new UnsupportedOperationException();
	}
	@Todo("al")
	public static int alcGetError(ALCdevice device) {
		throw new UnsupportedOperationException();
	}
	@Todo("al")
	public static boolean alcIsExtensionPresent(ALCdevice device, String extName) {
		throw new UnsupportedOperationException();
	}
	@Todo("al")
	public static int alcGetEnumValue(ALCdevice device, String enumName) {
		throw new UnsupportedOperationException();
	}
}
