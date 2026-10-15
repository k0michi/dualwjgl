package com.koyomiji.lwjgl2w3.stubgen;

/** Java source built line by line; {@link #open} and {@link #close} manage the indentation. */
final class Code {

	private final StringBuilder out = new StringBuilder();
	private int depth;

	Code line(String s) {
		out.append("\t".repeat(depth)).append(s).append('\n');
		return this;
	}

	Code blank() {
		out.append('\n');
		return this;
	}

	/** Writes {@code header} and an opening brace, and indents what follows until {@link #close}. */
	Code open(String header) {
		line(header + " {");
		depth++;
		return this;
	}

	Code close() {
		depth--;
		return line("}");
	}

	@Override
	public String toString() {
		return out.toString();
	}

}
