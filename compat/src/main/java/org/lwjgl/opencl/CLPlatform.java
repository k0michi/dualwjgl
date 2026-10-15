package org.lwjgl.opencl;

import java.util.List;
import org.lwjgl.opencl.api.Filter;

public final class CLPlatform extends CLObject {
	CLPlatform(long pointer) {
		super((long) 0L);
		// TODO(cl)
		throw new UnsupportedOperationException();
	}

	public static CLPlatform getCLPlatform(long id) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}

	public CLDevice getCLDevice(long id) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}

	public static List<CLPlatform> getPlatforms() {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}

	public static List<CLPlatform> getPlatforms(Filter<CLPlatform> filter) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}

	public String getInfoString(int param_name) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}

	public List<CLDevice> getDevices(int device_type) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}

	public List<CLDevice> getDevices(int device_type, Filter<CLDevice> filter) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}
}
