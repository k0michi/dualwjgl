package org.lwjgl.opencl;

import com.koyomiji.lwjgl2w3.inject.Into;
import com.koyomiji.lwjgl2w3.inject.Wrap;
import org.lwjgl.PointerBuffer;

import java.nio.IntBuffer;

/** The CL10 parts of LWJGL 2's CL object model that bindings do not cover. */
@Into(CL10.class)
final class CL10Fragment {

	/**
	 * LWJGL 3's clGetPlatformIDs (the same signature as LWJGL 2's, so LWJGL 3's wins) plus LWJGL 2's side effect:
	 * the platforms it returns get CLPlatform wrappers, which CLPlatform.getPlatforms and the CL object model look up.
	 */
	@Wrap
	public static int clGetPlatformIDs(PointerBuffer platforms, IntBuffer num_platforms) {
		if (platforms != null && num_platforms == null) {
			num_platforms = APIUtil.getBufferInt();
		}
		int result = clGetPlatformIDs$lwjgl3(platforms, num_platforms);
		if (result == CL10.CL_SUCCESS && platforms != null) {
			CLPlatform.registerCLPlatforms(platforms, num_platforms);
		}
		return result;
	}

	static native int clGetPlatformIDs$lwjgl3(PointerBuffer platforms, IntBuffer num_platforms);

	// LWJGL 2's natives with the function pointer last, which InfoUtilFactory (imported) calls: LWJGL 3's take theirs
	// from the ICD

	static long nclCreateContext(long properties, int num_devices, long devices, long pfn_notify, long user_data, long errcode_ret,
		long function_pointer) {
		return CL10.nclCreateContext(properties, num_devices, devices, pfn_notify, user_data, errcode_ret);
	}

	static long nclCreateImage2D(long context, long flags, long image_format, long image_width, long image_height, long image_row_pitch,
		long host_ptr, long errcode_ret, long function_pointer) {
		return CL10.nclCreateImage2D(context, flags, image_format, image_width, image_height, image_row_pitch, host_ptr, errcode_ret);
	}

	static long nclCreateImage3D(long context, long flags, long image_format, long image_width, long image_height, long image_depth,
		long image_row_pitch, long image_slice_pitch, long host_ptr, long errcode_ret, long function_pointer) {
		return CL10.nclCreateImage3D(context, flags, image_format, image_width, image_height, image_depth, image_row_pitch,
			image_slice_pitch, host_ptr, errcode_ret);
	}

}
