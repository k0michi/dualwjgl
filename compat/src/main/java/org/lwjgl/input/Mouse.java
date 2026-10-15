package org.lwjgl.input;

import org.lwjgl.LWJGLException;

public class Mouse {
	public static final int EVENT_SIZE = 22;

	private Mouse() {
	}

	public static Cursor getNativeCursor() {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static Cursor setNativeCursor(Cursor cursor) throws LWJGLException {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static boolean isClipMouseCoordinatesToWindow() {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static void setClipMouseCoordinatesToWindow(boolean clip) {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static void setCursorPosition(int new_x, int new_y) {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static void create() throws LWJGLException {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static boolean isCreated() {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static void destroy() {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static void poll() {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static boolean isButtonDown(int button) {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static String getButtonName(int button) {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static int getButtonIndex(String buttonName) {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static boolean next() {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static int getEventButton() {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static boolean getEventButtonState() {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static int getEventDX() {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static int getEventDY() {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static int getEventX() {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static int getEventY() {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static int getEventDWheel() {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static long getEventNanoseconds() {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static int getX() {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static int getY() {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static int getDX() {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static int getDY() {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static int getDWheel() {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static int getButtonCount() {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static boolean hasWheel() {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static boolean isGrabbed() {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static void setGrabbed(boolean grab) {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static void updateCursor() {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static boolean isInsideWindow() {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}
}
