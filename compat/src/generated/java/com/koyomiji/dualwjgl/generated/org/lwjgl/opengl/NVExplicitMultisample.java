package com.koyomiji.dualwjgl.generated.org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public final class NVExplicitMultisample {
	public static void glGetBooleanIndexedEXT(int pname, int index, ByteBuffer data) {
		org.lwjgl.opengl.EXTDirectStateAccess.glGetBooleanIndexedvEXT(pname, index, data);
	}
	public static boolean glGetBooleanIndexedEXT(int pname, int index) {
		return org.lwjgl.opengl.EXTDirectStateAccess.glGetBooleanIndexedEXT(pname, index);
	}
	public static void glGetIntegerIndexedEXT(int pname, int index, IntBuffer data) {
		org.lwjgl.opengl.EXTDirectStateAccess.glGetIntegerIndexedvEXT(pname, index, data);
	}
	public static int glGetIntegerIndexedEXT(int pname, int index) {
		return org.lwjgl.opengl.EXTDirectStateAccess.glGetIntegerIndexedEXT(pname, index);
	}
	public static void glGetMultisampleNV(int pname, int index, FloatBuffer val) {
		org.lwjgl.opengl.NVExplicitMultisample.glGetMultisamplefvNV(pname, index, val);
	}
}
