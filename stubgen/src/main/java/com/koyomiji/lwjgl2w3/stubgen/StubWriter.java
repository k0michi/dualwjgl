package com.koyomiji.lwjgl2w3.stubgen;

import javax.lang.model.element.*;
import javax.lang.model.type.*;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/** Writes one generated source file: a whole LWJGL 2 class, or a fragment of members for an LWJGL 3 class. */
final class StubWriter {

	private static final String THROW = "throw new UnsupportedOperationException();";

	/**
	 * Packages and whole classes compat does not support (DEVIATION(out-of-scope)): their members are generated
	 * throwing, without @Todo. org.lwjgl.util.mapped rewrites classes at run time with an ASM prerelease and reaches
	 * memory through sun.misc.Unsafe; XRandR is LWJGL 2's Linux display internals, over the xrandr command.
	 */
	static final Set<String> UNSUPPORTED = Set.of("org.lwjgl.util.mapped", "org.lwjgl.opengl.XRandR");

	/** What the current whole class is unsupported as (its package, or its own name), or null. */
	private String unsupportedAs;

	private final Lwjgl2Api lwjgl2;
	private final Set<String> forcePublic;
	final String pkg;
	final String area;
	final TypeNames names;
	private final Code code = new Code();
	private final Delegator delegator;
	int todos, delegations, unsupported, members;

	/** {@code delegator}: implements methods of whole classes by rule; fragments pass implementations explicitly. */
	StubWriter(Lwjgl2Api lwjgl2, Set<String> forcePublic, String pkg, String area, Delegator delegator) {
		this.lwjgl2 = lwjgl2;
		this.delegator = delegator;
		this.forcePublic = forcePublic;
		this.pkg = pkg;
		this.area = area;
		this.names = new TypeNames(pkg, lwjgl2.elements);
	}

	String file() {
		StringBuilder sb = new StringBuilder("package ").append(pkg).append(";\n\n");
		if (!names.imports().isEmpty()) {
			names.imports().forEach(i -> sb.append("import ").append(i).append(";\n"));
			sb.append('\n');
		}
		return sb.append(code).toString();
	}

	void openFragment(String simple) {
		names.declare(simple);
		code.open("public final class " + simple);
	}

	/** A fragment in the target's package: {@code @Generated @Into(Target.class) final class TargetGenerated}. */
	void openFragmentInto(String name, String target) {
		names.declare(name);
		annotate("Generated");
		code.line("@" + annotationName("Into") + "(" + target + ".class)");
		code.open("final class " + name);
	}

	private String annotationName(String name) {
		names.addImport(StubGen.INJECT_PACKAGE + "." + name);
		return name;
	}

	void closeFragment() {
		code.close();
	}

	/** {@code @name} from inject-api. */
	private void annotate(String name) {
		names.addImport(StubGen.INJECT_PACKAGE + "." + name);
		code.line("@" + name);
	}

	private boolean unsupportedPackage() {
		return unsupportedAs != null;
	}

	/** The LWJGL 2 class whose stubs come next, nested classes included. */
	void unsupportedFor(String qualifiedName) {
		unsupportedAs = UNSUPPORTED.contains(pkg) ? pkg : UNSUPPORTED.contains(qualifiedName) ? qualifiedName : null;
	}

	/** The body of a member left unimplemented: @Todo, or for an unsupported package a throw saying so. */
	private String unimplemented() {
		return unsupportedPackage() ? "throw new UnsupportedOperationException(\"" + unsupportedAs + " is not supported\");" : THROW;
	}

	private void todo() {
		if (unsupportedPackage()) {
			unsupported++;
			return;
		}
		todos++;
		names.addImport(StubGen.INJECT_PACKAGE + ".Todo");
		code.line("@Todo(\"" + area + "\")");
	}

	private void deprecated(Element e) {
		if (e.getAnnotation(Deprecated.class) != null) {
			code.line("@Deprecated");
		}
	}

	private static String modifiers(Element e, boolean inInterface) {
		if (inInterface) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		for (Modifier m : List.of(Modifier.PUBLIC, Modifier.PROTECTED, Modifier.PRIVATE, Modifier.ABSTRACT, Modifier.STATIC, Modifier.FINAL)) {
			if (e.getModifiers().contains(m)) {
				sb.append(m).append(' ');
			}
		}
		return sb.toString();
	}

	/** A whole LWJGL 2 class (and its nested API types), with stubs for its constructors and methods. */
	void type(TypeElement te) {
		if (te.getNestingKind() != NestingKind.MEMBER) {
			names.declare(te);
		}
		names.addImport(StubGen.INJECT_PACKAGE + ".Generated");
		code.line("@Generated");
		deprecated(te);
		for (AnnotationMirror am : te.getAnnotationMirrors()) {
			if (am.getAnnotationType().toString().startsWith("java.lang.annotation.")) {
				code.line(names.annotation(am));
			}
		}
		boolean parentItf = te.getNestingKind() == NestingKind.MEMBER && te.getEnclosingElement().getKind().isInterface();
		String kind = switch (te.getKind()) {
			case INTERFACE -> "interface";
			case ANNOTATION_TYPE -> "@interface";
			default -> "class";
		};
		StringBuilder header = new StringBuilder();
		if (forcePublic.contains(te.getQualifiedName().toString())) {
			header.append("public ");
		}
		if (!parentItf) {
			for (Modifier m : List.of(Modifier.PUBLIC, Modifier.PROTECTED, Modifier.PRIVATE, Modifier.STATIC, Modifier.FINAL)) {
				if (te.getModifiers().contains(m)) {
					header.append(m).append(' ');
				}
			}
			if (kind.equals("class") && te.getModifiers().contains(Modifier.ABSTRACT)) {
				header.append("abstract ");
			}
		}
		header.append(kind).append(' ').append(te.getSimpleName()).append(names.typeParams(te.getTypeParameters()).stripTrailing());
		if (kind.equals("class") && te.getSuperclass().getKind() == TypeKind.DECLARED
			&& !te.getSuperclass().toString().equals("java.lang.Object")) {
			header.append(" extends ").append(names.type(te.getSuperclass()));
		}
		if (!te.getInterfaces().isEmpty() && !kind.equals("@interface")) {
			header.append(kind.equals("interface") ? " extends " : " implements ")
				.append(te.getInterfaces().stream().map(names::type).collect(Collectors.joining(", ")));
		}
		code.open(header.toString());

		boolean itf = te.getKind().isInterface();
		boolean first = true;
		for (Element e : te.getEnclosedElements()) {
			if (e.getKind() == ElementKind.FIELD && Lwjgl2Api.isApi(e)) {
				field((VariableElement)e, itf);
				first = false;
			}
		}
		if (kind.equals("class")) {
			List<ExecutableElement> visible = te.getEnclosedElements().stream()
				.filter(e -> e.getKind() == ElementKind.CONSTRUCTOR && !e.getModifiers().contains(Modifier.PRIVATE))
				.map(e -> (ExecutableElement)e).toList();
			if (!first) {
				code.blank();
			}
			if (visible.isEmpty()) {
				code.open("private " + te.getSimpleName() + "()");
				superCall(te);
				code.close();
			}
			for (ExecutableElement c : visible) {
				// javac's default constructor (LWJGL 2 declared none): it only calls super(), which the empty body does too
				boolean implicit = lwjgl2.elements.getOrigin(c) == javax.lang.model.util.Elements.Origin.MANDATED;
				constructor(c, te.getSimpleName().toString(), null, !implicit);
			}
			first = false;
		}
		for (Element e : te.getEnclosedElements()) {
			if (e.getKind() == ElementKind.METHOD && Lwjgl2Api.isApi(e)) {
				if (!first) {
					code.blank();
				}
				ExecutableElement m = (ExecutableElement)e;
				method(m, itf, null, true, itf ? null : delegator.delegate(m, lwjgl2.internalName(te), lwjgl2.desc(m)));
				first = false;
			}
		}
		for (Element e : te.getEnclosedElements()) {
			if (e instanceof TypeElement n && Lwjgl2Api.isApi(n)) {
				code.blank();
				type(n);
			}
		}
		code.close();
	}

	void field(VariableElement f, boolean inInterface) {
		members++;
		Object cv = f.getConstantValue();
		boolean isFinal = f.getModifiers().contains(Modifier.FINAL);
		boolean isStatic = f.getModifiers().contains(Modifier.STATIC);
		boolean needsValue = cv == null && (isFinal && isStatic || inInterface);
		if (needsValue) {
			todo();
		}
		deprecated(f);
		String mods = modifiers(f, inInterface);
		if (!inInterface && isFinal && !isStatic && cv == null) {
			// cannot be assigned without a constructor body; LWJGL 2 binaries do not care about final
			mods = mods.substring(0, mods.length() - "final ".length());
		}
		String decl = mods + names.type(f.asType()) + " " + f.getSimpleName();
		if (cv != null) {
			code.line(decl + " = " + Literals.of(cv, f.asType()) + ";");
		} else if (needsValue) {
			code.line(decl + " = " + Literals.defaultValue(f.asType()) + ";");
		} else {
			code.line(decl + ";");
		}
	}

	/**
	 * {@code annotation}: an inject-api annotation name or null; {@code stub}: a @Todo body, otherwise an empty one (for
	 * @Widen, which the merger ignores, or for a default constructor, which it is).
	 */
	void constructor(ExecutableElement c, String simple, String annotation, boolean stub) {
		members++;
		deprecated(c);
		if (annotation != null) {
			annotate(annotation);
		}
		if (stub) {
			todo();
		}
		code.open(modifiers(c, false) + names.typeParams(c.getTypeParameters()) + simple + parameters(c) + throwsClause(c));
		if (stub) {
			superCall((TypeElement)c.getEnclosingElement());
			code.line(unimplemented());
		}
		code.close();
	}

	/**
	 * {@code impl}: a rule's body for the method; otherwise the body throws, with @Todo if {@code stub} (without it, as
	 * for @Widen, the merger ignores the body).
	 */
	void method(ExecutableElement m, boolean inInterface, String annotation, boolean stub, Rule.Implementation impl) {
		String delegate = impl == null ? null : impl.statement();
		members++;
		deprecated(m);
		if (annotation != null) {
			annotate(annotation);
		}
		boolean concrete = !inInterface && !m.getModifiers().contains(Modifier.ABSTRACT) && m.getDefaultValue() == null;
		if (concrete && stub && delegate == null) {
			todo();
		}
		String header = modifiers(m, inInterface) + names.typeParams(m.getTypeParameters())
			+ names.type(m.getReturnType()) + " " + m.getSimpleName() + parameters(m) + throwsClause(m);
		if (m.getDefaultValue() != null) {
			code.line(header + " default " + names.value(m.getDefaultValue()) + ";");
		} else if (!concrete) {
			code.line(header + ";");
		} else {
			code.open(header);
			if (delegate != null) {
				if (impl.rule().unsupported()) {
					unsupported++;
				} else {
					delegations++;
				}
				for (String line : delegate.split("\n")) {
					code.line(line);
				}
			} else {
				code.line(stub ? unimplemented() : THROW);
			}
			code.close();
		}
	}

	private String parameters(ExecutableElement m) {
		List<? extends VariableElement> ps = m.getParameters();
		StringBuilder sb = new StringBuilder("(");
		for (int i = 0; i < ps.size(); i++) {
			if (i > 0) {
				sb.append(", ");
			}
			TypeMirror t = ps.get(i).asType();
			if (m.isVarArgs() && i == ps.size() - 1) {
				sb.append(names.type(((ArrayType)t).getComponentType())).append("...");
			} else {
				sb.append(names.type(t));
			}
			sb.append(' ').append(ps.get(i).getSimpleName());
		}
		return sb.append(')').toString();
	}

	private String throwsClause(ExecutableElement m) {
		return m.getThrownTypes().isEmpty() ? ""
			: " throws " + m.getThrownTypes().stream().map(names::type).collect(Collectors.joining(", "));
	}

	/** An explicit super(...) call when the superclass has no no-arg constructor. */
	private void superCall(TypeElement te) {
		TypeMirror sup = te.getSuperclass();
		if (sup.getKind() != TypeKind.DECLARED) {
			return;
		}
		TypeElement st = (TypeElement)((DeclaredType)sup).asElement();
		List<ExecutableElement> cs = st.getEnclosedElements().stream()
			.filter(e -> e.getKind() == ElementKind.CONSTRUCTOR && !e.getModifiers().contains(Modifier.PRIVATE))
			.map(e -> (ExecutableElement)e).sorted(Comparator.comparingInt(c -> c.getParameters().size())).toList();
		if (cs.isEmpty() || cs.get(0).getParameters().isEmpty()) {
			return;
		}
		ExecutableType ct = (ExecutableType)lwjgl2.types.asMemberOf((DeclaredType)sup, cs.get(0));
		String args = ct.getParameterTypes().stream()
			.map(p -> "(" + names.type(lwjgl2.types.erasure(p)) + ") " + Literals.defaultValue(p))
			.collect(Collectors.joining(", "));
		code.line("super(" + args + ");");
	}

}
