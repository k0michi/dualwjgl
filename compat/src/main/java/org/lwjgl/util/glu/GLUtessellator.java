package org.lwjgl.util.glu;

public interface GLUtessellator {
	void gluDeleteTess();

	void gluTessProperty(int which, double value);

	void gluGetTessProperty(int which, double[] value, int value_offset);

	void gluTessNormal(double x, double y, double z);

	void gluTessCallback(int which, GLUtessellatorCallback aCallback);

	void gluTessVertex(double[] coords, int coords_offset, Object vertexData);

	void gluTessBeginPolygon(Object data);

	void gluTessBeginContour();

	void gluTessEndContour();

	void gluTessEndPolygon();

	void gluBeginPolygon();

	void gluNextContour(int type);

	void gluEndPolygon();
}
