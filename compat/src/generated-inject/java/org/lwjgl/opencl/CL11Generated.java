package org.lwjgl.opencl;

import com.koyomiji.dualwjgl.inject.Generated;
import com.koyomiji.dualwjgl.inject.Into;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.PointerBuffer;

@Generated
@Into(CL11.class)
final class CL11Generated {
	public static CLMem clCreateSubBuffer(CLMem buffer, long flags, int buffer_create_type, ByteBuffer buffer_create_info, IntBuffer errcode_ret) {
		org.lwjgl.opencl.CLMem __result = CLMem.create(org.lwjgl.opencl.CL11.clCreateSubBuffer(buffer.getPointer(), flags, buffer_create_type, buffer_create_info, errcode_ret), buffer.getParent());
		return __result;
	}
	public static int clSetMemObjectDestructorCallback(CLMem memobj, CLMemObjectDestructorCallback pfn_notify) {
		long user_data = CallbackUtil.createGlobalRef(pfn_notify);
		int __result = 0;
		try {
			__result = org.lwjgl.opencl.CL11.clSetMemObjectDestructorCallback(memobj.getPointer(), pfn_notify, user_data);
			return __result;
		} finally {
			CallbackUtil.checkCallback(__result, user_data);
		}
	}
	public static int clEnqueueReadBufferRect(CLCommandQueue command_queue, CLMem buffer, int blocking_read, PointerBuffer buffer_offset, PointerBuffer host_offset, PointerBuffer region, long buffer_row_pitch, long buffer_slice_pitch, long host_row_pitch, long host_slice_pitch, ByteBuffer ptr, PointerBuffer event_wait_list, PointerBuffer event) {
		int __result = org.lwjgl.opencl.CL11.clEnqueueReadBufferRect(command_queue.getPointer(), buffer.getPointer(), (blocking_read != 0), buffer_offset, host_offset, region, buffer_row_pitch, buffer_slice_pitch, host_row_pitch, host_slice_pitch, ptr, event_wait_list, event);
		if ( __result == CL10.CL_SUCCESS ) command_queue.registerCLEvent(event);
		return __result;
	}
	public static int clEnqueueReadBufferRect(CLCommandQueue command_queue, CLMem buffer, int blocking_read, PointerBuffer buffer_offset, PointerBuffer host_offset, PointerBuffer region, long buffer_row_pitch, long buffer_slice_pitch, long host_row_pitch, long host_slice_pitch, DoubleBuffer ptr, PointerBuffer event_wait_list, PointerBuffer event) {
		int __result = org.lwjgl.opencl.CL11.clEnqueueReadBufferRect(command_queue.getPointer(), buffer.getPointer(), (blocking_read != 0), buffer_offset, host_offset, region, buffer_row_pitch, buffer_slice_pitch, host_row_pitch, host_slice_pitch, ptr, event_wait_list, event);
		if ( __result == CL10.CL_SUCCESS ) command_queue.registerCLEvent(event);
		return __result;
	}
	public static int clEnqueueReadBufferRect(CLCommandQueue command_queue, CLMem buffer, int blocking_read, PointerBuffer buffer_offset, PointerBuffer host_offset, PointerBuffer region, long buffer_row_pitch, long buffer_slice_pitch, long host_row_pitch, long host_slice_pitch, FloatBuffer ptr, PointerBuffer event_wait_list, PointerBuffer event) {
		int __result = org.lwjgl.opencl.CL11.clEnqueueReadBufferRect(command_queue.getPointer(), buffer.getPointer(), (blocking_read != 0), buffer_offset, host_offset, region, buffer_row_pitch, buffer_slice_pitch, host_row_pitch, host_slice_pitch, ptr, event_wait_list, event);
		if ( __result == CL10.CL_SUCCESS ) command_queue.registerCLEvent(event);
		return __result;
	}
	public static int clEnqueueReadBufferRect(CLCommandQueue command_queue, CLMem buffer, int blocking_read, PointerBuffer buffer_offset, PointerBuffer host_offset, PointerBuffer region, long buffer_row_pitch, long buffer_slice_pitch, long host_row_pitch, long host_slice_pitch, IntBuffer ptr, PointerBuffer event_wait_list, PointerBuffer event) {
		int __result = org.lwjgl.opencl.CL11.clEnqueueReadBufferRect(command_queue.getPointer(), buffer.getPointer(), (blocking_read != 0), buffer_offset, host_offset, region, buffer_row_pitch, buffer_slice_pitch, host_row_pitch, host_slice_pitch, ptr, event_wait_list, event);
		if ( __result == CL10.CL_SUCCESS ) command_queue.registerCLEvent(event);
		return __result;
	}
	public static int clEnqueueReadBufferRect(CLCommandQueue command_queue, CLMem buffer, int blocking_read, PointerBuffer buffer_offset, PointerBuffer host_offset, PointerBuffer region, long buffer_row_pitch, long buffer_slice_pitch, long host_row_pitch, long host_slice_pitch, LongBuffer ptr, PointerBuffer event_wait_list, PointerBuffer event) {
		int __result = org.lwjgl.opencl.CL11.clEnqueueReadBufferRect(command_queue.getPointer(), buffer.getPointer(), (blocking_read != 0), buffer_offset, host_offset, region, buffer_row_pitch, buffer_slice_pitch, host_row_pitch, host_slice_pitch, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(ptr), (org.lwjgl.system.Checks.remainingSafe(ptr) << 3)), event_wait_list, event);
		if ( __result == CL10.CL_SUCCESS ) command_queue.registerCLEvent(event);
		return __result;
	}
	public static int clEnqueueReadBufferRect(CLCommandQueue command_queue, CLMem buffer, int blocking_read, PointerBuffer buffer_offset, PointerBuffer host_offset, PointerBuffer region, long buffer_row_pitch, long buffer_slice_pitch, long host_row_pitch, long host_slice_pitch, ShortBuffer ptr, PointerBuffer event_wait_list, PointerBuffer event) {
		int __result = org.lwjgl.opencl.CL11.clEnqueueReadBufferRect(command_queue.getPointer(), buffer.getPointer(), (blocking_read != 0), buffer_offset, host_offset, region, buffer_row_pitch, buffer_slice_pitch, host_row_pitch, host_slice_pitch, ptr, event_wait_list, event);
		if ( __result == CL10.CL_SUCCESS ) command_queue.registerCLEvent(event);
		return __result;
	}
	public static int clEnqueueWriteBufferRect(CLCommandQueue command_queue, CLMem buffer, int blocking_write, PointerBuffer buffer_offset, PointerBuffer host_offset, PointerBuffer region, long buffer_row_pitch, long buffer_slice_pitch, long host_row_pitch, long host_slice_pitch, ByteBuffer ptr, PointerBuffer event_wait_list, PointerBuffer event) {
		int __result = org.lwjgl.opencl.CL11.clEnqueueWriteBufferRect(command_queue.getPointer(), buffer.getPointer(), (blocking_write != 0), buffer_offset, host_offset, region, buffer_row_pitch, buffer_slice_pitch, host_row_pitch, host_slice_pitch, ptr, event_wait_list, event);
		if ( __result == CL10.CL_SUCCESS ) command_queue.registerCLEvent(event);
		return __result;
	}
	public static int clEnqueueWriteBufferRect(CLCommandQueue command_queue, CLMem buffer, int blocking_write, PointerBuffer buffer_offset, PointerBuffer host_offset, PointerBuffer region, long buffer_row_pitch, long buffer_slice_pitch, long host_row_pitch, long host_slice_pitch, DoubleBuffer ptr, PointerBuffer event_wait_list, PointerBuffer event) {
		int __result = org.lwjgl.opencl.CL11.clEnqueueWriteBufferRect(command_queue.getPointer(), buffer.getPointer(), (blocking_write != 0), buffer_offset, host_offset, region, buffer_row_pitch, buffer_slice_pitch, host_row_pitch, host_slice_pitch, ptr, event_wait_list, event);
		if ( __result == CL10.CL_SUCCESS ) command_queue.registerCLEvent(event);
		return __result;
	}
	public static int clEnqueueWriteBufferRect(CLCommandQueue command_queue, CLMem buffer, int blocking_write, PointerBuffer buffer_offset, PointerBuffer host_offset, PointerBuffer region, long buffer_row_pitch, long buffer_slice_pitch, long host_row_pitch, long host_slice_pitch, FloatBuffer ptr, PointerBuffer event_wait_list, PointerBuffer event) {
		int __result = org.lwjgl.opencl.CL11.clEnqueueWriteBufferRect(command_queue.getPointer(), buffer.getPointer(), (blocking_write != 0), buffer_offset, host_offset, region, buffer_row_pitch, buffer_slice_pitch, host_row_pitch, host_slice_pitch, ptr, event_wait_list, event);
		if ( __result == CL10.CL_SUCCESS ) command_queue.registerCLEvent(event);
		return __result;
	}
	public static int clEnqueueWriteBufferRect(CLCommandQueue command_queue, CLMem buffer, int blocking_write, PointerBuffer buffer_offset, PointerBuffer host_offset, PointerBuffer region, long buffer_row_pitch, long buffer_slice_pitch, long host_row_pitch, long host_slice_pitch, IntBuffer ptr, PointerBuffer event_wait_list, PointerBuffer event) {
		int __result = org.lwjgl.opencl.CL11.clEnqueueWriteBufferRect(command_queue.getPointer(), buffer.getPointer(), (blocking_write != 0), buffer_offset, host_offset, region, buffer_row_pitch, buffer_slice_pitch, host_row_pitch, host_slice_pitch, ptr, event_wait_list, event);
		if ( __result == CL10.CL_SUCCESS ) command_queue.registerCLEvent(event);
		return __result;
	}
	public static int clEnqueueWriteBufferRect(CLCommandQueue command_queue, CLMem buffer, int blocking_write, PointerBuffer buffer_offset, PointerBuffer host_offset, PointerBuffer region, long buffer_row_pitch, long buffer_slice_pitch, long host_row_pitch, long host_slice_pitch, LongBuffer ptr, PointerBuffer event_wait_list, PointerBuffer event) {
		int __result = org.lwjgl.opencl.CL11.clEnqueueWriteBufferRect(command_queue.getPointer(), buffer.getPointer(), (blocking_write != 0), buffer_offset, host_offset, region, buffer_row_pitch, buffer_slice_pitch, host_row_pitch, host_slice_pitch, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(ptr), (org.lwjgl.system.Checks.remainingSafe(ptr) << 3)), event_wait_list, event);
		if ( __result == CL10.CL_SUCCESS ) command_queue.registerCLEvent(event);
		return __result;
	}
	public static int clEnqueueWriteBufferRect(CLCommandQueue command_queue, CLMem buffer, int blocking_write, PointerBuffer buffer_offset, PointerBuffer host_offset, PointerBuffer region, long buffer_row_pitch, long buffer_slice_pitch, long host_row_pitch, long host_slice_pitch, ShortBuffer ptr, PointerBuffer event_wait_list, PointerBuffer event) {
		int __result = org.lwjgl.opencl.CL11.clEnqueueWriteBufferRect(command_queue.getPointer(), buffer.getPointer(), (blocking_write != 0), buffer_offset, host_offset, region, buffer_row_pitch, buffer_slice_pitch, host_row_pitch, host_slice_pitch, ptr, event_wait_list, event);
		if ( __result == CL10.CL_SUCCESS ) command_queue.registerCLEvent(event);
		return __result;
	}
	public static int clEnqueueCopyBufferRect(CLCommandQueue command_queue, CLMem src_buffer, CLMem dst_buffer, PointerBuffer src_origin, PointerBuffer dst_origin, PointerBuffer region, long src_row_pitch, long src_slice_pitch, long dst_row_pitch, long dst_slice_pitch, PointerBuffer event_wait_list, PointerBuffer event) {
		int __result = org.lwjgl.opencl.CL11.clEnqueueCopyBufferRect(command_queue.getPointer(), src_buffer.getPointer(), dst_buffer.getPointer(), src_origin, dst_origin, region, src_row_pitch, src_slice_pitch, dst_row_pitch, dst_slice_pitch, event_wait_list, event);
		if ( __result == CL10.CL_SUCCESS ) command_queue.registerCLEvent(event);
		return __result;
	}
	public static CLEvent clCreateUserEvent(CLContext context, IntBuffer errcode_ret) {
		org.lwjgl.opencl.CLEvent __result = new org.lwjgl.opencl.CLEvent(org.lwjgl.opencl.CL11.clCreateUserEvent(context.getPointer(), errcode_ret), context);
		return __result;
	}
	public static int clSetUserEventStatus(CLEvent event, int execution_status) {
		return org.lwjgl.opencl.CL11.clSetUserEventStatus(event.getPointer(), execution_status);
	}
	public static int clSetEventCallback(CLEvent event, int command_exec_callback_type, CLEventCallback pfn_notify) {
		long user_data = CallbackUtil.createGlobalRef(pfn_notify);
		pfn_notify.setRegistry(event.getParentRegistry());
		int __result = 0;
		try {
			__result = org.lwjgl.opencl.CL11.clSetEventCallback(event.getPointer(), command_exec_callback_type, pfn_notify, user_data);
			return __result;
		} finally {
			CallbackUtil.checkCallback(__result, user_data);
		}
	}
}
