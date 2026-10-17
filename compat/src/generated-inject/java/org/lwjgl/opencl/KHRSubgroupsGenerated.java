package org.lwjgl.opencl;

import com.koyomiji.dualwjgl.inject.Generated;
import com.koyomiji.dualwjgl.inject.Into;
import java.nio.ByteBuffer;
import org.lwjgl.PointerBuffer;

@Generated
@Into(KHRSubgroups.class)
final class KHRSubgroupsGenerated {
	public static int clGetKernelSubGroupInfoKHR(CLKernel kernel, CLDevice device, int param_name, ByteBuffer input_value, ByteBuffer param_value, PointerBuffer param_value_size_ret) {
		return org.lwjgl.opencl.KHRSubgroups.clGetKernelSubGroupInfoKHR(kernel.getPointer(), (device == null ? 0L : device.getPointer()), param_name, input_value, param_value, param_value_size_ret);
	}
}
