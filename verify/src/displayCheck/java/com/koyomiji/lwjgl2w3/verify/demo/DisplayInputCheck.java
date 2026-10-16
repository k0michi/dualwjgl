package com.koyomiji.lwjgl2w3.verify.demo;

import org.lwjgl.BufferUtils;
import org.lwjgl.input.Cursor;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.sdl.SDL_Event;

import java.nio.IntBuffer;

import static org.lwjgl.sdl.SDLEvents.*;
import static org.lwjgl.sdl.SDLMouse.*;

/**
 * Opens a Display and feeds SDL synthetic mouse events, then checks what LWJGL 2's Mouse reports. Compiled against the
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

		Display.destroy();
		check("Display.destroy() destroys the Mouse", !Mouse.isCreated());
		System.out.println(failures == 0 ? "all checks passed" : failures + " checks failed");
		System.exit(failures == 0 ? 0 : 1);
	}

}
