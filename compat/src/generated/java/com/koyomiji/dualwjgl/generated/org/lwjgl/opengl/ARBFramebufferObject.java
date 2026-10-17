package com.koyomiji.dualwjgl.generated.org.lwjgl.opengl;

import java.nio.IntBuffer;

public final class ARBFramebufferObject {
	public static final int GL_SRGB = 0x8C40;
	public static void glGetRenderbufferParameter(int target, int pname, IntBuffer params) {
		org.lwjgl.opengl.ARBFramebufferObject.glGetRenderbufferParameteriv(target, pname, params);
	}
	@Deprecated
	public static int glGetRenderbufferParameter(int target, int pname) {
		return org.lwjgl.opengl.ARBFramebufferObject.glGetRenderbufferParameteri(target, pname);
	}
	public static void glGetFramebufferAttachmentParameter(int target, int attachment, int pname, IntBuffer params) {
		org.lwjgl.opengl.ARBFramebufferObject.glGetFramebufferAttachmentParameteriv(target, attachment, pname, params);
	}
	@Deprecated
	public static int glGetFramebufferAttachmentParameter(int target, int attachment, int pname) {
		return org.lwjgl.opengl.ARBFramebufferObject.glGetFramebufferAttachmentParameteri(target, attachment, pname);
	}
}
