package org.lwjgl.opencl;

public final class CLDevice extends CLObjectChild<CLDevice> {
	CLDevice(long pointer, CLPlatform platform) {
		super((long) 0L, (CLDevice) null);
		// TODO(cl)
		throw new UnsupportedOperationException();
	}
	CLDevice(long pointer, CLDevice parent) {
		super((long) 0L, (CLDevice) null);
		// TODO(cl)
		throw new UnsupportedOperationException();
	}
	CLDevice(long pointer, CLDevice parent, CLPlatform platform) {
		super((long) 0L, (CLDevice) null);
		// TODO(cl)
		throw new UnsupportedOperationException();
	}

	public CLPlatform getPlatform() {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}

	public CLDevice getSubCLDevice(long id) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}

	public String getInfoString(int param_name) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}

	public int getInfoInt(int param_name) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}

	public boolean getInfoBoolean(int param_name) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}

	public long getInfoSize(int param_name) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}

	public long[] getInfoSizeArray(int param_name) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}

	public long getInfoLong(int param_name) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}
}
