package com.koyomiji.dualwjgl.generated.org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

public final class ARBMatrixPalette {
	public static void glMatrixIndexuARB(ByteBuffer pIndices) {
		org.lwjgl.opengl.ARBMatrixPalette.glMatrixIndexubvARB(pIndices);
	}
	public static void glMatrixIndexuARB(ShortBuffer pIndices) {
		org.lwjgl.opengl.ARBMatrixPalette.glMatrixIndexusvARB(pIndices);
	}
	public static void glMatrixIndexuARB(IntBuffer pIndices) {
		org.lwjgl.opengl.ARBMatrixPalette.glMatrixIndexuivARB(pIndices);
	}
}
