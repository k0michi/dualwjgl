package com.koyomiji.dualwjgl.stubgen;

import javax.lang.model.element.*;
import javax.lang.model.type.*;
import javax.lang.model.util.Elements;
import java.util.*;
import java.util.stream.Collectors;

/** How one source file writes types: simple names with imports where unambiguous, qualified names otherwise. */
final class TypeNames {

	private final String pkg;
	private final Elements elements;
	/** simple name -> the qualified name written as that simple name */
	private final Map<String, String> taken = new HashMap<>();
	private final TreeSet<String> imports = new TreeSet<>();

	TypeNames(String pkg, Elements elements) {
		this.pkg = pkg;
		this.elements = elements;
	}

	/** Reserves the simple names declared in this file (a class and its nested types). */
	void declare(TypeElement te) {
		taken.put(te.getSimpleName().toString(), te.getQualifiedName().toString());
		for (Element e : te.getEnclosedElements()) {
			if (e instanceof TypeElement n) {
				declare(n);
			}
		}
	}

	/** Reserves {@code simple} for this file's own class, e.g. a fragment named like its target. */
	void declare(String simple) {
		taken.put(simple, pkg + "." + simple);
	}

	void addImport(String qualifiedName) {
		imports.add(qualifiedName);
	}

	SortedSet<String> imports() {
		return imports;
	}

	String name(TypeElement te) {
		if (te.getNestingKind() == NestingKind.MEMBER) {
			return name((TypeElement)te.getEnclosingElement()) + "." + te.getSimpleName();
		}
		String fqn = te.getQualifiedName().toString();
		String simple = te.getSimpleName().toString();
		String p = elements.getPackageOf(te).getQualifiedName().toString();
		String owner = taken.get(simple);
		if (owner != null) {
			return owner.equals(fqn) ? simple : fqn;
		}
		taken.put(simple, fqn);
		if (!p.equals("java.lang") && !p.equals(pkg)) {
			imports.add(fqn);
		}
		return simple;
	}

	String type(TypeMirror t) {
		return switch (t.getKind()) {
			case ARRAY -> type(((ArrayType)t).getComponentType()) + "[]";
			case DECLARED -> {
				DeclaredType dt = (DeclaredType)t;
				String base = name((TypeElement)dt.asElement());
				yield dt.getTypeArguments().isEmpty() ? base
					: base + dt.getTypeArguments().stream().map(this::type).collect(Collectors.joining(", ", "<", ">"));
			}
			case WILDCARD -> {
				WildcardType wt = (WildcardType)t;
				yield wt.getExtendsBound() != null ? "? extends " + type(wt.getExtendsBound())
					: wt.getSuperBound() != null ? "? super " + type(wt.getSuperBound()) : "?";
			}
			default -> t.toString();
		};
	}

	/** {@code <T extends A & B> } with a trailing space, or "" when there are none. */
	String typeParams(List<? extends TypeParameterElement> tps) {
		if (tps.isEmpty()) {
			return "";
		}
		return tps.stream().map(tp -> {
			List<String> bounds = tp.getBounds().stream()
				.filter(b -> !b.toString().equals("java.lang.Object")).map(this::type).toList();
			return tp.getSimpleName() + (bounds.isEmpty() ? "" : " extends " + String.join(" & ", bounds));
		}).collect(Collectors.joining(", ", "<", "> "));
	}

	String annotation(AnnotationMirror am) {
		String values = am.getElementValues().entrySet().stream()
			.map(e -> e.getKey().getSimpleName() + " = " + value(e.getValue())).collect(Collectors.joining(", "));
		return "@" + type(am.getAnnotationType()) + (values.isEmpty() ? "" : "(" + values + ")");
	}

	String value(AnnotationValue v) {
		Object o = v.getValue();
		if (o instanceof VariableElement c) {
			return type(c.asType()) + "." + c.getSimpleName();
		} else if (o instanceof TypeMirror t) {
			return type(t) + ".class";
		} else if (o instanceof AnnotationMirror am) {
			return annotation(am);
		} else if (o instanceof List<?> l) {
			return l.stream().map(x -> value((AnnotationValue)x)).collect(Collectors.joining(", ", "{", "}"));
		}
		return v.toString();
	}

}
