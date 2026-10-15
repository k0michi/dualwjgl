package org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Generated;
import com.koyomiji.lwjgl2w3.inject.Todo;
import org.lwjgl.LWJGLException;

@Generated
public final class Pbuffer extends DrawableGL {
	public static final int PBUFFER_SUPPORTED = 1;
	public static final int RENDER_TEXTURE_SUPPORTED = 2;
	public static final int RENDER_TEXTURE_RECTANGLE_SUPPORTED = 4;
	public static final int RENDER_DEPTH_TEXTURE_SUPPORTED = 8;
	public static final int MIPMAP_LEVEL = 0x207B;
	public static final int CUBE_MAP_FACE = 0x207C;
	public static final int TEXTURE_CUBE_MAP_POSITIVE_X = 0x207D;
	public static final int TEXTURE_CUBE_MAP_NEGATIVE_X = 0x207E;
	public static final int TEXTURE_CUBE_MAP_POSITIVE_Y = 0x207F;
	public static final int TEXTURE_CUBE_MAP_NEGATIVE_Y = 0x2080;
	public static final int TEXTURE_CUBE_MAP_POSITIVE_Z = 0x2081;
	public static final int TEXTURE_CUBE_MAP_NEGATIVE_Z = 0x2082;
	public static final int FRONT_LEFT_BUFFER = 0x2083;
	public static final int FRONT_RIGHT_BUFFER = 0x2084;
	public static final int BACK_LEFT_BUFFER = 0x2085;
	public static final int BACK_RIGHT_BUFFER = 0x2086;
	public static final int DEPTH_BUFFER = 0x20A7;

	@Todo("sdl")
	public Pbuffer(int width, int height, PixelFormat pixel_format, Drawable shared_drawable) throws LWJGLException {
		throw new UnsupportedOperationException();
	}
	@Todo("sdl")
	public Pbuffer(int width, int height, PixelFormat pixel_format, RenderTexture renderTexture, Drawable shared_drawable) throws LWJGLException {
		throw new UnsupportedOperationException();
	}
	@Todo("sdl")
	public Pbuffer(int width, int height, PixelFormat pixel_format, RenderTexture renderTexture, Drawable shared_drawable, ContextAttribs attribs) throws LWJGLException {
		throw new UnsupportedOperationException();
	}

	@Todo("sdl")
	public boolean isBufferLost() {
		throw new UnsupportedOperationException();
	}

	@Todo("sdl")
	public static int getCapabilities() {
		throw new UnsupportedOperationException();
	}

	@Todo("sdl")
	public void setAttrib(int attrib, int value) {
		throw new UnsupportedOperationException();
	}

	@Todo("sdl")
	public void bindTexImage(int buffer) {
		throw new UnsupportedOperationException();
	}

	@Todo("sdl")
	public void releaseTexImage(int buffer) {
		throw new UnsupportedOperationException();
	}

	@Todo("sdl")
	public int getHeight() {
		throw new UnsupportedOperationException();
	}

	@Todo("sdl")
	public int getWidth() {
		throw new UnsupportedOperationException();
	}
}
