package com.koyomiji.lwjgl2w3.inject;

import java.lang.annotation.*;

/**
 * Copy this member as {@code ACC_SYNTHETIC}: binaries compiled against LWJGL 2 still link to it, but javac does not see
 * it, so it cannot hijack overload resolution of LWJGL 3 source code.
 */
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.FIELD})
public @interface Hidden {
}
