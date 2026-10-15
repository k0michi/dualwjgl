package org.lwjgl.opencl;

abstract class CLObjectChild<P extends CLObject> extends CLObjectRetainable {
	protected CLObjectChild(long pointer, P parent) {
		super((long) 0L);
		// TODO(cl)
		throw new UnsupportedOperationException();
	}

	public P getParent() {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}
}
