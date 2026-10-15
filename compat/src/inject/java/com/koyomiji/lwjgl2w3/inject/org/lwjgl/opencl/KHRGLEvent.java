package com.koyomiji.lwjgl2w3.inject.org.lwjgl.opencl;

import java.nio.IntBuffer;
import org.lwjgl.opencl.CLContext;
import org.lwjgl.opencl.CLEvent;
import org.lwjgl.opengl.GLSync;

public final class KHRGLEvent {
	public static CLEvent clCreateEventFromGLsyncKHR(CLContext context, GLSync sync, IntBuffer errcode_ret) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}
}
