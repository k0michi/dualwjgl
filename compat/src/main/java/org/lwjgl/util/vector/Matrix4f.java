package org.lwjgl.util.vector;

import java.io.Serializable;
import java.nio.FloatBuffer;

public class Matrix4f extends Matrix implements Serializable {
	public float m00;
	public float m01;
	public float m02;
	public float m03;
	public float m10;
	public float m11;
	public float m12;
	public float m13;
	public float m20;
	public float m21;
	public float m22;
	public float m23;
	public float m30;
	public float m31;
	public float m32;
	public float m33;

	public Matrix4f() {
		// TODO(port)
		throw new UnsupportedOperationException();
	}
	public Matrix4f(Matrix4f src) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public String toString() {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public Matrix setIdentity() {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static Matrix4f setIdentity(Matrix4f m) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public Matrix setZero() {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static Matrix4f setZero(Matrix4f m) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public Matrix4f load(Matrix4f src) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static Matrix4f load(Matrix4f src, Matrix4f dest) {
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

	public Matrix store3f(FloatBuffer buf) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static Matrix4f add(Matrix4f left, Matrix4f right, Matrix4f dest) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static Matrix4f sub(Matrix4f left, Matrix4f right, Matrix4f dest) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static Matrix4f mul(Matrix4f left, Matrix4f right, Matrix4f dest) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static Vector4f transform(Matrix4f left, Vector4f right, Vector4f dest) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public Matrix transpose() {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public Matrix4f translate(Vector2f vec) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public Matrix4f translate(Vector3f vec) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public Matrix4f scale(Vector3f vec) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static Matrix4f scale(Vector3f vec, Matrix4f src, Matrix4f dest) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public Matrix4f rotate(float angle, Vector3f axis) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public Matrix4f rotate(float angle, Vector3f axis, Matrix4f dest) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static Matrix4f rotate(float angle, Vector3f axis, Matrix4f src, Matrix4f dest) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public Matrix4f translate(Vector3f vec, Matrix4f dest) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static Matrix4f translate(Vector3f vec, Matrix4f src, Matrix4f dest) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public Matrix4f translate(Vector2f vec, Matrix4f dest) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static Matrix4f translate(Vector2f vec, Matrix4f src, Matrix4f dest) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public Matrix4f transpose(Matrix4f dest) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static Matrix4f transpose(Matrix4f src, Matrix4f dest) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public float determinant() {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public Matrix invert() {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static Matrix4f invert(Matrix4f src, Matrix4f dest) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public Matrix negate() {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public Matrix4f negate(Matrix4f dest) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static Matrix4f negate(Matrix4f src, Matrix4f dest) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}
}
