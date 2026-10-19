package org.lwjgl.opencl;

import org.lwjgl.PointerWrapperAbstract;
import org.lwjgl.system.Callback;

import java.nio.ByteBuffer;

import static org.lwjgl.system.MemoryUtil.*;

/**
 * LWJGL 2 and LWJGL 3 {@code CLContextCallback} in one class.
 *
 * <p>The superclass is LWJGL 2's {@link PointerWrapperAbstract}, whose own superclass in DuaLWJGL is LWJGL 3's
 * {@link Callback}: this is both, and is assigned to or cast to either, as LWJGL 2 or LWJGL 3 code does. The no-argument
 * constructor makes the native upcall (Callback's descriptor constructor); the other wraps a native function.</p>
 *
 * <p>Neither callback method is abstract: LWJGL 3 code overrides {@code invoke}, LWJGL 2 code overrides
 * {@code handleMessage}, and the default {@code invoke} forwards to {@code handleMessage}.</p>
 */
public abstract class CLContextCallback extends PointerWrapperAbstract implements CLContextCallbackI {

	public static CLContextCallback create(long functionPointer) {
		return create(Callback.get(functionPointer), functionPointer);
	}

	public static CLContextCallback createSafe(long functionPointer) {
		return functionPointer == NULL ? null : create(functionPointer);
	}

	public static CLContextCallback create(CLContextCallbackI instance) {
		return create(instance, instance.address());
	}

	private static CLContextCallback create(CLContextCallbackI instance, long functionPointer) {
		return instance instanceof CLContextCallback
			? (CLContextCallback)instance
			: new CLContextCallback(functionPointer) {
				@Override
				public void invoke(long errinfo, long private_info, long cb, long user_data) {
					instance.invoke(errinfo, private_info, cb, user_data);
				}
			};
	}

	protected CLContextCallback() {
		super(DESCRIPTOR);
		CallbackUtil.markOwned(this);
		this.custom = false;
	}

	/** LWJGL 2: {@code protected}, wraps a native callback; LWJGL 3: package-private, used by {@code create}. */
	protected CLContextCallback(long functionPointer) {
		super(functionPointer);
		if (functionPointer == NULL) {
			throw new RuntimeException("Invalid callback function pointer specified.");
		}
		this.custom = true;
	}

	private final boolean custom;

	/** LWJGL 2: whether this was created from a user-supplied native function pointer. */
	final boolean isCustom() {
		return custom;
	}

	@Override
	public void invoke(long errinfo, long private_info, long cb, long user_data) {
		handleMessage(memUTF8(errinfo), private_info == NULL ? null : memByteBuffer(private_info, (int)cb));
	}

	protected void handleMessage(String errinfo, ByteBuffer private_info) {
		throw new AbstractMethodError(getClass().getName() + " overrides neither invoke nor handleMessage");
	}

}
