package com.koyomiji.lwjgl2w3.stubgen;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.*;
import org.objectweb.asm.tree.analysis.*;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.regex.*;
import java.util.zip.*;

/**
 * Symbolically executes LWJGL binding methods down to the native calls they make, so that an LWJGL 2 method can be
 * shown to do the same as an LWJGL 3 one.
 *
 * <p>Each method is reduced to a "trace": the multiset of native calls it performs, written as
 * {@code fnName(arg, ...)} with arguments expressed in terms of the method parameters ({@code $0$, $1$, ...}),
 * plus the returned expression. Function pointers are dropped from the arguments and used as the call name.</p>
 */
final class NativeTrace {

	static final int MAX_DEPTH = 8;
	static final String UNKNOWN = "?";

	/** Static helpers replaced by a canonical expression instead of being inlined. */
	static final Map<String, String> CANON = new HashMap<>();
	/** Owners whose static methods are treated as side-effect-free checks (not inlined, no trace). */
	static final Set<String> CHECK_OWNERS = new HashSet<>(Arrays.asList(
		"org/lwjgl/BufferChecks", "org/lwjgl/opengl/GLChecks", "org/lwjgl/system/Checks", "org/lwjgl/opencl/CLChecks",
		"org/lwjgl/LWJGLUtil", "org/lwjgl/opencl/Util", "org/lwjgl/opengl/Util", "org/lwjgl/openal/Util"
	));

	static {
		// pointer of a buffer at its current position
		for (String n : new String[] {"getAddress", "getAddressSafe", "getAddress0", "getAddress0Safe"}) {
			CANON.put("org/lwjgl/MemoryUtil." + n, "addr");
		}
		for (String n : new String[] {"memAddress", "memAddressSafe", "memAddress0", "memAddress0Safe"}) {
			CANON.put("org/lwjgl/system/MemoryUtil." + n, "addr");
		}
		CANON.put("org/lwjgl/system/MemoryUtil.memPutAddress", "putAddr");
		CANON.put("org/lwjgl/system/Checks.remainingSafe", "rem");
		CANON.put("org/lwjgl/system/Checks.lengthSafe", "len");
	}

	final Map<String, ClassNode> classes = new HashMap<>();
	final Map<String, Summary> cache = new HashMap<>();
	final Set<String> inProgress = new HashSet<>();

	NativeTrace(String jars) throws IOException {
		for (String jar : jars.split(":")) {
			try (ZipFile z = new ZipFile(jar)) {
				for (Enumeration<? extends ZipEntry> e = z.entries(); e.hasMoreElements(); ) {
					ZipEntry ze = e.nextElement();
					String n = ze.getName();
					if (!n.endsWith(".class") || n.startsWith("META-INF/") || n.endsWith("module-info.class")) {
						continue;
					}
					ClassNode cn = new ClassNode();
					try (InputStream in = z.getInputStream(ze)) {
						new ClassReader(in).accept(cn, ClassReader.SKIP_DEBUG | ClassReader.SKIP_FRAMES);
					}
					classes.put(cn.name, cn);
				}
			}
		}
	}

	static final class Summary {
		final List<String> natives = new ArrayList<>();
		final Set<String> returns = new TreeSet<>();
		boolean unresolved;
		/** An LWJGL 2 native that takes or returns Java objects: it does work in C we cannot see. */
		boolean objectNative;

		String ret() {
			return returns.isEmpty() ? "" : returns.size() == 1 ? returns.iterator().next() : "phi(" + String.join("|", returns) + ")";
		}
	}

	MethodNode find(String owner, String name, String desc) {
		for (String o = owner; o != null; ) {
			ClassNode cn = classes.get(o);
			if (cn == null) {
				return null;
			}
			for (MethodNode m : cn.methods) {
				if (m.name.equals(name) && m.desc.equals(desc)) {
					return m;
				}
			}
			o = cn.superName;
		}
		return null;
	}

	Summary summarize(String owner, String name, String desc, int depth) {
		String key = owner + "." + name + desc;
		Summary s = cache.get(key);
		if (s != null) {
			return s;
		}
		s = new Summary();
		MethodNode m = find(owner, name, desc);
		if (m == null || (m.access & Opcodes.ACC_ABSTRACT) != 0 || depth > MAX_DEPTH || !inProgress.add(key)) {
			s.unresolved = true;
			return s;
		}
		try {
			if ((m.access & Opcodes.ACC_NATIVE) != 0) {
				// The entry point itself is native (LWJGL 3 declares many public glXxx methods as native).
				List<String> ps = new ArrayList<>();
				for (int i = 0; i < Type.getArgumentTypes(desc).length; i++) {
					ps.add("$" + i + "$");
				}
				String fname = name.startsWith("n") ? name.substring(1) : name;
				String call = fname + "(" + String.join(",", ps) + ")";
				s.natives.add(call);
				if (Type.getReturnType(desc) != Type.VOID_TYPE) {
					s.returns.add("R:" + call);
				}
				cache.put(key, s);
				return s;
			}
			Interp interp = new Interp(this, m, depth, s);
			Analyzer<Sym> a = new Analyzer<>(interp);
			try {
				a.analyze(owner, m);
			} catch (AnalyzerException ex) {
				s.unresolved = true;
			}
			// dedupe effects recorded during the analyzer's fixpoint iterations
			List<String> uniq = new ArrayList<>(new LinkedHashSet<>(interp.effects.values()));
			s.natives.addAll(uniq);
			Collections.sort(s.natives);
		} finally {
			inProgress.remove(key);
		}
		cache.put(key, s);
		return s;
	}


	/** Identity of an instruction, usable inside value-compared keys. */
	record IdentityKey(AbstractInsnNode insn) {
		@Override
		public boolean equals(Object o) {
			return o instanceof IdentityKey k && k.insn == insn;
		}

		@Override
		public int hashCode() {
			return System.identityHashCode(insn);
		}
	}

	static final class Sym implements Value {
		final int size;
		final String expr;

		Sym(int size, String expr) {
			this.size = size;
			this.expr = expr;
		}

		static Sym of(Type t, String e) {
			return new Sym(t == null ? 1 : t.getSize(), e);
		}

		@Override public int getSize() { return size; }
		@Override public boolean equals(Object o) { return o instanceof Sym && ((Sym)o).size == size && ((Sym)o).expr.equals(expr); }
		@Override public int hashCode() { return expr.hashCode() * 31 + size; }
		@Override public String toString() { return expr; }
	}

	static final Pattern PARAM = Pattern.compile("\\$(\\d+)\\$");

	static String subst(String e, List<String> args) {
		Matcher mt = PARAM.matcher(e);
		StringBuffer sb = new StringBuffer();
		while (mt.find()) {
			int i = Integer.parseInt(mt.group(1));
			mt.appendReplacement(sb, Matcher.quoteReplacement(i < args.size() ? args.get(i) : UNKNOWN));
		}
		mt.appendTail(sb);
		return sb.toString();
	}

	static String simple(String internal) {
		return internal.substring(internal.lastIndexOf('/') + 1);
	}

	static final class Interp extends Interpreter<Sym> implements Opcodes {
		final NativeTrace nt;
		final MethodNode m;
		final int depth;
		final Summary summary;
		/** an instruction (or a callee's effect at an instruction) -> its call: later fixpoint iterations overwrite */
		final Map<Object, String> effects = new LinkedHashMap<>();
		final Map<Integer, Integer> slotToParam = new HashMap<>();

		Interp(NativeTrace nt, MethodNode m, int depth, Summary summary) {
			super(Opcodes.ASM9);
			this.nt = nt;
			this.m = m;
			this.depth = depth;
			this.summary = summary;
			int slot = (m.access & Opcodes.ACC_STATIC) != 0 ? 0 : 1;
			int p = 0;
			if (slot == 1) {
				slotToParam.put(0, -1);
			}
			for (Type t : Type.getArgumentTypes(m.desc)) {
				slotToParam.put(slot, p++);
				slot += t.getSize();
			}
		}

		@Override public Sym newValue(Type type) {
			if (type == Type.VOID_TYPE) {
				return null;
			}
			return new Sym(type == null ? 1 : type.getSize(), UNKNOWN);
		}

		@Override public Sym newParameterValue(boolean isInstanceMethod, int local, Type type) {
			Integer p = slotToParam.get(local);
			return Sym.of(type, p == null ? UNKNOWN : p < 0 ? "this" : "$" + p + "$");
		}

		@Override public Sym newReturnTypeValue(Type type) { return type == Type.VOID_TYPE ? null : Sym.of(type, UNKNOWN); }
		@Override public Sym newEmptyValue(int local) { return new Sym(1, UNKNOWN); }
		@Override public Sym newExceptionValue(TryCatchBlockNode t, Frame<Sym> f, Type type) { return Sym.of(type, "exc"); }

		@Override public Sym newOperation(AbstractInsnNode insn) {
			switch (insn.getOpcode()) {
				case ACONST_NULL: return new Sym(1, "null");
				case ICONST_M1: case ICONST_0: case ICONST_1: case ICONST_2: case ICONST_3: case ICONST_4: case ICONST_5:
					return new Sym(1, String.valueOf(insn.getOpcode() - ICONST_0));
				case LCONST_0: case LCONST_1: return new Sym(2, String.valueOf(insn.getOpcode() - LCONST_0));
				case FCONST_0: case FCONST_1: case FCONST_2: return new Sym(1, (insn.getOpcode() - FCONST_0) + ".0f");
				case DCONST_0: case DCONST_1: return new Sym(2, (insn.getOpcode() - DCONST_0) + ".0");
				case BIPUSH: case SIPUSH: return new Sym(1, String.valueOf(((IntInsnNode)insn).operand));
				case LDC: {
					Object c = ((LdcInsnNode)insn).cst;
					int size = (c instanceof Long || c instanceof Double) ? 2 : 1;
					return new Sym(size, c instanceof String ? "\"" + c + "\"" : String.valueOf(c));
				}
				case GETSTATIC: {
					FieldInsnNode f = (FieldInsnNode)insn;
					if (f.desc.equals("J") && f.owner.endsWith("Capabilities")) {
						return new Sym(2, "fn:" + f.name);
					}
					// LWJGL 3 compile-time switches like Checks.CHECKS / DEBUG
					return Sym.of(Type.getType(f.desc), "S:" + simple(f.owner) + "." + f.name);
				}
				case NEW: return new Sym(1, "new " + simple(((TypeInsnNode)insn).desc));
				default: return new Sym(1, UNKNOWN);
			}
		}

		@Override public Sym copyOperation(AbstractInsnNode insn, Sym v) { return v; }

		@Override public Sym unaryOperation(AbstractInsnNode insn, Sym v) {
			int op = insn.getOpcode();
			switch (op) {
				case INEG: case LNEG: case FNEG: case DNEG: return new Sym(v.size, "-(" + v + ")");
				case IINC: return new Sym(1, UNKNOWN);
				case I2L: case F2L: case D2L: return new Sym(2, v.expr);
				case I2D: case L2D: case F2D: return new Sym(2, v.expr);
				case L2I: case F2I: case D2I: case I2F: case L2F: case D2F: case I2B: case I2C: case I2S:
					return new Sym(1, v.expr);
				case GETFIELD: {
					FieldInsnNode f = (FieldInsnNode)insn;
					if (f.desc.equals("J") && f.owner.endsWith("Capabilities")) {
						return new Sym(2, "fn:" + f.name);
					}
					if (v.expr.equals("TMP")) {
						return Sym.of(Type.getType(f.desc), "TMP");
					}
					return Sym.of(Type.getType(f.desc), v + "." + f.name);
				}
				case ARRAYLENGTH: return new Sym(1, "len(" + v + ")");
				case CHECKCAST: return v;
				case NEWARRAY: case ANEWARRAY: return new Sym(1, "newarray[" + v + "]");
				case INSTANCEOF: return new Sym(1, "instanceof(" + v + ")");
				default: return null; // branches, PUTSTATIC, ATHROW, MONITOR*, *RETURN handled elsewhere
			}
		}

		@Override public Sym binaryOperation(AbstractInsnNode insn, Sym a, Sym b) {
			int op = insn.getOpcode();
			String o;
			switch (op) {
				case IADD: case LADD: case FADD: case DADD: o = "+"; break;
				case ISUB: case LSUB: case FSUB: case DSUB: o = "-"; break;
				case IMUL: case LMUL: case FMUL: case DMUL: o = "*"; break;
				case IDIV: case LDIV: case FDIV: case DDIV: o = "/"; break;
				case IREM: case LREM: case FREM: case DREM: o = "%"; break;
				case ISHL: case LSHL: o = "<<"; break;
				case ISHR: case LSHR: o = ">>"; break;
				case IUSHR: case LUSHR: o = ">>>"; break;
				case IAND: case LAND: o = "&"; break;
				case IOR: case LOR: o = "|"; break;
				case IXOR: case LXOR: o = "^"; break;
				case LCMP: case FCMPL: case FCMPG: case DCMPL: case DCMPG: return new Sym(1, "cmp(" + a + "," + b + ")");
				case IALOAD: case BALOAD: case CALOAD: case SALOAD: case FALOAD: case AALOAD: return new Sym(1, a + "[" + b + "]");
				case LALOAD: case DALOAD: return new Sym(2, a + "[" + b + "]");
				case PUTFIELD: return null;
				default: return null; // IF_ICMP*, IF_ACMP*
			}
			int size = (op == LADD || op == LSUB || op == LMUL || op == LDIV || op == LREM || op == LSHL || op == LSHR
				|| op == LUSHR || op == LAND || op == LOR || op == LXOR || op == DADD || op == DSUB || op == DMUL
				|| op == DDIV || op == DREM) ? 2 : 1;
			return new Sym(size, "(" + a + o + b + ")");
		}

		@Override public Sym ternaryOperation(AbstractInsnNode insn, Sym a, Sym b, Sym c) { return null; }

		@Override public Sym naryOperation(AbstractInsnNode insn, List<? extends Sym> values) {
			if (insn.getOpcode() == MULTIANEWARRAY) {
				return new Sym(1, UNKNOWN);
			}
			if (insn.getOpcode() == INVOKEDYNAMIC) {
				InvokeDynamicInsnNode d = (InvokeDynamicInsnNode)insn;
				return Sym.of(Type.getReturnType(d.desc), "indy:" + d.name);
			}
			MethodInsnNode mi = (MethodInsnNode)insn;
			Type rt = Type.getReturnType(mi.desc);
			List<String> args = new ArrayList<>();
			for (Sym v : values) {
				args.add(v.expr);
			}
			String key = mi.owner + "." + mi.name;

			// --- value-preserving idioms
			if (mi.owner.equals("java/lang/Integer") && mi.name.equals("toUnsignedLong")) {
				return new Sym(2, args.get(0));
			}
			// --- strings: encoding helpers on either side become str/strlen/string
			Type[] ats = Type.getArgumentTypes(mi.desc);
			String strArg = null;
			for (int i = 0; i < ats.length; i++) {
				String d = ats[i].getDescriptor();
				if (d.equals("Ljava/lang/CharSequence;") || d.equals("[Ljava/lang/CharSequence;") || d.equals("Ljava/lang/String;")) {
					strArg = args.get(i + (mi.getOpcode() == INVOKESTATIC ? 0 : 1));
				}
			}
			if (mi.owner.equals("java/lang/CharSequence") && mi.name.equals("length")) {
				return new Sym(1, "strlen(" + args.get(0) + ")");
			}
			if (strArg != null && (mi.owner.endsWith("/APIUtil") || mi.owner.equals("org/lwjgl/system/MemoryStack")
				|| mi.owner.equals("org/lwjgl/system/MemoryUtil"))) {
				if (rt == Type.INT_TYPE) {
					return new Sym(1, "strlen(" + strArg + ")");
				}
				return Sym.of(rt, "str(" + strArg + ")");
			}
			if (mi.owner.equals("org/lwjgl/system/MemoryStack") && mi.name.equals("getPointerAddress")) {
				return new Sym(2, "str(*)");
			}
			// LWJGL 2 APIUtil temporaries: getInt(caps, v) -> address of a temp holding v, getBufferInt(caps) -> temp
			if (mi.owner.endsWith("/APIUtil") && mi.name.startsWith("get")) {
				if (rt == Type.LONG_TYPE && mi.name.equals("getInt") && args.size() == 2) {
					// a temporary holding the value (glDeleteTextures(int)): keep which value, for the delegation rule
					return new Sym(2, "addr(VAL(" + args.get(1) + "))");
				}
				if (rt == Type.LONG_TYPE) {
					return new Sym(2, "addr(TMP)");
				}
				if (rt.getSort() == Type.OBJECT && !rt.getDescriptor().equals("Ljava/lang/String;")) {
					return Sym.of(rt, "TMP");
				}
			}
			if ((mi.owner.equals("org/lwjgl/system/MemoryUtil") && (mi.name.startsWith("memUTF") || mi.name.startsWith("memASCII")))
				|| (mi.owner.endsWith("/APIUtil") && mi.name.startsWith("getString"))) {
				return Sym.of(rt, "string");
			}
			if (mi.owner.equals("org/lwjgl/system/MemoryUtil") && mi.name.startsWith("mem") && mi.name.endsWith("Buffer")
				|| mi.owner.equals("org/lwjgl/system/MemoryUtil") && mi.name.startsWith("mem") && mi.name.endsWith("BufferSafe")) {
				return Sym.of(rt, "wrap(" + String.join(",", args) + ")");
			}
			// --- temporaries initialised with values (stack.ints(x), TMP.put(i, x)) are still temporaries
			if (mi.owner.equals("org/lwjgl/system/MemoryStack")
				&& mi.name.matches("(bytes|shorts|ints|longs|floats|doubles|pointers|n?malloc.*|n?calloc.*)")) {
				return Sym.of(rt, "TMP");
			}
			if (mi.owner.startsWith("java/nio/") && mi.name.equals("put") && !args.isEmpty() && args.get(0).equals("TMP")) {
				return Sym.of(rt, "TMP");
			}
			if (mi.name.equals("remaining") && mi.desc.equals("()I") && mi.getOpcode() != INVOKESTATIC) {
				return new Sym(1, "rem(" + args.get(0) + ")");
			}
			String canon = CANON.get(key);
			if (canon != null) {
				return Sym.of(rt, canon + "(" + String.join(",", args) + ")");
			}
			if (mi.getOpcode() == INVOKESTATIC && CHECK_OWNERS.contains(mi.owner)) {
				return rt == Type.VOID_TYPE ? null : Sym.of(rt, "chk:" + mi.name + "(" + String.join(",", args) + ")");
			}
			// java.nio buffers: keep the observable accessors, normalised by name
			if (mi.owner.startsWith("java/nio/")) {
				String recv = args.isEmpty() ? "" : args.get(0);
				List<String> rest = args.size() > 1 ? args.subList(1, args.size()) : Collections.emptyList();
				return rt == Type.VOID_TYPE ? null : Sym.of(rt, recv + "." + mi.name + "(" + String.join(",", rest) + ")");
			}
			// stack / thread-local temporaries: LWJGL 2 APIUtil buffers vs LWJGL 3 MemoryStack
			if (mi.owner.equals("org/lwjgl/system/MemoryStack") || mi.owner.equals("org/lwjgl/opengl/APIUtil")
				|| mi.owner.equals("org/lwjgl/openal/APIUtil") || mi.owner.equals("org/lwjgl/opencl/APIUtil")) {
				if (mi.name.startsWith("stack") || mi.name.contains("alloc") || mi.name.startsWith("getBuffer")
					|| mi.name.startsWith("getBufferPointer")) {
					return rt == Type.VOID_TYPE ? null : Sym.of(rt, "TMP");
				}
				return rt == Type.VOID_TYPE ? null : Sym.of(rt, "api:" + mi.name + "(" + String.join(",", args) + ")");
			}
			// native call through LWJGL 3's JNI.call*/invoke*: last argument is the function pointer
			if (mi.owner.equals("org/lwjgl/system/JNI")) {
				String fp = args.get(args.size() - 1);
				String fname = fp.startsWith("fn:") ? fp.substring(3) : "?fp(" + fp + ")";
				return recordNative(insn, fname, args.subList(0, args.size() - 1), rt);
			}
			MethodNode target = nt.find(mi.owner, mi.name, mi.desc);
			if (target != null && (target.access & ACC_NATIVE) != 0) {
				// LWJGL 2: trailing long function_pointer; LWJGL 3: name is n<function>
				Type[] at = Type.getArgumentTypes(mi.desc);
				String last = args.isEmpty() ? "" : args.get(args.size() - 1);
				boolean objects = Type.getReturnType(mi.desc).getSort() >= Type.ARRAY;
				for (Type a : at) {
					objects |= a.getSort() >= Type.ARRAY;
				}
				if (objects && !mi.owner.startsWith("org/lwjgl/system/")) {
					summary.objectNative = true;
				}
				if (at.length > 0 && at[at.length - 1] == Type.LONG_TYPE && last.startsWith("fn:")) {
					return recordNative(insn, last.substring(3), args.subList(0, args.size() - 1), rt);
				}
				String fname = mi.name.startsWith("n") ? mi.name.substring(1) : mi.name;
				return recordNative(insn, fname, args, rt);
			}
			if (target != null && mi.owner.startsWith("org/lwjgl/")
				&& (mi.getOpcode() == INVOKESTATIC || mi.getOpcode() == INVOKESPECIAL && !mi.name.equals("<init>"))) {
				Summary callee = nt.summarize(mi.owner, mi.name, mi.desc, depth + 1);
				if (!callee.unresolved) {
					summary.objectNative |= callee.objectNative;
					for (int k = 0; k < callee.natives.size(); k++) {
						effects.put(List.of(new IdentityKey(insn), k), subst(callee.natives.get(k), args));
					}
					String r = callee.ret();
					return rt == Type.VOID_TYPE ? null : Sym.of(rt, r.isEmpty() ? UNKNOWN : subst(r, args));
				}
			}
			String recv = mi.getOpcode() == INVOKESTATIC ? simple(mi.owner) : args.get(0);
			List<String> rest = mi.getOpcode() == INVOKESTATIC ? args : args.subList(1, args.size());
			return rt == Type.VOID_TYPE ? null : Sym.of(rt, recv + "." + mi.name + "(" + String.join(",", rest) + ")");
		}

		Sym recordNative(AbstractInsnNode insn, String fname, List<String> args, Type rt) {
			String call = fname + "(" + String.join(",", args) + ")";
			effects.put(insn, call);
			return rt == Type.VOID_TYPE ? null : Sym.of(rt, "R:" + call);
		}

		@Override public void returnOperation(AbstractInsnNode insn, Sym value, Sym expected) {
			summary.returns.add(value.expr);
		}

		@Override public Sym merge(Sym a, Sym b) {
			if (a.equals(b)) {
				return a;
			}
			if (a.expr.equals(UNKNOWN) || b.expr.equals(UNKNOWN) || a.size != b.size) {
				return new Sym(Math.min(a.size, b.size), UNKNOWN);
			}
			TreeSet<String> alts = new TreeSet<>();
			alts.addAll(alternatives(a.expr));
			alts.addAll(alternatives(b.expr));
			if (alts.size() > 4) {
				return new Sym(a.size, UNKNOWN);
			}
			// null-safe idioms: x == null ? 0 : x.remaining()  ==  remainingSafe(x)
			if (alts.size() == 2 && alts.contains("0")) {
				String other = alts.last().equals("0") ? alts.first() : alts.last();
				if (other.startsWith("rem(") || other.startsWith("addr(") || other.startsWith("len(")) {
					return new Sym(a.size, other);
				}
			}
			if (alts.size() == 2 && alts.contains("null")) {
				String other = alts.first().equals("null") ? alts.last() : alts.first();
				return new Sym(a.size, other);
			}
			return new Sym(a.size, "phi(" + String.join("|", alts) + ")");
		}

		static List<String> alternatives(String e) {
			if (e.startsWith("phi(") && e.endsWith(")")) {
				return Arrays.asList(e.substring(4, e.length() - 1).split("\\|"));
			}
			return Collections.singletonList(e);
		}
	}


	static String fmt(Summary s) {
		if (s.unresolved) {
			return "UNRESOLVED";
		}
		return String.join(" ; ", s.natives) + " => " + s.ret();
	}

	/** Effect strings without bookkeeping-only details (buffer-checks, etc.). */
	static List<String> norm(Summary s) {
		return norm(s.natives);
	}

	static List<String> norm(List<String> natives) {
		List<String> out = new ArrayList<>();
		for (String n : natives) {
			out.add(normCall(n.replace("TMP.position()", "0").replaceAll("addr\\(VAL\\([^()]*\\)\\)", "addr(TMP)")));
		}
		Collections.sort(out);
		return out;
	}

	static final Pattern TMP_OUT = Pattern.compile("^(\\w+)\\((.*?),?addr\\(TMP\\)\\)$");

	/** Getter returning one value through a temporary out-parameter == native returning it directly. */
	static String normCall(String call) {
		// which string a temporary holds is not tracked on the LWJGL 3 side
		call = call.replaceAll("str\\((\\*|\\$\\d+\\$)\\)", "str");
		Matcher mt = TMP_OUT.matcher(call);
		return mt.matches() ? mt.group(1) + "(" + mt.group(2) + ")" : call;
	}

	static String normRet(Summary s) {
		return normRet(s.ret(), s.natives);
	}

	static String normRet(String r, List<String> natives) {
		if (r.equals("TMP.get(0)") || r.startsWith("TMP.get(0)") || r.equals("(TMP.get(0)!=0)")) {
			for (String n : natives) {
				if (TMP_OUT.matcher(n).matches()) {
					return "R:" + normCall(n.replaceAll("addr\\(VAL\\([^()]*\\)\\)", "addr(TMP)"));
				}
			}
		}
		return r.startsWith("R:") ? "R:" + normCall(r.substring(2)) : r;
	}

	static String fnNames(List<String> natives) {
		TreeSet<String> names = new TreeSet<>();
		for (String n : natives) {
			names.add(n.substring(0, n.indexOf('(')));
		}
		return String.join(",", names);
	}

}
