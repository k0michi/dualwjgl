package com.koyomiji.dualwjgl.verify;

import org.junit.jupiter.api.Test;
import org.lwjgl.BufferUtils;
import org.lwjgl.openal.AL;
import org.lwjgl.openal.AL10;
import org.lwjgl.openal.ALC10;
import org.lwjgl.openal.ALCcontext;
import org.lwjgl.openal.ALCdevice;

import java.nio.IntBuffer;

import static org.junit.jupiter.api.Assertions.*;

/** LWJGL 2's AL startup and ALC object model, on OpenAL Soft's null backend (ALSOFT_DRIVERS=null). */
class Lwjgl2OpenALTest {

	@Test
	void createOpensDeviceAndContext() throws Exception {
		AL.create();
		ALCdevice device = AL.getDevice();
		ALCcontext context = AL.getContext();
		try {
			assertTrue(AL.isCreated());
			assertTrue(device.isValid() && context.isValid());
			assertSame(context, currentContext());
			assertSame(device, ALC10.alcGetContextsDevice(context));
			assertNotNull(ALC10.alcGetString(device, ALC10.ALC_DEVICE_SPECIFIER));
			IntBuffer version = BufferUtils.createIntBuffer(1);
			ALC10.alcGetInteger(device, ALC10.ALC_MAJOR_VERSION, version);
			assertEquals(1, version.get(0));
			assertEquals(ALC10.ALC_NO_ERROR, ALC10.alcGetError(device));

			int source = AL10.alGenSources();
			AL10.alSourcef(source, AL10.AL_GAIN, 0.5f);
			assertEquals(0.5f, AL10.alGetSourcef(source, AL10.AL_GAIN));
			AL10.alDeleteSources(source);
			assertEquals(AL10.AL_NO_ERROR, AL10.alGetError());

			assertThrows(IllegalStateException.class, AL::create);
		} finally {
			AL.destroy();
		}
		assertFalse(AL.isCreated());
		assertNull(AL.getDevice());
		assertNull(AL.getContext());
		assertFalse(device.isValid() || context.isValid());

		AL.create(null, -1, -1, false);
		assertTrue(AL.getContext().isValid());
		AL.destroy();
	}

	/*
	 * LWJGL 2's alcOpenDevice(String) and alcGetCurrentContext() are hidden: recompiled against the patched jars, a call
	 * resolves to LWJGL 3's (which return a long), so both suites reach LWJGL 2's by reflection.
	 */

	private static ALCdevice openDevice(String name) throws Exception {
		return (ALCdevice)ALC10.class.getMethod("alcOpenDevice", String.class).invoke(null, name);
	}

	private static ALCcontext currentContext() throws Exception {
		for (java.lang.reflect.Method m : ALC10.class.getMethods()) {
			if (m.getName().equals("alcGetCurrentContext") && m.getReturnType() == ALCcontext.class) {
				return (ALCcontext)m.invoke(null);
			}
		}
		throw new NoSuchMethodException("alcGetCurrentContext");
	}

	@Test
	void ownDeviceAndContext() throws Exception {
		AL.create(null, -1, -1, false, false);
		try {
			assertTrue(AL.isCreated());
			assertNull(AL.getDevice());
			assertNull(currentContext());

			ALCdevice device = openDevice(null);
			ALCcontext context = ALC10.alcCreateContext(device, null);
			assertEquals(ALC10.ALC_TRUE, ALC10.alcMakeContextCurrent(context));
			assertSame(context, currentContext());
			int buffer = AL10.alGenBuffers();
			assertTrue(AL10.alIsBuffer(buffer));
			AL10.alDeleteBuffers(buffer);

			ALC10.alcMakeContextCurrent(null);
			assertNull(currentContext());
			ALC10.alcDestroyContext(context);
			assertFalse(context.isValid());
			assertTrue(ALC10.alcCloseDevice(device));
			assertFalse(device.isValid());
		} finally {
			AL.destroy();
		}
	}

}
