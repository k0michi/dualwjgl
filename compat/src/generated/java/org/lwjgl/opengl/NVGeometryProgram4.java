package org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Generated;

@Generated
public final class NVGeometryProgram4 {
	public static final int GL_GEOMETRY_PROGRAM_NV = 0x8C26;
	public static final int GL_MAX_PROGRAM_OUTPUT_VERTICES_NV = 0x8C27;
	public static final int GL_MAX_PROGRAM_TOTAL_OUTPUT_COMPONENTS_NV = 0x8C28;

	private NVGeometryProgram4() {
	}

	public static void glProgramVertexLimitNV(int target, int limit) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glFramebufferTextureEXT(int target, int attachment, int texture, int level) {
		org.lwjgl.opengl.EXTGeometryShader4.glFramebufferTextureEXT(target, attachment, texture, level);
	}

	public static void glFramebufferTextureLayerEXT(int target, int attachment, int texture, int level, int layer) {
		org.lwjgl.opengl.EXTGeometryShader4.glFramebufferTextureLayerEXT(target, attachment, texture, level, layer);
	}

	public static void glFramebufferTextureFaceEXT(int target, int attachment, int texture, int level, int face) {
		org.lwjgl.opengl.EXTGeometryShader4.glFramebufferTextureFaceEXT(target, attachment, texture, level, face);
	}
}
