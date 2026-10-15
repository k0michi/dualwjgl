package com.koyomiji.lwjgl2w3.inject.org.lwjgl.openal;

import com.koyomiji.lwjgl2w3.inject.Hidden;
import com.koyomiji.lwjgl2w3.inject.Widen;
import java.nio.ByteBuffer;
import org.lwjgl.openal.ALCdevice;

public final class ALC11 {
	@Widen
	public ALC11() {
	}
	@Hidden
	public static ALCdevice alcCaptureOpenDevice(String devicename, int frequency, int format, int buffersize) {
		// TODO(al)
		throw new UnsupportedOperationException();
	}
	public static boolean alcCaptureCloseDevice(ALCdevice device) {
		// TODO(al)
		throw new UnsupportedOperationException();
	}
	public static void alcCaptureStart(ALCdevice device) {
		// TODO(al)
		throw new UnsupportedOperationException();
	}
	public static void alcCaptureStop(ALCdevice device) {
		// TODO(al)
		throw new UnsupportedOperationException();
	}
	public static void alcCaptureSamples(ALCdevice device, ByteBuffer buffer, int samples) {
		// TODO(al)
		throw new UnsupportedOperationException();
	}
}
