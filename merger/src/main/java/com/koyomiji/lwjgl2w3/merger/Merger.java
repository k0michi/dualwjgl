package com.koyomiji.lwjgl2w3.merger;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.commons.ClassRemapper;
import org.objectweb.asm.commons.Remapper;
import org.objectweb.asm.tree.*;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.jar.*;
import java.util.stream.*;

/**
 * Produces LWJGL 3 jars that also carry the LWJGL 2 API.
 *
 * <ul>
 * <li>Inject classes ({@code com/koyomiji/lwjgl2w3/inject/<pkg>/<Name>}) are merged into the existing LWJGL 3 class
 * {@code <pkg>/<Name>}: their members are copied in, references to the inject class are remapped to the target.</li>
 * <li>Add classes (LWJGL 2-only classes, compiled in their real package) are added to the LWJGL 3 jar that owns the
 * package, or to the extra jar when no LWJGL 3 jar does.</li>
 * </ul>
 *
 * <p>Usage: {@code Merger --jar IN=OUT ... --inject DIR --add DIR --extra OUT}</p>
 */
public final class Merger {

	static final String INJECT_PREFIX = "com/koyomiji/lwjgl2w3/inject/";
	static final String ANNOTATION_PREFIX = "L" + INJECT_PREFIX;
	static final String WIDEN = ANNOTATION_PREFIX + "Widen;";
	static final String HIDDEN = ANNOTATION_PREFIX + "Hidden;";
	static final String CLINIT_ALIAS = "lwjgl2w3$clinit";
	static final String VERSIONS = "META-INF/versions/";

	static final class JarImage {
		final Path out;
		final Map<String, byte[]> entries = new LinkedHashMap<>();
		Manifest manifest;

		JarImage(Path out) {
			this.out = out;
		}
	}

	final List<JarImage> jars = new ArrayList<>();
	final Map<String, JarImage> packageOwner = new HashMap<>();
	final Map<String, JarImage> classOwner = new HashMap<>();
	final List<String> log = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		Merger m = new Merger();
		List<Path> injectDirs = new ArrayList<>(), addDirs = new ArrayList<>();
		Path extra = null;
		for (int i = 0; i < args.length; i++) {
			switch (args[i]) {
				case "--jar": {
					String[] io = args[++i].split("=", 2);
					m.read(Paths.get(io[0]), Paths.get(io[1]));
					break;
				}
				case "--inject":
					injectDirs.add(Paths.get(args[++i]));
					break;
				case "--add":
					addDirs.add(Paths.get(args[++i]));
					break;
				case "--extra":
					extra = Paths.get(args[++i]);
					break;
				default:
					throw new IllegalArgumentException("Unknown argument: " + args[i]);
			}
		}
		JarImage extraJar = new JarImage(Objects.requireNonNull(extra, "--extra is required"));
		for (Path dir : injectDirs) {
			for (Path f : classFiles(dir)) {
				m.inject(Files.readAllBytes(f));
			}
		}
		for (Path dir : addDirs) {
			for (Path f : classFiles(dir)) {
				m.add(Files.readAllBytes(f), extraJar);
			}
		}
		for (JarImage j : m.jars) {
			write(j);
		}
		if (!extraJar.entries.isEmpty()) {
			write(extraJar);
		}
		m.log.forEach(System.out::println);
	}

	static List<Path> classFiles(Path dir) throws IOException {
		if (!Files.isDirectory(dir)) {
			return Collections.emptyList();
		}
		try (Stream<Path> s = Files.walk(dir)) {
			return s.filter(p -> p.toString().endsWith(".class")).sorted().collect(Collectors.toList());
		}
	}

	void read(Path in, Path out) throws IOException {
		JarImage j = new JarImage(out);
		try (JarFile jf = new JarFile(in.toFile())) {
			j.manifest = jf.getManifest();
			for (Enumeration<JarEntry> e = jf.entries(); e.hasMoreElements(); ) {
				JarEntry je = e.nextElement();
				if (je.isDirectory() || je.getName().equals(JarFile.MANIFEST_NAME)) {
					continue;
				}
				try (InputStream is = jf.getInputStream(je)) {
					j.entries.put(je.getName(), is.readAllBytes());
				}
				String n = je.getName();
				if (n.endsWith(".class") && !n.startsWith("META-INF/")) {
					String cls = n.substring(0, n.length() - 6);
					classOwner.put(cls, j);
					packageOwner.putIfAbsent(packageOf(cls), j);
				}
			}
		}
		jars.add(j);
	}

	static String packageOf(String internalName) {
		int i = internalName.lastIndexOf('/');
		return i < 0 ? "" : internalName.substring(0, i);
	}

	static final Remapper STRIP_PREFIX = new Remapper() {
		@Override
		public String map(String internalName) {
			// <prefix><pkg>/<Name> is an inject class; <prefix><Name> is inject-api (e.g. @Widen)
			if (internalName.startsWith(INJECT_PREFIX) && internalName.indexOf('/', INJECT_PREFIX.length()) >= 0) {
				return internalName.substring(INJECT_PREFIX.length());
			}
			return internalName;
		}
	};

	static ClassNode readInject(byte[] bytes) {
		ClassNode inj = new ClassNode();
		new ClassReader(bytes).accept(new ClassRemapper(inj, STRIP_PREFIX), 0);
		return inj;
	}

	void inject(byte[] bytes) {
		String target = readInject(bytes).name;
		JarImage owner = classOwner.get(target);
		if (owner == null) {
			throw new IllegalStateException("Inject target " + target + " does not exist in LWJGL 3. "
				+ "LWJGL 2-only classes belong in compat's main source set.");
		}
		if (target.contains("$")) {
			throw new IllegalStateException("Nested inject classes are not supported yet: " + target);
		}
		// the class itself and any multi-release variants of it
		for (String entry : new ArrayList<>(owner.entries.keySet())) {
			if (entry.equals(target + ".class") || (entry.startsWith(VERSIONS) && entry.endsWith("/" + target + ".class"))) {
				// a fresh copy per target: merge() moves and edits the inject's members
				owner.entries.put(entry, merge(owner.entries.get(entry), readInject(bytes), entry));
			}
		}
	}

	byte[] merge(byte[] targetBytes, ClassNode inj, String entry) {
		ClassNode t = new ClassNode();
		new ClassReader(targetBytes).accept(t, 0);

		if (!inj.superName.equals("java/lang/Object") && !inj.superName.equals(t.superName)) {
			throw new IllegalStateException(entry + ": inject class extends " + inj.superName + " but target extends " + t.superName);
		}
		for (String itf : inj.interfaces) {
			if (!t.interfaces.contains(itf)) {
				t.interfaces.add(itf);
				log.add(entry + ": + implements " + itf);
			}
		}

		for (FieldNode f : inj.fields) {
			FieldNode existing = t.fields.stream().filter(x -> x.name.equals(f.name)).findFirst().orElse(null);
			boolean widenField = has(f.invisibleAnnotations, WIDEN);
			boolean hiddenField = has(f.invisibleAnnotations, HIDDEN);
			f.invisibleAnnotations = strip(f.invisibleAnnotations);
			if (widenField) {
				if (existing == null || !existing.desc.equals(f.desc)) {
					throw new IllegalStateException(entry + ": @Widen field " + f.name + " " + f.desc + " not found in target");
				}
				existing.access = widen(existing.access, f.access);
				log.add(entry + ": widen field " + f.name);
				continue;
			}
			if (existing != null) {
				throw new IllegalStateException(entry + ": field " + f.name + " already exists in target");
			}
			if (hiddenField) {
				f.access |= Opcodes.ACC_SYNTHETIC;
			}
			t.fields.add(f);
			log.add(entry + ": + field " + f.name + " " + f.desc);
		}

		for (MethodNode m : inj.methods) {
			MethodNode existing = find(t, m.name, m.desc);
			boolean widen = has(m.invisibleAnnotations, WIDEN);
			boolean hidden = has(m.invisibleAnnotations, HIDDEN);
			m.invisibleAnnotations = strip(m.invisibleAnnotations);

			if (widen) {
				if (existing == null) {
					throw new IllegalStateException(entry + ": @Widen method " + m.name + m.desc + " not found in target");
				}
				existing.access = widen(existing.access, m.access);
				log.add(entry + ": widen " + m.name + m.desc + " -> " + access(existing.access));
				continue;
			}
			if (m.name.equals("<init>")) {
				if (isTrivialConstructor(m, inj.superName)) {
					continue; // the inject class's own default constructor
				}
				throw new IllegalStateException(entry + ": constructors must be annotated (@Widen): " + m.desc);
			}
			if (m.name.equals("<clinit>")) {
				m.name = CLINIT_ALIAS;
				m.access = Opcodes.ACC_PRIVATE | Opcodes.ACC_STATIC | Opcodes.ACC_SYNTHETIC;
				callFromClinit(t, t.name, CLINIT_ALIAS);
				existing = find(t, m.name, m.desc);
			}
			if (existing != null) {
				throw new IllegalStateException(entry + ": " + m.name + m.desc + " already exists in target "
					+ "(use @Widen, or give the LWJGL 2 member a different descriptor)");
			}
			if (hidden) {
				m.access |= Opcodes.ACC_SYNTHETIC;
			}
			t.methods.add(m);
			log.add(entry + ": + " + access(m.access) + " " + m.name + m.desc);
		}

		ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
		t.accept(cw);
		return cw.toByteArray();
	}

	static void callFromClinit(ClassNode t, String owner, String alias) {
		MethodNode clinit = find(t, "<clinit>", "()V");
		if (clinit == null) {
			clinit = new MethodNode(Opcodes.ACC_STATIC, "<clinit>", "()V", null, null);
			clinit.instructions.add(new InsnNode(Opcodes.RETURN));
			t.methods.add(clinit);
		}
		clinit.instructions.insert(new MethodInsnNode(Opcodes.INVOKESTATIC, owner, alias, "()V", false));
	}

	static boolean isTrivialConstructor(MethodNode m, String superName) {
		if (!m.desc.equals("()V")) {
			return false;
		}
		List<Integer> ops = new ArrayList<>();
		for (AbstractInsnNode i : m.instructions) {
			if (i.getOpcode() >= 0) {
				ops.add(i.getOpcode());
			}
		}
		return ops.equals(Arrays.asList(Opcodes.ALOAD, Opcodes.INVOKESPECIAL, Opcodes.RETURN));
	}

	static MethodNode find(ClassNode c, String name, String desc) {
		return c.methods.stream().filter(m -> m.name.equals(name) && m.desc.equals(desc)).findFirst().orElse(null);
	}

	static boolean has(List<AnnotationNode> anns, String desc) {
		return anns != null && anns.stream().anyMatch(a -> a.desc.equals(desc));
	}

	static List<AnnotationNode> strip(List<AnnotationNode> anns) {
		if (anns == null) {
			return null;
		}
		List<AnnotationNode> kept = anns.stream().filter(a -> !a.desc.startsWith(ANNOTATION_PREFIX)).collect(Collectors.toList());
		return kept.isEmpty() ? null : kept;
	}

	static int rank(int access) {
		if ((access & Opcodes.ACC_PUBLIC) != 0) {
			return 3;
		}
		if ((access & Opcodes.ACC_PROTECTED) != 0) {
			return 2;
		}
		return (access & Opcodes.ACC_PRIVATE) != 0 ? 0 : 1;
	}

	static int widen(int existing, int wanted) {
		if (rank(wanted) <= rank(existing)) {
			return existing;
		}
		int vis = Opcodes.ACC_PUBLIC | Opcodes.ACC_PROTECTED | Opcodes.ACC_PRIVATE;
		return (existing & ~vis) | (wanted & vis);
	}

	static String access(int a) {
		return new String[] {"private", "package", "protected", "public"}[rank(a)]
			+ ((a & Opcodes.ACC_STATIC) != 0 ? " static" : "")
			+ ((a & Opcodes.ACC_SYNTHETIC) != 0 ? " synthetic" : "");
	}

	void add(byte[] bytes, JarImage extra) {
		String name = new ClassReader(bytes).getClassName();
		if (classOwner.containsKey(name)) {
			throw new IllegalStateException(name + " already exists in LWJGL 3; write it as an inject class instead");
		}
		JarImage owner = packageOwner.getOrDefault(packageOf(name), extra);
		owner.entries.put(name + ".class", bytes);
		log.add(owner.out.getFileName() + ": + class " + name);
	}

	static void write(JarImage j) throws IOException {
		Files.createDirectories(j.out.getParent());
		Manifest mf = j.manifest != null ? j.manifest : new Manifest();
		mf.getMainAttributes().putIfAbsent(Attributes.Name.MANIFEST_VERSION, "1.0");
		try (JarOutputStream jos = new JarOutputStream(Files.newOutputStream(j.out), mf)) {
			Set<String> dirs = new HashSet<>();
			for (Map.Entry<String, byte[]> e : j.entries.entrySet()) {
				String n = e.getKey();
				for (int i = n.indexOf('/'); i >= 0; i = n.indexOf('/', i + 1)) {
					String d = n.substring(0, i + 1);
					if (dirs.add(d)) {
						jos.putNextEntry(new JarEntry(d));
						jos.closeEntry();
					}
				}
				jos.putNextEntry(new JarEntry(n));
				jos.write(e.getValue());
				jos.closeEntry();
			}
		}
	}

}
