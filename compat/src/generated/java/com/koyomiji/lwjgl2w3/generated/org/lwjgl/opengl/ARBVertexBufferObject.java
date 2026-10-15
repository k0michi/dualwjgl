package com.koyomiji.lwjgl2w3.generated.org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Hidden;
import com.koyomiji.lwjgl2w3.inject.Todo;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public final class ARBVertexBufferObject {
	public static void glGetBufferParameterARB(int target, int pname, IntBuffer params) {
		org.lwjgl.opengl.ARBVertexBufferObject.glGetBufferParameterivARB(target, pname, params);
	}
	@Deprecated
	public static int glGetBufferParameterARB(int target, int pname) {
		return org.lwjgl.opengl.ARBVertexBufferObject.glGetBufferParameteriARB(target, pname);
	}
	@Hidden
	@Todo("gl")
	public static ByteBuffer glGetBufferPointerARB(int target, int pname) {
		throw new UnsupportedOperationException();
	}
}
