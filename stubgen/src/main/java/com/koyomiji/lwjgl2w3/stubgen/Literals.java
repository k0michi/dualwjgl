package com.koyomiji.lwjgl2w3.stubgen;

import javax.lang.model.type.TypeMirror;

/** Java source for constant values. */
final class Literals {

	private Literals() {
	}

	static String defaultValue(TypeMirror t) {
		return switch (t.getKind()) {
			case BOOLEAN -> "false";
			case CHAR -> "'\\0'";
			case LONG -> "0L";
			case FLOAT -> "0f";
			case DOUBLE -> "0d";
			case BYTE, SHORT, INT -> "0";
			default -> "null";
		};
	}

	static String of(Object v, TypeMirror t) {
		return switch (t.getKind()) {
			case BOOLEAN -> v.toString();
			case CHAR -> String.format("'\\u%04x'", (int)(Character)v);
			case BYTE -> "(byte) " + v;
			case SHORT -> "(short) " + v;
			case INT -> {
				int i = ((Number)v).intValue();
				yield (i >= 0x100 || i < 0) ? "0x" + Integer.toHexString(i).toUpperCase() : Integer.toString(i);
			}
			case LONG -> {
				long l = ((Number)v).longValue();
				yield (l >= 0x100 || l < 0) ? "0x" + Long.toHexString(l).toUpperCase() + "L" : l + "L";
			}
			case FLOAT -> {
				float f = (Float)v;
				yield Float.isNaN(f) ? "Float.NaN" : Float.isInfinite(f) ? (f > 0 ? "Float.POSITIVE_INFINITY" : "Float.NEGATIVE_INFINITY") : f + "f";
			}
			case DOUBLE -> {
				double d = (Double)v;
				yield Double.isNaN(d) ? "Double.NaN" : Double.isInfinite(d) ? (d > 0 ? "Double.POSITIVE_INFINITY" : "Double.NEGATIVE_INFINITY") : d + "d";
			}
			default -> "\"" + v.toString().replace("\\", "\\\\").replace("\"", "\\\"").replace("\n", "\\n").replace("\r", "\\r").replace("\t", "\\t") + "\"";
		};
	}

}
