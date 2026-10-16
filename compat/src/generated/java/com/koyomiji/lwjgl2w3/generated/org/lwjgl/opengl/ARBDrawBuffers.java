package com.koyomiji.lwjgl2w3.generated.org.lwjgl.opengl;

public final class ARBDrawBuffers {
	public static void glDrawBuffersARB(int buffer) {
		try (org.lwjgl.system.MemoryStack __stack = org.lwjgl.system.MemoryStack.stackPush()) {
			org.lwjgl.opengl.ARBDrawBuffers.nglDrawBuffersARB(1, org.lwjgl.system.MemoryUtil.memAddress(__stack.ints(buffer)));
		}
	}
}
