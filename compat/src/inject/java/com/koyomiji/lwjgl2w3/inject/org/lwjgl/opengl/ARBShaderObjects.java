package com.koyomiji.lwjgl2w3.inject.org.lwjgl.opengl;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;

import java.nio.ByteBuffer;

// TODO(verify): hand-written; DelegationTest only compares generated members.
public final class ARBShaderObjects {

	/** LWJGL 2's native took the string's address and length; LWJGL 3's takes arrays of both. */
	public static void glShaderSourceARB(int shader, ByteBuffer string) {
		try (MemoryStack stack = MemoryStack.stackPush()) {
			org.lwjgl.opengl.ARBShaderObjects.glShaderSourceARB(shader, stack.pointers(MemoryUtil.memAddress(string)), stack.ints(string.remaining()));
		}
	}
}
