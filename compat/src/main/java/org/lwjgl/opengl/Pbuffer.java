package org.lwjgl.opengl;

import org.lwjgl.LWJGLException;

/**
 * DEVIATION(pbuffer): Pbuffers are not supported. SDL has no off-screen drawable, so getCapabilities reports none and
 * every constructor throws, as LWJGL 2 did where the platform had no pbuffers; the other members are unreachable
 * without an instance.
 */
public final class Pbuffer extends DrawableGL {

	public static final int PBUFFER_SUPPORTED = 1 << 0;

	public static final int RENDER_TEXTURE_SUPPORTED = 1 << 1;

	public static final int RENDER_TEXTURE_RECTANGLE_SUPPORTED = 1 << 2;

	public static final int RENDER_DEPTH_TEXTURE_SUPPORTED = 1 << 3;

	public static final int MIPMAP_LEVEL = RenderTexture.WGL_MIPMAP_LEVEL_ARB;

	public static final int CUBE_MAP_FACE = RenderTexture.WGL_CUBE_MAP_FACE_ARB;

	public static final int TEXTURE_CUBE_MAP_POSITIVE_X = RenderTexture.WGL_TEXTURE_CUBE_MAP_POSITIVE_X_ARB;

	public static final int TEXTURE_CUBE_MAP_NEGATIVE_X = RenderTexture.WGL_TEXTURE_CUBE_MAP_NEGATIVE_X_ARB;

	public static final int TEXTURE_CUBE_MAP_POSITIVE_Y = RenderTexture.WGL_TEXTURE_CUBE_MAP_POSITIVE_Y_ARB;

	public static final int TEXTURE_CUBE_MAP_NEGATIVE_Y = RenderTexture.WGL_TEXTURE_CUBE_MAP_NEGATIVE_Y_ARB;

	public static final int TEXTURE_CUBE_MAP_POSITIVE_Z = RenderTexture.WGL_TEXTURE_CUBE_MAP_POSITIVE_Z_ARB;

	public static final int TEXTURE_CUBE_MAP_NEGATIVE_Z = RenderTexture.WGL_TEXTURE_CUBE_MAP_NEGATIVE_Z_ARB;

	public static final int FRONT_LEFT_BUFFER = RenderTexture.WGL_FRONT_LEFT_ARB;

	public static final int FRONT_RIGHT_BUFFER = RenderTexture.WGL_FRONT_RIGHT_ARB;

	public static final int BACK_LEFT_BUFFER = RenderTexture.WGL_BACK_LEFT_ARB;

	public static final int BACK_RIGHT_BUFFER = RenderTexture.WGL_BACK_RIGHT_ARB;

	public static final int DEPTH_BUFFER = RenderTexture.WGL_DEPTH_COMPONENT_NV;

	private static final String UNSUPPORTED = "Pbuffers are not supported";

	public Pbuffer(int width, int height, PixelFormat pixel_format, Drawable shared_drawable) throws LWJGLException {
		this(width, height, pixel_format, null, shared_drawable);
	}

	public Pbuffer(int width, int height, PixelFormat pixel_format, RenderTexture renderTexture, Drawable shared_drawable) throws LWJGLException {
		this(width, height, pixel_format, renderTexture, shared_drawable, null);
	}

	public Pbuffer(int width, int height, PixelFormat pixel_format, RenderTexture renderTexture, Drawable shared_drawable, ContextAttribs attribs) throws LWJGLException {
		if (pixel_format == null) {
			throw new NullPointerException("Pixel format must be non-null");
		}
		throw new LWJGLException(UNSUPPORTED);
	}

	public synchronized boolean isBufferLost() {
		checkDestroyed();
		return false;
	}

	/** None: no Pbuffer can be created. */
	public static int getCapabilities() {
		return 0;
	}

	public synchronized void setAttrib(int attrib, int value) {
		checkDestroyed();
	}

	public synchronized void bindTexImage(int buffer) {
		checkDestroyed();
	}

	public synchronized void releaseTexImage(int buffer) {
		checkDestroyed();
	}

	public synchronized int getHeight() {
		checkDestroyed();
		return 0;
	}

	public synchronized int getWidth() {
		checkDestroyed();
		return 0;
	}

}
