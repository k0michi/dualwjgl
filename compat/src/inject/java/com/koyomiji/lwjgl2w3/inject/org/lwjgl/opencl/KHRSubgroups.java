package com.koyomiji.lwjgl2w3.inject.org.lwjgl.opencl;

import java.nio.ByteBuffer;
import org.lwjgl.PointerBuffer;
import org.lwjgl.opencl.CLDevice;
import org.lwjgl.opencl.CLKernel;

public final class KHRSubgroups {
	public static int clGetKernelSubGroupInfoKHR(CLKernel kernel, CLDevice device, int param_name, ByteBuffer input_value, ByteBuffer param_value, PointerBuffer param_value_size_ret) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}
}
