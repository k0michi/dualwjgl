package com.koyomiji.dualwjgl.verify;

import org.junit.jupiter.api.Test;
import org.lwjgl.openal.AL;
import org.lwjgl.openal.ALC;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import static org.junit.jupiter.api.Assertions.*;
import static org.lwjgl.openal.AL10.*;
import static org.lwjgl.openal.ALC10.*;

/**
 * LWJGL 3's own OpenAL lifecycle, twice, with the LWJGL 2 code merged in (ALSOFT_DRIVERS=null). Not ALC.destroy and
 * ALC.create again: LWJGL 3 keeps the first library's function pointers, so that crashes where it really unloads (Linux).
 */
class Lwjgl3OpenALTest {

	@Test
	void lifecycleUnchanged() {
		for (int i = 0; i < 2; i++) {
			long device = alcOpenDevice((ByteBuffer)null);
			assertNotEquals(0L, device);
			long context = alcCreateContext(device, (IntBuffer)null);
			assertTrue(alcMakeContextCurrent(context));
			AL.createCapabilities(ALC.createCapabilities(device));
			int source = alGenSources();
			assertTrue(alIsSource(source));
			alDeleteSources(source);
			alcMakeContextCurrent(0L);
			alcDestroyContext(context);
			assertTrue(alcCloseDevice(device));
		}
	}

}
