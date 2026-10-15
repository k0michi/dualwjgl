package com.koyomiji.lwjgl2w3.inject.org.lwjgl.opencl;

import java.nio.IntBuffer;
import java.nio.LongBuffer;
import org.lwjgl.PointerBuffer;
import org.lwjgl.opencl.CLDevice;

public final class EXTDeviceFission {
	public static final int CL_DEVICE_PARITION_TYPES_EXT = 0x4055;
	public static int clRetainDeviceEXT(CLDevice device) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}
	public static int clReleaseDeviceEXT(CLDevice device) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}
	public static int clCreateSubDevicesEXT(CLDevice in_device, LongBuffer properties, PointerBuffer out_devices, IntBuffer num_devices) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}
}
