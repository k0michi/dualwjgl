package org.lwjgl.openal;

import com.koyomiji.lwjgl2w3.inject.Into;

import java.nio.ByteBuffer;

/** LWJGL 2's ALC11 capture functions on its ALCdevice wrapper (see {@link ALObjects}). */
@Into(ALC11.class)
final class ALC11Fragment {

	public static ALCdevice alcCaptureOpenDevice(String devicename, int frequency, int format, int buffersize) {
		return ALObjects.alcCaptureOpenDevice(devicename, frequency, format, buffersize);
	}

	public static boolean alcCaptureCloseDevice(ALCdevice device) {
		return ALObjects.alcCaptureCloseDevice(device);
	}

	public static void alcCaptureStart(ALCdevice device) {
		ALObjects.alcCaptureStart(device);
	}

	public static void alcCaptureStop(ALCdevice device) {
		ALObjects.alcCaptureStop(device);
	}

	public static void alcCaptureSamples(ALCdevice device, ByteBuffer buffer, int samples) {
		ALObjects.alcCaptureSamples(device, buffer, samples);
	}

}
