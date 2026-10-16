package com.koyomiji.lwjgl2w3.verify;

import org.junit.jupiter.api.Test;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import static org.junit.jupiter.api.Assertions.*;

class Lwjgl2CoreTest {

	/** Guards the setup: these tests must run against the patched jars, never the original LWJGL 2. */
	@Test
	void runsAgainstPatchedJars() {
		String where = Sys.class.getProtectionDomain().getCodeSource().getLocation().toString();
		assertTrue(where.contains("/patched/"), where);
		assertTrue(RuntimeException.class.isAssignableFrom(LWJGLException.class));
	}

	@Test
	void bufferUtilsOffsets() {
		FloatBuffer f = BufferUtils.createFloatBuffer(8);
		f.position(3);
		assertEquals(2, BufferUtils.getElementSizeExponent(f));
		assertEquals(12, BufferUtils.getOffset(f));

		ByteBuffer b = BufferUtils.createByteBuffer(4);
		b.position(1);
		assertEquals(1, BufferUtils.getOffset(b));

		DoubleBuffer d = BufferUtils.createDoubleBuffer(1);
		assertEquals(3, BufferUtils.getElementSizeExponent(d));
	}

	@Test
	void bufferUtilsZeroesFromPosition() {
		IntBuffer i = BufferUtils.createIntBuffer(4);
		i.put(0, 7).put(3, 9);
		i.position(1);
		BufferUtils.zeroBuffer(i);
		assertEquals(7, i.get(0));
		assertEquals(0, i.get(3));
	}

	@Test
	void bufferUtilsHasPublicConstructor() {
		assertNotNull(new BufferUtils());
	}

	@Test
	void sysTimer() throws InterruptedException {
		assertEquals(1000L, Sys.getTimerResolution());
		long t0 = Sys.getTime();
		Thread.sleep(30);
		long t1 = Sys.getTime();
		assertTrue(t1 - t0 >= 20, "elapsed " + (t1 - t0));
	}

	@Test
	void sysInfo() {
		Sys.initialize();
		assertTrue(Sys.getVersion().startsWith("2.9"));
		assertEquals(System.getProperty("os.arch").contains("64"), Sys.is64Bit());
	}

	/** The link tests run without lwjgl-sdl: Sys falls back as LWJGL 2 does when the platform cannot. */
	@Test
	void sysDesktopFunctionsNeverThrow() {
		Sys.alert("lwjgl2w3", "Sys.alert from a test");
		Sys.alert(null, null);
		assertFalse(Sys.openURL("https://www.lwjgl.org"));
		assertNull(Sys.getClipboard());
	}

	@Test
	void lwjglExceptionCanBeCaughtAsChecked() {
		try {
			throwChecked();
			fail();
		} catch (LWJGLException e) {
			assertEquals("boom", e.getMessage());
		}
	}

	private static void throwChecked() throws LWJGLException {
		throw new LWJGLException("boom");
	}

}
