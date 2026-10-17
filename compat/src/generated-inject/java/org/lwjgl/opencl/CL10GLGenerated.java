package org.lwjgl.opencl;

import com.koyomiji.dualwjgl.inject.Generated;
import com.koyomiji.dualwjgl.inject.Into;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.PointerBuffer;

@Generated
@Into(CL10GL.class)
final class CL10GLGenerated {
	public static CLMem clCreateFromGLBuffer(CLContext context, long flags, int bufobj, IntBuffer errcode_ret) {
		org.lwjgl.opencl.CLMem __result = new org.lwjgl.opencl.CLMem(org.lwjgl.opencl.CL10GL.clCreateFromGLBuffer(context.getPointer(), flags, bufobj, errcode_ret), context);
		return __result;
	}
	public static CLMem clCreateFromGLTexture2D(CLContext context, long flags, int target, int miplevel, int texture, IntBuffer errcode_ret) {
		org.lwjgl.opencl.CLMem __result = new org.lwjgl.opencl.CLMem(org.lwjgl.opencl.CL10GL.clCreateFromGLTexture2D(context.getPointer(), flags, target, miplevel, texture, errcode_ret), context);
		return __result;
	}
	public static CLMem clCreateFromGLTexture3D(CLContext context, long flags, int target, int miplevel, int texture, IntBuffer errcode_ret) {
		org.lwjgl.opencl.CLMem __result = new org.lwjgl.opencl.CLMem(org.lwjgl.opencl.CL10GL.clCreateFromGLTexture3D(context.getPointer(), flags, target, miplevel, texture, errcode_ret), context);
		return __result;
	}
	public static CLMem clCreateFromGLRenderbuffer(CLContext context, long flags, int renderbuffer, IntBuffer errcode_ret) {
		org.lwjgl.opencl.CLMem __result = new org.lwjgl.opencl.CLMem(org.lwjgl.opencl.CL10GL.clCreateFromGLRenderbuffer(context.getPointer(), flags, renderbuffer, errcode_ret), context);
		return __result;
	}
	public static int clGetGLObjectInfo(CLMem memobj, IntBuffer gl_object_type, IntBuffer gl_object_name) {
		return org.lwjgl.opencl.CL10GL.clGetGLObjectInfo(memobj.getPointer(), gl_object_type, gl_object_name);
	}
	public static int clGetGLTextureInfo(CLMem memobj, int param_name, ByteBuffer param_value, PointerBuffer param_value_size_ret) {
		return org.lwjgl.opencl.CL10GL.clGetGLTextureInfo(memobj.getPointer(), param_name, param_value, param_value_size_ret);
	}
	public static int clEnqueueAcquireGLObjects(CLCommandQueue command_queue, PointerBuffer mem_objects, PointerBuffer event_wait_list, PointerBuffer event) {
		int __result = org.lwjgl.opencl.CL10GL.clEnqueueAcquireGLObjects(command_queue.getPointer(), mem_objects, event_wait_list, event);
		if ( __result == CL10.CL_SUCCESS ) command_queue.registerCLEvent(event);
		return __result;
	}
	public static int clEnqueueAcquireGLObjects(CLCommandQueue command_queue, CLMem mem_object, PointerBuffer event_wait_list, PointerBuffer event) {
		try (org.lwjgl.system.MemoryStack __stack = org.lwjgl.system.MemoryStack.stackPush()) {
			org.lwjgl.PointerBuffer __p1 = __stack.pointers(mem_object.getPointer());
			int __result = org.lwjgl.opencl.CL10GL.clEnqueueAcquireGLObjects(command_queue.getPointer(), __p1, event_wait_list, event);
			if ( __result == CL10.CL_SUCCESS ) command_queue.registerCLEvent(event);
			return __result;
		}
	}
	public static int clEnqueueReleaseGLObjects(CLCommandQueue command_queue, PointerBuffer mem_objects, PointerBuffer event_wait_list, PointerBuffer event) {
		int __result = org.lwjgl.opencl.CL10GL.clEnqueueReleaseGLObjects(command_queue.getPointer(), mem_objects, event_wait_list, event);
		if ( __result == CL10.CL_SUCCESS ) command_queue.registerCLEvent(event);
		return __result;
	}
	public static int clEnqueueReleaseGLObjects(CLCommandQueue command_queue, CLMem mem_object, PointerBuffer event_wait_list, PointerBuffer event) {
		try (org.lwjgl.system.MemoryStack __stack = org.lwjgl.system.MemoryStack.stackPush()) {
			org.lwjgl.PointerBuffer __p1 = __stack.pointers(mem_object.getPointer());
			int __result = org.lwjgl.opencl.CL10GL.clEnqueueReleaseGLObjects(command_queue.getPointer(), __p1, event_wait_list, event);
			if ( __result == CL10.CL_SUCCESS ) command_queue.registerCLEvent(event);
			return __result;
		}
	}
}
