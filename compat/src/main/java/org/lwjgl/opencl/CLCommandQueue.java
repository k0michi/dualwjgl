package org.lwjgl.opencl;

public final class CLCommandQueue extends CLObjectChild<CLContext> {
	CLCommandQueue(long pointer, CLContext context, CLDevice device) {
		super((long) 0L, (CLContext) null);
		// TODO(cl)
		throw new UnsupportedOperationException();
	}

	public CLDevice getCLDevice() {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}

	public CLEvent getCLEvent(long id) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}

	public int getInfoInt(int param_name) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}
}
