package org.lwjgl.opencl;

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

	public CLPlatformCapabilities(CLPlatform platform) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}

	public int getMajorVersion() {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}

	public int getMinorVersion() {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}

	public String toString() {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}
}
