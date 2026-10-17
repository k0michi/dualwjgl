package org.lwjgl.opencl;

import com.koyomiji.dualwjgl.inject.Generated;
import com.koyomiji.dualwjgl.inject.Into;

@Generated
@Into(KHRTerminateContext.class)
final class KHRTerminateContextGenerated {
	public static int clTerminateContextKHR(CLContext context) {
		return org.lwjgl.opencl.KHRTerminateContext.clTerminateContextKHR(context.getPointer());
	}
}
