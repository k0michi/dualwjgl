package org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Generated;
import java.nio.FloatBuffer;

@Generated
public final class EXTGpuProgramParameters {
	private EXTGpuProgramParameters() {
	}

	public static void glProgramEnvParameters4EXT(int target, int index, int count, FloatBuffer params) {
		org.lwjgl.opengl.EXTGPUProgramParameters.glProgramEnvParameters4fvEXT(target, index, org.lwjgl.system.MemoryUtil.memFloatBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(params), (count << 2)));
	}

	public static void glProgramLocalParameters4EXT(int target, int index, int count, FloatBuffer params) {
		org.lwjgl.opengl.EXTGPUProgramParameters.glProgramLocalParameters4fvEXT(target, index, org.lwjgl.system.MemoryUtil.memFloatBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(params), (count << 2)));
	}
}
