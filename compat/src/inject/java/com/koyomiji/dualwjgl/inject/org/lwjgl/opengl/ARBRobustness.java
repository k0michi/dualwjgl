package com.koyomiji.dualwjgl.inject.org.lwjgl.opengl;

import java.nio.ByteBuffer;

// TODO(verify): hand-written; DelegationTest only compares generated members.
public final class ARBRobustness {

	/** Buffer object offsets: span is unused by GL, and LWJGL 3 takes it as a buffer only, so null. */
	public static void glGetnSeparableFilterARB(int target, int format, int type, int row_rowBufSize, long row_buffer_offset,
		int column_columnBufSize, long column_buffer_offset, long span_buffer_offset) {
		org.lwjgl.opengl.ARBRobustness.glGetnSeparableFilterARB(target, format, type, row_rowBufSize, row_buffer_offset,
			column_columnBufSize, column_buffer_offset, (ByteBuffer)null);
	}
}
