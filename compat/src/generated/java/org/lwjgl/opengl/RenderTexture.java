package org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Generated;
import com.koyomiji.lwjgl2w3.inject.Todo;

@Generated
public final class RenderTexture {
	public static final int RENDER_TEXTURE_1D = 0x2079;
	public static final int RENDER_TEXTURE_2D = 0x207A;
	public static final int RENDER_TEXTURE_RECTANGLE = 0x20A2;
	public static final int RENDER_TEXTURE_CUBE_MAP = 0x2078;

	@Todo("sdl")
	public RenderTexture(boolean useRGB, boolean useRGBA, boolean useDepth, boolean isRectangle, int target, int mipmaps) {
		throw new UnsupportedOperationException();
	}
}
