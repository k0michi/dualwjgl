package org.lwjgl.opencl;

import org.lwjgl.PointerWrapperAbstract;

public abstract class CLPrintfCallback extends PointerWrapperAbstract {
	protected CLPrintfCallback() {
		super((long) 0L);
		// TODO(cl)
		throw new UnsupportedOperationException();
	}

	protected abstract void handleMessage(String data);
}
