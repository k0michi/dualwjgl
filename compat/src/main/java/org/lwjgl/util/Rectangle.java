package org.lwjgl.util;

import java.io.Serializable;

public final class Rectangle implements ReadableRectangle, WritableRectangle, Serializable {
	public Rectangle() {
		// TODO(port)
		throw new UnsupportedOperationException();
	}
	public Rectangle(int x, int y, int w, int h) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}
	public Rectangle(ReadablePoint p, ReadableDimension d) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}
	public Rectangle(ReadableRectangle r) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public void setLocation(int x, int y) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public void setLocation(ReadablePoint p) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public void setSize(int w, int h) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public void setSize(ReadableDimension d) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public void setBounds(int x, int y, int w, int h) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public void setBounds(ReadablePoint p, ReadableDimension d) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public void setBounds(ReadableRectangle r) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public void getBounds(WritableRectangle dest) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public void getLocation(WritablePoint dest) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public void getSize(WritableDimension dest) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public void translate(int x, int y) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public void translate(ReadablePoint point) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public void untranslate(ReadablePoint point) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public boolean contains(ReadablePoint p) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public boolean contains(int X, int Y) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public boolean contains(ReadableRectangle r) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public boolean contains(int X, int Y, int W, int H) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public boolean intersects(ReadableRectangle r) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public Rectangle intersection(ReadableRectangle r, Rectangle dest) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public WritableRectangle union(ReadableRectangle r, WritableRectangle dest) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public void add(int newx, int newy) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public void add(ReadablePoint pt) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public void add(ReadableRectangle r) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public void grow(int h, int v) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public boolean isEmpty() {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public boolean equals(Object obj) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public String toString() {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public int getHeight() {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public void setHeight(int height) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public int getWidth() {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public void setWidth(int width) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public int getX() {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public void setX(int x) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public int getY() {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public void setY(int y) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}
}
