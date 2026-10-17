package com.koyomiji.dualwjgl.verify.bench;

import org.lwjgl.BufferUtils;
import org.lwjgl.PointerBuffer;

import java.util.function.LongSupplier;

/** LWJGL 2 code using PointerBuffer, compiled against LWJGL 2.9.3: a plain buffer and a subclass (synced view). */
public final class PointerBufferBench2 {

	static long sink;

	static final class Sub extends PointerBuffer {
		Sub(int capacity) {
			super(BufferUtils.createByteBuffer(capacity * getPointerSize()));
		}
	}

	static LongSupplier loop(PointerBuffer p) {
		return () -> {
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
		};
	}

	static void time(String what, long ops, LongSupplier body) {
		double best = Double.MAX_VALUE;
		for (int i = 0; i < 15; i++) {
			long t0 = System.nanoTime();
			sink += body.getAsLong();
			double ns = (System.nanoTime() - t0) / (double)ops;
			if (i >= 5) {
				best = Math.min(best, ns);
			}
		}
		System.out.printf("  %-44s %6.2f ns/op%n", what, best);
	}

	public static void main(String[] args) {
		System.out.println("LWJGL 2 PointerBuffer on " + args[0] + ":");
		long ops = 2L * 1024 * 2000;
		time("new PointerBuffer(1024): put/get", ops, loop(new PointerBuffer(1024)));
		time("subclass (synced view): put/get", ops, loop(new Sub(1024)));
	}

}
