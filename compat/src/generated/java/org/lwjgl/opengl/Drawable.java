package org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Generated;
import org.lwjgl.LWJGLException;
import org.lwjgl.PointerBuffer;

@Generated
public interface Drawable {
	boolean isCurrent() throws LWJGLException;

	void makeCurrent() throws LWJGLException;

	void releaseContext() throws LWJGLException;

	void destroy();

	void setCLSharingProperties(PointerBuffer properties) throws LWJGLException;
}
