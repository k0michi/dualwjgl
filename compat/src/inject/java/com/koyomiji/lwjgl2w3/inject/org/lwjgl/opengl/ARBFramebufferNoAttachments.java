package com.koyomiji.lwjgl2w3.inject.org.lwjgl.opengl;

import java.nio.IntBuffer;

public final class ARBFramebufferNoAttachments {
	public static void glGetFramebufferParameter(int target, int pname, IntBuffer params) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glGetNamedFramebufferParameterEXT(int framebuffer, int pname, IntBuffer params) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static int glGetNamedFramebufferParameterEXT(int framebuffer, int pname) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
}
