package com.koyomiji.lwjgl2w3.verify.bench;

import java.util.function.LongSupplier;

/** Best of the last 10 of 15 runs, in ns per operation: enough to see the sync's cost, not a JMH replacement. */
final class Timer {

	static long sink;

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

	private Timer() {
	}

}
