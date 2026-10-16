package org.lwjgl.opencl;

/**
 * DEVIATION(out-of-scope): APPLE_ContextLoggingFunctions is not supported. The callbacks are null, as LWJGL 2 left
 * them where the extension was missing, and CLCapabilities reports it missing.
 */
public final class APPLEContextLoggingUtil {

	/** Sends all log messages to the Apple System Logger. */
	public static final CLContextCallback SYSTEM_LOG_CALLBACK = null;

	/** Sends all log messages to the file descriptor stdout. */
	public static final CLContextCallback STD_OUT_CALLBACK = null;

	/** Sends all log messages to the file descriptor stderr. */
	public static final CLContextCallback STD_ERR_CALLBACK = null;

	private APPLEContextLoggingUtil() {
	}

}
