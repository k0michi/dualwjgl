package org.lwjgl;

import com.koyomiji.lwjgl2w3.inject.Around;
import com.koyomiji.lwjgl2w3.inject.Hidden;
import com.koyomiji.lwjgl2w3.inject.Into;
import com.koyomiji.lwjgl2w3.inject.Redirect;
import com.koyomiji.lwjgl2w3.inject.Wrap;
import org.lwjgl.system.CustomBuffer;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.nio.LongBuffer;

import static org.lwjgl.system.MemoryUtil.*;
import static org.lwjgl.system.Pointer.*;

/**
 * LWJGL 2's PointerBuffer constructors and members, merged into LWJGL 3's PointerBuffer.
 *
 * <p>LWJGL 2's protected fields: {@code pointers} is {@link #getBuffer()}'s buffer, and an LWJGL 2 subclass (or a buffer
 * over a source in non-native order, whose elements LWJGL 2 reads in that order) also gets LWJGL 2's NIO views
 * {@code view}, {@code view32} and {@code view64}. Two owners of the state then: CustomBuffer's fields, which LWJGL 3
 * code moves, and the view, which the subclass moves. {@link Around} makes every PointerBuffer method pull the view's
 * state on entry and push its own on exit, which keeps them in sync since the subclass can only move the view between
 * two calls. Without a view both hooks return at once, so LWJGL 3's own buffers pay a field check per call
 * ({@code :verify:pointerBufferBench} measures it). Without sun.misc.Unsafe, a mark set on the view is not pulled.</p>
 *
 * <p>DEVIATION(pointer-buffer-static-order): the static put(ByteBuffer, ...) and get(ByteBuffer, ...) are LWJGL 3's
 * (same descriptors), which use native order where LWJGL 2's used the target buffer's.</p>
 *
 * <p>Extends CustomBuffer, like PointerBuffer, so that its constructors can call super(...) and its members can call
 * CustomBuffer's and read its state. In LWJGL 2's package so that it can create the package-private
 * {@link PointerBufferR}.</p>
 */
@Into(PointerBuffer.class)
@Around(enter = "lwjgl2$pull", exit = "lwjgl2$push")
abstract class PointerBufferFragment extends CustomBuffer<PointerBuffer> {

	public PointerBufferFragment(int capacity) {
		this(BufferUtils.createByteBuffer(capacity * POINTER_SIZE));
	}

	public PointerBufferFragment(ByteBuffer source) {
		super(memAddress(checkSource(source)), source, -1, 0, source.remaining() >> POINTER_SHIFT, source.remaining() >> POINTER_SHIFT);
		pointers = source.slice().order(source.order());
		// getClass() is typed after this fragment here
		if ((Object)getClass() != PointerBuffer.class || pointers.order() != ByteOrder.nativeOrder()) {
			if (BITS64) {
				view32 = null;
				view = view64 = pointers.asLongBuffer();
			} else {
				view = view32 = pointers.asIntBuffer();
				view64 = null;
			}
			lwjgl2$synced = new int[] {position, limit, mark};
		}
	}

	protected ByteBuffer pointers;
	protected Buffer view;
	protected IntBuffer view32;
	protected LongBuffer view64;

	/**
	 * Position, limit and mark as last synced between this buffer and its view; null without a view. Only a view that
	 * differs from it was moved by the subclass: a nested call (self() inside position(int)) must not pull the view over
	 * the state its caller is changing.
	 */
	@Hidden
	private int[] lwjgl2$synced;

	/** Entry: take what the subclass did to the view since the last sync. */
	@Hidden
	final void lwjgl2$pull() {
		int[] synced = lwjgl2$synced;
		if (synced == null) {
			return;
		}
		Buffer v = view;
		int p = v.position();
		int l = v.limit();
		int m = PointerBufferSupport.GET_MARK != null ? getMark(v) : synced[2];
		if (p != synced[0] || l != synced[1] || m != synced[2]) {
			limit = synced[1] = l;
			position = synced[0] = p;
			mark = synced[2] = m;
		}
	}

	/** Exit: give the view what LWJGL 3 code did to this buffer's state since the last sync. */
	@Hidden
	final void lwjgl2$push() {
		int[] synced = lwjgl2$synced;
		if (synced == null || position == synced[0] && limit == synced[1] && mark == synced[2]) {
			return;
		}
		Buffer v = view;
		// limit first: NIO moves the position and drops the mark when they are above the new limit
		v.limit(limit);
		v.position(position);
		if (PointerBufferSupport.PUT_MARK != null) {
			putMark(v, mark);
		} else if (mark >= 0) {
			v.position(mark);
			v.mark();
			v.position(position);
		}
		synced[0] = position;
		synced[1] = limit;
		synced[2] = mark;
	}

	private static int getMark(Buffer v) {
		try {
			return (int)PointerBufferSupport.GET_MARK.invokeExact(v);
		} catch (Throwable e) {
			throw new IllegalStateException(e);
		}
	}

	private static void putMark(Buffer v, int mark) {
		try {
			PointerBufferSupport.PUT_MARK.invokeExact(v, mark);
		} catch (Throwable e) {
			throw new IllegalStateException(e);
		}
	}

	/** Whether LWJGL 2 reads and writes this buffer's elements in a non-native order: its source's. */
	private boolean swapped() {
		return lwjgl2$synced != null && pointers.order() != ByteOrder.nativeOrder();
	}

	private static long swap(long value) {
		return BITS64 ? Long.reverseBytes(value) : Integer.toUnsignedLong(Integer.reverseBytes((int)value));
	}

	// PointerBuffer's element access, in its source's order as in LWJGL 2 when that is not native

	@Hidden
	@Redirect(owner = org.lwjgl.system.MemoryUtil.class, name = "memGetAddress")
	final long lwjgl2$memGetAddress(long address) {
		long value = memGetAddress(address);
		return swapped() ? swap(value) : value;
	}

	@Hidden
	@Redirect(owner = org.lwjgl.system.MemoryUtil.class, name = "memPutAddress")
	final void lwjgl2$memPutAddress(long address, long value) {
		memPutAddress(address, swapped() ? swap(value) : value);
	}

	@Hidden
	@Redirect(owner = org.lwjgl.system.MemoryUtil.class, name = "memLongBuffer")
	final LongBuffer lwjgl2$memLongBuffer(long address, int capacity) {
		return swapped() ? memByteBuffer(address, capacity << 3).order(pointers.order()).asLongBuffer() : memLongBuffer(address, capacity);
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

	/**
	 * The whole memory of this buffer, from element 0 to its capacity; always the same object. LWJGL 2's constructors
	 * create it, as LWJGL 2 did, in the source's order; for other buffers it is created on first use, in native order,
	 * from the buffer they were created from when there is one, so that it keeps that memory alive. Writable even for a
	 * read-only buffer, as LWJGL 2's.
	 */
	public ByteBuffer getBuffer() {
		ByteBuffer buffer = pointers;
		if (buffer == null) {
			pointers = buffer = bytes(address, container, capacity);
		}
		return buffer;
	}

	/**
	 * {@code capacity} pointers at {@code address}, cut from {@code container} when there is one, so that the view keeps
	 * that memory alive.
	 */
	private static ByteBuffer bytes(long address, ByteBuffer container, int capacity) {
		int bytes = capacity << POINTER_SHIFT;
		ByteBuffer buffer;
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
		return buffer.order(ByteOrder.nativeOrder());
	}

	/**
	 * LWJGL 3's slice(), slice(int, int) and duplicate() create their result here. For an LWJGL 2 subclass or a buffer
	 * over a non-native source, through newInstance in the source's order, as LWJGL 2's slice() and duplicate() did, so
	 * that a subclass overriding it gets its own type back from these too (LWJGL 2 source compiled against these jars
	 * calls them) and the order is kept. LWJGL 3's own buffers, PointerBufferR and LWJGL 3 subclasses (which override
	 * this) are unchanged.
	 */
	@Wrap
	protected PointerBuffer create(long address, ByteBuffer container, int mark, int position, int limit, int capacity) {
		// in this fragment, getClass() is typed after PointerBufferFragment
		if ((Object)getClass() == PointerBuffer.class && lwjgl2$synced == null) {
			return create$lwjgl3(address, container, mark, position, limit, capacity);
		}
		PointerBuffer buffer = newInstance(bytes(address, container, capacity).order(order()));
		buffer.limit(limit);
		if (mark >= 0) {
			buffer.position(mark);
			buffer.mark();
		}
		buffer.position(position);
		return buffer;
	}

	/** LWJGL 3's create(...), renamed by the merger. */
	abstract PointerBuffer create$lwjgl3(long address, ByteBuffer container, int mark, int position, int limit, int capacity);

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
	// PointerBuffer versions. Hidden, so that javac keeps seeing only LWJGL 3's. javac also writes bridges from the
	// CustomBuffer versions to these; the merger drops them, so LWJGL 3's calls still reach CustomBuffer's.

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

	/** As LWJGL 2's: newInstance over the elements from position to limit. */
	@Hidden
	@Override
	public PointerBuffer slice() {
		ByteBuffer bytes = lwjgl2Bytes();
		bytes.limit(limit << POINTER_SHIFT);
		bytes.position(position << POINTER_SHIFT);
		return newInstance(bytes.slice().order(bytes.order()));
	}

	/**
	 * As LWJGL 2's: newInstance over the whole buffer, then this buffer's position and limit, not its mark. LWJGL 2
	 * source compiled against these jars calls LWJGL 3's duplicate() instead (same signature, LWJGL 3 wins), which copies
	 * the mark.
	 */
	@Hidden
	@Override
	public PointerBuffer duplicate() {
		PointerBuffer buffer = newInstance(lwjgl2Bytes());
		buffer.position(position);
		buffer.limit(limit);
		return buffer;
	}

	/** A fresh view of {@link #getBuffer()}'s memory, in its order, so that slicing it does not move the shared one. */
	private ByteBuffer lwjgl2Bytes() {
		ByteBuffer buffer = getBuffer();
		ByteBuffer bytes = buffer.duplicate().order(buffer.order());
		bytes.clear();
		return bytes;
	}

	/** As NIO's and LWJGL 2's: advances {@code src} too, where LWJGL 3's put(PointerBuffer) leaves it. */
	@Hidden
	@Override
	public PointerBuffer put(PointerBuffer src) {
		int n = src.remaining();
		super.put(src);
		src.position(src.position() + n);
		return self();
	}

	@Hidden
	@Override
	public PointerBuffer compact() {
		return super.compact();
	}

	/**
	 * Creates the result of slice() and duplicate() for LWJGL 2 subclasses: LWJGL 2 binaries call LWJGL 2's (the hidden
	 * overloads above), everything else LWJGL 3's, which reach this through create(...).
	 */
	protected PointerBuffer newInstance(ByteBuffer source) {
		try {
			return (PointerBuffer)PointerBufferSupport.NEW.invokeExact(source);
		} catch (RuntimeException | Error e) {
			throw e;
		} catch (Throwable e) {
			throw new IllegalStateException(e);
		}
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

	/** As LWJGL 2's: the order of {@link #getBuffer()}, the source's. */
	public ByteOrder order() {
		return getBuffer().order();
	}

}
