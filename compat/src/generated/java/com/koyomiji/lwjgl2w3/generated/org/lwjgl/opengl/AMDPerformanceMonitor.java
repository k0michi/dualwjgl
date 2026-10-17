package com.koyomiji.lwjgl2w3.generated.org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Todo;

public final class AMDPerformanceMonitor {
	@Todo("gl")
	public static String glGetPerfMonitorGroupStringAMD(int group, int bufSize) {
		throw new UnsupportedOperationException();
	}
	@Todo("gl")
	public static String glGetPerfMonitorCounterStringAMD(int group, int counter, int bufSize) {
		throw new UnsupportedOperationException();
	}
	public static void glSelectPerfMonitorCountersAMD(int monitor, boolean enable, int group, int counter) {
		try (org.lwjgl.system.MemoryStack __stack = org.lwjgl.system.MemoryStack.stackPush()) {
			java.nio.IntBuffer __v3 = __stack.ints(counter);
			org.lwjgl.opengl.AMDPerformanceMonitor.glSelectPerfMonitorCountersAMD(monitor, enable, group, __v3);
		}
	}
	public static int glGetPerfMonitorCounterDataAMD(int monitor, int pname) {
		try (org.lwjgl.system.MemoryStack __stack = org.lwjgl.system.MemoryStack.stackPush()) {
			java.nio.IntBuffer __t2 = __stack.mallocInt(4);
			org.lwjgl.opengl.AMDPerformanceMonitor.glGetPerfMonitorCounterDataAMD(monitor, pname, __t2, (java.nio.IntBuffer)null);
			return __t2.get(0);
		}
	}
}
