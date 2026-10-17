package com.koyomiji.dualwjgl.inject.org.lwjgl.opengl;

import org.lwjgl.BufferChecks;
import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;

import java.nio.ByteBuffer;

// TODO(verify): hand-written; DelegationTest only compares generated members.
public final class GL30 {

	/** LWJGL 2's native split count null-terminated strings, one after the other, into the array GL takes. */
	public static void glTransformFeedbackVaryings(int program, int count, ByteBuffer varyings, int bufferMode) {
		BufferChecks.checkDirect(varyings);
		BufferChecks.checkNullTerminated(varyings, count);
		try (MemoryStack stack = MemoryStack.stackPush()) {
			PointerBuffer pointers = stack.mallocPointer(count);
			long address = MemoryUtil.memAddress(varyings);
			for (int i = 0; i < pointers.capacity(); i++) {
				pointers.put(i, address);
				while (MemoryUtil.memGetByte(address) != 0) {
					address++;
				}
				address++;
			}
			org.lwjgl.opengl.GL30.glTransformFeedbackVaryings(program, pointers, bufferMode);
		}
	}

}
