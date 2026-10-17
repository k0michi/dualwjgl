package org.lwjgl.util.mapped;

import com.koyomiji.dualwjgl.inject.Generated;
import java.net.URL;
import java.net.URLClassLoader;

@Generated
public class MappedObjectClassLoader extends URLClassLoader {
	private MappedObjectClassLoader() {
		super((URL[]) null);
	}

	public static boolean fork(Class<?> mainClass, String[] args) {
		throw new UnsupportedOperationException("org.lwjgl.util.mapped is not supported");
	}

	protected Class<?> loadMappedObject() throws ClassNotFoundException {
		throw new UnsupportedOperationException("org.lwjgl.util.mapped is not supported");
	}

	protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
		throw new UnsupportedOperationException("org.lwjgl.util.mapped is not supported");
	}
}
