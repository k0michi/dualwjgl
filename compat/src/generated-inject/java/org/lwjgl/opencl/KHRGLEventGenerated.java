package org.lwjgl.opencl;

import com.koyomiji.lwjgl2w3.inject.Generated;
import com.koyomiji.lwjgl2w3.inject.Into;
import java.nio.IntBuffer;
import org.lwjgl.opengl.GLSync;

@Generated
@Into(KHRGLEvent.class)
final class KHRGLEventGenerated {
	public static CLEvent clCreateEventFromGLsyncKHR(CLContext context, GLSync sync, IntBuffer errcode_ret) {
		org.lwjgl.opencl.CLEvent __result = new org.lwjgl.opencl.CLEvent(org.lwjgl.opencl.KHRGLEvent.clCreateEventFromGLsyncKHR(context.getPointer(), sync.getPointer(), errcode_ret), context);
		return __result;
	}
}
