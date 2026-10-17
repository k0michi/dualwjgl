package com.koyomiji.lwjgl2w3.generated.org.lwjgl.opengl;

import org.lwjgl.opencl.CLContext;
import org.lwjgl.opencl.CLEvent;
import org.lwjgl.opengl.GLSync;

public final class ARBCLEvent {
	public static GLSync glCreateSyncFromCLeventARB(CLContext context, CLEvent event, int flags) {
		return new org.lwjgl.opengl.GLSync(org.lwjgl.opengl.ARBCLEvent.glCreateSyncFromCLeventARB(context.getPointer(), event.getPointer(), flags));
	}
}
