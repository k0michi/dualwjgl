package org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Generated;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

@Generated
public final class EXTGpuShader4 {
	public static final int GL_VERTEX_ATTRIB_ARRAY_INTEGER_EXT = 0x88FD;
	public static final int GL_SAMPLER_1D_ARRAY_EXT = 0x8DC0;
	public static final int GL_SAMPLER_2D_ARRAY_EXT = 0x8DC1;
	public static final int GL_SAMPLER_BUFFER_EXT = 0x8DC2;
	public static final int GL_SAMPLER_1D_ARRAY_SHADOW_EXT = 0x8DC3;
	public static final int GL_SAMPLER_2D_ARRAY_SHADOW_EXT = 0x8DC4;
	public static final int GL_SAMPLER_CUBE_SHADOW_EXT = 0x8DC5;
	public static final int GL_UNSIGNED_INT_VEC2_EXT = 0x8DC6;
	public static final int GL_UNSIGNED_INT_VEC3_EXT = 0x8DC7;
	public static final int GL_UNSIGNED_INT_VEC4_EXT = 0x8DC8;
	public static final int GL_INT_SAMPLER_1D_EXT = 0x8DC9;
	public static final int GL_INT_SAMPLER_2D_EXT = 0x8DCA;
	public static final int GL_INT_SAMPLER_3D_EXT = 0x8DCB;
	public static final int GL_INT_SAMPLER_CUBE_EXT = 0x8DCC;
	public static final int GL_INT_SAMPLER_2D_RECT_EXT = 0x8DCD;
	public static final int GL_INT_SAMPLER_1D_ARRAY_EXT = 0x8DCE;
	public static final int GL_INT_SAMPLER_2D_ARRAY_EXT = 0x8DCF;
	public static final int GL_INT_SAMPLER_BUFFER_EXT = 0x8DD0;
	public static final int GL_UNSIGNED_INT_SAMPLER_1D_EXT = 0x8DD1;
	public static final int GL_UNSIGNED_INT_SAMPLER_2D_EXT = 0x8DD2;
	public static final int GL_UNSIGNED_INT_SAMPLER_3D_EXT = 0x8DD3;
	public static final int GL_UNSIGNED_INT_SAMPLER_CUBE_EXT = 0x8DD4;
	public static final int GL_UNSIGNED_INT_SAMPLER_2D_RECT_EXT = 0x8DD5;
	public static final int GL_UNSIGNED_INT_SAMPLER_1D_ARRAY_EXT = 0x8DD6;
	public static final int GL_UNSIGNED_INT_SAMPLER_2D_ARRAY_EXT = 0x8DD7;
	public static final int GL_UNSIGNED_INT_SAMPLER_BUFFER_EXT = 0x8DD8;
	public static final int GL_MIN_PROGRAM_TEXEL_OFFSET_EXT = 0x8904;
	public static final int GL_MAX_PROGRAM_TEXEL_OFFSET_EXT = 0x8905;

	private EXTGpuShader4() {
	}

	public static void glVertexAttribI1iEXT(int index, int x) {
		org.lwjgl.opengl.EXTGPUShader4.glVertexAttribI1iEXT(index, x);
	}

	public static void glVertexAttribI2iEXT(int index, int x, int y) {
		org.lwjgl.opengl.EXTGPUShader4.glVertexAttribI2iEXT(index, x, y);
	}

	public static void glVertexAttribI3iEXT(int index, int x, int y, int z) {
		org.lwjgl.opengl.EXTGPUShader4.glVertexAttribI3iEXT(index, x, y, z);
	}

	public static void glVertexAttribI4iEXT(int index, int x, int y, int z, int w) {
		org.lwjgl.opengl.EXTGPUShader4.glVertexAttribI4iEXT(index, x, y, z, w);
	}

	public static void glVertexAttribI1uiEXT(int index, int x) {
		org.lwjgl.opengl.EXTGPUShader4.glVertexAttribI1uiEXT(index, x);
	}

	public static void glVertexAttribI2uiEXT(int index, int x, int y) {
		org.lwjgl.opengl.EXTGPUShader4.glVertexAttribI2uiEXT(index, x, y);
	}

	public static void glVertexAttribI3uiEXT(int index, int x, int y, int z) {
		org.lwjgl.opengl.EXTGPUShader4.glVertexAttribI3uiEXT(index, x, y, z);
	}

	public static void glVertexAttribI4uiEXT(int index, int x, int y, int z, int w) {
		org.lwjgl.opengl.EXTGPUShader4.glVertexAttribI4uiEXT(index, x, y, z, w);
	}

	public static void glVertexAttribI1EXT(int index, IntBuffer v) {
		org.lwjgl.opengl.EXTGPUShader4.nglVertexAttribI1ivEXT(index, org.lwjgl.system.MemoryUtil.memAddressSafe(v));
	}

	public static void glVertexAttribI2EXT(int index, IntBuffer v) {
		org.lwjgl.opengl.EXTGPUShader4.nglVertexAttribI2ivEXT(index, org.lwjgl.system.MemoryUtil.memAddressSafe(v));
	}

	public static void glVertexAttribI3EXT(int index, IntBuffer v) {
		org.lwjgl.opengl.EXTGPUShader4.nglVertexAttribI3ivEXT(index, org.lwjgl.system.MemoryUtil.memAddressSafe(v));
	}

	public static void glVertexAttribI4EXT(int index, IntBuffer v) {
		org.lwjgl.opengl.EXTGPUShader4.nglVertexAttribI4ivEXT(index, org.lwjgl.system.MemoryUtil.memAddressSafe(v));
	}

	public static void glVertexAttribI1uEXT(int index, IntBuffer v) {
		org.lwjgl.opengl.EXTGPUShader4.nglVertexAttribI1uivEXT(index, org.lwjgl.system.MemoryUtil.memAddressSafe(v));
	}

	public static void glVertexAttribI2uEXT(int index, IntBuffer v) {
		org.lwjgl.opengl.EXTGPUShader4.nglVertexAttribI2uivEXT(index, org.lwjgl.system.MemoryUtil.memAddressSafe(v));
	}

	public static void glVertexAttribI3uEXT(int index, IntBuffer v) {
		org.lwjgl.opengl.EXTGPUShader4.nglVertexAttribI3uivEXT(index, org.lwjgl.system.MemoryUtil.memAddressSafe(v));
	}

	public static void glVertexAttribI4uEXT(int index, IntBuffer v) {
		org.lwjgl.opengl.EXTGPUShader4.nglVertexAttribI4uivEXT(index, org.lwjgl.system.MemoryUtil.memAddressSafe(v));
	}

	public static void glVertexAttribI4EXT(int index, ByteBuffer v) {
		org.lwjgl.opengl.EXTGPUShader4.nglVertexAttribI4bvEXT(index, org.lwjgl.system.MemoryUtil.memAddressSafe(v));
	}

	public static void glVertexAttribI4EXT(int index, ShortBuffer v) {
		org.lwjgl.opengl.EXTGPUShader4.nglVertexAttribI4svEXT(index, org.lwjgl.system.MemoryUtil.memAddressSafe(v));
	}

	public static void glVertexAttribI4uEXT(int index, ByteBuffer v) {
		org.lwjgl.opengl.EXTGPUShader4.nglVertexAttribI4ubvEXT(index, org.lwjgl.system.MemoryUtil.memAddressSafe(v));
	}

	public static void glVertexAttribI4uEXT(int index, ShortBuffer v) {
		org.lwjgl.opengl.EXTGPUShader4.nglVertexAttribI4usvEXT(index, org.lwjgl.system.MemoryUtil.memAddressSafe(v));
	}

	public static void glVertexAttribIPointerEXT(int index, int size, int type, int stride, ByteBuffer buffer) {
		org.lwjgl.opengl.EXTGPUShader4.glVertexAttribIPointerEXT(index, size, type, stride, buffer);
	}

	public static void glVertexAttribIPointerEXT(int index, int size, int type, int stride, IntBuffer buffer) {
		org.lwjgl.opengl.EXTGPUShader4.glVertexAttribIPointerEXT(index, size, type, stride, buffer);
	}

	public static void glVertexAttribIPointerEXT(int index, int size, int type, int stride, ShortBuffer buffer) {
		org.lwjgl.opengl.EXTGPUShader4.glVertexAttribIPointerEXT(index, size, type, stride, buffer);
	}

	public static void glVertexAttribIPointerEXT(int index, int size, int type, int stride, long buffer_buffer_offset) {
		org.lwjgl.opengl.EXTGPUShader4.glVertexAttribIPointerEXT(index, size, type, stride, buffer_buffer_offset);
	}

	public static void glGetVertexAttribIEXT(int index, int pname, IntBuffer params) {
		org.lwjgl.opengl.EXTGPUShader4.nglGetVertexAttribIivEXT(index, pname, org.lwjgl.system.MemoryUtil.memAddressSafe(params));
	}

	public static void glGetVertexAttribIuEXT(int index, int pname, IntBuffer params) {
		org.lwjgl.opengl.EXTGPUShader4.nglGetVertexAttribIuivEXT(index, pname, org.lwjgl.system.MemoryUtil.memAddressSafe(params));
	}

	public static void glUniform1uiEXT(int location, int v0) {
		org.lwjgl.opengl.EXTGPUShader4.glUniform1uiEXT(location, v0);
	}

	public static void glUniform2uiEXT(int location, int v0, int v1) {
		org.lwjgl.opengl.EXTGPUShader4.glUniform2uiEXT(location, v0, v1);
	}

	public static void glUniform3uiEXT(int location, int v0, int v1, int v2) {
		org.lwjgl.opengl.EXTGPUShader4.glUniform3uiEXT(location, v0, v1, v2);
	}

	public static void glUniform4uiEXT(int location, int v0, int v1, int v2, int v3) {
		org.lwjgl.opengl.EXTGPUShader4.glUniform4uiEXT(location, v0, v1, v2, v3);
	}

	public static void glUniform1uEXT(int location, IntBuffer value) {
		org.lwjgl.opengl.EXTGPUShader4.nglUniform1uivEXT(location, org.lwjgl.system.Checks.remainingSafe(value), org.lwjgl.system.MemoryUtil.memAddressSafe(value));
	}

	public static void glUniform2uEXT(int location, IntBuffer value) {
		org.lwjgl.opengl.EXTGPUShader4.nglUniform2uivEXT(location, (org.lwjgl.system.Checks.remainingSafe(value) >> 1), org.lwjgl.system.MemoryUtil.memAddressSafe(value));
	}

	public static void glUniform3uEXT(int location, IntBuffer value) {
		org.lwjgl.opengl.EXTGPUShader4.nglUniform3uivEXT(location, (org.lwjgl.system.Checks.remainingSafe(value) / 3), org.lwjgl.system.MemoryUtil.memAddressSafe(value));
	}

	public static void glUniform4uEXT(int location, IntBuffer value) {
		org.lwjgl.opengl.EXTGPUShader4.nglUniform4uivEXT(location, (org.lwjgl.system.Checks.remainingSafe(value) >> 2), org.lwjgl.system.MemoryUtil.memAddressSafe(value));
	}

	public static void glGetUniformuEXT(int program, int location, IntBuffer params) {
		org.lwjgl.opengl.EXTGPUShader4.nglGetUniformuivEXT(program, location, org.lwjgl.system.MemoryUtil.memAddressSafe(params));
	}

	public static void glBindFragDataLocationEXT(int program, int colorNumber, ByteBuffer name) {
		org.lwjgl.opengl.EXTGPUShader4.glBindFragDataLocationEXT(program, colorNumber, name);
	}

	public static void glBindFragDataLocationEXT(int program, int colorNumber, CharSequence name) {
		org.lwjgl.opengl.EXTGPUShader4.glBindFragDataLocationEXT(program, colorNumber, name);
	}

	public static int glGetFragDataLocationEXT(int program, ByteBuffer name) {
		return org.lwjgl.opengl.EXTGPUShader4.glGetFragDataLocationEXT(program, name);
	}

	public static int glGetFragDataLocationEXT(int program, CharSequence name) {
		return org.lwjgl.opengl.EXTGPUShader4.glGetFragDataLocationEXT(program, name);
	}
}
