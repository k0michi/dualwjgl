package com.koyomiji.lwjgl2w3.inject.org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Hidden;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.PointerBuffer;

public final class ARBDirectStateAccess {
	public static final int GL_TEXTURE_BINDING = 0x82EB;
	public static void glGetTransformFeedback(int xfb, int pname, IntBuffer param) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glGetTransformFeedback(int xfb, int pname, int index, IntBuffer param) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glGetTransformFeedback(int xfb, int pname, int index, LongBuffer param) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glNamedBufferStorage(int buffer, LongBuffer data, int flags) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glGetNamedBufferParameter(int buffer, int pname, IntBuffer params) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glGetNamedBufferParameter(int buffer, int pname, LongBuffer params) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	@Hidden
	public static ByteBuffer glGetNamedBufferPointer(int buffer, int pname) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glClearNamedFramebuffer(int framebuffer, int buffer, int drawbuffer, IntBuffer value) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glClearNamedFramebufferu(int framebuffer, int buffer, int drawbuffer, IntBuffer value) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glClearNamedFramebuffer(int framebuffer, int buffer, int drawbuffer, FloatBuffer value) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glClearNamedFramebufferfi(int framebuffer, int buffer, float depth, int stencil) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glGetNamedFramebufferParameter(int framebuffer, int pname, IntBuffer params) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static int glGetNamedFramebufferParameter(int framebuffer, int pname) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glGetNamedFramebufferAttachmentParameter(int framebuffer, int attachment, int pname, IntBuffer params) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static int glGetNamedFramebufferAttachmentParameter(int framebuffer, int attachment, int pname) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glGetNamedRenderbufferParameter(int renderbuffer, int pname, IntBuffer params) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static int glGetNamedRenderbufferParameter(int renderbuffer, int pname) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glCompressedTextureSubImage3D(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int imageSize, ByteBuffer data) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glTextureParameter(int texture, int pname, FloatBuffer params) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glTextureParameterI(int texture, int pname, IntBuffer params) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glTextureParameterIu(int texture, int pname, IntBuffer params) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glTextureParameter(int texture, int pname, IntBuffer params) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glGetCompressedTextureImage(int texture, int level, IntBuffer pixels) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glGetCompressedTextureImage(int texture, int level, ShortBuffer pixels) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glGetTextureLevelParameter(int texture, int level, int pname, FloatBuffer params) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glGetTextureLevelParameter(int texture, int level, int pname, IntBuffer params) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glGetTextureParameter(int texture, int pname, FloatBuffer params) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glGetTextureParameterI(int texture, int pname, IntBuffer params) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glGetTextureParameterIu(int texture, int pname, IntBuffer params) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glGetTextureParameter(int texture, int pname, IntBuffer params) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glVertexArrayVertexBuffers(int vaobj, int first, int count, IntBuffer buffers, PointerBuffer offsets, IntBuffer strides) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glGetVertexArray(int vaobj, int pname, IntBuffer param) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static int glGetVertexArray(int vaobj, int pname) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glGetVertexArrayIndexed(int vaobj, int index, int pname, IntBuffer param) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static int glGetVertexArrayIndexed(int vaobj, int index, int pname) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public static void glGetVertexArrayIndexed64i(int vaobj, int index, int pname, LongBuffer param) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
}
