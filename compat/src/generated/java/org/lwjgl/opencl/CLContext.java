package org.lwjgl.opencl;

import com.koyomiji.lwjgl2w3.inject.Generated;
import com.koyomiji.lwjgl2w3.inject.Todo;
import java.nio.IntBuffer;
import java.util.List;
import org.lwjgl.LWJGLException;
import org.lwjgl.opencl.api.CLImageFormat;
import org.lwjgl.opencl.api.Filter;
import org.lwjgl.opengl.Drawable;

@Generated
public final class CLContext extends CLObjectChild<CLPlatform> {
	@Todo("cl")
	CLContext(long pointer, CLPlatform platform) {
		super((long) 0L, (CLPlatform) null);
		throw new UnsupportedOperationException();
	}

	@Todo("cl")
	public CLCommandQueue getCLCommandQueue(long id) {
		throw new UnsupportedOperationException();
	}

	@Todo("cl")
	public CLMem getCLMem(long id) {
		throw new UnsupportedOperationException();
	}

	@Todo("cl")
	public CLSampler getCLSampler(long id) {
		throw new UnsupportedOperationException();
	}

	@Todo("cl")
	public CLProgram getCLProgram(long id) {
		throw new UnsupportedOperationException();
	}

	@Todo("cl")
	public CLEvent getCLEvent(long id) {
		throw new UnsupportedOperationException();
	}

	@Todo("cl")
	public static CLContext create(CLPlatform platform, List<CLDevice> devices, IntBuffer errcode_ret) throws LWJGLException {
		throw new UnsupportedOperationException();
	}

	@Todo("cl")
	public static CLContext create(CLPlatform platform, List<CLDevice> devices, CLContextCallback pfn_notify, IntBuffer errcode_ret) throws LWJGLException {
		throw new UnsupportedOperationException();
	}

	@Todo("cl")
	public static CLContext create(CLPlatform platform, List<CLDevice> devices, CLContextCallback pfn_notify, Drawable share_drawable, IntBuffer errcode_ret) throws LWJGLException {
		throw new UnsupportedOperationException();
	}

	@Todo("cl")
	public static CLContext createFromType(CLPlatform platform, long device_type, IntBuffer errcode_ret) throws LWJGLException {
		throw new UnsupportedOperationException();
	}

	@Todo("cl")
	public static CLContext createFromType(CLPlatform platform, long device_type, CLContextCallback pfn_notify, IntBuffer errcode_ret) throws LWJGLException {
		throw new UnsupportedOperationException();
	}

	@Todo("cl")
	public static CLContext createFromType(CLPlatform platform, long device_type, CLContextCallback pfn_notify, Drawable share_drawable, IntBuffer errcode_ret) throws LWJGLException {
		throw new UnsupportedOperationException();
	}

	@Todo("cl")
	public int getInfoInt(int param_name) {
		throw new UnsupportedOperationException();
	}

	@Todo("cl")
	public List<CLDevice> getInfoDevices() {
		throw new UnsupportedOperationException();
	}

	@Todo("cl")
	public List<CLImageFormat> getSupportedImageFormats(long flags, int image_type) {
		throw new UnsupportedOperationException();
	}

	@Todo("cl")
	public List<CLImageFormat> getSupportedImageFormats(long flags, int image_type, Filter<CLImageFormat> filter) {
		throw new UnsupportedOperationException();
	}
}
