package org.lwjgl.input;

import com.koyomiji.lwjgl2w3.inject.Generated;
import com.koyomiji.lwjgl2w3.inject.Todo;
import java.nio.IntBuffer;
import org.lwjgl.LWJGLException;

@Generated
public class Cursor {
	public static final int CURSOR_ONE_BIT_TRANSPARENCY = 1;
	public static final int CURSOR_8_BIT_ALPHA = 2;
	public static final int CURSOR_ANIMATION = 4;

	@Todo("sdl")
	public Cursor(int width, int height, int xHotspot, int yHotspot, int numImages, IntBuffer images, IntBuffer delays) throws LWJGLException {
		throw new UnsupportedOperationException();
	}

	@Todo("sdl")
	public static int getMinCursorSize() {
		throw new UnsupportedOperationException();
	}

	@Todo("sdl")
	public static int getMaxCursorSize() {
		throw new UnsupportedOperationException();
	}

	@Todo("sdl")
	public static int getCapabilities() {
		throw new UnsupportedOperationException();
	}

	@Todo("sdl")
	public void destroy() {
		throw new UnsupportedOperationException();
	}

	@Todo("sdl")
	protected void setTimeout() {
		throw new UnsupportedOperationException();
	}

	@Todo("sdl")
	protected boolean hasTimedOut() {
		throw new UnsupportedOperationException();
	}

	@Todo("sdl")
	protected void nextCursor() {
		throw new UnsupportedOperationException();
	}
}
