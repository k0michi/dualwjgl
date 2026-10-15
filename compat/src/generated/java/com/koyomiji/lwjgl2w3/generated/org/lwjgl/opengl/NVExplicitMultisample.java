package com.koyomiji.lwjgl2w3.generated.org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Todo;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public final class NVExplicitMultisample {
	@Todo("gl")
	public static void glGetBooleanIndexedEXT(int pname, int index, ByteBuffer data) {
		throw new UnsupportedOperationException();
	}
	@Todo("gl")
	public static boolean glGetBooleanIndexedEXT(int pname, int index) {
		throw new UnsupportedOperationException();
	}
	@Todo("gl")
	public static void glGetIntegerIndexedEXT(int pname, int index, IntBuffer data) {
		throw new UnsupportedOperationException();
	}
	@Todo("gl")
	public static int glGetIntegerIndexedEXT(int pname, int index) {
		throw new UnsupportedOperationException();
	}
	public static void glGetMultisampleNV(int pname, int index, FloatBuffer val) {
		org.lwjgl.opengl.NVExplicitMultisample.glGetMultisamplefvNV(pname, index, val);
	}
}
