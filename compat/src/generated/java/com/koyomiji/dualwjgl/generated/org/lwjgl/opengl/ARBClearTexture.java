package com.koyomiji.dualwjgl.generated.org.lwjgl.opengl;

import java.nio.LongBuffer;

public final class ARBClearTexture {
	public static void glClearTexImage(int texture, int level, int format, int type, LongBuffer data) {
		org.lwjgl.opengl.ARBClearTexture.glClearTexImage(texture, level, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(data), (org.lwjgl.system.Checks.remainingSafe(data) << 3)));
	}
	public static void glClearTexSubImage(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, LongBuffer data) {
		org.lwjgl.opengl.ARBClearTexture.glClearTexSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(data), (org.lwjgl.system.Checks.remainingSafe(data) << 3)));
	}
}
