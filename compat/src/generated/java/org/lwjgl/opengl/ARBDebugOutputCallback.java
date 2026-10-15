package org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Generated;
import com.koyomiji.lwjgl2w3.inject.Todo;
import org.lwjgl.PointerWrapperAbstract;

@Generated
public final class ARBDebugOutputCallback extends PointerWrapperAbstract {
	@Todo("gl")
	public ARBDebugOutputCallback() {
		super((long) 0L);
		throw new UnsupportedOperationException();
	}
	@Todo("gl")
	public ARBDebugOutputCallback(ARBDebugOutputCallback.Handler handler) {
		super((long) 0L);
		throw new UnsupportedOperationException();
	}

	@Generated
	public static interface Handler {
		void handleMessage(int source, int type, int id, int severity, String message);
	}
}
