package org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Generated;
import com.koyomiji.lwjgl2w3.inject.Todo;
import java.nio.IntBuffer;
import java.nio.LongBuffer;

@Generated
public final class NVVideoCaptureUtil {
	private NVVideoCaptureUtil() {
	}

	@Todo("gl")
	public static boolean glBindVideoCaptureDeviceNV(int video_slot, long device) {
		throw new UnsupportedOperationException();
	}

	@Todo("gl")
	public static int glEnumerateVideoCaptureDevicesNV(LongBuffer devices) {
		throw new UnsupportedOperationException();
	}

	@Todo("gl")
	public static boolean glLockVideoCaptureDeviceNV(long device) {
		throw new UnsupportedOperationException();
	}

	@Todo("gl")
	public static boolean glQueryVideoCaptureDeviceNV(long device, int attribute, IntBuffer value) {
		throw new UnsupportedOperationException();
	}

	@Todo("gl")
	public static boolean glReleaseVideoCaptureDeviceNV(long device) {
		throw new UnsupportedOperationException();
	}
}
