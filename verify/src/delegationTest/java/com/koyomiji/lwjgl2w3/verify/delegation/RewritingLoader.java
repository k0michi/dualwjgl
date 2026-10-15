package com.koyomiji.lwjgl2w3.verify.delegation;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.*;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.function.Predicate;

/**
 * Loads one side's LWJGL jars with their native methods rewritten to report to {@link Recorder} instead of calling C,
 * and their capability accessors returning {@link Recorder}'s fakes, so no driver or context is needed.
 */
final class RewritingLoader extends URLClassLoader {

	private static final String RECORDER = Type.getInternalName(Recorder.class);

	/** Which native methods to record; the others stay native (LWJGL 3's core library is loaded for real). */
	private final Predicate<String> recordNatives;
	/** {@code owner.name} of a static accessor -> Recorder field it returns instead */
	private final java.util.Map<String, String> accessors;
	/** {@code owner.name} prefixes of static void methods to empty (LWJGL 2's GL state checks) */
	private final java.util.List<String> emptied;

	RewritingLoader(URL[] jars, Predicate<String> recordNatives, java.util.Map<String, String> accessors, java.util.List<String> emptied) {
		super(jars, RewritingLoader.class.getClassLoader().getParent());
		this.recordNatives = recordNatives;
		this.accessors = accessors;
		this.emptied = emptied;
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		if (name.equals(Recorder.class.getName()) || name.startsWith(Recorder.class.getName() + "$")) {
			return RewritingLoader.class.getClassLoader().loadClass(name);
		}
		URL url = findResource(name.replace('.', '/') + ".class");
		if (url == null) {
			throw new ClassNotFoundException(name);
		}
		byte[] bytes;
		try (InputStream in = url.openStream()) {
			bytes = rewrite(in.readAllBytes());
		} catch (IOException e) {
			throw new ClassNotFoundException(name, e);
		}
		return defineClass(name, bytes, 0, bytes.length);
	}

	@Override
	protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
		if (name.equals(Recorder.class.getName()) || name.startsWith(Recorder.class.getName() + "$")) {
			return RewritingLoader.class.getClassLoader().loadClass(name);
		}
		return super.loadClass(name, resolve);
	}

	private byte[] rewrite(byte[] bytes) {
		ClassNode cn = new ClassNode();
		new ClassReader(bytes).accept(cn, 0);
		for (MethodNode m : cn.methods) {
			String key = cn.name + "." + m.name;
			String field = accessors.get(key);
			if (field != null && (m.access & Opcodes.ACC_STATIC) != 0) {
				body(m, insns(
					new FieldInsnNode(Opcodes.GETSTATIC, RECORDER, field, "Ljava/lang/Object;"),
					new TypeInsnNode(Opcodes.CHECKCAST, Type.getReturnType(m.desc).getInternalName()),
					new InsnNode(Opcodes.ARETURN)));
			} else if ((m.access & Opcodes.ACC_NATIVE) != 0 && recordNatives.test(cn.name)) {
				m.access &= ~Opcodes.ACC_NATIVE;
				body(m, record(cn.name, m));
			} else if ((m.access & Opcodes.ACC_STATIC) != 0 && Type.getReturnType(m.desc) == Type.VOID_TYPE
				&& emptied.stream().anyMatch(key::startsWith)) {
				body(m, insns(new InsnNode(Opcodes.RETURN)));
			} else if (m.instructions != null) {
				// LWJGL 2 loads liblwjgl in static initializers; its natives are all rewritten, so skip the load
				for (AbstractInsnNode i : m.instructions.toArray()) {
					if (i instanceof MethodInsnNode mi && mi.owner.equals("java/lang/System")
						&& (mi.name.equals("loadLibrary") || mi.name.equals("load"))) {
						m.instructions.set(i, new InsnNode(Opcodes.POP));
					}
				}
			}
		}
		ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
		cn.accept(cw);
		return cw.toByteArray();
	}

	private static InsnList record(String owner, MethodNode m) {
		InsnList l = new InsnList();
		Type[] args = Type.getArgumentTypes(m.desc);
		boolean isStatic = (m.access & Opcodes.ACC_STATIC) != 0;
		l.add(new LdcInsnNode(owner + "." + m.name));
		l.add(new LdcInsnNode(args.length));
		l.add(new TypeInsnNode(Opcodes.ANEWARRAY, "java/lang/Object"));
		int slot = isStatic ? 0 : 1;
		for (int i = 0; i < args.length; i++) {
			l.add(new InsnNode(Opcodes.DUP));
			l.add(new LdcInsnNode(i));
			l.add(new VarInsnNode(args[i].getOpcode(Opcodes.ILOAD), slot));
			box(l, args[i]);
			l.add(new InsnNode(Opcodes.AASTORE));
			slot += args[i].getSize();
		}
		l.add(new MethodInsnNode(Opcodes.INVOKESTATIC, RECORDER, "record", "(Ljava/lang/String;[Ljava/lang/Object;)V", false));
		Type ret = Type.getReturnType(m.desc);
		switch (ret.getSort()) {
			case Type.VOID -> l.add(new InsnNode(Opcodes.RETURN));
			case Type.LONG -> {
				l.add(new InsnNode(Opcodes.LCONST_0));
				l.add(new InsnNode(Opcodes.LRETURN));
			}
			case Type.FLOAT -> {
				l.add(new InsnNode(Opcodes.FCONST_0));
				l.add(new InsnNode(Opcodes.FRETURN));
			}
			case Type.DOUBLE -> {
				l.add(new InsnNode(Opcodes.DCONST_0));
				l.add(new InsnNode(Opcodes.DRETURN));
			}
			case Type.OBJECT, Type.ARRAY -> {
				l.add(new InsnNode(Opcodes.ACONST_NULL));
				l.add(new InsnNode(Opcodes.ARETURN));
			}
			default -> {
				l.add(new InsnNode(Opcodes.ICONST_0));
				l.add(new InsnNode(Opcodes.IRETURN));
			}
		}
		return l;
	}

	private static void box(InsnList l, Type t) {
		String w = switch (t.getSort()) {
			case Type.BOOLEAN -> "java/lang/Boolean";
			case Type.BYTE -> "java/lang/Byte";
			case Type.CHAR -> "java/lang/Character";
			case Type.SHORT -> "java/lang/Short";
			case Type.INT -> "java/lang/Integer";
			case Type.LONG -> "java/lang/Long";
			case Type.FLOAT -> "java/lang/Float";
			case Type.DOUBLE -> "java/lang/Double";
			default -> null;
		};
		if (w != null) {
			l.add(new MethodInsnNode(Opcodes.INVOKESTATIC, w, "valueOf", "(" + t.getDescriptor() + ")L" + w + ";", false));
		}
	}

	private static InsnList insns(AbstractInsnNode... nodes) {
		InsnList l = new InsnList();
		for (AbstractInsnNode n : nodes) {
			l.add(n);
		}
		return l;
	}

	private static void body(MethodNode m, InsnList code) {
		m.instructions = code;
		m.tryCatchBlocks.clear();
		if (m.localVariables != null) {
			m.localVariables.clear();
		}
		m.visibleLocalVariableAnnotations = null;
		m.invisibleLocalVariableAnnotations = null;
	}

}
