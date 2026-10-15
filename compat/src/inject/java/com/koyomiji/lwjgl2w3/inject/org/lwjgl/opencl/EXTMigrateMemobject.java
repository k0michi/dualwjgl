package com.koyomiji.lwjgl2w3.inject.org.lwjgl.opencl;

import org.lwjgl.PointerBuffer;
import org.lwjgl.opencl.CLCommandQueue;
import org.lwjgl.opencl.CLMem;

public final class EXTMigrateMemobject {
	public static int clEnqueueMigrateMemObjectEXT(CLCommandQueue command_queue, PointerBuffer mem_objects, long flags, PointerBuffer event_wait_list, PointerBuffer event) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}
	public static int clEnqueueMigrateMemObjectEXT(CLCommandQueue command_queue, CLMem mem_object, long flags, PointerBuffer event_wait_list, PointerBuffer event) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}
}
