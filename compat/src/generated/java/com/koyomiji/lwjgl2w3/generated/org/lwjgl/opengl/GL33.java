package com.koyomiji.lwjgl2w3.generated.org.lwjgl.opengl;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;

public final class GL33 {
	public static void glSamplerParameter(int sampler, int pname, IntBuffer params) {
		org.lwjgl.opengl.GL33.glSamplerParameteriv(sampler, pname, params);
	}
	public static void glSamplerParameter(int sampler, int pname, FloatBuffer params) {
		org.lwjgl.opengl.GL33.glSamplerParameterfv(sampler, pname, params);
	}
	public static void glSamplerParameterI(int sampler, int pname, IntBuffer params) {
		org.lwjgl.opengl.GL33.glSamplerParameterIiv(sampler, pname, params);
	}
	public static void glSamplerParameterIu(int sampler, int pname, IntBuffer params) {
		org.lwjgl.opengl.GL33.glSamplerParameterIuiv(sampler, pname, params);
	}
	public static void glGetSamplerParameter(int sampler, int pname, IntBuffer params) {
		org.lwjgl.opengl.GL33.glGetSamplerParameteriv(sampler, pname, params);
	}
	public static void glGetSamplerParameter(int sampler, int pname, FloatBuffer params) {
		org.lwjgl.opengl.GL33.glGetSamplerParameterfv(sampler, pname, params);
	}
	public static void glGetSamplerParameterI(int sampler, int pname, IntBuffer params) {
		org.lwjgl.opengl.GL33.glGetSamplerParameterIiv(sampler, pname, params);
	}
	public static void glGetSamplerParameterIu(int sampler, int pname, IntBuffer params) {
		org.lwjgl.opengl.GL33.glGetSamplerParameterIuiv(sampler, pname, params);
	}
	public static void glGetQueryObject(int id, int pname, LongBuffer params) {
		org.lwjgl.opengl.GL33.glGetQueryObjecti64v(id, pname, params);
	}
	@Deprecated
	public static long glGetQueryObject(int id, int pname) {
		return org.lwjgl.opengl.GL33.glGetQueryObjecti64(id, pname);
	}
	public static void glGetQueryObjectu(int id, int pname, LongBuffer params) {
		org.lwjgl.opengl.GL33.glGetQueryObjectui64v(id, pname, params);
	}
	@Deprecated
	public static long glGetQueryObjectu(int id, int pname) {
		return org.lwjgl.opengl.GL33.glGetQueryObjectui64(id, pname);
	}
	public static void glVertexP2u(int type, IntBuffer value) {
		org.lwjgl.opengl.GL33.glVertexP2uiv(type, value);
	}
	public static void glVertexP3u(int type, IntBuffer value) {
		org.lwjgl.opengl.GL33.glVertexP3uiv(type, value);
	}
	public static void glVertexP4u(int type, IntBuffer value) {
		org.lwjgl.opengl.GL33.glVertexP4uiv(type, value);
	}
	public static void glTexCoordP1u(int type, IntBuffer coords) {
		org.lwjgl.opengl.GL33.glTexCoordP1uiv(type, coords);
	}
	public static void glTexCoordP2u(int type, IntBuffer coords) {
		org.lwjgl.opengl.GL33.glTexCoordP2uiv(type, coords);
	}
	public static void glTexCoordP3u(int type, IntBuffer coords) {
		org.lwjgl.opengl.GL33.glTexCoordP3uiv(type, coords);
	}
	public static void glTexCoordP4u(int type, IntBuffer coords) {
		org.lwjgl.opengl.GL33.glTexCoordP4uiv(type, coords);
	}
	public static void glMultiTexCoordP1u(int texture, int type, IntBuffer coords) {
		org.lwjgl.opengl.GL33.glMultiTexCoordP1uiv(texture, type, coords);
	}
	public static void glMultiTexCoordP2u(int texture, int type, IntBuffer coords) {
		org.lwjgl.opengl.GL33.glMultiTexCoordP2uiv(texture, type, coords);
	}
	public static void glMultiTexCoordP3u(int texture, int type, IntBuffer coords) {
		org.lwjgl.opengl.GL33.glMultiTexCoordP3uiv(texture, type, coords);
	}
	public static void glMultiTexCoordP4u(int texture, int type, IntBuffer coords) {
		org.lwjgl.opengl.GL33.glMultiTexCoordP4uiv(texture, type, coords);
	}
	public static void glNormalP3u(int type, IntBuffer coords) {
		org.lwjgl.opengl.GL33.glNormalP3uiv(type, coords);
	}
	public static void glColorP3u(int type, IntBuffer color) {
		org.lwjgl.opengl.GL33.glColorP3uiv(type, color);
	}
	public static void glColorP4u(int type, IntBuffer color) {
		org.lwjgl.opengl.GL33.glColorP4uiv(type, color);
	}
	public static void glSecondaryColorP3u(int type, IntBuffer color) {
		org.lwjgl.opengl.GL33.glSecondaryColorP3uiv(type, color);
	}
	public static void glVertexAttribP1u(int index, int type, boolean normalized, IntBuffer value) {
		org.lwjgl.opengl.GL33.glVertexAttribP1uiv(index, type, normalized, value);
	}
	public static void glVertexAttribP2u(int index, int type, boolean normalized, IntBuffer value) {
		org.lwjgl.opengl.GL33.glVertexAttribP2uiv(index, type, normalized, value);
	}
	public static void glVertexAttribP3u(int index, int type, boolean normalized, IntBuffer value) {
		org.lwjgl.opengl.GL33.glVertexAttribP3uiv(index, type, normalized, value);
	}
	public static void glVertexAttribP4u(int index, int type, boolean normalized, IntBuffer value) {
		org.lwjgl.opengl.GL33.glVertexAttribP4uiv(index, type, normalized, value);
	}
}
