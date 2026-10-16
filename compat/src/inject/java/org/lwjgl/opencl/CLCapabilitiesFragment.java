package org.lwjgl.opencl;

import com.koyomiji.lwjgl2w3.inject.Into;

/**
 * LWJGL 2's CLCapabilities: the extension flags CLPlatformCapabilities and CLDeviceCapabilities (imported) combine with
 * the extension strings, and the per-object capabilities. LWJGL 2 set a flag when the library exported the extension's
 * functions; so does this, through LWJGL 3's function provider. LWJGL 2's OpenCL1x flags and function pointer fields
 * are left out: LWJGL 3's instance fields have their names, and nothing imported reads them.
 */
@Into(CLCapabilities.class)
final class CLCapabilitiesFragment {

	static final boolean CL_APPLE_ContextLoggingFunctions = has("clLogMessagesToSystemLogAPPLE")
		& has("clLogMessagesToStdoutAPPLE") & has("clLogMessagesToStderrAPPLE");
	static final boolean CL_APPLE_SetMemObjectDestructor = has("clSetMemObjectDestructorAPPLE");
	static final boolean CL_APPLE_gl_sharing = has("clGetGLContextInfoAPPLE");
	static final boolean CL_EXT_device_fission = has("clRetainDeviceEXT") & has("clReleaseDeviceEXT") & has("clCreateSubDevicesEXT");
	static final boolean CL_EXT_migrate_memobject = has("clEnqueueMigrateMemObjectEXT");
	static final boolean CL_KHR_gl_event = has("clCreateEventFromGLsyncKHR");
	static final boolean CL_KHR_gl_sharing = has("clGetGLContextInfoKHR");
	static final boolean CL_KHR_icd = true; // as LWJGL 2: (clIcdGetPlatformIDsKHR != 0 || true)
	static final boolean CL_KHR_subgroups = has("clGetKernelSubGroupInfoKHR");
	static final boolean CL_KHR_terminate_context = has("clTerminateContextKHR");

	/** CL.create sets the function provider before it creates the ICD's capabilities, which initializes this class. */
	private static boolean has(String function) {
		try {
			return CL.getFunctionProvider().getFunctionAddress(function) != 0L;
		} catch (IllegalStateException | LinkageError e) { // not loaded, or CL failed to: LWJGL 2 had 0 before CL.create too
			return false;
		}
	}

	public static CLPlatformCapabilities getPlatformCapabilities(final CLPlatform platform) {
		platform.checkValid();

		CLPlatformCapabilities caps = (CLPlatformCapabilities)platform.getCapabilities();
		if (caps == null) {
			platform.setCapabilities(caps = new CLPlatformCapabilities(platform));
		}

		return caps;
	}

	public static CLDeviceCapabilities getDeviceCapabilities(final CLDevice device) {
		device.checkValid();

		CLDeviceCapabilities caps = (CLDeviceCapabilities)device.getCapabilities();
		if (caps == null) {
			device.setCapabilities(caps = new CLDeviceCapabilities(device));
		}

		return caps;
	}

}
