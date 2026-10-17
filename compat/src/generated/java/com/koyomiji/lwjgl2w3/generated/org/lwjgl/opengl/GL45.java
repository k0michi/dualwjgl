package com.koyomiji.lwjgl2w3.generated.org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Hidden;
import com.koyomiji.lwjgl2w3.inject.Todo;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.PointerBuffer;

public final class GL45 {
	public static final int GL_TEXTURE_BINDING = 0x82EB;
	public static final int GL_CONTEXT_ROBUST_ACCESS = 0x90F3;
	public static void glGetTransformFeedback(int xfb, int pname, IntBuffer param) {
		org.lwjgl.opengl.GL45.glGetTransformFeedbackiv(xfb, pname, param);
	}
	public static void glGetTransformFeedback(int xfb, int pname, int index, IntBuffer param) {
		org.lwjgl.opengl.GL45.glGetTransformFeedbacki_v(xfb, pname, index, param);
	}
	public static void glGetTransformFeedback(int xfb, int pname, int index, LongBuffer param) {
		org.lwjgl.opengl.GL45.glGetTransformFeedbacki64_v(xfb, pname, index, param);
	}
	public static void glNamedBufferStorage(int buffer, LongBuffer data, int flags) {
		org.lwjgl.opengl.GL45.glNamedBufferStorage(buffer, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(data), (org.lwjgl.system.Checks.remainingSafe(data) << 3)), flags);
	}
	public static void glGetNamedBufferParameter(int buffer, int pname, IntBuffer params) {
		org.lwjgl.opengl.GL45.glGetNamedBufferParameteriv(buffer, pname, params);
	}
	public static void glGetNamedBufferParameter(int buffer, int pname, LongBuffer params) {
		org.lwjgl.opengl.GL45.glGetNamedBufferParameteri64v(buffer, pname, params);
	}
	@Hidden
	@Todo("gl")
	public static ByteBuffer glGetNamedBufferPointer(int buffer, int pname) {
		throw new UnsupportedOperationException();
	}
	public static void glClearNamedFramebuffer(int framebuffer, int buffer, int drawbuffer, IntBuffer value) {
		org.lwjgl.opengl.GL45.glClearNamedFramebufferiv(framebuffer, buffer, drawbuffer, value);
	}
	public static void glClearNamedFramebufferu(int framebuffer, int buffer, int drawbuffer, IntBuffer value) {
		org.lwjgl.opengl.GL45.glClearNamedFramebufferuiv(framebuffer, buffer, drawbuffer, value);
	}
	public static void glClearNamedFramebuffer(int framebuffer, int buffer, int drawbuffer, FloatBuffer value) {
		org.lwjgl.opengl.GL45.glClearNamedFramebufferfv(framebuffer, buffer, drawbuffer, value);
	}
	@Todo("gl")
	public static void glClearNamedFramebufferfi(int framebuffer, int buffer, float depth, int stencil) {
		throw new UnsupportedOperationException();
	}
	public static void glGetNamedFramebufferParameter(int framebuffer, int pname, IntBuffer params) {
		org.lwjgl.opengl.GL45.glGetNamedFramebufferParameteriv(framebuffer, pname, params);
	}
	public static int glGetNamedFramebufferParameter(int framebuffer, int pname) {
		return org.lwjgl.opengl.GL45.glGetNamedFramebufferParameteri(framebuffer, pname);
	}
	public static void glGetNamedFramebufferAttachmentParameter(int framebuffer, int attachment, int pname, IntBuffer params) {
		org.lwjgl.opengl.GL45.glGetNamedFramebufferAttachmentParameteriv(framebuffer, attachment, pname, params);
	}
	public static int glGetNamedFramebufferAttachmentParameter(int framebuffer, int attachment, int pname) {
		return org.lwjgl.opengl.GL45.glGetNamedFramebufferAttachmentParameteri(framebuffer, attachment, pname);
	}
	public static void glGetNamedRenderbufferParameter(int renderbuffer, int pname, IntBuffer params) {
		org.lwjgl.opengl.GL45.glGetNamedRenderbufferParameteriv(renderbuffer, pname, params);
	}
	public static int glGetNamedRenderbufferParameter(int renderbuffer, int pname) {
		return org.lwjgl.opengl.GL45.glGetNamedRenderbufferParameteri(renderbuffer, pname);
	}
	public static void glCompressedTextureSubImage3D(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int imageSize, ByteBuffer data) {
		org.lwjgl.opengl.GL45.glCompressedTextureSubImage3D(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, imageSize, org.lwjgl.system.MemoryUtil.memAddressSafe(data));
	}
	public static void glTextureParameter(int texture, int pname, FloatBuffer params) {
		org.lwjgl.opengl.GL45.glTextureParameterfv(texture, pname, params);
	}
	public static void glTextureParameterI(int texture, int pname, IntBuffer params) {
		org.lwjgl.opengl.GL45.glTextureParameterIiv(texture, pname, params);
	}
	public static void glTextureParameterIu(int texture, int pname, IntBuffer params) {
		org.lwjgl.opengl.GL45.glTextureParameterIuiv(texture, pname, params);
	}
	public static void glTextureParameter(int texture, int pname, IntBuffer params) {
		org.lwjgl.opengl.GL45.glTextureParameteriv(texture, pname, params);
	}
	public static void glGetCompressedTextureImage(int texture, int level, IntBuffer pixels) {
		org.lwjgl.opengl.GL45.glGetCompressedTextureImage(texture, level, (org.lwjgl.system.Checks.remainingSafe(pixels) << 2), org.lwjgl.system.MemoryUtil.memAddressSafe(pixels));
	}
	public static void glGetCompressedTextureImage(int texture, int level, ShortBuffer pixels) {
		org.lwjgl.opengl.GL45.glGetCompressedTextureImage(texture, level, (org.lwjgl.system.Checks.remainingSafe(pixels) << 1), org.lwjgl.system.MemoryUtil.memAddressSafe(pixels));
	}
	public static void glGetTextureLevelParameter(int texture, int level, int pname, FloatBuffer params) {
		org.lwjgl.opengl.GL45.glGetTextureLevelParameterfv(texture, level, pname, params);
	}
	public static void glGetTextureLevelParameter(int texture, int level, int pname, IntBuffer params) {
		org.lwjgl.opengl.GL45.glGetTextureLevelParameteriv(texture, level, pname, params);
	}
	public static void glGetTextureParameter(int texture, int pname, FloatBuffer params) {
		org.lwjgl.opengl.GL45.glGetTextureParameterfv(texture, pname, params);
	}
	public static void glGetTextureParameterI(int texture, int pname, IntBuffer params) {
		org.lwjgl.opengl.GL45.glGetTextureParameterIiv(texture, pname, params);
	}
	public static void glGetTextureParameterIu(int texture, int pname, IntBuffer params) {
		org.lwjgl.opengl.GL45.glGetTextureParameterIuiv(texture, pname, params);
	}
	public static void glGetTextureParameter(int texture, int pname, IntBuffer params) {
		org.lwjgl.opengl.GL45.glGetTextureParameteriv(texture, pname, params);
	}
	public static void glVertexArrayVertexBuffers(int vaobj, int first, int count, IntBuffer buffers, PointerBuffer offsets, IntBuffer strides) {
		org.lwjgl.opengl.GL45.glVertexArrayVertexBuffers(vaobj, first, org.lwjgl.system.MemoryUtil.memIntBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(buffers), count), offsets, strides);
	}
	public static void glGetVertexArray(int vaobj, int pname, IntBuffer param) {
		org.lwjgl.opengl.GL45.glGetVertexArrayiv(vaobj, pname, param);
	}
	public static int glGetVertexArray(int vaobj, int pname) {
		return org.lwjgl.opengl.GL45.glGetVertexArrayi(vaobj, pname);
	}
	public static void glGetVertexArrayIndexed(int vaobj, int index, int pname, IntBuffer param) {
		org.lwjgl.opengl.GL45.glGetVertexArrayIndexediv(vaobj, index, pname, param);
	}
	public static int glGetVertexArrayIndexed(int vaobj, int index, int pname) {
		return org.lwjgl.opengl.GL45.glGetVertexArrayIndexedi(vaobj, index, pname);
	}
	public static void glGetVertexArrayIndexed64i(int vaobj, int index, int pname, LongBuffer param) {
		org.lwjgl.opengl.GL45.glGetVertexArrayIndexed64iv(vaobj, index, pname, param);
	}
	public static void glReadnPixels(int x, int y, int width, int height, int format, int type, DoubleBuffer pixels) {
		org.lwjgl.opengl.GL45.glReadnPixels(x, y, width, height, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(pixels), (org.lwjgl.system.Checks.remainingSafe(pixels) << 3)));
	}
	public static void glGetnUniform(int program, int location, FloatBuffer params) {
		org.lwjgl.opengl.GL45.glGetnUniformfv(program, location, params);
	}
	public static void glGetnUniform(int program, int location, IntBuffer params) {
		org.lwjgl.opengl.GL45.glGetnUniformiv(program, location, params);
	}
	public static void glGetnUniformu(int program, int location, IntBuffer params) {
		org.lwjgl.opengl.GL45.glGetnUniformuiv(program, location, params);
	}
}
