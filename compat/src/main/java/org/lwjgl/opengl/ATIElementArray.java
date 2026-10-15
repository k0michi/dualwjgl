package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

public final class ATIElementArray {
	public static final int GL_ELEMENT_ARRAY_ATI = 0x8768;
	public static final int GL_ELEMENT_ARRAY_TYPE_ATI = 0x8769;
	public static final int GL_ELEMENT_ARRAY_POINTER_ATI = 0x876A;

	private ATIElementArray() {
	}

	public static void glElementPointerATI(ByteBuffer pPointer) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glElementPointerATI(IntBuffer pPointer) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glElementPointerATI(ShortBuffer pPointer) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glDrawElementArrayATI(int mode, int count) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static void glDrawRangeElementArrayATI(int mode, int start, int end, int count) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
}
