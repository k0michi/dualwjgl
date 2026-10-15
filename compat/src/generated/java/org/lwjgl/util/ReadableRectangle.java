package org.lwjgl.util;

import com.koyomiji.lwjgl2w3.inject.Generated;

@Generated
public interface ReadableRectangle extends ReadableDimension, ReadablePoint {
	void getBounds(WritableRectangle dest);
}
