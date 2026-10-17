package org.lwjgl.opengl;

import com.koyomiji.dualwjgl.inject.Generated;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;

@Generated
public final class NVVideoCapture {
	public static final int GL_VIDEO_BUFFER_NV = 0x9020;
	public static final int GL_VIDEO_BUFFER_BINDING_NV = 0x9021;
	public static final int GL_FIELD_UPPER_NV = 0x9022;
	public static final int GL_FIELD_LOWER_NV = 0x9023;
	public static final int GL_NUM_VIDEO_CAPTURE_STREAMS_NV = 0x9024;
	public static final int GL_NEXT_VIDEO_CAPTURE_BUFFER_STATUS_NV = 0x9025;
	public static final int GL_LAST_VIDEO_CAPTURE_STATUS_NV = 0x9027;
	public static final int GL_VIDEO_BUFFER_PITCH_NV = 0x9028;
	public static final int GL_VIDEO_CAPTURE_FRAME_WIDTH_NV = 0x9038;
	public static final int GL_VIDEO_CAPTURE_FRAME_HEIGHT_NV = 0x9039;
	public static final int GL_VIDEO_CAPTURE_FIELD_UPPER_HEIGHT_NV = 0x903A;
	public static final int GL_VIDEO_CAPTURE_FIELD_LOWER_HEIGHT_NV = 0x903B;
	public static final int GL_VIDEO_CAPTURE_TO_422_SUPPORTED_NV = 0x9026;
	public static final int GL_VIDEO_COLOR_CONVERSION_MATRIX_NV = 0x9029;
	public static final int GL_VIDEO_COLOR_CONVERSION_MAX_NV = 0x902A;
	public static final int GL_VIDEO_COLOR_CONVERSION_MIN_NV = 0x902B;
	public static final int GL_VIDEO_COLOR_CONVERSION_OFFSET_NV = 0x902C;
	public static final int GL_VIDEO_BUFFER_INTERNAL_FORMAT_NV = 0x902D;
	public static final int GL_VIDEO_CAPTURE_SURFACE_ORIGIN_NV = 0x903C;
	public static final int GL_PARTIAL_SUCCESS_NV = 0x902E;
	public static final int GL_SUCCESS_NV = 0x902F;
	public static final int GL_FAILURE_NV = 0x9030;
	public static final int GL_YCBYCR8_422_NV = 0x9031;
	public static final int GL_YCBAYCR8A_4224_NV = 0x9032;
	public static final int GL_Z6Y10Z6CB10Z6Y10Z6CR10_422_NV = 0x9033;
	public static final int GL_Z6Y10Z6CB10Z6A10Z6Y10Z6CR10Z6A10_4224_NV = 0x9034;
	public static final int GL_Z4Y12Z4CB12Z4Y12Z4CR12_422_NV = 0x9035;
	public static final int GL_Z4Y12Z4CB12Z4A12Z4Y12Z4CR12Z4A12_4224_NV = 0x9036;
	public static final int GL_Z4Y12Z4CB12Z4CR12_444_NV = 0x9037;
	public static final int GL_NUM_VIDEO_CAPTURE_SLOTS_NV = 0x20CF;
	public static final int GL_UNIQUE_ID_NV = 0x20CE;

	private NVVideoCapture() {
	}

	public static void glBeginVideoCaptureNV(int video_capture_slot) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glBindVideoCaptureStreamBufferNV(int video_capture_slot, int stream, int frame_region, long offset) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glBindVideoCaptureStreamTextureNV(int video_capture_slot, int stream, int frame_region, int target, int texture) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glEndVideoCaptureNV(int video_capture_slot) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glGetVideoCaptureNV(int video_capture_slot, int pname, IntBuffer params) {
		throw new IllegalStateException("Function is not supported");
	}

	public static int glGetVideoCaptureiNV(int video_capture_slot, int pname) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glGetVideoCaptureStreamNV(int video_capture_slot, int stream, int pname, IntBuffer params) {
		throw new IllegalStateException("Function is not supported");
	}

	public static int glGetVideoCaptureStreamiNV(int video_capture_slot, int stream, int pname) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glGetVideoCaptureStreamNV(int video_capture_slot, int stream, int pname, FloatBuffer params) {
		throw new IllegalStateException("Function is not supported");
	}

	public static float glGetVideoCaptureStreamfNV(int video_capture_slot, int stream, int pname) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glGetVideoCaptureStreamNV(int video_capture_slot, int stream, int pname, DoubleBuffer params) {
		throw new IllegalStateException("Function is not supported");
	}

	public static double glGetVideoCaptureStreamdNV(int video_capture_slot, int stream, int pname) {
		throw new IllegalStateException("Function is not supported");
	}

	public static int glVideoCaptureNV(int video_capture_slot, IntBuffer sequence_num, LongBuffer capture_time) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glVideoCaptureStreamParameterNV(int video_capture_slot, int stream, int pname, IntBuffer params) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glVideoCaptureStreamParameterNV(int video_capture_slot, int stream, int pname, FloatBuffer params) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glVideoCaptureStreamParameterNV(int video_capture_slot, int stream, int pname, DoubleBuffer params) {
		throw new IllegalStateException("Function is not supported");
	}
}
