package org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Into;

/** LWJGL 2's glDebugMessageCallbackARB: CallbackUtil's fixed function, with the Handler's reference as userParam. */
@Into(ARBDebugOutput.class)
final class ARBDebugOutputFragment {

	public static void glDebugMessageCallbackARB(ARBDebugOutputCallback callback) {
		long userParam = callback == null ? 0 : CallbackUtil.createGlobalRef(callback.getHandler());
		CallbackUtil.registerContextCallbackARB(userParam);
		ARBDebugOutput.nglDebugMessageCallbackARB(callback == null ? 0 : callback.getPointer(), userParam);
	}

}
