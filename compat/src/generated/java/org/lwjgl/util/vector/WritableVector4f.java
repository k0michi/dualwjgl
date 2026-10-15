package org.lwjgl.util.vector;

import com.koyomiji.lwjgl2w3.inject.Generated;

@Generated
public interface WritableVector4f extends WritableVector3f {
	void setW(float w);

	void set(float x, float y, float z, float w);
}
