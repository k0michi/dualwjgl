package com.koyomiji.dualwjgl.inject.org.lwjgl.opengl;

import org.lwjgl.opengl.ARBVertexBufferObject;
import org.lwjgl.system.MemoryUtil;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

// TODO(verify): hand-written; DelegationTest only compares generated members.
/** LWJGL 2's ARBBufferObject functions, which LWJGL 3 binds in ARBVertexBufferObject. */
public final class EXTPixelBufferObject {

	/** LWJGL 2's C code reuses {@code old_buffer} when it views the mapped memory, as LWJGL 3 does, then sets native order. */
	public static ByteBuffer glMapBufferARB(int target, int access, ByteBuffer old_buffer) {
		ByteBuffer buffer = ARBVertexBufferObject.glMapBufferARB(target, access, old_buffer);
		return buffer == null ? null : buffer.order(ByteOrder.nativeOrder());
	}

	public static ByteBuffer glMapBufferARB(int target, int access, long length, ByteBuffer old_buffer) {
		ByteBuffer buffer = ARBVertexBufferObject.glMapBufferARB(target, access, length, old_buffer);
		return buffer == null ? null : buffer.order(ByteOrder.nativeOrder());
	}

	/** The buffer's whole store, or null if it is not mapped. */
	public static ByteBuffer glGetBufferPointerARB(int target, int pname) {
		int size = ARBVertexBufferObject.glGetBufferParameteriARB(target, ARBVertexBufferObject.GL_BUFFER_SIZE_ARB);
		return MemoryUtil.memByteBufferSafe(ARBVertexBufferObject.glGetBufferPointerARB(target, pname), size);
	}

}
