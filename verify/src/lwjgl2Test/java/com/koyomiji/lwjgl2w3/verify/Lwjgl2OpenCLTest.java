package com.koyomiji.lwjgl2w3.verify;

import org.junit.jupiter.api.Test;
import org.lwjgl.BufferUtils;
import org.lwjgl.PointerBuffer;
import org.lwjgl.opencl.CL;
import org.lwjgl.opencl.CL10;
import org.lwjgl.opencl.CLEvent;
import org.lwjgl.opencl.CLEventCallback;
import org.lwjgl.opencl.CLNativeKernel;
import org.lwjgl.opencl.CLPlatform;

import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

/** LWJGL 2's CL object model: CallbackUtil's references, the callbacks' trampolines, platform registration. */
class Lwjgl2OpenCLTest {

	// CallbackUtil is package-private: reach it reflectively

	private static Method callbackUtil(String name, Class<?>... types) throws Exception {
		Method m = Class.forName("org.lwjgl.opencl.CallbackUtil").getDeclaredMethod(name, types);
		m.setAccessible(true);
		return m;
	}

	private static long createGlobalRef(Object obj) throws Exception {
		return (Long)callbackUtil("createGlobalRef", Object.class).invoke(null, obj);
	}

	private static Object getObject(long ref) throws Exception {
		return callbackUtil("getObject", long.class).invoke(null, ref);
	}

	@Test
	void globalRefs() throws Exception {
		Object obj = new Object();
		long ref = createGlobalRef(obj);
		assertNotEquals(0L, ref);
		assertSame(obj, getObject(ref));
		assertEquals(0L, createGlobalRef(null));
		callbackUtil("checkCallback", int.class, long.class).invoke(null, 0, ref);
		assertSame(obj, getObject(ref), "kept on success");
		callbackUtil("checkCallback", int.class, long.class).invoke(null, -1, ref);
		assertNull(getObject(ref), "deleted on error");
	}

	@Test
	void eventCallbackDeletesItsReference() throws Exception {
		final int[] got = {0};
		CLEventCallback cb = new CLEventCallback() {
			@Override
			protected void handleMessage(CLEvent event, int event_command_exec_status) {
				assertNull(event); // no registry: not set by clSetEventCallback
				got[0] = event_command_exec_status;
			}
		};
		long ref = createGlobalRef(cb);
		upcall("invokePPV", 0x1000L, 3, ref, cb.getPointer());
		assertEquals(3, got[0]);
		assertNull(getObject(ref));
	}

	@Test
	void nativeKernelDecodesArgs() throws Exception {
		final ByteBuffer[][] got = new ByteBuffer[1][];
		CLNativeKernel kernel = new CLNativeKernel() {
			@Override
			protected void execute(ByteBuffer[] memobjs) {
				got[0] = memobjs;
			}
		};
		long ref = createGlobalRef(kernel);
		int ps = PointerBuffer.getPointerSize();
		ByteBuffer mem0 = BufferUtils.createByteBuffer(16);
		ByteBuffer mem1 = BufferUtils.createByteBuffer(32);
		// APIUtil.getNativeKernelArgs's layout, with the pointers the implementation would put in
		ByteBuffer args = BufferUtils.createByteBuffer(8 + 4 + 2 * (4 + ps));
		args.putLong(0, ref).putInt(8, 2);
		args.putInt(12, 16);
		putPointer(args, 16, address(mem0));
		args.putInt(16 + ps, 32);
		putPointer(args, 20 + ps, address(mem1));
		upcall("invokePV", address(args), kernel.getPointer());
		assertEquals(2, got[0].length);
		assertEquals(16, got[0][0].capacity());
		assertEquals(address(mem0), address(got[0][0]));
		assertEquals(32, got[0][1].capacity());
		assertEquals(address(mem1), address(got[0][1]));
		assertNull(getObject(ref));
	}

	private static void putPointer(ByteBuffer b, int index, long pointer) {
		if (PointerBuffer.is64Bit()) {
			b.putLong(index, pointer);
		} else {
			b.putInt(index, (int)pointer);
		}
	}

	@Test
	void platformsRegistered() throws Exception {
		// the only test here that loads CL: explicit init leaves it to CL.create(), which an LWJGL 2 program calls
		assertFalse(CL.isCreated());
		assumeTrue(openCL(), "no OpenCL");
		IntBuffer count = BufferUtils.createIntBuffer(1);
		assertEquals(CL10.CL_SUCCESS, CL10.clGetPlatformIDs(null, count));
		assumeTrue(count.get(0) > 0, "no OpenCL platform");
		PointerBuffer ids = BufferUtils.createPointerBuffer(count.get(0));
		assertEquals(CL10.CL_SUCCESS, CL10.clGetPlatformIDs(ids, (IntBuffer)null));

		List<CLPlatform> platforms = CLPlatform.getPlatforms();
		assertEquals(count.get(0), platforms.size());
		for (int i = 0; i < platforms.size(); i++) {
			assertEquals(ids.get(i), platforms.get(i).getPointer());
			assertSame(platforms.get(i), CLPlatform.getCLPlatform(ids.get(i)));
		}
		assertTrue(CL.isCreated());

		// LWJGL 2's static extension flags, which CLPlatformCapabilities reads, set as CLCapabilities initializes
		java.lang.reflect.Field icd = Class.forName("org.lwjgl.opencl.CLCapabilities").getDeclaredField("CL_KHR_icd");
		icd.setAccessible(true);
		assertTrue(icd.getBoolean(null));
	}

	/** As an LWJGL 2 program: CL.create() loads the library (the suite sets org.lwjgl.opencl.explicitInit). */
	private static boolean openCL() {
		try {
			CL.create();
			return true;
		} catch (Throwable e) {
			System.err.println("OpenCL unavailable: " + e);
			return false;
		}
	}

	// LWJGL 2 has no API to call a function pointer, so play the OpenCL driver through LWJGL 3 reflectively.

	private static void upcall(String name, long event, int status, long user_data, long function) throws Exception {
		Class.forName("org.lwjgl.system.JNI").getMethod(name, long.class, int.class, long.class, long.class)
			.invoke(null, event, status, user_data, function);
	}

	private static void upcall(String name, long a, long function) throws Exception {
		Class.forName("org.lwjgl.system.JNI").getMethod(name, long.class, long.class).invoke(null, a, function);
	}

	private static long address(ByteBuffer buffer) throws Exception {
		Method m = Class.forName("org.lwjgl.system.MemoryUtil").getMethod("memAddress", ByteBuffer.class);
		return (Long)m.invoke(null, buffer);
	}

}
