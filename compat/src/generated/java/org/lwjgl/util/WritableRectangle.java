package org.lwjgl.util;

import com.koyomiji.lwjgl2w3.inject.Generated;

@Generated
public interface WritableRectangle extends WritablePoint, WritableDimension {
	void setBounds(int x, int y, int width, int height);

	void setBounds(ReadablePoint location, ReadableDimension size);

	void setBounds(ReadableRectangle src);
}
