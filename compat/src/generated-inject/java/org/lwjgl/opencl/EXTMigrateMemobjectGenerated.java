package org.lwjgl.opencl;

import com.koyomiji.dualwjgl.inject.Generated;
import com.koyomiji.dualwjgl.inject.Into;
import org.lwjgl.PointerBuffer;

@Generated
@Into(EXTMigrateMemobject.class)
final class EXTMigrateMemobjectGenerated {
	public static int clEnqueueMigrateMemObjectEXT(CLCommandQueue command_queue, PointerBuffer mem_objects, long flags, PointerBuffer event_wait_list, PointerBuffer event) {
		int __result = org.lwjgl.opencl.EXTMigrateMemobject.clEnqueueMigrateMemObjectEXT(command_queue.getPointer(), mem_objects, flags, event_wait_list, event);
		if ( __result == CL10.CL_SUCCESS ) command_queue.registerCLEvent(event);
		return __result;
	}
	public static int clEnqueueMigrateMemObjectEXT(CLCommandQueue command_queue, CLMem mem_object, long flags, PointerBuffer event_wait_list, PointerBuffer event) {
		try (org.lwjgl.system.MemoryStack __stack = org.lwjgl.system.MemoryStack.stackPush()) {
			org.lwjgl.PointerBuffer __p1 = __stack.pointers(mem_object.getPointer());
			int __result = org.lwjgl.opencl.EXTMigrateMemobject.clEnqueueMigrateMemObjectEXT(command_queue.getPointer(), __p1, flags, event_wait_list, event);
			if ( __result == CL10.CL_SUCCESS ) command_queue.registerCLEvent(event);
			return __result;
		}
	}
}
