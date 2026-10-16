package com.koyomiji.lwjgl2w3.inject;

import java.lang.annotation.*;

/**
 * The target LWJGL 3 class already declares this method (same name and descriptor); the annotated method replaces it
 * and can call the original. The merger renames LWJGL 3's method to {@code <name>$lwjgl3} (synthetic, same access) and
 * adds this one under the original name, so every caller, inside LWJGL 3 or not, goes through it. To call the
 * original, declare {@code abstract <type> <name>$lwjgl3(<parameters>)} in the inject class.
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.METHOD)
public @interface Wrap {
}
