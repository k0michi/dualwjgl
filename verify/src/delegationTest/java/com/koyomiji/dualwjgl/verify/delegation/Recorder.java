package com.koyomiji.dualwjgl.verify.delegation;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Receives the native calls of both sides. Loaded by the test's own class loader, so the rewritten LWJGL classes of
 * either side reach the same instance.
 */
@SuppressWarnings("deprecation") // sun.misc.Unsafe reads native memory
public final class Recorder {

	/**
	 * One native call: the rewritten method ({@code owner.name}), its arguments, boxed, and for each argument that
	 * {@link #peekable} says points into memory, the int stored there during the call (temporary memory is gone after).
	 */
	public record Call(String method, Object[] args, Integer[] peeked) {
	}

	/** Which long arguments are addresses worth reading; set by the test, which knows its fake function addresses. */
	public static java.util.function.LongPredicate peekable = v -> false;

	private static final Unsafe UNSAFE;

	static {
		try {
			Field f = Unsafe.class.getDeclaredField("theUnsafe");
			f.setAccessible(true);
			UNSAFE = (Unsafe)f.get(null);
		} catch (ReflectiveOperationException e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	public static final List<Call> calls = new ArrayList<>();

	/** What the rewritten capability accessors return (LWJGL 2 GLContext; LWJGL 3 GL, AL, ALC). */
	public static Object lwjgl2GL;
	public static Object lwjgl3GL;
	public static Object lwjgl3AL;
	public static Object lwjgl3ALC;
	public static Object lwjgl3CL;

	/** LWJGL 2's CL function addresses (CLCapabilities' static fields, from CL.getFunctionAddress) -> names. */
	public static final java.util.Map<Long, String> lwjgl2CLFunctions = new java.util.HashMap<>();

	/** What LWJGL 2's CL.getFunctionAddress(String) returns: a distinct fake address per function. */
	public static long clFunction(String name) {
		for (java.util.Map.Entry<Long, String> e : lwjgl2CLFunctions.entrySet()) {
			if (e.getValue().equals(name)) {
				return e.getKey();
			}
		}
		long fn = 0x7E00_0010_0000L + lwjgl2CLFunctions.size() + 1;
		lwjgl2CLFunctions.put(fn, name);
		return fn;
	}

	private Recorder() {
	}

	/** Called by every rewritten native method. */
	public static void record(String method, Object[] args) {
		Integer[] peeked = new Integer[args.length];
		for (int i = 0; i < args.length; i++) {
			if (args[i] instanceof Long v && peekable.test(v)) {
				peeked[i] = UNSAFE.getInt(v);
			}
		}
		calls.add(new Call(method, args, peeked));
	}

}
