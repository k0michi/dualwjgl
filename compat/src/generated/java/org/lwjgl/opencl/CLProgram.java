package org.lwjgl.opencl;

import com.koyomiji.lwjgl2w3.inject.Generated;
import com.koyomiji.lwjgl2w3.inject.Todo;
import java.nio.ByteBuffer;

@Generated
public final class CLProgram extends CLObjectChild<CLContext> {
	@Todo("cl")
	CLProgram(long pointer, CLContext context) {
		super((long) 0L, (CLContext) null);
		throw new UnsupportedOperationException();
	}

	@Todo("cl")
	public CLKernel getCLKernel(long id) {
		throw new UnsupportedOperationException();
	}

	@Todo("cl")
	public CLKernel[] createKernelsInProgram() {
		throw new UnsupportedOperationException();
	}

	@Todo("cl")
	public String getInfoString(int param_name) {
		throw new UnsupportedOperationException();
	}

	@Todo("cl")
	public int getInfoInt(int param_name) {
		throw new UnsupportedOperationException();
	}

	@Todo("cl")
	public long[] getInfoSizeArray(int param_name) {
		throw new UnsupportedOperationException();
	}

	@Todo("cl")
	public CLDevice[] getInfoDevices() {
		throw new UnsupportedOperationException();
	}

	@Todo("cl")
	public ByteBuffer getInfoBinaries(ByteBuffer target) {
		throw new UnsupportedOperationException();
	}

	@Todo("cl")
	public ByteBuffer[] getInfoBinaries(ByteBuffer[] target) {
		throw new UnsupportedOperationException();
	}

	@Todo("cl")
	public String getBuildInfoString(CLDevice device, int param_name) {
		throw new UnsupportedOperationException();
	}

	@Todo("cl")
	public int getBuildInfoInt(CLDevice device, int param_name) {
		throw new UnsupportedOperationException();
	}
}
