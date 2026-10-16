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
		CallbackUtil.markOwned(this);
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

	/** LWJGL 2: where the CLEvent wrappers are; set by clSetEventCallback, which knows the event. */
	private CLObjectRegistry<CLEvent> eventRegistry;

	void setRegistry(final CLObjectRegistry<CLEvent> eventRegistry) {
		this.eventRegistry = eventRegistry;
	}

	/** LWJGL 2's trampoline: the CLEvent for the cl_event, then the one-shot reference deleted (see CallbackUtil). */
	@Override
	public void invoke(long event, int event_command_exec_status, long user_data) {
		try {
			handleMessage(eventRegistry == null ? null : eventRegistry.getObject(event), event_command_exec_status);
		} finally {
			CallbackUtil.deleteGlobalRef(user_data);
		}
	}

	protected void handleMessage(CLEvent event, int event_command_exec_status) {
		throw new AbstractMethodError(getClass().getName() + " overrides neither invoke nor handleMessage");
	}

}
