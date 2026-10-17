package com.koyomiji.dualwjgl.generated.org.lwjgl.opengl;

import java.nio.LongBuffer;

public final class ARBBufferStorage {
	public static void glBufferStorage(int target, LongBuffer data, int flags) {
		org.lwjgl.opengl.ARBBufferStorage.glBufferStorage(target, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(data), (org.lwjgl.system.Checks.remainingSafe(data) << 3)), flags);
	}
	public static void glNamedBufferStorageEXT(int buffer, LongBuffer data, int flags) {
		org.lwjgl.opengl.ARBBufferStorage.glNamedBufferStorageEXT(buffer, org.lwjgl.system.MemoryUtil.memByteBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(data), (org.lwjgl.system.Checks.remainingSafe(data) << 3)), flags);
	}
}
