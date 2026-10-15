package com.koyomiji.lwjgl2w3.inject.org.lwjgl.opengl;

import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public final class KHRRobustness {
	public static void glReadnPixels(int x, int y, int width, int height, int format, int type, DoubleBuffer pixels) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glGetnUniform(int program, int location, FloatBuffer params) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glGetnUniform(int program, int location, IntBuffer params) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glGetnUniformu(int program, int location, IntBuffer params) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
}
