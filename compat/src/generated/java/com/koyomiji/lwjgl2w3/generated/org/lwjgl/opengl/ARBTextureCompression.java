package com.koyomiji.lwjgl2w3.generated.org.lwjgl.opengl;

import java.nio.ByteBuffer;

public final class ARBTextureCompression {
	public static void glCompressedTexImage1DARB(int target, int level, int internalformat, int width, int border, ByteBuffer pData) {
		org.lwjgl.opengl.ARBTextureCompression.nglCompressedTexImage1DARB(target, level, internalformat, width, border, org.lwjgl.system.Checks.remainingSafe(pData), org.lwjgl.system.MemoryUtil.memAddressSafe(pData));
	}
	public static void glCompressedTexImage2DARB(int target, int level, int internalformat, int width, int height, int border, ByteBuffer pData) {
		org.lwjgl.opengl.ARBTextureCompression.nglCompressedTexImage2DARB(target, level, internalformat, width, height, border, org.lwjgl.system.Checks.remainingSafe(pData), org.lwjgl.system.MemoryUtil.memAddressSafe(pData));
	}
	public static void glCompressedTexImage3DARB(int target, int level, int internalformat, int width, int height, int depth, int border, ByteBuffer pData) {
		org.lwjgl.opengl.ARBTextureCompression.nglCompressedTexImage3DARB(target, level, internalformat, width, height, depth, border, org.lwjgl.system.Checks.remainingSafe(pData), org.lwjgl.system.MemoryUtil.memAddressSafe(pData));
	}
}
