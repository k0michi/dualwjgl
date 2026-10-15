package com.koyomiji.lwjgl2w3.generated.org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Todo;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public final class KHRRobustness {
	@Todo("gl")
	public static void glReadnPixels(int x, int y, int width, int height, int format, int type, DoubleBuffer pixels) {
		throw new UnsupportedOperationException();
	}
	public static void glGetnUniform(int program, int location, FloatBuffer params) {
		org.lwjgl.opengl.KHRRobustness.glGetnUniformfv(program, location, params);
	}
	public static void glGetnUniform(int program, int location, IntBuffer params) {
		org.lwjgl.opengl.KHRRobustness.glGetnUniformiv(program, location, params);
	}
	public static void glGetnUniformu(int program, int location, IntBuffer params) {
		org.lwjgl.opengl.KHRRobustness.glGetnUniformuiv(program, location, params);
	}
}
