package org.lwjgl.util.glu;

import com.koyomiji.lwjgl2w3.inject.Generated;
import com.koyomiji.lwjgl2w3.inject.Todo;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

@Generated
public class Project extends Util {
	@Todo("port")
	public Project() {
		throw new UnsupportedOperationException();
	}

	@Todo("port")
	public static void gluPerspective(float fovy, float aspect, float zNear, float zFar) {
		throw new UnsupportedOperationException();
	}

	@Todo("port")
	public static void gluLookAt(float eyex, float eyey, float eyez, float centerx, float centery, float centerz, float upx, float upy, float upz) {
		throw new UnsupportedOperationException();
	}

	@Todo("port")
	public static boolean gluProject(float objx, float objy, float objz, FloatBuffer modelMatrix, FloatBuffer projMatrix, IntBuffer viewport, FloatBuffer win_pos) {
		throw new UnsupportedOperationException();
	}

	@Todo("port")
	public static boolean gluUnProject(float winx, float winy, float winz, FloatBuffer modelMatrix, FloatBuffer projMatrix, IntBuffer viewport, FloatBuffer obj_pos) {
		throw new UnsupportedOperationException();
	}

	@Todo("port")
	public static void gluPickMatrix(float x, float y, float deltaX, float deltaY, IntBuffer viewport) {
		throw new UnsupportedOperationException();
	}
}
