package com.koyomiji.lwjgl2w3.generated.org.lwjgl.opengl;

import java.nio.ByteBuffer;

public final class EXTTransformFeedback {
	public static void glTransformFeedbackVaryingsEXT(int program, int count, ByteBuffer varyings, int bufferMode) {
		org.lwjgl.opengl.EXTTransformFeedback.nglTransformFeedbackVaryingsEXT(program, count, org.lwjgl.system.MemoryUtil.memAddressSafe(varyings), bufferMode);
	}
}
