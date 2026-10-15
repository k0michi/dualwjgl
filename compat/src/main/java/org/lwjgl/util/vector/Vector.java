package org.lwjgl.util.vector;

import java.io.Serializable;
import java.nio.FloatBuffer;

public abstract class Vector implements Serializable, ReadableVector {
	protected Vector() {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public final float length() {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public abstract float lengthSquared();

	public abstract Vector load(FloatBuffer buf);

	public abstract Vector negate();

	public final Vector normalise() {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public abstract Vector store(FloatBuffer buf);

	public abstract Vector scale(float scale);
}
