package com.koyomiji.lwjgl2w3.stubgen;

import org.objectweb.asm.tree.MethodNode;

import javax.lang.model.element.*;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/**
 * Writes compat/src/generated/java for the LWJGL 2.9.3 API: for every member LWJGL 3 does not provide (declared or
 * inherited), a delegation when a {@link Rule} proves one and a {@code @Todo} stub otherwise. Classes hand-written in
 * compat are skipped; hand-written members override generated ones in the merger.
 */
public final class StubGen {

	static final String INJECT_PACKAGE = "com.koyomiji.lwjgl2w3.inject";
	static final String GENERATED_PACKAGE = "com.koyomiji.lwjgl2w3.generated";

	/** LWJGL 2 classes whose LWJGL 3 counterpart has an incompatible superclass; see poc/callback in the research repo. */
	static final Set<String> CALLBACKS = Set.of(
		"org.lwjgl.opencl.CLContextCallback", "org.lwjgl.opencl.CLEventCallback",
		"org.lwjgl.opencl.CLMemObjectDestructorCallback", "org.lwjgl.opencl.CLNativeKernel",
		"org.lwjgl.opencl.CLProgramCallback");

	private final Lwjgl2Api lwjgl2;
	private final Lwjgl3Api lwjgl3;
	private final HandWritten handWritten;
	private final Overloads overloads;
	private final Delegator delegator;
	private final Diagnostics diagnostics;
	private final Report report = new Report();
	private final Path generatedDir;

	private StubGen(Options o) throws IOException {
		generatedDir = o.generated();
		handWritten = new HandWritten(o.main(), o.replace(), o.injectClasses());
		lwjgl3 = new Lwjgl3Api(o.lwjgl3());
		lwjgl2 = new Lwjgl2Api(o.sources(), o.classpath(), o.lwjgl2Jars(), lwjgl3);
		overloads = new Overloads(lwjgl3);
		NativeTrace trace3 = new NativeTrace(String.join(File.pathSeparator, o.lwjgl3()));
		NativeTrace trace2 = new NativeTrace(String.join(File.pathSeparator, o.lwjgl2Jars()));
		diagnostics = new Diagnostics(lwjgl3, trace3);
		delegator = new Delegator(lwjgl2, trace2,
			List.of(new UnsupportedRule(lwjgl3, trace3), new SameSignatureRule(lwjgl3, trace3), new RawNativeCallRule(lwjgl2, lwjgl3, trace3)),
			diagnostics);
	}

	public static void main(String[] args) throws IOException {
		Options o = Options.parse(args);
		deleteRecursively(o.generated());
		StubGen g = new StubGen(o);
		for (TypeElement te : g.lwjgl2.apiTypes) {
			g.generate(te);
		}
		g.report.print(g.delegator.hits, g.lwjgl2.forcePublic);
		if (o.diagnostics() != null) {
			g.diagnostics.write(o.diagnostics());
		}
	}

	private void generate(TypeElement te) throws IOException {
		String fqn = te.getQualifiedName().toString();
		String pkg = lwjgl2.packageOf(te);
		String simple = te.getSimpleName().toString();
		String area = Areas.of(pkg, simple);

		if (CALLBACKS.contains(fqn)) {
			if (!handWritten.replaced(pkg, simple)) {
				report.needsDesign(fqn + ": superclass conflicts with LWJGL 3 (PointerWrapperAbstract vs Callback); write a replace class");
			}
			return;
		}
		TypeMirror sup = te.getSuperclass();
		TypeElement st = sup.getKind() == TypeKind.DECLARED ? (TypeElement)((DeclaredType)sup).asElement() : null;
		if (st != null && CALLBACKS.contains(st.getQualifiedName().toString())
			&& !handWritten.replaced(lwjgl2.packageOf(st), st.getSimpleName().toString())) {
			report.needsDesign(fqn + ": extends " + st.getQualifiedName() + ", which needs a replace class first");
		}

		if (lwjgl3.contains(lwjgl2.internalName(te))) {
			generateFragment(te, pkg, simple, area);
			return;
		}
		if (handWritten.wholeClass(pkg, simple)) {
			return;
		}
		if (st != null && lwjgl3.contains(lwjgl2.internalName(st)) && !CALLBACKS.contains(st.getQualifiedName().toString())
			&& !lwjgl2.types.erasure(sup).toString().equals("java.lang.Object")) {
			report.needsDesign(fqn + ": LWJGL 2-only class extending " + sup + ", which LWJGL 3 also has");
			return;
		}
		StubWriter w = new StubWriter(lwjgl2, lwjgl2.forcePublic, pkg, area, delegator);
		w.type(te);
		write(generatedDir.resolve(pkg.replace('.', '/')).resolve(simple + ".java"), w.file());
		report.count(w);
	}

	/** The members of LWJGL 2 class {@code te} that LWJGL 3's class of the same name lacks. */
	private void generateFragment(TypeElement te, String pkg, String simple, String area) throws IOException {
		String fqn = te.getQualifiedName().toString();
		String cls = lwjgl2.internalName(te);
		Set<String> methods3 = lwjgl3.methods(cls);
		Set<String> fields3 = lwjgl3.fields(cls);

		// LWJGL 2 members, plus statics inherited from LWJGL 2-only superclasses (LWJGL 3 does not have that superclass)
		List<Element> members = new ArrayList<>(te.getEnclosedElements());
		for (TypeMirror s = te.getSuperclass(); s.getKind() == TypeKind.DECLARED; ) {
			TypeElement st = (TypeElement)((DeclaredType)s).asElement();
			if (lwjgl3.contains(lwjgl2.internalName(st)) || st.getQualifiedName().contentEquals("java.lang.Object")) {
				break;
			}
			for (Element e : st.getEnclosedElements()) {
				if (e.getModifiers().contains(Modifier.STATIC) && (e.getKind() == ElementKind.METHOD || e.getKind() == ElementKind.FIELD)) {
					members.add(e);
				} else if (e.getKind() == ElementKind.METHOD && Lwjgl2Api.isApi(e)) {
					report.needsDesign(fqn + ": inherits instance method " + e + " from LWJGL 2-only " + st.getQualifiedName());
				}
			}
			s = st.getSuperclass();
		}
		for (TypeMirror itf : te.getInterfaces()) {
			TypeElement it = (TypeElement)((DeclaredType)itf).asElement();
			if (!lwjgl3.supers(cls).contains(lwjgl2.internalName(it))) {
				report.needsDesign(fqn + ": LWJGL 2 implements " + it.getQualifiedName() + ", LWJGL 3 does not");
			}
		}

		StubWriter w = new StubWriter(lwjgl2, lwjgl2.forcePublic, GENERATED_PACKAGE + "." + pkg, area, delegator);
		w.openFragment(simple);
		for (Element e : members) {
			if (!Lwjgl2Api.isApi(e)) {
				continue;
			}
			switch (e.getKind()) {
				case FIELD -> {
					if (!fields3.contains(e.getSimpleName().toString())) {
						w.field((VariableElement)e, false);
					}
				}
				case METHOD -> {
					ExecutableElement m = (ExecutableElement)e;
					String d = lwjgl2.desc(m);
					MethodNode own = lwjgl3.declared(cls, m.getSimpleName().toString(), d);
					if (own != null) {
						if (Lwjgl3Api.rank(own.access) < Lwjgl2Api.rank(m.getModifiers())) {
							w.method(m, false, "Widen", false, null);
						}
					} else if (methods3.contains(m.getSimpleName() + d)) {
						// LWJGL 3 inherits it from a supertype: that implementation serves both
					} else if (m.getModifiers().contains(Modifier.ABSTRACT)) {
						report.needsDesign(fqn + ": abstract LWJGL 2 method " + m + " would break LWJGL 3 subclasses");
					} else {
						boolean hidden = overloads.needsHidden(methods3, m.getSimpleName().toString(), d);
						w.method(m, false, hidden ? "Hidden" : null, true, delegator.delegate(m, cls, d));
					}
				}
				case CONSTRUCTOR -> {
					ExecutableElement c = (ExecutableElement)e;
					String d = lwjgl2.desc(c);
					MethodNode own = lwjgl3.declared(cls, "<init>", d);
					if (own == null) {
						if (!handWritten.addsConstructor(cls, d)) {
							report.needsDesign(fqn + ": constructor " + c + " does not exist in LWJGL 3; add it from an @Into inject class extending the same superclass");
						}
					} else if (Lwjgl3Api.rank(own.access) < Lwjgl2Api.rank(c.getModifiers())) {
						w.constructor(c, simple, "Widen", false);
					}
				}
				default -> {
				}
			}
		}
		w.closeFragment();
		if (w.members == 0) {
			return;
		}
		write(generatedDir.resolve((GENERATED_PACKAGE + "." + pkg).replace('.', '/')).resolve(simple + ".java"), w.file());
		report.count(w);
	}

	private static void write(Path file, String content) throws IOException {
		Files.createDirectories(file.getParent());
		Files.writeString(file, content);
	}

	private static void deleteRecursively(Path dir) throws IOException {
		if (!Files.exists(dir)) {
			return;
		}
		try (var s = Files.walk(dir)) {
			for (Path p : s.sorted(Comparator.reverseOrder()).toList()) {
				Files.delete(p);
			}
		}
	}

}
