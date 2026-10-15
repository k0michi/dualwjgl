package org.lwjgl.util.vector;

import java.io.Serializable;
import java.nio.FloatBuffer;

public class Matrix2f extends Matrix implements Serializable {
	public float m00;
	public float m01;
	public float m10;
	public float m11;

	public Matrix2f() {
		// TODO(port)
		throw new UnsupportedOperationException();
	}
	public Matrix2f(Matrix2f src) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public Matrix2f load(Matrix2f src) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static Matrix2f load(Matrix2f src, Matrix2f dest) {
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

	public static Matrix2f add(Matrix2f left, Matrix2f right, Matrix2f dest) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static Matrix2f sub(Matrix2f left, Matrix2f right, Matrix2f dest) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static Matrix2f mul(Matrix2f left, Matrix2f right, Matrix2f dest) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static Vector2f transform(Matrix2f left, Vector2f right, Vector2f dest) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public Matrix transpose() {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public Matrix2f transpose(Matrix2f dest) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static Matrix2f transpose(Matrix2f src, Matrix2f dest) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public Matrix invert() {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static Matrix2f invert(Matrix2f src, Matrix2f dest) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public String toString() {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public Matrix negate() {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public Matrix2f negate(Matrix2f dest) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static Matrix2f negate(Matrix2f src, Matrix2f dest) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public Matrix setIdentity() {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static Matrix2f setIdentity(Matrix2f src) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public Matrix setZero() {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static Matrix2f setZero(Matrix2f src) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public float determinant() {
		// TODO(port)
		throw new UnsupportedOperationException();
	}
}
