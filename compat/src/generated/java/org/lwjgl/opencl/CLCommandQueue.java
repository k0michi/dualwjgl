package org.lwjgl.opencl;

import com.koyomiji.lwjgl2w3.inject.Generated;
import com.koyomiji.lwjgl2w3.inject.Todo;

@Generated
public final class CLCommandQueue extends CLObjectChild<CLContext> {
	@Todo("cl")
	CLCommandQueue(long pointer, CLContext context, CLDevice device) {
		super((long) 0L, (CLContext) null);
		throw new UnsupportedOperationException();
	}

	@Todo("cl")
	public CLDevice getCLDevice() {
		throw new UnsupportedOperationException();
	}

	@Todo("cl")
	public CLEvent getCLEvent(long id) {
		throw new UnsupportedOperationException();
	}

	@Todo("cl")
	public int getInfoInt(int param_name) {
		throw new UnsupportedOperationException();
	}
}
