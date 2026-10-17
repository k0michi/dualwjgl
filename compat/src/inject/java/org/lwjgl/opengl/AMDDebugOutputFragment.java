package org.lwjgl.opengl;

import com.koyomiji.dualwjgl.inject.Into;

/** LWJGL 2's glDebugMessageCallbackAMD: CallbackUtil's fixed function, with the Handler's reference as userParam. */
@Into(AMDDebugOutput.class)
final class AMDDebugOutputFragment {

	public static void glDebugMessageCallbackAMD(AMDDebugOutputCallback callback) {
		long userParam = callback == null ? 0 : CallbackUtil.createGlobalRef(callback.getHandler());
		CallbackUtil.registerContextCallbackAMD(userParam);
		// the pointer is CallbackUtil's fixed function, an LWJGL 3 callback: create(pointer) finds it
		AMDDebugOutput.glDebugMessageCallbackAMD(callback == null ? null : GLDebugMessageAMDCallback.create(callback.getPointer()), userParam);
	}

}
