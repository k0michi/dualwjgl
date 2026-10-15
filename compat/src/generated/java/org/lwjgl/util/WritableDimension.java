package org.lwjgl.util;

import com.koyomiji.lwjgl2w3.inject.Generated;

@Generated
public interface WritableDimension {
	void setSize(int w, int h);

	void setSize(ReadableDimension d);

	void setHeight(int height);

	void setWidth(int width);
}
