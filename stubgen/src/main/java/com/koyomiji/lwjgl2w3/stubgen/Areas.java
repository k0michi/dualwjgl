package com.koyomiji.lwjgl2w3.stubgen;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/** The areas TODOs are grouped by, in report order. */
final class Areas {

	static final Map<String, String> SCOPES = new LinkedHashMap<>();

	static {
		SCOPES.put("core", "org.lwjgl: Sys-level utilities, PointerBuffer, MemoryUtil");
		SCOPES.put("context", "GLContext / ContextCapabilities on top of GL.getCapabilities()");
		SCOPES.put("gl", "OpenGL bindings: mostly mechanical delegation to LWJGL 3 (e.g. glFog -> glFogfv)");
		SCOPES.put("gles", "OpenGL ES");
		SCOPES.put("sdl", "Display, input, pbuffers: SDL-based reimplementation");
		SCOPES.put("al", "OpenAL: AL/ALC object model over LWJGL 3 handles");
		SCOPES.put("cl", "OpenCL: CL object model (CLPlatform, CLDevice, ...) over LWJGL 3 handles");
		SCOPES.put("port", "Pure Java utilities from lwjgl_util: port from the LWJGL 2 sources (BSD)");
	}

	private static final Set<String> SDL_CLASSES = Set.of(
		"Display", "DisplayMode", "PixelFormat", "PixelFormatLWJGL", "Pbuffer", "Drawable", "SharedDrawable",
		"AWTGLCanvas", "XRandR", "RenderTexture");
	private static final Set<String> CONTEXT_CLASSES = Set.of("GLContext", "ContextCapabilities", "ContextAttribs");

	private Areas() {
	}

	static String of(String pkg, String simple) {
		if (pkg.startsWith("org.lwjgl.util")) {
			return "port";
		}
		return switch (pkg) {
			case "org.lwjgl.input" -> "sdl";
			case "org.lwjgl.opengl" -> SDL_CLASSES.contains(simple) ? "sdl" : CONTEXT_CLASSES.contains(simple) ? "context" : "gl";
			case "org.lwjgl.opengles" -> "gles";
			case "org.lwjgl.openal" -> "al";
			case "org.lwjgl.opencl" -> "cl";
			default -> "core";
		};
	}

}
