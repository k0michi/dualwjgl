package org.lwjgl.opencl;

import org.lwjgl.PointerWrapper;
import org.lwjgl.system.Callback;
import org.lwjgl.system.Checks;

import static org.lwjgl.system.MemoryUtil.*;

/**
 * LWJGL 2 and LWJGL 3 {@code CLProgramCallback} in one class; see {@link CLContextCallback} for how they are combined.
 * Package-private in LWJGL 2, where it is the superclass of {@code CLBuildProgramCallback} and friends.
 */
public abstract class CLProgramCallback extends Callback implements CLProgramCallbackI, PointerWrapper {

	public static CLProgramCallback create(long functionPointer) {
		return create(Callback.get(functionPointer), functionPointer);
	}

	public static CLProgramCallback createSafe(long functionPointer) {
		return functionPointer == NULL ? null : create(functionPointer);
	}

	public static CLProgramCallback create(CLProgramCallbackI instance) {
		return create(instance, instance.address());
	}

	private static CLProgramCallback create(CLProgramCallbackI instance, long functionPointer) {
		return instance instanceof CLProgramCallback
			? (CLProgramCallback)instance
			: new CLProgramCallback(functionPointer) {
				@Override
				public void invoke(long program, long user_data) {
					instance.invoke(program, user_data);
				}
			};
	}

	protected CLProgramCallback() {
		super(DESCRIPTOR);
		this.pointer = address();
	}

	CLProgramCallback(long functionPointer) {
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
	public void invoke(long program, long user_data) {
		handleMessage(program(program));
	}

	protected void handleMessage(CLProgram program) {
		throw new AbstractMethodError(getClass().getName() + " overrides neither invoke nor handleMessage");
	}

	private static CLProgram program(long program) {
		// TODO(cl): the CLProgram that wraps this cl_program in the CL object model
		throw new UnsupportedOperationException();
	}

}
