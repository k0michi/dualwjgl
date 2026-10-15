package org.lwjgl.opencl;

abstract class CLObjectRetainable extends CLObject {
	protected CLObjectRetainable(long pointer) {
		super((long) 0L);
		// TODO(cl)
		throw new UnsupportedOperationException();
	}

	public final int getReferenceCount() {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}

	public final boolean isValid() {
		// TODO(cl)
		throw new UnsupportedOperationException();
	}
}
