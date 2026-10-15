package org.lwjgl.util;

import com.koyomiji.lwjgl2w3.inject.Generated;
import com.koyomiji.lwjgl2w3.inject.Todo;
import java.nio.ByteBuffer;

@Generated
public interface ReadableColor {
	@Todo("port")
	ReadableColor RED = null;
	@Todo("port")
	ReadableColor ORANGE = null;
	@Todo("port")
	ReadableColor YELLOW = null;
	@Todo("port")
	ReadableColor GREEN = null;
	@Todo("port")
	ReadableColor CYAN = null;
	@Todo("port")
	ReadableColor BLUE = null;
	@Todo("port")
	ReadableColor PURPLE = null;
	@Todo("port")
	ReadableColor WHITE = null;
	@Todo("port")
	ReadableColor BLACK = null;
	@Todo("port")
	ReadableColor LTGREY = null;
	@Todo("port")
	ReadableColor DKGREY = null;
	@Todo("port")
	ReadableColor GREY = null;

	int getRed();

	int getGreen();

	int getBlue();

	int getAlpha();

	byte getRedByte();

	byte getGreenByte();

	byte getBlueByte();

	byte getAlphaByte();

	void writeRGBA(ByteBuffer dest);

	void writeRGB(ByteBuffer dest);

	void writeABGR(ByteBuffer dest);

	void writeBGR(ByteBuffer dest);

	void writeBGRA(ByteBuffer dest);

	void writeARGB(ByteBuffer dest);
}
