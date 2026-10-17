package org.lwjgl.opengl;

import com.koyomiji.dualwjgl.MainThread;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.sdl.SDL_CursorFrameInfo;
import org.lwjgl.sdl.SDL_Event;
import org.lwjgl.sdl.SDL_KeyboardEvent;
import org.lwjgl.sdl.SDL_MouseButtonEvent;
import org.lwjgl.sdl.SDL_MouseMotionEvent;
import org.lwjgl.sdl.SDL_MouseWheelEvent;
import org.lwjgl.sdl.SDL_Surface;
import org.lwjgl.sdl.SDL_TextInputEvent;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import static org.lwjgl.sdl.SDLError.SDL_GetError;
import static org.lwjgl.sdl.SDLEvents.*;
import static org.lwjgl.sdl.SDLKeyboard.SDL_StartTextInput;
import static org.lwjgl.sdl.SDLKeycode.SDL_KMOD_CTRL;
import static org.lwjgl.sdl.SDLKeyboard.SDL_StopTextInput;
import static org.lwjgl.sdl.SDLMouse.*;
import static org.lwjgl.sdl.SDLPixels.SDL_PIXELFORMAT_ABGR8888;
import static org.lwjgl.sdl.SDLPixels.SDL_PIXELFORMAT_ARGB8888;
import static org.lwjgl.sdl.SDLSurface.SDL_CreateSurfaceFrom;
import static org.lwjgl.sdl.SDLSurface.SDL_DestroySurface;
import static org.lwjgl.sdl.SDLSurface.SDL_DuplicateSurface;
import static org.lwjgl.system.MemoryUtil.memUTF8;

/**
 * The Display's input, what LWJGL 2's platform display classes implemented: LWJGL 2's Mouse and Keyboard (compiled
 * unchanged) read it, Display.processMessages() feeds it SDL's events. Coordinates are LWJGL 2's: window points, y up from
 * the bottom. Keys are LWJGL 2's key codes ({@link SDLKeys}); the characters come from SDL's text input.
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

	private final EventQueue keyEvents = new EventQueue(Keyboard.EVENT_SIZE);
	private final ByteBuffer keyEvent = ByteBuffer.allocate(Keyboard.EVENT_SIZE);
	private final boolean[] keys = new boolean[Keyboard.KEYBOARD_SIZE];
	private boolean keyboardCreated;
	/**
	 * The last key press, held back until SDL's text for it: SDL sends a press, then the text it typed, and LWJGL 2's
	 * press carries its character. -1 when there is none to complete.
	 */
	private int pendingKey = -1;
	private int pendingCharacter;
	private long pendingNanos;
	private boolean pendingRepeat;

	/** An SDL event, while Display.processMessages() empties SDL's queue. */
	void handle(SDL_Event e) {
		if (keyboardCreated) {
			handleKeyboard(e);
		}
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

	private void handleKeyboard(SDL_Event e) {
		int type = e.type();
		if (type == SDL_EVENT_KEY_DOWN || type == SDL_EVENT_KEY_UP) {
			SDL_KeyboardEvent k = e.key();
			int key = SDLKeys.key(k.scancode());
			if (key == Keyboard.KEY_NONE) {
				return;
			}
			flushKeyboard();
			keys[key] = k.down();
			if (k.down()) {
				pendingKey = key;
				// SDL's text input has no characters for Ctrl-letter: LWJGL 2 had its control character (Ctrl-V: 22),
				// which LWJGL 2 programs take for their shortcuts (text fields that paste on 22)
				int letter = k.key();
				pendingCharacter = (k.mod() & SDL_KMOD_CTRL) != 0 && letter >= 'a' && letter <= 'z' ? letter - 'a' + 1 : 0;
				pendingNanos = k.timestamp();
				pendingRepeat = k.repeat();
			} else {
				putKey(key, false, 0, k.timestamp(), false);
			}
		} else if (type == SDL_EVENT_TEXT_INPUT) {
			SDL_TextInputEvent t = e.text();
			String text = memUTF8(t.text());
			for (int i = 0; i < text.length(); i++) {
				char c = text.charAt(i);
				if (pendingKey >= 0 && pendingCharacter == 0) {
					pendingCharacter = c;
				} else {
					// more characters than presses (an input method, a dead key): LWJGL 2's character-only events
					flushKeyboard();
					putKey(Keyboard.KEY_NONE, true, c, t.timestamp(), false);
				}
			}
		}
	}

	/** Queues the held-back press, once SDL's queue is empty or another key event comes. */
	void flushKeyboard() {
		if (pendingKey >= 0) {
			int c = pendingCharacter != 0 ? pendingCharacter : SDLKeys.controlCharacter(pendingKey);
			putKey(pendingKey, true, c, pendingNanos, pendingRepeat);
			pendingKey = -1;
		}
	}

	private void putKey(int key, boolean state, int character, long nanos, boolean repeat) {
		keyEvent.clear();
		keyEvent.putInt(key).put((byte)(state ? 1 : 0)).putInt(character).putLong(nanos).put((byte)(repeat ? 1 : 0));
		keyEvent.flip();
		keyEvents.putEvent(keyEvent);
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
		inside = MainThread.call(() -> SDL_GetMouseFocus()) == Display.window();
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
		long window = Display.window();
		String error = MainThread.call(() -> SDL_SetWindowRelativeMouseMode(window, grab) ? null : SDL_GetError());
		if (error != null) {
			LWJGLUtil.log("Could not " + (grab ? "grab" : "release") + " the mouse: " + error);
			return;
		}
		grabbed = grab;
		dx = dy = 0;
		restX = restY = 0f;
	}

	/** With animation everywhere: SDL animates cursors natively (DEVIATION(cursor-native-animation)). */
	@Override
	public int getNativeCursorCapabilities() {
		return org.lwjgl.input.Cursor.CURSOR_ONE_BIT_TRANSPARENCY | org.lwjgl.input.Cursor.CURSOR_8_BIT_ALPHA
			| org.lwjgl.input.Cursor.CURSOR_ANIMATION;
	}

	@Override
	public void setCursorPosition(int x, int y) {
		long window = Display.window();
		float sdlY = Display.getHeight() - 1 - y;
		MainThread.run(() -> SDL_WarpMouseInWindow(window, x, sdlY));
		this.x = x;
		this.y = y;
	}

	@Override
	public void setNativeCursor(Object handle) throws LWJGLException {
		MainThread.run(() -> {
			long cursor = handle == null ? SDL_GetDefaultCursor() : (Long)handle;
			if (!SDL_SetCursor(cursor)) {
				throw new LWJGLException("Could not set the cursor: " + SDL_GetError());
			}
		});
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
	 * LWJGL 2's Cursor images, already flipped top-down with the hotspot from the top. One image is in the platform's
	 * format as LWJGL 2's Cursor prepares it (ABGR on macOS, ARGB elsewhere); an animation is ARGB on every platform,
	 * with the frames' delays in milliseconds, and becomes an SDL animated cursor.
	 */
	@Override
	public Object createCursor(int width, int height, int xHotspot, int yHotspot, int numImages, IntBuffer images, IntBuffer delays)
		throws LWJGLException {
		return MainThread.call(() -> createCursorOnMainThread(width, height, xHotspot, yHotspot, numImages, images, delays));
	}

	private static Object createCursorOnMainThread(int width, int height, int xHotspot, int yHotspot, int numImages, IntBuffer images,
		IntBuffer delays) {
		boolean animated = numImages > 1;
		int format = !animated && LWJGLUtil.getPlatform() == LWJGLUtil.PLATFORM_MACOSX ? SDL_PIXELFORMAT_ABGR8888 : SDL_PIXELFORMAT_ARGB8888;
		SDL_Surface[] surfaces = new SDL_Surface[numImages];
		try {
			for (int frame = 0; frame < numImages; frame++) {
				ByteBuffer pixels = BufferUtils.createByteBuffer(width * height * 4);
				IntBuffer argb = pixels.asIntBuffer();
				int start = images.position() + frame * width * height;
				for (int i = 0; i < width * height; i++) {
					argb.put(i, images.get(start + i));
				}
				// SDL_CreateSurfaceFrom keeps the pixels: the surface owns a copy so that they need not outlive this call
				SDL_Surface view = SDL_CreateSurfaceFrom(width, height, format, pixels, width * 4);
				if (view == null) {
					throw new LWJGLException("Could not create the cursor image: " + SDL_GetError());
				}
				surfaces[frame] = SDL_DuplicateSurface(view);
				SDL_DestroySurface(view);
				if (surfaces[frame] == null) {
					throw new LWJGLException("Could not create the cursor image: " + SDL_GetError());
				}
			}
			long cursor;
			if (animated) {
				SDL_CursorFrameInfo.Buffer frames = SDL_CursorFrameInfo.calloc(numImages);
				try {
					for (int frame = 0; frame < numImages; frame++) {
						frames.get(frame).surface(surfaces[frame]).duration(delays == null ? 0 : delays.get(delays.position() + frame));
					}
					cursor = SDL_CreateAnimatedCursor(frames, xHotspot, yHotspot);
				} finally {
					frames.free();
				}
			} else {
				cursor = SDL_CreateColorCursor(surfaces[0], xHotspot, yHotspot);
			}
			if (cursor == 0L) {
				throw new LWJGLException("Could not create the cursor: " + SDL_GetError());
			}
			return cursor;
		} finally {
			for (SDL_Surface surface : surfaces) {
				if (surface != null) {
					SDL_DestroySurface(surface);
				}
			}
		}
	}

	@Override
	public void destroyCursor(Object cursor_handle) {
		MainThread.run(() -> SDL_DestroyCursor((Long)cursor_handle));
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

	/** Starts SDL's text input on the window, which LWJGL 2's characters come from. */
	@Override
	public void createKeyboard() throws LWJGLException {
		long window = Display.window();
		String error = MainThread.call(() -> SDL_StartTextInput(window) ? null : SDL_GetError());
		if (error != null) {
			throw new LWJGLException("Could not start text input: " + error);
		}
		keyboardCreated = true;
		java.util.Arrays.fill(keys, false);
		pendingKey = -1;
		keyEvents.clearEvents();
	}

	@Override
	public void destroyKeyboard() {
		long window = Display.window();
		MainThread.run(() -> SDL_StopTextInput(window));
		keyboardCreated = false;
	}

	@Override
	public void pollKeyboard(ByteBuffer keyDownBuffer) {
		int position = keyDownBuffer.position();
		for (int i = 0; i < keys.length && i < keyDownBuffer.remaining(); i++) {
			keyDownBuffer.put(position + i, (byte)(keys[i] ? 1 : 0));
		}
	}

	@Override
	public void readKeyboard(ByteBuffer buffer) {
		keyEvents.copyEvents(buffer);
	}

}
