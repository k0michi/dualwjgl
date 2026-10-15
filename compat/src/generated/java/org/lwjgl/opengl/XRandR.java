package org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Generated;
import com.koyomiji.lwjgl2w3.inject.Todo;

@Generated
public class XRandR {
	@Todo("sdl")
	public XRandR() {
		throw new UnsupportedOperationException();
	}

	@Todo("sdl")
	public static XRandR.Screen[] getConfiguration() {
		throw new UnsupportedOperationException();
	}

	@Todo("sdl")
	public static void setConfiguration(boolean disableOthers, XRandR.Screen... screens) {
		throw new UnsupportedOperationException();
	}

	@Todo("sdl")
	public static void saveConfiguration() {
		throw new UnsupportedOperationException();
	}

	@Todo("sdl")
	public static void restoreConfiguration() {
		throw new UnsupportedOperationException();
	}

	@Todo("sdl")
	public static String[] getScreenNames() {
		throw new UnsupportedOperationException();
	}

	@Todo("sdl")
	public static XRandR.Screen[] getResolutions(String name) {
		throw new UnsupportedOperationException();
	}

	@Generated
	public static class Screen implements Cloneable {
		public String name;
		public int width;
		public int height;
		public int freq;
		public int xPos;
		public int yPos;

		@Todo("sdl")
		Screen(String name, int width, int height, int freq, int xPos, int yPos) {
			throw new UnsupportedOperationException();
		}

		@Todo("sdl")
		public String toString() {
			throw new UnsupportedOperationException();
		}
	}
}
