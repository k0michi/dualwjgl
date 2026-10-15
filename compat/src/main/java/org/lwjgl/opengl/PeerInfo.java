package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import org.lwjgl.LWJGLException;

abstract class PeerInfo {
	protected PeerInfo(ByteBuffer handle) {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public final void unlock() throws LWJGLException {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	protected abstract void doLockAndInitHandle() throws LWJGLException;

	protected abstract void doUnlock() throws LWJGLException;

	public final ByteBuffer lockAndGetHandle() throws LWJGLException {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	protected final ByteBuffer getHandle() {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public void destroy() {
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
}
