package com.koyomiji.dualwjgl.generated.org.lwjgl.opengl;

import java.nio.DoubleBuffer;

public final class EXTVertexAttrib64bit {
	public static void glVertexAttribL1EXT(int index, DoubleBuffer v) {
		org.lwjgl.opengl.EXTVertexAttrib64bit.glVertexAttribL1dvEXT(index, v);
	}
	public static void glVertexAttribL2EXT(int index, DoubleBuffer v) {
		org.lwjgl.opengl.EXTVertexAttrib64bit.glVertexAttribL2dvEXT(index, v);
	}
	public static void glVertexAttribL3EXT(int index, DoubleBuffer v) {
		org.lwjgl.opengl.EXTVertexAttrib64bit.glVertexAttribL3dvEXT(index, v);
	}
	public static void glVertexAttribL4EXT(int index, DoubleBuffer v) {
		org.lwjgl.opengl.EXTVertexAttrib64bit.glVertexAttribL4dvEXT(index, v);
	}
	public static void glVertexAttribLPointerEXT(int index, int size, int stride, long pointer_buffer_offset) {
		org.lwjgl.opengl.EXTVertexAttrib64bit.glVertexAttribLPointerEXT(index, size, 5130, stride, pointer_buffer_offset);
	}
	public static void glGetVertexAttribLEXT(int index, int pname, DoubleBuffer params) {
		org.lwjgl.opengl.EXTVertexAttrib64bit.glGetVertexAttribLdvEXT(index, pname, params);
	}
}
