package org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Generated;
import java.nio.FloatBuffer;

@Generated
public final class EXTGpuProgramParameters {
	private EXTGpuProgramParameters() {
	}

	public static void glProgramEnvParameters4EXT(int target, int index, int count, FloatBuffer params) {
		org.lwjgl.opengl.EXTGPUProgramParameters.nglProgramEnvParameters4fvEXT(target, index, count, org.lwjgl.system.MemoryUtil.memAddressSafe(params));
	}

	public static void glProgramLocalParameters4EXT(int target, int index, int count, FloatBuffer params) {
		org.lwjgl.opengl.EXTGPUProgramParameters.nglProgramLocalParameters4fvEXT(target, index, count, org.lwjgl.system.MemoryUtil.memAddressSafe(params));
	}
}
