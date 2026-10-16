package org.lwjgl.openal;

import org.lwjgl.LWJGLException;
import org.lwjgl.BufferChecks;
import org.lwjgl.system.MemoryUtil;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.HashMap;

/**
 * LWJGL 2's AL and ALC10/ALC11 object model on LWJGL 3's OpenAL: ALCdevice and ALCcontext (LWJGL 2's, unchanged) wrap
 * LWJGL 3's handles, and the handle-to-wrapper tables are LWJGL 2's ALC10 tables. The AL, ALC10 and ALC11 fragments
 * forward their LWJGL 2 members here, where the bodies are LWJGL 2's with its natives replaced by LWJGL 3's functions.
 *
 * <p>LWJGL 3's ALC owns the library: AL.create loads it only when nothing has yet (explicit init), and AL.destroy
 * closes only the device and context AL.create opened, unloading the library only if AL.create loaded it.</p>
 */
final class ALObjects {

	static final HashMap<Long, ALCcontext> contexts = new HashMap<Long, ALCcontext>();
	static final HashMap<Long, ALCdevice> devices = new HashMap<Long, ALCdevice>();

	// ---- AL

	private static ALCdevice device;
	private static ALCcontext context;
	private static boolean created;
	/** whether AL.create loaded LWJGL 3's ALC, so that AL.destroy unloads it */
	private static boolean loadedLibrary;
	/** inside ALC.destroy, which calls AL.destroy and then unloads the library itself */
	private static boolean alcDestroying;

	private ALObjects() {
	}

	static boolean isCreated() {
		return created;
	}

	static ALCdevice getDevice() {
		return device;
	}

	static ALCcontext getContext() {
		return context;
	}

	/** As LWJGL 2, with LWJGL 3's ALC in place of the library LWJGL 2 looked for on org.lwjgl.librarypath. */
	static void create(String deviceArguments, int contextFrequency, int contextRefresh, boolean contextSynchronized, boolean openDevice)
		throws LWJGLException {
		if (created) {
			throw new IllegalStateException("Only one OpenAL context may be instantiated at any one time.");
		}
		if (!libraryLoaded()) { // explicit init (org.lwjgl.openal.explicitInit), or unloaded by ALC.destroy
			try {
				ALC.create();
			} catch (RuntimeException e) {
				throw new LWJGLException("Could not locate OpenAL library.", e);
			}
			loadedLibrary = true;
		}
		created = true;
		try {
			if (openDevice) {
				device = alcOpenDevice(deviceArguments);
				if (device == null) {
					throw new LWJGLException("Could not open ALC device");
				}
				if (contextFrequency == -1) {
					context = alcCreateContext(device, null);
				} else {
					context = alcCreateContext(device,
						ALCcontext.createAttributeList(contextFrequency, contextRefresh,
							contextSynchronized ? ALC10.ALC_TRUE : ALC10.ALC_FALSE));
				}
				alcMakeContextCurrent(context);
			}
		} catch (LWJGLException e) {
			destroy();
			throw e;
		}
	}

	private static boolean libraryLoaded() {
		try {
			ALC.getFunctionProvider();
			return true;
		} catch (IllegalStateException e) {
			return false;
		}
	}

	/**
	 * AL.destroy's LWJGL 2 part: closes what AL.create opened. Returns whether the caller should unload the library:
	 * AL.create loaded it, and this is not ALC.destroy's own call.
	 */
	static boolean destroy() {
		if (context != null) {
			alcMakeContextCurrent(null);
			alcDestroyContext(context);
			context = null;
		}
		if (device != null) {
			alcCloseDevice(device);
			device = null;
		}
		created = false;
		boolean unload = loadedLibrary && !alcDestroying;
		if (unload) {
			loadedLibrary = false;
		}
		return unload;
	}

	static void beginALCDestroy() {
		alcDestroying = true;
	}

	static void endALCDestroy() {
		alcDestroying = false;
		loadedLibrary = false; // whoever loaded it, it is gone
	}

	// ---- ALC10

	static long device(ALCdevice device) {
		if (device != null) {
			Util.checkALCValidDevice(device);
			return device.device;
		}
		return 0L;
	}

	static long context(ALCcontext context) {
		if (context != null) {
			Util.checkALCValidContext(context);
			return context.context;
		}
		return 0L;
	}

	static String alcGetString(ALCdevice device, int pname) {
		String value = ALC10.alcGetString(device(device), pname);
		Util.checkALCError(device);
		return value;
	}

	static void alcGetInteger(ALCdevice device, int pname, IntBuffer integerdata) {
		BufferChecks.checkDirect(integerdata);
		ALC10.nalcGetIntegerv(device(device), pname, integerdata.remaining(), MemoryUtil.memAddress(integerdata));
		Util.checkALCError(device);
	}

	static ALCdevice alcOpenDevice(String devicename) {
		return register(ALC10.alcOpenDevice(devicename));
	}

	static ALCdevice alcCaptureOpenDevice(String devicename, int frequency, int format, int buffersize) {
		return register(ALC11.alcCaptureOpenDevice(devicename, frequency, format, buffersize));
	}

	private static ALCdevice register(long device_address) {
		if (device_address != 0) {
			ALCdevice device = new ALCdevice(device_address);
			synchronized (devices) {
				devices.put(device_address, device);
			}
			return device;
		}
		return null;
	}

	static boolean alcCloseDevice(ALCdevice device) {
		boolean result = ALC10.alcCloseDevice(device(device));
		unregister(device);
		return result;
	}

	static boolean alcCaptureCloseDevice(ALCdevice device) {
		boolean result = ALC11.alcCaptureCloseDevice(device(device));
		unregister(device);
		return result;
	}

	private static void unregister(ALCdevice device) {
		synchronized (devices) {
			device.setInvalid();
			devices.remove(device.device);
		}
	}

	static ALCcontext alcCreateContext(ALCdevice device, IntBuffer attrList) {
		long context_address = ALC10.nalcCreateContext(device(device), MemoryUtil.memAddressSafe(attrList));
		Util.checkALCError(device);
		if (context_address != 0) {
			ALCcontext context = new ALCcontext(context_address);
			synchronized (contexts) {
				contexts.put(context_address, context);
				device.addContext(context);
			}
			return context;
		}
		return null;
	}

	/**
	 * LWJGL 2 loaded AL's functions with the library; LWJGL 3 loads them into capabilities, which need a current context:
	 * the first context made current gets them, created from its device.
	 */
	static int alcMakeContextCurrent(ALCcontext context) {
		long handle = context(context);
		boolean result = ALC10.alcMakeContextCurrent(handle);
		if (result && handle != 0L && !hasALCapabilities()) {
			AL.createCapabilities(ALC.createCapabilities(ALC10.alcGetContextsDevice(handle)));
		}
		return result ? ALC10.ALC_TRUE : ALC10.ALC_FALSE;
	}

	private static boolean hasALCapabilities() {
		try {
			AL.getCapabilities();
			return true;
		} catch (IllegalStateException e) {
			return false;
		}
	}

	static void alcProcessContext(ALCcontext context) {
		ALC10.alcProcessContext(context(context));
	}

	static ALCcontext alcGetCurrentContext() {
		ALCcontext context = null;
		long context_address = ALC10.alcGetCurrentContext();
		if (context_address != 0) {
			synchronized (contexts) {
				context = contexts.get(context_address);
			}
		}
		return context;
	}

	static ALCdevice alcGetContextsDevice(ALCcontext context) {
		ALCdevice device = null;
		long device_address = ALC10.alcGetContextsDevice(context(context));
		if (device_address != 0) {
			synchronized (devices) {
				device = devices.get(device_address);
			}
		}
		return device;
	}

	static void alcSuspendContext(ALCcontext context) {
		ALC10.alcSuspendContext(context(context));
	}

	static void alcDestroyContext(ALCcontext context) {
		synchronized (contexts) {
			ALCdevice device = alcGetContextsDevice(context);
			ALC10.alcDestroyContext(context(context));
			device.removeContext(context);
			context.setInvalid();
		}
	}

	static int alcGetError(ALCdevice device) {
		return ALC10.alcGetError(device(device));
	}

	static boolean alcIsExtensionPresent(ALCdevice device, String extName) {
		boolean result = ALC10.alcIsExtensionPresent(device(device), extName);
		Util.checkALCError(device);
		return result;
	}

	static int alcGetEnumValue(ALCdevice device, String enumName) {
		int result = ALC10.alcGetEnumValue(device(device), enumName);
		Util.checkALCError(device);
		return result;
	}

	// ---- ALC11

	static void alcCaptureStart(ALCdevice device) {
		ALC11.alcCaptureStart(device(device));
	}

	static void alcCaptureStop(ALCdevice device) {
		ALC11.alcCaptureStop(device(device));
	}

	static void alcCaptureSamples(ALCdevice device, ByteBuffer buffer, int samples) {
		ALC11.nalcCaptureSamples(device(device), MemoryUtil.memAddress(buffer), samples);
	}

}
