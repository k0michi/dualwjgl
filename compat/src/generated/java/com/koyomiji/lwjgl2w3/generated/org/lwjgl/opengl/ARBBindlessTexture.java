package com.koyomiji.lwjgl2w3.generated.org.lwjgl.opengl;

import java.nio.LongBuffer;

public final class ARBBindlessTexture {
	public static void glUniformHandleuARB(int location, LongBuffer value) {
		org.lwjgl.opengl.ARBBindlessTexture.glUniformHandleui64vARB(location, value);
	}
	public static void glProgramUniformHandleuARB(int program, int location, LongBuffer values) {
		org.lwjgl.opengl.ARBBindlessTexture.glProgramUniformHandleui64vARB(program, location, values);
	}
	public static void glVertexAttribL1uARB(int index, LongBuffer v) {
		org.lwjgl.opengl.ARBBindlessTexture.glVertexAttribL1ui64vARB(index, v);
	}
	public static void glGetVertexAttribLuARB(int index, int pname, LongBuffer params) {
		org.lwjgl.opengl.ARBBindlessTexture.glGetVertexAttribLui64vARB(index, pname, params);
	}
}
