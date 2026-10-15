package com.koyomiji.lwjgl2w3.generated.org.lwjgl.opengl;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public final class ARBSamplerObjects {
	public static void glSamplerParameter(int sampler, int pname, IntBuffer params) {
		org.lwjgl.opengl.ARBSamplerObjects.glSamplerParameteriv(sampler, pname, params);
	}
	public static void glSamplerParameter(int sampler, int pname, FloatBuffer params) {
		org.lwjgl.opengl.ARBSamplerObjects.glSamplerParameterfv(sampler, pname, params);
	}
	public static void glSamplerParameterI(int sampler, int pname, IntBuffer params) {
		org.lwjgl.opengl.ARBSamplerObjects.glSamplerParameterIiv(sampler, pname, params);
	}
	public static void glSamplerParameterIu(int sampler, int pname, IntBuffer params) {
		org.lwjgl.opengl.ARBSamplerObjects.glSamplerParameterIuiv(sampler, pname, params);
	}
	public static void glGetSamplerParameter(int sampler, int pname, IntBuffer params) {
		org.lwjgl.opengl.ARBSamplerObjects.glGetSamplerParameteriv(sampler, pname, params);
	}
	public static void glGetSamplerParameter(int sampler, int pname, FloatBuffer params) {
		org.lwjgl.opengl.ARBSamplerObjects.glGetSamplerParameterfv(sampler, pname, params);
	}
	public static void glGetSamplerParameterI(int sampler, int pname, IntBuffer params) {
		org.lwjgl.opengl.ARBSamplerObjects.glGetSamplerParameterIiv(sampler, pname, params);
	}
	public static void glGetSamplerParameterIu(int sampler, int pname, IntBuffer params) {
		org.lwjgl.opengl.ARBSamplerObjects.glGetSamplerParameterIuiv(sampler, pname, params);
	}
}
