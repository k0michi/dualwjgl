package org.lwjgl.opencl;

import com.koyomiji.dualwjgl.inject.Into;

import java.nio.ByteBuffer;

import static org.lwjgl.system.MemoryUtil.memByteBuffer;

/**
 * LWJGL 2's CL members besides create and destroy, which are LWJGL 3's (same signatures; both load and unload the
 * library, though LWJGL 2's destroy did nothing).
 *
 * <p>DEVIATION(explicit-init): LWJGL 3's create throws once the library is loaded, where LWJGL 2's returned, and LWJGL 3
 * loads it as CL initializes unless org.lwjgl.opencl.explicitInit is set: LWJGL 2 programs run with
 * -Dorg.lwjgl.opencl.explicitInit=true.</p>
 */
@Into(CL.class)
final class CLFragment {

	/** Whether LWJGL 3's CL has the library loaded: by CL.create, or on its own unless explicit init is set. */
	public static boolean isCreated() {
		try {
			CL.getFunctionProvider();
			return true;
		} catch (IllegalStateException | LinkageError e) { // not loaded, or CL's own startup failed
			return false;
		}
	}

	/** LWJGL 2's lookup of a function in the library (CLCapabilities, CLFunctionAddress); 0 if missing or not loaded. */
	static long getFunctionAddress(String name) {
		try {
			return CL.getFunctionProvider().getFunctionAddress(name);
		} catch (IllegalStateException | LinkageError e) { // not loaded, or CL's own startup failed
			return 0L;
		}
	}

	static long getFunctionAddress(String[] aliases) {
		for (String alias : aliases) {
			long address = getFunctionAddress(alias);
			if (address != 0) {
				return address;
			}
		}
		return 0;
	}

	/** InfoUtil's CL_MEM_HOST_PTR view. */
	static ByteBuffer getHostBuffer(final long address, final int size) {
		return memByteBuffer(address, size);
	}

}
