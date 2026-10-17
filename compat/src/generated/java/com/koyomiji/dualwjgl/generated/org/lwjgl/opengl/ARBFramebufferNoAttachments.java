package com.koyomiji.dualwjgl.generated.org.lwjgl.opengl;

import java.nio.IntBuffer;

public final class ARBFramebufferNoAttachments {
	public static void glGetFramebufferParameter(int target, int pname, IntBuffer params) {
		org.lwjgl.opengl.ARBFramebufferNoAttachments.glGetFramebufferParameteriv(target, pname, params);
	}
	public static void glGetNamedFramebufferParameterEXT(int framebuffer, int pname, IntBuffer params) {
		org.lwjgl.opengl.ARBFramebufferNoAttachments.glGetNamedFramebufferParameterivEXT(framebuffer, pname, params);
	}
	public static int glGetNamedFramebufferParameterEXT(int framebuffer, int pname) {
		return org.lwjgl.opengl.ARBFramebufferNoAttachments.glGetNamedFramebufferParameteriEXT(framebuffer, pname);
	}
}
