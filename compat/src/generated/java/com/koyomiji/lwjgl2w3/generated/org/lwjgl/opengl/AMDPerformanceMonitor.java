package com.koyomiji.lwjgl2w3.generated.org.lwjgl.opengl;

public final class AMDPerformanceMonitor {
	public static String glGetPerfMonitorGroupStringAMD(int group, int bufSize) {
		try (org.lwjgl.system.MemoryStack __stack = org.lwjgl.system.MemoryStack.stackPush()) {
			java.nio.IntBuffer __groupString_length = __stack.mallocInt(1);
			java.nio.ByteBuffer __groupString = org.lwjgl.system.MemoryUtil.memAlloc(Math.max(bufSize, 1));
			try {
				org.lwjgl.opengl.AMDPerformanceMonitor.nglGetPerfMonitorGroupStringAMD(group, bufSize, org.lwjgl.system.MemoryUtil.memAddress(__groupString_length), org.lwjgl.system.MemoryUtil.memAddress(__groupString));
				return org.lwjgl.system.MemoryUtil.memASCII(__groupString, __groupString_length.get(0));
			} finally {
				org.lwjgl.system.MemoryUtil.memFree(__groupString);
			}
		}
	}
	public static String glGetPerfMonitorCounterStringAMD(int group, int counter, int bufSize) {
		try (org.lwjgl.system.MemoryStack __stack = org.lwjgl.system.MemoryStack.stackPush()) {
			java.nio.IntBuffer __counterString_length = __stack.mallocInt(1);
			java.nio.ByteBuffer __counterString = org.lwjgl.system.MemoryUtil.memAlloc(Math.max(bufSize, 1));
			try {
				org.lwjgl.opengl.AMDPerformanceMonitor.nglGetPerfMonitorCounterStringAMD(group, counter, bufSize, org.lwjgl.system.MemoryUtil.memAddress(__counterString_length), org.lwjgl.system.MemoryUtil.memAddress(__counterString));
				return org.lwjgl.system.MemoryUtil.memASCII(__counterString, __counterString_length.get(0));
			} finally {
				org.lwjgl.system.MemoryUtil.memFree(__counterString);
			}
		}
	}
	public static void glSelectPerfMonitorCountersAMD(int monitor, boolean enable, int group, int counter) {
		try (org.lwjgl.system.MemoryStack __stack = org.lwjgl.system.MemoryStack.stackPush()) {
			org.lwjgl.opengl.AMDPerformanceMonitor.nglSelectPerfMonitorCountersAMD(monitor, enable, group, 1, org.lwjgl.system.MemoryUtil.memAddress(__stack.ints(counter)));
		}
	}
	public static int glGetPerfMonitorCounterDataAMD(int monitor, int pname) {
		try (org.lwjgl.system.MemoryStack __stack = org.lwjgl.system.MemoryStack.stackPush()) {
			java.nio.IntBuffer __data = __stack.mallocInt(2);
			org.lwjgl.opengl.AMDPerformanceMonitor.nglGetPerfMonitorCounterDataAMD(monitor, pname, 4, org.lwjgl.system.MemoryUtil.memAddress(__data), 0);
			return __data.get(0);
		}
	}
}
