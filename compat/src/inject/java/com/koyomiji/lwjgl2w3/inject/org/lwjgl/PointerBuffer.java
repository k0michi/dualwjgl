package com.koyomiji.lwjgl2w3.inject.org.lwjgl;

import com.koyomiji.lwjgl2w3.inject.Hidden;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import org.lwjgl.PointerWrapper;

public final class PointerBuffer {
	protected ByteBuffer pointers;
	protected Buffer view;
	protected IntBuffer view32;
	protected LongBuffer view64;
	public ByteBuffer getBuffer() {
		// TODO(core)
		throw new UnsupportedOperationException();
	}
	public static boolean is64Bit() {
		// TODO(core)
		throw new UnsupportedOperationException();
	}
	public static int getPointerSize() {
		// TODO(core)
		throw new UnsupportedOperationException();
	}
	public final int positionByte() {
		// TODO(core)
		throw new UnsupportedOperationException();
	}
	@Hidden
	public final org.lwjgl.PointerBuffer position(int newPosition) {
		// TODO(core)
		throw new UnsupportedOperationException();
	}
	@Hidden
	public final org.lwjgl.PointerBuffer limit(int newLimit) {
		// TODO(core)
		throw new UnsupportedOperationException();
	}
	@Hidden
	public final org.lwjgl.PointerBuffer mark() {
		// TODO(core)
		throw new UnsupportedOperationException();
	}
	@Hidden
	public final org.lwjgl.PointerBuffer reset() {
		// TODO(core)
		throw new UnsupportedOperationException();
	}
	@Hidden
	public final org.lwjgl.PointerBuffer clear() {
		// TODO(core)
		throw new UnsupportedOperationException();
	}
	@Hidden
	public final org.lwjgl.PointerBuffer flip() {
		// TODO(core)
		throw new UnsupportedOperationException();
	}
	@Hidden
	public final org.lwjgl.PointerBuffer rewind() {
		// TODO(core)
		throw new UnsupportedOperationException();
	}
	public final int remainingByte() {
		// TODO(core)
		throw new UnsupportedOperationException();
	}
	protected org.lwjgl.PointerBuffer newInstance(ByteBuffer source) {
		// TODO(core)
		throw new UnsupportedOperationException();
	}
	@Hidden
	public org.lwjgl.PointerBuffer slice() {
		// TODO(core)
		throw new UnsupportedOperationException();
	}
	@Hidden
	public org.lwjgl.PointerBuffer duplicate() {
		// TODO(core)
		throw new UnsupportedOperationException();
	}
	public org.lwjgl.PointerBuffer asReadOnlyBuffer() {
		// TODO(core)
		throw new UnsupportedOperationException();
	}
	public boolean isReadOnly() {
		// TODO(core)
		throw new UnsupportedOperationException();
	}
	public org.lwjgl.PointerBuffer put(PointerWrapper pointer) {
		// TODO(core)
		throw new UnsupportedOperationException();
	}
	public org.lwjgl.PointerBuffer put(int index, PointerWrapper pointer) {
		// TODO(core)
		throw new UnsupportedOperationException();
	}
	@Hidden
	public org.lwjgl.PointerBuffer put(org.lwjgl.PointerBuffer src) {
		// TODO(core)
		throw new UnsupportedOperationException();
	}
	@Hidden
	public org.lwjgl.PointerBuffer compact() {
		// TODO(core)
		throw new UnsupportedOperationException();
	}
	public ByteOrder order() {
		// TODO(core)
		throw new UnsupportedOperationException();
	}
}
