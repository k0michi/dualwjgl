package com.koyomiji.lwjgl2w3.generated.org.lwjgl.opengl;

import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public final class KHRRobustness {
	public static void glReadnPixels(int x, int y, int width, int height, int format, int type, DoubleBuffer pixels) {
		org.lwjgl.opengl.KHRRobustness.nglReadnPixels(x, y, width, height, format, type, (org.lwjgl.system.Checks.remainingSafe(pixels) << 3), org.lwjgl.system.MemoryUtil.memAddressSafe(pixels));
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
