package org.lwjgl.opencl;

import com.koyomiji.lwjgl2w3.inject.Generated;
import com.koyomiji.lwjgl2w3.inject.Todo;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.opencl.api.CLBufferRegion;
import org.lwjgl.opencl.api.CLImageFormat;

@Generated
public final class CLMem extends CLObjectChild<CLContext> {
	@Todo("cl")
	CLMem(long pointer, CLContext context) {
		super((long) 0L, (CLContext) null);
		throw new UnsupportedOperationException();
	}

	@Todo("cl")
	public static CLMem createImage2D(CLContext context, long flags, CLImageFormat image_format, long image_width, long image_height, long image_row_pitch, Buffer host_ptr, IntBuffer errcode_ret) {
		throw new UnsupportedOperationException();
	}

	@Todo("cl")
	public static CLMem createImage3D(CLContext context, long flags, CLImageFormat image_format, long image_width, long image_height, long image_depth, long image_row_pitch, long image_slice_pitch, Buffer host_ptr, IntBuffer errcode_ret) {
		throw new UnsupportedOperationException();
	}

	@Todo("cl")
	public CLMem createSubBuffer(long flags, int buffer_create_type, CLBufferRegion buffer_create_info, IntBuffer errcode_ret) {
		throw new UnsupportedOperationException();
	}

	@Todo("cl")
	public int getInfoInt(int param_name) {
		throw new UnsupportedOperationException();
	}

	@Todo("cl")
	public long getInfoSize(int param_name) {
		throw new UnsupportedOperationException();
	}

	@Todo("cl")
	public long getInfoLong(int param_name) {
		throw new UnsupportedOperationException();
	}

	@Todo("cl")
	public ByteBuffer getInfoHostBuffer() {
		throw new UnsupportedOperationException();
	}

	@Todo("cl")
	public long getImageInfoSize(int param_name) {
		throw new UnsupportedOperationException();
	}

	@Todo("cl")
	public CLImageFormat getImageFormat() {
		throw new UnsupportedOperationException();
	}

	@Todo("cl")
	public int getImageChannelOrder() {
		throw new UnsupportedOperationException();
	}

	@Todo("cl")
	public int getImageChannelType() {
		throw new UnsupportedOperationException();
	}

	@Todo("cl")
	public int getGLObjectType() {
		throw new UnsupportedOperationException();
	}

	@Todo("cl")
	public int getGLObjectName() {
		throw new UnsupportedOperationException();
	}

	@Todo("cl")
	public int getGLTextureInfoInt(int param_name) {
		throw new UnsupportedOperationException();
	}
}
