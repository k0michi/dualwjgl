package org.lwjgl.opengl;

public final class ContextAttribs {
	public static final int CONTEXT_MAJOR_VERSION_ARB = 0x2091;
	public static final int CONTEXT_MINOR_VERSION_ARB = 0x2092;
	public static final int CONTEXT_PROFILE_MASK_ARB = 0x9126;
	public static final int CONTEXT_CORE_PROFILE_BIT_ARB = 1;
	public static final int CONTEXT_COMPATIBILITY_PROFILE_BIT_ARB = 2;
	public static final int CONTEXT_ES2_PROFILE_BIT_EXT = 4;
	public static final int CONTEXT_FLAGS_ARB = 0x2094;
	public static final int CONTEXT_DEBUG_BIT_ARB = 1;
	public static final int CONTEXT_FORWARD_COMPATIBLE_BIT_ARB = 2;
	public static final int CONTEXT_ROBUST_ACCESS_BIT_ARB = 4;
	public static final int CONTEXT_RESET_ISOLATION_BIT_ARB = 8;
	public static final int CONTEXT_RESET_NOTIFICATION_STRATEGY_ARB = 0x8256;
	public static final int NO_RESET_NOTIFICATION_ARB = 0x8261;
	public static final int LOSE_CONTEXT_ON_RESET_ARB = 0x8252;
	public static final int CONTEXT_RELEASE_BEHABIOR_ARB = 0x2097;
	public static final int CONTEXT_RELEASE_BEHAVIOR_NONE_ARB = 0;
	public static final int CONTEXT_RELEASE_BEHAVIOR_FLUSH_ARB = 0x2098;
	public static final int CONTEXT_LAYER_PLANE_ARB = 0x2093;

	public ContextAttribs() {
		// TODO(context)
		throw new UnsupportedOperationException();
	}
	public ContextAttribs(int majorVersion, int minorVersion) {
		// TODO(context)
		throw new UnsupportedOperationException();
	}
	public ContextAttribs(int majorVersion, int minorVersion, int profileMask) {
		// TODO(context)
		throw new UnsupportedOperationException();
	}
	public ContextAttribs(int majorVersion, int minorVersion, int profileMask, int contextFlags) {
		// TODO(context)
		throw new UnsupportedOperationException();
	}

	public int getMajorVersion() {
		// TODO(context)
		throw new UnsupportedOperationException();
	}

	public int getMinorVersion() {
		// TODO(context)
		throw new UnsupportedOperationException();
	}

	public int getProfileMask() {
		// TODO(context)
		throw new UnsupportedOperationException();
	}

	public boolean isProfileCore() {
		// TODO(context)
		throw new UnsupportedOperationException();
	}

	public boolean isProfileCompatibility() {
		// TODO(context)
		throw new UnsupportedOperationException();
	}

	public boolean isProfileES() {
		// TODO(context)
		throw new UnsupportedOperationException();
	}

	public int getContextFlags() {
		// TODO(context)
		throw new UnsupportedOperationException();
	}

	public boolean isDebug() {
		// TODO(context)
		throw new UnsupportedOperationException();
	}

	public boolean isForwardCompatible() {
		// TODO(context)
		throw new UnsupportedOperationException();
	}

	public boolean isRobustAccess() {
		// TODO(context)
		throw new UnsupportedOperationException();
	}

	public boolean isContextResetIsolation() {
		// TODO(context)
		throw new UnsupportedOperationException();
	}

	public int getContextResetNotificationStrategy() {
		// TODO(context)
		throw new UnsupportedOperationException();
	}

	public boolean isLoseContextOnReset() {
		// TODO(context)
		throw new UnsupportedOperationException();
	}

	public int getContextReleaseBehavior() {
		// TODO(context)
		throw new UnsupportedOperationException();
	}

	public int getLayerPlane() {
		// TODO(context)
		throw new UnsupportedOperationException();
	}

	public ContextAttribs withProfileCore(boolean profileCore) {
		// TODO(context)
		throw new UnsupportedOperationException();
	}

	public ContextAttribs withProfileCompatibility(boolean profileCompatibility) {
		// TODO(context)
		throw new UnsupportedOperationException();
	}

	public ContextAttribs withProfileES(boolean profileES) {
		// TODO(context)
		throw new UnsupportedOperationException();
	}

	public ContextAttribs withDebug(boolean debug) {
		// TODO(context)
		throw new UnsupportedOperationException();
	}

	public ContextAttribs withForwardCompatible(boolean forwardCompatible) {
		// TODO(context)
		throw new UnsupportedOperationException();
	}

	public ContextAttribs withRobustAccess(boolean robustAccess) {
		// TODO(context)
		throw new UnsupportedOperationException();
	}

	public ContextAttribs withContextResetIsolation(boolean contextResetIsolation) {
		// TODO(context)
		throw new UnsupportedOperationException();
	}

	public ContextAttribs withResetNotificationStrategy(int strategy) {
		// TODO(context)
		throw new UnsupportedOperationException();
	}

	public ContextAttribs withLoseContextOnReset(boolean loseContextOnReset) {
		// TODO(context)
		throw new UnsupportedOperationException();
	}

	public ContextAttribs withContextReleaseBehavior(int behavior) {
		// TODO(context)
		throw new UnsupportedOperationException();
	}

	public ContextAttribs withLayer(int layerPlane) {
		// TODO(context)
		throw new UnsupportedOperationException();
	}

	public String toString() {
		// TODO(context)
		throw new UnsupportedOperationException();
	}
}
