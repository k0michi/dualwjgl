package org.lwjgl.opengl;

import java.util.HashMap;
import java.util.Map;

/**
 * LWJGL 2's GL CallbackUtil without its natives. LWJGL 2 registered a fixed C function per debug extension with the
 * driver and passed a JNI global reference to the callback's Handler as userParam; here the fixed functions are LWJGL 3
 * callbacks, created once and never freed as LWJGL 2's were static, and userParam is an ID in a Java table that keeps
 * the Handler alive while it is registered with a context.
 *
 * <p>TODO(verify): with a driver that has KHR_debug, ARB_debug_output or AMD_debug_output; macOS has none.</p>
 */
final class CallbackUtil {

	/** IDs away from small integers and typical pointers, so that LWJGL 3 userParams rarely match one */
	private static final long ID_BASE = 0x4C57_4A47_0000_0000L;

	private static final Map<Long, Object> refs = new HashMap<Long, Object>();
	private static long nextId = ID_BASE;

	/** a context's LWJGL 3 capabilities -> the Handler reference registered with it, per extension */
	private static final Map<GLCapabilities, Long> contextUserParamsARB = new HashMap<GLCapabilities, Long>();
	private static final Map<GLCapabilities, Long> contextUserParamsAMD = new HashMap<GLCapabilities, Long>();
	private static final Map<GLCapabilities, Long> contextUserParamsKHR = new HashMap<GLCapabilities, Long>();

	private static GLDebugMessageCallback debugCallbackKHR;
	private static GLDebugMessageARBCallback debugOutputCallbackARB;
	private static GLDebugMessageAMDCallback debugOutputCallbackAMD;

	private CallbackUtil() {
	}

	static long createGlobalRef(final Object obj) {
		if (obj == null) {
			return 0;
		}
		synchronized (refs) {
			long id = nextId++;
			refs.put(id, obj);
			return id;
		}
	}

	private static void deleteGlobalRef(final long ref) {
		synchronized (refs) {
			refs.remove(ref);
		}
	}

	private static Object getObject(final long ref) {
		synchronized (refs) {
			return refs.get(ref);
		}
	}

	// --------- [ XXX_debug_output ] ---------

	private static void registerContextCallback(final long userParam, final Map<GLCapabilities, Long> contextUserData) {
		GLCapabilities caps;
		try {
			caps = GL.getCapabilities();
		} catch (IllegalStateException e) {
			deleteGlobalRef(userParam);
			throw new IllegalStateException("No context is current.");
		}

		synchronized (refs) {
			final Long userParam_old = contextUserData.remove(caps);
			if (userParam_old != null) {
				deleteGlobalRef(userParam_old);
			}

			if (userParam != 0) {
				contextUserData.put(caps, userParam);
			}
		}
	}

	/** ContextGL's, as it destroys a context: the Handlers registered with it can go. */
	static void unregisterCallbacks(final Object context) {
		final GLCapabilities caps = GLContext.getLWJGL3Capabilities(context);
		if (caps == null) {
			return;
		}
		synchronized (refs) {
			Long userParam = contextUserParamsARB.remove(caps);
			if (userParam != null) {
				deleteGlobalRef(userParam);
			}

			userParam = contextUserParamsAMD.remove(caps);
			if (userParam != null) {
				deleteGlobalRef(userParam);
			}

			userParam = contextUserParamsKHR.remove(caps);
			if (userParam != null) {
				deleteGlobalRef(userParam);
			}
		}
	}

	// --------- [ ARB_debug_output ] ---------

	/** The fixed function the ARBDebugOutputCallback class registers; its static initializer reads it reflectively. */
	static synchronized long getDebugOutputCallbackARB() {
		if (debugOutputCallbackARB == null) {
			debugOutputCallbackARB = GLDebugMessageARBCallback.create((source, type, id, severity, length, message, userParam) -> {
				Object handler = getObject(userParam);
				if (handler instanceof ARBDebugOutputCallback.Handler) {
					((ARBDebugOutputCallback.Handler)handler).handleMessage(source, type, id, severity,
						GLDebugMessageARBCallback.getMessage(length, message));
				}
			});
		}
		return debugOutputCallbackARB.address();
	}

	static void registerContextCallbackARB(final long userParam) {
		registerContextCallback(userParam, contextUserParamsARB);
	}

	// --------- [ AMD_debug_output ] ---------

	static synchronized long getDebugOutputCallbackAMD() {
		if (debugOutputCallbackAMD == null) {
			debugOutputCallbackAMD = GLDebugMessageAMDCallback.create((id, category, severity, length, message, userParam) -> {
				Object handler = getObject(userParam);
				if (handler instanceof AMDDebugOutputCallback.Handler) {
					((AMDDebugOutputCallback.Handler)handler).handleMessage(id, category, severity,
						GLDebugMessageAMDCallback.getMessage(length, message));
				}
			});
		}
		return debugOutputCallbackAMD.address();
	}

	static void registerContextCallbackAMD(final long userParam) {
		registerContextCallback(userParam, contextUserParamsAMD);
	}

	// --------- [ KHR_debug ] ---------

	static synchronized long getDebugCallbackKHR() {
		if (debugCallbackKHR == null) {
			debugCallbackKHR = GLDebugMessageCallback.create((source, type, id, severity, length, message, userParam) -> {
				Object handler = getObject(userParam);
				if (handler instanceof KHRDebugCallback.Handler) {
					((KHRDebugCallback.Handler)handler).handleMessage(source, type, id, severity,
						GLDebugMessageCallback.getMessage(length, message));
				}
			});
		}
		return debugCallbackKHR.address();
	}

	static void registerContextCallbackKHR(final long userParam) {
		registerContextCallback(userParam, contextUserParamsKHR);
	}

}
