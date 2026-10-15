package com.koyomiji.lwjgl2w3.generated.org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Todo;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;

public final class EXTSecondaryColor {
	public static void glSecondaryColorPointerEXT(int size, int stride, DoubleBuffer pPointer) {
		org.lwjgl.opengl.EXTSecondaryColor.nglSecondaryColorPointerEXT(size, 5130, stride, org.lwjgl.system.MemoryUtil.memAddressSafe(pPointer));
	}
	public static void glSecondaryColorPointerEXT(int size, int stride, FloatBuffer pPointer) {
		org.lwjgl.opengl.EXTSecondaryColor.nglSecondaryColorPointerEXT(size, 5126, stride, org.lwjgl.system.MemoryUtil.memAddressSafe(pPointer));
	}
	@Todo("gl")
	public static void glSecondaryColorPointerEXT(int size, boolean unsigned, int stride, ByteBuffer pPointer) {
		throw new UnsupportedOperationException();
	}
}
