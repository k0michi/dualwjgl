package org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Into;

/** LWJGL 2's glDebugMessageCallbackAMD: CallbackUtil's fixed function, with the Handler's reference as userParam. */
@Into(AMDDebugOutput.class)
final class AMDDebugOutputFragment {

	public static void glDebugMessageCallbackAMD(AMDDebugOutputCallback callback) {
		long userParam = callback == null ? 0 : CallbackUtil.createGlobalRef(callback.getHandler());
		CallbackUtil.registerContextCallbackAMD(userParam);
		AMDDebugOutput.nglDebugMessageCallbackAMD(callback == null ? 0 : callback.getPointer(), userParam);
	}

}
