package com.koyomiji.dualwjgl;

import org.lwjgl.sdl.SDLError;
import org.lwjgl.system.JNI;
import org.lwjgl.system.Platform;
import org.lwjgl.system.macosx.ObjCRuntime;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

import static org.lwjgl.sdl.SDLHints.SDL_HINT_MAC_PRESS_AND_HOLD;
import static org.lwjgl.sdl.SDLHints.SDL_SetHint;
import static org.lwjgl.sdl.SDLInit.*;

/**
 * Runs a program with SDL owning the macOS main thread:
 * {@code java -XstartOnFirstThread -Dcom.koyomiji.dualwjgl.main=<main class> com.koyomiji.dualwjgl.Launcher <args...>}.
 * The main thread initializes SDL's video first, so that SDL creates the
 * application (NSApp) before anything else can (AWT, as soon as ImageIO or the toolkit loads), starts the program's
 * main on a thread named "main", and then runs the application ([NSApp run]): SDL handles every event there, and AWT,
 * which needs a running application, works beside it. SDL's calls from the program reach it through
 * {@link MainThread}.
 *
 * <p>-Xdock:name and -Xdock:icon, which AWT applied as it created the application, are applied by {@link Dock}.</p>
 *
 * <p>The main class may also be given as the first argument. Off macOS, or not on the main thread (no
 * -XstartOnFirstThread), the launcher only calls the program's main.</p>
 */
public final class Launcher {

	private Launcher() {
	}

	public static void main(String[] args) throws Throwable {
		String name = System.getProperty("com.koyomiji.dualwjgl.main");
		if (name == null) {
			if (args.length == 0) {
				System.err.println("Usage: java -Dcom.koyomiji.dualwjgl.main=<main class> " + Launcher.class.getName() + " <args...>");
				System.exit(1);
			}
			name = args[0];
			args = Arrays.copyOfRange(args, 1, args.length);
		}
		Method main = Class.forName(name, false, Launcher.class.getClassLoader()).getMethod("main", String[].class);
		if (!Modifier.isStatic(main.getModifiers())) {
			throw new NoSuchMethodException(name + ".main(String[]) is not static");
		}
		if (Platform.get() == Platform.MACOSX) {
			// as LWJGL 2: holding a key repeats it, rather than opening the accents menu; read as SDL creates NSApp
			SDL_SetHint(SDL_HINT_MAC_PRESS_AND_HOLD, "0");
		}
		if (Platform.get() == Platform.MACOSX && isMainThread()) {
			Dock.applyName(); // -Xdock:name, before SDL names its menus
		}
		if (Platform.get() != Platform.MACOSX || !isMainThread() || !SDL_InitSubSystem(SDL_INIT_VIDEO)) {
			if (Platform.get() == Platform.MACOSX && isMainThread()) {
				System.err.println("[DuaLWJGL] Could not initialize SDL video (" + SDLError.SDL_GetError() + "); running " + name + " here");
			}
			invoke(main, args);
			return;
		}
		Dock.applyIcon(); // -Xdock:icon, now that SDL created the application
		Thread mainThread = Thread.currentThread();
		MainThread.bridge(mainThread);
		final Method program = main;
		final String[] programArgs = args;
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				int status = 0;
				try {
					invoke(program, programArgs);
				} catch (Throwable e) {
					Thread self = Thread.currentThread();
					self.getUncaughtExceptionHandler().uncaughtException(self, e); // "Exception in thread "main" ..."
					status = 1;
				}
				exitAfterOtherThreads(mainThread, status);
			}
		}, "main");
		thread.setContextClassLoader(mainThread.getContextClassLoader());
		thread.start();

		long app = JNI.invokePPP(ObjCRuntime.objc_getClass("NSApplication"), ObjCRuntime.sel_getUid("sharedApplication"), objc_msgSend());
		JNI.invokePPV(app, ObjCRuntime.sel_getUid("run"), objc_msgSend()); // returns only if the application is stopped
		thread.join();
	}

	private static long objc_msgSend() {
		return ObjCRuntime.getLibrary().getFunctionAddress("objc_msgSend");
	}

	/** pthread_main_np: whether this is the process's first thread. */
	private static boolean isMainThread() {
		if (Platform.get() != Platform.MACOSX) {
			return false;
		}
		long pthread_main_np = org.lwjgl.system.Library.loadNative(Launcher.class, "org.lwjgl", "/usr/lib/libSystem.B.dylib")
			.getFunctionAddress("pthread_main_np");
		return JNI.invokeI(pthread_main_np) != 0;
	}

	private static void invoke(Method main, String[] args) throws Throwable {
		try {
			main.invoke(null, (Object)args);
		} catch (InvocationTargetException e) {
			throw e.getCause();
		}
	}

	/**
	 * What the java launcher does when main returns: wait for the other non-daemon threads, then exit. The main thread
	 * never returns from the application's run loop, so it does not count.
	 */
	private static void exitAfterOtherThreads(Thread mainThread, int status) {
		Thread self = Thread.currentThread();
		boolean waited;
		do {
			waited = false;
			for (Thread t : Thread.getAllStackTraces().keySet()) {
				if (t != self && t != mainThread && !t.isDaemon() && t.isAlive()) {
					try {
						t.join();
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					}
					waited = true;
				}
			}
		} while (waited);
		System.exit(status);
	}

}
