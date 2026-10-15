package org.lwjgl.opengl;

import org.lwjgl.LWJGLException;
import org.lwjgl.PointerBuffer;

abstract class DrawableGL implements DrawableLWJGL {
	protected PixelFormat pixel_format;
	protected PeerInfo peer_info;
	protected ContextGL context;

	protected DrawableGL() {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public void setPixelFormat(PixelFormatLWJGL pf) throws LWJGLException {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public void setPixelFormat(PixelFormatLWJGL pf, ContextAttribs attribs) throws LWJGLException {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public PixelFormatLWJGL getPixelFormat() {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public ContextGL getContext() {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public ContextGL createSharedContext() throws LWJGLException {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public void checkGLError() {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public void setSwapInterval(int swap_interval) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public void swapBuffers() throws LWJGLException {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public void initContext(float r, float g, float b) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public boolean isCurrent() throws LWJGLException {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public void makeCurrent() throws LWJGLException {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public void releaseContext() throws LWJGLException {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public void destroy() {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public void setCLSharingProperties(PointerBuffer properties) throws LWJGLException {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	protected final void checkDestroyed() {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
}
