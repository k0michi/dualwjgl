package org.lwjgl.util;

import com.koyomiji.lwjgl2w3.inject.Generated;
import com.koyomiji.lwjgl2w3.inject.Todo;
import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import javax.sound.sampled.AudioInputStream;

@Generated
public class WaveData {
	public ByteBuffer data;
	public int format;
	public int samplerate;

	private WaveData() {
	}

	@Todo("port")
	public void dispose() {
		throw new UnsupportedOperationException();
	}

	@Todo("port")
	public static WaveData create(URL path) {
		throw new UnsupportedOperationException();
	}

	@Todo("port")
	public static WaveData create(String path) {
		throw new UnsupportedOperationException();
	}

	@Todo("port")
	public static WaveData create(InputStream is) {
		throw new UnsupportedOperationException();
	}

	@Todo("port")
	public static WaveData create(byte[] buffer) {
		throw new UnsupportedOperationException();
	}

	@Todo("port")
	public static WaveData create(ByteBuffer buffer) {
		throw new UnsupportedOperationException();
	}

	@Todo("port")
	public static WaveData create(AudioInputStream ais) {
		throw new UnsupportedOperationException();
	}
}
