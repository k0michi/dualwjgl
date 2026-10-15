package org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Generated;
import com.koyomiji.lwjgl2w3.inject.Todo;
import org.lwjgl.PointerWrapperAbstract;

@Generated
public final class AMDDebugOutputCallback extends PointerWrapperAbstract {
	@Todo("gl")
	public AMDDebugOutputCallback() {
		super((long) 0L);
		throw new UnsupportedOperationException();
	}
	@Todo("gl")
	public AMDDebugOutputCallback(AMDDebugOutputCallback.Handler handler) {
		super((long) 0L);
		throw new UnsupportedOperationException();
	}

	@Generated
	public static interface Handler {
		void handleMessage(int id, int category, int severity, String message);
	}
}
