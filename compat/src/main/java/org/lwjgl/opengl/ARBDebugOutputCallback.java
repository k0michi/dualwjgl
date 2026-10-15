package org.lwjgl.opengl;

import org.lwjgl.PointerWrapperAbstract;

public final class ARBDebugOutputCallback extends PointerWrapperAbstract {
	public ARBDebugOutputCallback() {
		super((long) 0L);
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public ARBDebugOutputCallback(ARBDebugOutputCallback.Handler handler) {
		super((long) 0L);
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static interface Handler {
		void handleMessage(int source, int type, int id, int severity, String message);
	}
}
