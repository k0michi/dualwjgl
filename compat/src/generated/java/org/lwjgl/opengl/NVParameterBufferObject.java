package org.lwjgl.opengl;

import com.koyomiji.dualwjgl.inject.Generated;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

@Generated
public final class NVParameterBufferObject {
	public static final int GL_MAX_PROGRAM_PARAMETER_BUFFER_BINDINGS_NV = 0x8DA0;
	public static final int GL_MAX_PROGRAM_PARAMETER_BUFFER_SIZE_NV = 0x8DA1;
	public static final int GL_VERTEX_PROGRAM_PARAMETER_BUFFER_NV = 0x8DA2;
	public static final int GL_GEOMETRY_PROGRAM_PARAMETER_BUFFER_NV = 0x8DA3;
	public static final int GL_FRAGMENT_PROGRAM_PARAMETER_BUFFER_NV = 0x8DA4;

	private NVParameterBufferObject() {
	}

	public static void glProgramBufferParametersNV(int target, int buffer, int index, FloatBuffer params) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glProgramBufferParametersINV(int target, int buffer, int index, IntBuffer params) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glProgramBufferParametersIuNV(int target, int buffer, int index, IntBuffer params) {
		throw new IllegalStateException("Function is not supported");
	}
}
