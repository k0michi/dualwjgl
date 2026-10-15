package com.koyomiji.lwjgl2w3.generated.org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Todo;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

public final class ARBVertexBlend {
	public static void glWeightARB(ByteBuffer pWeights) {
		org.lwjgl.opengl.ARBVertexBlend.glWeightbvARB(pWeights);
	}
	public static void glWeightARB(ShortBuffer pWeights) {
		org.lwjgl.opengl.ARBVertexBlend.glWeightsvARB(pWeights);
	}
	public static void glWeightARB(IntBuffer pWeights) {
		org.lwjgl.opengl.ARBVertexBlend.glWeightivARB(pWeights);
	}
	public static void glWeightARB(FloatBuffer pWeights) {
		org.lwjgl.opengl.ARBVertexBlend.glWeightfvARB(pWeights);
	}
	public static void glWeightARB(DoubleBuffer pWeights) {
		org.lwjgl.opengl.ARBVertexBlend.glWeightdvARB(pWeights);
	}
	public static void glWeightuARB(ByteBuffer pWeights) {
		org.lwjgl.opengl.ARBVertexBlend.glWeightubvARB(pWeights);
	}
	public static void glWeightuARB(ShortBuffer pWeights) {
		org.lwjgl.opengl.ARBVertexBlend.glWeightusvARB(pWeights);
	}
	public static void glWeightuARB(IntBuffer pWeights) {
		org.lwjgl.opengl.ARBVertexBlend.glWeightuivARB(pWeights);
	}
	@Todo("gl")
	public static void glWeightPointerARB(int size, int stride, DoubleBuffer pPointer) {
		throw new UnsupportedOperationException();
	}
	@Todo("gl")
	public static void glWeightPointerARB(int size, int stride, FloatBuffer pPointer) {
		throw new UnsupportedOperationException();
	}
	@Todo("gl")
	public static void glWeightPointerARB(int size, boolean unsigned, int stride, ByteBuffer pPointer) {
		throw new UnsupportedOperationException();
	}
	@Todo("gl")
	public static void glWeightPointerARB(int size, boolean unsigned, int stride, IntBuffer pPointer) {
		throw new UnsupportedOperationException();
	}
	@Todo("gl")
	public static void glWeightPointerARB(int size, boolean unsigned, int stride, ShortBuffer pPointer) {
		throw new UnsupportedOperationException();
	}
}
