package com.koyomiji.lwjgl2w3.generated.org.lwjgl.opencl;

import com.koyomiji.lwjgl2w3.inject.Todo;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.PointerBuffer;
import org.lwjgl.opencl.CLBuildProgramCallback;
import org.lwjgl.opencl.CLCommandQueue;
import org.lwjgl.opencl.CLContext;
import org.lwjgl.opencl.CLContextCallback;
import org.lwjgl.opencl.CLDevice;
import org.lwjgl.opencl.CLEvent;
import org.lwjgl.opencl.CLKernel;
import org.lwjgl.opencl.CLMem;
import org.lwjgl.opencl.CLNativeKernel;
import org.lwjgl.opencl.CLObject;
import org.lwjgl.opencl.CLPlatform;
import org.lwjgl.opencl.CLProgram;
import org.lwjgl.opencl.CLSampler;

public final class CL10 {
	public static final int CL_INVALID_GL_OBJECT = 0xFFFFFFC4;
	public static final int CL_INVALID_MIP_LEVEL = 0xFFFFFFC2;
	public static final int CL_DEVICE_PREFERRED_VECTOR_WIDTH_ = 0x1008;
	@Todo("cl")
	public static int clGetPlatformInfo(CLPlatform platform, int param_name, ByteBuffer param_value, PointerBuffer param_value_size_ret) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static int clGetDeviceIDs(CLPlatform platform, long device_type, PointerBuffer devices, IntBuffer num_devices) {
		throw new UnsupportedOperationException();
	}
	public static int clGetDeviceInfo(CLDevice device, int param_name, ByteBuffer param_value, PointerBuffer param_value_size_ret) {
		return org.lwjgl.opencl.CL10.clGetDeviceInfo(device.getPointer(), param_name, param_value, param_value_size_ret);
	}
	@Todo("cl")
	public static CLContext clCreateContext(PointerBuffer properties, PointerBuffer devices, CLContextCallback pfn_notify, IntBuffer errcode_ret) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static CLContext clCreateContext(PointerBuffer properties, CLDevice device, CLContextCallback pfn_notify, IntBuffer errcode_ret) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static CLContext clCreateContextFromType(PointerBuffer properties, long device_type, CLContextCallback pfn_notify, IntBuffer errcode_ret) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static int clRetainContext(CLContext context) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static int clReleaseContext(CLContext context) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static int clGetContextInfo(CLContext context, int param_name, ByteBuffer param_value, PointerBuffer param_value_size_ret) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static CLCommandQueue clCreateCommandQueue(CLContext context, CLDevice device, long properties, IntBuffer errcode_ret) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static int clRetainCommandQueue(CLCommandQueue command_queue) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static int clReleaseCommandQueue(CLCommandQueue command_queue) {
		throw new UnsupportedOperationException();
	}
	public static int clGetCommandQueueInfo(CLCommandQueue command_queue, int param_name, ByteBuffer param_value, PointerBuffer param_value_size_ret) {
		return org.lwjgl.opencl.CL10.clGetCommandQueueInfo(command_queue.getPointer(), param_name, param_value, param_value_size_ret);
	}
	@Todo("cl")
	public static CLMem clCreateBuffer(CLContext context, long flags, long host_ptr_size, IntBuffer errcode_ret) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static CLMem clCreateBuffer(CLContext context, long flags, ByteBuffer host_ptr, IntBuffer errcode_ret) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static CLMem clCreateBuffer(CLContext context, long flags, DoubleBuffer host_ptr, IntBuffer errcode_ret) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static CLMem clCreateBuffer(CLContext context, long flags, FloatBuffer host_ptr, IntBuffer errcode_ret) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static CLMem clCreateBuffer(CLContext context, long flags, IntBuffer host_ptr, IntBuffer errcode_ret) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static CLMem clCreateBuffer(CLContext context, long flags, LongBuffer host_ptr, IntBuffer errcode_ret) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static CLMem clCreateBuffer(CLContext context, long flags, ShortBuffer host_ptr, IntBuffer errcode_ret) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static int clEnqueueReadBuffer(CLCommandQueue command_queue, CLMem buffer, int blocking_read, long offset, ByteBuffer ptr, PointerBuffer event_wait_list, PointerBuffer event) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static int clEnqueueReadBuffer(CLCommandQueue command_queue, CLMem buffer, int blocking_read, long offset, DoubleBuffer ptr, PointerBuffer event_wait_list, PointerBuffer event) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static int clEnqueueReadBuffer(CLCommandQueue command_queue, CLMem buffer, int blocking_read, long offset, FloatBuffer ptr, PointerBuffer event_wait_list, PointerBuffer event) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static int clEnqueueReadBuffer(CLCommandQueue command_queue, CLMem buffer, int blocking_read, long offset, IntBuffer ptr, PointerBuffer event_wait_list, PointerBuffer event) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static int clEnqueueReadBuffer(CLCommandQueue command_queue, CLMem buffer, int blocking_read, long offset, LongBuffer ptr, PointerBuffer event_wait_list, PointerBuffer event) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static int clEnqueueReadBuffer(CLCommandQueue command_queue, CLMem buffer, int blocking_read, long offset, ShortBuffer ptr, PointerBuffer event_wait_list, PointerBuffer event) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static int clEnqueueWriteBuffer(CLCommandQueue command_queue, CLMem buffer, int blocking_write, long offset, ByteBuffer ptr, PointerBuffer event_wait_list, PointerBuffer event) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static int clEnqueueWriteBuffer(CLCommandQueue command_queue, CLMem buffer, int blocking_write, long offset, DoubleBuffer ptr, PointerBuffer event_wait_list, PointerBuffer event) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static int clEnqueueWriteBuffer(CLCommandQueue command_queue, CLMem buffer, int blocking_write, long offset, FloatBuffer ptr, PointerBuffer event_wait_list, PointerBuffer event) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static int clEnqueueWriteBuffer(CLCommandQueue command_queue, CLMem buffer, int blocking_write, long offset, IntBuffer ptr, PointerBuffer event_wait_list, PointerBuffer event) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static int clEnqueueWriteBuffer(CLCommandQueue command_queue, CLMem buffer, int blocking_write, long offset, LongBuffer ptr, PointerBuffer event_wait_list, PointerBuffer event) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static int clEnqueueWriteBuffer(CLCommandQueue command_queue, CLMem buffer, int blocking_write, long offset, ShortBuffer ptr, PointerBuffer event_wait_list, PointerBuffer event) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static int clEnqueueCopyBuffer(CLCommandQueue command_queue, CLMem src_buffer, CLMem dst_buffer, long src_offset, long dst_offset, long size, PointerBuffer event_wait_list, PointerBuffer event) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static ByteBuffer clEnqueueMapBuffer(CLCommandQueue command_queue, CLMem buffer, int blocking_map, long map_flags, long offset, long size, PointerBuffer event_wait_list, PointerBuffer event, IntBuffer errcode_ret) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static CLMem clCreateImage2D(CLContext context, long flags, ByteBuffer image_format, long image_width, long image_height, long image_row_pitch, ByteBuffer host_ptr, IntBuffer errcode_ret) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static CLMem clCreateImage2D(CLContext context, long flags, ByteBuffer image_format, long image_width, long image_height, long image_row_pitch, FloatBuffer host_ptr, IntBuffer errcode_ret) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static CLMem clCreateImage2D(CLContext context, long flags, ByteBuffer image_format, long image_width, long image_height, long image_row_pitch, IntBuffer host_ptr, IntBuffer errcode_ret) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static CLMem clCreateImage2D(CLContext context, long flags, ByteBuffer image_format, long image_width, long image_height, long image_row_pitch, ShortBuffer host_ptr, IntBuffer errcode_ret) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static CLMem clCreateImage3D(CLContext context, long flags, ByteBuffer image_format, long image_width, long image_height, long image_depth, long image_row_pitch, long image_slice_pitch, ByteBuffer host_ptr, IntBuffer errcode_ret) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static CLMem clCreateImage3D(CLContext context, long flags, ByteBuffer image_format, long image_width, long image_height, long image_depth, long image_row_pitch, long image_slice_pitch, FloatBuffer host_ptr, IntBuffer errcode_ret) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static CLMem clCreateImage3D(CLContext context, long flags, ByteBuffer image_format, long image_width, long image_height, long image_depth, long image_row_pitch, long image_slice_pitch, IntBuffer host_ptr, IntBuffer errcode_ret) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static CLMem clCreateImage3D(CLContext context, long flags, ByteBuffer image_format, long image_width, long image_height, long image_depth, long image_row_pitch, long image_slice_pitch, ShortBuffer host_ptr, IntBuffer errcode_ret) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static int clGetSupportedImageFormats(CLContext context, long flags, int image_type, ByteBuffer image_formats, IntBuffer num_image_formats) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static int clEnqueueReadImage(CLCommandQueue command_queue, CLMem image, int blocking_read, PointerBuffer origin, PointerBuffer region, long row_pitch, long slice_pitch, ByteBuffer ptr, PointerBuffer event_wait_list, PointerBuffer event) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static int clEnqueueReadImage(CLCommandQueue command_queue, CLMem image, int blocking_read, PointerBuffer origin, PointerBuffer region, long row_pitch, long slice_pitch, FloatBuffer ptr, PointerBuffer event_wait_list, PointerBuffer event) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static int clEnqueueReadImage(CLCommandQueue command_queue, CLMem image, int blocking_read, PointerBuffer origin, PointerBuffer region, long row_pitch, long slice_pitch, IntBuffer ptr, PointerBuffer event_wait_list, PointerBuffer event) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static int clEnqueueReadImage(CLCommandQueue command_queue, CLMem image, int blocking_read, PointerBuffer origin, PointerBuffer region, long row_pitch, long slice_pitch, ShortBuffer ptr, PointerBuffer event_wait_list, PointerBuffer event) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static int clEnqueueWriteImage(CLCommandQueue command_queue, CLMem image, int blocking_write, PointerBuffer origin, PointerBuffer region, long input_row_pitch, long input_slice_pitch, ByteBuffer ptr, PointerBuffer event_wait_list, PointerBuffer event) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static int clEnqueueWriteImage(CLCommandQueue command_queue, CLMem image, int blocking_write, PointerBuffer origin, PointerBuffer region, long input_row_pitch, long input_slice_pitch, FloatBuffer ptr, PointerBuffer event_wait_list, PointerBuffer event) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static int clEnqueueWriteImage(CLCommandQueue command_queue, CLMem image, int blocking_write, PointerBuffer origin, PointerBuffer region, long input_row_pitch, long input_slice_pitch, IntBuffer ptr, PointerBuffer event_wait_list, PointerBuffer event) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static int clEnqueueWriteImage(CLCommandQueue command_queue, CLMem image, int blocking_write, PointerBuffer origin, PointerBuffer region, long input_row_pitch, long input_slice_pitch, ShortBuffer ptr, PointerBuffer event_wait_list, PointerBuffer event) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static int clEnqueueCopyImage(CLCommandQueue command_queue, CLMem src_image, CLMem dst_image, PointerBuffer src_origin, PointerBuffer dst_origin, PointerBuffer region, PointerBuffer event_wait_list, PointerBuffer event) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static int clEnqueueCopyImageToBuffer(CLCommandQueue command_queue, CLMem src_image, CLMem dst_buffer, PointerBuffer src_origin, PointerBuffer region, long dst_offset, PointerBuffer event_wait_list, PointerBuffer event) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static int clEnqueueCopyBufferToImage(CLCommandQueue command_queue, CLMem src_buffer, CLMem dst_image, long src_offset, PointerBuffer dst_origin, PointerBuffer region, PointerBuffer event_wait_list, PointerBuffer event) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static ByteBuffer clEnqueueMapImage(CLCommandQueue command_queue, CLMem image, int blocking_map, long map_flags, PointerBuffer origin, PointerBuffer region, PointerBuffer image_row_pitch, PointerBuffer image_slice_pitch, PointerBuffer event_wait_list, PointerBuffer event, IntBuffer errcode_ret) {
		throw new UnsupportedOperationException();
	}
	public static int clGetImageInfo(CLMem image, int param_name, ByteBuffer param_value, PointerBuffer param_value_size_ret) {
		return org.lwjgl.opencl.CL10.clGetImageInfo(image.getPointer(), param_name, param_value, param_value_size_ret);
	}
	@Todo("cl")
	public static int clRetainMemObject(CLMem memobj) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static int clReleaseMemObject(CLMem memobj) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static int clEnqueueUnmapMemObject(CLCommandQueue command_queue, CLMem memobj, ByteBuffer mapped_ptr, PointerBuffer event_wait_list, PointerBuffer event) {
		throw new UnsupportedOperationException();
	}
	public static int clGetMemObjectInfo(CLMem memobj, int param_name, ByteBuffer param_value, PointerBuffer param_value_size_ret) {
		return org.lwjgl.opencl.CL10.clGetMemObjectInfo(memobj.getPointer(), param_name, param_value, param_value_size_ret);
	}
	@Todo("cl")
	public static CLSampler clCreateSampler(CLContext context, int normalized_coords, int addressing_mode, int filter_mode, IntBuffer errcode_ret) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static int clRetainSampler(CLSampler sampler) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static int clReleaseSampler(CLSampler sampler) {
		throw new UnsupportedOperationException();
	}
	public static int clGetSamplerInfo(CLSampler sampler, int param_name, ByteBuffer param_value, PointerBuffer param_value_size_ret) {
		return org.lwjgl.opencl.CL10.clGetSamplerInfo(sampler.getPointer(), param_name, param_value, param_value_size_ret);
	}
	@Todo("cl")
	public static CLProgram clCreateProgramWithSource(CLContext context, ByteBuffer string, IntBuffer errcode_ret) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static CLProgram clCreateProgramWithSource(CLContext context, ByteBuffer strings, PointerBuffer lengths, IntBuffer errcode_ret) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static CLProgram clCreateProgramWithSource(CLContext context, ByteBuffer[] strings, IntBuffer errcode_ret) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static CLProgram clCreateProgramWithSource(CLContext context, CharSequence string, IntBuffer errcode_ret) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static CLProgram clCreateProgramWithSource(CLContext context, CharSequence[] strings, IntBuffer errcode_ret) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static CLProgram clCreateProgramWithBinary(CLContext context, CLDevice device, ByteBuffer binary, IntBuffer binary_status, IntBuffer errcode_ret) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static CLProgram clCreateProgramWithBinary(CLContext context, PointerBuffer device_list, PointerBuffer lengths, ByteBuffer binaries, IntBuffer binary_status, IntBuffer errcode_ret) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static CLProgram clCreateProgramWithBinary(CLContext context, PointerBuffer device_list, ByteBuffer[] binaries, IntBuffer binary_status, IntBuffer errcode_ret) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static int clRetainProgram(CLProgram program) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static int clReleaseProgram(CLProgram program) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static int clBuildProgram(CLProgram program, PointerBuffer device_list, ByteBuffer options, CLBuildProgramCallback pfn_notify) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static int clBuildProgram(CLProgram program, PointerBuffer device_list, CharSequence options, CLBuildProgramCallback pfn_notify) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static int clBuildProgram(CLProgram program, CLDevice device, CharSequence options, CLBuildProgramCallback pfn_notify) {
		throw new UnsupportedOperationException();
	}
	public static int clGetProgramInfo(CLProgram program, int param_name, ByteBuffer param_value, PointerBuffer param_value_size_ret) {
		return org.lwjgl.opencl.CL10.clGetProgramInfo(program.getPointer(), param_name, param_value, param_value_size_ret);
	}
	@Todo("cl")
	public static int clGetProgramInfo(CLProgram program, PointerBuffer sizes, ByteBuffer param_value, PointerBuffer param_value_size_ret) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static int clGetProgramInfo(CLProgram program, ByteBuffer[] param_value, PointerBuffer param_value_size_ret) {
		throw new UnsupportedOperationException();
	}
	public static int clGetProgramBuildInfo(CLProgram program, CLDevice device, int param_name, ByteBuffer param_value, PointerBuffer param_value_size_ret) {
		return org.lwjgl.opencl.CL10.clGetProgramBuildInfo(program.getPointer(), device.getPointer(), param_name, param_value, param_value_size_ret);
	}
	@Todo("cl")
	public static CLKernel clCreateKernel(CLProgram program, ByteBuffer kernel_name, IntBuffer errcode_ret) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static CLKernel clCreateKernel(CLProgram program, CharSequence kernel_name, IntBuffer errcode_ret) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static int clCreateKernelsInProgram(CLProgram program, PointerBuffer kernels, IntBuffer num_kernels_ret) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static int clRetainKernel(CLKernel kernel) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static int clReleaseKernel(CLKernel kernel) {
		throw new UnsupportedOperationException();
	}
	public static int clSetKernelArg(CLKernel kernel, int arg_index, long arg_value_arg_size) {
		return org.lwjgl.opencl.CL10.clSetKernelArg(kernel.getPointer(), arg_index, arg_value_arg_size);
	}
	public static int clSetKernelArg(CLKernel kernel, int arg_index, ByteBuffer arg_value) {
		return org.lwjgl.opencl.CL10.clSetKernelArg(kernel.getPointer(), arg_index, arg_value);
	}
	public static int clSetKernelArg(CLKernel kernel, int arg_index, DoubleBuffer arg_value) {
		return org.lwjgl.opencl.CL10.clSetKernelArg(kernel.getPointer(), arg_index, arg_value);
	}
	public static int clSetKernelArg(CLKernel kernel, int arg_index, FloatBuffer arg_value) {
		return org.lwjgl.opencl.CL10.clSetKernelArg(kernel.getPointer(), arg_index, arg_value);
	}
	public static int clSetKernelArg(CLKernel kernel, int arg_index, IntBuffer arg_value) {
		return org.lwjgl.opencl.CL10.clSetKernelArg(kernel.getPointer(), arg_index, arg_value);
	}
	public static int clSetKernelArg(CLKernel kernel, int arg_index, LongBuffer arg_value) {
		return org.lwjgl.opencl.CL10.clSetKernelArg(kernel.getPointer(), arg_index, arg_value);
	}
	public static int clSetKernelArg(CLKernel kernel, int arg_index, ShortBuffer arg_value) {
		return org.lwjgl.opencl.CL10.clSetKernelArg(kernel.getPointer(), arg_index, arg_value);
	}
	@Todo("cl")
	public static int clSetKernelArg(CLKernel kernel, int arg_index, CLObject arg_value) {
		throw new UnsupportedOperationException();
	}
	public static int clGetKernelInfo(CLKernel kernel, int param_name, ByteBuffer param_value, PointerBuffer param_value_size_ret) {
		return org.lwjgl.opencl.CL10.clGetKernelInfo(kernel.getPointer(), param_name, param_value, param_value_size_ret);
	}
	@Todo("cl")
	public static int clGetKernelWorkGroupInfo(CLKernel kernel, CLDevice device, int param_name, ByteBuffer param_value, PointerBuffer param_value_size_ret) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static int clEnqueueNDRangeKernel(CLCommandQueue command_queue, CLKernel kernel, int work_dim, PointerBuffer global_work_offset, PointerBuffer global_work_size, PointerBuffer local_work_size, PointerBuffer event_wait_list, PointerBuffer event) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static int clEnqueueTask(CLCommandQueue command_queue, CLKernel kernel, PointerBuffer event_wait_list, PointerBuffer event) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static int clEnqueueNativeKernel(CLCommandQueue command_queue, CLNativeKernel user_func, CLMem[] mem_list, long[] sizes, PointerBuffer event_wait_list, PointerBuffer event) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static int clWaitForEvents(CLEvent event) {
		throw new UnsupportedOperationException();
	}
	public static int clGetEventInfo(CLEvent event, int param_name, ByteBuffer param_value, PointerBuffer param_value_size_ret) {
		return org.lwjgl.opencl.CL10.clGetEventInfo(event.getPointer(), param_name, param_value, param_value_size_ret);
	}
	@Todo("cl")
	public static int clRetainEvent(CLEvent event) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static int clReleaseEvent(CLEvent event) {
		throw new UnsupportedOperationException();
	}
	@Todo("cl")
	public static int clEnqueueMarker(CLCommandQueue command_queue, PointerBuffer event) {
		throw new UnsupportedOperationException();
	}
	public static int clEnqueueBarrier(CLCommandQueue command_queue) {
		return org.lwjgl.opencl.CL10.clEnqueueBarrier(command_queue.getPointer());
	}
	public static int clEnqueueWaitForEvents(CLCommandQueue command_queue, PointerBuffer event_list) {
		return org.lwjgl.opencl.CL10.clEnqueueWaitForEvents(command_queue.getPointer(), event_list);
	}
	@Todo("cl")
	public static int clEnqueueWaitForEvents(CLCommandQueue command_queue, CLEvent event) {
		throw new UnsupportedOperationException();
	}
	public static int clGetEventProfilingInfo(CLEvent event, int param_name, ByteBuffer param_value, PointerBuffer param_value_size_ret) {
		return org.lwjgl.opencl.CL10.clGetEventProfilingInfo(event.getPointer(), param_name, param_value, param_value_size_ret);
	}
	public static int clFlush(CLCommandQueue command_queue) {
		return org.lwjgl.opencl.CL10.clFlush(command_queue.getPointer());
	}
	public static int clFinish(CLCommandQueue command_queue) {
		return org.lwjgl.opencl.CL10.clFinish(command_queue.getPointer());
	}
}
