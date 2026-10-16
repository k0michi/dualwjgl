package org.lwjgl.opengl;

import org.lwjgl.LWJGLException;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.PointerBuffer;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.sdl.SDLError.SDL_GetError;
import static org.lwjgl.sdl.SDLVideo.*;

/**
 * LWJGL 2's ContextGL on SDL's GL contexts, in place of its platform ContextImplementations: the same states, threads
 * and deferred destruction, with an SDL_GLContext as the handle. SDL updates the context when its window moves or
 * resizes, so update and releaseDrawable have nothing to do.
 *
 * <p>DEVIATION(shared-context): SDL shares a new context only with the current one, so the shared context is made
 * current for the creation, then the previous one restored. A context shared with one current on another thread cannot
 * be created: that throws, where LWJGL 2 created it.</p>
 */
final class ContextGL implements Context {

	/** The current Context */
	private static final ThreadLocal<ContextGL> current_context_local = new ThreadLocal<ContextGL>();

	/** Handle to the native GL rendering context */
	private final long handle;
	private final PeerInfo peer_info;

	private final ContextAttribs contextAttribs;
	private final boolean forwardCompatible;

	/** Whether the context has been destroyed */
	private boolean destroyed;

	private boolean destroy_requested;

	/** The thread that has this context current, or null. */
	private Thread thread;

	PeerInfo getPeerInfo() {
		return peer_info;
	}

	ContextAttribs getContextAttribs() {
		return contextAttribs;
	}

	static ContextGL getCurrentContext() {
		return current_context_local.get();
	}

	/** Create a context with the specified peer info and shared context */
	ContextGL(PeerInfo peer_info, ContextAttribs attribs, ContextGL shared_context) throws LWJGLException {
		ContextGL context_lock = shared_context != null ? shared_context : this;
		// If shared_context is not null, synchronize on it to make sure it is not deleted
		// while this context is created. Otherwise, simply synchronize on ourself to avoid NPE
		synchronized (context_lock) {
			if (shared_context != null && shared_context.destroyed) {
				throw new IllegalArgumentException("Shared context is destroyed");
			}
			GLContext.loadOpenGLLibrary();
			try {
				this.peer_info = peer_info;
				this.contextAttribs = attribs;
				this.forwardCompatible = attribs != null && attribs.isForwardCompatible();
				this.handle = create((SDLPeerInfo)peer_info, attribs, shared_context);
			} catch (LWJGLException e) {
				GLContext.unloadOpenGLLibrary();
				throw e;
			}
		}
	}

	/** SDL_GL_CreateContext, which takes its attributes from SDL's state and makes the new context current: undone here. */
	private static long create(SDLPeerInfo peer_info, ContextAttribs attribs, ContextGL shared_context) throws LWJGLException {
		long previous_window = SDL_GL_GetCurrentWindow();
		long previous_context = SDL_GL_GetCurrentContext();
		try {
			Display.glAttributes(peer_info.getPixelFormat(), attribs);
			if (shared_context != null) {
				if (shared_context.thread != null && shared_context.thread != Thread.currentThread()) {
					throw new LWJGLException("Cannot share with a context current in " + shared_context.thread);
				}
				if (!SDL_GL_MakeCurrent(shared_context.window(), shared_context.handle)) {
					throw new LWJGLException("Could not make the shared context current: " + SDL_GetError());
				}
				SDL_GL_SetAttribute(SDL_GL_SHARE_WITH_CURRENT_CONTEXT, 1);
			}
			long handle = SDL_GL_CreateContext(peer_info.getWindow());
			if (handle == 0L) {
				throw new LWJGLException("Could not create the OpenGL context: " + SDL_GetError());
			}
			return handle;
		} finally {
			SDL_GL_MakeCurrent(previous_window, previous_context);
		}
	}

	private long window() {
		return ((SDLPeerInfo)peer_info).getWindow();
	}

	/** Release the current context (if any). After this call, no context is current. */
	public void releaseCurrent() throws LWJGLException {
		ContextGL current_context = getCurrentContext();
		if (current_context != null) {
			if (!SDL_GL_MakeCurrent(0L, 0L)) {
				throw new LWJGLException("Could not release the current context: " + SDL_GetError());
			}
			GLContext.useContext(null);
			current_context_local.set(null);
			synchronized (current_context) {
				current_context.thread = null;
				current_context.checkDestroy();
			}
		}
	}

	/** Nothing to do: SDL binds the context to its window when making it current. */
	public synchronized void releaseDrawable() throws LWJGLException {
		if (destroyed) {
			throw new IllegalStateException("Context is destroyed");
		}
	}

	/** Nothing to do: SDL updates the context when its window moves or resizes. */
	public synchronized void update() {
		if (destroyed) {
			throw new IllegalStateException("Context is destroyed");
		}
	}

	/** Swap the buffers on the current context. Only valid for double-buffered contexts */
	public static void swapBuffers() throws LWJGLException {
		ContextGL current_context = getCurrentContext();
		if (current_context == null) {
			throw new IllegalStateException("No context is current");
		}
		synchronized (current_context) {
			if (!SDL_GL_SwapWindow(current_context.window())) {
				throw new LWJGLException("Could not swap buffers: " + SDL_GetError());
			}
		}
	}

	private boolean canAccess() {
		return thread == null || Thread.currentThread() == thread;
	}

	private void checkAccess() {
		if (!canAccess()) {
			throw new IllegalStateException("From thread " + Thread.currentThread() + ": " + thread + " already has the context current");
		}
	}

	/** Make the context current */
	public synchronized void makeCurrent() throws LWJGLException {
		checkAccess();
		if (destroyed) {
			throw new IllegalStateException("Context is destroyed");
		}
		thread = Thread.currentThread();
		current_context_local.set(this);
		if (!SDL_GL_MakeCurrent(window(), handle)) {
			throw new LWJGLException("Could not make the OpenGL context current: " + SDL_GetError());
		}
		GLContext.useContext(this, forwardCompatible);
	}

	long getHandle() {
		return handle;
	}

	/** Query whether the context is current */
	public synchronized boolean isCurrent() throws LWJGLException {
		if (destroyed) {
			throw new IllegalStateException("Context is destroyed");
		}
		return SDL_GL_GetCurrentContext() == handle;
	}

	private void checkDestroy() {
		if (!destroyed && destroy_requested) {
			try {
				releaseDrawable();
				SDL_GL_DestroyContext(handle);
				CallbackUtil.unregisterCallbacks(this);
				destroyed = true;
				thread = null;
				GLContext.unloadOpenGLLibrary();
			} catch (LWJGLException e) {
				LWJGLUtil.log("Exception occurred while destroying context: " + e);
			}
		}
	}

	/**
	 * Set the buffer swap interval. This call is a best-attempt at changing
	 * the monitor swap interval, which is the minimum periodicity of color buffer swaps,
	 * measured in video frame periods, and is not guaranteed to be successful.
	 * <p/>
	 * A video frame period is the time required to display a full frame of video data.
	 */
	public static void setSwapInterval(int value) {
		SDL_GL_SetSwapInterval(value);
	}

	/**
	 * Destroy the context. This method behaves the same as destroy() with the extra
	 * requirement that the context must be either current to the current thread or not
	 * current at all.
	 */
	public synchronized void forceDestroy() throws LWJGLException {
		checkAccess();
		destroy();
	}

	/**
	 * Request destruction of the Context. If the context is current, no context will be current after this call.
	 * The context is destroyed when no thread has it current.
	 */
	public synchronized void destroy() throws LWJGLException {
		if (destroyed) {
			return;
		}
		destroy_requested = true;
		boolean was_current = isCurrent();
		int error = GL_NO_ERROR;
		if (was_current) {
			try {
				// May fail on GLContext.getCapabilities()
				error = glGetError();
			} catch (Exception e) {
				// ignore
			}
			releaseCurrent();
		}
		checkDestroy();
		if (was_current && error != GL_NO_ERROR) {
			throw new OpenGLException(error);
		}
	}

	public synchronized void setCLSharingProperties(final PointerBuffer properties) throws LWJGLException {
		// TODO(cl): CL/GL sharing (CL_GL_CONTEXT_KHR and the platform's display or share group, from SDL's properties)
		throw new LWJGLException("CL/GL sharing is not supported yet");
	}

}
