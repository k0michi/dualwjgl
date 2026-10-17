package com.koyomiji.dualwjgl.generated.org.lwjgl.openal;

import com.koyomiji.dualwjgl.inject.Hidden;
import com.koyomiji.dualwjgl.inject.Todo;
import com.koyomiji.dualwjgl.inject.Widen;
import java.nio.ByteBuffer;
import org.lwjgl.openal.ALCdevice;

public final class ALC11 {
	@Widen
	public ALC11() {
	}
	@Hidden
	@Todo("al")
	public static ALCdevice alcCaptureOpenDevice(String devicename, int frequency, int format, int buffersize) {
		throw new UnsupportedOperationException();
	}
	@Todo("al")
	public static boolean alcCaptureCloseDevice(ALCdevice device) {
		throw new UnsupportedOperationException();
	}
	@Todo("al")
	public static void alcCaptureStart(ALCdevice device) {
		throw new UnsupportedOperationException();
	}
	@Todo("al")
	public static void alcCaptureStop(ALCdevice device) {
		throw new UnsupportedOperationException();
	}
	@Todo("al")
	public static void alcCaptureSamples(ALCdevice device, ByteBuffer buffer, int samples) {
		throw new UnsupportedOperationException();
	}
}
