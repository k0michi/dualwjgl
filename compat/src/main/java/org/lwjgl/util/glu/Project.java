package org.lwjgl.util.glu;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public class Project extends Util {
	public Project() {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static void gluPerspective(float fovy, float aspect, float zNear, float zFar) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static void gluLookAt(float eyex, float eyey, float eyez, float centerx, float centery, float centerz, float upx, float upy, float upz) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static boolean gluProject(float objx, float objy, float objz, FloatBuffer modelMatrix, FloatBuffer projMatrix, IntBuffer viewport, FloatBuffer win_pos) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static boolean gluUnProject(float winx, float winy, float winz, FloatBuffer modelMatrix, FloatBuffer projMatrix, IntBuffer viewport, FloatBuffer obj_pos) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static void gluPickMatrix(float x, float y, float deltaX, float deltaY, IntBuffer viewport) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}
}
