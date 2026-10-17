package com.koyomiji.dualwjgl.generated.org.lwjgl.opengl;

import com.koyomiji.dualwjgl.inject.Todo;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

public final class EXTDirectStateAccess {
	public static void glMatrixLoadEXT(int matrixMode, FloatBuffer m) {
		org.lwjgl.opengl.EXTDirectStateAccess.glMatrixLoadfEXT(matrixMode, m);
	}
	public static void glMatrixLoadEXT(int matrixMode, DoubleBuffer m) {
		org.lwjgl.opengl.EXTDirectStateAccess.glMatrixLoaddEXT(matrixMode, m);
	}
	public static void glMatrixMultEXT(int matrixMode, FloatBuffer m) {
		org.lwjgl.opengl.EXTDirectStateAccess.glMatrixMultfEXT(matrixMode, m);
	}
	public static void glMatrixMultEXT(int matrixMode, DoubleBuffer m) {
		org.lwjgl.opengl.EXTDirectStateAccess.glMatrixMultdEXT(matrixMode, m);
	}
	public static void glTextureParameterEXT(int texture, int target, int pname, IntBuffer param) {
		org.lwjgl.opengl.EXTDirectStateAccess.glTextureParameterivEXT(texture, target, pname, param);
	}
	public static void glTextureParameterEXT(int texture, int target, int pname, FloatBuffer param) {
		org.lwjgl.opengl.EXTDirectStateAccess.glTextureParameterfvEXT(texture, target, pname, param);
	}
	public static void glGetTextureParameterEXT(int texture, int target, int pname, FloatBuffer params) {
		org.lwjgl.opengl.EXTDirectStateAccess.glGetTextureParameterfvEXT(texture, target, pname, params);
	}
	public static void glGetTextureParameterEXT(int texture, int target, int pname, IntBuffer params) {
		org.lwjgl.opengl.EXTDirectStateAccess.glGetTextureParameterivEXT(texture, target, pname, params);
	}
	public static void glGetTextureLevelParameterEXT(int texture, int target, int level, int pname, FloatBuffer params) {
		org.lwjgl.opengl.EXTDirectStateAccess.glGetTextureLevelParameterfvEXT(texture, target, level, pname, params);
	}
	public static void glGetTextureLevelParameterEXT(int texture, int target, int level, int pname, IntBuffer params) {
		org.lwjgl.opengl.EXTDirectStateAccess.glGetTextureLevelParameterivEXT(texture, target, level, pname, params);
	}
	public static void glMultiTexCoordPointerEXT(int texunit, int size, int stride, DoubleBuffer pointer) {
		org.lwjgl.opengl.EXTDirectStateAccess.glMultiTexCoordPointerEXT(texunit, size, 5130, stride, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(pointer), (org.lwjgl.system.Checks.remainingSafe(pointer) << 3)));
	}
	public static void glMultiTexCoordPointerEXT(int texunit, int size, int stride, FloatBuffer pointer) {
		org.lwjgl.opengl.EXTDirectStateAccess.glMultiTexCoordPointerEXT(texunit, size, 5126, stride, pointer);
	}
	public static void glMultiTexEnvEXT(int texunit, int target, int pname, FloatBuffer params) {
		org.lwjgl.opengl.EXTDirectStateAccess.glMultiTexEnvfvEXT(texunit, target, pname, params);
	}
	public static void glMultiTexEnvEXT(int texunit, int target, int pname, IntBuffer params) {
		org.lwjgl.opengl.EXTDirectStateAccess.glMultiTexEnvivEXT(texunit, target, pname, params);
	}
	public static void glMultiTexGenEXT(int texunit, int coord, int pname, DoubleBuffer params) {
		org.lwjgl.opengl.EXTDirectStateAccess.glMultiTexGendvEXT(texunit, coord, pname, params);
	}
	public static void glMultiTexGenEXT(int texunit, int coord, int pname, FloatBuffer params) {
		org.lwjgl.opengl.EXTDirectStateAccess.glMultiTexGenfvEXT(texunit, coord, pname, params);
	}
	public static void glMultiTexGenEXT(int texunit, int coord, int pname, IntBuffer params) {
		org.lwjgl.opengl.EXTDirectStateAccess.glMultiTexGenivEXT(texunit, coord, pname, params);
	}
	public static void glGetMultiTexEnvEXT(int texunit, int target, int pname, FloatBuffer params) {
		org.lwjgl.opengl.EXTDirectStateAccess.glGetMultiTexEnvfvEXT(texunit, target, pname, params);
	}
	public static void glGetMultiTexEnvEXT(int texunit, int target, int pname, IntBuffer params) {
		org.lwjgl.opengl.EXTDirectStateAccess.glGetMultiTexEnvivEXT(texunit, target, pname, params);
	}
	public static void glGetMultiTexGenEXT(int texunit, int coord, int pname, DoubleBuffer params) {
		org.lwjgl.opengl.EXTDirectStateAccess.glGetMultiTexGendvEXT(texunit, coord, pname, params);
	}
	public static void glGetMultiTexGenEXT(int texunit, int coord, int pname, FloatBuffer params) {
		org.lwjgl.opengl.EXTDirectStateAccess.glGetMultiTexGenfvEXT(texunit, coord, pname, params);
	}
	public static void glGetMultiTexGenEXT(int texunit, int coord, int pname, IntBuffer params) {
		org.lwjgl.opengl.EXTDirectStateAccess.glGetMultiTexGenivEXT(texunit, coord, pname, params);
	}
	public static void glMultiTexParameterEXT(int texunit, int target, int pname, IntBuffer param) {
		org.lwjgl.opengl.EXTDirectStateAccess.glMultiTexParameterivEXT(texunit, target, pname, param);
	}
	public static void glMultiTexParameterEXT(int texunit, int target, int pname, FloatBuffer param) {
		org.lwjgl.opengl.EXTDirectStateAccess.glMultiTexParameterfvEXT(texunit, target, pname, param);
	}
	public static void glGetMultiTexParameterEXT(int texunit, int target, int pname, FloatBuffer params) {
		org.lwjgl.opengl.EXTDirectStateAccess.glGetMultiTexParameterfvEXT(texunit, target, pname, params);
	}
	public static void glGetMultiTexParameterEXT(int texunit, int target, int pname, IntBuffer params) {
		org.lwjgl.opengl.EXTDirectStateAccess.glGetMultiTexParameterivEXT(texunit, target, pname, params);
	}
	public static void glGetMultiTexLevelParameterEXT(int texunit, int target, int level, int pname, FloatBuffer params) {
		org.lwjgl.opengl.EXTDirectStateAccess.glGetMultiTexLevelParameterfvEXT(texunit, target, level, pname, params);
	}
	public static void glGetMultiTexLevelParameterEXT(int texunit, int target, int level, int pname, IntBuffer params) {
		org.lwjgl.opengl.EXTDirectStateAccess.glGetMultiTexLevelParameterivEXT(texunit, target, level, pname, params);
	}
	public static void glGetFloatIndexedEXT(int pname, int index, FloatBuffer params) {
		org.lwjgl.opengl.EXTDirectStateAccess.glGetFloatIndexedvEXT(pname, index, params);
	}
	public static void glGetDoubleIndexedEXT(int pname, int index, DoubleBuffer params) {
		org.lwjgl.opengl.EXTDirectStateAccess.glGetDoubleIndexedvEXT(pname, index, params);
	}
	@Todo("gl")
	public static ByteBuffer glGetPointerIndexedEXT(int pname, int index, long result_size) {
		throw new UnsupportedOperationException();
	}
	public static void glGetFloatEXT(int pname, int index, FloatBuffer params) {
		org.lwjgl.opengl.EXTDirectStateAccess.glGetFloati_vEXT(pname, index, params);
	}
	public static float glGetFloatEXT(int pname, int index) {
		return org.lwjgl.opengl.EXTDirectStateAccess.glGetFloatiEXT(pname, index);
	}
	public static void glGetDoubleEXT(int pname, int index, DoubleBuffer params) {
		org.lwjgl.opengl.EXTDirectStateAccess.glGetDoublei_vEXT(pname, index, params);
	}
	public static double glGetDoubleEXT(int pname, int index) {
		return org.lwjgl.opengl.EXTDirectStateAccess.glGetDoubleiEXT(pname, index);
	}
	@Todo("gl")
	public static ByteBuffer glGetPointerEXT(int pname, int index, long result_size) {
		throw new UnsupportedOperationException();
	}
	public static void glGetIntegerIndexedEXT(int pname, int index, IntBuffer params) {
		org.lwjgl.opengl.EXTDirectStateAccess.glGetIntegerIndexedvEXT(pname, index, params);
	}
	public static void glGetBooleanIndexedEXT(int pname, int index, ByteBuffer params) {
		org.lwjgl.opengl.EXTDirectStateAccess.glGetBooleanIndexedvEXT(pname, index, params);
	}
	public static void glNamedProgramStringEXT(int program, int target, int format, CharSequence string) {
		try (org.lwjgl.system.MemoryStack __stack = org.lwjgl.system.MemoryStack.stackPush()) {
			java.nio.ByteBuffer __s3 = __stack.ASCII(string, false);
			org.lwjgl.opengl.EXTDirectStateAccess.glNamedProgramStringEXT(program, target, format, __s3);
		}
	}
	public static void glNamedProgramLocalParameter4EXT(int program, int target, int index, DoubleBuffer params) {
		org.lwjgl.opengl.EXTDirectStateAccess.glNamedProgramLocalParameter4dvEXT(program, target, index, params);
	}
	public static void glNamedProgramLocalParameter4EXT(int program, int target, int index, FloatBuffer params) {
		org.lwjgl.opengl.EXTDirectStateAccess.glNamedProgramLocalParameter4fvEXT(program, target, index, params);
	}
	public static void glGetNamedProgramLocalParameterEXT(int program, int target, int index, DoubleBuffer params) {
		org.lwjgl.opengl.EXTDirectStateAccess.glGetNamedProgramLocalParameterdvEXT(program, target, index, params);
	}
	public static void glGetNamedProgramLocalParameterEXT(int program, int target, int index, FloatBuffer params) {
		org.lwjgl.opengl.EXTDirectStateAccess.glGetNamedProgramLocalParameterfvEXT(program, target, index, params);
	}
	public static void glGetNamedProgramEXT(int program, int target, int pname, IntBuffer params) {
		org.lwjgl.opengl.EXTDirectStateAccess.glGetNamedProgramivEXT(program, target, pname, params);
	}
	public static int glGetNamedProgramEXT(int program, int target, int pname) {
		return org.lwjgl.opengl.EXTDirectStateAccess.glGetNamedProgramiEXT(program, target, pname);
	}
	@Todo("gl")
	public static String glGetNamedProgramStringEXT(int program, int target, int pname) {
		throw new UnsupportedOperationException();
	}
	public static void glGetCompressedTextureImageEXT(int texture, int target, int level, IntBuffer img) {
		org.lwjgl.opengl.EXTDirectStateAccess.glGetCompressedTextureImageEXT(texture, target, level, org.lwjgl.system.MemoryUtil.memAddressSafe(img));
	}
	public static void glGetCompressedTextureImageEXT(int texture, int target, int level, ShortBuffer img) {
		org.lwjgl.opengl.EXTDirectStateAccess.glGetCompressedTextureImageEXT(texture, target, level, org.lwjgl.system.MemoryUtil.memAddressSafe(img));
	}
	public static void glGetCompressedMultiTexImageEXT(int texunit, int target, int level, IntBuffer img) {
		org.lwjgl.opengl.EXTDirectStateAccess.glGetCompressedMultiTexImageEXT(texunit, target, level, org.lwjgl.system.MemoryUtil.memAddressSafe(img));
	}
	public static void glGetCompressedMultiTexImageEXT(int texunit, int target, int level, ShortBuffer img) {
		org.lwjgl.opengl.EXTDirectStateAccess.glGetCompressedMultiTexImageEXT(texunit, target, level, org.lwjgl.system.MemoryUtil.memAddressSafe(img));
	}
	public static void glMatrixLoadTransposeEXT(int matrixMode, FloatBuffer m) {
		org.lwjgl.opengl.EXTDirectStateAccess.glMatrixLoadTransposefEXT(matrixMode, m);
	}
	public static void glMatrixLoadTransposeEXT(int matrixMode, DoubleBuffer m) {
		org.lwjgl.opengl.EXTDirectStateAccess.glMatrixLoadTransposedEXT(matrixMode, m);
	}
	public static void glMatrixMultTransposeEXT(int matrixMode, FloatBuffer m) {
		org.lwjgl.opengl.EXTDirectStateAccess.glMatrixMultTransposefEXT(matrixMode, m);
	}
	public static void glMatrixMultTransposeEXT(int matrixMode, DoubleBuffer m) {
		org.lwjgl.opengl.EXTDirectStateAccess.glMatrixMultTransposedEXT(matrixMode, m);
	}
	public static void glGetNamedBufferParameterEXT(int buffer, int pname, IntBuffer params) {
		org.lwjgl.opengl.EXTDirectStateAccess.glGetNamedBufferParameterivEXT(buffer, pname, params);
	}
	public static int glGetNamedBufferParameterEXT(int buffer, int pname) {
		return org.lwjgl.opengl.EXTDirectStateAccess.glGetNamedBufferParameteriEXT(buffer, pname);
	}
	@Todo("gl")
	public static ByteBuffer glGetNamedBufferPointerEXT(int buffer, int pname) {
		throw new UnsupportedOperationException();
	}
	public static void glProgramUniform1EXT(int program, int location, FloatBuffer value) {
		org.lwjgl.opengl.EXTDirectStateAccess.glProgramUniform1fvEXT(program, location, value);
	}
	public static void glProgramUniform2EXT(int program, int location, FloatBuffer value) {
		org.lwjgl.opengl.EXTDirectStateAccess.glProgramUniform2fvEXT(program, location, value);
	}
	public static void glProgramUniform3EXT(int program, int location, FloatBuffer value) {
		org.lwjgl.opengl.EXTDirectStateAccess.glProgramUniform3fvEXT(program, location, value);
	}
	public static void glProgramUniform4EXT(int program, int location, FloatBuffer value) {
		org.lwjgl.opengl.EXTDirectStateAccess.glProgramUniform4fvEXT(program, location, value);
	}
	public static void glProgramUniform1EXT(int program, int location, IntBuffer value) {
		org.lwjgl.opengl.EXTDirectStateAccess.glProgramUniform1ivEXT(program, location, value);
	}
	public static void glProgramUniform2EXT(int program, int location, IntBuffer value) {
		org.lwjgl.opengl.EXTDirectStateAccess.glProgramUniform2ivEXT(program, location, value);
	}
	public static void glProgramUniform3EXT(int program, int location, IntBuffer value) {
		org.lwjgl.opengl.EXTDirectStateAccess.glProgramUniform3ivEXT(program, location, value);
	}
	public static void glProgramUniform4EXT(int program, int location, IntBuffer value) {
		org.lwjgl.opengl.EXTDirectStateAccess.glProgramUniform4ivEXT(program, location, value);
	}
	public static void glProgramUniformMatrix2EXT(int program, int location, boolean transpose, FloatBuffer value) {
		org.lwjgl.opengl.EXTDirectStateAccess.glProgramUniformMatrix2fvEXT(program, location, transpose, value);
	}
	public static void glProgramUniformMatrix3EXT(int program, int location, boolean transpose, FloatBuffer value) {
		org.lwjgl.opengl.EXTDirectStateAccess.glProgramUniformMatrix3fvEXT(program, location, transpose, value);
	}
	public static void glProgramUniformMatrix4EXT(int program, int location, boolean transpose, FloatBuffer value) {
		org.lwjgl.opengl.EXTDirectStateAccess.glProgramUniformMatrix4fvEXT(program, location, transpose, value);
	}
	public static void glProgramUniformMatrix2x3EXT(int program, int location, boolean transpose, FloatBuffer value) {
		org.lwjgl.opengl.EXTDirectStateAccess.glProgramUniformMatrix2x3fvEXT(program, location, transpose, value);
	}
	public static void glProgramUniformMatrix3x2EXT(int program, int location, boolean transpose, FloatBuffer value) {
		org.lwjgl.opengl.EXTDirectStateAccess.glProgramUniformMatrix3x2fvEXT(program, location, transpose, value);
	}
	public static void glProgramUniformMatrix2x4EXT(int program, int location, boolean transpose, FloatBuffer value) {
		org.lwjgl.opengl.EXTDirectStateAccess.glProgramUniformMatrix2x4fvEXT(program, location, transpose, value);
	}
	public static void glProgramUniformMatrix4x2EXT(int program, int location, boolean transpose, FloatBuffer value) {
		org.lwjgl.opengl.EXTDirectStateAccess.glProgramUniformMatrix4x2fvEXT(program, location, transpose, value);
	}
	public static void glProgramUniformMatrix3x4EXT(int program, int location, boolean transpose, FloatBuffer value) {
		org.lwjgl.opengl.EXTDirectStateAccess.glProgramUniformMatrix3x4fvEXT(program, location, transpose, value);
	}
	public static void glProgramUniformMatrix4x3EXT(int program, int location, boolean transpose, FloatBuffer value) {
		org.lwjgl.opengl.EXTDirectStateAccess.glProgramUniformMatrix4x3fvEXT(program, location, transpose, value);
	}
	public static void glTextureParameterIEXT(int texture, int target, int pname, IntBuffer params) {
		org.lwjgl.opengl.EXTDirectStateAccess.glTextureParameterIivEXT(texture, target, pname, params);
	}
	public static void glTextureParameterIEXT(int texture, int target, int pname, int param) {
		try (org.lwjgl.system.MemoryStack __stack = org.lwjgl.system.MemoryStack.stackPush()) {
			java.nio.IntBuffer __v3 = __stack.callocInt(4).put(0, param);
			org.lwjgl.opengl.EXTDirectStateAccess.glTextureParameterIivEXT(texture, target, pname, __v3);
		}
	}
	public static void glTextureParameterIuEXT(int texture, int target, int pname, IntBuffer params) {
		org.lwjgl.opengl.EXTDirectStateAccess.glTextureParameterIuivEXT(texture, target, pname, params);
	}
	public static void glTextureParameterIuEXT(int texture, int target, int pname, int param) {
		try (org.lwjgl.system.MemoryStack __stack = org.lwjgl.system.MemoryStack.stackPush()) {
			java.nio.IntBuffer __v3 = __stack.callocInt(4).put(0, param);
			org.lwjgl.opengl.EXTDirectStateAccess.glTextureParameterIuivEXT(texture, target, pname, __v3);
		}
	}
	public static void glGetTextureParameterIEXT(int texture, int target, int pname, IntBuffer params) {
		org.lwjgl.opengl.EXTDirectStateAccess.glGetTextureParameterIivEXT(texture, target, pname, params);
	}
	public static void glGetTextureParameterIuEXT(int texture, int target, int pname, IntBuffer params) {
		org.lwjgl.opengl.EXTDirectStateAccess.glGetTextureParameterIuivEXT(texture, target, pname, params);
	}
	public static void glMultiTexParameterIEXT(int texunit, int target, int pname, IntBuffer params) {
		org.lwjgl.opengl.EXTDirectStateAccess.glMultiTexParameterIivEXT(texunit, target, pname, params);
	}
	public static void glMultiTexParameterIEXT(int texunit, int target, int pname, int param) {
		try (org.lwjgl.system.MemoryStack __stack = org.lwjgl.system.MemoryStack.stackPush()) {
			java.nio.IntBuffer __v3 = __stack.callocInt(4).put(0, param);
			org.lwjgl.opengl.EXTDirectStateAccess.glMultiTexParameterIivEXT(texunit, target, pname, __v3);
		}
	}
	public static void glMultiTexParameterIuEXT(int texunit, int target, int pname, IntBuffer params) {
		org.lwjgl.opengl.EXTDirectStateAccess.glMultiTexParameterIuivEXT(texunit, target, pname, params);
	}
	public static void glMultiTexParameterIuEXT(int texunit, int target, int pname, int param) {
		try (org.lwjgl.system.MemoryStack __stack = org.lwjgl.system.MemoryStack.stackPush()) {
			java.nio.IntBuffer __v3 = __stack.callocInt(4).put(0, param);
			org.lwjgl.opengl.EXTDirectStateAccess.glMultiTexParameterIuivEXT(texunit, target, pname, __v3);
		}
	}
	public static void glGetMultiTexParameterIEXT(int texunit, int target, int pname, IntBuffer params) {
		org.lwjgl.opengl.EXTDirectStateAccess.glGetMultiTexParameterIivEXT(texunit, target, pname, params);
	}
	public static void glGetMultiTexParameterIuEXT(int texunit, int target, int pname, IntBuffer params) {
		org.lwjgl.opengl.EXTDirectStateAccess.glGetMultiTexParameterIuivEXT(texunit, target, pname, params);
	}
	public static void glProgramUniform1uEXT(int program, int location, IntBuffer value) {
		org.lwjgl.opengl.EXTDirectStateAccess.glProgramUniform1uivEXT(program, location, value);
	}
	public static void glProgramUniform2uEXT(int program, int location, IntBuffer value) {
		org.lwjgl.opengl.EXTDirectStateAccess.glProgramUniform2uivEXT(program, location, value);
	}
	public static void glProgramUniform3uEXT(int program, int location, IntBuffer value) {
		org.lwjgl.opengl.EXTDirectStateAccess.glProgramUniform3uivEXT(program, location, value);
	}
	public static void glProgramUniform4uEXT(int program, int location, IntBuffer value) {
		org.lwjgl.opengl.EXTDirectStateAccess.glProgramUniform4uivEXT(program, location, value);
	}
	public static void glNamedProgramLocalParameters4EXT(int program, int target, int index, FloatBuffer params) {
		org.lwjgl.opengl.EXTDirectStateAccess.glNamedProgramLocalParameters4fvEXT(program, target, index, params);
	}
	public static void glNamedProgramLocalParameterI4EXT(int program, int target, int index, IntBuffer params) {
		org.lwjgl.opengl.EXTDirectStateAccess.glNamedProgramLocalParameterI4ivEXT(program, target, index, params);
	}
	public static void glNamedProgramLocalParametersI4EXT(int program, int target, int index, IntBuffer params) {
		org.lwjgl.opengl.EXTDirectStateAccess.glNamedProgramLocalParametersI4ivEXT(program, target, index, params);
	}
	public static void glNamedProgramLocalParameterI4uEXT(int program, int target, int index, IntBuffer params) {
		org.lwjgl.opengl.EXTDirectStateAccess.glNamedProgramLocalParameterI4uivEXT(program, target, index, params);
	}
	public static void glNamedProgramLocalParametersI4uEXT(int program, int target, int index, IntBuffer params) {
		org.lwjgl.opengl.EXTDirectStateAccess.glNamedProgramLocalParametersI4uivEXT(program, target, index, params);
	}
	public static void glGetNamedProgramLocalParameterIEXT(int program, int target, int index, IntBuffer params) {
		org.lwjgl.opengl.EXTDirectStateAccess.glGetNamedProgramLocalParameterIivEXT(program, target, index, params);
	}
	public static void glGetNamedProgramLocalParameterIuEXT(int program, int target, int index, IntBuffer params) {
		org.lwjgl.opengl.EXTDirectStateAccess.glGetNamedProgramLocalParameterIuivEXT(program, target, index, params);
	}
	public static void glGetNamedRenderbufferParameterEXT(int renderbuffer, int pname, IntBuffer params) {
		org.lwjgl.opengl.EXTDirectStateAccess.glGetNamedRenderbufferParameterivEXT(renderbuffer, pname, params);
	}
	public static int glGetNamedRenderbufferParameterEXT(int renderbuffer, int pname) {
		return org.lwjgl.opengl.EXTDirectStateAccess.glGetNamedRenderbufferParameteriEXT(renderbuffer, pname);
	}
	public static void glGetNamedFramebufferAttachmentParameterEXT(int framebuffer, int attachment, int pname, IntBuffer params) {
		org.lwjgl.opengl.EXTDirectStateAccess.glGetNamedFramebufferAttachmentParameterivEXT(framebuffer, attachment, pname, params);
	}
	public static int glGetNamedFramebufferAttachmentParameterEXT(int framebuffer, int attachment, int pname) {
		return org.lwjgl.opengl.EXTDirectStateAccess.glGetNamedFramebufferAttachmentParameteriEXT(framebuffer, attachment, pname);
	}
	public static void glGetFramebufferParameterEXT(int framebuffer, int pname, IntBuffer param) {
		org.lwjgl.opengl.EXTDirectStateAccess.glGetFramebufferParameterivEXT(framebuffer, pname, param);
	}
	public static int glGetFramebufferParameterEXT(int framebuffer, int pname) {
		return org.lwjgl.opengl.EXTDirectStateAccess.glGetFramebufferParameteriEXT(framebuffer, pname);
	}
	public static void glGetVertexArrayIntegerEXT(int vaobj, int pname, IntBuffer param) {
		org.lwjgl.opengl.EXTDirectStateAccess.glGetVertexArrayIntegervEXT(vaobj, pname, param);
	}
	@Todo("gl")
	public static ByteBuffer glGetVertexArrayPointerEXT(int vaobj, int pname, long result_size) {
		throw new UnsupportedOperationException();
	}
	public static void glGetVertexArrayIntegerEXT(int vaobj, int index, int pname, IntBuffer param) {
		org.lwjgl.opengl.EXTDirectStateAccess.glGetVertexArrayIntegeri_vEXT(vaobj, index, pname, param);
	}
	@Todo("gl")
	public static ByteBuffer glGetVertexArrayPointerEXT(int vaobj, int index, int pname, long result_size) {
		throw new UnsupportedOperationException();
	}
}
