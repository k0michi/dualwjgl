package com.koyomiji.lwjgl2w3.stubgen;

import javax.lang.model.element.ExecutableElement;
import javax.lang.model.type.TypeKind;
import java.util.List;

/** A way to implement an LWJGL 2 static method with LWJGL 3 code, proven by native-call traces. */
interface Rule {

	/** Short name for the report, e.g. {@code R}. */
	String name();

	/** The statement implementing {@code target}, or null if this rule does not apply. */
	String apply(Target target);

	/** Whether the statement deliberately leaves the method unsupported rather than implementing it. */
	default boolean unsupported() {
		return false;
	}

	/** A rule's statement for a method. */
	record Implementation(String statement, Rule rule) {
	}

	/**
	 * An LWJGL 2 static method to implement.
	 *
	 * @param cls   the class it is merged into (internal name)
	 * @param calls its normalized native calls
	 * @param ret   its normalized return expression
	 */
	record Target(ExecutableElement method, String cls, String desc, List<String> calls, String ret) {

		String name() {
			return method.getSimpleName().toString();
		}

		boolean returns() {
			return method.getReturnType().getKind() != TypeKind.VOID;
		}

		/** A call to static method {@code owner.name(args)}, returned if the target returns something. */
		String call(String owner, String name, String args) {
			String call = owner.replace('/', '.').replace('$', '.') + "." + name + "(" + args + ");";
			return returns() ? "return " + call : call;
		}

	}

}
