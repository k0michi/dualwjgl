package org.lwjgl.util.glu.tessellation;

import org.lwjgl.util.glu.GLUtessellator;
import org.lwjgl.util.glu.GLUtessellatorCallback;

public class GLUtessellatorImpl implements GLUtessellator {
	public static final int TESS_MAX_CACHE = 100;

	public GLUtessellatorImpl() {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static GLUtessellator gluNewTess() {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public void gluDeleteTess() {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public void gluTessProperty(int which, double value) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public void gluGetTessProperty(int which, double[] value, int value_offset) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public void gluTessNormal(double x, double y, double z) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public void gluTessCallback(int which, GLUtessellatorCallback aCallback) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public void gluTessVertex(double[] coords, int coords_offset, Object vertexData) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public void gluTessBeginPolygon(Object data) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public void gluTessBeginContour() {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public void gluTessEndContour() {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public void gluTessEndPolygon() {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public void gluBeginPolygon() {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public void gluNextContour(int type) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public void gluEndPolygon() {
		// TODO(port)
		throw new UnsupportedOperationException();
	}
}
