package com.koyomiji.lwjgl2w3.generated.org.lwjgl.opengl;

public final class ARBDrawBuffers {
	public static void glDrawBuffersARB(int buffer) {
		try (org.lwjgl.system.MemoryStack __stack = org.lwjgl.system.MemoryStack.stackPush()) {
			java.nio.IntBuffer __v0 = __stack.ints(buffer);
			org.lwjgl.opengl.ARBDrawBuffers.glDrawBuffersARB(__v0);
		}
	}
}
