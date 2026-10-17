package com.koyomiji.dualwjgl.generated.org.lwjgl.opengl;

import java.nio.IntBuffer;

public final class ARBInternalformatQuery {
	public static void glGetInternalformat(int target, int internalformat, int pname, IntBuffer params) {
		org.lwjgl.opengl.ARBInternalformatQuery.glGetInternalformativ(target, internalformat, pname, params);
	}
	public static int glGetInternalformat(int target, int internalformat, int pname) {
		return org.lwjgl.opengl.ARBInternalformatQuery.glGetInternalformati(target, internalformat, pname);
	}
}
