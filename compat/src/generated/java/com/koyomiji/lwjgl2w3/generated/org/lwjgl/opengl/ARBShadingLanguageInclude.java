package com.koyomiji.lwjgl2w3.generated.org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Todo;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public final class ARBShadingLanguageInclude {
	@Todo("gl")
	public static void glCompileShaderIncludeARB(int shader, int count, ByteBuffer path) {
		throw new UnsupportedOperationException();
	}
	@Todo("gl")
	public static void glCompileShaderIncludeARB(int shader, CharSequence[] path) {
		throw new UnsupportedOperationException();
	}
	public static void glGetNamedStringARB(ByteBuffer name, int pname, IntBuffer params) {
		org.lwjgl.opengl.ARBShadingLanguageInclude.glGetNamedStringivARB(name, pname, params);
	}
	public static void glGetNamedStringiARB(CharSequence name, int pname, IntBuffer params) {
		org.lwjgl.opengl.ARBShadingLanguageInclude.glGetNamedStringivARB(name, pname, params);
	}
}
