package org.lwjgl.util.mapped;

import java.nio.ByteBuffer;

public abstract class MappedObject {
	public long baseAddress;
	public long viewAddress;
	public static int SIZEOF;
	public int view;

	protected MappedObject() {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	protected final long getViewAddress(int view) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public final void setViewAddress(long address) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public final int getAlign() {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public final int getSizeof() {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public final int capacity() {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static <T extends MappedObject> T map(ByteBuffer bb) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static <T extends MappedObject> T map(long address, int capacity) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static <T extends MappedObject> T malloc(int elementCount) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public final <T extends MappedObject> T dup() {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public final <T extends MappedObject> T slice() {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public final void runViewConstructor() {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public final void next() {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public final <T extends MappedObject> void copyTo(T target) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public final <T extends MappedObject> void copyRange(T target, int instances) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static <T extends MappedObject> Iterable<T> foreach(T mapped) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static <T extends MappedObject> Iterable<T> foreach(T mapped, int elementCount) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public final <T extends MappedObject> T[] asArray() {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public final ByteBuffer backingByteBuffer() {
		// TODO(port)
		throw new UnsupportedOperationException();
	}
}
