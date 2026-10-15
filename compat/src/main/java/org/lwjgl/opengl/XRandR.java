package org.lwjgl.opengl;

public class XRandR {
	public XRandR() {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static XRandR.Screen[] getConfiguration() {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static void setConfiguration(boolean disableOthers, XRandR.Screen... screens) {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static void saveConfiguration() {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static void restoreConfiguration() {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static String[] getScreenNames() {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static XRandR.Screen[] getResolutions(String name) {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static class Screen implements Cloneable {
		public String name;
		public int width;
		public int height;
		public int freq;
		public int xPos;
		public int yPos;

		Screen(String name, int width, int height, int freq, int xPos, int yPos) {
			// TODO(sdl)
			throw new UnsupportedOperationException();
		}

		public String toString() {
			// TODO(sdl)
			throw new UnsupportedOperationException();
		}
	}
}
