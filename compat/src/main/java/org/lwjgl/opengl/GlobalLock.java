package org.lwjgl.opengl;

/** As LWJGL 2's: the lock Display, Mouse and Keyboard share; LWJGL 2's input classes read it by reflection. */
final class GlobalLock {

	static final Object lock = new Object();

	private GlobalLock() {
	}

}
