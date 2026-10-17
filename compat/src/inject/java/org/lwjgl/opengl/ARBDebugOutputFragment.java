package org.lwjgl.opengl;

import com.koyomiji.dualwjgl.inject.Into;

/** LWJGL 2's glDebugMessageCallbackARB: CallbackUtil's fixed function, with the Handler's reference as userParam. */
@Into(ARBDebugOutput.class)
final class ARBDebugOutputFragment {

	public static void glDebugMessageCallbackARB(ARBDebugOutputCallback callback) {
		long userParam = callback == null ? 0 : CallbackUtil.createGlobalRef(callback.getHandler());
		CallbackUtil.registerContextCallbackARB(userParam);
		// the pointer is CallbackUtil's fixed function, an LWJGL 3 callback: create(pointer) finds it
		ARBDebugOutput.glDebugMessageCallbackARB(callback == null ? null : GLDebugMessageARBCallback.create(callback.getPointer()), userParam);
	}

}
