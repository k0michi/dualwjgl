package com.koyomiji.lwjgl2w3.inject.org.lwjgl.opengl;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

// TODO(verify): hand-written; DelegationTest only compares generated members.
public final class AMDPerformanceMonitor {

	/** LWJGL 2 reads up to bufSize bytes and decodes the length written (ASCII, DEVIATION(text-encoding)). */
	public static String glGetPerfMonitorGroupStringAMD(int group, int bufSize) {
		ByteBuffer groupString = MemoryUtil.memAlloc(Math.max(bufSize, 1));
		try (MemoryStack stack = MemoryStack.stackPush()) {
			IntBuffer length = stack.mallocInt(1);
			groupString.limit(bufSize);
			org.lwjgl.opengl.AMDPerformanceMonitor.glGetPerfMonitorGroupStringAMD(group, length, groupString);
			return MemoryUtil.memASCII(groupString, length.get(0));
		} finally {
			MemoryUtil.memFree(groupString);
		}
	}

	public static String glGetPerfMonitorCounterStringAMD(int group, int counter, int bufSize) {
		ByteBuffer counterString = MemoryUtil.memAlloc(Math.max(bufSize, 1));
		try (MemoryStack stack = MemoryStack.stackPush()) {
			IntBuffer length = stack.mallocInt(1);
			counterString.limit(bufSize);
			org.lwjgl.opengl.AMDPerformanceMonitor.glGetPerfMonitorCounterStringAMD(group, counter, length, counterString);
			return MemoryUtil.memASCII(counterString, length.get(0));
		} finally {
			MemoryUtil.memFree(counterString);
		}
	}
}
