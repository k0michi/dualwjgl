package org.lwjgl.opencl;

import com.koyomiji.lwjgl2w3.inject.Into;

@Into(CL12.class)
final class CL12Fragment {

	/** DEVIATION(out-of-scope): as LWJGL 2 where the implementation lacked it (see CLPrintfCallback). */
	public static int clSetPrintfCallback(CLContext context, CLPrintfCallback pfn_notify) {
		throw new IllegalStateException("Function is not supported");
	}

}
