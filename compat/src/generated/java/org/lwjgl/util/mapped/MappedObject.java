package org.lwjgl.util.mapped;

import com.koyomiji.lwjgl2w3.inject.Generated;
import com.koyomiji.lwjgl2w3.inject.Todo;
import java.nio.ByteBuffer;

@Generated
public abstract class MappedObject {
	public long baseAddress;
	public long viewAddress;
	public static int SIZEOF;
	public int view;

	@Todo("port")
	protected MappedObject() {
		throw new UnsupportedOperationException();
	}

	@Todo("port")
	protected final long getViewAddress(int view) {
		throw new UnsupportedOperationException();
	}

	@Todo("port")
	public final void setViewAddress(long address) {
		throw new UnsupportedOperationException();
	}

	@Todo("port")
	public final int getAlign() {
		throw new UnsupportedOperationException();
	}

	@Todo("port")
	public final int getSizeof() {
		throw new UnsupportedOperationException();
	}

	@Todo("port")
	public final int capacity() {
		throw new UnsupportedOperationException();
	}

	@Todo("port")
	public static <T extends MappedObject> T map(ByteBuffer bb) {
		throw new UnsupportedOperationException();
	}

	@Todo("port")
	public static <T extends MappedObject> T map(long address, int capacity) {
		throw new UnsupportedOperationException();
	}

	@Todo("port")
	public static <T extends MappedObject> T malloc(int elementCount) {
		throw new UnsupportedOperationException();
	}

	@Todo("port")
	public final <T extends MappedObject> T dup() {
		throw new UnsupportedOperationException();
	}

	@Todo("port")
	public final <T extends MappedObject> T slice() {
		throw new UnsupportedOperationException();
	}

	@Todo("port")
	public final void runViewConstructor() {
		throw new UnsupportedOperationException();
	}

	@Todo("port")
	public final void next() {
		throw new UnsupportedOperationException();
	}

	@Todo("port")
	public final <T extends MappedObject> void copyTo(T target) {
		throw new UnsupportedOperationException();
	}

	@Todo("port")
	public final <T extends MappedObject> void copyRange(T target, int instances) {
		throw new UnsupportedOperationException();
	}

	@Todo("port")
	public static <T extends MappedObject> Iterable<T> foreach(T mapped) {
		throw new UnsupportedOperationException();
	}

	@Todo("port")
	public static <T extends MappedObject> Iterable<T> foreach(T mapped, int elementCount) {
		throw new UnsupportedOperationException();
	}

	@Todo("port")
	public final <T extends MappedObject> T[] asArray() {
		throw new UnsupportedOperationException();
	}

	@Todo("port")
	public final ByteBuffer backingByteBuffer() {
		throw new UnsupportedOperationException();
	}
}
