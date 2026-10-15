package com.koyomiji.lwjgl2w3.generated.org.lwjgl.opengl;

import java.nio.LongBuffer;

public final class ARBClearTexture {
	public static void glClearTexImage(int texture, int level, int format, int type, LongBuffer data) {
		org.lwjgl.opengl.ARBClearTexture.nglClearTexImage(texture, level, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(data));
	}
	public static void glClearTexSubImage(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, LongBuffer data) {
		org.lwjgl.opengl.ARBClearTexture.nglClearTexSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(data));
	}
}
