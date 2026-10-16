package org.lwjgl.opengl;

import org.lwjgl.LWJGLException;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * LWJGL 2's GLContext on LWJGL 3's GL: a thread's current context is LWJGL 3's current GLCapabilities (Display makes it
 * current), and its ContextCapabilities are derived from them once.
 */
public final class GLContext {

	/** LWJGL 3's capabilities -> LWJGL 2's, built on first use */
	private static final Map<GLCapabilities, ContextCapabilities> capabilities = new WeakHashMap<>();
	/** useContext's contexts -> LWJGL 3's capabilities for them */
	private static final Map<Object, GLCapabilities> contexts = new WeakHashMap<>();
	private static int libraryRefCount;
	/** whether loadOpenGLLibrary loaded LWJGL 3's GL, so that unloading it is ours to do */
	private static boolean loadedLibrary;
	private static boolean autoLoaded;

	public GLContext() {
	}

	/** The capabilities of the current thread's context; throws without one, as LWJGL 2. */
	public static ContextCapabilities getCapabilities() {
		GLCapabilities current;
		try {
			current = GL.getCapabilities();
		} catch (IllegalStateException | LinkageError e) { // none current, or no GL at all to initialize
			throw new RuntimeException("No OpenGL context found in the current thread.");
		}
		synchronized (GLContext.class) {
			ContextCapabilities caps = capabilities.get(current);
			if (caps == null) {
				try {
					caps = new ContextCapabilities(current.forwardCompatible);
				} catch (LWJGLException e) {
					throw new RuntimeException(e);
				}
				capabilities.put(current, caps);
			}
			return caps;
		}
	}

	public static void useContext(Object context) throws LWJGLException {
		useContext(context, false);
	}

	/**
	 * As LWJGL 2: makes the capabilities of {@code context}, which the caller has made current natively, current in this
	 * thread, creating them the first time; a null context clears them.
	 */
	public static synchronized void useContext(Object context, boolean forwardCompatible) throws LWJGLException {
		if (context == null) {
			GL.setCapabilities(null);
			if (autoLoaded) {
				autoLoaded = false;
				unloadOpenGLLibrary();
			}
			return;
		}
		if (libraryRefCount == 0) {
			loadOpenGLLibrary();
			autoLoaded = true;
		}
		GLCapabilities caps = contexts.get(context);
		if (caps == null) {
			try {
				caps = GL.createCapabilities(forwardCompatible); // also makes them current
			} catch (IllegalStateException e) {
				throw new LWJGLException(e.getMessage());
			}
			contexts.put(context, caps);
		} else {
			GL.setCapabilities(caps);
		}
	}

	/** The LWJGL 3 capabilities useContext made for a context, or null: CallbackUtil's key for it. */
	static synchronized GLCapabilities getLWJGL3Capabilities(Object context) {
		return contexts.get(context);
	}

	/** Reference counted, as LWJGL 2. LWJGL 3's GL may be loaded already (Display, or LWJGL 3 code): then it is left alone. */
	public static synchronized void loadOpenGLLibrary() throws LWJGLException {
		if (libraryRefCount == 0 && GL.getFunctionProvider() == null) {
			try {
				GL.create();
			} catch (IllegalStateException e) {
				throw new LWJGLException(e.getMessage());
			}
			loadedLibrary = true;
		}
		libraryRefCount++;
	}

	public static synchronized void unloadOpenGLLibrary() {
		if (libraryRefCount == 0) {
			return;
		}
		libraryRefCount--;
		if (libraryRefCount == 0 && loadedLibrary) {
			loadedLibrary = false;
			GL.destroy();
		}
	}

}
