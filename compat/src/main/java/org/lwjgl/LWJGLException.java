package org.lwjgl;

/**
 * LWJGL 2's general exception.
 *
 * <p>In LWJGL 2 this is a checked exception. Here it extends {@link RuntimeException}, so that methods shared with
 * LWJGL 3 (e.g. {@code CL.create()}) compile both for LWJGL 2 callers that catch it and LWJGL 3 callers that do not.
 * {@link Exception} stays a supertype, so binaries compiled against LWJGL 2 still link and catch it.</p>
 */
public class LWJGLException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public LWJGLException() {
		super();
	}

	public LWJGLException(String msg) {
		super(msg);
	}

	public LWJGLException(String message, Throwable cause) {
		super(message, cause);
	}

	public LWJGLException(Throwable cause) {
		super(cause);
	}

}
