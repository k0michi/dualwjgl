package org.lwjgl.opencl;

public final class CLEvent extends CLObjectChild<CLContext> {
	CLEvent(long pointer, CLContext context) {
		super((long) 0L, (CLContext) null);
		// TODO(cl)
		throw new UnsupportedOperationException();
	}
	CLEvent(long pointer, CLCommandQueue queue) {
		super((long) 0L, (CLContext) null);
		// TODO(cl)
		throw new UnsupportedOperationException();
	}
	CLEvent(long pointer, CLContext context, CLCommandQueue queue) {
		super((long) 0L, (CLContext) null);
		// TODO(cl)
		throw new UnsupportedOperationException();
	}

	public CLCommandQueue getCLCommandQueue() {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}

	public int getInfoInt(int param_name) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}

	public long getProfilingInfoLong(int param_name) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}
}
