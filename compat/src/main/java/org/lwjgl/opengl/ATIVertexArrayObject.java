package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

public final class ATIVertexArrayObject {
	public static final int GL_STATIC_ATI = 0x8760;
	public static final int GL_DYNAMIC_ATI = 0x8761;
	public static final int GL_PRESERVE_ATI = 0x8762;
	public static final int GL_DISCARD_ATI = 0x8763;
	public static final int GL_OBJECT_BUFFER_SIZE_ATI = 0x8764;
	public static final int GL_OBJECT_BUFFER_USAGE_ATI = 0x8765;
	public static final int GL_ARRAY_OBJECT_BUFFER_ATI = 0x8766;
	public static final int GL_ARRAY_OBJECT_OFFSET_ATI = 0x8767;

	private ATIVertexArrayObject() {
	}

	public static int glNewObjectBufferATI(int pPointer_size, int usage) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static int glNewObjectBufferATI(ByteBuffer pPointer, int usage) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static int glNewObjectBufferATI(DoubleBuffer pPointer, int usage) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static int glNewObjectBufferATI(FloatBuffer pPointer, int usage) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static int glNewObjectBufferATI(IntBuffer pPointer, int usage) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static int glNewObjectBufferATI(ShortBuffer pPointer, int usage) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static boolean glIsObjectBufferATI(int buffer) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glUpdateObjectBufferATI(int buffer, int offset, ByteBuffer pPointer, int preserve) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glUpdateObjectBufferATI(int buffer, int offset, DoubleBuffer pPointer, int preserve) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glUpdateObjectBufferATI(int buffer, int offset, FloatBuffer pPointer, int preserve) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glUpdateObjectBufferATI(int buffer, int offset, IntBuffer pPointer, int preserve) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glUpdateObjectBufferATI(int buffer, int offset, ShortBuffer pPointer, int preserve) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glGetObjectBufferATI(int buffer, int pname, FloatBuffer params) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glGetObjectBufferATI(int buffer, int pname, IntBuffer params) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static int glGetObjectBufferiATI(int buffer, int pname) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glFreeObjectBufferATI(int buffer) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glArrayObjectATI(int array, int size, int type, int stride, int buffer, int offset) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glGetArrayObjectATI(int array, int pname, FloatBuffer params) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glGetArrayObjectATI(int array, int pname, IntBuffer params) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glVariantArrayObjectATI(int id, int type, int stride, int buffer, int offset) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glGetVariantArrayObjectATI(int id, int pname, FloatBuffer params) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glGetVariantArrayObjectATI(int id, int pname, IntBuffer params) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
}
