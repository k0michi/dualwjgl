package org.lwjgl.util;

import com.koyomiji.lwjgl2w3.inject.Generated;

@Generated
public interface ReadableDimension {
	int getWidth();

	int getHeight();

	void getSize(WritableDimension dest);
}
