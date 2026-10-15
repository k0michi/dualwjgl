package org.lwjgl.util.mapped;

import com.koyomiji.lwjgl2w3.inject.Generated;
import com.koyomiji.lwjgl2w3.inject.Todo;
import java.net.URL;
import java.net.URLClassLoader;

@Generated
public class MappedObjectClassLoader extends URLClassLoader {
	private MappedObjectClassLoader() {
		super((URL[]) null);
	}

	@Todo("port")
	public static boolean fork(Class<?> mainClass, String[] args) {
		throw new UnsupportedOperationException();
	}

	@Todo("port")
	protected Class<?> loadMappedObject() throws ClassNotFoundException {
		throw new UnsupportedOperationException();
	}

	@Todo("port")
	protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
		throw new UnsupportedOperationException();
	}
}
