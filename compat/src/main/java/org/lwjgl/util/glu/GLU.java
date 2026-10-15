package org.lwjgl.util.glu;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public class GLU {
	public static final int GLU_INVALID_ENUM = 0x18A24;
	public static final int GLU_INVALID_VALUE = 0x18A25;
	public static final int GLU_OUT_OF_MEMORY = 0x18A26;
	public static final int GLU_INCOMPATIBLE_GL_VERSION = 0x18A27;
	public static final int GLU_VERSION = 0x189C0;
	public static final int GLU_EXTENSIONS = 0x189C1;
	public static final boolean GLU_TRUE = true;
	public static final boolean GLU_FALSE = false;
	public static final int GLU_SMOOTH = 0x186A0;
	public static final int GLU_FLAT = 0x186A1;
	public static final int GLU_NONE = 0x186A2;
	public static final int GLU_POINT = 0x186AA;
	public static final int GLU_LINE = 0x186AB;
	public static final int GLU_FILL = 0x186AC;
	public static final int GLU_SILHOUETTE = 0x186AD;
	public static final int GLU_OUTSIDE = 0x186B4;
	public static final int GLU_INSIDE = 0x186B5;
	public static final double GLU_TESS_MAX_COORD = 1.0E150d;
	public static final double TESS_MAX_COORD = 1.0E150d;
	public static final int GLU_TESS_WINDING_RULE = 0x1872C;
	public static final int GLU_TESS_BOUNDARY_ONLY = 0x1872D;
	public static final int GLU_TESS_TOLERANCE = 0x1872E;
	public static final int GLU_TESS_WINDING_ODD = 0x18722;
	public static final int GLU_TESS_WINDING_NONZERO = 0x18723;
	public static final int GLU_TESS_WINDING_POSITIVE = 0x18724;
	public static final int GLU_TESS_WINDING_NEGATIVE = 0x18725;
	public static final int GLU_TESS_WINDING_ABS_GEQ_TWO = 0x18726;
	public static final int GLU_TESS_BEGIN = 0x18704;
	public static final int GLU_TESS_VERTEX = 0x18705;
	public static final int GLU_TESS_END = 0x18706;
	public static final int GLU_TESS_ERROR = 0x18707;
	public static final int GLU_TESS_EDGE_FLAG = 0x18708;
	public static final int GLU_TESS_COMBINE = 0x18709;
	public static final int GLU_TESS_BEGIN_DATA = 0x1870A;
	public static final int GLU_TESS_VERTEX_DATA = 0x1870B;
	public static final int GLU_TESS_END_DATA = 0x1870C;
	public static final int GLU_TESS_ERROR_DATA = 0x1870D;
	public static final int GLU_TESS_EDGE_FLAG_DATA = 0x1870E;
	public static final int GLU_TESS_COMBINE_DATA = 0x1870F;
	public static final int GLU_TESS_ERROR1 = 0x18737;
	public static final int GLU_TESS_ERROR2 = 0x18738;
	public static final int GLU_TESS_ERROR3 = 0x18739;
	public static final int GLU_TESS_ERROR4 = 0x1873A;
	public static final int GLU_TESS_ERROR5 = 0x1873B;
	public static final int GLU_TESS_ERROR6 = 0x1873C;
	public static final int GLU_TESS_ERROR7 = 0x1873D;
	public static final int GLU_TESS_ERROR8 = 0x1873E;
	public static final int GLU_TESS_MISSING_BEGIN_POLYGON = 0x18737;
	public static final int GLU_TESS_MISSING_BEGIN_CONTOUR = 0x18738;
	public static final int GLU_TESS_MISSING_END_POLYGON = 0x18739;
	public static final int GLU_TESS_MISSING_END_CONTOUR = 0x1873A;
	public static final int GLU_TESS_COORD_TOO_LARGE = 0x1873B;
	public static final int GLU_TESS_NEED_COMBINE_CALLBACK = 0x1873C;
	public static final int GLU_AUTO_LOAD_MATRIX = 0x18768;
	public static final int GLU_CULLING = 0x18769;
	public static final int GLU_SAMPLING_TOLERANCE = 0x1876B;
	public static final int GLU_DISPLAY_MODE = 0x1876C;
	public static final int GLU_PARAMETRIC_TOLERANCE = 0x1876A;
	public static final int GLU_SAMPLING_METHOD = 0x1876D;
	public static final int GLU_U_STEP = 0x1876E;
	public static final int GLU_V_STEP = 0x1876F;
	public static final int GLU_PATH_LENGTH = 0x18777;
	public static final int GLU_PARAMETRIC_ERROR = 0x18778;
	public static final int GLU_DOMAIN_DISTANCE = 0x18779;
	public static final int GLU_MAP1_TRIM_2 = 0x18772;
	public static final int GLU_MAP1_TRIM_3 = 0x18773;
	public static final int GLU_OUTLINE_POLYGON = 0x18790;
	public static final int GLU_OUTLINE_PATCH = 0x18791;
	public static final int GLU_NURBS_ERROR1 = 0x1879B;
	public static final int GLU_NURBS_ERROR2 = 0x1879C;
	public static final int GLU_NURBS_ERROR3 = 0x1879D;
	public static final int GLU_NURBS_ERROR4 = 0x1879E;
	public static final int GLU_NURBS_ERROR5 = 0x1879F;
	public static final int GLU_NURBS_ERROR6 = 0x187A0;
	public static final int GLU_NURBS_ERROR7 = 0x187A1;
	public static final int GLU_NURBS_ERROR8 = 0x187A2;
	public static final int GLU_NURBS_ERROR9 = 0x187A3;
	public static final int GLU_NURBS_ERROR10 = 0x187A4;
	public static final int GLU_NURBS_ERROR11 = 0x187A5;
	public static final int GLU_NURBS_ERROR12 = 0x187A6;
	public static final int GLU_NURBS_ERROR13 = 0x187A7;
	public static final int GLU_NURBS_ERROR14 = 0x187A8;
	public static final int GLU_NURBS_ERROR15 = 0x187A9;
	public static final int GLU_NURBS_ERROR16 = 0x187AA;
	public static final int GLU_NURBS_ERROR17 = 0x187AB;
	public static final int GLU_NURBS_ERROR18 = 0x187AC;
	public static final int GLU_NURBS_ERROR19 = 0x187AD;
	public static final int GLU_NURBS_ERROR20 = 0x187AE;
	public static final int GLU_NURBS_ERROR21 = 0x187AF;
	public static final int GLU_NURBS_ERROR22 = 0x187B0;
	public static final int GLU_NURBS_ERROR23 = 0x187B1;
	public static final int GLU_NURBS_ERROR24 = 0x187B2;
	public static final int GLU_NURBS_ERROR25 = 0x187B3;
	public static final int GLU_NURBS_ERROR26 = 0x187B4;
	public static final int GLU_NURBS_ERROR27 = 0x187B5;
	public static final int GLU_NURBS_ERROR28 = 0x187B6;
	public static final int GLU_NURBS_ERROR29 = 0x187B7;
	public static final int GLU_NURBS_ERROR30 = 0x187B8;
	public static final int GLU_NURBS_ERROR31 = 0x187B9;
	public static final int GLU_NURBS_ERROR32 = 0x187BA;
	public static final int GLU_NURBS_ERROR33 = 0x187BB;
	public static final int GLU_NURBS_ERROR34 = 0x187BC;
	public static final int GLU_NURBS_ERROR35 = 0x187BD;
	public static final int GLU_NURBS_ERROR36 = 0x187BE;
	public static final int GLU_NURBS_ERROR37 = 0x187BF;
	public static final int GLU_CW = 0x18718;
	public static final int GLU_CCW = 0x18719;
	public static final int GLU_INTERIOR = 0x1871A;
	public static final int GLU_EXTERIOR = 0x1871B;
	public static final int GLU_UNKNOWN = 0x1871C;
	public static final int GLU_BEGIN = 0x18704;
	public static final int GLU_VERTEX = 0x18705;
	public static final int GLU_END = 0x18706;
	public static final int GLU_ERROR = 0x18707;
	public static final int GLU_EDGE_FLAG = 0x18708;

	public GLU() {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static void gluLookAt(float eyex, float eyey, float eyez, float centerx, float centery, float centerz, float upx, float upy, float upz) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static void gluOrtho2D(float left, float right, float bottom, float top) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static void gluPerspective(float fovy, float aspect, float zNear, float zFar) {
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

	public static void gluPickMatrix(float x, float y, float width, float height, IntBuffer viewport) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static String gluGetString(int name) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static boolean gluCheckExtension(String extName, String extString) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static int gluBuild2DMipmaps(int target, int components, int width, int height, int format, int type, ByteBuffer data) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static int gluScaleImage(int format, int widthIn, int heightIn, int typeIn, ByteBuffer dataIn, int widthOut, int heightOut, int typeOut, ByteBuffer dataOut) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static String gluErrorString(int error_code) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static GLUtessellator gluNewTess() {
		// TODO(port)
		throw new UnsupportedOperationException();
	}
}
