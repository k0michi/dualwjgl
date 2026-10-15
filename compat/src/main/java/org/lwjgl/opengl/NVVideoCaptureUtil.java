package org.lwjgl.opengl;

import java.nio.IntBuffer;
import java.nio.LongBuffer;

public final class NVVideoCaptureUtil {
	private NVVideoCaptureUtil() {
	}

	public static boolean glBindVideoCaptureDeviceNV(int video_slot, long device) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static int glEnumerateVideoCaptureDevicesNV(LongBuffer devices) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static boolean glLockVideoCaptureDeviceNV(long device) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static boolean glQueryVideoCaptureDeviceNV(long device, int attribute, IntBuffer value) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static boolean glReleaseVideoCaptureDeviceNV(long device) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
}
