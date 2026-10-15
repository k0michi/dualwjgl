/*
 * Copyright LWJGL. All rights reserved.
 * License terms: https://www.lwjgl.org/license
 */
package org.lwjgl.opencl;

import org.lwjgl.PointerWrapper;
import org.lwjgl.system.Callback;
import org.lwjgl.system.Checks;

import static org.lwjgl.system.MemoryUtil.*;

/** LWJGL 2 and LWJGL 3 {@code CLMemObjectDestructorCallback} in one class; see {@link CLContextCallback} for how they are combined. */
public abstract class CLMemObjectDestructorCallback extends Callback implements CLMemObjectDestructorCallbackI, PointerWrapper {

	public static CLMemObjectDestructorCallback create(long functionPointer) {
		return create(Callback.get(functionPointer), functionPointer);
	}

	public static CLMemObjectDestructorCallback createSafe(long functionPointer) {
		return functionPointer == NULL ? null : create(functionPointer);
	}

	public static CLMemObjectDestructorCallback create(CLMemObjectDestructorCallbackI instance) {
		return create(instance, instance.address());
	}

	private static CLMemObjectDestructorCallback create(CLMemObjectDestructorCallbackI instance, long functionPointer) {
		return instance instanceof CLMemObjectDestructorCallback
			? (CLMemObjectDestructorCallback)instance
			: new CLMemObjectDestructorCallback(functionPointer) {
				@Override
				public void invoke(long memobj, long user_data) {
					instance.invoke(memobj, user_data);
				}
			};
	}

	protected CLMemObjectDestructorCallback() {
		super(DESCRIPTOR);
		this.pointer = address();
	}

	CLMemObjectDestructorCallback(long functionPointer) {
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
	public void invoke(long memobj, long user_data) {
		handleMessage(memobj);
	}

	protected void handleMessage(long memobj) {
		throw new AbstractMethodError(getClass().getName() + " overrides neither invoke nor handleMessage");
	}

}
