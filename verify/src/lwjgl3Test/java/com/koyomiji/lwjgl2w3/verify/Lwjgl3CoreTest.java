package com.koyomiji.lwjgl2w3.verify;

import org.junit.jupiter.api.Test;
import org.lwjgl.BufferUtils;
import org.lwjgl.PointerBuffer;
import org.lwjgl.Version;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;

import static org.junit.jupiter.api.Assertions.*;

/** LWJGL 3 code: compiled against LWJGL 3.4.3 and against the patched jars, run against the patched jars. */
class Lwjgl3CoreTest {

	@Test
	void bufferUtils() {
		ByteBuffer b = BufferUtils.createByteBuffer(16);
		assertEquals(16, b.capacity());
		assertEquals(ByteOrder.nativeOrder(), b.order());

		PointerBuffer p = BufferUtils.createPointerBuffer(2);
		p.put(0, 42L);
		assertEquals(42L, p.get(0));
	}

	@Test
	void nativesStillLoad() {
		ByteBuffer m = MemoryUtil.memAlloc(32);
		try {
			m.putInt(0, 5);
			assertEquals(5, m.getInt(0));
		} finally {
			MemoryUtil.memFree(m);
		}
		try (MemoryStack stack = MemoryStack.stackPush()) {
			IntBuffer i = stack.ints(1, 2, 3);
			assertEquals(3, i.remaining());
		}
	}

	@Test
	void version() {
		assertTrue(Version.getVersion().startsWith("3.4.3"), Version.getVersion());
	}

}
