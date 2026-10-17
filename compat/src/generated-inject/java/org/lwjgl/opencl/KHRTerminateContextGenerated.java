package org.lwjgl.opencl;

import com.koyomiji.lwjgl2w3.inject.Generated;
import com.koyomiji.lwjgl2w3.inject.Into;

@Generated
@Into(KHRTerminateContext.class)
final class KHRTerminateContextGenerated {
	public static int clTerminateContextKHR(CLContext context) {
		return org.lwjgl.opencl.KHRTerminateContext.clTerminateContextKHR(context.getPointer());
	}
}
