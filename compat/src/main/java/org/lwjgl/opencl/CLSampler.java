package org.lwjgl.opencl;

public final class CLSampler extends CLObjectChild<CLContext> {
	CLSampler(long pointer, CLContext context) {
		super((long) 0L, (CLContext) null);
		// TODO(cl)
		throw new UnsupportedOperationException();
	}

	public int getInfoInt(int param_name) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}

	public long getInfoLong(int param_name) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}
}
