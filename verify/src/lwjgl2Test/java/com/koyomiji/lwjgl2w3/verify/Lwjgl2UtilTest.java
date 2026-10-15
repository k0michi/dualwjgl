package com.koyomiji.lwjgl2w3.verify;

import org.junit.jupiter.api.Test;
import org.lwjgl.util.Color;
import org.lwjgl.util.ReadableColor;
import org.lwjgl.util.Rectangle;
import org.lwjgl.util.glu.GLU;
import org.lwjgl.util.glu.GLUtessellator;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Quaternion;
import org.lwjgl.util.vector.Vector3f;
import org.lwjgl.util.vector.Vector4f;

import static org.junit.jupiter.api.Assertions.*;

class Lwjgl2UtilTest {

	@Test
	void vector() {
		Vector3f z = Vector3f.cross(new Vector3f(1, 0, 0), new Vector3f(0, 1, 0), null);
		assertEquals(new Vector3f(0, 0, 1), z);
		assertEquals(5f, new Vector3f(3, 4, 0).length(), 1e-6f);

		Matrix4f m = new Matrix4f();
		m.translate(new Vector3f(1, 2, 3));
		Vector4f p = Matrix4f.transform(m, new Vector4f(0, 0, 0, 1), null);
		assertEquals(new Vector4f(1, 2, 3, 1), p);
		Matrix4f inv = Matrix4f.invert(m, null);
		assertEquals(new Vector4f(0, 0, 0, 1), Matrix4f.transform(inv, p, null));

		Quaternion q = new Quaternion();
		assertEquals(1f, q.length(), 1e-6f);
	}

	@Test
	void geometryAndColor() {
		Rectangle r = new Rectangle(0, 0, 10, 10);
		assertTrue(r.contains(5, 5));
		assertTrue(r.intersects(new Rectangle(8, 8, 4, 4)));
		assertFalse(r.intersects(new Rectangle(20, 20, 1, 1)));
		assertEquals(255, new Color(ReadableColor.RED).getRed());
	}

	@Test
	void glu() {
		GLUtessellator tess = GLU.gluNewTess();
		assertNotNull(tess);
		tess.gluDeleteTess();
	}

}
