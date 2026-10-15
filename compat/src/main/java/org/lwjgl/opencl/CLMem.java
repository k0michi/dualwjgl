package org.lwjgl.opencl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.opencl.api.CLBufferRegion;
import org.lwjgl.opencl.api.CLImageFormat;

public final class CLMem extends CLObjectChild<CLContext> {
	CLMem(long pointer, CLContext context) {
		super((long) 0L, (CLContext) null);
		// TODO(cl)
		throw new UnsupportedOperationException();
	}

	public static CLMem createImage2D(CLContext context, long flags, CLImageFormat image_format, long image_width, long image_height, long image_row_pitch, Buffer host_ptr, IntBuffer errcode_ret) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}

	public static CLMem createImage3D(CLContext context, long flags, CLImageFormat image_format, long image_width, long image_height, long image_depth, long image_row_pitch, long image_slice_pitch, Buffer host_ptr, IntBuffer errcode_ret) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}

	public CLMem createSubBuffer(long flags, int buffer_create_type, CLBufferRegion buffer_create_info, IntBuffer errcode_ret) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}

	public int getInfoInt(int param_name) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}

	public long getInfoSize(int param_name) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}

	public long getInfoLong(int param_name) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}

	public ByteBuffer getInfoHostBuffer() {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}

	public long getImageInfoSize(int param_name) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}

	public CLImageFormat getImageFormat() {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}

	public int getImageChannelOrder() {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}

	public int getImageChannelType() {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}

	public int getGLObjectType() {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}

	public int getGLObjectName() {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}

	public int getGLTextureInfoInt(int param_name) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}
}
