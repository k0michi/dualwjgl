package org.lwjgl.util.vector;

import com.koyomiji.lwjgl2w3.inject.Generated;
import com.koyomiji.lwjgl2w3.inject.Todo;
import java.io.Serializable;
import java.nio.FloatBuffer;

@Generated
public abstract class Vector implements Serializable, ReadableVector {
	@Todo("port")
	protected Vector() {
		throw new UnsupportedOperationException();
	}

	@Todo("port")
	public final float length() {
		throw new UnsupportedOperationException();
	}

	public abstract float lengthSquared();

	public abstract Vector load(FloatBuffer buf);

	public abstract Vector negate();

	@Todo("port")
	public final Vector normalise() {
		throw new UnsupportedOperationException();
	}

	public abstract Vector store(FloatBuffer buf);

	public abstract Vector scale(float scale);
}
