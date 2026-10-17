package com.koyomiji.dualwjgl.generated.org.lwjgl.opengl;

import com.koyomiji.dualwjgl.inject.Hidden;
import com.koyomiji.dualwjgl.inject.Todo;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public final class NVPathRendering {
	public static final int GL_PRIMARY_COLOR = 0x8577;
	public static final int GL_GLYPH_HAS_KERNING_NV = 0x100;
	public static final int GL_FONT_X_MIN_BOUNDS_NV = 0x10000;
	public static final int GL_FONT_Y_MIN_BOUNDS_NV = 0x20000;
	public static final int GL_FONT_X_MAX_BOUNDS_NV = 0x40000;
	public static final int GL_FONT_Y_MAX_BOUNDS_NV = 0x80000;
	public static final int GL_FONT_UNITS_PER_EM_NV = 0x100000;
	public static final int GL_FONT_ASCENDER_NV = 0x200000;
	public static final int GL_FONT_DESCENDER_NV = 0x400000;
	public static final int GL_FONT_HEIGHT_NV = 0x800000;
	public static final int GL_FONT_MAX_ADVANCE_WIDTH_NV = 0x1000000;
	public static final int GL_FONT_MAX_ADVANCE_HEIGHT_NV = 0x2000000;
	public static final int GL_FONT_UNDERLINE_POSITION_NV = 0x4000000;
	public static final int GL_FONT_UNDERLINE_THICKNESS_NV = 0x8000000;
	public static final int GL_FONT_HAS_KERNING_NV = 0x10000000;
	public static void glPathParameterNV(int path, int pname, IntBuffer value) {
		org.lwjgl.opengl.NVPathRendering.glPathParameterivNV(path, pname, value);
	}
	public static void glPathParameterNV(int path, int pname, FloatBuffer value) {
		org.lwjgl.opengl.NVPathRendering.glPathParameterfvNV(path, pname, value);
	}
	@Hidden
	@Todo("gl")
	public static void glPathStencilDepthOffsetNV(float factor, int units) {
		throw new UnsupportedOperationException();
	}
	@Todo("gl")
	public static void glPathTexGenNV(int texCoordSet, int genMode, FloatBuffer coeffs) {
		throw new UnsupportedOperationException();
	}
	public static void glGetPathParameterNV(int name, int param, IntBuffer value) {
		org.lwjgl.opengl.NVPathRendering.glGetPathParameterivNV(name, param, value);
	}
	public static void glGetPathColorGenNV(int color, int pname, IntBuffer value) {
		org.lwjgl.opengl.NVPathRendering.glGetPathColorGenivNV(color, pname, value);
	}
	public static void glGetPathColorGenNV(int color, int pname, FloatBuffer value) {
		org.lwjgl.opengl.NVPathRendering.glGetPathColorGenfvNV(color, pname, value);
	}
	public static void glGetPathTexGenNV(int texCoordSet, int pname, IntBuffer value) {
		org.lwjgl.opengl.NVPathRendering.glGetPathTexGenivNV(texCoordSet, pname, value);
	}
	public static void glGetPathTexGenNV(int texCoordSet, int pname, FloatBuffer value) {
		org.lwjgl.opengl.NVPathRendering.glGetPathTexGenfvNV(texCoordSet, pname, value);
	}
}
