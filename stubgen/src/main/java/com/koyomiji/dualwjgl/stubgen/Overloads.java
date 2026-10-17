package com.koyomiji.dualwjgl.stubgen;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/** Decides which LWJGL 2 members must be @Hidden next to LWJGL 3's overloads. */
final class Overloads {

	static final Map<String, String> WIDENING = Map.of(
		"B", "BSIJFD", "S", "SIJFD", "C", "CIJFD", "I", "IJFD", "J", "JFD", "F", "FD", "D", "D", "Z", "Z");

	private final Lwjgl3Api lwjgl3;

	Overloads(Lwjgl3Api lwjgl3) {
		this.lwjgl3 = lwjgl3;
	}

	/**
	 * Hide from javac (keep linkable): when LWJGL 3 has the same parameters with another return type, or when this
	 * overload is more specific than an LWJGL 3 one and would silently take over LWJGL 3 calls.
	 */
	boolean needsHidden(Set<String> methods3, String name, String desc) {
		String ps = desc.substring(0, desc.indexOf(')') + 1);
		List<String> p2 = params(desc);
		for (String m : methods3) {
			if (!m.startsWith(name + "(")) {
				continue;
			}
			String d3 = m.substring(name.length());
			if (d3.startsWith(ps)) {
				return true;
			}
			List<String> p3 = params(d3);
			if (p3.size() == p2.size()) {
				boolean all = true;
				for (int i = 0; i < p2.size() && all; i++) {
					all = assignable(p2.get(i), p3.get(i));
				}
				if (all) {
					return true;
				}
			}
		}
		return false;
	}

	static List<String> params(String desc) {
		List<String> out = new ArrayList<>();
		String s = desc.substring(1, desc.indexOf(')'));
		for (int i = 0; i < s.length(); ) {
			int j = i;
			while (s.charAt(j) == '[') {
				j++;
			}
			j = s.charAt(j) == 'L' ? s.indexOf(';', j) + 1 : j + 1;
			out.add(s.substring(i, j));
			i = j;
		}
		return out;
	}

	private boolean assignable(String a, String b) {
		if (a.equals(b)) {
			return true;
		}
		if (a.length() == 1 || b.length() == 1) {
			return a.length() == 1 && b.length() == 1 && WIDENING.get(a).contains(b);
		}
		if (b.equals("Ljava/lang/Object;")) {
			return true;
		}
		if (a.startsWith("[") || b.startsWith("[")) {
			return false;
		}
		String an = a.substring(1, a.length() - 1), bn = b.substring(1, b.length() - 1);
		if (an.equals("java/lang/String") && bn.equals("java/lang/CharSequence")) {
			return true;
		}
		if (an.startsWith("java/nio/") && an.endsWith("Buffer") && bn.equals("java/nio/Buffer")) {
			return true;
		}
		return lwjgl3.contains(an) && lwjgl3.supers(an).contains(bn);
	}

}
