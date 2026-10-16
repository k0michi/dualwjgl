package org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Into;

/** LWJGL 2's glDebugMessageCallback: CallbackUtil's fixed function, with the Handler's reference as userParam. */
@Into(GL43.class)
final class GL43DebugFragment {

	public static void glDebugMessageCallback(KHRDebugCallback callback) {
		long userParam = callback == null ? 0 : CallbackUtil.createGlobalRef(callback.getHandler());
		CallbackUtil.registerContextCallbackKHR(userParam);
		GL43.nglDebugMessageCallback(callback == null ? 0 : callback.getPointer(), userParam);
	}

}
