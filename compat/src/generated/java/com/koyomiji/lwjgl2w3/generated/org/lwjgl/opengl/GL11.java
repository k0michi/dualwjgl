package com.koyomiji.lwjgl2w3.generated.org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Todo;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

public final class GL11 {
	public static final int GL_CONSTANT_COLOR = 0x8001;
	public static final int GL_ONE_MINUS_CONSTANT_COLOR = 0x8002;
	public static final int GL_CONSTANT_ALPHA = 0x8003;
	public static final int GL_ONE_MINUS_CONSTANT_ALPHA = 0x8004;
	public static final int GL_ALL_CLIENT_ATTRIB_BITS = 0xFFFFFFFF;
	public static void glColorPointer(int size, int stride, DoubleBuffer pointer) {
		org.lwjgl.opengl.GL11.nglColorPointer(size, 5130, stride, org.lwjgl.system.MemoryUtil.memAddressSafe(pointer));
	}
	public static void glColorPointer(int size, int stride, FloatBuffer pointer) {
		org.lwjgl.opengl.GL11.nglColorPointer(size, 5126, stride, org.lwjgl.system.MemoryUtil.memAddressSafe(pointer));
	}
	public static void glColorPointer(int size, boolean unsigned, int stride, ByteBuffer pointer) {
		org.lwjgl.opengl.GL11.nglColorPointer(size, (unsigned ? 5121 : 5120), stride, org.lwjgl.system.MemoryUtil.memAddress(pointer));
	}
	public static void glDrawElements(int mode, int count, int type, ByteBuffer indices) {
		org.lwjgl.opengl.GL11.nglDrawElements(mode, count, type, org.lwjgl.system.MemoryUtil.memAddressSafe(indices));
	}
	public static void glGetPixelMap(int map, FloatBuffer values) {
		org.lwjgl.opengl.GL11.glGetPixelMapfv(map, values);
	}
	public static void glGetPixelMapu(int map, IntBuffer values) {
		org.lwjgl.opengl.GL11.glGetPixelMapuiv(map, values);
	}
	public static void glGetPixelMapu(int map, ShortBuffer values) {
		org.lwjgl.opengl.GL11.glGetPixelMapusv(map, values);
	}
	public static void glGetMaterial(int face, int pname, FloatBuffer params) {
		org.lwjgl.opengl.GL11.glGetMaterialfv(face, pname, params);
	}
	public static void glGetMaterial(int face, int pname, IntBuffer params) {
		org.lwjgl.opengl.GL11.glGetMaterialiv(face, pname, params);
	}
	public static void glGetMap(int target, int query, FloatBuffer v) {
		org.lwjgl.opengl.GL11.glGetMapfv(target, query, v);
	}
	public static void glGetMap(int target, int query, DoubleBuffer v) {
		org.lwjgl.opengl.GL11.glGetMapdv(target, query, v);
	}
	public static void glGetMap(int target, int query, IntBuffer v) {
		org.lwjgl.opengl.GL11.glGetMapiv(target, query, v);
	}
	public static void glGetLight(int light, int pname, FloatBuffer params) {
		org.lwjgl.opengl.GL11.glGetLightfv(light, pname, params);
	}
	public static void glGetLight(int light, int pname, IntBuffer params) {
		org.lwjgl.opengl.GL11.glGetLightiv(light, pname, params);
	}
	public static void glGetBoolean(int pname, ByteBuffer params) {
		org.lwjgl.opengl.GL11.glGetBooleanv(pname, params);
	}
	public static void glGetDouble(int pname, DoubleBuffer params) {
		org.lwjgl.opengl.GL11.glGetDoublev(pname, params);
	}
	public static void glGetFloat(int pname, FloatBuffer params) {
		org.lwjgl.opengl.GL11.glGetFloatv(pname, params);
	}
	public static void glGetInteger(int pname, IntBuffer params) {
		org.lwjgl.opengl.GL11.glGetIntegerv(pname, params);
	}
	public static void glFog(int pname, FloatBuffer params) {
		org.lwjgl.opengl.GL11.glFogfv(pname, params);
	}
	public static void glFog(int pname, IntBuffer params) {
		org.lwjgl.opengl.GL11.glFogiv(pname, params);
	}
	@Todo("gl")
	public static ByteBuffer glGetPointer(int pname, long result_size) {
		throw new UnsupportedOperationException();
	}
	public static void glGetTexParameter(int target, int pname, FloatBuffer params) {
		org.lwjgl.opengl.GL11.glGetTexParameterfv(target, pname, params);
	}
	public static void glGetTexParameter(int target, int pname, IntBuffer params) {
		org.lwjgl.opengl.GL11.glGetTexParameteriv(target, pname, params);
	}
	public static void glGetTexLevelParameter(int target, int level, int pname, FloatBuffer params) {
		org.lwjgl.opengl.GL11.glGetTexLevelParameterfv(target, level, pname, params);
	}
	public static void glGetTexLevelParameter(int target, int level, int pname, IntBuffer params) {
		org.lwjgl.opengl.GL11.glGetTexLevelParameteriv(target, level, pname, params);
	}
	public static void glGetTexGen(int coord, int pname, IntBuffer params) {
		org.lwjgl.opengl.GL11.glGetTexGeniv(coord, pname, params);
	}
	public static void glGetTexGen(int coord, int pname, FloatBuffer params) {
		org.lwjgl.opengl.GL11.glGetTexGenfv(coord, pname, params);
	}
	public static void glGetTexGen(int coord, int pname, DoubleBuffer params) {
		org.lwjgl.opengl.GL11.glGetTexGendv(coord, pname, params);
	}
	public static void glGetTexEnv(int coord, int pname, IntBuffer params) {
		org.lwjgl.opengl.GL11.glGetTexEnviv(coord, pname, params);
	}
	public static void glGetTexEnv(int coord, int pname, FloatBuffer params) {
		org.lwjgl.opengl.GL11.glGetTexEnvfv(coord, pname, params);
	}
	public static void glMaterial(int face, int pname, FloatBuffer params) {
		org.lwjgl.opengl.GL11.glMaterialfv(face, pname, params);
	}
	public static void glMaterial(int face, int pname, IntBuffer params) {
		org.lwjgl.opengl.GL11.glMaterialiv(face, pname, params);
	}
	public static void glLoadMatrix(FloatBuffer m) {
		org.lwjgl.opengl.GL11.glLoadMatrixf(m);
	}
	public static void glLoadMatrix(DoubleBuffer m) {
		org.lwjgl.opengl.GL11.glLoadMatrixd(m);
	}
	public static void glLightModel(int pname, FloatBuffer params) {
		org.lwjgl.opengl.GL11.glLightModelfv(pname, params);
	}
	public static void glLightModel(int pname, IntBuffer params) {
		org.lwjgl.opengl.GL11.glLightModeliv(pname, params);
	}
	public static void glLight(int light, int pname, FloatBuffer params) {
		org.lwjgl.opengl.GL11.glLightfv(light, pname, params);
	}
	public static void glLight(int light, int pname, IntBuffer params) {
		org.lwjgl.opengl.GL11.glLightiv(light, pname, params);
	}
	public static void glPixelMap(int map, FloatBuffer values) {
		org.lwjgl.opengl.GL11.glPixelMapfv(map, values);
	}
	public static void glPixelMapu(int map, IntBuffer values) {
		org.lwjgl.opengl.GL11.glPixelMapuiv(map, values);
	}
	public static void glPixelMapu(int map, ShortBuffer values) {
		org.lwjgl.opengl.GL11.glPixelMapusv(map, values);
	}
	public static void glNormalPointer(int stride, ByteBuffer pointer) {
		org.lwjgl.opengl.GL11.nglNormalPointer(5120, stride, org.lwjgl.system.MemoryUtil.memAddressSafe(pointer));
	}
	public static void glNormalPointer(int stride, DoubleBuffer pointer) {
		org.lwjgl.opengl.GL11.nglNormalPointer(5130, stride, org.lwjgl.system.MemoryUtil.memAddressSafe(pointer));
	}
	public static void glNormalPointer(int stride, FloatBuffer pointer) {
		org.lwjgl.opengl.GL11.nglNormalPointer(5126, stride, org.lwjgl.system.MemoryUtil.memAddressSafe(pointer));
	}
	public static void glNormalPointer(int stride, IntBuffer pointer) {
		org.lwjgl.opengl.GL11.nglNormalPointer(5124, stride, org.lwjgl.system.MemoryUtil.memAddressSafe(pointer));
	}
	public static void glMultMatrix(FloatBuffer m) {
		org.lwjgl.opengl.GL11.glMultMatrixf(m);
	}
	public static void glMultMatrix(DoubleBuffer m) {
		org.lwjgl.opengl.GL11.glMultMatrixd(m);
	}
	public static void glReadPixels(int x, int y, int width, int height, int format, int type, DoubleBuffer pixels) {
		org.lwjgl.opengl.GL11.nglReadPixels(x, y, width, height, format, type, org.lwjgl.system.MemoryUtil.memAddressSafe(pixels));
	}
	public static void glVertexPointer(int size, int stride, DoubleBuffer pointer) {
		org.lwjgl.opengl.GL11.nglVertexPointer(size, 5130, stride, org.lwjgl.system.MemoryUtil.memAddressSafe(pointer));
	}
	public static void glVertexPointer(int size, int stride, FloatBuffer pointer) {
		org.lwjgl.opengl.GL11.nglVertexPointer(size, 5126, stride, org.lwjgl.system.MemoryUtil.memAddressSafe(pointer));
	}
	public static void glVertexPointer(int size, int stride, IntBuffer pointer) {
		org.lwjgl.opengl.GL11.nglVertexPointer(size, 5124, stride, org.lwjgl.system.MemoryUtil.memAddressSafe(pointer));
	}
	public static void glVertexPointer(int size, int stride, ShortBuffer pointer) {
		org.lwjgl.opengl.GL11.nglVertexPointer(size, 5122, stride, org.lwjgl.system.MemoryUtil.memAddressSafe(pointer));
	}
	public static void glTexParameter(int target, int pname, FloatBuffer param) {
		org.lwjgl.opengl.GL11.glTexParameterfv(target, pname, param);
	}
	public static void glTexParameter(int target, int pname, IntBuffer param) {
		org.lwjgl.opengl.GL11.glTexParameteriv(target, pname, param);
	}
	public static void glTexGen(int coord, int pname, FloatBuffer params) {
		org.lwjgl.opengl.GL11.glTexGenfv(coord, pname, params);
	}
	public static void glTexGen(int coord, int pname, DoubleBuffer params) {
		org.lwjgl.opengl.GL11.glTexGendv(coord, pname, params);
	}
	public static void glTexGen(int coord, int pname, IntBuffer params) {
		org.lwjgl.opengl.GL11.glTexGeniv(coord, pname, params);
	}
	public static void glTexEnv(int target, int pname, FloatBuffer params) {
		org.lwjgl.opengl.GL11.glTexEnvfv(target, pname, params);
	}
	public static void glTexEnv(int target, int pname, IntBuffer params) {
		org.lwjgl.opengl.GL11.glTexEnviv(target, pname, params);
	}
	public static void glTexCoordPointer(int size, int stride, DoubleBuffer pointer) {
		org.lwjgl.opengl.GL11.nglTexCoordPointer(size, 5130, stride, org.lwjgl.system.MemoryUtil.memAddressSafe(pointer));
	}
	public static void glTexCoordPointer(int size, int stride, FloatBuffer pointer) {
		org.lwjgl.opengl.GL11.nglTexCoordPointer(size, 5126, stride, org.lwjgl.system.MemoryUtil.memAddressSafe(pointer));
	}
	public static void glTexCoordPointer(int size, int stride, IntBuffer pointer) {
		org.lwjgl.opengl.GL11.nglTexCoordPointer(size, 5124, stride, org.lwjgl.system.MemoryUtil.memAddressSafe(pointer));
	}
	public static void glTexCoordPointer(int size, int stride, ShortBuffer pointer) {
		org.lwjgl.opengl.GL11.nglTexCoordPointer(size, 5122, stride, org.lwjgl.system.MemoryUtil.memAddressSafe(pointer));
	}
}
