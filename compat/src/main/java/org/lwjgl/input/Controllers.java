package org.lwjgl.input;

import com.koyomiji.dualwjgl.MainThread;
import org.lwjgl.LWJGLException;

import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.sdl.SDLError.SDL_GetError;
import static org.lwjgl.sdl.SDLGamepad.SDL_IsGamepad;
import static org.lwjgl.sdl.SDLInit.*;
import static org.lwjgl.sdl.SDLJoystick.SDL_GetJoysticks;
import static org.lwjgl.sdl.SDLJoystick.SDL_UpdateJoysticks;
import static org.lwjgl.sdl.SDLStdinc.SDL_free;

/**
 * LWJGL 2's Controllers on SDL 3's gamepads and joysticks, where LWJGL 2 used JInput: no JInput needed. As LWJGL 2, the
 * controllers are those present at create(), and poll() turns their changes into events.
 *
 * <p>DEVIATION(controllers-sdl): controls are SDL's. A device SDL knows as a gamepad has its standard layout: axes X, Y
 * (left stick), Z (left trigger), RX, RY (right stick), RZ (right trigger), the d-pad as the POV, buttons A, B, X, Y,
 * shoulders, back, start, stick clicks, guide. Another joystick has SDL's axes, buttons and first hat in SDL's order.
 * JInput's names, order and ranges varied by platform and driver.</p>
 */
public class Controllers {

	private static final List<SDLController> controllers = new ArrayList<>();
	private static final List<ControllerEvent> events = new ArrayList<>();
	private static ControllerEvent event;
	private static boolean created;

	public static void create() throws LWJGLException {
		if (created) {
			return;
		}
		try {
			// on the main thread, as their updates (SDL's joystick backend on macOS runs on the thread that started it)
			MainThread.run(Controllers::open);
			created = true;
		} catch (LWJGLException e) {
			throw e;
		} catch (Throwable e) { // lwjgl-sdl or its natives missing, as LWJGL 2 without JInput
			throw new LWJGLException("Failed to initialise controllers", e);
		}
	}

	private static void open() {
		if (!SDL_InitSubSystem(SDL_INIT_GAMEPAD)) { // and the joystick subsystem with it
			throw new LWJGLException("Failed to initialise controllers: " + SDL_GetError());
		}
		IntBuffer ids = SDL_GetJoysticks();
		if (ids == null) {
			throw new LWJGLException("Failed to initialise controllers: " + SDL_GetError());
		}
		try {
			for (int i = 0; i < ids.remaining(); i++) {
				int id = ids.get(i);
				SDLController c = SDL_IsGamepad(id) ? SDLController.gamepad(controllers.size(), id) : SDLController.joystick(controllers.size(), id);
				if (c != null) {
					controllers.add(c);
				}
			}
		} finally {
			SDL_free(ids);
		}
	}

	public static Controller getController(int index) {
		return controllers.get(index);
	}

	public static int getControllerCount() {
		return controllers.size();
	}

	public static void poll() {
		if (created) {
			MainThread.run(() -> SDL_UpdateJoysticks());
		}
		for (int i = 0; i < controllers.size(); i++) {
			getController(i).poll();
		}
	}

	public static void clearEvents() {
		events.clear();
	}

	public static boolean next() {
		if (events.isEmpty()) {
			event = null;
			return false;
		}
		event = events.remove(0);
		return event != null;
	}

	public static boolean isCreated() {
		return created;
	}

	/** As LWJGL 2: does nothing; the controllers stay open and created. */
	public static void destroy() {
	}

	public static Controller getEventSource() {
		return event.getSource();
	}

	public static int getEventControlIndex() {
		return event.getControlIndex();
	}

	public static boolean isEventButton() {
		return event.isButton();
	}

	public static boolean isEventAxis() {
		return event.isAxis();
	}

	public static boolean isEventXAxis() {
		return event.isXAxis();
	}

	public static boolean isEventYAxis() {
		return event.isYAxis();
	}

	public static boolean isEventPovX() {
		return event.isPovX();
	}

	public static boolean isEventPovY() {
		return event.isPovY();
	}

	public static long getEventNanoseconds() {
		return event.getTimeStamp();
	}

	public static boolean getEventButtonState() {
		return event.getButtonState();
	}

	public static float getEventXAxisValue() {
		return event.getXAxisValue();
	}

	public static float getEventYAxisValue() {
		return event.getYAxisValue();
	}

	static void addEvent(ControllerEvent event) {
		if (event != null) {
			events.add(event);
		}
	}

}
