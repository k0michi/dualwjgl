package org.lwjgl.opencl;

import org.lwjgl.PointerWrapper;
import org.lwjgl.system.Callback;
import org.lwjgl.system.Checks;

import static org.lwjgl.system.MemoryUtil.*;

/** LWJGL 2 and LWJGL 3 {@code CLEventCallback} in one class; see {@link CLContextCallback} for how they are combined. */
public abstract class CLEventCallback extends Callback implements CLEventCallbackI, PointerWrapper {

	public static CLEventCallback create(long functionPointer) {
		return create(Callback.get(functionPointer), functionPointer);
	}

	public static CLEventCallback createSafe(long functionPointer) {
		return functionPointer == NULL ? null : create(functionPointer);
	}

	public static CLEventCallback create(CLEventCallbackI instance) {
		return create(instance, instance.address());
	}

	private static CLEventCallback create(CLEventCallbackI instance, long functionPointer) {
		return instance instanceof CLEventCallback
			? (CLEventCallback)instance
			: new CLEventCallback(functionPointer) {
				@Override
				public void invoke(long event, int event_command_exec_status, long user_data) {
					instance.invoke(event, event_command_exec_status, user_data);
				}
			};
	}

	protected CLEventCallback() {
		super(DESCRIPTOR);
		this.pointer = address();
	}

	CLEventCallback(long functionPointer) {
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
	public void invoke(long event, int event_command_exec_status, long user_data) {
		handleMessage(event(event), event_command_exec_status);
	}

	protected void handleMessage(CLEvent event, int event_command_exec_status) {
		throw new AbstractMethodError(getClass().getName() + " overrides neither invoke nor handleMessage");
	}

	private static CLEvent event(long event) {
		// TODO(cl): the CLEvent that wraps this cl_event in the CL object model
		throw new UnsupportedOperationException();
	}

}
