package com.koyomiji.lwjgl2w3.inject;

import java.lang.annotation.*;

/**
 * Marks a class written by stubgen. Its members may be overridden by hand-written inject classes; members of other
 * classes may not.
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.TYPE)
public @interface Generated {
}
