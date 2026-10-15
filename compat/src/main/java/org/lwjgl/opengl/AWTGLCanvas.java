package org.lwjgl.opengl;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.Point;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;
import org.lwjgl.LWJGLException;
import org.lwjgl.PointerBuffer;

public class AWTGLCanvas extends Canvas implements DrawableLWJGL, ComponentListener, HierarchyListener {
	public AWTGLCanvas() throws LWJGLException {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}
	public AWTGLCanvas(PixelFormat pixel_format) throws LWJGLException {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}
	public AWTGLCanvas(GraphicsDevice device, PixelFormat pixel_format) throws LWJGLException {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}
	public AWTGLCanvas(GraphicsDevice device, PixelFormat pixel_format, Drawable drawable) throws LWJGLException {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}
	public AWTGLCanvas(GraphicsDevice device, PixelFormat pixel_format, Drawable drawable, ContextAttribs attribs) throws LWJGLException {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public void setPixelFormat(PixelFormatLWJGL pf) throws LWJGLException {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public void setPixelFormat(PixelFormatLWJGL pf, ContextAttribs attribs) throws LWJGLException {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public PixelFormatLWJGL getPixelFormat() {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public ContextGL getContext() {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public ContextGL createSharedContext() throws LWJGLException {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public void checkGLError() {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public void initContext(float r, float g, float b) {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public void addNotify() {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public void removeNotify() {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public void setSwapInterval(int swap_interval) {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public void setVSyncEnabled(boolean enabled) {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public void swapBuffers() throws LWJGLException {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public boolean isCurrent() throws LWJGLException {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public void makeCurrent() throws LWJGLException {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public void releaseContext() throws LWJGLException {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public final void destroy() {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public final void setCLSharingProperties(PointerBuffer properties) throws LWJGLException {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	protected void initGL() {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	protected void paintGL() {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public final void paint(Graphics g) {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	protected void exceptionOccurred(LWJGLException exception) {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public void update(Graphics g) {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public void componentShown(ComponentEvent e) {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public void componentHidden(ComponentEvent e) {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public void componentResized(ComponentEvent e) {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public void componentMoved(ComponentEvent e) {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public void setLocation(int x, int y) {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public void setLocation(Point p) {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public void setSize(Dimension d) {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public void setSize(int width, int height) {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public void setBounds(int x, int y, int width, int height) {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public void hierarchyChanged(HierarchyEvent e) {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}
}
