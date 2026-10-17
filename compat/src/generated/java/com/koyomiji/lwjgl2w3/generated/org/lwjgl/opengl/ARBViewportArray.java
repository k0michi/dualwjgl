package com.koyomiji.lwjgl2w3.generated.org.lwjgl.opengl;

import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public final class ARBViewportArray {
	public static final int GL_FIRST_VERTEX_CONVENTION = 0x8E4D;
	public static final int GL_LAST_VERTEX_CONVENTION = 0x8E4E;
	public static final int GL_PROVOKING_VERTEX = 0x8E4F;
	public static void glViewportArray(int first, FloatBuffer v) {
		org.lwjgl.opengl.ARBViewportArray.glViewportArrayv(first, v);
	}
	public static void glViewportIndexed(int index, FloatBuffer v) {
		org.lwjgl.opengl.ARBViewportArray.glViewportIndexedfv(index, v);
	}
	public static void glScissorArray(int first, IntBuffer v) {
		org.lwjgl.opengl.ARBViewportArray.glScissorArrayv(first, v);
	}
	public static void glScissorIndexed(int index, IntBuffer v) {
		org.lwjgl.opengl.ARBViewportArray.glScissorIndexedv(index, v);
	}
	public static void glDepthRangeArray(int first, DoubleBuffer v) {
		org.lwjgl.opengl.ARBViewportArray.glDepthRangeArrayv(first, v);
	}
	public static void glGetFloat(int target, int index, FloatBuffer data) {
		org.lwjgl.opengl.ARBViewportArray.glGetFloati_v(target, index, data);
	}
	public static float glGetFloat(int target, int index) {
		return org.lwjgl.opengl.ARBViewportArray.glGetFloati(target, index);
	}
	public static void glGetDouble(int target, int index, DoubleBuffer data) {
		org.lwjgl.opengl.ARBViewportArray.glGetDoublei_v(target, index, data);
	}
	public static double glGetDouble(int target, int index) {
		return org.lwjgl.opengl.ARBViewportArray.glGetDoublei(target, index);
	}
	public static void glGetIntegerIndexedEXT(int target, int index, IntBuffer v) {
		org.lwjgl.opengl.EXTDirectStateAccess.glGetIntegerIndexedvEXT(target, index, v);
	}
	public static int glGetIntegerIndexedEXT(int target, int index) {
		return org.lwjgl.opengl.EXTDirectStateAccess.glGetIntegerIndexedEXT(target, index);
	}
	public static void glEnableIndexedEXT(int target, int index) {
		org.lwjgl.opengl.EXTDirectStateAccess.glEnableIndexedEXT(target, index);
	}
	public static void glDisableIndexedEXT(int target, int index) {
		org.lwjgl.opengl.EXTDirectStateAccess.glDisableIndexedEXT(target, index);
	}
	public static boolean glIsEnabledIndexedEXT(int target, int index) {
		return org.lwjgl.opengl.EXTDirectStateAccess.glIsEnabledIndexedEXT(target, index);
	}
}
