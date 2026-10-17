package org.lwjgl.opencl;

/**
 * DEVIATION(out-of-scope): LWJGL 3 has no APPLE_SetMemObjectDestructor, so this is LWJGL 2's class where the
 * implementation lacked the extension. CL11.clSetMemObjectDestructorCallback is the core function.
 */
public final class APPLESetMemObjectDestructor {

	private APPLESetMemObjectDestructor() {
	}

	public static int clSetMemObjectDestructorAPPLE(CLMem memobj, CLMemObjectDestructorCallback pfn_notify) {
		throw new IllegalStateException("Function is not supported");
	}

}
