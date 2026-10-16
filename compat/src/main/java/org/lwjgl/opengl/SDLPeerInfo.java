package org.lwjgl.opengl;

/**
 * A PeerInfo over an SDL window, which ContextGL creates its context for and makes it current with. SDL keeps the
 * native handles, so there is nothing to lock: the handle is null.
 */
final class SDLPeerInfo extends PeerInfo {

	/** Gives the window: the Display's peer exists before its window does, as in LWJGL 2. */
	interface Window {
		long get();
	}

	private final PixelFormat pixel_format;
	private final Window window;

	SDLPeerInfo(PixelFormat pixel_format, Window window) {
		super(null);
		this.pixel_format = pixel_format;
		this.window = window;
	}

	/** What ContextGL sets SDL's GL attributes from: on some platforms SDL chooses the pixel format with the context. */
	PixelFormat getPixelFormat() {
		return pixel_format;
	}

	long getWindow() {
		return window.get();
	}

	@Override
	protected void doLockAndInitHandle() {
	}

	@Override
	protected void doUnlock() {
	}

}
