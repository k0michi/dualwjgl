package com.koyomiji.lwjgl2w3.stubgen;

import java.util.*;

/** What a run generated and what it left for hand-written code. */
final class Report {

	/** area -> {TODO stubs, delegations} */
	private final Map<String, int[]> counts = new TreeMap<>();
	private final List<String> design = new ArrayList<>();

	void count(StubWriter w) {
		int[] c = counts.computeIfAbsent(w.area, k -> new int[2]);
		c[0] += w.todos;
		c[1] += w.delegations;
	}

	/** Something no stub can express, e.g. a superclass that conflicts with LWJGL 3's. */
	void needsDesign(String note) {
		design.add(note);
	}

	void print(Map<String, Integer> ruleHits, Set<String> forcePublic) {
		System.out.println("Generated members (TODO stubs / delegations); the merger reports what hand-written code leaves:");
		int tt = 0, td = 0;
		for (Map.Entry<String, String> a : Areas.SCOPES.entrySet()) {
			int[] c = counts.getOrDefault(a.getKey(), new int[2]);
			System.out.printf("  %-8s %5d / %5d  %s%n", a.getKey(), c[0], c[1], a.getValue());
			tt += c[0];
			td += c[1];
		}
		System.out.printf("  %-8s %5d / %5d%n", "total", tt, td);
		System.out.println("Delegations by rule: " + ruleHits);
		System.out.println("Needs design (no stub generated):");
		design.stream().distinct().sorted().forEach(d -> System.out.println("  - " + d));
		System.out.println("Package-private in LWJGL 2, made public because inject classes mention them:");
		forcePublic.forEach(f -> System.out.println("  - " + f));
	}

}
