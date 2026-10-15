package org.lwjgl.opencl.api;

public interface Filter<T> {
	boolean accept(T object);
}
