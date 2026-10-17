package org.lwjgl.opengl;

import com.koyomiji.dualwjgl.inject.Generated;

@Generated
public class XRandR {
	public XRandR() {
	}

	public static XRandR.Screen[] getConfiguration() {
		throw new UnsupportedOperationException("org.lwjgl.opengl.XRandR is not supported");
	}

	public static void setConfiguration(boolean disableOthers, XRandR.Screen... screens) {
		throw new UnsupportedOperationException("org.lwjgl.opengl.XRandR is not supported");
	}

	public static void saveConfiguration() {
		throw new UnsupportedOperationException("org.lwjgl.opengl.XRandR is not supported");
	}

	public static void restoreConfiguration() {
		throw new UnsupportedOperationException("org.lwjgl.opengl.XRandR is not supported");
	}

	public static String[] getScreenNames() {
		throw new UnsupportedOperationException("org.lwjgl.opengl.XRandR is not supported");
	}

	public static XRandR.Screen[] getResolutions(String name) {
		throw new UnsupportedOperationException("org.lwjgl.opengl.XRandR is not supported");
	}

	@Generated
	public static class Screen implements Cloneable {
		public String name;
		public int width;
		public int height;
		public int freq;
		public int xPos;
		public int yPos;

		Screen(String name, int width, int height, int freq, int xPos, int yPos) {
			throw new UnsupportedOperationException("org.lwjgl.opengl.XRandR is not supported");
		}

		public String toString() {
			throw new UnsupportedOperationException("org.lwjgl.opengl.XRandR is not supported");
		}
	}
}
