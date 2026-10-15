package org.lwjgl.opencl;

import com.koyomiji.lwjgl2w3.inject.Generated;
import com.koyomiji.lwjgl2w3.inject.Todo;

@Generated
abstract class CLObjectChild<P extends CLObject> extends CLObjectRetainable {
	@Todo("cl")
	protected CLObjectChild(long pointer, P parent) {
		super((long) 0L);
		throw new UnsupportedOperationException();
	}

	@Todo("cl")
	public P getParent() {
		throw new UnsupportedOperationException();
	}
}
