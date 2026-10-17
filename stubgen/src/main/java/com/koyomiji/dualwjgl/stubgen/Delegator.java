package com.koyomiji.dualwjgl.stubgen;

import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/** Implements LWJGL 2 static methods with the first {@link Rule} that applies. */
final class Delegator {

	private final Lwjgl2Api lwjgl2;
	private final NativeTrace trace2;
	private final List<Rule> rules;
	private final Diagnostics diagnostics;
	/** rule -> methods it implemented */
	final Map<String, Integer> hits = new TreeMap<>();

	Delegator(Lwjgl2Api lwjgl2, NativeTrace trace2, List<Rule> rules, Diagnostics diagnostics) {
		this.lwjgl2 = lwjgl2;
		this.trace2 = trace2;
		this.rules = rules;
		this.diagnostics = diagnostics;
	}

	/** How a rule implements {@code m}, merged into {@code cls}, or null to leave it a stub. */
	Rule.Implementation delegate(ExecutableElement m, String cls, String desc) {
		if (!m.getModifiers().contains(Modifier.STATIC) || !m.getTypeParameters().isEmpty()) {
			return null;
		}
		String name = m.getSimpleName().toString();
		NativeTrace.Summary s2 = trace2.summarize(lwjgl2.internalName((TypeElement)m.getEnclosingElement()), name, desc, 0);
		if (s2.unresolved || s2.natives.isEmpty()) {
			diagnostics.untraced(cls, name, desc, s2);
			return null;
		}
		Rule.Target target = new Rule.Target(m, cls, desc, NativeTrace.norm(s2), NativeTrace.normRet(s2));
		for (Rule rule : rules) {
			String statement = rule.apply(target);
			if (statement != null) {
				hits.merge(rule.name(), 1, Integer::sum);
				return new Rule.Implementation(statement, rule);
			}
		}
		diagnostics.unmatched(target, s2);
		return null;
	}

}
