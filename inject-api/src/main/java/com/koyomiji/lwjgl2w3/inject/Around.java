package com.koyomiji.lwjgl2w3.inject;

import java.lang.annotation.*;

/**
 * Calls {@link #enter()} at the start of every instance method of the target class and {@link #exit()} when it returns
 * or throws, after all inject classes are merged. The target's inherited overridable methods get overrides that call
 * super first, so that calls on the target always run inside such a pair. Both hooks are no-argument instance methods
 * of the inject class; they and constructors are not wrapped. The overrides are synthetic, so javac keeps seeing the
 * inherited (generic) declarations.
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.TYPE)
public @interface Around {
	String enter();

	String exit();
}
