package com.koyomiji.lwjgl2w3.generated.org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

public final class GL30 {
	public static final int GL_DEPTH_BUFFER = 0x8223;
	public static final int GL_STENCIL_BUFFER = 0x8224;
	public static final int GL_SAMPLER_BUFFER = 0x8DC2;
	public static final int GL_INT_SAMPLER_2D_RECT = 0x8DCD;
	public static final int GL_INT_SAMPLER_BUFFER = 0x8DD0;
	public static final int GL_UNSIGNED_INT_SAMPLER_2D_RECT = 0x8DD5;
	public static final int GL_UNSIGNED_INT_SAMPLER_BUFFER = 0x8DD8;
	public static final int GL_ALPHA32F = 0x8816;
	public static final int GL_ALPHA16F = 0x881C;
	public static final int GL_RGBA_INTEGER_MODE = 0x8D9E;
	public static final int GL_ALPHA32UI = 0x8D72;
	public static final int GL_ALPHA16UI = 0x8D78;
	public static final int GL_ALPHA8UI = 0x8D7E;
	public static final int GL_ALPHA32I = 0x8D84;
	public static final int GL_ALPHA16I = 0x8D8A;
	public static final int GL_ALPHA8I = 0x8D90;
	public static final int GL_COMPARE_REF_DEPTH_TO_TEXTURE = 0x884E;
	public static final int GL_FRAMEBUFFER_SRGB_CAPABLE = 0x8DBA;
	public static void glClearBuffer(int buffer, int drawbuffer, FloatBuffer value) {
		org.lwjgl.opengl.GL30.glClearBufferfv(buffer, drawbuffer, value);
	}
	public static void glClearBuffer(int buffer, int drawbuffer, IntBuffer value) {
		org.lwjgl.opengl.GL30.glClearBufferiv(buffer, drawbuffer, value);
	}
	public static void glClearBufferu(int buffer, int drawbuffer, IntBuffer value) {
		org.lwjgl.opengl.GL30.glClearBufferuiv(buffer, drawbuffer, value);
	}
	public static void glVertexAttribI1(int index, IntBuffer v) {
		org.lwjgl.opengl.GL30.glVertexAttribI1iv(index, v);
	}
	public static void glVertexAttribI2(int index, IntBuffer v) {
		org.lwjgl.opengl.GL30.glVertexAttribI2iv(index, v);
	}
	public static void glVertexAttribI3(int index, IntBuffer v) {
		org.lwjgl.opengl.GL30.glVertexAttribI3iv(index, v);
	}
	public static void glVertexAttribI4(int index, IntBuffer v) {
		org.lwjgl.opengl.GL30.glVertexAttribI4iv(index, v);
	}
	public static void glVertexAttribI1u(int index, IntBuffer v) {
		org.lwjgl.opengl.GL30.glVertexAttribI1uiv(index, v);
	}
	public static void glVertexAttribI2u(int index, IntBuffer v) {
		org.lwjgl.opengl.GL30.glVertexAttribI2uiv(index, v);
	}
	public static void glVertexAttribI3u(int index, IntBuffer v) {
		org.lwjgl.opengl.GL30.glVertexAttribI3uiv(index, v);
	}
	public static void glVertexAttribI4u(int index, IntBuffer v) {
		org.lwjgl.opengl.GL30.glVertexAttribI4uiv(index, v);
	}
	public static void glVertexAttribI4(int index, ByteBuffer v) {
		org.lwjgl.opengl.GL30.glVertexAttribI4bv(index, v);
	}
	public static void glVertexAttribI4(int index, ShortBuffer v) {
		org.lwjgl.opengl.GL30.glVertexAttribI4sv(index, v);
	}
	public static void glVertexAttribI4u(int index, ByteBuffer v) {
		org.lwjgl.opengl.GL30.glVertexAttribI4ubv(index, v);
	}
	public static void glVertexAttribI4u(int index, ShortBuffer v) {
		org.lwjgl.opengl.GL30.glVertexAttribI4usv(index, v);
	}
	public static void glGetVertexAttribI(int index, int pname, IntBuffer params) {
		org.lwjgl.opengl.GL30.glGetVertexAttribIiv(index, pname, params);
	}
	public static void glGetVertexAttribIu(int index, int pname, IntBuffer params) {
		org.lwjgl.opengl.GL30.glGetVertexAttribIuiv(index, pname, params);
	}
	public static void glUniform1u(int location, IntBuffer value) {
		org.lwjgl.opengl.GL30.glUniform1uiv(location, value);
	}
	public static void glUniform2u(int location, IntBuffer value) {
		org.lwjgl.opengl.GL30.glUniform2uiv(location, value);
	}
	public static void glUniform3u(int location, IntBuffer value) {
		org.lwjgl.opengl.GL30.glUniform3uiv(location, value);
	}
	public static void glUniform4u(int location, IntBuffer value) {
		org.lwjgl.opengl.GL30.glUniform4uiv(location, value);
	}
	public static void glGetUniformu(int program, int location, IntBuffer params) {
		org.lwjgl.opengl.GL30.glGetUniformuiv(program, location, params);
	}
	public static void glGetRenderbufferParameter(int target, int pname, IntBuffer params) {
		org.lwjgl.opengl.GL30.glGetRenderbufferParameteriv(target, pname, params);
	}
	@Deprecated
	public static int glGetRenderbufferParameter(int target, int pname) {
		return org.lwjgl.opengl.GL30.glGetRenderbufferParameteri(target, pname);
	}
	public static void glGetFramebufferAttachmentParameter(int target, int attachment, int pname, IntBuffer params) {
		org.lwjgl.opengl.GL30.glGetFramebufferAttachmentParameteriv(target, attachment, pname, params);
	}
	@Deprecated
	public static int glGetFramebufferAttachmentParameter(int target, int attachment, int pname) {
		return org.lwjgl.opengl.GL30.glGetFramebufferAttachmentParameteri(target, attachment, pname);
	}
	public static void glTexParameterI(int target, int pname, IntBuffer params) {
		org.lwjgl.opengl.GL30.glTexParameterIiv(target, pname, params);
	}
	public static void glTexParameterIu(int target, int pname, IntBuffer params) {
		org.lwjgl.opengl.GL30.glTexParameterIuiv(target, pname, params);
	}
	public static void glGetTexParameterI(int target, int pname, IntBuffer params) {
		org.lwjgl.opengl.GL30.glGetTexParameterIiv(target, pname, params);
	}
	public static void glGetTexParameterIu(int target, int pname, IntBuffer params) {
		org.lwjgl.opengl.GL30.glGetTexParameterIuiv(target, pname, params);
	}
	public static void glGetBoolean(int value, int index, ByteBuffer data) {
		org.lwjgl.opengl.GL30.glGetBooleani_v(value, index, data);
	}
	public static boolean glGetBoolean(int value, int index) {
		return org.lwjgl.opengl.GL30.glGetBooleani(value, index);
	}
	public static void glGetInteger(int value, int index, IntBuffer data) {
		org.lwjgl.opengl.GL30.glGetIntegeri_v(value, index, data);
	}
	public static int glGetInteger(int value, int index) {
		return org.lwjgl.opengl.GL30.glGetIntegeri(value, index);
	}
	public static void glTransformFeedbackVaryings(int program, int count, ByteBuffer varyings, int bufferMode) {
		org.lwjgl.opengl.GL30.glTransformFeedbackVaryings(program, org.lwjgl.system.MemoryUtil.memPointerBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(varyings), count), bufferMode);
	}
}
