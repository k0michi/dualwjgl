package com.koyomiji.lwjgl2w3.verify.bench;

import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryStack;

/** LWJGL 3 code using PointerBuffer, compiled against LWJGL 3.4.3: what the LWJGL 2 sync costs LWJGL 3's buffers. */
public final class PointerBufferBench3 {

	static long sink;

	public static void main(String[] args) {
		System.out.println("LWJGL 3 PointerBuffer on " + args[0] + ":");
		PointerBuffer p = PointerBuffer.allocateDirect(1024);
		Timer.time("relative put/get, 1024 elements", 2L * 1024 * 2000, () -> {
			long sum = 0;
			for (int r = 0; r < 2000; r++) {
				p.clear();
				while (p.hasRemaining()) {
					p.put(r);
				}
				p.flip();
				while (p.hasRemaining()) {
					sum += p.get();
				}
			}
			return sum;
		});
		Timer.time("absolute put/get, 1024 elements", 2L * 1024 * 2000, () -> {
			long sum = 0;
			for (int r = 0; r < 2000; r++) {
				for (int i = 0; i < 1024; i++) {
					p.put(i, r);
				}
				for (int i = 0; i < 1024; i++) {
					sum += p.get(i);
				}
			}
			return sum;
		});
		Timer.time("stack: mallocPointer, put, get, remaining", 2_000_000, () -> {
			long sum = 0;
			for (int r = 0; r < 2_000_000; r++) {
				try (MemoryStack s = MemoryStack.stackPush()) {
					PointerBuffer q = s.mallocPointer(4);
					q.put(0, r).put(1, r + 1);
					sum += q.get(1) + q.remaining();
				}
			}
			return sum;
		});
		Timer.time("slice", 2_000_000, () -> {
			long sum = 0;
			p.clear();
			for (int r = 0; r < 2_000_000; r++) {
				sum += p.position(r & 511).slice().capacity();
			}
			return sum;
		});
		if (sink == 42) {
			System.out.println();
		}
	}

}
