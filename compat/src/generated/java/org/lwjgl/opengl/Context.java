package org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Generated;
import org.lwjgl.LWJGLException;

@Generated
interface Context {
	boolean isCurrent() throws LWJGLException;

	void makeCurrent() throws LWJGLException;

	void releaseCurrent() throws LWJGLException;

	void releaseDrawable() throws LWJGLException;
}
