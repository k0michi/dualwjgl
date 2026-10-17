package org.lwjgl.opengl;

import com.koyomiji.dualwjgl.inject.Into;

/** LWJGL 2's KHRDebug.glDebugMessageCallback, which was GL43's. */
@Into(KHRDebug.class)
final class KHRDebugFragment {

	public static void glDebugMessageCallback(KHRDebugCallback callback) {
		long userParam = callback == null ? 0 : CallbackUtil.createGlobalRef(callback.getHandler());
		CallbackUtil.registerContextCallbackKHR(userParam);
		// the pointer is CallbackUtil's fixed function, an LWJGL 3 callback: create(pointer) finds it
		KHRDebug.glDebugMessageCallback(callback == null ? null : GLDebugMessageCallback.create(callback.getPointer()), userParam);
	}

}
