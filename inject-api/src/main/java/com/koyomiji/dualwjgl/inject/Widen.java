package com.koyomiji.dualwjgl.inject;

import java.lang.annotation.*;

/**
 * The target LWJGL 3 class already declares this member (same name and descriptor). Do not copy it; only widen the
 * existing member's access to the access declared here. The annotated member's body is ignored.
 */
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.FIELD})
public @interface Widen {
}
