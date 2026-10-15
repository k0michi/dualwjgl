package com.koyomiji.lwjgl2w3.inject.org.lwjgl.openal;

import com.koyomiji.lwjgl2w3.inject.Widen;
import org.lwjgl.LWJGLException;
import org.lwjgl.openal.ALCcontext;
import org.lwjgl.openal.ALCdevice;

public final class AL {
	public static boolean isCreated() {
		// TODO(al)
		throw new UnsupportedOperationException();
	}
	public static void create(String deviceArguments, int contextFrequency, int contextRefresh, boolean contextSynchronized) throws LWJGLException {
		// TODO(al)
		throw new UnsupportedOperationException();
	}
	public static void create(String deviceArguments, int contextFrequency, int contextRefresh, boolean contextSynchronized, boolean openDevice) throws LWJGLException {
		// TODO(al)
		throw new UnsupportedOperationException();
	}
	public static void create() throws LWJGLException {
		// TODO(al)
		throw new UnsupportedOperationException();
	}
	@Widen
	public static void destroy() {
		throw new UnsupportedOperationException();
	}
	public static ALCcontext getContext() {
		// TODO(al)
		throw new UnsupportedOperationException();
	}
	public static ALCdevice getDevice() {
		// TODO(al)
		throw new UnsupportedOperationException();
	}
}
