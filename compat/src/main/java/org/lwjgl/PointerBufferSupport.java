package org.lwjgl;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.Buffer;
import java.nio.ByteBuffer;

import static java.lang.invoke.MethodType.methodType;

/**
 * What PointerBufferFragment's merged members need but cannot declare (static finals) or compile (LWJGL 2's constructor,
 * which LWJGL 3's PointerBuffer only has once merged).
 */
final class PointerBufferSupport {

	/**
	 * (Buffer) int and (Buffer, int) void: a java.nio.Buffer's mark, which Buffer has no accessors for, so that
	 * PointerBuffer can keep LWJGL 2's NIO view and its own mark in sync. Through sun.misc.Unsafe, as LWJGL 3 reads
	 * Buffer.address; absent, both are null and PointerBuffer falls back to NIO's mark().
	 */
	static final MethodHandle GET_MARK;
	static final MethodHandle PUT_MARK;

	/** (ByteBuffer) PointerBuffer: LWJGL 2's {@code new PointerBuffer(ByteBuffer)}, the default newInstance. */
	static final MethodHandle NEW;

	static {
		MethodHandle get = null;
		MethodHandle put = null;
		try {
			Class<?> unsafeClass = Class.forName("sun.misc.Unsafe");
			Field theUnsafe = unsafeClass.getDeclaredField("theUnsafe");
			theUnsafe.setAccessible(true);
			Object unsafe = theUnsafe.get(null);
			Method objectFieldOffset = unsafeClass.getMethod("objectFieldOffset", Field.class);
			long offset = (Long)objectFieldOffset.invoke(unsafe, Buffer.class.getDeclaredField("mark"));
			MethodHandles.Lookup lookup = MethodHandles.publicLookup();
			get = MethodHandles.insertArguments(
				lookup.findVirtual(unsafeClass, "getInt", methodType(int.class, Object.class, long.class)).bindTo(unsafe), 1, offset)
				.asType(methodType(int.class, Buffer.class));
			put = MethodHandles.insertArguments(
				lookup.findVirtual(unsafeClass, "putInt", methodType(void.class, Object.class, long.class, int.class)).bindTo(unsafe), 1, offset)
				.asType(methodType(void.class, Buffer.class, int.class));
		} catch (Throwable e) {
			get = null;
			put = null;
		}
		GET_MARK = get;
		PUT_MARK = put;
		try {
			NEW = MethodHandles.publicLookup().findConstructor(PointerBuffer.class, methodType(void.class, ByteBuffer.class));
		} catch (ReflectiveOperationException e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	private PointerBufferSupport() {
	}

}
