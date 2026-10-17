package org.lwjgl.opencl;

import com.koyomiji.dualwjgl.inject.Generated;
import com.koyomiji.dualwjgl.inject.Into;
import com.koyomiji.dualwjgl.inject.Todo;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.PointerBuffer;

@Generated
@Into(CL10.class)
final class CL10Generated {
	public static final int CL_INVALID_GL_OBJECT = 0xFFFFFFC4;
	public static final int CL_INVALID_MIP_LEVEL = 0xFFFFFFC2;
	public static final int CL_DEVICE_PREFERRED_VECTOR_WIDTH_ = 0x1008;
	public static int clGetPlatformInfo(CLPlatform platform, int param_name, ByteBuffer param_value, PointerBuffer param_value_size_ret) {
		return org.lwjgl.opencl.CL10.clGetPlatformInfo((platform == null ? 0L : platform.getPointer()), param_name, param_value, param_value_size_ret);
	}
	public static int clGetDeviceIDs(CLPlatform platform, long device_type, PointerBuffer devices, IntBuffer num_devices) {
		if ( num_devices == null )
			num_devices = APIUtil.getBufferInt();
		int __result = org.lwjgl.opencl.CL10.clGetDeviceIDs(platform.getPointer(), device_type, devices, num_devices);
		if ( __result == CL10.CL_SUCCESS && devices != null ) platform.registerCLDevices(devices, num_devices);
		return __result;
	}
	public static int clGetDeviceInfo(CLDevice device, int param_name, ByteBuffer param_value, PointerBuffer param_value_size_ret) {
		return org.lwjgl.opencl.CL10.clGetDeviceInfo(device.getPointer(), param_name, param_value, param_value_size_ret);
	}
	public static CLContext clCreateContext(PointerBuffer properties, PointerBuffer devices, CLContextCallback pfn_notify, IntBuffer errcode_ret) {
		long user_data = pfn_notify == null || pfn_notify.isCustom() ? 0 : CallbackUtil.createGlobalRef(pfn_notify);
		org.lwjgl.opencl.CLContext __result = null;
		try {
			__result = new org.lwjgl.opencl.CLContext(org.lwjgl.opencl.CL10.clCreateContext(properties, devices, pfn_notify, user_data, errcode_ret), APIUtil.getCLPlatform(properties));
			return __result;
		} finally {
			if ( __result != null ) __result.setContextCallback(user_data);
		}
	}
	public static CLContext clCreateContext(PointerBuffer properties, CLDevice device, CLContextCallback pfn_notify, IntBuffer errcode_ret) {
		try (org.lwjgl.system.MemoryStack __stack = org.lwjgl.system.MemoryStack.stackPush()) {
			org.lwjgl.PointerBuffer __p1 = __stack.pointers(device.getPointer());
			long user_data = pfn_notify == null || pfn_notify.isCustom() ? 0 : CallbackUtil.createGlobalRef(pfn_notify);
			org.lwjgl.opencl.CLContext __result = null;
			try {
				__result = new org.lwjgl.opencl.CLContext(org.lwjgl.opencl.CL10.clCreateContext(properties, __p1, pfn_notify, user_data, errcode_ret), APIUtil.getCLPlatform(properties));
				return __result;
			} finally {
				if ( __result != null ) __result.setContextCallback(user_data);
			}
		}
	}
	public static CLContext clCreateContextFromType(PointerBuffer properties, long device_type, CLContextCallback pfn_notify, IntBuffer errcode_ret) {
		long user_data = pfn_notify == null || pfn_notify.isCustom() ? 0 : CallbackUtil.createGlobalRef(pfn_notify);
		org.lwjgl.opencl.CLContext __result = null;
		try {
			__result = new org.lwjgl.opencl.CLContext(org.lwjgl.opencl.CL10.clCreateContextFromType(properties, device_type, pfn_notify, user_data, errcode_ret), APIUtil.getCLPlatform(properties));
			return __result;
		} finally {
			if ( __result != null ) __result.setContextCallback(user_data);
		}
	}
	public static int clRetainContext(CLContext context) {
		int __result = org.lwjgl.opencl.CL10.clRetainContext(context.getPointer());
		if ( __result == CL10.CL_SUCCESS ) context.retain();
		return __result;
	}
	public static int clReleaseContext(CLContext context) {
		APIUtil.releaseObjects(context);
		int __result = org.lwjgl.opencl.CL10.clReleaseContext(context.getPointer());
		if ( __result == CL10.CL_SUCCESS ) context.releaseImpl();
		return __result;
	}
	public static int clGetContextInfo(CLContext context, int param_name, ByteBuffer param_value, PointerBuffer param_value_size_ret) {
		if ( param_value_size_ret == null && APIUtil.isDevicesParam(param_name) ) param_value_size_ret = APIUtil.getBufferPointer();
		int __result = org.lwjgl.opencl.CL10.clGetContextInfo(context.getPointer(), param_name, param_value, param_value_size_ret);
		if ( __result == CL10.CL_SUCCESS && param_value != null && APIUtil.isDevicesParam(param_name) ) context.getParent().registerCLDevices(param_value, param_value_size_ret);
		return __result;
	}
	public static CLCommandQueue clCreateCommandQueue(CLContext context, CLDevice device, long properties, IntBuffer errcode_ret) {
		org.lwjgl.opencl.CLCommandQueue __result = new org.lwjgl.opencl.CLCommandQueue(org.lwjgl.opencl.CL10.clCreateCommandQueue(context.getPointer(), device.getPointer(), properties, errcode_ret), context, device);
		return __result;
	}
	public static int clRetainCommandQueue(CLCommandQueue command_queue) {
		int __result = org.lwjgl.opencl.CL10.clRetainCommandQueue(command_queue.getPointer());
		if ( __result == CL10.CL_SUCCESS ) command_queue.retain();
		return __result;
	}
	public static int clReleaseCommandQueue(CLCommandQueue command_queue) {
		APIUtil.releaseObjects(command_queue);
		int __result = org.lwjgl.opencl.CL10.clReleaseCommandQueue(command_queue.getPointer());
		if ( __result == CL10.CL_SUCCESS ) command_queue.release();
		return __result;
	}
	public static int clGetCommandQueueInfo(CLCommandQueue command_queue, int param_name, ByteBuffer param_value, PointerBuffer param_value_size_ret) {
		return org.lwjgl.opencl.CL10.clGetCommandQueueInfo(command_queue.getPointer(), param_name, param_value, param_value_size_ret);
	}
	public static CLMem clCreateBuffer(CLContext context, long flags, long host_ptr_size, IntBuffer errcode_ret) {
		org.lwjgl.opencl.CLMem __result = new org.lwjgl.opencl.CLMem(org.lwjgl.opencl.CL10.clCreateBuffer(context.getPointer(), flags, host_ptr_size, errcode_ret), context);
		return __result;
	}
	public static CLMem clCreateBuffer(CLContext context, long flags, ByteBuffer host_ptr, IntBuffer errcode_ret) {
		org.lwjgl.opencl.CLMem __result = new org.lwjgl.opencl.CLMem(org.lwjgl.opencl.CL10.clCreateBuffer(context.getPointer(), flags, host_ptr, errcode_ret), context);
		return __result;
	}
	public static CLMem clCreateBuffer(CLContext context, long flags, DoubleBuffer host_ptr, IntBuffer errcode_ret) {
		org.lwjgl.opencl.CLMem __result = new org.lwjgl.opencl.CLMem(org.lwjgl.opencl.CL10.clCreateBuffer(context.getPointer(), flags, host_ptr, errcode_ret), context);
		return __result;
	}
	public static CLMem clCreateBuffer(CLContext context, long flags, FloatBuffer host_ptr, IntBuffer errcode_ret) {
		org.lwjgl.opencl.CLMem __result = new org.lwjgl.opencl.CLMem(org.lwjgl.opencl.CL10.clCreateBuffer(context.getPointer(), flags, host_ptr, errcode_ret), context);
		return __result;
	}
	public static CLMem clCreateBuffer(CLContext context, long flags, IntBuffer host_ptr, IntBuffer errcode_ret) {
		org.lwjgl.opencl.CLMem __result = new org.lwjgl.opencl.CLMem(org.lwjgl.opencl.CL10.clCreateBuffer(context.getPointer(), flags, host_ptr, errcode_ret), context);
		return __result;
	}
	public static CLMem clCreateBuffer(CLContext context, long flags, LongBuffer host_ptr, IntBuffer errcode_ret) {
		org.lwjgl.opencl.CLMem __result = new org.lwjgl.opencl.CLMem(org.lwjgl.opencl.CL10.clCreateBuffer(context.getPointer(), flags, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(host_ptr), (org.lwjgl.system.Checks.remainingSafe(host_ptr) << 3)), errcode_ret), context);
		return __result;
	}
	public static CLMem clCreateBuffer(CLContext context, long flags, ShortBuffer host_ptr, IntBuffer errcode_ret) {
		org.lwjgl.opencl.CLMem __result = new org.lwjgl.opencl.CLMem(org.lwjgl.opencl.CL10.clCreateBuffer(context.getPointer(), flags, host_ptr, errcode_ret), context);
		return __result;
	}
	public static int clEnqueueReadBuffer(CLCommandQueue command_queue, CLMem buffer, int blocking_read, long offset, ByteBuffer ptr, PointerBuffer event_wait_list, PointerBuffer event) {
		int __result = org.lwjgl.opencl.CL10.clEnqueueReadBuffer(command_queue.getPointer(), buffer.getPointer(), (blocking_read != 0), offset, ptr, event_wait_list, event);
		if ( __result == CL10.CL_SUCCESS ) command_queue.registerCLEvent(event);
		return __result;
	}
	public static int clEnqueueReadBuffer(CLCommandQueue command_queue, CLMem buffer, int blocking_read, long offset, DoubleBuffer ptr, PointerBuffer event_wait_list, PointerBuffer event) {
		int __result = org.lwjgl.opencl.CL10.clEnqueueReadBuffer(command_queue.getPointer(), buffer.getPointer(), (blocking_read != 0), offset, ptr, event_wait_list, event);
		if ( __result == CL10.CL_SUCCESS ) command_queue.registerCLEvent(event);
		return __result;
	}
	public static int clEnqueueReadBuffer(CLCommandQueue command_queue, CLMem buffer, int blocking_read, long offset, FloatBuffer ptr, PointerBuffer event_wait_list, PointerBuffer event) {
		int __result = org.lwjgl.opencl.CL10.clEnqueueReadBuffer(command_queue.getPointer(), buffer.getPointer(), (blocking_read != 0), offset, ptr, event_wait_list, event);
		if ( __result == CL10.CL_SUCCESS ) command_queue.registerCLEvent(event);
		return __result;
	}
	public static int clEnqueueReadBuffer(CLCommandQueue command_queue, CLMem buffer, int blocking_read, long offset, IntBuffer ptr, PointerBuffer event_wait_list, PointerBuffer event) {
		int __result = org.lwjgl.opencl.CL10.clEnqueueReadBuffer(command_queue.getPointer(), buffer.getPointer(), (blocking_read != 0), offset, ptr, event_wait_list, event);
		if ( __result == CL10.CL_SUCCESS ) command_queue.registerCLEvent(event);
		return __result;
	}
	public static int clEnqueueReadBuffer(CLCommandQueue command_queue, CLMem buffer, int blocking_read, long offset, LongBuffer ptr, PointerBuffer event_wait_list, PointerBuffer event) {
		int __result = org.lwjgl.opencl.CL10.clEnqueueReadBuffer(command_queue.getPointer(), buffer.getPointer(), (blocking_read != 0), offset, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(ptr), (org.lwjgl.system.Checks.remainingSafe(ptr) << 3)), event_wait_list, event);
		if ( __result == CL10.CL_SUCCESS ) command_queue.registerCLEvent(event);
		return __result;
	}
	public static int clEnqueueReadBuffer(CLCommandQueue command_queue, CLMem buffer, int blocking_read, long offset, ShortBuffer ptr, PointerBuffer event_wait_list, PointerBuffer event) {
		int __result = org.lwjgl.opencl.CL10.clEnqueueReadBuffer(command_queue.getPointer(), buffer.getPointer(), (blocking_read != 0), offset, ptr, event_wait_list, event);
		if ( __result == CL10.CL_SUCCESS ) command_queue.registerCLEvent(event);
		return __result;
	}
	public static int clEnqueueWriteBuffer(CLCommandQueue command_queue, CLMem buffer, int blocking_write, long offset, ByteBuffer ptr, PointerBuffer event_wait_list, PointerBuffer event) {
		int __result = org.lwjgl.opencl.CL10.clEnqueueWriteBuffer(command_queue.getPointer(), buffer.getPointer(), (blocking_write != 0), offset, ptr, event_wait_list, event);
		if ( __result == CL10.CL_SUCCESS ) command_queue.registerCLEvent(event);
		return __result;
	}
	public static int clEnqueueWriteBuffer(CLCommandQueue command_queue, CLMem buffer, int blocking_write, long offset, DoubleBuffer ptr, PointerBuffer event_wait_list, PointerBuffer event) {
		int __result = org.lwjgl.opencl.CL10.clEnqueueWriteBuffer(command_queue.getPointer(), buffer.getPointer(), (blocking_write != 0), offset, ptr, event_wait_list, event);
		if ( __result == CL10.CL_SUCCESS ) command_queue.registerCLEvent(event);
		return __result;
	}
	public static int clEnqueueWriteBuffer(CLCommandQueue command_queue, CLMem buffer, int blocking_write, long offset, FloatBuffer ptr, PointerBuffer event_wait_list, PointerBuffer event) {
		int __result = org.lwjgl.opencl.CL10.clEnqueueWriteBuffer(command_queue.getPointer(), buffer.getPointer(), (blocking_write != 0), offset, ptr, event_wait_list, event);
		if ( __result == CL10.CL_SUCCESS ) command_queue.registerCLEvent(event);
		return __result;
	}
	public static int clEnqueueWriteBuffer(CLCommandQueue command_queue, CLMem buffer, int blocking_write, long offset, IntBuffer ptr, PointerBuffer event_wait_list, PointerBuffer event) {
		int __result = org.lwjgl.opencl.CL10.clEnqueueWriteBuffer(command_queue.getPointer(), buffer.getPointer(), (blocking_write != 0), offset, ptr, event_wait_list, event);
		if ( __result == CL10.CL_SUCCESS ) command_queue.registerCLEvent(event);
		return __result;
	}
	public static int clEnqueueWriteBuffer(CLCommandQueue command_queue, CLMem buffer, int blocking_write, long offset, LongBuffer ptr, PointerBuffer event_wait_list, PointerBuffer event) {
		int __result = org.lwjgl.opencl.CL10.clEnqueueWriteBuffer(command_queue.getPointer(), buffer.getPointer(), (blocking_write != 0), offset, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(ptr), (org.lwjgl.system.Checks.remainingSafe(ptr) << 3)), event_wait_list, event);
		if ( __result == CL10.CL_SUCCESS ) command_queue.registerCLEvent(event);
		return __result;
	}
	public static int clEnqueueWriteBuffer(CLCommandQueue command_queue, CLMem buffer, int blocking_write, long offset, ShortBuffer ptr, PointerBuffer event_wait_list, PointerBuffer event) {
		int __result = org.lwjgl.opencl.CL10.clEnqueueWriteBuffer(command_queue.getPointer(), buffer.getPointer(), (blocking_write != 0), offset, ptr, event_wait_list, event);
		if ( __result == CL10.CL_SUCCESS ) command_queue.registerCLEvent(event);
		return __result;
	}
	public static int clEnqueueCopyBuffer(CLCommandQueue command_queue, CLMem src_buffer, CLMem dst_buffer, long src_offset, long dst_offset, long size, PointerBuffer event_wait_list, PointerBuffer event) {
		int __result = org.lwjgl.opencl.CL10.clEnqueueCopyBuffer(command_queue.getPointer(), src_buffer.getPointer(), dst_buffer.getPointer(), src_offset, dst_offset, size, event_wait_list, event);
		if ( __result == CL10.CL_SUCCESS ) command_queue.registerCLEvent(event);
		return __result;
	}
	@Todo("cl")
	public static ByteBuffer clEnqueueMapBuffer(CLCommandQueue command_queue, CLMem buffer, int blocking_map, long map_flags, long offset, long size, PointerBuffer event_wait_list, PointerBuffer event, IntBuffer errcode_ret) {
		throw new UnsupportedOperationException();
	}
	public static CLMem clCreateImage2D(CLContext context, long flags, ByteBuffer image_format, long image_width, long image_height, long image_row_pitch, ByteBuffer host_ptr, IntBuffer errcode_ret) {
		org.lwjgl.opencl.CLMem __result = new org.lwjgl.opencl.CLMem(org.lwjgl.opencl.CL10.clCreateImage2D(context.getPointer(), flags, org.lwjgl.opencl.CLImageFormat.create(org.lwjgl.system.MemoryUtil.memAddress(image_format)), image_width, image_height, image_row_pitch, host_ptr, errcode_ret), context);
		return __result;
	}
	public static CLMem clCreateImage2D(CLContext context, long flags, ByteBuffer image_format, long image_width, long image_height, long image_row_pitch, FloatBuffer host_ptr, IntBuffer errcode_ret) {
		org.lwjgl.opencl.CLMem __result = new org.lwjgl.opencl.CLMem(org.lwjgl.opencl.CL10.clCreateImage2D(context.getPointer(), flags, org.lwjgl.opencl.CLImageFormat.create(org.lwjgl.system.MemoryUtil.memAddress(image_format)), image_width, image_height, image_row_pitch, host_ptr, errcode_ret), context);
		return __result;
	}
	public static CLMem clCreateImage2D(CLContext context, long flags, ByteBuffer image_format, long image_width, long image_height, long image_row_pitch, IntBuffer host_ptr, IntBuffer errcode_ret) {
		org.lwjgl.opencl.CLMem __result = new org.lwjgl.opencl.CLMem(org.lwjgl.opencl.CL10.clCreateImage2D(context.getPointer(), flags, org.lwjgl.opencl.CLImageFormat.create(org.lwjgl.system.MemoryUtil.memAddress(image_format)), image_width, image_height, image_row_pitch, host_ptr, errcode_ret), context);
		return __result;
	}
	public static CLMem clCreateImage2D(CLContext context, long flags, ByteBuffer image_format, long image_width, long image_height, long image_row_pitch, ShortBuffer host_ptr, IntBuffer errcode_ret) {
		org.lwjgl.opencl.CLMem __result = new org.lwjgl.opencl.CLMem(org.lwjgl.opencl.CL10.clCreateImage2D(context.getPointer(), flags, org.lwjgl.opencl.CLImageFormat.create(org.lwjgl.system.MemoryUtil.memAddress(image_format)), image_width, image_height, image_row_pitch, host_ptr, errcode_ret), context);
		return __result;
	}
	public static CLMem clCreateImage3D(CLContext context, long flags, ByteBuffer image_format, long image_width, long image_height, long image_depth, long image_row_pitch, long image_slice_pitch, ByteBuffer host_ptr, IntBuffer errcode_ret) {
		org.lwjgl.opencl.CLMem __result = new org.lwjgl.opencl.CLMem(org.lwjgl.opencl.CL10.clCreateImage3D(context.getPointer(), flags, org.lwjgl.opencl.CLImageFormat.create(org.lwjgl.system.MemoryUtil.memAddress(image_format)), image_width, image_height, image_depth, image_row_pitch, image_slice_pitch, host_ptr, errcode_ret), context);
		return __result;
	}
	public static CLMem clCreateImage3D(CLContext context, long flags, ByteBuffer image_format, long image_width, long image_height, long image_depth, long image_row_pitch, long image_slice_pitch, FloatBuffer host_ptr, IntBuffer errcode_ret) {
		org.lwjgl.opencl.CLMem __result = new org.lwjgl.opencl.CLMem(org.lwjgl.opencl.CL10.clCreateImage3D(context.getPointer(), flags, org.lwjgl.opencl.CLImageFormat.create(org.lwjgl.system.MemoryUtil.memAddress(image_format)), image_width, image_height, image_depth, image_row_pitch, image_slice_pitch, host_ptr, errcode_ret), context);
		return __result;
	}
	public static CLMem clCreateImage3D(CLContext context, long flags, ByteBuffer image_format, long image_width, long image_height, long image_depth, long image_row_pitch, long image_slice_pitch, IntBuffer host_ptr, IntBuffer errcode_ret) {
		org.lwjgl.opencl.CLMem __result = new org.lwjgl.opencl.CLMem(org.lwjgl.opencl.CL10.clCreateImage3D(context.getPointer(), flags, org.lwjgl.opencl.CLImageFormat.create(org.lwjgl.system.MemoryUtil.memAddress(image_format)), image_width, image_height, image_depth, image_row_pitch, image_slice_pitch, host_ptr, errcode_ret), context);
		return __result;
	}
	public static CLMem clCreateImage3D(CLContext context, long flags, ByteBuffer image_format, long image_width, long image_height, long image_depth, long image_row_pitch, long image_slice_pitch, ShortBuffer host_ptr, IntBuffer errcode_ret) {
		org.lwjgl.opencl.CLMem __result = new org.lwjgl.opencl.CLMem(org.lwjgl.opencl.CL10.clCreateImage3D(context.getPointer(), flags, org.lwjgl.opencl.CLImageFormat.create(org.lwjgl.system.MemoryUtil.memAddress(image_format)), image_width, image_height, image_depth, image_row_pitch, image_slice_pitch, host_ptr, errcode_ret), context);
		return __result;
	}
	@Todo("cl")
	public static int clGetSupportedImageFormats(CLContext context, long flags, int image_type, ByteBuffer image_formats, IntBuffer num_image_formats) {
		throw new UnsupportedOperationException();
	}
	public static int clEnqueueReadImage(CLCommandQueue command_queue, CLMem image, int blocking_read, PointerBuffer origin, PointerBuffer region, long row_pitch, long slice_pitch, ByteBuffer ptr, PointerBuffer event_wait_list, PointerBuffer event) {
		int __result = org.lwjgl.opencl.CL10.clEnqueueReadImage(command_queue.getPointer(), image.getPointer(), (blocking_read != 0), origin, region, row_pitch, slice_pitch, ptr, event_wait_list, event);
		if ( __result == CL10.CL_SUCCESS ) command_queue.registerCLEvent(event);
		return __result;
	}
	public static int clEnqueueReadImage(CLCommandQueue command_queue, CLMem image, int blocking_read, PointerBuffer origin, PointerBuffer region, long row_pitch, long slice_pitch, FloatBuffer ptr, PointerBuffer event_wait_list, PointerBuffer event) {
		int __result = org.lwjgl.opencl.CL10.clEnqueueReadImage(command_queue.getPointer(), image.getPointer(), (blocking_read != 0), origin, region, row_pitch, slice_pitch, ptr, event_wait_list, event);
		if ( __result == CL10.CL_SUCCESS ) command_queue.registerCLEvent(event);
		return __result;
	}
	public static int clEnqueueReadImage(CLCommandQueue command_queue, CLMem image, int blocking_read, PointerBuffer origin, PointerBuffer region, long row_pitch, long slice_pitch, IntBuffer ptr, PointerBuffer event_wait_list, PointerBuffer event) {
		int __result = org.lwjgl.opencl.CL10.clEnqueueReadImage(command_queue.getPointer(), image.getPointer(), (blocking_read != 0), origin, region, row_pitch, slice_pitch, ptr, event_wait_list, event);
		if ( __result == CL10.CL_SUCCESS ) command_queue.registerCLEvent(event);
		return __result;
	}
	public static int clEnqueueReadImage(CLCommandQueue command_queue, CLMem image, int blocking_read, PointerBuffer origin, PointerBuffer region, long row_pitch, long slice_pitch, ShortBuffer ptr, PointerBuffer event_wait_list, PointerBuffer event) {
		int __result = org.lwjgl.opencl.CL10.clEnqueueReadImage(command_queue.getPointer(), image.getPointer(), (blocking_read != 0), origin, region, row_pitch, slice_pitch, ptr, event_wait_list, event);
		if ( __result == CL10.CL_SUCCESS ) command_queue.registerCLEvent(event);
		return __result;
	}
	public static int clEnqueueWriteImage(CLCommandQueue command_queue, CLMem image, int blocking_write, PointerBuffer origin, PointerBuffer region, long input_row_pitch, long input_slice_pitch, ByteBuffer ptr, PointerBuffer event_wait_list, PointerBuffer event) {
		int __result = org.lwjgl.opencl.CL10.clEnqueueWriteImage(command_queue.getPointer(), image.getPointer(), (blocking_write != 0), origin, region, input_row_pitch, input_slice_pitch, ptr, event_wait_list, event);
		if ( __result == CL10.CL_SUCCESS ) command_queue.registerCLEvent(event);
		return __result;
	}
	public static int clEnqueueWriteImage(CLCommandQueue command_queue, CLMem image, int blocking_write, PointerBuffer origin, PointerBuffer region, long input_row_pitch, long input_slice_pitch, FloatBuffer ptr, PointerBuffer event_wait_list, PointerBuffer event) {
		int __result = org.lwjgl.opencl.CL10.clEnqueueWriteImage(command_queue.getPointer(), image.getPointer(), (blocking_write != 0), origin, region, input_row_pitch, input_slice_pitch, ptr, event_wait_list, event);
		if ( __result == CL10.CL_SUCCESS ) command_queue.registerCLEvent(event);
		return __result;
	}
	public static int clEnqueueWriteImage(CLCommandQueue command_queue, CLMem image, int blocking_write, PointerBuffer origin, PointerBuffer region, long input_row_pitch, long input_slice_pitch, IntBuffer ptr, PointerBuffer event_wait_list, PointerBuffer event) {
		int __result = org.lwjgl.opencl.CL10.clEnqueueWriteImage(command_queue.getPointer(), image.getPointer(), (blocking_write != 0), origin, region, input_row_pitch, input_slice_pitch, ptr, event_wait_list, event);
		if ( __result == CL10.CL_SUCCESS ) command_queue.registerCLEvent(event);
		return __result;
	}
	public static int clEnqueueWriteImage(CLCommandQueue command_queue, CLMem image, int blocking_write, PointerBuffer origin, PointerBuffer region, long input_row_pitch, long input_slice_pitch, ShortBuffer ptr, PointerBuffer event_wait_list, PointerBuffer event) {
		int __result = org.lwjgl.opencl.CL10.clEnqueueWriteImage(command_queue.getPointer(), image.getPointer(), (blocking_write != 0), origin, region, input_row_pitch, input_slice_pitch, ptr, event_wait_list, event);
		if ( __result == CL10.CL_SUCCESS ) command_queue.registerCLEvent(event);
		return __result;
	}
	public static int clEnqueueCopyImage(CLCommandQueue command_queue, CLMem src_image, CLMem dst_image, PointerBuffer src_origin, PointerBuffer dst_origin, PointerBuffer region, PointerBuffer event_wait_list, PointerBuffer event) {
		int __result = org.lwjgl.opencl.CL10.clEnqueueCopyImage(command_queue.getPointer(), src_image.getPointer(), dst_image.getPointer(), src_origin, dst_origin, region, event_wait_list, event);
		if ( __result == CL10.CL_SUCCESS ) command_queue.registerCLEvent(event);
		return __result;
	}
	public static int clEnqueueCopyImageToBuffer(CLCommandQueue command_queue, CLMem src_image, CLMem dst_buffer, PointerBuffer src_origin, PointerBuffer region, long dst_offset, PointerBuffer event_wait_list, PointerBuffer event) {
		int __result = org.lwjgl.opencl.CL10.clEnqueueCopyImageToBuffer(command_queue.getPointer(), src_image.getPointer(), dst_buffer.getPointer(), src_origin, region, dst_offset, event_wait_list, event);
		if ( __result == CL10.CL_SUCCESS ) command_queue.registerCLEvent(event);
		return __result;
	}
	public static int clEnqueueCopyBufferToImage(CLCommandQueue command_queue, CLMem src_buffer, CLMem dst_image, long src_offset, PointerBuffer dst_origin, PointerBuffer region, PointerBuffer event_wait_list, PointerBuffer event) {
		int __result = org.lwjgl.opencl.CL10.clEnqueueCopyBufferToImage(command_queue.getPointer(), src_buffer.getPointer(), dst_image.getPointer(), src_offset, dst_origin, region, event_wait_list, event);
		if ( __result == CL10.CL_SUCCESS ) command_queue.registerCLEvent(event);
		return __result;
	}
	@Todo("cl")
	public static ByteBuffer clEnqueueMapImage(CLCommandQueue command_queue, CLMem image, int blocking_map, long map_flags, PointerBuffer origin, PointerBuffer region, PointerBuffer image_row_pitch, PointerBuffer image_slice_pitch, PointerBuffer event_wait_list, PointerBuffer event, IntBuffer errcode_ret) {
		throw new UnsupportedOperationException();
	}
	public static int clGetImageInfo(CLMem image, int param_name, ByteBuffer param_value, PointerBuffer param_value_size_ret) {
		return org.lwjgl.opencl.CL10.clGetImageInfo(image.getPointer(), param_name, param_value, param_value_size_ret);
	}
	public static int clRetainMemObject(CLMem memobj) {
		int __result = org.lwjgl.opencl.CL10.clRetainMemObject(memobj.getPointer());
		if ( __result == CL10.CL_SUCCESS ) memobj.retain();
		return __result;
	}
	public static int clReleaseMemObject(CLMem memobj) {
		int __result = org.lwjgl.opencl.CL10.clReleaseMemObject(memobj.getPointer());
		if ( __result == CL10.CL_SUCCESS ) memobj.release();
		return __result;
	}
	public static int clEnqueueUnmapMemObject(CLCommandQueue command_queue, CLMem memobj, ByteBuffer mapped_ptr, PointerBuffer event_wait_list, PointerBuffer event) {
		int __result = org.lwjgl.opencl.CL10.clEnqueueUnmapMemObject(command_queue.getPointer(), memobj.getPointer(), mapped_ptr, event_wait_list, event);
		if ( __result == CL10.CL_SUCCESS ) command_queue.registerCLEvent(event);
		return __result;
	}
	public static int clGetMemObjectInfo(CLMem memobj, int param_name, ByteBuffer param_value, PointerBuffer param_value_size_ret) {
		return org.lwjgl.opencl.CL10.clGetMemObjectInfo(memobj.getPointer(), param_name, param_value, param_value_size_ret);
	}
	public static CLSampler clCreateSampler(CLContext context, int normalized_coords, int addressing_mode, int filter_mode, IntBuffer errcode_ret) {
		org.lwjgl.opencl.CLSampler __result = new org.lwjgl.opencl.CLSampler(org.lwjgl.opencl.CL10.clCreateSampler(context.getPointer(), (normalized_coords != 0), addressing_mode, filter_mode, errcode_ret), context);
		return __result;
	}
	public static int clRetainSampler(CLSampler sampler) {
		int __result = org.lwjgl.opencl.CL10.clRetainSampler(sampler.getPointer());
		if ( __result == CL10.CL_SUCCESS ) sampler.retain();
		return __result;
	}
	public static int clReleaseSampler(CLSampler sampler) {
		int __result = org.lwjgl.opencl.CL10.clReleaseSampler(sampler.getPointer());
		if ( __result == CL10.CL_SUCCESS ) sampler.release();
		return __result;
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
	public static int clRetainProgram(CLProgram program) {
		int __result = org.lwjgl.opencl.CL10.clRetainProgram(program.getPointer());
		if ( __result == CL10.CL_SUCCESS ) program.retain();
		return __result;
	}
	public static int clReleaseProgram(CLProgram program) {
		APIUtil.releaseObjects(program);
		int __result = org.lwjgl.opencl.CL10.clReleaseProgram(program.getPointer());
		if ( __result == CL10.CL_SUCCESS ) program.release();
		return __result;
	}
	public static int clBuildProgram(CLProgram program, PointerBuffer device_list, ByteBuffer options, CLBuildProgramCallback pfn_notify) {
		long user_data = CallbackUtil.createGlobalRef(pfn_notify);
		if ( pfn_notify != null ) pfn_notify.setContext(program.getParent());
		int __result = 0;
		try {
			__result = org.lwjgl.opencl.CL10.clBuildProgram(program.getPointer(), device_list, options, pfn_notify, user_data);
			return __result;
		} finally {
			CallbackUtil.checkCallback(__result, user_data);
		}
	}
	public static int clBuildProgram(CLProgram program, PointerBuffer device_list, CharSequence options, CLBuildProgramCallback pfn_notify) {
		long user_data = CallbackUtil.createGlobalRef(pfn_notify);
		if ( pfn_notify != null ) pfn_notify.setContext(program.getParent());
		int __result = 0;
		try {
			__result = org.lwjgl.opencl.CL10.clBuildProgram(program.getPointer(), device_list, options, pfn_notify, user_data);
			return __result;
		} finally {
			CallbackUtil.checkCallback(__result, user_data);
		}
	}
	public static int clBuildProgram(CLProgram program, CLDevice device, CharSequence options, CLBuildProgramCallback pfn_notify) {
		try (org.lwjgl.system.MemoryStack __stack = org.lwjgl.system.MemoryStack.stackPush()) {
			org.lwjgl.PointerBuffer __p1 = __stack.pointers(device.getPointer());
			long user_data = CallbackUtil.createGlobalRef(pfn_notify);
			if ( pfn_notify != null ) pfn_notify.setContext(program.getParent());
			int __result = 0;
			try {
				__result = org.lwjgl.opencl.CL10.clBuildProgram(program.getPointer(), __p1, options, pfn_notify, user_data);
				return __result;
			} finally {
				CallbackUtil.checkCallback(__result, user_data);
			}
		}
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
	public static CLKernel clCreateKernel(CLProgram program, ByteBuffer kernel_name, IntBuffer errcode_ret) {
		org.lwjgl.opencl.CLKernel __result = new org.lwjgl.opencl.CLKernel(org.lwjgl.opencl.CL10.clCreateKernel(program.getPointer(), kernel_name, errcode_ret), program);
		return __result;
	}
	public static CLKernel clCreateKernel(CLProgram program, CharSequence kernel_name, IntBuffer errcode_ret) {
		org.lwjgl.opencl.CLKernel __result = new org.lwjgl.opencl.CLKernel(org.lwjgl.opencl.CL10.clCreateKernel(program.getPointer(), kernel_name, errcode_ret), program);
		return __result;
	}
	public static int clCreateKernelsInProgram(CLProgram program, PointerBuffer kernels, IntBuffer num_kernels_ret) {
		int __result = org.lwjgl.opencl.CL10.clCreateKernelsInProgram(program.getPointer(), kernels, num_kernels_ret);
		if ( __result == CL10.CL_SUCCESS && kernels != null ) program.registerCLKernels(kernels);
		return __result;
	}
	public static int clRetainKernel(CLKernel kernel) {
		int __result = org.lwjgl.opencl.CL10.clRetainKernel(kernel.getPointer());
		if ( __result == CL10.CL_SUCCESS ) kernel.retain();
		return __result;
	}
	public static int clReleaseKernel(CLKernel kernel) {
		int __result = org.lwjgl.opencl.CL10.clReleaseKernel(kernel.getPointer());
		if ( __result == CL10.CL_SUCCESS ) kernel.release();
		return __result;
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
	public static int clSetKernelArg(CLKernel kernel, int arg_index, CLObject arg_value) {
		try (org.lwjgl.system.MemoryStack __stack = org.lwjgl.system.MemoryStack.stackPush()) {
			org.lwjgl.PointerBuffer __p2 = __stack.pointers((arg_value == null ? 0L : arg_value.getPointer()));
			return org.lwjgl.opencl.CL10.clSetKernelArg(kernel.getPointer(), arg_index, __p2);
		}
	}
	public static int clGetKernelInfo(CLKernel kernel, int param_name, ByteBuffer param_value, PointerBuffer param_value_size_ret) {
		return org.lwjgl.opencl.CL10.clGetKernelInfo(kernel.getPointer(), param_name, param_value, param_value_size_ret);
	}
	public static int clGetKernelWorkGroupInfo(CLKernel kernel, CLDevice device, int param_name, ByteBuffer param_value, PointerBuffer param_value_size_ret) {
		return org.lwjgl.opencl.CL10.clGetKernelWorkGroupInfo(kernel.getPointer(), (device == null ? 0L : device.getPointer()), param_name, param_value, param_value_size_ret);
	}
	public static int clEnqueueNDRangeKernel(CLCommandQueue command_queue, CLKernel kernel, int work_dim, PointerBuffer global_work_offset, PointerBuffer global_work_size, PointerBuffer local_work_size, PointerBuffer event_wait_list, PointerBuffer event) {
		int __result = org.lwjgl.opencl.CL10.clEnqueueNDRangeKernel(command_queue.getPointer(), kernel.getPointer(), work_dim, global_work_offset, global_work_size, local_work_size, event_wait_list, event);
		if ( __result == CL10.CL_SUCCESS ) command_queue.registerCLEvent(event);
		return __result;
	}
	public static int clEnqueueTask(CLCommandQueue command_queue, CLKernel kernel, PointerBuffer event_wait_list, PointerBuffer event) {
		int __result = org.lwjgl.opencl.CL10.clEnqueueTask(command_queue.getPointer(), kernel.getPointer(), event_wait_list, event);
		if ( __result == CL10.CL_SUCCESS ) command_queue.registerCLEvent(event);
		return __result;
	}
	@Todo("cl")
	public static int clEnqueueNativeKernel(CLCommandQueue command_queue, CLNativeKernel user_func, CLMem[] mem_list, long[] sizes, PointerBuffer event_wait_list, PointerBuffer event) {
		throw new UnsupportedOperationException();
	}
	public static int clWaitForEvents(CLEvent event) {
		try (org.lwjgl.system.MemoryStack __stack = org.lwjgl.system.MemoryStack.stackPush()) {
			org.lwjgl.PointerBuffer __p0 = __stack.pointers(event.getPointer());
			return org.lwjgl.opencl.CL10.clWaitForEvents(__p0);
		}
	}
	public static int clGetEventInfo(CLEvent event, int param_name, ByteBuffer param_value, PointerBuffer param_value_size_ret) {
		return org.lwjgl.opencl.CL10.clGetEventInfo(event.getPointer(), param_name, param_value, param_value_size_ret);
	}
	public static int clRetainEvent(CLEvent event) {
		int __result = org.lwjgl.opencl.CL10.clRetainEvent(event.getPointer());
		if ( __result == CL10.CL_SUCCESS ) event.retain();
		return __result;
	}
	public static int clReleaseEvent(CLEvent event) {
		int __result = org.lwjgl.opencl.CL10.clReleaseEvent(event.getPointer());
		if ( __result == CL10.CL_SUCCESS ) event.release();
		return __result;
	}
	public static int clEnqueueMarker(CLCommandQueue command_queue, PointerBuffer event) {
		int __result = org.lwjgl.opencl.CL10.clEnqueueMarker(command_queue.getPointer(), event);
		if ( __result == CL10.CL_SUCCESS ) command_queue.registerCLEvent(event);
		return __result;
	}
	public static int clEnqueueBarrier(CLCommandQueue command_queue) {
		return org.lwjgl.opencl.CL10.clEnqueueBarrier(command_queue.getPointer());
	}
	public static int clEnqueueWaitForEvents(CLCommandQueue command_queue, PointerBuffer event_list) {
		return org.lwjgl.opencl.CL10.clEnqueueWaitForEvents(command_queue.getPointer(), event_list);
	}
	public static int clEnqueueWaitForEvents(CLCommandQueue command_queue, CLEvent event) {
		try (org.lwjgl.system.MemoryStack __stack = org.lwjgl.system.MemoryStack.stackPush()) {
			org.lwjgl.PointerBuffer __p1 = __stack.pointers(event.getPointer());
			return org.lwjgl.opencl.CL10.clEnqueueWaitForEvents(command_queue.getPointer(), __p1);
		}
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
