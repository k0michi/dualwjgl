package org.lwjgl.opencl;

import org.lwjgl.PointerWrapperAbstract;

/**
 * LWJGL 2's base class of all OpenCL objects, as in its sources except that it is public: LWJGL 2's public
 * {@code CL10.clSetKernelArg(CLKernel, int, CLObject)} mentions it, and the generated CL10 members are compiled in another
 * package before the merger moves them into this one.
 */
public abstract class CLObject extends PointerWrapperAbstract {

	protected CLObject(final long pointer) {
		super(pointer);
	}

	final long getPointerUnsafe() {
		return pointer;
	}

}
