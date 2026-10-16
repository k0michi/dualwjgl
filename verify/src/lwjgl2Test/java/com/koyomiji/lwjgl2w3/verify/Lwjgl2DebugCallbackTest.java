package com.koyomiji.lwjgl2w3.verify;

import org.junit.jupiter.api.Test;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.AMDDebugOutputCallback;
import org.lwjgl.opengl.ARBDebugOutputCallback;
import org.lwjgl.opengl.KHRDebugCallback;

import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

/**
 * LWJGL 2's debug output callbacks: each class's pointer is CallbackUtil's fixed function, which hands a message to
 * the Handler its userParam refers to. Plays the driver (no context here, and macOS has none of the extensions).
 */
class Lwjgl2DebugCallbackTest {

	@Test
	void khrDebug() throws Exception {
		final String[] got = new String[1];
		KHRDebugCallback callback = new KHRDebugCallback(new KHRDebugCallback.Handler() {
			@Override
			public void handleMessage(int source, int type, int id, int severity, String message) {
				got[0] = source + " " + type + " " + id + " " + severity + " " + message;
			}
		});
		long userParam = createGlobalRef(handler(callback));
		ByteBuffer message = utf8("hello");
		upcall("invokePPV", 0x8246, 0x824C, 7, 0x9146, 5, address(message), userParam, callback.getPointer());
		assertEquals(0x8246 + " " + 0x824C + " 7 " + 0x9146 + " hello", got[0]);

		got[0] = null;
		upcall("invokePPV", 0x8246, 0x824C, 7, 0x9146, 5, address(message), 12345L, callback.getPointer());
		assertNull(got[0], "an unknown userParam reaches no Handler");
	}

	@Test
	void arbDebugOutput() throws Exception {
		final String[] got = new String[1];
		ARBDebugOutputCallback callback = new ARBDebugOutputCallback(new ARBDebugOutputCallback.Handler() {
			@Override
			public void handleMessage(int source, int type, int id, int severity, String message) {
				got[0] = id + " " + message;
			}
		});
		long userParam = createGlobalRef(handler(callback));
		ByteBuffer message = utf8("arb");
		upcall("invokePPV", 0x8246, 0x824C, 3, 0x9146, 3, address(message), userParam, callback.getPointer());
		assertEquals("3 arb", got[0]);
	}

	@Test
	void amdDebugOutput() throws Exception {
		final String[] got = new String[1];
		AMDDebugOutputCallback callback = new AMDDebugOutputCallback(new AMDDebugOutputCallback.Handler() {
			@Override
			public void handleMessage(int id, int category, int severity, String message) {
				got[0] = id + " " + category + " " + severity + " " + message;
			}
		});
		long userParam = createGlobalRef(handler(callback));
		ByteBuffer message = utf8("amd");
		Class.forName("org.lwjgl.system.JNI").getMethod("invokePPV", int.class, int.class, int.class, int.class, long.class,
			long.class, long.class).invoke(null, 9, 0x9149, 0x9146, 3, address(message), userParam, callback.getPointer());
		assertEquals("9 " + 0x9149 + " " + 0x9146 + " amd", got[0]);
	}

	// CallbackUtil and getHandler() are package-private: what the glDebugMessageCallback* functions do, reflectively

	private static Object handler(Object callback) throws Exception {
		Method m = callback.getClass().getDeclaredMethod("getHandler");
		m.setAccessible(true);
		return m.invoke(callback);
	}

	private static long createGlobalRef(Object obj) throws Exception {
		Method m = Class.forName("org.lwjgl.opengl.CallbackUtil").getDeclaredMethod("createGlobalRef", Object.class);
		m.setAccessible(true);
		return (Long)m.invoke(null, obj);
	}

	private static void upcall(String name, int a, int b, int c, int d, int e, long f, long g, long function) throws Exception {
		Class.forName("org.lwjgl.system.JNI").getMethod(name, int.class, int.class, int.class, int.class, int.class, long.class,
			long.class, long.class).invoke(null, a, b, c, d, e, f, g, function);
	}

	private static long address(ByteBuffer buffer) throws Exception {
		Method m = Class.forName("org.lwjgl.system.MemoryUtil").getMethod("memAddress", ByteBuffer.class);
		return (Long)m.invoke(null, buffer);
	}

	private static ByteBuffer utf8(String s) {
		byte[] bytes = (s + "\0").getBytes(StandardCharsets.UTF_8);
		ByteBuffer b = BufferUtils.createByteBuffer(bytes.length);
		b.put(bytes).flip();
		return b;
	}

}
