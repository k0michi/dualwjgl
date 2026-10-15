package org.lwjgl.util;

import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import javax.sound.sampled.AudioInputStream;

public class WaveData {
	public ByteBuffer data;
	public int format;
	public int samplerate;

	private WaveData() {
	}

	public void dispose() {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static WaveData create(URL path) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static WaveData create(String path) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static WaveData create(InputStream is) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static WaveData create(byte[] buffer) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static WaveData create(ByteBuffer buffer) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}

	public static WaveData create(AudioInputStream ais) {
		// TODO(port)
		throw new UnsupportedOperationException();
	}
}
