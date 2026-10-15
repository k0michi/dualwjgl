package org.lwjgl.opengl;

import org.lwjgl.PointerWrapperAbstract;

public final class AMDDebugOutputCallback extends PointerWrapperAbstract {
	public AMDDebugOutputCallback() {
		super((long) 0L);
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public AMDDebugOutputCallback(AMDDebugOutputCallback.Handler handler) {
		super((long) 0L);
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static interface Handler {
		void handleMessage(int id, int category, int severity, String message);
	}
}
