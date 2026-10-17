package com.koyomiji.dualwjgl.verify;

import org.junit.jupiter.api.Test;
import org.lwjgl.BufferUtils;
import org.lwjgl.PointerBuffer;
import org.lwjgl.PointerWrapper;
import org.lwjgl.Sys;
import org.lwjgl.opencl.CLContextCallback;
import org.lwjgl.opencl.CLMemObjectDestructorCallback;

import java.lang.reflect.Method;
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

	@Test
	void contextCallbackOverridingHandleMessage() throws Exception {
		final String[] got = new String[1];
		CLContextCallback cb = new CLContextCallback() {
			@Override
			protected void handleMessage(String errinfo, ByteBuffer private_info) {
				got[0] = errinfo + ":" + private_info.remaining();
			}
		};
		PointerWrapper w = cb;
		assertTrue(cb.isValid());

		ByteBuffer errinfo = utf8("boom");
		ByteBuffer info = BufferUtils.createByteBuffer(3);
		upcall("invokePPPPV", address(errinfo), address(info), 3L, 0L, w.getPointer());
		assertEquals("boom:3", got[0]);
	}

	@Test
	void memObjectDestructorCallbackOverridingHandleMessage() throws Exception {
		final long[] got = new long[1];
		CLMemObjectDestructorCallback cb = new CLMemObjectDestructorCallback() {
			@Override
			protected void handleMessage(long memobj) {
				got[0] = memobj;
			}
		};
		upcall("invokePPV", 0x1234L, 0L, cb.getPointer());
		assertEquals(0x1234L, got[0]);
	}

	// LWJGL 2 has no API to call a function pointer, so play the OpenCL driver through LWJGL 3 reflectively.

	private static void upcall(String name, long... args) throws Exception {
		Class<?>[] types = new Class<?>[args.length];
		Object[] values = new Object[args.length];
		for (int i = 0; i < args.length; i++) {
			types[i] = long.class;
			values[i] = args[i];
		}
		Class.forName("org.lwjgl.system.JNI").getMethod(name, types).invoke(null, values);
	}

	private static long address(ByteBuffer buffer) throws Exception {
		Method m = Class.forName("org.lwjgl.system.MemoryUtil").getMethod("memAddress", ByteBuffer.class);
		return (Long)m.invoke(null, buffer);
	}

	private static ByteBuffer utf8(String s) {
		byte[] bytes = (s + "\0").getBytes(java.nio.charset.StandardCharsets.UTF_8);
		ByteBuffer b = BufferUtils.createByteBuffer(bytes.length);
		b.put(bytes).flip();
		return b;
	}

}
