package com.koyomiji.lwjgl2w3.inject.org.lwjgl;

import com.koyomiji.lwjgl2w3.inject.Widen;

import java.nio.*;

/** LWJGL 2 members of {@code org.lwjgl.BufferUtils}. */
public final class BufferUtils {

	/** LWJGL 2's implicit public constructor; LWJGL 3's is private. */
	@Widen
	public BufferUtils() {
	}

	/** log2 of the element size of {@code buffer}, in bytes. */
	public static int getElementSizeExponent(Buffer buffer) {
		if (buffer instanceof ByteBuffer) {
			return 0;
		} else if (buffer instanceof ShortBuffer || buffer instanceof CharBuffer) {
			return 1;
		} else if (buffer instanceof FloatBuffer || buffer instanceof IntBuffer) {
			return 2;
		} else if (buffer instanceof LongBuffer || buffer instanceof DoubleBuffer) {
			return 3;
		} else {
			throw new IllegalStateException("Unsupported buffer type: " + buffer);
		}
	}

	/** The position of {@code buffer}, in bytes. */
	public static int getOffset(Buffer buffer) {
		return buffer.position() << getElementSizeExponent(buffer);
	}

}
