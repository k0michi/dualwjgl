package org.lwjgl.opencl;

import org.lwjgl.PointerWrapperAbstract;

/**
 * DEVIATION(out-of-scope): printf callbacks are not supported (LWJGL 3 does not bind clSetPrintfCallback). A callback
 * can be created, with no native function behind it, and clSetPrintfCallback reports the function as not supported.
 */
public abstract class CLPrintfCallback extends PointerWrapperAbstract {

	protected CLPrintfCallback() {
		super(0L);
	}

	protected abstract void handleMessage(String data);

}
