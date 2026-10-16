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

	/** LWJGL 2's PointerBuffer members (synthetic overloads, a field, a read-only subclass) leave LWJGL 3's alone. */
	@Test
	void pointerBufferStillLwjgl3() {
		PointerBuffer p = PointerBuffer.allocateDirect(4);
		p.put(1L).put(2L);
		PointerBuffer s = p.flip().slice();
		assertEquals(2, s.remaining());
		assertEquals(2L, s.get(1));
		assertEquals(p, p.duplicate());

		// LWJGL 3's put(PointerBuffer) leaves the source where it is; LWJGL 2's (a hidden overload) advances it
		PointerBuffer src = PointerBuffer.allocateDirect(2);
		PointerBuffer dst = PointerBuffer.allocateDirect(2);
		dst.put(src);
		assertEquals(0, src.position());
		assertEquals(2, dst.position());
		try (MemoryStack stack = MemoryStack.stackPush()) {
			PointerBuffer q = stack.mallocPointer(2);
			q.put(0, 9L).position(1);
			assertEquals(9L, q.get(0));
			assertEquals(1, q.remaining());
		}
	}

	@Test
	void version() {
		assertTrue(Version.getVersion().startsWith("3.4.3"), Version.getVersion());
	}

}
