package com.koyomiji.lwjgl2w3.verify.demo;

import org.lwjgl.BufferUtils;
import org.lwjgl.input.Cursor;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.opengl.GLContext;
import org.lwjgl.sdl.SDL_Event;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import static org.lwjgl.sdl.SDLEvents.*;
import static org.lwjgl.sdl.SDLMouse.*;
import static org.lwjgl.sdl.SDLScancode.*;
import static org.lwjgl.system.MemoryUtil.memFree;
import static org.lwjgl.system.MemoryUtil.memUTF8;

/**
 * Opens a Display and feeds SDL synthetic mouse and keyboard events, then checks what LWJGL 2's Mouse and Keyboard
 * report; then checks GLContext and ContextCapabilities against LWJGL 3's. Compiled against the
 * patched jars and LWJGL 3's SDL module (it pushes SDL events); needs a display, so it is not part of check.
 */
public final class DisplayInputCheck {

	static int failures;

	static void check(String what, boolean ok) {
		System.out.println((ok ? "  PASS  " : "  FAIL  ") + what);
		if (!ok) {
			failures++;
		}
	}

	static void push(SDL_Event e) {
		if (!SDL_PushEvent(e)) {
			throw new IllegalStateException("SDL_PushEvent failed");
		}
	}

	static void motion(float x, float y, float xrel, float yrel) {
		SDL_Event e = SDL_Event.calloc();
		e.motion().type(SDL_EVENT_MOUSE_MOTION).x(x).y(y).xrel(xrel).yrel(yrel);
		push(e);
		e.free();
	}

	static void button(int button, boolean down, float x, float y) {
		SDL_Event e = SDL_Event.calloc();
		e.button().type(down ? SDL_EVENT_MOUSE_BUTTON_DOWN : SDL_EVENT_MOUSE_BUTTON_UP).button((byte)button).down(down).x(x).y(y);
		push(e);
		e.free();
	}

	static void wheel(float y) {
		SDL_Event e = SDL_Event.calloc();
		e.wheel().type(SDL_EVENT_MOUSE_WHEEL).y(y).direction(SDL_MOUSEWHEEL_NORMAL);
		push(e);
		e.free();
	}

	static void key(int scancode, boolean down, boolean repeat) {
		SDL_Event e = SDL_Event.calloc();
		e.key().type(down ? SDL_EVENT_KEY_DOWN : SDL_EVENT_KEY_UP).scancode(scancode).down(down).repeat(repeat);
		push(e);
		e.free();
	}

	/** SDL copies nothing: the text must stay alive until the event is polled. */
	static ByteBuffer text(String text) {
		ByteBuffer utf8 = memUTF8(text);
		SDL_Event e = SDL_Event.calloc();
		e.text().type(SDL_EVENT_TEXT_INPUT).text(utf8);
		push(e);
		e.free();
		return utf8;
	}

	static void checkKeyboard() {
		check("Display.create() creates the Keyboard", Keyboard.isCreated());
		while (Keyboard.next()) {
			// drain whatever the real keyboard did
		}
		key(SDL_SCANCODE_A, true, false);
		ByteBuffer a = text("a");
		key(SDL_SCANCODE_RETURN, true, false);
		key(SDL_SCANCODE_RETURN, false, false);
		key(SDL_SCANCODE_A, true, true); // a repeat, with its text
		ByteBuffer a2 = text("a");
		Display.update();

		check("A held", Keyboard.isKeyDown(Keyboard.KEY_A) && !Keyboard.isKeyDown(Keyboard.KEY_RETURN));
		check("key 1: A down with its character", Keyboard.next() && Keyboard.getEventKey() == Keyboard.KEY_A
			&& Keyboard.getEventKeyState() && Keyboard.getEventCharacter() == 'a');
		check("key 2: Return down, with LWJGL 2's control character", Keyboard.next()
			&& Keyboard.getEventKey() == Keyboard.KEY_RETURN && Keyboard.getEventCharacter() == '\r');
		check("key 3: Return up", Keyboard.next() && Keyboard.getEventKey() == Keyboard.KEY_RETURN && !Keyboard.getEventKeyState());
		check("repeats skipped unless enabled", !Keyboard.next());

		Keyboard.enableRepeatEvents(true);
		key(SDL_SCANCODE_A, true, true);
		Display.update();
		check("repeat delivered when enabled", Keyboard.next() && Keyboard.getEventKey() == Keyboard.KEY_A && Keyboard.isRepeatEvent());
		Keyboard.enableRepeatEvents(false);

		key(SDL_SCANCODE_A, false, false);
		ByteBuffer accent = text("\u00e9"); // text with no press before it: an input method
		Display.update();
		check("A released", Keyboard.next() && Keyboard.getEventKey() == Keyboard.KEY_A && !Keyboard.getEventKeyState()
			&& !Keyboard.isKeyDown(Keyboard.KEY_A));
		check("text without a press: a KEY_NONE event", Keyboard.next() && Keyboard.getEventKey() == Keyboard.KEY_NONE
			&& Keyboard.getEventCharacter() == '\u00e9');
		check("no more events", !Keyboard.next());
		memFree(a);
		memFree(a2);
		memFree(accent);
		check("key names", "A".equals(Keyboard.getKeyName(Keyboard.KEY_A)) && Keyboard.getKeyIndex("RETURN") == Keyboard.KEY_RETURN);
	}

	static void checkContext() throws Exception {
		ContextCapabilities caps = GLContext.getCapabilities();
		check("GLContext.getCapabilities() is cached", caps == GLContext.getCapabilities());
		GLCapabilities lwjgl3 = GL.getCapabilities();
		int flags = 0;
		int differ = 0;
		for (Field f : ContextCapabilities.class.getFields()) {
			if (f.getType() != boolean.class || Modifier.isStatic(f.getModifiers())) {
				continue;
			}
			flags++;
			boolean expected;
			try {
				expected = GLCapabilities.class.getField(f.getName()).getBoolean(lwjgl3);
			} catch (NoSuchFieldException e) {
				expected = false;
			}
			if (f.getBoolean(caps) != expected) {
				differ++;
			}
		}
		check(flags + " flags, all LWJGL 3's", flags > 300 && differ == 0);
		check("OpenGL 2.0 and ARB_vertex_buffer_object", caps.OpenGL20 && caps.GL_ARB_vertex_buffer_object);

		Throwable[] other = new Throwable[1];
		Thread t = new Thread(() -> {
			try {
				GLContext.getCapabilities();
			} catch (Throwable e) {
				other[0] = e;
			}
		});
		t.start();
		t.join();
		check("another thread has no context", other[0] instanceof RuntimeException);

		Display.releaseContext();
		boolean released;
		try {
			GLContext.getCapabilities();
			released = false;
		} catch (RuntimeException e) {
			released = true;
		}
		check("releaseContext() clears it", released && !Display.isCurrent());
		Display.makeCurrent();
		check("makeCurrent() brings it back", Display.isCurrent() && GLContext.getCapabilities() == caps);
	}

	public static void main(String[] args) throws Exception {
		Display.setDisplayMode(new DisplayMode(400, 300));
		Display.create();
		check("Display.create() creates the Mouse", Mouse.isCreated());
		check("5 buttons and a wheel", Mouse.getButtonCount() == 5 && Mouse.hasWheel());
		while (Mouse.next()) {
			// drain whatever the real mouse did
		}

		motion(100, 50, 0, 0);
		button(SDL_BUTTON_LEFT, true, 100, 50);
		wheel(1);
		button(SDL_BUTTON_RIGHT, true, 100, 50);
		button(SDL_BUTTON_RIGHT, false, 100, 50);
		Display.update();

		check("position, y up from the bottom", Mouse.getX() == 100 && Mouse.getY() == 300 - 1 - 50);
		check("left button held", Mouse.isButtonDown(0) && !Mouse.isButtonDown(1));
		check("wheel: 120 per notch", Mouse.getDWheel() == 120);

		check("event 1: motion", Mouse.next() && Mouse.getEventButton() == -1 && Mouse.getEventX() == 100 && Mouse.getEventY() == 249);
		check("event 2: left down", Mouse.next() && Mouse.getEventButton() == 0 && Mouse.getEventButtonState());
		check("event 3: wheel", Mouse.next() && Mouse.getEventButton() == -1 && Mouse.getEventDWheel() == 120);
		check("event 4: right down", Mouse.next() && Mouse.getEventButton() == 1 && Mouse.getEventButtonState());
		check("event 5: right up", Mouse.next() && Mouse.getEventButton() == 1 && !Mouse.getEventButtonState());
		check("no more events", !Mouse.next());

		button(SDL_BUTTON_LEFT, false, 120, 60);
		Display.update();
		check("left released, moved", !Mouse.isButtonDown(0) && Mouse.getX() == 120 && Mouse.getDX() == 20 && Mouse.getDY() == -10);

		Mouse.setGrabbed(true);
		check("grabbed", Mouse.isGrabbed());
		motion(0, 0, 5.5f, -3f);
		motion(0, 0, 0.5f, 0f);
		Display.update();
		check("grabbed: deltas, y up, fractions kept", Mouse.getDX() == 6 && Mouse.getDY() == 3);
		check("grabbed: event deltas", Mouse.next() && Mouse.getEventDX() == 5 && Mouse.getEventDY() == 3
			&& Mouse.next() && Mouse.getEventDX() == 1);
		Mouse.setGrabbed(false);
		check("released", !Mouse.isGrabbed());

		IntBuffer image = BufferUtils.createIntBuffer(16 * 16);
		for (int i = 0; i < 16 * 16; i++) {
			image.put(i, 0xFFFF0000);
		}
		Cursor cursor = new Cursor(16, 16, 0, 15, 1, image, null);
		Mouse.setNativeCursor(cursor);
		check("native cursor set", Mouse.getNativeCursor() == cursor);
		Mouse.setNativeCursor(null);
		cursor.destroy();

		check("cursor capabilities include animation", (Cursor.getCapabilities() & Cursor.CURSOR_ANIMATION) != 0);
		IntBuffer frames = BufferUtils.createIntBuffer(2 * 16 * 16);
		for (int i = 0; i < 16 * 16; i++) {
			frames.put(i, 0xFFFF0000);
			frames.put(16 * 16 + i, 0x800000FF);
		}
		IntBuffer delays = BufferUtils.createIntBuffer(2);
		delays.put(0, 200).put(1, 300);
		Cursor animated = new Cursor(16, 16, 8, 8, 2, frames, delays);
		Mouse.setNativeCursor(animated);
		Display.update(); // Mouse.updateCursor(): one native cursor, nothing to switch
		check("animated cursor set", Mouse.getNativeCursor() == animated);
		Mouse.setNativeCursor(null);
		animated.destroy();

		checkKeyboard();
		checkContext();

		Display.destroy();
		check("Display.destroy() destroys the Mouse and the Keyboard", !Mouse.isCreated() && !Keyboard.isCreated());
		System.out.println(failures == 0 ? "all checks passed" : failures + " checks failed");
		System.exit(failures == 0 ? 0 : 1);
	}

}
