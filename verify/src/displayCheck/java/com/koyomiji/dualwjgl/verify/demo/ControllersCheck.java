package com.koyomiji.dualwjgl.verify.demo;

import org.lwjgl.input.Controller;
import org.lwjgl.input.Controllers;
import org.lwjgl.sdl.SDL_VirtualJoystickDesc;

import java.nio.ByteBuffer;

import static org.lwjgl.sdl.SDLGamepad.*;
import static org.lwjgl.sdl.SDLInit.*;
import static org.lwjgl.sdl.SDLJoystick.*;
import static org.lwjgl.system.MemoryUtil.memUTF8;

/**
 * Attaches an SDL virtual gamepad and a virtual plain joystick, then checks what LWJGL 2's Controllers report as SDL's
 * state changes. Needs no window; compiled against the patched jars and LWJGL 3's SDL module.
 */
public final class ControllersCheck {

	static int failures;

	static void check(String what, boolean ok) {
		System.out.println((ok ? "  PASS  " : "  FAIL  ") + what);
		if (!ok) {
			failures++;
		}
	}

	static long attach(short type, int axes, int buttons, int hats, String name) {
		SDL_VirtualJoystickDesc desc = SDL_VirtualJoystickDesc.calloc();
		ByteBuffer utf8 = memUTF8(name);
		desc.version(SDL_VirtualJoystickDesc.SIZEOF).type(type).naxes((short)axes).nbuttons((short)buttons).nhats((short)hats).name(utf8);
		int id = SDL_AttachVirtualJoystick(desc);
		desc.free();
		if (id == 0) {
			throw new IllegalStateException("SDL_AttachVirtualJoystick failed");
		}
		return SDL_OpenJoystick(id);
	}

	public static void main(String[] args) throws Exception {
		if (!SDL_InitSubSystem(SDL_INIT_GAMEPAD)) {
			throw new IllegalStateException("SDL_InitSubSystem failed");
		}
		long pad = attach((short)SDL_JOYSTICK_TYPE_GAMEPAD, SDL_GAMEPAD_AXIS_COUNT, SDL_GAMEPAD_BUTTON_COUNT, 0, "dualwjgl virtual gamepad");
		long stick = attach((short)0, 3, 4, 1, "dualwjgl virtual joystick");

		Controllers.create();
		Controller gamepad = null;
		Controller joystick = null;
		for (int i = 0; i < Controllers.getControllerCount(); i++) {
			Controller c = Controllers.getController(i);
			if (c.getName().equals("dualwjgl virtual gamepad")) {
				gamepad = c;
			} else if (c.getName().equals("dualwjgl virtual joystick")) {
				joystick = c;
			}
		}
		check("both virtual devices found", gamepad != null && joystick != null);
		check("gamepad: 6 axes, 11 buttons, LWJGL 2's x/y/z/rx/ry/rz", gamepad.getAxisCount() == 6 && gamepad.getButtonCount() == 11
			&& "X Axis".equals(gamepad.getAxisName(0)) && "Z Rotation".equals(gamepad.getAxisName(5)) && "A".equals(gamepad.getButtonName(0)));
		Controllers.poll();
		while (Controllers.next()) {
			// initial state
		}

		SDL_SetJoystickVirtualAxis(pad, SDL_GAMEPAD_AXIS_LEFTX, (short)32767);
		// a virtual gamepad maps the axis range -32768..32767 onto the trigger range 0..32767: 16384 is 3/4
		SDL_SetJoystickVirtualAxis(pad, SDL_GAMEPAD_AXIS_RIGHT_TRIGGER, (short)16384);
		SDL_SetJoystickVirtualAxis(pad, SDL_GAMEPAD_AXIS_RIGHTY, (short)1000); // inside the 0.05 dead zone
		SDL_SetJoystickVirtualButton(pad, SDL_GAMEPAD_BUTTON_SOUTH, true);
		SDL_SetJoystickVirtualButton(pad, SDL_GAMEPAD_BUTTON_DPAD_LEFT, true);
		SDL_SetJoystickVirtualButton(pad, SDL_GAMEPAD_BUTTON_DPAD_DOWN, true);
		Controllers.poll();

		check("gamepad: x axis", gamepad.getXAxisValue() == 1f);
		check("gamepad: right trigger as rz", Math.abs(gamepad.getRZAxisValue() - 0.75f) < 0.01f);
		check("gamepad: dead zone", gamepad.getRYAxisValue() == 0f);
		check("gamepad: A pressed", gamepad.isButtonPressed(0) && !gamepad.isButtonPressed(1));
		check("gamepad: d-pad as POV", gamepad.getPovX() == -1f && gamepad.getPovY() == 1f);

		boolean button = false;
		boolean xAxis = false;
		boolean povX = false;
		boolean povY = false;
		while (Controllers.next()) {
			check("event source", Controllers.getEventSource() == gamepad);
			if (Controllers.isEventButton()) {
				button = Controllers.getEventControlIndex() == 0 && Controllers.getEventButtonState();
			} else if (Controllers.isEventXAxis()) {
				xAxis = Controllers.getEventXAxisValue() == 1f;
			} else if (Controllers.isEventPovX()) {
				povX = true;
			} else if (Controllers.isEventPovY()) {
				povY = true;
			}
		}
		check("events: button, x axis, POV x and y", button && xAxis && povX && povY);
		Controllers.poll();
		check("no events without a change", !Controllers.next());

		check("joystick: SDL's axes, buttons and hat", joystick.getAxisCount() == 3 && joystick.getButtonCount() == 4
			&& "Button 3".equals(joystick.getButtonName(3)));
		SDL_SetJoystickVirtualAxis(stick, 1, (short)-32768);
		SDL_SetJoystickVirtualButton(stick, 2, true);
		SDL_SetJoystickVirtualHat(stick, 0, (byte)SDL_HAT_RIGHTUP);
		Controllers.poll();
		check("joystick: y axis -1", joystick.getYAxisValue() == -1f);
		check("joystick: button 2", joystick.isButtonPressed(2));
		check("joystick: hat as POV", joystick.getPovX() == 1f && joystick.getPovY() == -1f);
		Controllers.clearEvents();

		gamepad.setDeadZone(0, 0.5f);
		check("dead zones", gamepad.getXAxisDeadZone() == 0.5f && joystick.getZAxisDeadZone() == 0.05f);

		System.out.println(failures == 0 ? "all checks passed" : failures + " checks failed");
		System.exit(failures == 0 ? 0 : 1);
	}

}
