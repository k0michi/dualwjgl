package com.koyomiji.dualwjgl;

import org.lwjgl.system.JNI;
import org.lwjgl.system.Library;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.macosx.ObjCRuntime;

/**
 * -Xdock:name and -Xdock:icon under the launcher. The java launcher passes them to the process as APP_NAME_<pid> and
 * APP_ICON_<pid>, which AWT applies when it creates the application; under the launcher SDL creates it, so they are
 * applied here, as AWT does: the name before SDL starts (SDL names its menus from the bundle's name then), the icon once
 * the application exists.
 */
final class Dock {

	private static final long objc_msgSend = ObjCRuntime.getLibrary().getFunctionAddress("objc_msgSend");

	private Dock() {
	}

	/** -Xdock:name, before SDL creates the application: the bundle's name (SDL's menus) and the process's. */
	static void applyName() {
		String name = environment("APP_NAME_");
		if (name == null || name.isEmpty()) {
			return;
		}
		try (MemoryStack stack = MemoryStack.stackPush()) {
			long string = string(stack, name);
			long info = send(send(cls("NSBundle"), "mainBundle"), "infoDictionary");
			if (info != 0L && JNI.invokePPPZ(info, sel("isKindOfClass:"), cls("NSMutableDictionary"), objc_msgSend)) {
				JNI.invokePPPPV(info, sel("setObject:forKey:"), string, string(stack, "CFBundleName"), objc_msgSend);
			}
			JNI.invokePPPV(send(cls("NSProcessInfo"), "processInfo"), sel("setProcessName:"), string, objc_msgSend);
		}
	}

	/** -Xdock:icon, once the application exists: the Dock's icon. */
	static void applyIcon() {
		String path = environment("APP_ICON_");
		if (path == null || path.isEmpty()) {
			return;
		}
		try (MemoryStack stack = MemoryStack.stackPush()) {
			long image = JNI.invokePPPP(send(cls("NSImage"), "alloc"), sel("initWithContentsOfFile:"), string(stack, path), objc_msgSend);
			if (image == 0L) {
				System.err.println("[DuaLWJGL] Could not read the Dock icon " + path);
				return;
			}
			JNI.invokePPPV(send(cls("NSApplication"), "sharedApplication"), sel("setApplicationIconImage:"), image, objc_msgSend);
		}
	}

	private static String environment(String prefix) {
		long getpid = Library.loadNative(Dock.class, "org.lwjgl", "/usr/lib/libSystem.B.dylib").getFunctionAddress("getpid");
		return System.getenv(prefix + JNI.invokeI(getpid));
	}

	private static long string(MemoryStack stack, String s) {
		return JNI.invokePPPP(cls("NSString"), sel("stringWithUTF8String:"), MemoryUtil.memAddress(stack.UTF8(s)), objc_msgSend);
	}

	private static long send(long receiver, String selector) {
		return JNI.invokePPP(receiver, sel(selector), objc_msgSend);
	}

	private static long cls(String name) {
		return ObjCRuntime.objc_getClass(name);
	}

	private static long sel(String name) {
		return ObjCRuntime.sel_getUid(name);
	}

}
