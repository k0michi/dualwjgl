package com.koyomiji.lwjgl2w3.generated.org.lwjgl.opengl;

import java.nio.IntBuffer;

public final class APPLEObjectPurgeable {
	public static void glGetObjectParameterAPPLE(int objectType, int name, int pname, IntBuffer params) {
		org.lwjgl.opengl.APPLEObjectPurgeable.glGetObjectParameterivAPPLE(objectType, name, pname, params);
	}
	public static int glGetObjectParameteriAPPLE(int objectType, int name, int pname) {
		return org.lwjgl.opengl.APPLEObjectPurgeable.glGetObjectParameterivAPPLE(objectType, name, pname);
	}
}
