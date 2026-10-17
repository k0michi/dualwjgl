package com.koyomiji.dualwjgl.inject.org.lwjgl.opengl;

import org.lwjgl.BufferChecks;
import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

// TODO(verify): hand-written; DelegationTest only compares generated members.
public final class ARBUniformBufferObject {

	/** LWJGL 2's deprecated name for glGetActiveUniformsi. */
	@Deprecated
	public static int glGetActiveUniforms(int program, int uniformIndex, int pname) {
		return org.lwjgl.opengl.ARBUniformBufferObject.glGetActiveUniformsi(program, uniformIndex, pname);
	}

	/** LWJGL 2's native split the null-terminated strings, one after the other and one per index, into the array GL takes. */
	public static void glGetUniformIndices(int program, ByteBuffer uniformNames, IntBuffer uniformIndices) {
		BufferChecks.checkDirect(uniformNames);
		BufferChecks.checkDirect(uniformIndices);
		BufferChecks.checkNullTerminated(uniformNames, uniformIndices.remaining());
		try (MemoryStack stack = MemoryStack.stackPush()) {
			PointerBuffer pointers = stack.mallocPointer(uniformIndices.remaining());
			long address = MemoryUtil.memAddress(uniformNames);
			for (int i = 0; i < pointers.capacity(); i++) {
				pointers.put(i, address);
				while (MemoryUtil.memGetByte(address) != 0) {
					address++;
				}
				address++;
			}
			org.lwjgl.opengl.ARBUniformBufferObject.glGetUniformIndices(program, pointers, uniformIndices);
		}
	}

}
