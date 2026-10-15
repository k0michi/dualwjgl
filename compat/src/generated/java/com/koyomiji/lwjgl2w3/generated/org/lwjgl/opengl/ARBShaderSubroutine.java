package com.koyomiji.lwjgl2w3.generated.org.lwjgl.opengl;

import java.nio.IntBuffer;

public final class ARBShaderSubroutine {
	public static void glGetActiveSubroutineUniform(int program, int shadertype, int index, int pname, IntBuffer values) {
		org.lwjgl.opengl.ARBShaderSubroutine.glGetActiveSubroutineUniformiv(program, shadertype, index, pname, values);
	}
	public static void glUniformSubroutinesu(int shadertype, IntBuffer indices) {
		org.lwjgl.opengl.ARBShaderSubroutine.glUniformSubroutinesuiv(shadertype, indices);
	}
	public static void glGetUniformSubroutineu(int shadertype, int location, IntBuffer params) {
		org.lwjgl.opengl.ARBShaderSubroutine.glGetUniformSubroutineuiv(shadertype, location, params);
	}
	public static void glGetProgramStage(int program, int shadertype, int pname, IntBuffer values) {
		org.lwjgl.opengl.ARBShaderSubroutine.glGetProgramStageiv(program, shadertype, pname, values);
	}
}
