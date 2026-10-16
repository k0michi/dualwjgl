package com.koyomiji.lwjgl2w3.verify;

import org.junit.jupiter.api.Test;
import org.lwjgl.BufferChecks;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.MemoryUtil;
import org.lwjgl.PointerBuffer;
import org.lwjgl.PointerWrapper;

import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.nio.ReadOnlyBufferException;

import static org.junit.jupiter.api.Assertions.*;

/** core as LWJGL 2 binaries use it: PointerBuffer's LWJGL 2 members, MemoryUtil, BufferChecks, LWJGLUtil. */
class Lwjgl2PointerBufferTest {

	private static final int SIZE = PointerBuffer.getPointerSize();

	@Test
	void pointerSize() {
		assertEquals(PointerBuffer.is64Bit() ? 8 : 4, SIZE);
	}

	@Test
	void chainedCallsReturnPointerBuffer() {
		PointerBuffer p = new PointerBuffer(4);
		// compiled against LWJGL 2, these call the PointerBuffer-returning methods
		PointerBuffer q = p.position(1).limit(3).mark();
		assertSame(p, q);
		assertEquals(1, p.position());
		assertEquals(SIZE, p.positionByte());
		assertEquals(2 * SIZE, p.remainingByte());
		p.position(2).reset();
		assertEquals(1, p.position());
		assertSame(p, p.clear().flip().rewind());
	}

	@Test
	void sliceDuplicateCompactPut() {
		PointerBuffer p = new PointerBuffer(4);
		p.put(0, 10L).put(1, 11L).put(2, 12L).put(3, 13L);
		p.position(1);
		PointerBuffer s = p.slice();
		assertEquals(3, s.capacity());
		assertEquals(11L, s.get(0));
		PointerBuffer d = p.duplicate();
		assertEquals(1, d.position());

		PointerBuffer dst = new PointerBuffer(4);
		dst.put(s);
		assertEquals(3, dst.position());
		assertEquals(13L, dst.get(2));

		p.position(2);
		p.compact();
		assertEquals(12L, p.get(0));
	}

	@Test
	void putPointerBufferAdvancesBoth() {
		PointerBuffer src = new PointerBuffer(4);
		src.put(0, 1L).put(1, 2L).put(2, 3L).put(3, 4L);
		src.position(1).limit(3);
		PointerBuffer dst = new PointerBuffer(4);
		dst.position(1);

		assertSame(dst, dst.put(src));
		// An LWJGL 2 binary calls LWJGL 2's put (hidden overload), which advances the source as LWJGL 2 and NIO do.
		// Source compiled against the patched jars only sees LWJGL 3's put, which has the same signature and wins.
		boolean binary = "original".equals(System.getProperty("lwjgl2w3.compiledAgainst"));
		assertEquals(binary ? 3 : 1, src.position());
		assertEquals(3, dst.position());
		assertEquals(2L, dst.get(1));
		assertEquals(3L, dst.get(2));

		// nothing moves when it does not fit, or the source is the buffer itself
		PointerBuffer big = new PointerBuffer(3);
		PointerBuffer small = new PointerBuffer(2);
		assertThrows(BufferOverflowException.class, () -> small.put(big));
		assertEquals(0, big.position());
		assertEquals(0, small.position());
		assertThrows(IllegalArgumentException.class, () -> small.put(small));

		// a read-only source can be read
		PointerBuffer ro = new PointerBuffer(2).asReadOnlyBuffer();
		new PointerBuffer(2).put(ro);
		assertEquals(binary ? 2 : 0, ro.position());
	}

	@Test
	void getBufferIsTheSameViewOfTheWholeMemory() {
		ByteBuffer source = BufferUtils.createByteBuffer(4 * SIZE);
		PointerBuffer p = new PointerBuffer(source);
		p.position(2);
		ByteBuffer b = p.getBuffer();
		assertSame(b, p.getBuffer());
		assertEquals(4 * SIZE, b.capacity());
		assertEquals(0, b.position());
		assertEquals(ByteOrder.nativeOrder(), b.order());
		assertEquals(ByteOrder.nativeOrder(), p.order());
		assertEquals(MemoryUtil.getAddress0(source), MemoryUtil.getAddress0(b));
		p.put(1, 77L);
		assertEquals(77L, SIZE == 8 ? b.getLong(SIZE) : b.getInt(SIZE));
	}

	@Test
	void getBufferOfASliceStartsAtTheSlice() {
		PointerBuffer p = new PointerBuffer(4);
		p.position(1);
		PointerBuffer s = p.slice();
		assertEquals(MemoryUtil.getAddress0(p.getBuffer()) + SIZE, MemoryUtil.getAddress0(s.getBuffer()));
		assertEquals(3 * SIZE, s.getBuffer().capacity());
	}

	@Test
	void readOnly() {
		PointerBuffer p = new PointerBuffer(4);
		p.put(0, 5L);
		p.position(1);
		assertFalse(p.isReadOnly());

		PointerBuffer r = p.asReadOnlyBuffer();
		assertTrue(r.isReadOnly());
		assertEquals(1, r.position());
		assertEquals(5L, r.get(0));
		assertThrows(ReadOnlyBufferException.class, () -> r.put(1L));
		assertThrows(ReadOnlyBufferException.class, () -> r.put(0, 1L));
		assertThrows(ReadOnlyBufferException.class, () -> r.put(new PointerBuffer(1)));
		assertThrows(ReadOnlyBufferException.class, () -> r.put(wrapper(1L)));
		assertThrows(ReadOnlyBufferException.class, r::compact);
		assertTrue(r.slice().isReadOnly());
		assertTrue(r.duplicate().isReadOnly());
		assertTrue(r.getBuffer().isReadOnly());

		// the writable buffer's changes show through
		p.put(0, 6L);
		assertEquals(6L, r.get(0));
	}

	@Test
	void putPointerWrapper() {
		PointerBuffer p = new PointerBuffer(2);
		p.put(wrapper(123L)).put(1, wrapper(456L));
		assertEquals(123L, p.get(0));
		assertEquals(456L, p.get(1));
	}

	@Test
	void memoryUtilAddresses() {
		IntBuffer i = BufferUtils.createIntBuffer(8);
		i.position(3);
		assertEquals(MemoryUtil.getAddress0(i) + 12, MemoryUtil.getAddress(i));
		assertEquals(MemoryUtil.getAddress0(i) + 20, MemoryUtil.getAddress(i, 5));
		assertEquals(0L, MemoryUtil.getAddressSafe((IntBuffer)null));

		PointerBuffer p = new PointerBuffer(4);
		p.position(1);
		assertEquals(MemoryUtil.getAddress0(p) + SIZE, MemoryUtil.getAddress(p));
	}

	@Test
	void memoryUtilText() {
		ByteBuffer ascii = MemoryUtil.encodeASCII("abc");
		assertEquals(4, ascii.remaining()); // null-terminated
		ascii.limit(3);
		assertEquals("abc", MemoryUtil.decodeASCII(ascii));
		ByteBuffer utf8 = MemoryUtil.encodeUTF8("\u3042");
		assertEquals(4, utf8.remaining());
		utf8.limit(3);
		assertEquals("\u3042", MemoryUtil.decodeUTF8(utf8));
	}

	@Test
	void checksAndUtil() {
		assertTrue(LWJGLUtil.CHECKS);
		assertFalse(LWJGLUtil.DEBUG);
		assertTrue(LWJGLUtil.getPlatform() >= 1 && LWJGLUtil.getPlatform() <= 3);
		assertThrows(IllegalArgumentException.class, () -> BufferChecks.checkBuffer(BufferUtils.createIntBuffer(1), 2));
		assertThrows(IllegalArgumentException.class, () -> BufferChecks.checkDirect(IntBuffer.allocate(1)));
		BufferChecks.checkBuffer(new PointerBuffer(2), 2);
		assertThrows(IllegalArgumentException.class, () -> BufferChecks.checkBuffer(new PointerBuffer(1), 2));
	}

	private static PointerWrapper wrapper(long pointer) {
		return () -> pointer;
	}

}
