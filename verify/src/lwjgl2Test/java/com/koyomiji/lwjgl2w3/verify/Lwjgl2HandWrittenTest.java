package com.koyomiji.lwjgl2w3.verify;

import org.junit.jupiter.api.Test;
import org.lwjgl.BufferUtils;
import org.lwjgl.PointerBuffer;
import org.lwjgl.Sys;

import java.nio.ByteBuffer;

import static org.junit.jupiter.api.Assertions.*;

class Lwjgl2HandWrittenTest {

	@Test
	void pointerBufferConstructors() {
		PointerBuffer pb = new PointerBuffer(3);
		assertEquals(3, pb.capacity());
		pb.put(0, 42L);
		assertEquals(42L, pb.get(0));

		ByteBuffer source = BufferUtils.createByteBuffer(2 * (Sys.is64Bit() ? 8 : 4));
		PointerBuffer view = new PointerBuffer(source);
		assertEquals(2, view.capacity());
		view.put(1, 7L);
		assertEquals(7L, new PointerBuffer(source).get(1));

		assertThrows(IllegalArgumentException.class, () -> new PointerBuffer(ByteBuffer.allocate(16)));
	}

}
