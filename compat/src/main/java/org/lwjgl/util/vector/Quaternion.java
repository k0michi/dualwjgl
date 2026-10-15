package org.lwjgl.util.vector;

import java.nio.FloatBuffer;

public class Quaternion extends Vector implements ReadableVector4f {
	public float x;
	public float y;
	public float z;
	public float w;

	public Quaternion() {
		// TODO(port)
		throw new UnsupportedOperationException();
	}
	public Quaternion(ReadableVector4f src) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}
	public Quaternion(float x, float y, float z, float w) {
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

	public void set(float x, float y, float z, float w) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public Quaternion set(ReadableVector4f src) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public Quaternion setIdentity() {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static Quaternion setIdentity(Quaternion q) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public float lengthSquared() {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static Quaternion normalise(Quaternion src, Quaternion dest) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public Quaternion normalise(Quaternion dest) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static float dot(Quaternion left, Quaternion right) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public Quaternion negate(Quaternion dest) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static Quaternion negate(Quaternion src, Quaternion dest) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public Vector negate() {
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

	public static Quaternion scale(float scale, Quaternion src, Quaternion dest) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public Vector store(FloatBuffer buf) {
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

	public void setW(float w) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public float getW() {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public String toString() {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static Quaternion mul(Quaternion left, Quaternion right, Quaternion dest) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static Quaternion mulInverse(Quaternion left, Quaternion right, Quaternion dest) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public final void setFromAxisAngle(Vector4f a1) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public final Quaternion setFromMatrix(Matrix4f m) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static Quaternion setFromMatrix(Matrix4f m, Quaternion q) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public final Quaternion setFromMatrix(Matrix3f m) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static Quaternion setFromMatrix(Matrix3f m, Quaternion q) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}
}
