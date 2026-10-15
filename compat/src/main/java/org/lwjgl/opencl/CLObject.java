package org.lwjgl.opencl;

import org.lwjgl.PointerWrapperAbstract;

public abstract class CLObject extends PointerWrapperAbstract {
	protected CLObject(long pointer) {
		super((long) 0L);
		// TODO(cl)
		throw new UnsupportedOperationException();
	}
}
