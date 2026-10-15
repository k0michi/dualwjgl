package org.lwjgl.opencl;

import com.koyomiji.lwjgl2w3.inject.Generated;
import com.koyomiji.lwjgl2w3.inject.Todo;
import org.lwjgl.PointerWrapperAbstract;

@Generated
public abstract class CLPrintfCallback extends PointerWrapperAbstract {
	@Todo("cl")
	protected CLPrintfCallback() {
		super((long) 0L);
		throw new UnsupportedOperationException();
	}

	protected abstract void handleMessage(String data);
}
