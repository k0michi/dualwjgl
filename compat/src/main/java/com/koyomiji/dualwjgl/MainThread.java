package com.koyomiji.dualwjgl;

import org.lwjgl.sdl.SDL_MainThreadCallback;
import org.lwjgl.system.JNI;
import org.lwjgl.system.Library;
import org.lwjgl.system.SharedLibrary;

/**
 * SDL's calls on the process's main thread. On macOS, SDL's video (windows, events, cursors, the clipboard, message
 * boxes) must run on the main thread; under {@link Launcher}, the program runs on another thread, so these calls are
 * handed to the main thread (libdispatch's main queue, which the main thread's run loop serves) and waited for. GL
 * context calls (create, make current, swap, destroy) are not: a context is current on the program's thread.
 *
 * <p>Without the launcher (or off macOS) the calls run where they are made, as before: on macOS the program must then
 * run on the main thread itself (-XstartOnFirstThread). Code run here must not wait for the program's thread, nor take
 * a lock the program's thread may hold while it waits: run only SDL's calls.</p>
 */
public final class MainThread {

	/** The main thread when the launcher runs the program on another thread; null when calls run where they are made. */
	private static volatile Thread main;

	private static SharedLibrary libSystem;
	private static long dispatch_sync_f;
	private static long mainQueue;
	private static SDL_MainThreadCallback trampoline;

	/** The task the main thread runs next, and its outcome: calls are handed over one at a time. */
	private static Task<?> task;
	private static Object result;
	private static Throwable failure;

	private MainThread() {
	}

	/** A call to run on the main thread. */
	public interface Task<T> {
		T run();
	}

	/** Called by the launcher on the main thread, before it starts the program's thread. */
	static synchronized void bridge(Thread mainThread) {
		libSystem = Library.loadNative(MainThread.class, "org.lwjgl", "/usr/lib/libSystem.B.dylib");
		dispatch_sync_f = libSystem.getFunctionAddress("dispatch_sync_f");
		mainQueue = libSystem.getFunctionAddress("_dispatch_main_q"); // what dispatch_get_main_queue() returns
		if (dispatch_sync_f == 0L || mainQueue == 0L) {
			throw new IllegalStateException("libdispatch's main queue is not available");
		}
		trampoline = SDL_MainThreadCallback.create(userdata -> {
			try {
				result = task.run();
			} catch (Throwable e) {
				failure = e;
			}
		});
		main = mainThread;
	}

	/** Whether SDL's calls are handed to the main thread, rather than run where they are made. */
	public static boolean isBridged() {
		return main != null;
	}

	/** Runs {@code call} on the main thread and returns its result; its exception is thrown here. */
	@SuppressWarnings("unchecked")
	public static <T> T call(Task<T> call) {
		Thread mainThread = main;
		if (mainThread == null || Thread.currentThread() == mainThread) {
			return call.run();
		}
		synchronized (MainThread.class) {
			task = call;
			result = null;
			failure = null;
			try {
				JNI.invokePPPV(mainQueue, 0L, trampoline.address(), dispatch_sync_f);
				if (failure instanceof RuntimeException) {
					throw (RuntimeException)failure;
				}
				if (failure instanceof Error) {
					throw (Error)failure;
				}
				if (failure != null) {
					throw new RuntimeException(failure);
				}
				return (T)result;
			} finally {
				task = null;
				result = null;
				failure = null;
			}
		}
	}

	public static void run(final Runnable call) {
		call(new Task<Void>() {
			@Override
			public Void run() {
				call.run();
				return null;
			}
		});
	}

}
