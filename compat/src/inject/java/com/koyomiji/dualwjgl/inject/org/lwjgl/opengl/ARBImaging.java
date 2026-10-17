package com.koyomiji.dualwjgl.inject.org.lwjgl.opengl;

import java.nio.ByteBuffer;

// TODO(verify): hand-written; DelegationTest only compares generated members.
public final class ARBImaging {

	/** Buffer object offsets: span is unused by GL, and LWJGL 3 takes it as a buffer only, so null. */
	public static void glGetSeparableFilter(int target, int format, int type, long row_buffer_offset, long column_buffer_offset, long span_buffer_offset) {
		org.lwjgl.opengl.ARBImaging.glGetSeparableFilter(target, format, type, row_buffer_offset, column_buffer_offset, (ByteBuffer)null);
	}
}
