package org.lwjgl.opencl;

import com.koyomiji.dualwjgl.inject.Into;
import com.koyomiji.dualwjgl.inject.Wrap;
import org.lwjgl.PointerBuffer;

import java.nio.ByteBuffer;

@Into(KHRGLSharing.class)
final class KHRGLSharingFragment {

	/**
	 * LWJGL 3's clGetGLContextInfoKHR (the same signature as LWJGL 2's, so LWJGL 3's wins) plus LWJGL 2's side effect:
	 * the devices it returns get CLDevice wrappers on the properties' platform.
	 */
	@Wrap
	public static int clGetGLContextInfoKHR(PointerBuffer properties, int param_name, ByteBuffer param_value, PointerBuffer param_value_size_ret) {
		if (param_value_size_ret == null && APIUtil.isDevicesParam(param_name)) {
			param_value_size_ret = APIUtil.getBufferPointer();
		}
		int result = clGetGLContextInfoKHR$lwjgl3(properties, param_name, param_value, param_value_size_ret);
		if (result == CL10.CL_SUCCESS && param_value != null && APIUtil.isDevicesParam(param_name)) {
			APIUtil.getCLPlatform(properties).registerCLDevices(param_value, param_value_size_ret);
		}
		return result;
	}

	static native int clGetGLContextInfoKHR$lwjgl3(PointerBuffer properties, int param_name, ByteBuffer param_value,
		PointerBuffer param_value_size_ret);

}
