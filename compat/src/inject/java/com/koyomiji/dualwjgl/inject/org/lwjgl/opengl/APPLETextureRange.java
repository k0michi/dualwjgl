package com.koyomiji.dualwjgl.inject.org.lwjgl.opengl;

import org.lwjgl.system.MemoryUtil;

import java.nio.Buffer;

// TODO(verify): hand-written; DelegationTest only compares generated members.
public final class APPLETextureRange {

	/** LWJGL 2 wraps the pointer in a buffer of {@code result_size} bytes, or returns null for a null pointer. */
	public static Buffer glGetTexParameterPointervAPPLE(int target, int pname, long result_size) {
		return MemoryUtil.memByteBufferSafe(org.lwjgl.opengl.APPLETextureRange.glGetTexParameterPointervAPPLE(target, pname), (int)result_size);
	}

}
