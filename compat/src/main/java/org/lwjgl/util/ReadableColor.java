package org.lwjgl.util;

import java.nio.ByteBuffer;

public interface ReadableColor {
	ReadableColor RED = null; // TODO(port)
	ReadableColor ORANGE = null; // TODO(port)
	ReadableColor YELLOW = null; // TODO(port)
	ReadableColor GREEN = null; // TODO(port)
	ReadableColor CYAN = null; // TODO(port)
	ReadableColor BLUE = null; // TODO(port)
	ReadableColor PURPLE = null; // TODO(port)
	ReadableColor WHITE = null; // TODO(port)
	ReadableColor BLACK = null; // TODO(port)
	ReadableColor LTGREY = null; // TODO(port)
	ReadableColor DKGREY = null; // TODO(port)
	ReadableColor GREY = null; // TODO(port)

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
