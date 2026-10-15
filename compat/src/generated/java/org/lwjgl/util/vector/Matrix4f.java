package org.lwjgl.util.vector;

import com.koyomiji.lwjgl2w3.inject.Generated;
import com.koyomiji.lwjgl2w3.inject.Todo;
import java.io.Serializable;
import java.nio.FloatBuffer;

@Generated
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

	@Todo("port")
	public Matrix4f() {
		throw new UnsupportedOperationException();
	}
	@Todo("port")
	public Matrix4f(Matrix4f src) {
		throw new UnsupportedOperationException();
	}

	@Todo("port")
	public String toString() {
		throw new UnsupportedOperationException();
	}

	@Todo("port")
	public Matrix setIdentity() {
		throw new UnsupportedOperationException();
	}

	@Todo("port")
	public static Matrix4f setIdentity(Matrix4f m) {
		throw new UnsupportedOperationException();
	}

	@Todo("port")
	public Matrix setZero() {
		throw new UnsupportedOperationException();
	}

	@Todo("port")
	public static Matrix4f setZero(Matrix4f m) {
		throw new UnsupportedOperationException();
	}

	@Todo("port")
	public Matrix4f load(Matrix4f src) {
		throw new UnsupportedOperationException();
	}

	@Todo("port")
	public static Matrix4f load(Matrix4f src, Matrix4f dest) {
		throw new UnsupportedOperationException();
	}

	@Todo("port")
	public Matrix load(FloatBuffer buf) {
		throw new UnsupportedOperationException();
	}

	@Todo("port")
	public Matrix loadTranspose(FloatBuffer buf) {
		throw new UnsupportedOperationException();
	}

	@Todo("port")
	public Matrix store(FloatBuffer buf) {
		throw new UnsupportedOperationException();
	}

	@Todo("port")
	public Matrix storeTranspose(FloatBuffer buf) {
		throw new UnsupportedOperationException();
	}

	@Todo("port")
	public Matrix store3f(FloatBuffer buf) {
		throw new UnsupportedOperationException();
	}

	@Todo("port")
	public static Matrix4f add(Matrix4f left, Matrix4f right, Matrix4f dest) {
		throw new UnsupportedOperationException();
	}

	@Todo("port")
	public static Matrix4f sub(Matrix4f left, Matrix4f right, Matrix4f dest) {
		throw new UnsupportedOperationException();
	}

	@Todo("port")
	public static Matrix4f mul(Matrix4f left, Matrix4f right, Matrix4f dest) {
		throw new UnsupportedOperationException();
	}

	@Todo("port")
	public static Vector4f transform(Matrix4f left, Vector4f right, Vector4f dest) {
		throw new UnsupportedOperationException();
	}

	@Todo("port")
	public Matrix transpose() {
		throw new UnsupportedOperationException();
	}

	@Todo("port")
	public Matrix4f translate(Vector2f vec) {
		throw new UnsupportedOperationException();
	}

	@Todo("port")
	public Matrix4f translate(Vector3f vec) {
		throw new UnsupportedOperationException();
	}

	@Todo("port")
	public Matrix4f scale(Vector3f vec) {
		throw new UnsupportedOperationException();
	}

	@Todo("port")
	public static Matrix4f scale(Vector3f vec, Matrix4f src, Matrix4f dest) {
		throw new UnsupportedOperationException();
	}

	@Todo("port")
	public Matrix4f rotate(float angle, Vector3f axis) {
		throw new UnsupportedOperationException();
	}

	@Todo("port")
	public Matrix4f rotate(float angle, Vector3f axis, Matrix4f dest) {
		throw new UnsupportedOperationException();
	}

	@Todo("port")
	public static Matrix4f rotate(float angle, Vector3f axis, Matrix4f src, Matrix4f dest) {
		throw new UnsupportedOperationException();
	}

	@Todo("port")
	public Matrix4f translate(Vector3f vec, Matrix4f dest) {
		throw new UnsupportedOperationException();
	}

	@Todo("port")
	public static Matrix4f translate(Vector3f vec, Matrix4f src, Matrix4f dest) {
		throw new UnsupportedOperationException();
	}

	@Todo("port")
	public Matrix4f translate(Vector2f vec, Matrix4f dest) {
		throw new UnsupportedOperationException();
	}

	@Todo("port")
	public static Matrix4f translate(Vector2f vec, Matrix4f src, Matrix4f dest) {
		throw new UnsupportedOperationException();
	}

	@Todo("port")
	public Matrix4f transpose(Matrix4f dest) {
		throw new UnsupportedOperationException();
	}

	@Todo("port")
	public static Matrix4f transpose(Matrix4f src, Matrix4f dest) {
		throw new UnsupportedOperationException();
	}

	@Todo("port")
	public float determinant() {
		throw new UnsupportedOperationException();
	}

	@Todo("port")
	public Matrix invert() {
		throw new UnsupportedOperationException();
	}

	@Todo("port")
	public static Matrix4f invert(Matrix4f src, Matrix4f dest) {
		throw new UnsupportedOperationException();
	}

	@Todo("port")
	public Matrix negate() {
		throw new UnsupportedOperationException();
	}

	@Todo("port")
	public Matrix4f negate(Matrix4f dest) {
		throw new UnsupportedOperationException();
	}

	@Todo("port")
	public static Matrix4f negate(Matrix4f src, Matrix4f dest) {
		throw new UnsupportedOperationException();
	}
}
