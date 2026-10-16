package org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Into;

/** LWJGL 2's KHRDebug.glDebugMessageCallback, which was GL43's. */
@Into(KHRDebug.class)
final class KHRDebugFragment {

	public static void glDebugMessageCallback(KHRDebugCallback callback) {
		long userParam = callback == null ? 0 : CallbackUtil.createGlobalRef(callback.getHandler());
		CallbackUtil.registerContextCallbackKHR(userParam);
		KHRDebug.nglDebugMessageCallback(callback == null ? 0 : callback.getPointer(), userParam);
	}

}
