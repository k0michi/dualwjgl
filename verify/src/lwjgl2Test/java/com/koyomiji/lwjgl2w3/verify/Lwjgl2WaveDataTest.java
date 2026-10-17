package com.koyomiji.lwjgl2w3.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.lwjgl.openal.AL10;
import org.lwjgl.util.WaveData;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.*;

/** LWJGL 2's WaveData (lwjgl_util), whose create(URL) reads through javax.sound.sampled instead of com.sun.media.sound. */
class Lwjgl2WaveDataTest {

	/** A canonical PCM WAVE file: RIFF header, fmt chunk, data chunk. */
	private static byte[] wave(int channels, int bits, int rate, byte[] samples) {
		ByteBuffer b = ByteBuffer.allocate(44 + samples.length).order(ByteOrder.LITTLE_ENDIAN);
		b.put("RIFF".getBytes()).putInt(36 + samples.length).put("WAVE".getBytes());
		b.put("fmt ".getBytes()).putInt(16).putShort((short)1).putShort((short)channels).putInt(rate)
			.putInt(rate * channels * bits / 8).putShort((short)(channels * bits / 8)).putShort((short)bits);
		b.put("data".getBytes()).putInt(samples.length).put(samples);
		return b.array();
	}

	private static final byte[] MONO16 = {0x34, 0x12, (byte)0xCD, (byte)0xAB}; // 0x1234, 0xABCD, little-endian

	private static void checkMono16(WaveData data) {
		assertNotNull(data);
		assertEquals(AL10.AL_FORMAT_MONO16, data.format);
		assertEquals(22050, data.samplerate);
		assertEquals(4, data.data.remaining());
		assertTrue(data.data.isDirect());
		ByteBuffer samples = data.data.duplicate().order(ByteOrder.nativeOrder());
		assertEquals((short)0x1234, samples.getShort(0));
		assertEquals((short)0xABCD, samples.getShort(2));
	}

	@Test
	void fromUrl(@TempDir File dir) throws Exception {
		File file = new File(dir, "mono16.wav");
		Files.write(file.toPath(), wave(1, 16, 22050, MONO16));
		checkMono16(WaveData.create(file.toURI().toURL()));
	}

	@Test
	void fromBytesAndStreams() {
		byte[] wav = wave(1, 16, 22050, MONO16);
		checkMono16(WaveData.create(wav));
		checkMono16(WaveData.create(new java.io.BufferedInputStream(new ByteArrayInputStream(wav))));
		ByteBuffer direct = ByteBuffer.allocateDirect(wav.length);
		direct.put(wav).flip();
		checkMono16(WaveData.create(direct));
	}

	@Test
	void stereo8() {
		WaveData data = WaveData.create(wave(2, 8, 8000, new byte[] {1, 2, 3, 4}));
		assertNotNull(data);
		assertEquals(AL10.AL_FORMAT_STEREO8, data.format);
		assertEquals(8000, data.samplerate);
		assertEquals(4, data.data.remaining());
		assertEquals(3, data.data.get(2));
	}

	@Test
	void notAWave(@TempDir File dir) throws Exception {
		File file = new File(dir, "junk.wav");
		Files.write(file.toPath(), new byte[] {1, 2, 3, 4, 5, 6, 7, 8});
		assertNull(WaveData.create(file.toURI().toURL()));
		assertNull(WaveData.create(new byte[] {1, 2, 3}));
	}

}
