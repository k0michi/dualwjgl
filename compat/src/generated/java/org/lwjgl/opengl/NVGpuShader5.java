package org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Generated;
import java.nio.LongBuffer;

@Generated
public final class NVGpuShader5 {
	public static final int GL_INT64_NV = 0x140E;
	public static final int GL_UNSIGNED_INT64_NV = 0x140F;
	public static final int GL_INT8_NV = 0x8FE0;
	public static final int GL_INT8_VEC2_NV = 0x8FE1;
	public static final int GL_INT8_VEC3_NV = 0x8FE2;
	public static final int GL_INT8_VEC4_NV = 0x8FE3;
	public static final int GL_INT16_NV = 0x8FE4;
	public static final int GL_INT16_VEC2_NV = 0x8FE5;
	public static final int GL_INT16_VEC3_NV = 0x8FE6;
	public static final int GL_INT16_VEC4_NV = 0x8FE7;
	public static final int GL_INT64_VEC2_NV = 0x8FE9;
	public static final int GL_INT64_VEC3_NV = 0x8FEA;
	public static final int GL_INT64_VEC4_NV = 0x8FEB;
	public static final int GL_UNSIGNED_INT8_NV = 0x8FEC;
	public static final int GL_UNSIGNED_INT8_VEC2_NV = 0x8FED;
	public static final int GL_UNSIGNED_INT8_VEC3_NV = 0x8FEE;
	public static final int GL_UNSIGNED_INT8_VEC4_NV = 0x8FEF;
	public static final int GL_UNSIGNED_INT16_NV = 0x8FF0;
	public static final int GL_UNSIGNED_INT16_VEC2_NV = 0x8FF1;
	public static final int GL_UNSIGNED_INT16_VEC3_NV = 0x8FF2;
	public static final int GL_UNSIGNED_INT16_VEC4_NV = 0x8FF3;
	public static final int GL_UNSIGNED_INT64_VEC2_NV = 0x8FF5;
	public static final int GL_UNSIGNED_INT64_VEC3_NV = 0x8FF6;
	public static final int GL_UNSIGNED_INT64_VEC4_NV = 0x8FF7;
	public static final int GL_FLOAT16_NV = 0x8FF8;
	public static final int GL_FLOAT16_VEC2_NV = 0x8FF9;
	public static final int GL_FLOAT16_VEC3_NV = 0x8FFA;
	public static final int GL_FLOAT16_VEC4_NV = 0x8FFB;
	public static final int GL_PATCHES = 14;

	private NVGpuShader5() {
	}

	public static void glUniform1i64NV(int location, long x) {
		org.lwjgl.opengl.NVGPUShader5.glUniform1i64NV(location, x);
	}

	public static void glUniform2i64NV(int location, long x, long y) {
		org.lwjgl.opengl.NVGPUShader5.glUniform2i64NV(location, x, y);
	}

	public static void glUniform3i64NV(int location, long x, long y, long z) {
		org.lwjgl.opengl.NVGPUShader5.glUniform3i64NV(location, x, y, z);
	}

	public static void glUniform4i64NV(int location, long x, long y, long z, long w) {
		org.lwjgl.opengl.NVGPUShader5.glUniform4i64NV(location, x, y, z, w);
	}

	public static void glUniform1NV(int location, LongBuffer value) {
		org.lwjgl.opengl.NVGPUShader5.nglUniform1i64vNV(location, org.lwjgl.system.Checks.remainingSafe(value), org.lwjgl.system.MemoryUtil.memAddressSafe(value));
	}

	public static void glUniform2NV(int location, LongBuffer value) {
		org.lwjgl.opengl.NVGPUShader5.nglUniform2i64vNV(location, (org.lwjgl.system.Checks.remainingSafe(value) >> 1), org.lwjgl.system.MemoryUtil.memAddressSafe(value));
	}

	public static void glUniform3NV(int location, LongBuffer value) {
		org.lwjgl.opengl.NVGPUShader5.nglUniform3i64vNV(location, (org.lwjgl.system.Checks.remainingSafe(value) / 3), org.lwjgl.system.MemoryUtil.memAddressSafe(value));
	}

	public static void glUniform4NV(int location, LongBuffer value) {
		org.lwjgl.opengl.NVGPUShader5.nglUniform4i64vNV(location, (org.lwjgl.system.Checks.remainingSafe(value) >> 2), org.lwjgl.system.MemoryUtil.memAddressSafe(value));
	}

	public static void glUniform1ui64NV(int location, long x) {
		org.lwjgl.opengl.NVGPUShader5.glUniform1ui64NV(location, x);
	}

	public static void glUniform2ui64NV(int location, long x, long y) {
		org.lwjgl.opengl.NVGPUShader5.glUniform2ui64NV(location, x, y);
	}

	public static void glUniform3ui64NV(int location, long x, long y, long z) {
		org.lwjgl.opengl.NVGPUShader5.glUniform3ui64NV(location, x, y, z);
	}

	public static void glUniform4ui64NV(int location, long x, long y, long z, long w) {
		org.lwjgl.opengl.NVGPUShader5.glUniform4ui64NV(location, x, y, z, w);
	}

	public static void glUniform1uNV(int location, LongBuffer value) {
		org.lwjgl.opengl.NVGPUShader5.nglUniform1ui64vNV(location, org.lwjgl.system.Checks.remainingSafe(value), org.lwjgl.system.MemoryUtil.memAddressSafe(value));
	}

	public static void glUniform2uNV(int location, LongBuffer value) {
		org.lwjgl.opengl.NVGPUShader5.nglUniform2ui64vNV(location, (org.lwjgl.system.Checks.remainingSafe(value) >> 1), org.lwjgl.system.MemoryUtil.memAddressSafe(value));
	}

	public static void glUniform3uNV(int location, LongBuffer value) {
		org.lwjgl.opengl.NVGPUShader5.nglUniform3ui64vNV(location, (org.lwjgl.system.Checks.remainingSafe(value) / 3), org.lwjgl.system.MemoryUtil.memAddressSafe(value));
	}

	public static void glUniform4uNV(int location, LongBuffer value) {
		org.lwjgl.opengl.NVGPUShader5.nglUniform4ui64vNV(location, (org.lwjgl.system.Checks.remainingSafe(value) >> 2), org.lwjgl.system.MemoryUtil.memAddressSafe(value));
	}

	public static void glGetUniformNV(int program, int location, LongBuffer params) {
		org.lwjgl.opengl.NVGPUShader5.nglGetUniformi64vNV(program, location, org.lwjgl.system.MemoryUtil.memAddressSafe(params));
	}

	public static void glGetUniformuNV(int program, int location, LongBuffer params) {
		org.lwjgl.opengl.NVGPUShader5.nglGetUniformui64vNV(program, location, org.lwjgl.system.MemoryUtil.memAddressSafe(params));
	}

	public static void glProgramUniform1i64NV(int program, int location, long x) {
		org.lwjgl.opengl.NVGPUShader5.glProgramUniform1i64NV(program, location, x);
	}

	public static void glProgramUniform2i64NV(int program, int location, long x, long y) {
		org.lwjgl.opengl.NVGPUShader5.glProgramUniform2i64NV(program, location, x, y);
	}

	public static void glProgramUniform3i64NV(int program, int location, long x, long y, long z) {
		org.lwjgl.opengl.NVGPUShader5.glProgramUniform3i64NV(program, location, x, y, z);
	}

	public static void glProgramUniform4i64NV(int program, int location, long x, long y, long z, long w) {
		org.lwjgl.opengl.NVGPUShader5.glProgramUniform4i64NV(program, location, x, y, z, w);
	}

	public static void glProgramUniform1NV(int program, int location, LongBuffer value) {
		org.lwjgl.opengl.NVGPUShader5.nglProgramUniform1i64vNV(program, location, org.lwjgl.system.Checks.remainingSafe(value), org.lwjgl.system.MemoryUtil.memAddressSafe(value));
	}

	public static void glProgramUniform2NV(int program, int location, LongBuffer value) {
		org.lwjgl.opengl.NVGPUShader5.nglProgramUniform2i64vNV(program, location, (org.lwjgl.system.Checks.remainingSafe(value) >> 1), org.lwjgl.system.MemoryUtil.memAddressSafe(value));
	}

	public static void glProgramUniform3NV(int program, int location, LongBuffer value) {
		org.lwjgl.opengl.NVGPUShader5.nglProgramUniform3i64vNV(program, location, (org.lwjgl.system.Checks.remainingSafe(value) / 3), org.lwjgl.system.MemoryUtil.memAddressSafe(value));
	}

	public static void glProgramUniform4NV(int program, int location, LongBuffer value) {
		org.lwjgl.opengl.NVGPUShader5.nglProgramUniform4i64vNV(program, location, (org.lwjgl.system.Checks.remainingSafe(value) >> 2), org.lwjgl.system.MemoryUtil.memAddressSafe(value));
	}

	public static void glProgramUniform1ui64NV(int program, int location, long x) {
		org.lwjgl.opengl.NVGPUShader5.glProgramUniform1ui64NV(program, location, x);
	}

	public static void glProgramUniform2ui64NV(int program, int location, long x, long y) {
		org.lwjgl.opengl.NVGPUShader5.glProgramUniform2ui64NV(program, location, x, y);
	}

	public static void glProgramUniform3ui64NV(int program, int location, long x, long y, long z) {
		org.lwjgl.opengl.NVGPUShader5.glProgramUniform3ui64NV(program, location, x, y, z);
	}

	public static void glProgramUniform4ui64NV(int program, int location, long x, long y, long z, long w) {
		org.lwjgl.opengl.NVGPUShader5.glProgramUniform4ui64NV(program, location, x, y, z, w);
	}

	public static void glProgramUniform1uNV(int program, int location, LongBuffer value) {
		org.lwjgl.opengl.NVGPUShader5.nglProgramUniform1ui64vNV(program, location, org.lwjgl.system.Checks.remainingSafe(value), org.lwjgl.system.MemoryUtil.memAddressSafe(value));
	}

	public static void glProgramUniform2uNV(int program, int location, LongBuffer value) {
		org.lwjgl.opengl.NVGPUShader5.nglProgramUniform2ui64vNV(program, location, (org.lwjgl.system.Checks.remainingSafe(value) >> 1), org.lwjgl.system.MemoryUtil.memAddressSafe(value));
	}

	public static void glProgramUniform3uNV(int program, int location, LongBuffer value) {
		org.lwjgl.opengl.NVGPUShader5.nglProgramUniform3ui64vNV(program, location, (org.lwjgl.system.Checks.remainingSafe(value) / 3), org.lwjgl.system.MemoryUtil.memAddressSafe(value));
	}

	public static void glProgramUniform4uNV(int program, int location, LongBuffer value) {
		org.lwjgl.opengl.NVGPUShader5.nglProgramUniform4ui64vNV(program, location, (org.lwjgl.system.Checks.remainingSafe(value) >> 2), org.lwjgl.system.MemoryUtil.memAddressSafe(value));
	}
}
