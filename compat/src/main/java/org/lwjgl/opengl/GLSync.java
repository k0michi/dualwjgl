package org.lwjgl.opengl;

import org.lwjgl.PointerWrapperAbstract;

/**
 * A GLsync handle, as in LWJGL 2. LWJGL 3 passes the handle as a {@code long}; LWJGL 2's GL32/ARBSync methods wrap it.
 * The constructor is package-private in LWJGL 2; it is public here because the generated GL32/ARBSync members are
 * compiled in another package before the merger moves them into this one.
 */
public final class GLSync extends PointerWrapperAbstract {

	public GLSync(long sync) {
		super(sync);
	}

}
