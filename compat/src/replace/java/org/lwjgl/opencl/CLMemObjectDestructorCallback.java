package org.lwjgl.opencl;

import org.lwjgl.PointerWrapperAbstract;
import org.lwjgl.system.Callback;

import static org.lwjgl.system.MemoryUtil.*;

/** LWJGL 2 and LWJGL 3 {@code CLMemObjectDestructorCallback} in one class; see {@link CLContextCallback} for how they are combined. */
public abstract class CLMemObjectDestructorCallback extends PointerWrapperAbstract implements CLMemObjectDestructorCallbackI {

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
		CallbackUtil.markOwned(this);
	}

	CLMemObjectDestructorCallback(long functionPointer) {
		super(functionPointer);
	}

	/** LWJGL 2's trampoline: the call, then the one-shot reference deleted (see CallbackUtil). */
	@Override
	public void invoke(long memobj, long user_data) {
		try {
			handleMessage(memobj);
		} finally {
			CallbackUtil.deleteGlobalRef(user_data);
		}
	}

	protected void handleMessage(long memobj) {
		throw new AbstractMethodError(getClass().getName() + " overrides neither invoke nor handleMessage");
	}

}
