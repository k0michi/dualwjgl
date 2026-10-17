package com.koyomiji.lwjgl2w3.generated.org.lwjgl.opengl;

import java.nio.ByteBuffer;

public final class EXTTransformFeedback {
	public static void glTransformFeedbackVaryingsEXT(int program, int count, ByteBuffer varyings, int bufferMode) {
		org.lwjgl.opengl.EXTTransformFeedback.glTransformFeedbackVaryingsEXT(program, org.lwjgl.system.MemoryUtil.memPointerBufferSafe(org.lwjgl.system.MemoryUtil.memAddressSafe(varyings), count), bufferMode);
	}
}
