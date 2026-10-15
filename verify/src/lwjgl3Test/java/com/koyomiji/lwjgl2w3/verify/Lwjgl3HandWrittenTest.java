package com.koyomiji.lwjgl2w3.verify;

import org.junit.jupiter.api.Test;
import org.lwjgl.PointerBuffer;
import org.lwjgl.opencl.CLContextCallback;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;

import static org.junit.jupiter.api.Assertions.*;
import static org.lwjgl.system.MemoryUtil.*;

class Lwjgl3HandWrittenTest {

	@Test
	void contextCallbackFromLambda() {
		String[] got = new String[1];
		try (CLContextCallback cb = CLContextCallback.create((errinfo, private_info, size, user_data) -> got[0] = memUTF8(errinfo));
		     MemoryStack stack = MemoryStack.stackPush()) {
			JNI.invokePPPPV(memAddress(stack.UTF8("from lambda")), NULL, 0L, 0L, cb.address());
		}
		assertEquals("from lambda", got[0]);
	}

	@Test
	void contextCallbackOverridingInvoke() {
		long[] got = new long[1];
		try (CLContextCallback cb = new CLContextCallback() {
			@Override
			public void invoke(long errinfo, long private_info, long size, long user_data) {
				got[0] = user_data;
			}
		}; MemoryStack stack = MemoryStack.stackPush()) {
			JNI.invokePPPPV(memAddress(stack.UTF8("x")), NULL, 0L, 99L, cb.address());
		}
		assertEquals(99L, got[0]);
	}

	@Test
	void pointerBufferFactoriesStillWork() {
		PointerBuffer pb = PointerBuffer.allocateDirect(2);
		pb.put(1, 5L);
		assertEquals(5L, pb.get(1));
	}

}
