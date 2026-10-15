package org.lwjgl.opengl;

import java.nio.IntBuffer;
import java.nio.LongBuffer;

public final class NVPresentVideoUtil {
	private NVPresentVideoUtil() {
	}

	public static int glEnumerateVideoDevicesNV(LongBuffer devices) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static boolean glBindVideoDeviceNV(int video_slot, long video_device, IntBuffer attrib_list) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static boolean glQueryContextNV(int attrib, IntBuffer value) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
}
