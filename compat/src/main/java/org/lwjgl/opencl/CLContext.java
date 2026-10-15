package org.lwjgl.opencl;

import java.nio.IntBuffer;
import java.util.List;
import org.lwjgl.LWJGLException;
import org.lwjgl.opencl.api.CLImageFormat;
import org.lwjgl.opencl.api.Filter;
import org.lwjgl.opengl.Drawable;

public final class CLContext extends CLObjectChild<CLPlatform> {
	CLContext(long pointer, CLPlatform platform) {
		super((long) 0L, (CLPlatform) null);
		// TODO(cl)
		throw new UnsupportedOperationException();
	}

	public CLCommandQueue getCLCommandQueue(long id) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}

	public CLMem getCLMem(long id) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}

	public CLSampler getCLSampler(long id) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}

	public CLProgram getCLProgram(long id) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}

	public CLEvent getCLEvent(long id) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}

	public static CLContext create(CLPlatform platform, List<CLDevice> devices, IntBuffer errcode_ret) throws LWJGLException {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}

	public static CLContext create(CLPlatform platform, List<CLDevice> devices, CLContextCallback pfn_notify, IntBuffer errcode_ret) throws LWJGLException {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}

	public static CLContext create(CLPlatform platform, List<CLDevice> devices, CLContextCallback pfn_notify, Drawable share_drawable, IntBuffer errcode_ret) throws LWJGLException {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}

	public static CLContext createFromType(CLPlatform platform, long device_type, IntBuffer errcode_ret) throws LWJGLException {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}

	public static CLContext createFromType(CLPlatform platform, long device_type, CLContextCallback pfn_notify, IntBuffer errcode_ret) throws LWJGLException {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}

	public static CLContext createFromType(CLPlatform platform, long device_type, CLContextCallback pfn_notify, Drawable share_drawable, IntBuffer errcode_ret) throws LWJGLException {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}

	public int getInfoInt(int param_name) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}

	public List<CLDevice> getInfoDevices() {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}

	public List<CLImageFormat> getSupportedImageFormats(long flags, int image_type) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}

	public List<CLImageFormat> getSupportedImageFormats(long flags, int image_type, Filter<CLImageFormat> filter) {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}
}
