package org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Generated;
import java.nio.IntBuffer;
import java.nio.LongBuffer;

@Generated
public final class NVVideoCaptureUtil {
	private NVVideoCaptureUtil() {
	}

	public static boolean glBindVideoCaptureDeviceNV(int video_slot, long device) {
		throw new IllegalStateException("Function is not supported");
	}

	public static int glEnumerateVideoCaptureDevicesNV(LongBuffer devices) {
		throw new IllegalStateException("Function is not supported");
	}

	public static boolean glLockVideoCaptureDeviceNV(long device) {
		throw new IllegalStateException("Function is not supported");
	}

	public static boolean glQueryVideoCaptureDeviceNV(long device, int attribute, IntBuffer value) {
		throw new IllegalStateException("Function is not supported");
	}

	public static boolean glReleaseVideoCaptureDeviceNV(long device) {
		throw new IllegalStateException("Function is not supported");
	}
}
