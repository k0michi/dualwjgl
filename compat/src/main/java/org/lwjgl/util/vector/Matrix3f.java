package org.lwjgl.util.vector;

import java.io.Serializable;
import java.nio.FloatBuffer;

public class Matrix3f extends Matrix implements Serializable {
	public float m00;
	public float m01;
	public float m02;
	public float m10;
	public float m11;
	public float m12;
	public float m20;
	public float m21;
	public float m22;

	public Matrix3f() {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public Matrix3f load(Matrix3f src) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static Matrix3f load(Matrix3f src, Matrix3f dest) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public Matrix load(FloatBuffer buf) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public Matrix loadTranspose(FloatBuffer buf) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public Matrix store(FloatBuffer buf) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public Matrix storeTranspose(FloatBuffer buf) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static Matrix3f add(Matrix3f left, Matrix3f right, Matrix3f dest) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static Matrix3f sub(Matrix3f left, Matrix3f right, Matrix3f dest) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static Matrix3f mul(Matrix3f left, Matrix3f right, Matrix3f dest) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static Vector3f transform(Matrix3f left, Vector3f right, Vector3f dest) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public Matrix transpose() {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public Matrix3f transpose(Matrix3f dest) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static Matrix3f transpose(Matrix3f src, Matrix3f dest) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public float determinant() {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public String toString() {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public Matrix invert() {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static Matrix3f invert(Matrix3f src, Matrix3f dest) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public Matrix negate() {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public Matrix3f negate(Matrix3f dest) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static Matrix3f negate(Matrix3f src, Matrix3f dest) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public Matrix setIdentity() {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static Matrix3f setIdentity(Matrix3f m) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public Matrix setZero() {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static Matrix3f setZero(Matrix3f m) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}
}
