package org.lwjgl.input;

import java.nio.IntBuffer;
import org.lwjgl.LWJGLException;

public class Cursor {
	public static final int CURSOR_ONE_BIT_TRANSPARENCY = 1;
	public static final int CURSOR_8_BIT_ALPHA = 2;
	public static final int CURSOR_ANIMATION = 4;

	public Cursor(int width, int height, int xHotspot, int yHotspot, int numImages, IntBuffer images, IntBuffer delays) throws LWJGLException {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static int getMinCursorSize() {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static int getMaxCursorSize() {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static int getCapabilities() {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public void destroy() {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	protected void setTimeout() {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	protected boolean hasTimedOut() {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	protected void nextCursor() {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}
}
