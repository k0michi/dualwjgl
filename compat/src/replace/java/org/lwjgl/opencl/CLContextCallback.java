package org.lwjgl.opencl;

import org.lwjgl.PointerWrapper;
import org.lwjgl.system.Callback;
import org.lwjgl.system.Checks;

import java.nio.ByteBuffer;

import static org.lwjgl.system.MemoryUtil.*;

/**
 * LWJGL 2 and LWJGL 3 {@code CLContextCallback} in one class.
 *
 * <p>The superclass is LWJGL 3's {@link Callback}, which owns the native upcall. LWJGL 2's superclass
 * ({@code PointerWrapperAbstract}) cannot also be a superclass, so this implements {@link PointerWrapper} and
 * re-declares its members; no LWJGL 2 API takes {@code PointerWrapperAbstract} itself.</p>
 *
 * <p>Neither callback method is abstract: LWJGL 3 code overrides {@code invoke}, LWJGL 2 code overrides
 * {@code handleMessage}, and the default {@code invoke} forwards to {@code handleMessage}.</p>
 */
public abstract class CLContextCallback extends Callback implements CLContextCallbackI, PointerWrapper {

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
		this.pointer = address();
		this.custom = false;
	}

	/** LWJGL 2: {@code protected}, wraps a native callback; LWJGL 3: package-private, used by {@code create}. */
	protected CLContextCallback(long functionPointer) {
		super(functionPointer);
		if (functionPointer == NULL) {
			throw new RuntimeException("Invalid callback function pointer specified.");
		}
		this.pointer = functionPointer;
		this.custom = true;
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
