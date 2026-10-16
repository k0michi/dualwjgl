package com.koyomiji.lwjgl2w3.verify;

import org.junit.jupiter.api.Test;
import org.lwjgl.openal.AL;
import org.lwjgl.openal.ALC;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import static org.junit.jupiter.api.Assertions.*;
import static org.lwjgl.openal.AL10.*;
import static org.lwjgl.openal.ALC10.*;

/** LWJGL 3's own OpenAL lifecycle, through the wrapped AL.destroy and ALC.destroy (ALSOFT_DRIVERS=null). */
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

			ALC.destroy();
			assertThrows(IllegalStateException.class, ALC::getFunctionProvider);
			assertThrows(IllegalStateException.class, AL::getCapabilities);
			ALC.create();
		}
	}

}
