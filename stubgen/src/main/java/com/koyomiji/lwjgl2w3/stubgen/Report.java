package com.koyomiji.lwjgl2w3.stubgen;

import java.util.*;

/** What a run generated and what it left for hand-written code. */
final class Report {

	/** area -> {TODO stubs, delegations, unsupported} */
	private final Map<String, int[]> counts = new TreeMap<>();
	private final List<String> design = new ArrayList<>();

	void count(StubWriter w) {
		int[] c = counts.computeIfAbsent(w.area, k -> new int[3]);
		c[0] += w.todos;
		c[1] += w.delegations;
		c[2] += w.unsupported;
	}

	/** Something no stub can express, e.g. a superclass that conflicts with LWJGL 3's. */
	void needsDesign(String note) {
		design.add(note);
	}

	void print(Map<String, Integer> ruleHits, Set<String> forcePublic) {
		System.out.println("Generated members (TODO stubs / delegations / unsupported); the merger reports what hand-written code leaves:");
		int tt = 0, td = 0, tu = 0;
		for (Map.Entry<String, String> a : Areas.SCOPES.entrySet()) {
			int[] c = counts.getOrDefault(a.getKey(), new int[3]);
			System.out.printf("  %-8s %5d / %5d / %4d  %s%n", a.getKey(), c[0], c[1], c[2], a.getValue());
			tt += c[0];
			td += c[1];
			tu += c[2];
		}
		System.out.printf("  %-8s %5d / %5d / %4d%n", "total", tt, td, tu);
		System.out.println("By rule: " + ruleHits);
		System.out.println("Needs design (no stub generated):");
		design.stream().distinct().sorted().forEach(d -> System.out.println("  - " + d));
		System.out.println("Package-private in LWJGL 2, made public because inject classes mention them:");
		forcePublic.forEach(f -> System.out.println("  - " + f));
	}

}
