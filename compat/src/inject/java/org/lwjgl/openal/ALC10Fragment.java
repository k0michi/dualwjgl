package org.lwjgl.openal;

import com.koyomiji.dualwjgl.inject.Into;

import java.nio.IntBuffer;

/** LWJGL 2's ALC10 functions on its ALCdevice and ALCcontext wrappers (see {@link ALObjects}). */
@Into(ALC10.class)
final class ALC10Fragment {

	public static String alcGetString(ALCdevice device, int pname) {
		return ALObjects.alcGetString(device, pname);
	}

	public static void alcGetInteger(ALCdevice device, int pname, IntBuffer integerdata) {
		ALObjects.alcGetInteger(device, pname, integerdata);
	}

	public static ALCdevice alcOpenDevice(String devicename) {
		return ALObjects.alcOpenDevice(devicename);
	}

	public static boolean alcCloseDevice(ALCdevice device) {
		return ALObjects.alcCloseDevice(device);
	}

	public static ALCcontext alcCreateContext(ALCdevice device, IntBuffer attrList) {
		return ALObjects.alcCreateContext(device, attrList);
	}

	public static int alcMakeContextCurrent(ALCcontext context) {
		return ALObjects.alcMakeContextCurrent(context);
	}

	public static void alcProcessContext(ALCcontext context) {
		ALObjects.alcProcessContext(context);
	}

	public static ALCcontext alcGetCurrentContext() {
		return ALObjects.alcGetCurrentContext();
	}

	public static ALCdevice alcGetContextsDevice(ALCcontext context) {
		return ALObjects.alcGetContextsDevice(context);
	}

	public static void alcSuspendContext(ALCcontext context) {
		ALObjects.alcSuspendContext(context);
	}

	public static void alcDestroyContext(ALCcontext context) {
		ALObjects.alcDestroyContext(context);
	}

	public static int alcGetError(ALCdevice device) {
		return ALObjects.alcGetError(device);
	}

	public static boolean alcIsExtensionPresent(ALCdevice device, String extName) {
		return ALObjects.alcIsExtensionPresent(device, extName);
	}

	public static int alcGetEnumValue(ALCdevice device, String enumName) {
		return ALObjects.alcGetEnumValue(device, enumName);
	}

}
