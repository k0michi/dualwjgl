package org.lwjgl.util.mapped;

import java.net.URL;
import java.net.URLClassLoader;

public class MappedObjectClassLoader extends URLClassLoader {
	private MappedObjectClassLoader() {
		super((URL[]) null);
	}

	public static boolean fork(Class<?> mainClass, String[] args) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	protected Class<?> loadMappedObject() throws ClassNotFoundException {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
		// TODO(port)
		throw new UnsupportedOperationException();
	}
}
