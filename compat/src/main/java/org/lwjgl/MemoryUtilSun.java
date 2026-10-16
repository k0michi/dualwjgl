package org.lwjgl;

import java.nio.Buffer;

/**
 * LWJGL 2's MemoryUtil (compiled unchanged) loads {@code MemoryUtilSun$AccessorUnsafe} by name to read buffer
 * addresses. LWJGL 2's own implementation reads {@code Buffer.address} with {@code sun.misc.Unsafe}, and its fallbacks
 * (reflection, LWJGL 2's natives) no longer work; this one asks LWJGL 3, which does the same.
 */
final class MemoryUtilSun {

	private MemoryUtilSun() {
	}

	static final class AccessorUnsafe implements MemoryUtil.Accessor {

		AccessorUnsafe() {
		}

		@Override
		public long getAddress(Buffer buffer) {
			return org.lwjgl.system.MemoryUtil.memAddress0(buffer);
		}

	}

}
