package com.koyomiji.lwjgl2w3.inject.org.lwjgl;

import com.koyomiji.lwjgl2w3.inject.Into;
import org.lwjgl.BufferUtils;
import org.lwjgl.PointerBuffer;
import org.lwjgl.system.CustomBuffer;

import java.nio.ByteBuffer;

import static org.lwjgl.system.MemoryUtil.*;
import static org.lwjgl.system.Pointer.*;

/** LWJGL 2's public PointerBuffer constructors. Extends CustomBuffer, like PointerBuffer, so they can call super(...). */
@Into(PointerBuffer.class)
abstract class PointerBufferConstructors extends CustomBuffer<PointerBuffer> {

	public PointerBufferConstructors(int capacity) {
		this(BufferUtils.createByteBuffer(capacity * POINTER_SIZE));
	}

	public PointerBufferConstructors(ByteBuffer source) {
		super(memAddress(checkSource(source)), source, -1, 0, source.remaining() >> POINTER_SHIFT, source.remaining() >> POINTER_SHIFT);
	}

	private static ByteBuffer checkSource(ByteBuffer source) {
		if (!source.isDirect()) {
			throw new IllegalArgumentException("The source buffer is not direct.");
		}
		if ((memAddress(source) | source.remaining()) % POINTER_SIZE != 0) {
			throw new IllegalArgumentException("The source buffer is not aligned to " + POINTER_SIZE + " bytes.");
		}
		return source;
	}

}
