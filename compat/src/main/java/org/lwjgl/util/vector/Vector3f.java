package org.lwjgl.util.vector;

import java.io.Serializable;
import java.nio.FloatBuffer;

public class Vector3f extends Vector implements Serializable, ReadableVector3f, WritableVector3f {
	public float x;
	public float y;
	public float z;

	public Vector3f() {
		// TODO(port)
		throw new UnsupportedOperationException();
	}
	public Vector3f(ReadableVector3f src) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}
	public Vector3f(float x, float y, float z) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public void set(float x, float y) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public void set(float x, float y, float z) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public Vector3f set(ReadableVector3f src) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public float lengthSquared() {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public Vector3f translate(float x, float y, float z) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static Vector3f add(Vector3f left, Vector3f right, Vector3f dest) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static Vector3f sub(Vector3f left, Vector3f right, Vector3f dest) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static Vector3f cross(Vector3f left, Vector3f right, Vector3f dest) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public Vector negate() {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public Vector3f negate(Vector3f dest) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public Vector3f normalise(Vector3f dest) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static float dot(Vector3f left, Vector3f right) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static float angle(Vector3f a, Vector3f b) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public Vector load(FloatBuffer buf) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public Vector scale(float scale) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public Vector store(FloatBuffer buf) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public String toString() {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public final float getX() {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public final float getY() {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public final void setX(float x) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public final void setY(float y) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public void setZ(float z) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public float getZ() {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public boolean equals(Object obj) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}
}
