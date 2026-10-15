package org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Generated;
import java.nio.IntBuffer;
import java.nio.LongBuffer;

@Generated
public final class NVPresentVideo {
	public static final int GL_FRAME_NV = 0x8E26;
	public static final int FIELDS_NV = 0x8E27;
	public static final int GL_CURRENT_TIME_NV = 0x8E28;
	public static final int GL_NUM_FILL_STREAMS_NV = 0x8E29;
	public static final int GL_PRESENT_TIME_NV = 0x8E2A;
	public static final int GL_PRESENT_DURATION_NV = 0x8E2B;
	public static final int GL_NUM_VIDEO_SLOTS_NV = 0x20F0;

	private NVPresentVideo() {
	}

	public static void glPresentFrameKeyedNV(int video_slot, long minPresentTime, int beginPresentTimeId, int presentDurationId, int type, int target0, int fill0, int key0, int target1, int fill1, int key1) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glPresentFrameDualFillNV(int video_slot, long minPresentTime, int beginPresentTimeId, int presentDurationId, int type, int target0, int fill0, int target1, int fill1, int target2, int fill2, int target3, int fill3) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glGetVideoNV(int video_slot, int pname, IntBuffer params) {
		throw new IllegalStateException("Function is not supported");
	}

	public static int glGetVideoiNV(int video_slot, int pname) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glGetVideouNV(int video_slot, int pname, IntBuffer params) {
		throw new IllegalStateException("Function is not supported");
	}

	public static int glGetVideouiNV(int video_slot, int pname) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glGetVideoNV(int video_slot, int pname, LongBuffer params) {
		throw new IllegalStateException("Function is not supported");
	}

	public static long glGetVideoi64NV(int video_slot, int pname) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glGetVideouNV(int video_slot, int pname, LongBuffer params) {
		throw new IllegalStateException("Function is not supported");
	}

	public static long glGetVideoui64NV(int video_slot, int pname) {
		throw new IllegalStateException("Function is not supported");
	}
}
