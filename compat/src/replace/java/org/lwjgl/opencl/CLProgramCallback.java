package org.lwjgl.opencl;

import org.lwjgl.PointerWrapperAbstract;
import org.lwjgl.system.Callback;

import static org.lwjgl.system.MemoryUtil.*;

/**
 * LWJGL 2 and LWJGL 3 {@code CLProgramCallback} in one class; see {@link CLContextCallback} for how they are combined.
 * Package-private in LWJGL 2, where it is the superclass of {@code CLBuildProgramCallback} and friends.
 */
public abstract class CLProgramCallback extends PointerWrapperAbstract implements CLProgramCallbackI {

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
		CallbackUtil.markOwned(this);
	}

	CLProgramCallback(long functionPointer) {
		super(functionPointer);
	}

	/** LWJGL 2: where the CLProgram wrappers are; set by the functions that take the callback, which know the program. */
	private CLContext context;

	final void setContext(final CLContext context) {
		this.context = context;
	}

	/** LWJGL 2's trampoline: the CLProgram for the cl_program, then the one-shot reference deleted (see CallbackUtil). */
	@Override
	public void invoke(long program, long user_data) {
		try {
			handleMessage(context == null ? null : context.getCLProgram(program));
		} finally {
			CallbackUtil.deleteGlobalRef(user_data);
		}
	}

	protected void handleMessage(CLProgram program) {
		throw new AbstractMethodError(getClass().getName() + " overrides neither invoke nor handleMessage");
	}

}
