package org.lwjgl.opencl;

import com.koyomiji.lwjgl2w3.inject.Generated;
import com.koyomiji.lwjgl2w3.inject.Todo;

@Generated
public class CLPlatformCapabilities {
	public int majorVersion;
	public int minorVersion;
	public boolean OpenCL11;
	public boolean OpenCL12;
	public boolean CL_APPLE_SetMemObjectDestructor;
	public boolean CL_APPLE_gl_sharing;
	public boolean CL_KHR_d3d10_sharing;
	public boolean CL_KHR_gl_event;
	public boolean CL_KHR_gl_sharing;
	public boolean CL_KHR_icd;

	@Todo("cl")
	public CLPlatformCapabilities(CLPlatform platform) {
		throw new UnsupportedOperationException();
	}

	@Todo("cl")
	public int getMajorVersion() {
		throw new UnsupportedOperationException();
	}

	@Todo("cl")
	public int getMinorVersion() {
		throw new UnsupportedOperationException();
	}

	@Todo("cl")
	public String toString() {
		throw new UnsupportedOperationException();
	}
}
