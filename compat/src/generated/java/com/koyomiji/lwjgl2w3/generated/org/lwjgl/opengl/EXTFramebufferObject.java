package com.koyomiji.lwjgl2w3.generated.org.lwjgl.opengl;

import java.nio.IntBuffer;

public final class EXTFramebufferObject {
	public static void glGetRenderbufferParameterEXT(int target, int pname, IntBuffer params) {
		org.lwjgl.opengl.EXTFramebufferObject.glGetRenderbufferParameterivEXT(target, pname, params);
	}
	@Deprecated
	public static int glGetRenderbufferParameterEXT(int target, int pname) {
		return org.lwjgl.opengl.EXTFramebufferObject.glGetRenderbufferParameteriEXT(target, pname);
	}
	public static void glGetFramebufferAttachmentParameterEXT(int target, int attachment, int pname, IntBuffer params) {
		org.lwjgl.opengl.EXTFramebufferObject.glGetFramebufferAttachmentParameterivEXT(target, attachment, pname, params);
	}
	@Deprecated
	public static int glGetFramebufferAttachmentParameterEXT(int target, int attachment, int pname) {
		return org.lwjgl.opengl.EXTFramebufferObject.glGetFramebufferAttachmentParameteriEXT(target, attachment, pname);
	}
}
