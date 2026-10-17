package org.lwjgl.util.mapped;

import com.koyomiji.dualwjgl.inject.Generated;
import java.nio.ByteBuffer;

@Generated
public abstract class MappedObject {
	public long baseAddress;
	public long viewAddress;
	public static int SIZEOF;
	public int view;

	protected MappedObject() {
		throw new UnsupportedOperationException("org.lwjgl.util.mapped is not supported");
	}

	protected final long getViewAddress(int view) {
		throw new UnsupportedOperationException("org.lwjgl.util.mapped is not supported");
	}

	public final void setViewAddress(long address) {
		throw new UnsupportedOperationException("org.lwjgl.util.mapped is not supported");
	}

	public final int getAlign() {
		throw new UnsupportedOperationException("org.lwjgl.util.mapped is not supported");
	}

	public final int getSizeof() {
		throw new UnsupportedOperationException("org.lwjgl.util.mapped is not supported");
	}

	public final int capacity() {
		throw new UnsupportedOperationException("org.lwjgl.util.mapped is not supported");
	}

	public static <T extends MappedObject> T map(ByteBuffer bb) {
		throw new UnsupportedOperationException("org.lwjgl.util.mapped is not supported");
	}

	public static <T extends MappedObject> T map(long address, int capacity) {
		throw new UnsupportedOperationException("org.lwjgl.util.mapped is not supported");
	}

	public static <T extends MappedObject> T malloc(int elementCount) {
		throw new UnsupportedOperationException("org.lwjgl.util.mapped is not supported");
	}

	public final <T extends MappedObject> T dup() {
		throw new UnsupportedOperationException("org.lwjgl.util.mapped is not supported");
	}

	public final <T extends MappedObject> T slice() {
		throw new UnsupportedOperationException("org.lwjgl.util.mapped is not supported");
	}

	public final void runViewConstructor() {
		throw new UnsupportedOperationException("org.lwjgl.util.mapped is not supported");
	}

	public final void next() {
		throw new UnsupportedOperationException("org.lwjgl.util.mapped is not supported");
	}

	public final <T extends MappedObject> void copyTo(T target) {
		throw new UnsupportedOperationException("org.lwjgl.util.mapped is not supported");
	}

	public final <T extends MappedObject> void copyRange(T target, int instances) {
		throw new UnsupportedOperationException("org.lwjgl.util.mapped is not supported");
	}

	public static <T extends MappedObject> Iterable<T> foreach(T mapped) {
		throw new UnsupportedOperationException("org.lwjgl.util.mapped is not supported");
	}

	public static <T extends MappedObject> Iterable<T> foreach(T mapped, int elementCount) {
		throw new UnsupportedOperationException("org.lwjgl.util.mapped is not supported");
	}

	public final <T extends MappedObject> T[] asArray() {
		throw new UnsupportedOperationException("org.lwjgl.util.mapped is not supported");
	}

	public final ByteBuffer backingByteBuffer() {
		throw new UnsupportedOperationException("org.lwjgl.util.mapped is not supported");
	}
}
