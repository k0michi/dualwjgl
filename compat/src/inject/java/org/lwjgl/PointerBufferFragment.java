package org.lwjgl;

import com.koyomiji.lwjgl2w3.inject.Hidden;
import com.koyomiji.lwjgl2w3.inject.Into;
import org.lwjgl.system.CustomBuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static org.lwjgl.system.MemoryUtil.*;
import static org.lwjgl.system.Pointer.*;

/**
 * LWJGL 2's PointerBuffer constructors and members, merged into LWJGL 3's PointerBuffer.
 *
 * <p>Extends CustomBuffer, like PointerBuffer, so that its constructors can call super(...) and its members can call
 * CustomBuffer's and read its state. In LWJGL 2's package so that it can create the package-private
 * {@link PointerBufferR}.</p>
 */
@Into(PointerBuffer.class)
abstract class PointerBufferFragment extends CustomBuffer<PointerBuffer> {

	public PointerBufferFragment(int capacity) {
		this(BufferUtils.createByteBuffer(capacity * POINTER_SIZE));
	}

	public PointerBufferFragment(ByteBuffer source) {
		super(memAddress(checkSource(source)), source, -1, 0, source.remaining() >> POINTER_SHIFT, source.remaining() >> POINTER_SHIFT);
	}

	private static ByteBuffer checkSource(ByteBuffer source) {
		if (!source.isDirect()) {
			throw new IllegalArgumentException("The source buffer is not direct.");
		}
		if ((memAddress(source) | source.remaining()) % POINTER_SIZE != 0) {
			throw new IllegalArgumentException("The source buffer is not aligned to " + POINTER_SIZE + " bytes.");
		}
		return source;
	}

	/** {@link #getBuffer()}'s view, created on first use: LWJGL 2 returns the same buffer every time. */
	@Hidden
	private ByteBuffer lwjgl2Buffer;

	/**
	 * The whole memory of this buffer, from element 0 to its capacity, in native order; always the same object. From the
	 * buffer it was created from when there is one, so that the view keeps that memory alive.
	 */
	public ByteBuffer getBuffer() {
		ByteBuffer buffer = lwjgl2Buffer;
		if (buffer == null) {
			int bytes = capacity << POINTER_SHIFT;
			if (container != null) {
				int offset = (int)(address - memAddress0(container));
				ByteBuffer view = container.duplicate();
				view.clear();
				view.limit(offset + bytes);
				view.position(offset);
				buffer = view.slice();
			} else {
				buffer = memByteBuffer(address, bytes);
			}
			if (isReadOnly()) {
				buffer = buffer.asReadOnlyBuffer();
			}
			buffer.order(ByteOrder.nativeOrder());
			lwjgl2Buffer = buffer;
		}
		return buffer;
	}

	public static boolean is64Bit() {
		return BITS64;
	}

	public static int getPointerSize() {
		return POINTER_SIZE;
	}

	public final int positionByte() {
		return position() * POINTER_SIZE;
	}

	public final int remainingByte() {
		return remaining() * POINTER_SIZE;
	}

	// LWJGL 3 declares these in CustomBuffer<SELF>, so in bytecode they return CustomBuffer; LWJGL 2 binaries call the
	// PointerBuffer versions. Hidden, so that javac keeps seeing only LWJGL 3's.

	@Hidden
	@Override
	public final PointerBuffer position(int newPosition) {
		return super.position(newPosition);
	}

	@Hidden
	@Override
	public final PointerBuffer limit(int newLimit) {
		return super.limit(newLimit);
	}

	@Hidden
	@Override
	public final PointerBuffer mark() {
		return super.mark();
	}

	@Hidden
	@Override
	public final PointerBuffer reset() {
		return super.reset();
	}

	@Hidden
	@Override
	public final PointerBuffer clear() {
		return super.clear();
	}

	@Hidden
	@Override
	public final PointerBuffer flip() {
		return super.flip();
	}

	@Hidden
	@Override
	public final PointerBuffer rewind() {
		return super.rewind();
	}

	@Hidden
	@Override
	public PointerBuffer slice() {
		return super.slice();
	}

	@Hidden
	@Override
	public PointerBuffer duplicate() {
		return super.duplicate();
	}

	@Hidden
	@Override
	public PointerBuffer put(PointerBuffer src) {
		return super.put(src);
	}

	@Hidden
	@Override
	public PointerBuffer compact() {
		return super.compact();
	}

	/**
	 * DEVIATION(newInstance): LWJGL 2's slice() and duplicate() create their result with newInstance, so a subclass
	 * overriding it got its own type back. LWJGL 3's create them with create(...) and never call newInstance: an
	 * override here has no effect on them. Few, if any, LWJGL 2 users subclass PointerBuffer; revisit if one does.
	 */
	protected PointerBuffer newInstance(ByteBuffer source) {
		return PointerBuffer.create(source);
	}

	/** A view that throws ReadOnlyBufferException on every write, sharing this buffer's memory and state. */
	public PointerBuffer asReadOnlyBuffer() {
		return new PointerBufferR(address, container, mark, position, limit, capacity);
	}

	public boolean isReadOnly() {
		return false;
	}

	public PointerBuffer put(PointerWrapper pointer) {
		return self().put(pointer.getPointer());
	}

	public PointerBuffer put(int index, PointerWrapper pointer) {
		return self().put(index, pointer.getPointer());
	}

	public ByteOrder order() {
		return ByteOrder.nativeOrder();
	}

}
