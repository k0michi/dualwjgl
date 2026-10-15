package org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Generated;
import org.lwjgl.LWJGLException;

@Generated
interface DrawableLWJGL extends Drawable {
	void setPixelFormat(PixelFormatLWJGL pf) throws LWJGLException;

	void setPixelFormat(PixelFormatLWJGL pf, ContextAttribs attribs) throws LWJGLException;

	PixelFormatLWJGL getPixelFormat();

	Context getContext();

	Context createSharedContext() throws LWJGLException;

	void checkGLError();

	void setSwapInterval(int swap_interval);

	void swapBuffers() throws LWJGLException;

	void initContext(float r, float g, float b);
}
