package org.lwjgl.util.vector;

import com.koyomiji.lwjgl2w3.inject.Generated;
import com.koyomiji.lwjgl2w3.inject.Todo;
import java.io.Serializable;
import java.nio.FloatBuffer;

@Generated
public abstract class Matrix implements Serializable {
	@Todo("port")
	protected Matrix() {
		throw new UnsupportedOperationException();
	}

	public abstract Matrix setIdentity();

	public abstract Matrix invert();

	public abstract Matrix load(FloatBuffer buf);

	public abstract Matrix loadTranspose(FloatBuffer buf);

	public abstract Matrix negate();

	public abstract Matrix store(FloatBuffer buf);

	public abstract Matrix storeTranspose(FloatBuffer buf);

	public abstract Matrix transpose();

	public abstract Matrix setZero();

	public abstract float determinant();
}
