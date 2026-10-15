package com.koyomiji.lwjgl2w3.generated.org.lwjgl.opengl;

import java.nio.LongBuffer;

public final class ARBBufferStorage {
	public static void glBufferStorage(int target, LongBuffer data, int flags) {
		org.lwjgl.opengl.ARBBufferStorage.nglBufferStorage(target, ((long)org.lwjgl.system.Checks.remainingSafe(data) << 3), org.lwjgl.system.MemoryUtil.memAddressSafe(data), flags);
	}
	public static void glNamedBufferStorageEXT(int buffer, LongBuffer data, int flags) {
		org.lwjgl.opengl.ARBBufferStorage.nglNamedBufferStorageEXT(buffer, ((long)org.lwjgl.system.Checks.remainingSafe(data) << 3), org.lwjgl.system.MemoryUtil.memAddressSafe(data), flags);
	}
}
