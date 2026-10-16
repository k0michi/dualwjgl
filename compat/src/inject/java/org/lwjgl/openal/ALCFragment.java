package org.lwjgl.openal;

import com.koyomiji.lwjgl2w3.inject.Into;
import com.koyomiji.lwjgl2w3.inject.Wrap;

/** Marks ALC.destroy's own call of AL.destroy, which then leaves the library to it (see {@link ALFragment}). */
@Into(ALC.class)
final class ALCFragment {

	@Wrap
	public static void destroy() {
		ALObjects.beginALCDestroy();
		try {
			destroy$lwjgl3();
		} finally {
			ALObjects.endALCDestroy();
		}
	}

	static native void destroy$lwjgl3();

}
