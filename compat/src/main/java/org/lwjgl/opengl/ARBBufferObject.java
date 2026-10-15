package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

public class ARBBufferObject {
	public static final int GL_STREAM_DRAW_ARB = 0x88E0;
	public static final int GL_STREAM_READ_ARB = 0x88E1;
	public static final int GL_STREAM_COPY_ARB = 0x88E2;
	public static final int GL_STATIC_DRAW_ARB = 0x88E4;
	public static final int GL_STATIC_READ_ARB = 0x88E5;
	public static final int GL_STATIC_COPY_ARB = 0x88E6;
	public static final int GL_DYNAMIC_DRAW_ARB = 0x88E8;
	public static final int GL_DYNAMIC_READ_ARB = 0x88E9;
	public static final int GL_DYNAMIC_COPY_ARB = 0x88EA;
	public static final int GL_READ_ONLY_ARB = 0x88B8;
	public static final int GL_WRITE_ONLY_ARB = 0x88B9;
	public static final int GL_READ_WRITE_ARB = 0x88BA;
	public static final int GL_BUFFER_SIZE_ARB = 0x8764;
	public static final int GL_BUFFER_USAGE_ARB = 0x8765;
	public static final int GL_BUFFER_ACCESS_ARB = 0x88BB;
	public static final int GL_BUFFER_MAPPED_ARB = 0x88BC;
	public static final int GL_BUFFER_MAP_POINTER_ARB = 0x88BD;

	public ARBBufferObject() {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glBindBufferARB(int target, int buffer) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glDeleteBuffersARB(IntBuffer buffers) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glDeleteBuffersARB(int buffer) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glGenBuffersARB(IntBuffer buffers) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static int glGenBuffersARB() {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static boolean glIsBufferARB(int buffer) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glBufferDataARB(int target, long data_size, int usage) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glBufferDataARB(int target, ByteBuffer data, int usage) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glBufferDataARB(int target, DoubleBuffer data, int usage) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glBufferDataARB(int target, FloatBuffer data, int usage) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glBufferDataARB(int target, IntBuffer data, int usage) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glBufferDataARB(int target, ShortBuffer data, int usage) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glBufferSubDataARB(int target, long offset, ByteBuffer data) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glBufferSubDataARB(int target, long offset, DoubleBuffer data) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glBufferSubDataARB(int target, long offset, FloatBuffer data) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glBufferSubDataARB(int target, long offset, IntBuffer data) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glBufferSubDataARB(int target, long offset, ShortBuffer data) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glGetBufferSubDataARB(int target, long offset, ByteBuffer data) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glGetBufferSubDataARB(int target, long offset, DoubleBuffer data) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glGetBufferSubDataARB(int target, long offset, FloatBuffer data) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glGetBufferSubDataARB(int target, long offset, IntBuffer data) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glGetBufferSubDataARB(int target, long offset, ShortBuffer data) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static ByteBuffer glMapBufferARB(int target, int access, ByteBuffer old_buffer) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static ByteBuffer glMapBufferARB(int target, int access, long length, ByteBuffer old_buffer) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static boolean glUnmapBufferARB(int target) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glGetBufferParameterARB(int target, int pname, IntBuffer params) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	@Deprecated
	public static int glGetBufferParameterARB(int target, int pname) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static int glGetBufferParameteriARB(int target, int pname) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static ByteBuffer glGetBufferPointerARB(int target, int pname) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
}
