package org.lwjgl;

import com.koyomiji.lwjgl2w3.inject.Generated;
import com.koyomiji.lwjgl2w3.inject.Todo;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.util.Map;

@Generated
public class LWJGLUtil {
	public static final int PLATFORM_LINUX = 1;
	public static final int PLATFORM_MACOSX = 2;
	public static final int PLATFORM_WINDOWS = 3;
	public static final String PLATFORM_LINUX_NAME = "linux";
	public static final String PLATFORM_MACOSX_NAME = "macosx";
	public static final String PLATFORM_WINDOWS_NAME = "windows";
	@Todo("core")
	public static final ByteBuffer LWJGLIcon16x16 = null;
	@Todo("core")
	public static final ByteBuffer LWJGLIcon32x32 = null;
	@Todo("core")
	public static final boolean DEBUG = false;
	@Todo("core")
	public static final boolean CHECKS = false;

	@Todo("core")
	public LWJGLUtil() {
		throw new UnsupportedOperationException();
	}

	@Todo("core")
	public static int getPlatform() {
		throw new UnsupportedOperationException();
	}

	@Todo("core")
	public static String getPlatformName() {
		throw new UnsupportedOperationException();
	}

	@Todo("core")
	public static String mapLibraryName(String name) {
		throw new UnsupportedOperationException();
	}

	@Todo("core")
	public static String[] getLibraryPaths(String libname, String platform_lib_name, ClassLoader classloader) {
		throw new UnsupportedOperationException();
	}

	@Todo("core")
	public static String[] getLibraryPaths(String libname, String[] platform_lib_names, ClassLoader classloader) {
		throw new UnsupportedOperationException();
	}

	@Todo("core")
	public static boolean getPrivilegedBoolean(String property_name) {
		throw new UnsupportedOperationException();
	}

	@Todo("core")
	public static Integer getPrivilegedInteger(String property_name) {
		throw new UnsupportedOperationException();
	}

	@Todo("core")
	public static Integer getPrivilegedInteger(String property_name, int default_val) {
		throw new UnsupportedOperationException();
	}

	@Todo("core")
	public static void log(CharSequence msg) {
		throw new UnsupportedOperationException();
	}

	@Todo("core")
	public static boolean isMacOSXEqualsOrBetterThan(int major_required, int minor_required) {
		throw new UnsupportedOperationException();
	}

	@Todo("core")
	public static Map<Integer, String> getClassTokens(LWJGLUtil.TokenFilter filter, Map<Integer, String> target, Class... tokenClasses) {
		throw new UnsupportedOperationException();
	}

	@Todo("core")
	public static Map<Integer, String> getClassTokens(LWJGLUtil.TokenFilter filter, Map<Integer, String> target, Iterable<Class> tokenClasses) {
		throw new UnsupportedOperationException();
	}

	@Todo("core")
	public static String toHexString(int value) {
		throw new UnsupportedOperationException();
	}

	@Generated
	public static interface TokenFilter {
		boolean accept(Field field, int value);
	}
}
