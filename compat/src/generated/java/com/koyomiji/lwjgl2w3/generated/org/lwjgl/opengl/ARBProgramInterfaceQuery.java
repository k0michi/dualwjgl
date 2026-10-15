package com.koyomiji.lwjgl2w3.generated.org.lwjgl.opengl;

import java.nio.IntBuffer;

public final class ARBProgramInterfaceQuery {
	public static void glGetProgramInterface(int program, int programInterface, int pname, IntBuffer params) {
		org.lwjgl.opengl.ARBProgramInterfaceQuery.glGetProgramInterfaceiv(program, programInterface, pname, params);
	}
	public static void glGetProgramResource(int program, int programInterface, int index, IntBuffer props, IntBuffer length, IntBuffer params) {
		org.lwjgl.opengl.ARBProgramInterfaceQuery.glGetProgramResourceiv(program, programInterface, index, props, length, params);
	}
}
