package com.koyomiji.lwjgl2w3.stubgen;

import org.objectweb.asm.Type;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;

import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeKind;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * R2: the LWJGL 2 method makes exactly one native call whose arguments are parameters, buffer addresses, remaining
 * counts, array lengths, constants and shifts/products of those, and returns nothing or that call's primitive result.
 * It becomes a call to LWJGL 3's raw {@code n<function>} method, which passes its arguments straight to the same native
 * function (e.g. {@code glBufferStorage(int, LongBuffer, int)} becomes
 * {@code nglBufferStorage(target, remaining << 3, address, flags)}), wherever {@link Lwjgl3Api#owners} finds it.
 */
final class RawNativeCallRule implements Rule {

	private static final Pattern ARG = Pattern.compile(
		"\\$(\\d+)\\$|(addr|rem|len)\\(\\$(\\d+)\\$\\)|(-?\\d+)|\\((rem|len)\\(\\$(\\d+)\\$\\)(<<|>>|/|\\*)(\\d+)\\)");

	private static final Set<String> ADDRESSABLE = Set.of("java.nio.ByteBuffer", "java.nio.ShortBuffer", "java.nio.CharBuffer",
		"java.nio.IntBuffer", "java.nio.FloatBuffer", "java.nio.LongBuffer", "java.nio.DoubleBuffer", "org.lwjgl.PointerBuffer");

	private final Lwjgl2Api lwjgl2;
	private final Lwjgl3Api lwjgl3;
	private final NativeTrace trace3;

	RawNativeCallRule(Lwjgl2Api lwjgl2, Lwjgl3Api lwjgl3, NativeTrace trace3) {
		this.lwjgl2 = lwjgl2;
		this.lwjgl3 = lwjgl3;
		this.trace3 = trace3;
	}

	@Override
	public String name() {
		return "R2";
	}

	@Override
	public String apply(Target t) {
		if (t.calls().size() != 1) {
			return null;
		}
		ExecutableElement m = t.method();
		String call2 = t.calls().get(0);
		String fn = call2.substring(0, call2.indexOf('('));
		List<String> args = splitArgs(call2.substring(call2.indexOf('(') + 1, call2.length() - 1));
		boolean returns = t.returns();
		if (returns ? !t.ret().equals("R:" + call2) || !m.getReturnType().getKind().isPrimitive() : !t.ret().isEmpty()) {
			return null;
		}
		String identity = fn + "(" + IntStream.range(0, args.size()).mapToObj(i -> "$" + i + "$")
			.collect(Collectors.joining(",")) + ")";
		for (String owner3 : lwjgl3.owners(t.cls())) {
			ClassNode cn = lwjgl3.get(owner3);
			if (cn == null) {
				continue;
			}
			for (MethodNode n : cn.methods) {
				if (!n.name.equals("n" + fn) || !Lwjgl3Api.isPublicStatic(n)) {
					continue;
				}
				Type[] pts = Type.getArgumentTypes(n.desc);
				Type rt = Type.getReturnType(n.desc);
				if (pts.length != args.size() || (returns && !rt.getDescriptor().equals(lwjgl2.desc(m.getReturnType())))) {
					continue;
				}
				NativeTrace.Summary s3 = trace3.summarize(owner3, n.name, n.desc, 0);
				if (s3.unresolved || !NativeTrace.norm(s3).equals(List.of(identity))
					|| !NativeTrace.normRet(s3).equals(returns ? "R:" + identity : "")) {
					continue;
				}
				List<String> rendered = new ArrayList<>();
				for (int i = 0; i < args.size(); i++) {
					String a = renderArg(args.get(i), m, pts[i]);
					if (a == null) {
						return null;
					}
					rendered.add(a);
				}
				return t.call(owner3, n.name, String.join(", ", rendered));
			}
		}
		return null;
	}

	static List<String> splitArgs(String s) {
		List<String> out = new ArrayList<>();
		int depth = 0;
		StringBuilder cur = new StringBuilder();
		for (char ch : s.toCharArray()) {
			if (ch == '(' || ch == '[') {
				depth++;
			} else if (ch == ')' || ch == ']') {
				depth--;
			}
			if (ch == ',' && depth == 0) {
				out.add(cur.toString());
				cur.setLength(0);
			} else {
				cur.append(ch);
			}
		}
		if (cur.length() > 0) {
			out.add(cur.toString());
		}
		return out;
	}

	/** Java source for one argument, passed to a parameter of type {@code to}; null if it cannot be written. */
	private String renderArg(String arg, ExecutableElement m, Type to) {
		Matcher a = ARG.matcher(arg);
		if (!a.matches()) {
			return null;
		}
		boolean toLong = to.getSort() == Type.LONG;
		if (a.group(1) != null) {
			VariableElement p = m.getParameters().get(Integer.parseInt(a.group(1)));
			String from = lwjgl2.desc(p.asType());
			// only what Java converts implicitly: identity or primitive widening
			return from.length() == 1 && Overloads.WIDENING.get(from).contains(to.getDescriptor()) ? p.getSimpleName().toString() : null;
		}
		if (a.group(4) != null) {
			return a.group(4) + (toLong ? "L" : "");
		}
		String kind = a.group(2) != null ? a.group(2) : a.group(5);
		VariableElement p = m.getParameters().get(Integer.parseInt(a.group(2) != null ? a.group(3) : a.group(6)));
		String name = p.getSimpleName().toString();
		String type = lwjgl2.types.erasure(p.asType()).toString();
		String base;
		switch (kind) {
			case "addr" -> {
				if (!ADDRESSABLE.contains(type) || !toLong) {
					return null;
				}
				return "org.lwjgl.system.MemoryUtil.memAddressSafe(" + name + ")";
			}
			case "rem" -> {
				if (!ADDRESSABLE.contains(type)) {
					return null;
				}
				base = "org.lwjgl.system.Checks.remainingSafe(" + name + ")";
			}
			default -> {
				if (p.asType().getKind() != TypeKind.ARRAY) {
					return null;
				}
				base = "(" + name + " == null ? 0 : " + name + ".length)";
			}
		}
		if (to.getSort() != Type.INT && !toLong) {
			return null;
		}
		if (a.group(7) == null) {
			return base;
		}
		// evaluate in the parameter's width, as the LWJGL 2 code did not overflow either
		return "(" + (toLong ? "(long)" : "") + base + " " + a.group(7) + " " + a.group(8) + ")";
	}

}
