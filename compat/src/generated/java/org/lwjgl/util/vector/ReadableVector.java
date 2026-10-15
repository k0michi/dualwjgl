package org.lwjgl.util.vector;

import com.koyomiji.lwjgl2w3.inject.Generated;
import java.nio.FloatBuffer;

@Generated
public interface ReadableVector {
	float length();

	float lengthSquared();

	Vector store(FloatBuffer buf);
}
