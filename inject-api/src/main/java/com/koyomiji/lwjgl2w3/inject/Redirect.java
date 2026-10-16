package com.koyomiji.lwjgl2w3.inject;

import java.lang.annotation.*;

/**
 * In the target's instance methods, calls to the static method {@link #owner()}.{@link #name()} with this method's
 * descriptor call this instance method instead, on {@code this}. Static methods of the target are left alone.
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.METHOD)
public @interface Redirect {
	Class<?> owner();

	String name();
}
