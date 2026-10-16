package org.lwjgl.opengl;

import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.LWJGLUtil;
import org.lwjgl.PointerBuffer;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.sdl.SDL_DisplayMode;
import org.lwjgl.sdl.SDL_Event;
import org.lwjgl.sdl.SDL_Surface;
import org.lwjgl.system.MemoryStack;

import java.awt.Canvas;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.LinkedHashSet;
import java.util.Set;

import static org.lwjgl.sdl.SDLError.SDL_GetError;
import static org.lwjgl.sdl.SDLEvents.*;
import static org.lwjgl.sdl.SDLInit.*;
import static org.lwjgl.sdl.SDLPixels.SDL_BITSPERPIXEL;
import static org.lwjgl.sdl.SDLPixels.SDL_PIXELFORMAT_RGBA32;
import static org.lwjgl.sdl.SDLStdinc.SDL_free;
import static org.lwjgl.sdl.SDLSurface.SDL_CreateSurfaceFrom;
import static org.lwjgl.sdl.SDLSurface.SDL_DestroySurface;
import static org.lwjgl.sdl.SDLVideo.*;

/**
 * LWJGL 2's Display, on LWJGL 3's SDL 3 bindings: one SDL window with an OpenGL context, made current on the creating
 * thread with LWJGL 3's GL capabilities.
 *
 * <p>Input goes through {@link SDLInput}, LWJGL 2's InputImplementation, which LWJGL 2's Mouse and Keyboard (compiled
 * unchanged) reach through getImplementation(), as in LWJGL 2.</p>
 *
 * <p>Not there yet: shared contexts and Pbuffers, OpenGL ES. Not supported: setParent (AWT embedding, DEVIATION(awt))
 * and setDisplayConfiguration (gamma, DEVIATION(display-configuration)).</p>
 *
 * <p>DEVIATION(macos-first-thread): on macOS, SDL's video needs the process's first thread, so the JVM must run with
 * -XstartOnFirstThread and the Display be used from main(); without it, the Display fails with "No available video
 * device". LWJGL 2 needed neither. Sys.alert and Sys.getClipboard need it too, and fall back without it.</p>
 */
public final class Display {

	private static final Object lock = GlobalLock.lock;
	private static final Drawable drawable = new DisplayDrawable();
	private static final SDLInput input = new SDLInput();

	private static DisplayMode initialMode;
	private static DisplayMode currentMode;
	private static String title = "Game";
	private static boolean fullscreen;
	private static boolean resizable;
	private static int swapInterval;
	private static int x = -1;
	private static int y = -1;
	private static float red;
	private static float green;
	private static float blue;
	private static ByteBuffer[] cachedIcons;

	private static long window;
	private static long context;
	private static GLCapabilities capabilities;
	private static int width;
	private static int height;
	private static boolean closeRequested;
	private static boolean resizeEvent;
	private static boolean windowResized;

	private Display() {
	}

	// ---- SDL

	/** The video subsystem, on first use: LWJGL 2 initialized the display in its static initializer. */
	private static void video() throws LWJGLException {
		if (SDL_WasInit(SDL_INIT_VIDEO) == 0 && !SDL_InitSubSystem(SDL_INIT_VIDEO)) {
			throw new LWJGLException("Could not initialize SDL video: " + SDL_GetError()
				+ (LWJGLUtil.getPlatform() == LWJGLUtil.PLATFORM_MACOSX ? " (on macOS, run the JVM with -XstartOnFirstThread)" : ""));
		}
	}

	private static DisplayMode mode(SDL_DisplayMode m) {
		return new DisplayMode(m.w(), m.h(), SDL_BITSPERPIXEL(m.format()), Math.round(m.refresh_rate()));
	}

	private static DisplayMode initialMode() {
		synchronized (lock) {
			if (initialMode == null) {
				try {
					video();
				} catch (LWJGLException e) {
					throw new RuntimeException(e);
				}
				SDL_DisplayMode m = SDL_GetDesktopDisplayMode(SDL_GetPrimaryDisplay());
				if (m == null) {
					throw new RuntimeException("Could not get the desktop display mode: " + SDL_GetError());
				}
				initialMode = mode(m);
				if (currentMode == null) {
					currentMode = initialMode;
				}
			}
			return initialMode;
		}
	}

	// ---- display modes

	public static DisplayMode[] getAvailableDisplayModes() throws LWJGLException {
		synchronized (lock) {
			video();
			PointerBuffer modes = SDL_GetFullscreenDisplayModes(SDL_GetPrimaryDisplay());
			if (modes == null) {
				throw new LWJGLException("Could not get the display modes: " + SDL_GetError());
			}
			try {
				Set<DisplayMode> out = new LinkedHashSet<>();
				for (int i = 0; i < modes.remaining(); i++) {
					out.add(mode(SDL_DisplayMode.create(modes.get(i))));
				}
				return out.toArray(new DisplayMode[0]);
			} finally {
				SDL_free(modes);
			}
		}
	}

	public static DisplayMode getDesktopDisplayMode() {
		return initialMode();
	}

	public static DisplayMode getDisplayMode() {
		initialMode();
		return currentMode;
	}

	public static void setDisplayMode(DisplayMode mode) throws LWJGLException {
		synchronized (lock) {
			if (mode == null) {
				throw new NullPointerException("mode must be non-null");
			}
			initialMode();
			currentMode = mode;
			if (isCreated()) {
				applyMode();
			}
		}
	}

	public static void setFullscreen(boolean fullscreen) throws LWJGLException {
		synchronized (lock) {
			initialMode();
			Display.fullscreen = fullscreen;
			if (isCreated()) {
				applyMode();
			}
		}
	}

	public static void setDisplayModeAndFullscreen(DisplayMode mode) throws LWJGLException {
		synchronized (lock) {
			if (mode == null) {
				throw new NullPointerException("mode must be non-null");
			}
			initialMode();
			currentMode = mode;
			fullscreen = mode.isFullscreenCapable();
			if (isCreated()) {
				applyMode();
			}
		}
	}

	/** As LWJGL 2: fullscreen only with a mode from getAvailableDisplayModes(). */
	public static boolean isFullscreen() {
		return fullscreen && getDisplayMode().isFullscreenCapable();
	}

	/** The window's mode and size for the current mode and fullscreen setting. */
	private static void applyMode() throws LWJGLException {
		DisplayMode mode = currentMode;
		if (isFullscreen()) {
			SDL_DisplayMode closest = SDL_DisplayMode.malloc();
			try {
				if (!SDL_GetClosestFullscreenDisplayMode(SDL_GetPrimaryDisplay(), mode.getWidth(), mode.getHeight(), mode.getFrequency(),
					false, closest) || !SDL_SetWindowFullscreenMode(window, closest) || !SDL_SetWindowFullscreen(window, true)) {
					throw new LWJGLException("Could not switch to " + mode + ": " + SDL_GetError());
				}
			} finally {
				closest.free();
			}
		} else {
			SDL_SetWindowFullscreen(window, false);
			SDL_SetWindowFullscreenMode(window, null);
			SDL_SetWindowSize(window, mode.getWidth(), mode.getHeight());
			SDL_SetWindowPosition(window, windowX(), windowY());
		}
		width = mode.getWidth();
		height = mode.getHeight();
	}

	private static int windowX() {
		return x == -1 ? SDL_WINDOWPOS_CENTERED : x;
	}

	private static int windowY() {
		return y == -1 ? SDL_WINDOWPOS_CENTERED : y;
	}

	/**
	 * DEVIATION(display-configuration): not supported, failing as LWJGL 2 did where the platform had no gamma ramp. SDL 3
	 * has no gamma API. LWJGL 2's checks come first, in its order.
	 */
	public static void setDisplayConfiguration(float gamma, float brightness, float contrast) throws LWJGLException {
		synchronized (lock) {
			if (!isCreated()) {
				throw new LWJGLException("Display not yet created.");
			}
			if (brightness < -1.0f || brightness > 1.0f) {
				throw new IllegalArgumentException("Invalid brightness value");
			}
			if (contrast < 0.0f) {
				throw new IllegalArgumentException("Invalid contrast value");
			}
			throw new LWJGLException("Display configuration not supported");
		}
	}

	// ---- window

	public static void sync(int fps) {
		Sync.sync(fps);
	}

	public static String getTitle() {
		synchronized (lock) {
			return title;
		}
	}

	public static void setTitle(String newTitle) {
		synchronized (lock) {
			title = newTitle == null ? "" : newTitle;
			if (isCreated()) {
				SDL_SetWindowTitle(window, title);
			}
		}
	}

	public static Canvas getParent() {
		return null;
	}

	/** DEVIATION(awt): embedding in an AWT Canvas is not supported. A null parent, the default, is accepted. */
	public static void setParent(Canvas parent) throws LWJGLException {
		if (parent != null) {
			throw new LWJGLException("Display.setParent is not supported");
		}
	}

	public static void setLocation(int new_x, int new_y) {
		synchronized (lock) {
			x = new_x;
			y = new_y;
			if (isCreated() && !isFullscreen()) {
				SDL_SetWindowPosition(window, windowX(), windowY());
			}
		}
	}

	public static int getX() {
		synchronized (lock) {
			if (isFullscreen() || !isCreated()) {
				return isFullscreen() ? 0 : x;
			}
			try (MemoryStack stack = MemoryStack.stackPush()) {
				IntBuffer px = stack.mallocInt(1);
				SDL_GetWindowPosition(window, px, null);
				return px.get(0);
			}
		}
	}

	public static int getY() {
		synchronized (lock) {
			if (isFullscreen() || !isCreated()) {
				return isFullscreen() ? 0 : y;
			}
			try (MemoryStack stack = MemoryStack.stackPush()) {
				IntBuffer py = stack.mallocInt(1);
				SDL_GetWindowPosition(window, null, py);
				return py.get(0);
			}
		}
	}

	public static int getWidth() {
		if (isFullscreen()) {
			return getDisplayMode().getWidth();
		}
		return isCreated() ? width : getDisplayMode().getWidth();
	}

	public static int getHeight() {
		if (isFullscreen()) {
			return getDisplayMode().getHeight();
		}
		return isCreated() ? height : getDisplayMode().getHeight();
	}

	/** 1 unless org.lwjgl.opengl.Display.enableHighDPI is set, as in LWJGL 2. */
	public static float getPixelScaleFactor() {
		return isCreated() ? SDL_GetWindowPixelDensity(window) : 1f;
	}

	public static void setResizable(boolean resizable) {
		synchronized (lock) {
			Display.resizable = resizable;
			if (isCreated()) {
				SDL_SetWindowResizable(window, resizable);
			}
		}
	}

	public static boolean isResizable() {
		return resizable;
	}

	/** Whether the window was resized by the user before the last update(). */
	public static boolean wasResized() {
		return windowResized;
	}

	public static boolean isCloseRequested() {
		synchronized (lock) {
			if (!isCreated()) {
				throw new IllegalStateException("Cannot determine close requested state of uncreated window");
			}
			// as LWJGL 2's implementations: reading the request consumes it
			boolean requested = closeRequested;
			closeRequested = false;
			return requested;
		}
	}

	public static boolean isVisible() {
		synchronized (lock) {
			if (!isCreated()) {
				throw new IllegalStateException("Cannot determine minimized state of uncreated window");
			}
			return (SDL_GetWindowFlags(window) & (SDL_WINDOW_HIDDEN | SDL_WINDOW_MINIMIZED)) == 0;
		}
	}

	public static boolean isActive() {
		synchronized (lock) {
			if (!isCreated()) {
				throw new IllegalStateException("Cannot determine focused state of uncreated window");
			}
			return (SDL_GetWindowFlags(window) & SDL_WINDOW_INPUT_FOCUS) != 0;
		}
	}

	/** Never: the window keeps its contents, as with LWJGL 2's Windows and Mac implementations. */
	public static boolean isDirty() {
		synchronized (lock) {
			if (!isCreated()) {
				throw new IllegalStateException("Cannot determine dirty state of uncreated window");
			}
			return false;
		}
	}

	public static void setInitialBackground(float red, float green, float blue) {
		Display.red = red;
		Display.green = green;
		Display.blue = blue;
	}

	/** RGBA icons, square; SDL takes the largest, and the others as alternatives for other sizes. */
	public static int setIcon(ByteBuffer[] icons) {
		synchronized (lock) {
			// a deep copy, as LWJGL 2: the caller's buffers may change after this returns
			if (cachedIcons != icons) {
				cachedIcons = new ByteBuffer[icons.length];
				for (int i = 0; i < icons.length; i++) {
					cachedIcons[i] = BufferUtils.createByteBuffer(icons[i].remaining());
					cachedIcons[i].put(icons[i].duplicate()).flip();
				}
			}
			return isCreated() ? applyIcons() : 0;
		}
	}

	private static int applyIcons() {
		ByteBuffer largest = null;
		for (ByteBuffer icon : cachedIcons) {
			if (largest == null || icon.remaining() > largest.remaining()) {
				largest = icon;
			}
		}
		if (largest == null) {
			return 0;
		}
		int side = (int)Math.sqrt(largest.remaining() / 4);
		SDL_Surface surface = SDL_CreateSurfaceFrom(side, side, SDL_PIXELFORMAT_RGBA32, largest, side * 4);
		if (surface == null) {
			return 0;
		}
		try {
			return SDL_SetWindowIcon(window, surface) ? 1 : 0;
		} finally {
			SDL_DestroySurface(surface);
		}
	}

	public static String getAdapter() {
		return null;
	}

	public static String getVersion() {
		return null;
	}

	// ---- creation

	public static void create() throws LWJGLException {
		create(new PixelFormat(), null, (ContextAttribs)null);
	}

	public static void create(PixelFormat pixel_format) throws LWJGLException {
		create(pixel_format, null, (ContextAttribs)null);
	}

	public static void create(PixelFormat pixel_format, Drawable shared_drawable) throws LWJGLException {
		create(pixel_format, shared_drawable, (ContextAttribs)null);
	}

	public static void create(PixelFormat pixel_format, ContextAttribs attribs) throws LWJGLException {
		create(pixel_format, null, attribs);
	}

	public static void create(PixelFormat pixel_format, Drawable shared_drawable, ContextAttribs attribs) throws LWJGLException {
		synchronized (lock) {
			if (isCreated()) {
				throw new IllegalStateException("Only one LWJGL context may be instantiated at any one time.");
			}
			if (pixel_format == null) {
				throw new NullPointerException("pixel_format cannot be null");
			}
			if (shared_drawable != null) {
				// TODO(sdl): shared contexts (SharedDrawable, Pbuffer)
				throw new LWJGLException("Shared contexts are not supported yet");
			}
			initialMode();
			video();
			glAttributes(pixel_format, attribs);

			long flags = SDL_WINDOW_OPENGL | SDL_WINDOW_HIDDEN;
			if (resizable) {
				flags |= SDL_WINDOW_RESIZABLE;
			}
			if (LWJGLUtil.getPrivilegedBoolean("org.lwjgl.opengl.Display.enableHighDPI")) {
				flags |= SDL_WINDOW_HIGH_PIXEL_DENSITY;
			}
			DisplayMode mode = currentMode;
			window = SDL_CreateWindow(title, mode.getWidth(), mode.getHeight(), flags);
			if (window == 0L) {
				throw new LWJGLException("Could not create the window: " + SDL_GetError());
			}
			try {
				context = SDL_GL_CreateContext(window);
				if (context == 0L) {
					throw new LWJGLException("Could not create the OpenGL context: " + SDL_GetError());
				}
				if (!SDL_GL_MakeCurrent(window, context)) {
					throw new LWJGLException("Could not make the OpenGL context current: " + SDL_GetError());
				}
				capabilities = GL.createCapabilities();
				applyMode();
				SDL_ShowWindow(window);
				setSwapInterval(swapInterval);
				// as LWJGL 2: the window icon, the given one or LWJGL's
				setIcon(cachedIcons != null ? cachedIcons : new ByteBuffer[] {LWJGLUtil.LWJGLIcon32x32, LWJGLUtil.LWJGLIcon16x16});
				initControls();
				// as LWJGL 2's initContext: clear to the initial background and show it
				GL11.glClearColor(red, green, blue, 0f);
				GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
				update();
			} catch (RuntimeException e) { // LWJGLException included: it is unchecked here
				destroy();
				throw e;
			}
		}
	}

	/** As LWJGL 2: the input devices, unless org.lwjgl.opengl.Display.noinput (or .nomouse, .nokeyboard) is set. */
	private static void initControls() {
		if (LWJGLUtil.getPrivilegedBoolean("org.lwjgl.opengl.Display.noinput")) {
			return;
		}
		if (!Mouse.isCreated() && !LWJGLUtil.getPrivilegedBoolean("org.lwjgl.opengl.Display.nomouse")) {
			try {
				Mouse.create();
			} catch (LWJGLException e) {
				LWJGLUtil.log("Failed to create Mouse: " + e);
			}
		}
		if (!Keyboard.isCreated() && !LWJGLUtil.getPrivilegedBoolean("org.lwjgl.opengl.Display.nokeyboard")) {
			try {
				Keyboard.create();
			} catch (LWJGLException e) {
				LWJGLUtil.log("Failed to create Keyboard: " + e);
			}
		}
	}

	/** PixelFormat and ContextAttribs as SDL OpenGL attributes, before the window is created. */
	private static void glAttributes(PixelFormat format, ContextAttribs attribs) throws LWJGLException {
		SDL_GL_ResetAttributes();
		SDL_GL_SetAttribute(SDL_GL_DOUBLEBUFFER, 1);
		int bpp = format.getBitsPerPixel();
		if (bpp > 0) {
			int channel = bpp >= 24 ? 8 : bpp >= 15 ? 5 : bpp / 3;
			SDL_GL_SetAttribute(SDL_GL_RED_SIZE, channel);
			SDL_GL_SetAttribute(SDL_GL_GREEN_SIZE, bpp == 16 ? 6 : channel);
			SDL_GL_SetAttribute(SDL_GL_BLUE_SIZE, channel);
		}
		SDL_GL_SetAttribute(SDL_GL_ALPHA_SIZE, format.getAlphaBits());
		SDL_GL_SetAttribute(SDL_GL_DEPTH_SIZE, format.getDepthBits());
		SDL_GL_SetAttribute(SDL_GL_STENCIL_SIZE, format.getStencilBits());
		if (format.getSamples() > 0) {
			SDL_GL_SetAttribute(SDL_GL_MULTISAMPLEBUFFERS, 1);
			SDL_GL_SetAttribute(SDL_GL_MULTISAMPLESAMPLES, format.getSamples());
		}
		int accum = format.getAccumulationBitsPerPixel();
		if (accum > 0) {
			int channel = accum / 3;
			SDL_GL_SetAttribute(SDL_GL_ACCUM_RED_SIZE, channel);
			SDL_GL_SetAttribute(SDL_GL_ACCUM_GREEN_SIZE, channel);
			SDL_GL_SetAttribute(SDL_GL_ACCUM_BLUE_SIZE, channel);
			SDL_GL_SetAttribute(SDL_GL_ACCUM_ALPHA_SIZE, format.getAccumulationAlpha());
		}
		SDL_GL_SetAttribute(SDL_GL_STEREO, format.isStereo() ? 1 : 0);
		SDL_GL_SetAttribute(SDL_GL_FRAMEBUFFER_SRGB_CAPABLE, format.isSRGB() ? 1 : 0);
		SDL_GL_SetAttribute(SDL_GL_FLOATBUFFERS, format.isFloatingPoint() ? 1 : 0);
		if (format.getAuxBuffers() > 0) {
			// TODO(sdl): auxiliary buffers, which SDL does not request
			throw new LWJGLException("Auxiliary buffers are not supported");
		}
		if (attribs != null) {
			SDL_GL_SetAttribute(SDL_GL_CONTEXT_MAJOR_VERSION, attribs.getMajorVersion());
			SDL_GL_SetAttribute(SDL_GL_CONTEXT_MINOR_VERSION, attribs.getMinorVersion());
			if (attribs.isProfileCore()) {
				SDL_GL_SetAttribute(SDL_GL_CONTEXT_PROFILE_MASK, SDL_GL_CONTEXT_PROFILE_CORE);
			} else if (attribs.isProfileCompatibility()) {
				SDL_GL_SetAttribute(SDL_GL_CONTEXT_PROFILE_MASK, SDL_GL_CONTEXT_PROFILE_COMPATIBILITY);
			} else if (attribs.isProfileES()) {
				SDL_GL_SetAttribute(SDL_GL_CONTEXT_PROFILE_MASK, SDL_GL_CONTEXT_PROFILE_ES);
			}
			int flags = 0;
			if (attribs.isDebug()) {
				flags |= SDL_GL_CONTEXT_DEBUG_FLAG;
			}
			if (attribs.isForwardCompatible()) {
				flags |= SDL_GL_CONTEXT_FORWARD_COMPATIBLE_FLAG;
			}
			if (attribs.isRobustAccess()) {
				flags |= SDL_GL_CONTEXT_ROBUST_ACCESS_FLAG;
			}
			if (attribs.isContextResetIsolation()) {
				flags |= SDL_GL_CONTEXT_RESET_ISOLATION_FLAG;
			}
			SDL_GL_SetAttribute(SDL_GL_CONTEXT_FLAGS, flags);
			if (attribs.isLoseContextOnReset()) {
				SDL_GL_SetAttribute(SDL_GL_CONTEXT_RESET_NOTIFICATION, SDL_GL_CONTEXT_RESET_LOSE_CONTEXT);
			}
		}
	}

	public static void create(PixelFormatLWJGL pixel_format) throws LWJGLException {
		create(pixel_format, null, (org.lwjgl.opengles.ContextAttribs)null);
	}

	public static void create(PixelFormatLWJGL pixel_format, Drawable shared_drawable) throws LWJGLException {
		create(pixel_format, shared_drawable, (org.lwjgl.opengles.ContextAttribs)null);
	}

	public static void create(PixelFormatLWJGL pixel_format, org.lwjgl.opengles.ContextAttribs attribs) throws LWJGLException {
		create(pixel_format, null, attribs);
	}

	/** LWJGL 2's OpenGL ES variants. */
	public static void create(PixelFormatLWJGL pixel_format, Drawable shared_drawable, org.lwjgl.opengles.ContextAttribs attribs)
		throws LWJGLException {
		// TODO(sdl): OpenGL ES contexts
		throw new LWJGLException("OpenGL ES is not supported yet");
	}

	public static boolean isCreated() {
		synchronized (lock) {
			return window != 0L;
		}
	}

	public static void destroy() {
		synchronized (lock) {
			if (Mouse.isCreated()) {
				Mouse.destroy();
			}
			if (Keyboard.isCreated()) {
				Keyboard.destroy();
			}
			if (context != 0L) {
				if (SDL_GL_GetCurrentContext() == context) {
					SDL_GL_MakeCurrent(window, 0L);
					GL.setCapabilities(null);
				}
				SDL_GL_DestroyContext(context);
				context = 0L;
			}
			if (window != 0L) {
				SDL_DestroyWindow(window);
				window = 0L;
			}
			capabilities = null;
			closeRequested = false;
			resizeEvent = false;
			windowResized = false;
		}
	}

	public static Drawable getDrawable() {
		return drawable;
	}

	/** LWJGL 2's input classes get it by reflection (OpenGLPackageAccess). */
	private static InputImplementation getImplementation() {
		return input;
	}

	static long window() {
		return window;
	}

	// ---- per frame

	public static void swapBuffers() throws LWJGLException {
		synchronized (lock) {
			if (!isCreated()) {
				throw new IllegalStateException("Display not created");
			}
			if (!SDL_GL_SwapWindow(window)) {
				throw new LWJGLException("Could not swap buffers: " + SDL_GetError());
			}
		}
	}

	public static void update() {
		update(true);
	}

	/** As LWJGL 2: swap when visible, take the resize since the last update, then process the window's events. */
	public static void update(boolean processMessages) {
		synchronized (lock) {
			if (!isCreated()) {
				throw new IllegalStateException("Display not created");
			}
			if (isVisible()) {
				try {
					swapBuffers();
				} catch (LWJGLException e) {
					throw new RuntimeException(e);
				}
			}
			windowResized = !isFullscreen() && resizeEvent;
			resizeEvent = false;
			if (processMessages) {
				processMessages();
			}
		}
	}

	public static void processMessages() {
		synchronized (lock) {
			if (!isCreated()) {
				throw new IllegalStateException("Display not created");
			}
			try (MemoryStack stack = MemoryStack.stackPush()) {
				SDL_Event event = SDL_Event.malloc(stack);
				while (SDL_PollEvent(event)) {
					handle(event);
					input.handle(event);
				}
				input.flushKeyboard();
			}
			// as LWJGL 2's pollDevices
			if (Mouse.isCreated()) {
				Mouse.poll();
				Mouse.updateCursor();
			}
			if (Keyboard.isCreated()) {
				Keyboard.poll();
			}
		}
	}

	private static void handle(SDL_Event event) {
		int type = event.type();
		if (type == SDL_EVENT_QUIT || type == SDL_EVENT_WINDOW_CLOSE_REQUESTED) {
			closeRequested = true;
		} else if (type == SDL_EVENT_WINDOW_RESIZED) {
			width = event.window().data1();
			height = event.window().data2();
			resizeEvent = true;
		}
	}

	// ---- context

	public static void setSwapInterval(int value) {
		synchronized (lock) {
			swapInterval = value;
			if (isCreated()) {
				SDL_GL_SetSwapInterval(value);
			}
		}
	}

	public static void setVSyncEnabled(boolean sync) {
		setSwapInterval(sync ? 1 : 0);
	}

	public static void makeCurrent() throws LWJGLException {
		drawable.makeCurrent();
	}

	public static void releaseContext() throws LWJGLException {
		drawable.releaseContext();
	}

	public static boolean isCurrent() throws LWJGLException {
		return drawable.isCurrent();
	}

	/** The Display's context: made current on a thread together with LWJGL 3's GL capabilities for it. */
	private static final class DisplayDrawable implements Drawable {

		@Override
		public boolean isCurrent() throws LWJGLException {
			synchronized (lock) {
				if (!Display.isCreated()) {
					throw new IllegalStateException("Display not created");
				}
				return SDL_GL_GetCurrentContext() == context;
			}
		}

		@Override
		public void makeCurrent() throws LWJGLException {
			synchronized (lock) {
				if (!Display.isCreated()) {
					throw new IllegalStateException("Display not created");
				}
				if (!SDL_GL_MakeCurrent(window, context)) {
					throw new LWJGLException("Could not make the OpenGL context current: " + SDL_GetError());
				}
				GL.setCapabilities(capabilities);
			}
		}

		@Override
		public void releaseContext() throws LWJGLException {
			synchronized (lock) {
				if (!Display.isCreated()) {
					throw new IllegalStateException("Display not created");
				}
				if (SDL_GL_GetCurrentContext() == context) {
					SDL_GL_MakeCurrent(window, 0L);
					GL.setCapabilities(null);
				}
			}
		}

		@Override
		public void destroy() {
			Display.destroy();
		}

		@Override
		public void setCLSharingProperties(PointerBuffer properties) throws LWJGLException {
			// TODO(cl): CL/GL sharing (CL_GL_CONTEXT_KHR and the platform's display or share group)
			throw new LWJGLException("CL/GL sharing is not supported yet");
		}

	}

}
