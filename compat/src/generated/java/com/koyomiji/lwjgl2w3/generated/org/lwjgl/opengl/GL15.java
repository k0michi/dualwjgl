package com.koyomiji.lwjgl2w3.generated.org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Hidden;
import com.koyomiji.lwjgl2w3.inject.Todo;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public final class GL15 {
	public static void glGetBufferParameter(int target, int pname, IntBuffer params) {
		org.lwjgl.opengl.GL15.glGetBufferParameteriv(target, pname, params);
	}
	@Deprecated
	public static int glGetBufferParameter(int target, int pname) {
		return org.lwjgl.opengl.GL15.glGetBufferParameteri(target, pname);
	}
	@Hidden
	@Todo("gl")
	public static ByteBuffer glGetBufferPointer(int target, int pname) {
		throw new UnsupportedOperationException();
	}
	public static void glGetQuery(int target, int pname, IntBuffer params) {
		org.lwjgl.opengl.GL15.glGetQueryiv(target, pname, params);
	}
	@Deprecated
	public static int glGetQuery(int target, int pname) {
		return org.lwjgl.opengl.GL15.glGetQueryi(target, pname);
	}
	public static void glGetQueryObject(int id, int pname, IntBuffer params) {
		org.lwjgl.opengl.GL15.glGetQueryObjectiv(id, pname, params);
	}
	public static void glGetQueryObjectu(int id, int pname, IntBuffer params) {
		org.lwjgl.opengl.GL15.glGetQueryObjectuiv(id, pname, params);
	}
}
