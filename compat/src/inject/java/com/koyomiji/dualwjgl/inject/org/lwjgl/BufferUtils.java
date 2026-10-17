package com.koyomiji.dualwjgl.inject.org.lwjgl;

import com.koyomiji.dualwjgl.inject.Widen;

import java.nio.*;

public final class BufferUtils {

	/** LWJGL 2's implicit public constructor; LWJGL 3's is private. */
	@Widen
	public BufferUtils() {
	}

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

	public static int getOffset(Buffer buffer) {
		return buffer.position() << getElementSizeExponent(buffer);
	}

}
