/*
 * Copyright (c) 2002-2010 LWJGL Project
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 * * Redistributions of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer in the
 *   documentation and/or other materials provided with the distribution.
 *
 * * Neither the name of 'LWJGL' nor the names of
 *   its contributors may be used to endorse or promote products derived
 *   from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.lwjgl;

import org.lwjgl.system.Callback;

/**
 * Base PointerWrapper implementation.
 *
 * <p>LWJGL 2's, with LWJGL 3's {@link Callback} as its superclass, so that the classes that are both LWJGL 2's
 * PointerWrappers and LWJGL 3's callbacks (CLContextCallback, CLEventCallback, ...) can extend this one class and be
 * assigned to, and cast to, either: {@code PointerWrapperAbstract} for LWJGL 2 code, {@code Callback} for LWJGL 3
 * code. Every other PointerWrapperAbstract (the CL objects, GLSync, ...) is then a Callback too, wrapping its pointer:
 * Callback's members are there, but free and close release nothing unless this object made a native callback.</p>
 *
 * <p>Two constructors: LWJGL 2's, which wraps a pointer, and one for LWJGL 3 callbacks, which makes the native
 * function (Callback's descriptor constructor). equals, hashCode and toString are LWJGL 2's, from the pointer.</p>
 *
 * @author Spasi
 */
public abstract class PointerWrapperAbstract extends Callback implements PointerWrapper {

	/** Callback refuses a NULL address, which LWJGL 2 wrapped (an object whose creation failed): it gets this instead. */
	private static final long NULL_STAND_IN = 1L;

	protected final long pointer;

	/** Whether this made the native function it wraps, which free releases. */
	private final boolean owned;

	protected PointerWrapperAbstract(final long pointer) {
		super(pointer == 0L ? NULL_STAND_IN : pointer);
		this.pointer = pointer;
		this.owned = false;
	}

	/** An LWJGL 3 callback: makes its native function, whose address is the pointer. */
	protected PointerWrapperAbstract(final Callback.Descriptor descriptor) {
		super(descriptor);
		this.pointer = super.address();
		this.owned = true;
	}

	/**
	 * Returns true if this object represents a valid pointer.
	 * The pointer might be invalid because it is NULL or because
	 * some other action has deleted the object that this pointer
	 * represents.
	 *
	 * @return true if the pointer is valid
	 */
	public boolean isValid() {
		return pointer != 0;
	}

	/**
	 * Checks if the pointer is valid and throws an IllegalStateException if
	 * it is not. This method is a NO-OP, unless the org.lwjgl.util.Debug
	 * property has been set to true.
	 */
	public final void checkValid() {
		if ( LWJGLUtil.DEBUG && !isValid() )
			throw new IllegalStateException("This " + getClass().getSimpleName() + " pointer is not valid.");
	}

	public final long getPointer() {
		checkValid();
		return pointer;
	}

	/** The pointer, NULL included (Callback's own address is never NULL). */
	@Override
	public long address() {
		return pointer;
	}

	/** Releases the native function only if this made it: a wrapped pointer is not this object's to free. */
	@Override
	public void free() {
		if (owned) {
			super.free();
		}
	}

	public boolean equals(final Object o) {
		if ( this == o ) return true;
		if ( !(o instanceof PointerWrapperAbstract) ) return false;

		final PointerWrapperAbstract that = (PointerWrapperAbstract)o;

		if ( pointer != that.pointer ) return false;

		return true;
	}

	public int hashCode() {
		return (int)(pointer ^ (pointer >>> 32));
	}

	public String toString() {
		return getClass().getSimpleName() + " pointer (0x" + Long.toHexString(pointer).toUpperCase() + ")";
	}
}
