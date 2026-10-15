package com.koyomiji.lwjgl2w3.generated.org.lwjgl.opencl;

import com.koyomiji.lwjgl2w3.inject.Todo;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.PointerBuffer;
import org.lwjgl.opencl.CLCommandQueue;
import org.lwjgl.opencl.CLContext;
import org.lwjgl.opencl.CLMem;

public final class CL10GL {
	@Todo("cl")
	public static CLMem clCreateFromGLBuffer(CLContext context, long flags, int bufobj, IntBuffer errcode_ret) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static CLMem clCreateFromGLTexture2D(CLContext context, long flags, int target, int miplevel, int texture, IntBuffer errcode_ret) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static CLMem clCreateFromGLTexture3D(CLContext context, long flags, int target, int miplevel, int texture, IntBuffer errcode_ret) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static CLMem clCreateFromGLRenderbuffer(CLContext context, long flags, int renderbuffer, IntBuffer errcode_ret) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static int clGetGLObjectInfo(CLMem memobj, IntBuffer gl_object_type, IntBuffer gl_object_name) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static int clGetGLTextureInfo(CLMem memobj, int param_name, ByteBuffer param_value, PointerBuffer param_value_size_ret) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static int clEnqueueAcquireGLObjects(CLCommandQueue command_queue, PointerBuffer mem_objects, PointerBuffer event_wait_list, PointerBuffer event) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static int clEnqueueAcquireGLObjects(CLCommandQueue command_queue, CLMem mem_object, PointerBuffer event_wait_list, PointerBuffer event) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static int clEnqueueReleaseGLObjects(CLCommandQueue command_queue, PointerBuffer mem_objects, PointerBuffer event_wait_list, PointerBuffer event) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static int clEnqueueReleaseGLObjects(CLCommandQueue command_queue, CLMem mem_object, PointerBuffer event_wait_list, PointerBuffer event) {
		throw new UnsupportedOperationException();
	}
}
