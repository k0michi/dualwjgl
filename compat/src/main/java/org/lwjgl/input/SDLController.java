package org.lwjgl.input;

import static org.lwjgl.sdl.SDLGamepad.*;
import static org.lwjgl.sdl.SDLJoystick.*;
import static org.lwjgl.sdl.SDLProperties.SDL_GetBooleanProperty;

/**
 * One controller, what LWJGL 2's JInputController was: SDL's state is read on poll(), and what changed since the last
 * poll becomes LWJGL 2's events. Dead zones default to 0.05, as LWJGL 2's.
 */
final class SDLController implements Controller {

	/** the axes of a gamepad, in LWJGL 2's x, y, z, rx, ry, rz order */
	private static final int[] GAMEPAD_AXES = {SDL_GAMEPAD_AXIS_LEFTX, SDL_GAMEPAD_AXIS_LEFTY, SDL_GAMEPAD_AXIS_LEFT_TRIGGER,
		SDL_GAMEPAD_AXIS_RIGHTX, SDL_GAMEPAD_AXIS_RIGHTY, SDL_GAMEPAD_AXIS_RIGHT_TRIGGER};
	private static final String[] GAMEPAD_AXIS_NAMES = {"X Axis", "Y Axis", "Z Axis", "X Rotation", "Y Rotation", "Z Rotation"};
	/** the buttons of a gamepad, in DirectInput's order for an Xbox controller; the d-pad is the POV */
	private static final int[] GAMEPAD_BUTTONS = {SDL_GAMEPAD_BUTTON_SOUTH, SDL_GAMEPAD_BUTTON_EAST, SDL_GAMEPAD_BUTTON_WEST,
		SDL_GAMEPAD_BUTTON_NORTH, SDL_GAMEPAD_BUTTON_LEFT_SHOULDER, SDL_GAMEPAD_BUTTON_RIGHT_SHOULDER, SDL_GAMEPAD_BUTTON_BACK,
		SDL_GAMEPAD_BUTTON_START, SDL_GAMEPAD_BUTTON_LEFT_STICK, SDL_GAMEPAD_BUTTON_RIGHT_STICK, SDL_GAMEPAD_BUTTON_GUIDE};
	private static final String[] GAMEPAD_BUTTON_NAMES = {"A", "B", "X", "Y", "Left Shoulder", "Right Shoulder", "Back", "Start",
		"Left Stick", "Right Stick", "Guide"};

	private final int index;
	private final String name;
	/** an open SDL_Gamepad, or 0 for a plain joystick */
	private final long gamepad;
	private final long joystick;
	private final String[] axisNames;
	private final String[] buttonNames;
	private final boolean hasPov;
	private final boolean rumble;

	private final boolean[] buttons;
	private final float[] axes;
	private final float[] deadZones;
	private float povX;
	private float povY;

	private SDLController(int index, String name, long gamepad, long joystick, String[] axisNames, String[] buttonNames,
	                      boolean hasPov, boolean rumble) {
		this.index = index;
		this.name = name;
		this.gamepad = gamepad;
		this.joystick = joystick;
		this.axisNames = axisNames;
		this.buttonNames = buttonNames;
		this.hasPov = hasPov;
		this.rumble = rumble;
		buttons = new boolean[buttonNames.length];
		axes = new float[axisNames.length];
		deadZones = new float[axisNames.length];
		java.util.Arrays.fill(deadZones, 0.05f);
		read(false);
	}

	/** A device SDL has a gamepad mapping for: its standard layout. Null if it cannot be opened. */
	static SDLController gamepad(int index, int id) {
		long gamepad = SDL_OpenGamepad(id);
		if (gamepad == 0L) {
			return null;
		}
		String name = SDL_GetGamepadName(gamepad);
		boolean rumble = SDL_GetBooleanProperty(SDL_GetGamepadProperties(gamepad), SDL_PROP_GAMEPAD_CAP_RUMBLE_BOOLEAN, false);
		return new SDLController(index, name == null ? "Gamepad" : name, gamepad, 0L, GAMEPAD_AXIS_NAMES, GAMEPAD_BUTTON_NAMES, true, rumble);
	}

	/** Any other joystick: SDL's axes, buttons and first hat. Null if it cannot be opened. */
	static SDLController joystick(int index, int id) {
		long joystick = SDL_OpenJoystick(id);
		if (joystick == 0L) {
			return null;
		}
		String name = SDL_GetJoystickName(joystick);
		String[] axes = new String[Math.max(0, SDL_GetNumJoystickAxes(joystick))];
		for (int i = 0; i < axes.length; i++) {
			axes[i] = i < GAMEPAD_AXIS_NAMES.length ? GAMEPAD_AXIS_NAMES[i] : "Axis " + i;
		}
		String[] buttons = new String[Math.max(0, SDL_GetNumJoystickButtons(joystick))];
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = "Button " + i;
		}
		boolean rumble = SDL_GetBooleanProperty(SDL_GetJoystickProperties(joystick), SDL_PROP_JOYSTICK_CAP_RUMBLE_BOOLEAN, false);
		return new SDLController(index, name == null ? "Joystick" : name, 0L, joystick, axes, buttons,
			SDL_GetNumJoystickHats(joystick) > 0, rumble);
	}

	/** SDL's state now; with {@code events}, LWJGL 2's events for what changed. */
	private void read(boolean events) {
		long nanos = System.nanoTime();
		for (int i = 0; i < buttons.length; i++) {
			boolean pressed = gamepad != 0L ? SDL_GetGamepadButton(gamepad, GAMEPAD_BUTTONS[i]) : SDL_GetJoystickButton(joystick, i);
			if (pressed != buttons[i]) {
				buttons[i] = pressed;
				if (events) {
					Controllers.addEvent(new ControllerEvent(this, nanos, ControllerEvent.BUTTON, i, pressed, false, false, 0, 0));
				}
			}
		}
		for (int i = 0; i < axes.length; i++) {
			short raw = gamepad != 0L ? SDL_GetGamepadAxis(gamepad, GAMEPAD_AXES[i]) : SDL_GetJoystickAxis(joystick, i);
			float value = Math.max(-1f, raw / 32767f);
			if (Math.abs(value) < deadZones[i]) {
				value = 0f;
			}
			if (value != axes[i]) {
				axes[i] = value;
				if (events) {
					Controllers.addEvent(new ControllerEvent(this, nanos, ControllerEvent.AXIS, i, false, i == 0, i == 1,
						i == 0 ? value : 0, i == 1 ? value : 0));
				}
			}
		}
		if (hasPov) {
			float x;
			float y;
			if (gamepad != 0L) {
				x = (SDL_GetGamepadButton(gamepad, SDL_GAMEPAD_BUTTON_DPAD_RIGHT) ? 1 : 0) - (SDL_GetGamepadButton(gamepad, SDL_GAMEPAD_BUTTON_DPAD_LEFT) ? 1 : 0);
				y = (SDL_GetGamepadButton(gamepad, SDL_GAMEPAD_BUTTON_DPAD_DOWN) ? 1 : 0) - (SDL_GetGamepadButton(gamepad, SDL_GAMEPAD_BUTTON_DPAD_UP) ? 1 : 0);
			} else {
				int hat = SDL_GetJoystickHat(joystick, 0);
				x = ((hat & SDL_HAT_RIGHT) != 0 ? 1 : 0) - ((hat & SDL_HAT_LEFT) != 0 ? 1 : 0);
				y = ((hat & SDL_HAT_DOWN) != 0 ? 1 : 0) - ((hat & SDL_HAT_UP) != 0 ? 1 : 0);
			}
			// as LWJGL 2: X before Y, each when it changed
			if (x != povX) {
				povX = x;
				if (events) {
					Controllers.addEvent(new ControllerEvent(this, nanos, ControllerEvent.POVX, 0, false, false));
				}
			}
			if (y != povY) {
				povY = y;
				if (events) {
					Controllers.addEvent(new ControllerEvent(this, nanos, ControllerEvent.POVY, 0, false, false));
				}
			}
		}
	}

	@Override
	public void poll() {
		read(true);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getIndex() {
		return index;
	}

	@Override
	public int getButtonCount() {
		return buttons.length;
	}

	@Override
	public String getButtonName(int index) {
		return buttonNames[index];
	}

	@Override
	public boolean isButtonPressed(int index) {
		return buttons[index];
	}

	@Override
	public float getPovX() {
		return povX;
	}

	@Override
	public float getPovY() {
		return povY;
	}

	@Override
	public float getDeadZone(int index) {
		return deadZones[index];
	}

	@Override
	public void setDeadZone(int index, float zone) {
		deadZones[index] = zone;
	}

	@Override
	public int getAxisCount() {
		return axes.length;
	}

	@Override
	public String getAxisName(int index) {
		return axisNames[index];
	}

	@Override
	public float getAxisValue(int index) {
		return axes[index];
	}

	private float axis(int i) {
		return i < axes.length ? axes[i] : 0f;
	}

	private float zone(int i) {
		return i < axes.length ? deadZones[i] : 0f;
	}

	private void zone(int i, float zone) {
		if (i < axes.length) {
			deadZones[i] = zone;
		}
	}

	@Override
	public float getXAxisValue() {
		return axis(0);
	}

	@Override
	public float getXAxisDeadZone() {
		return zone(0);
	}

	@Override
	public void setXAxisDeadZone(float zone) {
		zone(0, zone);
	}

	@Override
	public float getYAxisValue() {
		return axis(1);
	}

	@Override
	public float getYAxisDeadZone() {
		return zone(1);
	}

	@Override
	public void setYAxisDeadZone(float zone) {
		zone(1, zone);
	}

	@Override
	public float getZAxisValue() {
		return axis(2);
	}

	@Override
	public float getZAxisDeadZone() {
		return zone(2);
	}

	@Override
	public void setZAxisDeadZone(float zone) {
		zone(2, zone);
	}

	@Override
	public float getRXAxisValue() {
		return axis(3);
	}

	@Override
	public float getRXAxisDeadZone() {
		return zone(3);
	}

	@Override
	public void setRXAxisDeadZone(float zone) {
		zone(3, zone);
	}

	@Override
	public float getRYAxisValue() {
		return axis(4);
	}

	@Override
	public float getRYAxisDeadZone() {
		return zone(4);
	}

	@Override
	public void setRYAxisDeadZone(float zone) {
		zone(4, zone);
	}

	@Override
	public float getRZAxisValue() {
		return axis(5);
	}

	@Override
	public float getRZAxisDeadZone() {
		return zone(5);
	}

	@Override
	public void setRZAxisDeadZone(float zone) {
		zone(5, zone);
	}

	@Override
	public int getRumblerCount() {
		return rumble ? 1 : 0;
	}

	@Override
	public String getRumblerName(int index) {
		if (!rumble || index != 0) {
			throw new IndexOutOfBoundsException("rumbler " + index);
		}
		return "Rumble";
	}

	/** Both motors at {@code strength} (0 to 1) until set again, as JInput's rumblers. */
	@Override
	public void setRumblerStrength(int index, float strength) {
		if (!rumble || index != 0) {
			throw new IndexOutOfBoundsException("rumbler " + index);
		}
		short level = (short)Math.round(Math.max(0f, Math.min(1f, strength)) * 0xFFFF);
		// SDL rumbles for a duration: the longest, so that it lasts until the next call
		int duration = level == 0 ? 0 : 0xFFFFFFFF;
		if (gamepad != 0L) {
			SDL_RumbleGamepad(gamepad, level, level, duration);
		} else {
			SDL_RumbleJoystick(joystick, level, level, duration);
		}
	}

}
