package org.lwjgl.util;

import com.koyomiji.lwjgl2w3.inject.Generated;

@Generated
public interface WritablePoint {
	void setLocation(int x, int y);

	void setLocation(ReadablePoint p);

	void setX(int x);

	void setY(int y);
}
