package org.lwjgl.opengl;

import java.awt.Canvas;
import java.nio.ByteBuffer;
import org.lwjgl.LWJGLException;

public final class Display {
	private Display() {
	}

	public static Drawable getDrawable() {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static DisplayMode[] getAvailableDisplayModes() throws LWJGLException {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static DisplayMode getDesktopDisplayMode() {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static DisplayMode getDisplayMode() {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static void setDisplayMode(DisplayMode mode) throws LWJGLException {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static void setDisplayConfiguration(float gamma, float brightness, float contrast) throws LWJGLException {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static void sync(int fps) {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static String getTitle() {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static Canvas getParent() {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static void setParent(Canvas parent) throws LWJGLException {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static void setFullscreen(boolean fullscreen) throws LWJGLException {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static void setDisplayModeAndFullscreen(DisplayMode mode) throws LWJGLException {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static boolean isFullscreen() {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static void setTitle(String newTitle) {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static boolean isCloseRequested() {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static boolean isVisible() {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static boolean isActive() {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static boolean isDirty() {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static void processMessages() {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static void swapBuffers() throws LWJGLException {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static void update() {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static void update(boolean processMessages) {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static void releaseContext() throws LWJGLException {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static boolean isCurrent() throws LWJGLException {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static void makeCurrent() throws LWJGLException {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static void create() throws LWJGLException {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static void create(PixelFormat pixel_format) throws LWJGLException {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static void create(PixelFormat pixel_format, Drawable shared_drawable) throws LWJGLException {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static void create(PixelFormat pixel_format, ContextAttribs attribs) throws LWJGLException {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static void create(PixelFormat pixel_format, Drawable shared_drawable, ContextAttribs attribs) throws LWJGLException {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static void create(PixelFormatLWJGL pixel_format) throws LWJGLException {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static void create(PixelFormatLWJGL pixel_format, Drawable shared_drawable) throws LWJGLException {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static void create(PixelFormatLWJGL pixel_format, org.lwjgl.opengles.ContextAttribs attribs) throws LWJGLException {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static void create(PixelFormatLWJGL pixel_format, Drawable shared_drawable, org.lwjgl.opengles.ContextAttribs attribs) throws LWJGLException {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static void setInitialBackground(float red, float green, float blue) {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static void destroy() {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static boolean isCreated() {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static void setSwapInterval(int value) {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static void setVSyncEnabled(boolean sync) {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static void setLocation(int new_x, int new_y) {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static String getAdapter() {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static String getVersion() {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static int setIcon(ByteBuffer[] icons) {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static void setResizable(boolean resizable) {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static boolean isResizable() {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static boolean wasResized() {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static int getX() {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static int getY() {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static int getWidth() {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static int getHeight() {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}

	public static float getPixelScaleFactor() {
		// TODO(sdl)
		throw new UnsupportedOperationException();
	}
}
