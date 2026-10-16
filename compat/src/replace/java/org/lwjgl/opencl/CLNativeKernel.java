package org.lwjgl.opencl;

import org.lwjgl.PointerWrapper;
import org.lwjgl.system.Callback;
import org.lwjgl.system.Checks;

import java.nio.ByteBuffer;

import static org.lwjgl.system.MemoryUtil.*;

/** LWJGL 2 and LWJGL 3 {@code CLNativeKernel} in one class; see {@link CLContextCallback} for how they are combined. */
public abstract class CLNativeKernel extends Callback implements CLNativeKernelI, PointerWrapper {

	public static CLNativeKernel create(long functionPointer) {
		return create(Callback.get(functionPointer), functionPointer);
	}

	public static CLNativeKernel createSafe(long functionPointer) {
		return functionPointer == NULL ? null : create(functionPointer);
	}

	public static CLNativeKernel create(CLNativeKernelI instance) {
		return create(instance, instance.address());
	}

	private static CLNativeKernel create(CLNativeKernelI instance, long functionPointer) {
		return instance instanceof CLNativeKernel
			? (CLNativeKernel)instance
			: new CLNativeKernel(functionPointer) {
				@Override
				public void invoke(long args) {
					instance.invoke(args);
				}
			};
	}

	protected CLNativeKernel() {
		super(DESCRIPTOR);
		this.pointer = address();
		CallbackUtil.markOwned(this);
	}

	CLNativeKernel(long functionPointer) {
		super(functionPointer);
		this.pointer = functionPointer;
	}

	protected final long pointer;

	public boolean isValid() {
		return pointer != NULL;
	}

	public final void checkValid() {
		if (Checks.DEBUG && !isValid()) {
			throw new IllegalStateException("This " + getClass().getSimpleName() + " pointer is not valid.");
		}
	}

	@Override
	public final long getPointer() {
		checkValid();
		return pointer;
	}

	/**
	 * LWJGL 2's trampoline: the args block is APIUtil.getNativeKernelArgs's, the callback's reference (8 bytes), the
	 * memory object count (4), then per memory object its size (4) and the pointer the implementation puts there. The
	 * one-shot reference is deleted after the call (see CallbackUtil).
	 */
	@Override
	public void invoke(long args) {
		try {
			execute(memobjs(args));
		} finally {
			CallbackUtil.deleteGlobalRef(memGetLong(args));
		}
	}

	protected void execute(ByteBuffer[] memobjs) {
		throw new AbstractMethodError(getClass().getName() + " overrides neither invoke nor execute");
	}

	private static ByteBuffer[] memobjs(long args) {
		int count = memGetInt(args + 8);
		if (count == 0) {
			return null; // TODO(verify): LWJGL 2's trampoline passed null, not an empty array, without memory objects
		}
		ByteBuffer[] memobjs = new ByteBuffer[count];
		long entry = args + 12;
		for (int i = 0; i < count; i++) {
			memobjs[i] = memByteBuffer(memGetAddress(entry + 4), memGetInt(entry));
			entry += 4 + POINTER_SIZE;
		}
		return memobjs;
	}

}
