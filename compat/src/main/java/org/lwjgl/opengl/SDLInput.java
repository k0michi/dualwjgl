package org.lwjgl.opengl;

import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.input.Mouse;
import org.lwjgl.sdl.SDL_Event;
import org.lwjgl.sdl.SDL_MouseButtonEvent;
import org.lwjgl.sdl.SDL_MouseMotionEvent;
import org.lwjgl.sdl.SDL_MouseWheelEvent;
import org.lwjgl.sdl.SDL_Surface;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import static org.lwjgl.sdl.SDLError.SDL_GetError;
import static org.lwjgl.sdl.SDLEvents.*;
import static org.lwjgl.sdl.SDLMouse.*;
import static org.lwjgl.sdl.SDLPixels.SDL_PIXELFORMAT_ABGR8888;
import static org.lwjgl.sdl.SDLPixels.SDL_PIXELFORMAT_ARGB8888;
import static org.lwjgl.sdl.SDLSurface.SDL_CreateSurfaceFrom;
import static org.lwjgl.sdl.SDLSurface.SDL_DestroySurface;

/**
 * The Display's input, what LWJGL 2's platform display classes implemented: LWJGL 2's Mouse (compiled unchanged) reads
 * it, Display.processMessages() feeds it SDL's events. Coordinates are LWJGL 2's: window points, y up from the bottom.
 */
final class SDLInput implements InputImplementation {

	private static final int BUTTONS = 5;

	private final EventQueue mouseEvents = new EventQueue(Mouse.EVENT_SIZE);
	private final ByteBuffer event = ByteBuffer.allocate(Mouse.EVENT_SIZE);
	private final boolean[] buttons = new boolean[BUTTONS];
	private boolean mouseCreated;
	private boolean grabbed;
	private boolean inside;
	/** absolute position, or the motion since the last poll while grabbed */
	private int x;
	private int y;
	private int dx;
	private int dy;
	private int dwheel;
	/** fractions of a pixel or of a wheel step that SDL reported and LWJGL 2's ints cannot hold yet */
	private float restX;
	private float restY;
	private float restWheel;

	/** An SDL event, while Display.processMessages() empties SDL's queue. */
	void handle(SDL_Event e) {
		if (!mouseCreated) {
			return;
		}
		int type = e.type();
		if (type == SDL_EVENT_MOUSE_MOTION) {
			SDL_MouseMotionEvent m = e.motion();
			if (grabbed) {
				int ex = steps(m.xrel(), 0);
				int ey = steps(-m.yrel(), 1);
				dx += ex;
				dy += ey;
				put(-1, false, ex, ey, 0, m.timestamp());
			} else {
				position(m.x(), m.y());
				put(-1, false, x, y, 0, m.timestamp());
			}
		} else if (type == SDL_EVENT_MOUSE_BUTTON_DOWN || type == SDL_EVENT_MOUSE_BUTTON_UP) {
			SDL_MouseButtonEvent b = e.button();
			int button = button(b.button());
			if (button < 0) {
				return;
			}
			buttons[button] = b.down();
			if (!grabbed) {
				position(b.x(), b.y());
			}
			put(button, b.down(), grabbed ? 0 : x, grabbed ? 0 : y, 0, b.timestamp());
		} else if (type == SDL_EVENT_MOUSE_WHEEL) {
			SDL_MouseWheelEvent w = e.wheel();
			// LWJGL 2: 120 per notch, positive away from the user
			float delta = (w.direction() == SDL_MOUSEWHEEL_FLIPPED ? -w.y() : w.y()) * 120f + restWheel;
			int step = (int)delta;
			restWheel = delta - step;
			if (step != 0) {
				dwheel += step;
				put(-1, false, grabbed ? 0 : x, grabbed ? 0 : y, step, w.timestamp());
			}
		} else if (type == SDL_EVENT_WINDOW_MOUSE_ENTER) {
			inside = true;
		} else if (type == SDL_EVENT_WINDOW_MOUSE_LEAVE) {
			inside = false;
		}
	}

	/** Whole pixels of a relative motion, keeping the fraction for the next one. */
	private int steps(float delta, int axis) {
		float total = delta + (axis == 0 ? restX : restY);
		int whole = (int)total;
		if (axis == 0) {
			restX = total - whole;
		} else {
			restY = total - whole;
		}
		return whole;
	}

	private void position(float windowX, float windowY) {
		x = (int)windowX;
		y = Display.getHeight() - 1 - (int)windowY;
	}

	/** LWJGL 2's order: left, right, middle, then the side buttons. */
	private static int button(byte sdl) {
		switch (sdl) {
			case SDL_BUTTON_LEFT:
				return 0;
			case SDL_BUTTON_RIGHT:
				return 1;
			case SDL_BUTTON_MIDDLE:
				return 2;
			case SDL_BUTTON_X1:
				return 3;
			case SDL_BUTTON_X2:
				return 4;
			default:
				return -1;
		}
	}

	private void put(int button, boolean state, int coord1, int coord2, int wheel, long nanos) {
		event.clear();
		event.put((byte)button).put((byte)(state ? 1 : 0)).putInt(coord1).putInt(coord2).putInt(wheel).putLong(nanos);
		event.flip();
		mouseEvents.putEvent(event);
	}

	// ---- mouse

	@Override
	public boolean hasWheel() {
		return true;
	}

	@Override
	public int getButtonCount() {
		return BUTTONS;
	}

	@Override
	public void createMouse() throws LWJGLException {
		mouseCreated = true;
		grabbed = false;
		inside = SDL_GetMouseFocus() == Display.window();
		dx = dy = dwheel = 0;
		restX = restY = restWheel = 0f;
		java.util.Arrays.fill(buttons, false);
		mouseEvents.clearEvents();
	}

	@Override
	public void destroyMouse() {
		if (grabbed) {
			grabMouse(false);
		}
		mouseCreated = false;
	}

	@Override
	public void pollMouse(IntBuffer coord_buffer, ByteBuffer buttons_buffer) {
		if (grabbed) {
			coord_buffer.put(0, dx);
			coord_buffer.put(1, dy);
			dx = dy = 0;
		} else {
			coord_buffer.put(0, x);
			coord_buffer.put(1, y);
		}
		coord_buffer.put(2, dwheel);
		dwheel = 0;
		for (int i = 0; i < buttons.length && i < buttons_buffer.remaining(); i++) {
			buttons_buffer.put(buttons_buffer.position() + i, (byte)(buttons[i] ? 1 : 0));
		}
	}

	@Override
	public void readMouse(ByteBuffer buffer) {
		mouseEvents.copyEvents(buffer);
	}

	@Override
	public void grabMouse(boolean grab) {
		if (!SDL_SetWindowRelativeMouseMode(Display.window(), grab)) {
			LWJGLUtil.log("Could not " + (grab ? "grab" : "release") + " the mouse: " + SDL_GetError());
			return;
		}
		grabbed = grab;
		dx = dy = 0;
		restX = restY = 0f;
	}

	@Override
	public int getNativeCursorCapabilities() {
		// animation is LWJGL 2's Cursor switching images on macOS and Windows; X11's animated cursors are not in SDL
		return org.lwjgl.input.Cursor.CURSOR_ONE_BIT_TRANSPARENCY | org.lwjgl.input.Cursor.CURSOR_8_BIT_ALPHA;
	}

	@Override
	public void setCursorPosition(int x, int y) {
		SDL_WarpMouseInWindow(Display.window(), x, Display.getHeight() - 1 - y);
		this.x = x;
		this.y = y;
	}

	@Override
	public void setNativeCursor(Object handle) throws LWJGLException {
		long cursor = handle == null ? SDL_GetDefaultCursor() : (Long)handle;
		if (!SDL_SetCursor(cursor)) {
			throw new LWJGLException("Could not set the cursor: " + SDL_GetError());
		}
	}

	@Override
	public int getMinCursorSize() {
		return 1;
	}

	@Override
	public int getMaxCursorSize() {
		return 256;
	}

	/**
	 * One image of LWJGL 2's Cursor, already flipped top-down with the hotspot from the top. Cursor converted it to
	 * ABGR on macOS and keeps ARGB elsewhere; an X11 animation (several images) shows its first image.
	 */
	@Override
	public Object createCursor(int width, int height, int xHotspot, int yHotspot, int numImages, IntBuffer images, IntBuffer delays)
		throws LWJGLException {
		// TODO(sdl): animated cursors on Linux, which LWJGL 2 hands over whole
		ByteBuffer pixels = BufferUtils.createByteBuffer(width * height * 4);
		IntBuffer argb = pixels.asIntBuffer();
		for (int i = 0; i < width * height; i++) {
			argb.put(i, images.get(images.position() + i));
		}
		int format = LWJGLUtil.getPlatform() == LWJGLUtil.PLATFORM_MACOSX ? SDL_PIXELFORMAT_ABGR8888 : SDL_PIXELFORMAT_ARGB8888;
		SDL_Surface surface = SDL_CreateSurfaceFrom(width, height, format, pixels, width * 4);
		if (surface == null) {
			throw new LWJGLException("Could not create the cursor image: " + SDL_GetError());
		}
		try {
			long cursor = SDL_CreateColorCursor(surface, xHotspot, yHotspot);
			if (cursor == 0L) {
				throw new LWJGLException("Could not create the cursor: " + SDL_GetError());
			}
			return cursor;
		} finally {
			SDL_DestroySurface(surface);
		}
	}

	@Override
	public void destroyCursor(Object cursor_handle) {
		SDL_DestroyCursor((Long)cursor_handle);
	}

	@Override
	public int getWidth() {
		return Display.getWidth();
	}

	@Override
	public int getHeight() {
		return Display.getHeight();
	}

	@Override
	public boolean isInsideWindow() {
		return inside;
	}

	// ---- keyboard

	@Override
	public void createKeyboard() throws LWJGLException {
		// TODO(sdl): Keyboard
		throw new LWJGLException("Keyboard is not supported yet");
	}

	@Override
	public void destroyKeyboard() {
	}

	@Override
	public void pollKeyboard(ByteBuffer keyDownBuffer) {
	}

	@Override
	public void readKeyboard(ByteBuffer buffer) {
	}

}
