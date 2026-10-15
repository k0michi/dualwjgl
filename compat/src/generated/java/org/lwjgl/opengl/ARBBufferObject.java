package org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Generated;
import com.koyomiji.lwjgl2w3.inject.Todo;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

@Generated
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

	@Todo("gl")
	public ARBBufferObject() {
		throw new UnsupportedOperationException();
	}

	public static void glBindBufferARB(int target, int buffer) {
		org.lwjgl.opengl.ARBVertexBufferObject.glBindBufferARB(target, buffer);
	}

	public static void glDeleteBuffersARB(IntBuffer buffers) {
		org.lwjgl.opengl.ARBVertexBufferObject.glDeleteBuffersARB(buffers);
	}

	public static void glDeleteBuffersARB(int buffer) {
		org.lwjgl.opengl.ARBVertexBufferObject.glDeleteBuffersARB(buffer);
	}

	public static void glGenBuffersARB(IntBuffer buffers) {
		org.lwjgl.opengl.ARBVertexBufferObject.glGenBuffersARB(buffers);
	}

	public static int glGenBuffersARB() {
		return org.lwjgl.opengl.ARBVertexBufferObject.glGenBuffersARB();
	}

	public static boolean glIsBufferARB(int buffer) {
		return org.lwjgl.opengl.ARBVertexBufferObject.glIsBufferARB(buffer);
	}

	public static void glBufferDataARB(int target, long data_size, int usage) {
		org.lwjgl.opengl.ARBVertexBufferObject.glBufferDataARB(target, data_size, usage);
	}

	public static void glBufferDataARB(int target, ByteBuffer data, int usage) {
		org.lwjgl.opengl.ARBVertexBufferObject.glBufferDataARB(target, data, usage);
	}

	public static void glBufferDataARB(int target, DoubleBuffer data, int usage) {
		org.lwjgl.opengl.ARBVertexBufferObject.glBufferDataARB(target, data, usage);
	}

	public static void glBufferDataARB(int target, FloatBuffer data, int usage) {
		org.lwjgl.opengl.ARBVertexBufferObject.glBufferDataARB(target, data, usage);
	}

	public static void glBufferDataARB(int target, IntBuffer data, int usage) {
		org.lwjgl.opengl.ARBVertexBufferObject.glBufferDataARB(target, data, usage);
	}

	public static void glBufferDataARB(int target, ShortBuffer data, int usage) {
		org.lwjgl.opengl.ARBVertexBufferObject.glBufferDataARB(target, data, usage);
	}

	public static void glBufferSubDataARB(int target, long offset, ByteBuffer data) {
		org.lwjgl.opengl.ARBVertexBufferObject.glBufferSubDataARB(target, offset, data);
	}

	public static void glBufferSubDataARB(int target, long offset, DoubleBuffer data) {
		org.lwjgl.opengl.ARBVertexBufferObject.glBufferSubDataARB(target, offset, data);
	}

	public static void glBufferSubDataARB(int target, long offset, FloatBuffer data) {
		org.lwjgl.opengl.ARBVertexBufferObject.glBufferSubDataARB(target, offset, data);
	}

	public static void glBufferSubDataARB(int target, long offset, IntBuffer data) {
		org.lwjgl.opengl.ARBVertexBufferObject.glBufferSubDataARB(target, offset, data);
	}

	public static void glBufferSubDataARB(int target, long offset, ShortBuffer data) {
		org.lwjgl.opengl.ARBVertexBufferObject.glBufferSubDataARB(target, offset, data);
	}

	public static void glGetBufferSubDataARB(int target, long offset, ByteBuffer data) {
		org.lwjgl.opengl.ARBVertexBufferObject.glGetBufferSubDataARB(target, offset, data);
	}

	public static void glGetBufferSubDataARB(int target, long offset, DoubleBuffer data) {
		org.lwjgl.opengl.ARBVertexBufferObject.glGetBufferSubDataARB(target, offset, data);
	}

	public static void glGetBufferSubDataARB(int target, long offset, FloatBuffer data) {
		org.lwjgl.opengl.ARBVertexBufferObject.glGetBufferSubDataARB(target, offset, data);
	}

	public static void glGetBufferSubDataARB(int target, long offset, IntBuffer data) {
		org.lwjgl.opengl.ARBVertexBufferObject.glGetBufferSubDataARB(target, offset, data);
	}

	public static void glGetBufferSubDataARB(int target, long offset, ShortBuffer data) {
		org.lwjgl.opengl.ARBVertexBufferObject.glGetBufferSubDataARB(target, offset, data);
	}

	@Todo("gl")
	public static ByteBuffer glMapBufferARB(int target, int access, ByteBuffer old_buffer) {
		throw new UnsupportedOperationException();
	}

	@Todo("gl")
	public static ByteBuffer glMapBufferARB(int target, int access, long length, ByteBuffer old_buffer) {
		throw new UnsupportedOperationException();
	}

	public static boolean glUnmapBufferARB(int target) {
		return org.lwjgl.opengl.ARBVertexBufferObject.glUnmapBufferARB(target);
	}

	public static void glGetBufferParameterARB(int target, int pname, IntBuffer params) {
		org.lwjgl.opengl.ARBVertexBufferObject.nglGetBufferParameterivARB(target, pname, org.lwjgl.system.MemoryUtil.memAddressSafe(params));
	}

	@Deprecated
	@Todo("gl")
	public static int glGetBufferParameterARB(int target, int pname) {
		throw new UnsupportedOperationException();
	}

	public static int glGetBufferParameteriARB(int target, int pname) {
		return org.lwjgl.opengl.ARBVertexBufferObject.glGetBufferParameteriARB(target, pname);
	}

	@Todo("gl")
	public static ByteBuffer glGetBufferPointerARB(int target, int pname) {
		throw new UnsupportedOperationException();
	}
}
