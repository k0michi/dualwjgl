package com.koyomiji.lwjgl2w3.inject.org.lwjgl.opencl;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.PointerBuffer;
import org.lwjgl.opencl.CLCommandQueue;
import org.lwjgl.opencl.CLCompileProgramCallback;
import org.lwjgl.opencl.CLContext;
import org.lwjgl.opencl.CLDevice;
import org.lwjgl.opencl.CLKernel;
import org.lwjgl.opencl.CLLinkProgramCallback;
import org.lwjgl.opencl.CLMem;
import org.lwjgl.opencl.CLPlatform;
import org.lwjgl.opencl.CLPrintfCallback;
import org.lwjgl.opencl.CLProgram;

public final class CL12 {
	public static int clRetainDevice(CLDevice device) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}
	public static int clReleaseDevice(CLDevice device) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}
	public static int clCreateSubDevices(CLDevice in_device, LongBuffer properties, PointerBuffer out_devices, IntBuffer num_devices_ret) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}
	public static CLMem clCreateImage(CLContext context, long flags, ByteBuffer image_format, ByteBuffer image_desc, ByteBuffer host_ptr, IntBuffer errcode_ret) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}
	public static CLMem clCreateImage(CLContext context, long flags, ByteBuffer image_format, ByteBuffer image_desc, FloatBuffer host_ptr, IntBuffer errcode_ret) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}
	public static CLMem clCreateImage(CLContext context, long flags, ByteBuffer image_format, ByteBuffer image_desc, IntBuffer host_ptr, IntBuffer errcode_ret) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}
	public static CLMem clCreateImage(CLContext context, long flags, ByteBuffer image_format, ByteBuffer image_desc, ShortBuffer host_ptr, IntBuffer errcode_ret) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}
	public static CLProgram clCreateProgramWithBuiltInKernels(CLContext context, PointerBuffer device_list, ByteBuffer kernel_names, IntBuffer errcode_ret) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}
	public static CLProgram clCreateProgramWithBuiltInKernels(CLContext context, PointerBuffer device_list, CharSequence kernel_names, IntBuffer errcode_ret) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}
	public static int clCompileProgram(CLProgram program, PointerBuffer device_list, ByteBuffer options, PointerBuffer input_header, ByteBuffer header_include_name, CLCompileProgramCallback pfn_notify) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}
	public static int clCompileProgramMulti(CLProgram program, PointerBuffer device_list, ByteBuffer options, PointerBuffer input_headers, ByteBuffer header_include_names, CLCompileProgramCallback pfn_notify) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}
	public static int clCompileProgram(CLProgram program, PointerBuffer device_list, ByteBuffer options, PointerBuffer input_headers, ByteBuffer[] header_include_names, CLCompileProgramCallback pfn_notify) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}
	public static int clCompileProgram(CLProgram program, PointerBuffer device_list, CharSequence options, PointerBuffer input_header, CharSequence header_include_name, CLCompileProgramCallback pfn_notify) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}
	public static int clCompileProgram(CLProgram program, PointerBuffer device_list, CharSequence options, PointerBuffer input_header, CharSequence[] header_include_name, CLCompileProgramCallback pfn_notify) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}
	public static CLProgram clLinkProgram(CLContext context, PointerBuffer device_list, ByteBuffer options, PointerBuffer input_programs, CLLinkProgramCallback pfn_notify, IntBuffer errcode_ret) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}
	public static CLProgram clLinkProgram(CLContext context, PointerBuffer device_list, CharSequence options, PointerBuffer input_programs, CLLinkProgramCallback pfn_notify, IntBuffer errcode_ret) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}
	public static int clUnloadPlatformCompiler(CLPlatform platform) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}
	public static int clGetKernelArgInfo(CLKernel kernel, int arg_indx, int param_name, ByteBuffer param_value, PointerBuffer param_value_size_ret) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}
	public static int clEnqueueFillBuffer(CLCommandQueue command_queue, CLMem buffer, ByteBuffer pattern, long offset, long size, PointerBuffer event_wait_list, PointerBuffer event) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}
	public static int clEnqueueFillImage(CLCommandQueue command_queue, CLMem image, ByteBuffer fill_color, PointerBuffer origin, PointerBuffer region, PointerBuffer event_wait_list, PointerBuffer event) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}
	public static int clEnqueueMigrateMemObjects(CLCommandQueue command_queue, PointerBuffer mem_objects, long flags, PointerBuffer event_wait_list, PointerBuffer event) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}
	public static int clEnqueueMarkerWithWaitList(CLCommandQueue command_queue, PointerBuffer event_wait_list, PointerBuffer event) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}
	public static int clEnqueueBarrierWithWaitList(CLCommandQueue command_queue, PointerBuffer event_wait_list, PointerBuffer event) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}
	public static int clSetPrintfCallback(CLContext context, CLPrintfCallback pfn_notify) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}
}
