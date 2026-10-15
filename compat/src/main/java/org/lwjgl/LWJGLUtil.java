package org.lwjgl;

import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.util.Map;

public class LWJGLUtil {
	public static final int PLATFORM_LINUX = 1;
	public static final int PLATFORM_MACOSX = 2;
	public static final int PLATFORM_WINDOWS = 3;
	public static final String PLATFORM_LINUX_NAME = "linux";
	public static final String PLATFORM_MACOSX_NAME = "macosx";
	public static final String PLATFORM_WINDOWS_NAME = "windows";
	public static final ByteBuffer LWJGLIcon16x16 = null; // TODO(core)
	public static final ByteBuffer LWJGLIcon32x32 = null; // TODO(core)
	public static final boolean DEBUG = false; // TODO(core)
	public static final boolean CHECKS = false; // TODO(core)

	public LWJGLUtil() {
		// TODO(core)
		throw new UnsupportedOperationException();
	}

	public static int getPlatform() {
		// TODO(core)
		throw new UnsupportedOperationException();
	}

	public static String getPlatformName() {
		// TODO(core)
		throw new UnsupportedOperationException();
	}

	public static String mapLibraryName(String name) {
		// TODO(core)
		throw new UnsupportedOperationException();
	}

	public static String[] getLibraryPaths(String libname, String platform_lib_name, ClassLoader classloader) {
		// TODO(core)
		throw new UnsupportedOperationException();
	}

	public static String[] getLibraryPaths(String libname, String[] platform_lib_names, ClassLoader classloader) {
		// TODO(core)
		throw new UnsupportedOperationException();
	}

	public static boolean getPrivilegedBoolean(String property_name) {
		// TODO(core)
		throw new UnsupportedOperationException();
	}

	public static Integer getPrivilegedInteger(String property_name) {
		// TODO(core)
		throw new UnsupportedOperationException();
	}

	public static Integer getPrivilegedInteger(String property_name, int default_val) {
		// TODO(core)
		throw new UnsupportedOperationException();
	}

	public static void log(CharSequence msg) {
		// TODO(core)
		throw new UnsupportedOperationException();
	}

	public static boolean isMacOSXEqualsOrBetterThan(int major_required, int minor_required) {
		// TODO(core)
		throw new UnsupportedOperationException();
	}

	public static Map<Integer, String> getClassTokens(LWJGLUtil.TokenFilter filter, Map<Integer, String> target, Class... tokenClasses) {
		// TODO(core)
		throw new UnsupportedOperationException();
	}

	public static Map<Integer, String> getClassTokens(LWJGLUtil.TokenFilter filter, Map<Integer, String> target, Iterable<Class> tokenClasses) {
		// TODO(core)
		throw new UnsupportedOperationException();
	}

	public static String toHexString(int value) {
		// TODO(core)
		throw new UnsupportedOperationException();
	}

	public static interface TokenFilter {
		boolean accept(Field field, int value);
	}
}
