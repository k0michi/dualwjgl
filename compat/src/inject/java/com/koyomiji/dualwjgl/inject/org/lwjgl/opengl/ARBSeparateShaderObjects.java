package com.koyomiji.dualwjgl.inject.org.lwjgl.opengl;

import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;

import java.nio.ByteBuffer;

// TODO(verify): hand-written; DelegationTest only compares generated members.
public final class ARBSeparateShaderObjects {

	/**
	 * LWJGL 2's C code passes each buffer's base address (GetDirectBufferAddress), not its position; the strings are
	 * null-terminated.
	 */
	public static int glCreateShaderProgram(int type, ByteBuffer[] strings) {
		if (strings.length < 1) {
			throw new IllegalArgumentException("Number of array elements is 0, must be at least 1");
		}
		try (MemoryStack stack = MemoryStack.stackPush()) {
			PointerBuffer pointers = stack.mallocPointer(strings.length);
			for (int i = 0; i < strings.length; i++) {
				pointers.put(i, MemoryUtil.memAddress0(strings[i]));
			}
			return org.lwjgl.opengl.ARBSeparateShaderObjects.glCreateShaderProgramv(type, pointers);
		}
	}

}
