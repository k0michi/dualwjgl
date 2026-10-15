package com.koyomiji.lwjgl2w3.generated.org.lwjgl.opengl;

import java.nio.LongBuffer;

public final class ARBTimerQuery {
	public static void glGetQueryObject(int id, int pname, LongBuffer params) {
		org.lwjgl.opengl.ARBTimerQuery.glGetQueryObjecti64v(id, pname, params);
	}
	public static void glGetQueryObjectu(int id, int pname, LongBuffer params) {
		org.lwjgl.opengl.ARBTimerQuery.glGetQueryObjectui64v(id, pname, params);
	}
}
