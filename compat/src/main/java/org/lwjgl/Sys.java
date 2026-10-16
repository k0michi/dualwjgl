package org.lwjgl;

import org.lwjgl.input.Mouse;
import org.lwjgl.system.Pointer;

import static org.lwjgl.sdl.SDLClipboard.SDL_GetClipboardText;
import static org.lwjgl.sdl.SDLInit.*;
import static org.lwjgl.sdl.SDLMessageBox.SDL_MESSAGEBOX_INFORMATION;
import static org.lwjgl.sdl.SDLMessageBox.SDL_ShowSimpleMessageBox;
import static org.lwjgl.sdl.SDLMisc.SDL_OpenURL;

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

	/**
	 * A modal message box through SDL, without a parent window. Where SDL cannot show one (no video device, or on macOS
	 * off the first thread), the message goes to standard error, so that alert never fails.
	 */
	public static void alert(String title, String message) {
		// as LWJGL 2: a grabbed mouse is released while the box is shown
		boolean grabbed = Mouse.isGrabbed();
		if (grabbed) {
			Mouse.setGrabbed(false);
		}
		if (title == null) {
			title = "";
		}
		if (message == null) {
			message = "";
		}
		boolean shown;
		try {
			shown = SDL_ShowSimpleMessageBox(SDL_MESSAGEBOX_INFORMATION, title, message, 0L);
		} catch (LinkageError e) { // lwjgl-sdl or its natives missing
			shown = false;
		}
		if (!shown) {
			System.err.println("[LWJGL] " + title + ": " + message);
		}
		if (grabbed) {
			Mouse.setGrabbed(true);
		}
	}

	/** Opens the URL in the system's browser, through SDL; false if it could not. */
	public static boolean openURL(String url) {
		try {
			return SDL_OpenURL(url);
		} catch (LinkageError e) {
			return false;
		}
	}

	/** The clipboard's text, through SDL's video subsystem (initialized if needed); null when unavailable. */
	public static String getClipboard() {
		try {
			if (SDL_WasInit(SDL_INIT_VIDEO) == 0 && !SDL_InitSubSystem(SDL_INIT_VIDEO)) {
				return null;
			}
			return SDL_GetClipboardText();
		} catch (LinkageError e) {
			return null;
		}
	}

}
