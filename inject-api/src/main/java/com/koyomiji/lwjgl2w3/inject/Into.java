package com.koyomiji.lwjgl2w3.inject;

import java.lang.annotation.*;

/**
 * Merges the annotated inject class into {@link #value()} instead of the class its name maps to. Lets several inject
 * classes target one class, e.g. one that extends the target's superclass so that its constructors can call
 * {@code super(...)}: constructors are copied only when the inject class and the target share their superclass.
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.TYPE)
public @interface Into {

	Class<?> value();

}
