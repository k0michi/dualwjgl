package org.lwjgl.opencl;

import com.koyomiji.dualwjgl.inject.Generated;
import com.koyomiji.dualwjgl.inject.Into;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import org.lwjgl.PointerBuffer;

@Generated
@Into(EXTDeviceFission.class)
final class EXTDeviceFissionGenerated {
	public static final int CL_DEVICE_PARITION_TYPES_EXT = 0x4055;
	public static int clRetainDeviceEXT(CLDevice device) {
		int __result = org.lwjgl.opencl.EXTDeviceFission.clRetainDeviceEXT(device.getPointer());
		if ( __result == CL10.CL_SUCCESS ) device.retain();
		return __result;
	}
	public static int clReleaseDeviceEXT(CLDevice device) {
		APIUtil.releaseObjects(device);
		int __result = org.lwjgl.opencl.EXTDeviceFission.clReleaseDeviceEXT(device.getPointer());
		if ( __result == CL10.CL_SUCCESS ) device.release();
		return __result;
	}
	public static int clCreateSubDevicesEXT(CLDevice in_device, LongBuffer properties, PointerBuffer out_devices, IntBuffer num_devices) {
		int __result = org.lwjgl.opencl.EXTDeviceFission.clCreateSubDevicesEXT(in_device.getPointer(), properties, out_devices, num_devices);
		if ( __result == CL10.CL_SUCCESS && out_devices != null ) in_device.registerSubCLDevices(out_devices);
		return __result;
	}
}
