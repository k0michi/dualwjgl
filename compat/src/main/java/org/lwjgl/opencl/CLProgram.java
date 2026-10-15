package org.lwjgl.opencl;

import java.nio.ByteBuffer;

public final class CLProgram extends CLObjectChild<CLContext> {
	CLProgram(long pointer, CLContext context) {
		super((long) 0L, (CLContext) null);
		// TODO(cl)
		throw new UnsupportedOperationException();
	}

	public CLKernel getCLKernel(long id) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}

	public CLKernel[] createKernelsInProgram() {
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

	public long[] getInfoSizeArray(int param_name) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}

	public CLDevice[] getInfoDevices() {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}

	public ByteBuffer getInfoBinaries(ByteBuffer target) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}

	public ByteBuffer[] getInfoBinaries(ByteBuffer[] target) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}

	public String getBuildInfoString(CLDevice device, int param_name) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}

	public int getBuildInfoInt(CLDevice device, int param_name) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}
}
