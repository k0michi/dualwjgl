package org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Generated;
import com.koyomiji.lwjgl2w3.inject.Todo;
import java.nio.ByteBuffer;
import org.lwjgl.LWJGLException;

@Generated
abstract class PeerInfo {
	@Todo("gl")
	protected PeerInfo(ByteBuffer handle) {
		throw new UnsupportedOperationException();
	}

	@Todo("gl")
	public final void unlock() throws LWJGLException {
		throw new UnsupportedOperationException();
	}

	protected abstract void doLockAndInitHandle() throws LWJGLException;

	protected abstract void doUnlock() throws LWJGLException;

	@Todo("gl")
	public final ByteBuffer lockAndGetHandle() throws LWJGLException {
		throw new UnsupportedOperationException();
	}

	@Todo("gl")
	protected final ByteBuffer getHandle() {
		throw new UnsupportedOperationException();
	}

	@Todo("gl")
	public void destroy() {
		throw new UnsupportedOperationException();
	}
}
