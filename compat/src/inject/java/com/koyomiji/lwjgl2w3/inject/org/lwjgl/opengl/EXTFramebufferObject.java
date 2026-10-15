package com.koyomiji.lwjgl2w3.inject.org.lwjgl.opengl;

import java.nio.IntBuffer;

public final class EXTFramebufferObject {
	public static void glGetRenderbufferParameterEXT(int target, int pname, IntBuffer params) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	@Deprecated
	public static int glGetRenderbufferParameterEXT(int target, int pname) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glGetFramebufferAttachmentParameterEXT(int target, int attachment, int pname, IntBuffer params) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	@Deprecated
	public static int glGetFramebufferAttachmentParameterEXT(int target, int attachment, int pname) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
}
