package com.koyomiji.dualwjgl.generated.org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;

public final class EXTSecondaryColor {
	public static void glSecondaryColorPointerEXT(int size, int stride, DoubleBuffer pPointer) {
		org.lwjgl.opengl.EXTSecondaryColor.glSecondaryColorPointerEXT(size, 5130, stride, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(pPointer), (org.lwjgl.system.Checks.remainingSafe(pPointer) << 3)));
	}
	public static void glSecondaryColorPointerEXT(int size, int stride, FloatBuffer pPointer) {
		org.lwjgl.opengl.EXTSecondaryColor.glSecondaryColorPointerEXT(size, 5126, stride, pPointer);
	}
	public static void glSecondaryColorPointerEXT(int size, boolean unsigned, int stride, ByteBuffer pPointer) {
		org.lwjgl.opengl.EXTSecondaryColor.glSecondaryColorPointerEXT(size, (unsigned ? 5121 : 5120), stride, pPointer);
	}
}
