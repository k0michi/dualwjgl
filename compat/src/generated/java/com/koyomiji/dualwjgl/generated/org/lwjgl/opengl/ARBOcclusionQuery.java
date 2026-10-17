package com.koyomiji.dualwjgl.generated.org.lwjgl.opengl;

import java.nio.IntBuffer;

public final class ARBOcclusionQuery {
	public static void glGetQueryARB(int target, int pname, IntBuffer params) {
		org.lwjgl.opengl.ARBOcclusionQuery.glGetQueryivARB(target, pname, params);
	}
	@Deprecated
	public static int glGetQueryARB(int target, int pname) {
		return org.lwjgl.opengl.ARBOcclusionQuery.glGetQueryiARB(target, pname);
	}
	public static void glGetQueryObjectARB(int id, int pname, IntBuffer params) {
		org.lwjgl.opengl.ARBOcclusionQuery.glGetQueryObjectivARB(id, pname, params);
	}
	public static void glGetQueryObjectuARB(int id, int pname, IntBuffer params) {
		org.lwjgl.opengl.ARBOcclusionQuery.glGetQueryObjectuivARB(id, pname, params);
	}
}
