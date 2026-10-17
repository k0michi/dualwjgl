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

/**
 * DEVIATION(awt): rendering into an AWT component is not supported. LWJGL 2 rendered into the canvas's native peer,
 * which an SDL window cannot take over, so every constructor throws, as LWJGL 2 did where it could not create the
 * context; the other members are unreachable without an instance.
 */
public class AWTGLCanvas extends Canvas implements DrawableLWJGL, ComponentListener, HierarchyListener {

	private static final String UNSUPPORTED = "AWTGLCanvas is not supported";

	public AWTGLCanvas() throws LWJGLException {
		super();
		throw new LWJGLException(UNSUPPORTED);
	}
	public AWTGLCanvas(PixelFormat pixel_format) throws LWJGLException {
		super();
		throw new LWJGLException(UNSUPPORTED);
	}
	public AWTGLCanvas(GraphicsDevice device, PixelFormat pixel_format) throws LWJGLException {
		super();
		throw new LWJGLException(UNSUPPORTED);
	}
	public AWTGLCanvas(GraphicsDevice device, PixelFormat pixel_format, Drawable drawable) throws LWJGLException {
		super();
		throw new LWJGLException(UNSUPPORTED);
	}
	public AWTGLCanvas(GraphicsDevice device, PixelFormat pixel_format, Drawable drawable, ContextAttribs attribs) throws LWJGLException {
		super();
		throw new LWJGLException(UNSUPPORTED);
	}

	public void setPixelFormat(PixelFormatLWJGL pf) throws LWJGLException {
		throw new IllegalStateException(UNSUPPORTED);
	}

	public void setPixelFormat(PixelFormatLWJGL pf, ContextAttribs attribs) throws LWJGLException {
		throw new IllegalStateException(UNSUPPORTED);
	}

	public PixelFormatLWJGL getPixelFormat() {
		throw new IllegalStateException(UNSUPPORTED);
	}

	public ContextGL getContext() {
		throw new IllegalStateException(UNSUPPORTED);
	}

	public ContextGL createSharedContext() throws LWJGLException {
		throw new IllegalStateException(UNSUPPORTED);
	}

	public void checkGLError() {
		throw new IllegalStateException(UNSUPPORTED);
	}

	public void initContext(float r, float g, float b) {
		throw new IllegalStateException(UNSUPPORTED);
	}

	public void addNotify() {
		throw new IllegalStateException(UNSUPPORTED);
	}

	public void removeNotify() {
		throw new IllegalStateException(UNSUPPORTED);
	}

	public void setSwapInterval(int swap_interval) {
		throw new IllegalStateException(UNSUPPORTED);
	}

	public void setVSyncEnabled(boolean enabled) {
		throw new IllegalStateException(UNSUPPORTED);
	}

	public void swapBuffers() throws LWJGLException {
		throw new IllegalStateException(UNSUPPORTED);
	}

	public boolean isCurrent() throws LWJGLException {
		throw new IllegalStateException(UNSUPPORTED);
	}

	public void makeCurrent() throws LWJGLException {
		throw new IllegalStateException(UNSUPPORTED);
	}

	public void releaseContext() throws LWJGLException {
		throw new IllegalStateException(UNSUPPORTED);
	}

	public final void destroy() {
		throw new IllegalStateException(UNSUPPORTED);
	}

	public final void setCLSharingProperties(PointerBuffer properties) throws LWJGLException {
		throw new IllegalStateException(UNSUPPORTED);
	}

	protected void initGL() {
		throw new IllegalStateException(UNSUPPORTED);
	}

	protected void paintGL() {
		throw new IllegalStateException(UNSUPPORTED);
	}

	public final void paint(Graphics g) {
		throw new IllegalStateException(UNSUPPORTED);
	}

	protected void exceptionOccurred(LWJGLException exception) {
		throw new IllegalStateException(UNSUPPORTED);
	}

	public void update(Graphics g) {
		throw new IllegalStateException(UNSUPPORTED);
	}

	public void componentShown(ComponentEvent e) {
		throw new IllegalStateException(UNSUPPORTED);
	}

	public void componentHidden(ComponentEvent e) {
		throw new IllegalStateException(UNSUPPORTED);
	}

	public void componentResized(ComponentEvent e) {
		throw new IllegalStateException(UNSUPPORTED);
	}

	public void componentMoved(ComponentEvent e) {
		throw new IllegalStateException(UNSUPPORTED);
	}

	public void setLocation(int x, int y) {
		throw new IllegalStateException(UNSUPPORTED);
	}

	public void setLocation(Point p) {
		throw new IllegalStateException(UNSUPPORTED);
	}

	public void setSize(Dimension d) {
		throw new IllegalStateException(UNSUPPORTED);
	}

	public void setSize(int width, int height) {
		throw new IllegalStateException(UNSUPPORTED);
	}

	public void setBounds(int x, int y, int width, int height) {
		throw new IllegalStateException(UNSUPPORTED);
	}

	public void hierarchyChanged(HierarchyEvent e) {
		throw new IllegalStateException(UNSUPPORTED);
	}
}
