package org.lwjgl.opengl;

import com.koyomiji.dualwjgl.inject.Into;

/** LWJGL 2's glDebugMessageCallback: CallbackUtil's fixed function, with the Handler's reference as userParam. */
@Into(GL43.class)
final class GL43DebugFragment {

	public static void glDebugMessageCallback(KHRDebugCallback callback) {
		long userParam = callback == null ? 0 : CallbackUtil.createGlobalRef(callback.getHandler());
		CallbackUtil.registerContextCallbackKHR(userParam);
		// the pointer is CallbackUtil's fixed function, an LWJGL 3 callback: create(pointer) finds it
		GL43.glDebugMessageCallback(callback == null ? null : GLDebugMessageCallback.create(callback.getPointer()), userParam);
	}

}
