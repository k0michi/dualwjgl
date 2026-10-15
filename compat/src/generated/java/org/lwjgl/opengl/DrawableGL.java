package org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Generated;
import com.koyomiji.lwjgl2w3.inject.Todo;
import org.lwjgl.LWJGLException;
import org.lwjgl.PointerBuffer;

@Generated
abstract class DrawableGL implements DrawableLWJGL {
	protected PixelFormat pixel_format;
	protected PeerInfo peer_info;
	protected ContextGL context;

	@Todo("gl")
	protected DrawableGL() {
		throw new UnsupportedOperationException();
	}

	@Todo("gl")
	public void setPixelFormat(PixelFormatLWJGL pf) throws LWJGLException {
		throw new UnsupportedOperationException();
	}

	@Todo("gl")
	public void setPixelFormat(PixelFormatLWJGL pf, ContextAttribs attribs) throws LWJGLException {
		throw new UnsupportedOperationException();
	}

	@Todo("gl")
	public PixelFormatLWJGL getPixelFormat() {
		throw new UnsupportedOperationException();
	}

	@Todo("gl")
	public ContextGL getContext() {
		throw new UnsupportedOperationException();
	}

	@Todo("gl")
	public ContextGL createSharedContext() throws LWJGLException {
		throw new UnsupportedOperationException();
	}

	@Todo("gl")
	public void checkGLError() {
		throw new UnsupportedOperationException();
	}

	@Todo("gl")
	public void setSwapInterval(int swap_interval) {
		throw new UnsupportedOperationException();
	}

	@Todo("gl")
	public void swapBuffers() throws LWJGLException {
		throw new UnsupportedOperationException();
	}

	@Todo("gl")
	public void initContext(float r, float g, float b) {
		throw new UnsupportedOperationException();
	}

	@Todo("gl")
	public boolean isCurrent() throws LWJGLException {
		throw new UnsupportedOperationException();
	}

	@Todo("gl")
	public void makeCurrent() throws LWJGLException {
		throw new UnsupportedOperationException();
	}

	@Todo("gl")
	public void releaseContext() throws LWJGLException {
		throw new UnsupportedOperationException();
	}

	@Todo("gl")
	public void destroy() {
		throw new UnsupportedOperationException();
	}

	@Todo("gl")
	public void setCLSharingProperties(PointerBuffer properties) throws LWJGLException {
		throw new UnsupportedOperationException();
	}

	@Todo("gl")
	protected final void checkDestroyed() {
		throw new UnsupportedOperationException();
	}
}
