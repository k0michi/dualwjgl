package org.lwjgl.openal;

import com.koyomiji.lwjgl2w3.inject.Into;
import com.koyomiji.lwjgl2w3.inject.Wrap;
import org.lwjgl.LWJGLException;

/** LWJGL 2's AL startup and shutdown over LWJGL 3's ALC (see {@link ALObjects}). */
@Into(AL.class)
final class ALFragment {

	public static boolean isCreated() {
		return ALObjects.isCreated();
	}

	public static void create(String deviceArguments, int contextFrequency, int contextRefresh, boolean contextSynchronized)
		throws LWJGLException {
		create(deviceArguments, contextFrequency, contextRefresh, contextSynchronized, true);
	}

	public static void create(String deviceArguments, int contextFrequency, int contextRefresh, boolean contextSynchronized, boolean openDevice)
		throws LWJGLException {
		ALObjects.create(deviceArguments, contextFrequency, contextRefresh, contextSynchronized, openDevice);
	}

	public static void create() throws LWJGLException {
		create(null, 44100, 60, false);
	}

	/**
	 * LWJGL 3's AL.destroy (package-private, called by ALC.destroy) clears AL's capabilities; LWJGL 2's, public, also
	 * closed AL.create's context and device and unloaded the library. Both in one: AL.create's context and device are
	 * closed when there are any, then the capabilities cleared, and the library unloaded only if AL.create loaded it.
	 */
	@Wrap
	public static void destroy() {
		boolean unload = ALObjects.destroy();
		destroy$lwjgl3();
		if (unload) {
			ALC.destroy();
		}
	}

	static native void destroy$lwjgl3();

	public static ALCcontext getContext() {
		return ALObjects.getContext();
	}

	public static ALCdevice getDevice() {
		return ALObjects.getDevice();
	}

}
