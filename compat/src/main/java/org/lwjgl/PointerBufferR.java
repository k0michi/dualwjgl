package org.lwjgl;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ReadOnlyBufferException;
import java.nio.ShortBuffer;

import org.lwjgl.system.CustomBuffer;
import org.lwjgl.system.Pointer;

import static org.lwjgl.system.MemoryUtil.*;
import static org.lwjgl.system.Pointer.*;

/**
 * LWJGL 2's read-only PointerBuffer, from {@code asReadOnlyBuffer()}: every write method throws
 * ReadOnlyBufferException, and slices and duplicates stay read-only. As in LWJGL 2, writes through the address (e.g.
 * memPutAddress) are not prevented. Every write method of LWJGL 3's PointerBuffer must be overridden here.
 */
final class PointerBufferR extends PointerBuffer {

	PointerBufferR(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
		super(address, container, mark, position, limit, capacity);
	}

	@Override
	protected PointerBuffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
		return new PointerBufferR(address, container, mark, position, limit, capacity);
	}

	// LWJGL 2 members, overriding PointerBuffer's once merged

	public boolean isReadOnly() {
		return true;
	}

	public PointerBuffer asReadOnlyBuffer() {
		return duplicate();
	}

	/** DEVIATION(newInstance): see PointerBuffer's; LWJGL 2's read-only buffer returned a read-only buffer here too. */
	protected PointerBuffer newInstance(ByteBuffer source) {
		int capacity = source.remaining() >> POINTER_SHIFT;
		return new PointerBufferR(memAddress(source), source, -1, 0, capacity, capacity);
	}

	public PointerBuffer put(PointerWrapper pointer) {
		throw new ReadOnlyBufferException();
	}

	public PointerBuffer put(int index, PointerWrapper pointer) {
		throw new ReadOnlyBufferException();
	}

	// LWJGL 3's write methods

	@Override
	public PointerBuffer put(long value) {
		throw new ReadOnlyBufferException();
	}

	@Override
	public PointerBuffer put(int index, long value) {
		throw new ReadOnlyBufferException();
	}

	@Override
	public PointerBuffer put(Pointer pointer) {
		throw new ReadOnlyBufferException();
	}

	@Override
	public PointerBuffer put(int index, Pointer pointer) {
		throw new ReadOnlyBufferException();
	}

	@Override
	public PointerBuffer put(ByteBuffer buffer) {
		throw new ReadOnlyBufferException();
	}

	@Override
	public PointerBuffer put(ShortBuffer buffer) {
		throw new ReadOnlyBufferException();
	}

	@Override
	public PointerBuffer put(IntBuffer buffer) {
		throw new ReadOnlyBufferException();
	}

	@Override
	public PointerBuffer put(LongBuffer buffer) {
		throw new ReadOnlyBufferException();
	}

	@Override
	public PointerBuffer put(FloatBuffer buffer) {
		throw new ReadOnlyBufferException();
	}

	@Override
	public PointerBuffer put(DoubleBuffer buffer) {
		throw new ReadOnlyBufferException();
	}

	@Override
	public PointerBuffer put(int index, ByteBuffer buffer) {
		throw new ReadOnlyBufferException();
	}

	@Override
	public PointerBuffer put(int index, ShortBuffer buffer) {
		throw new ReadOnlyBufferException();
	}

	@Override
	public PointerBuffer put(int index, IntBuffer buffer) {
		throw new ReadOnlyBufferException();
	}

	@Override
	public PointerBuffer put(int index, LongBuffer buffer) {
		throw new ReadOnlyBufferException();
	}

	@Override
	public PointerBuffer put(int index, FloatBuffer buffer) {
		throw new ReadOnlyBufferException();
	}

	@Override
	public PointerBuffer put(int index, DoubleBuffer buffer) {
		throw new ReadOnlyBufferException();
	}

	@Override
	public PointerBuffer putAddressOf(CustomBuffer<?> buffer) {
		throw new ReadOnlyBufferException();
	}

	@Override
	public PointerBuffer putAddressOf(int index, CustomBuffer<?> buffer) {
		throw new ReadOnlyBufferException();
	}

	@Override
	public PointerBuffer put(long[] src) {
		throw new ReadOnlyBufferException();
	}

	@Override
	public PointerBuffer put(long[] src, int off, int len) {
		throw new ReadOnlyBufferException();
	}

	@Override
	public PointerBuffer put(PointerBuffer src) {
		throw new ReadOnlyBufferException();
	}

	@Override
	public PointerBuffer compact() {
		throw new ReadOnlyBufferException();
	}

}
