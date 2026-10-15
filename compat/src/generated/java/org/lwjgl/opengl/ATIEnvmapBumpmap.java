package org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Generated;
import com.koyomiji.lwjgl2w3.inject.Todo;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

@Generated
public final class ATIEnvmapBumpmap {
	public static final int GL_BUMP_ROT_MATRIX_ATI = 0x8775;
	public static final int GL_BUMP_ROT_MATRIX_SIZE_ATI = 0x8776;
	public static final int GL_BUMP_NUM_TEX_UNITS_ATI = 0x8777;
	public static final int GL_BUMP_TEX_UNITS_ATI = 0x8778;
	public static final int GL_DUDV_ATI = 0x8779;
	public static final int GL_DU8DV8_ATI = 0x877A;
	public static final int GL_BUMP_ENVMAP_ATI = 0x877B;
	public static final int GL_BUMP_TARGET_ATI = 0x877C;

	private ATIEnvmapBumpmap() {
	}

	@Todo("gl")
	public static void glTexBumpParameterATI(int pname, FloatBuffer param) {
		throw new UnsupportedOperationException();
	}

	@Todo("gl")
	public static void glTexBumpParameterATI(int pname, IntBuffer param) {
		throw new UnsupportedOperationException();
	}

	@Todo("gl")
	public static void glGetTexBumpParameterATI(int pname, FloatBuffer param) {
		throw new UnsupportedOperationException();
	}

	@Todo("gl")
	public static void glGetTexBumpParameterATI(int pname, IntBuffer param) {
		throw new UnsupportedOperationException();
	}
}
