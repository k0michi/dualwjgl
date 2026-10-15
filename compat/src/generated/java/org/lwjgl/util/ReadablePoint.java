package org.lwjgl.util;

import com.koyomiji.lwjgl2w3.inject.Generated;

@Generated
public interface ReadablePoint {
	int getX();

	int getY();

	void getLocation(WritablePoint dest);
}
