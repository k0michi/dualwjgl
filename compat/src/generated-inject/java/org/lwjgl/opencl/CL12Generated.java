package org.lwjgl.opencl;

import com.koyomiji.lwjgl2w3.inject.Generated;
import com.koyomiji.lwjgl2w3.inject.Into;
import com.koyomiji.lwjgl2w3.inject.Todo;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.PointerBuffer;

@Generated
@Into(CL12.class)
final class CL12Generated {
	public static int clRetainDevice(CLDevice device) {
		int __result = org.lwjgl.opencl.CL12.clRetainDevice(device.getPointer());
		if ( __result == CL10.CL_SUCCESS ) device.retain();
		return __result;
	}
	public static int clReleaseDevice(CLDevice device) {
		APIUtil.releaseObjects(device);
		int __result = org.lwjgl.opencl.CL12.clReleaseDevice(device.getPointer());
		if ( __result == CL10.CL_SUCCESS ) device.release();
		return __result;
	}
	public static int clCreateSubDevices(CLDevice in_device, LongBuffer properties, PointerBuffer out_devices, IntBuffer num_devices_ret) {
		int __result = org.lwjgl.opencl.CL12.clCreateSubDevices(in_device.getPointer(), org.lwjgl.system.MemoryUtil.memPointerBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(properties), org.lwjgl.system.Checks.remainingSafe(properties)), out_devices, num_devices_ret);
		if ( __result == CL10.CL_SUCCESS && out_devices != null ) in_device.registerSubCLDevices(out_devices);
		return __result;
	}
	public static CLMem clCreateImage(CLContext context, long flags, ByteBuffer image_format, ByteBuffer image_desc, ByteBuffer host_ptr, IntBuffer errcode_ret) {
		org.lwjgl.opencl.CLMem __result = new org.lwjgl.opencl.CLMem(org.lwjgl.opencl.CL12.clCreateImage(context.getPointer(), flags, org.lwjgl.opencl.CLImageFormat.create(org.lwjgl.system.MemoryUtil.memAddress(image_format)), org.lwjgl.opencl.CLImageDesc.create(org.lwjgl.system.MemoryUtil.memAddress(image_desc)), host_ptr, errcode_ret), context);
		return __result;
	}
	public static CLMem clCreateImage(CLContext context, long flags, ByteBuffer image_format, ByteBuffer image_desc, FloatBuffer host_ptr, IntBuffer errcode_ret) {
		org.lwjgl.opencl.CLMem __result = new org.lwjgl.opencl.CLMem(org.lwjgl.opencl.CL12.clCreateImage(context.getPointer(), flags, org.lwjgl.opencl.CLImageFormat.create(org.lwjgl.system.MemoryUtil.memAddress(image_format)), org.lwjgl.opencl.CLImageDesc.create(org.lwjgl.system.MemoryUtil.memAddress(image_desc)), host_ptr, errcode_ret), context);
		return __result;
	}
	public static CLMem clCreateImage(CLContext context, long flags, ByteBuffer image_format, ByteBuffer image_desc, IntBuffer host_ptr, IntBuffer errcode_ret) {
		org.lwjgl.opencl.CLMem __result = new org.lwjgl.opencl.CLMem(org.lwjgl.opencl.CL12.clCreateImage(context.getPointer(), flags, org.lwjgl.opencl.CLImageFormat.create(org.lwjgl.system.MemoryUtil.memAddress(image_format)), org.lwjgl.opencl.CLImageDesc.create(org.lwjgl.system.MemoryUtil.memAddress(image_desc)), host_ptr, errcode_ret), context);
		return __result;
	}
	public static CLMem clCreateImage(CLContext context, long flags, ByteBuffer image_format, ByteBuffer image_desc, ShortBuffer host_ptr, IntBuffer errcode_ret) {
		org.lwjgl.opencl.CLMem __result = new org.lwjgl.opencl.CLMem(org.lwjgl.opencl.CL12.clCreateImage(context.getPointer(), flags, org.lwjgl.opencl.CLImageFormat.create(org.lwjgl.system.MemoryUtil.memAddress(image_format)), org.lwjgl.opencl.CLImageDesc.create(org.lwjgl.system.MemoryUtil.memAddress(image_desc)), host_ptr, errcode_ret), context);
		return __result;
	}
	public static CLProgram clCreateProgramWithBuiltInKernels(CLContext context, PointerBuffer device_list, ByteBuffer kernel_names, IntBuffer errcode_ret) {
		org.lwjgl.opencl.CLProgram __result = new org.lwjgl.opencl.CLProgram(org.lwjgl.opencl.CL12.clCreateProgramWithBuiltInKernels(context.getPointer(), device_list, kernel_names, errcode_ret), context);
		return __result;
	}
	public static CLProgram clCreateProgramWithBuiltInKernels(CLContext context, PointerBuffer device_list, CharSequence kernel_names, IntBuffer errcode_ret) {
		org.lwjgl.opencl.CLProgram __result = new org.lwjgl.opencl.CLProgram(org.lwjgl.opencl.CL12.clCreateProgramWithBuiltInKernels(context.getPointer(), device_list, kernel_names, errcode_ret), context);
		return __result;
	}
	@Todo("cl")
	public static int clCompileProgram(CLProgram program, PointerBuffer device_list, ByteBuffer options, PointerBuffer input_header, ByteBuffer header_include_name, CLCompileProgramCallback pfn_notify) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static int clCompileProgramMulti(CLProgram program, PointerBuffer device_list, ByteBuffer options, PointerBuffer input_headers, ByteBuffer header_include_names, CLCompileProgramCallback pfn_notify) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static int clCompileProgram(CLProgram program, PointerBuffer device_list, ByteBuffer options, PointerBuffer input_headers, ByteBuffer[] header_include_names, CLCompileProgramCallback pfn_notify) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static int clCompileProgram(CLProgram program, PointerBuffer device_list, CharSequence options, PointerBuffer input_header, CharSequence header_include_name, CLCompileProgramCallback pfn_notify) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static int clCompileProgram(CLProgram program, PointerBuffer device_list, CharSequence options, PointerBuffer input_header, CharSequence[] header_include_name, CLCompileProgramCallback pfn_notify) {
		throw new UnsupportedOperationException();
	}
	public static CLProgram clLinkProgram(CLContext context, PointerBuffer device_list, ByteBuffer options, PointerBuffer input_programs, CLLinkProgramCallback pfn_notify, IntBuffer errcode_ret) {
		long user_data = CallbackUtil.createGlobalRef(pfn_notify);
		if ( pfn_notify != null ) pfn_notify.setContext(context);
		org.lwjgl.opencl.CLProgram __result = null;
		try {
			__result = new org.lwjgl.opencl.CLProgram(org.lwjgl.opencl.CL12.clLinkProgram(context.getPointer(), device_list, options, input_programs, pfn_notify, user_data, errcode_ret), context);
			return __result;
		} finally {
			CallbackUtil.checkCallback(errcode_ret.get(errcode_ret.position()), user_data);
		}
	}
	public static CLProgram clLinkProgram(CLContext context, PointerBuffer device_list, CharSequence options, PointerBuffer input_programs, CLLinkProgramCallback pfn_notify, IntBuffer errcode_ret) {
		long user_data = CallbackUtil.createGlobalRef(pfn_notify);
		if ( pfn_notify != null ) pfn_notify.setContext(context);
		org.lwjgl.opencl.CLProgram __result = null;
		try {
			__result = new org.lwjgl.opencl.CLProgram(org.lwjgl.opencl.CL12.clLinkProgram(context.getPointer(), device_list, options, input_programs, pfn_notify, user_data, errcode_ret), context);
			return __result;
		} finally {
			CallbackUtil.checkCallback(errcode_ret.get(errcode_ret.position()), user_data);
		}
	}
	public static int clUnloadPlatformCompiler(CLPlatform platform) {
		return org.lwjgl.opencl.CL12.clUnloadPlatformCompiler(platform.getPointer());
	}
	public static int clGetKernelArgInfo(CLKernel kernel, int arg_indx, int param_name, ByteBuffer param_value, PointerBuffer param_value_size_ret) {
		return org.lwjgl.opencl.CL12.clGetKernelArgInfo(kernel.getPointer(), arg_indx, param_name, param_value, param_value_size_ret);
	}
	public static int clEnqueueFillBuffer(CLCommandQueue command_queue, CLMem buffer, ByteBuffer pattern, long offset, long size, PointerBuffer event_wait_list, PointerBuffer event) {
		return org.lwjgl.opencl.CL12.clEnqueueFillBuffer(command_queue.getPointer(), buffer.getPointer(), pattern, offset, size, event_wait_list, event);
	}
	public static int clEnqueueFillImage(CLCommandQueue command_queue, CLMem image, ByteBuffer fill_color, PointerBuffer origin, PointerBuffer region, PointerBuffer event_wait_list, PointerBuffer event) {
		return org.lwjgl.opencl.CL12.clEnqueueFillImage(command_queue.getPointer(), image.getPointer(), fill_color, origin, region, event_wait_list, event);
	}
	public static int clEnqueueMigrateMemObjects(CLCommandQueue command_queue, PointerBuffer mem_objects, long flags, PointerBuffer event_wait_list, PointerBuffer event) {
		return org.lwjgl.opencl.CL12.clEnqueueMigrateMemObjects(command_queue.getPointer(), mem_objects, flags, event_wait_list, event);
	}
	public static int clEnqueueMarkerWithWaitList(CLCommandQueue command_queue, PointerBuffer event_wait_list, PointerBuffer event) {
		return org.lwjgl.opencl.CL12.clEnqueueMarkerWithWaitList(command_queue.getPointer(), event_wait_list, event);
	}
	public static int clEnqueueBarrierWithWaitList(CLCommandQueue command_queue, PointerBuffer event_wait_list, PointerBuffer event) {
		return org.lwjgl.opencl.CL12.clEnqueueBarrierWithWaitList(command_queue.getPointer(), event_wait_list, event);
	}
	@Todo("cl")
	public static int clSetPrintfCallback(CLContext context, CLPrintfCallback pfn_notify) {
		throw new UnsupportedOperationException();
	}
}
