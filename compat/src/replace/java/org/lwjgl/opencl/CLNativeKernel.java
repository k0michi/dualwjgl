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

	@Override
	public void invoke(long args) {
		execute(memobjs(args));
	}

	protected void execute(ByteBuffer[] memobjs) {
		throw new AbstractMethodError(getClass().getName() + " overrides neither invoke nor execute");
	}

	private static ByteBuffer[] memobjs(long args) {
		// TODO(cl): decode the args block that LWJGL 2's clEnqueueNativeKernel lays out (memory object count, sizes, pointers)
		throw new UnsupportedOperationException();
	}

}
