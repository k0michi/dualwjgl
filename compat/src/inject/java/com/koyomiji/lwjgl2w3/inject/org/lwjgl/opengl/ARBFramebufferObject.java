package com.koyomiji.lwjgl2w3.inject.org.lwjgl.opengl;

import java.nio.IntBuffer;

public final class ARBFramebufferObject {
	public static final int GL_SRGB = 0x8C40;
	public static void glGetRenderbufferParameter(int target, int pname, IntBuffer params) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	@Deprecated
	public static int glGetRenderbufferParameter(int target, int pname) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glGetFramebufferAttachmentParameter(int target, int attachment, int pname, IntBuffer params) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	@Deprecated
	public static int glGetFramebufferAttachmentParameter(int target, int attachment, int pname) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
}
