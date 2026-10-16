package org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Into;
import org.lwjgl.LWJGLException;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * LWJGL 2's ContextCapabilities constructor, merged into the generated class (its flags). LWJGL 2 loaded the context's
 * function pointers here; LWJGL 3 already did, so the flags are LWJGL 3's GLCapabilities flags of the same name for the
 * thread's current context. A flag LWJGL 3 has no field for (an extension it does not bind) stays false.
 */
@Into(ContextCapabilities.class)
final class ContextCapabilitiesFragment {

	ContextCapabilitiesFragment(boolean forwardCompatible) throws LWJGLException {
		GLCapabilities capabilities;
		try {
			capabilities = GL.getCapabilities();
		} catch (IllegalStateException e) {
			throw new LWJGLException("No OpenGL context found in the current thread.");
		}
		try {
			for (Field flag : ContextCapabilities.class.getDeclaredFields()) {
				if (flag.getType() != boolean.class || Modifier.isStatic(flag.getModifiers()) || !Modifier.isPublic(flag.getModifiers())) {
					continue;
				}
				Field lwjgl3;
				try {
					lwjgl3 = GLCapabilities.class.getField(flag.getName());
				} catch (NoSuchFieldException e) {
					continue;
				}
				if (lwjgl3.getType() == boolean.class && !Modifier.isStatic(lwjgl3.getModifiers())) {
					flag.setBoolean(this, lwjgl3.getBoolean(capabilities));
				}
			}
		} catch (IllegalAccessException e) {
			throw new LWJGLException(e);
		}
	}

}
