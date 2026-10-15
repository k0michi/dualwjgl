package org.lwjgl;

import org.lwjgl.system.Pointer;

public final class Sys {

	private static final String VERSION = "2.9.3";

	private Sys() {
	}

	/** LWJGL 2 loaded its native library here. LWJGL 3 loads its natives on first use, so there is nothing to do. */
	public static void initialize() {
	}

	public static String getVersion() {
		return VERSION;
	}

	public static long getTimerResolution() {
		return 1000L;
	}

	/** Monotonic time in milliseconds. */
	public static long getTime() {
		return (System.nanoTime() / 1_000_000L) & Long.MAX_VALUE;
	}

	public static boolean is64Bit() {
		return Pointer.BITS64;
	}

	// TODO(sdl): SDL_ShowSimpleMessageBox
	public static void alert(String title, String message) {
		System.err.println("[LWJGL] " + title + ": " + message);
	}

	// TODO(sdl): SDL_OpenURL. LWJGL 2 returns false when the URL could not be opened.
	public static boolean openURL(String url) {
		return false;
	}

	// TODO(sdl): SDL_GetClipboardText. LWJGL 2 returns null when the clipboard is unavailable.
	public static String getClipboard() {
		return null;
	}

}
