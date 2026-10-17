package org.lwjgl.opencl;

import com.koyomiji.lwjgl2w3.inject.Generated;
import com.koyomiji.lwjgl2w3.inject.Into;
import java.nio.ByteBuffer;
import org.lwjgl.PointerBuffer;

@Generated
@Into(APPLEGLSharing.class)
final class APPLEGLSharingGenerated {
	public static int clGetGLContextInfoAPPLE(CLContext context, PointerBuffer platform_gl_ctx, int param_name, ByteBuffer param_value, PointerBuffer param_value_size_ret) {
		if ( param_value_size_ret == null && APIUtil.isDevicesParam(param_name) ) param_value_size_ret = APIUtil.getBufferPointer();
		int __result = org.lwjgl.opencl.APPLEGLSharing.clGetGLContextInfoAPPLE(context.getPointer(), org.lwjgl.system.MemoryUtil.memAddressSafe(platform_gl_ctx), param_name, param_value, param_value_size_ret);
		if ( __result == CL10.CL_SUCCESS && param_value != null && APIUtil.isDevicesParam(param_name) ) context.getParent().registerCLDevices(param_value, param_value_size_ret);
		return __result;
	}
}
