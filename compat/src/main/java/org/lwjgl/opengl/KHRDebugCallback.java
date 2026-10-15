package org.lwjgl.opengl;

import org.lwjgl.PointerWrapperAbstract;

public final class KHRDebugCallback extends PointerWrapperAbstract {
	public KHRDebugCallback() {
		super((long) 0L);
		// TODO(gl)
		throw new UnsupportedOperationException();
	}
	public KHRDebugCallback(KHRDebugCallback.Handler handler) {
		super((long) 0L);
		// TODO(gl)
		throw new UnsupportedOperationException();
	}

	public static interface Handler {
		void handleMessage(int source, int type, int id, int severity, String message);
	}
}
