package org.lwjgl.opengl;

import com.koyomiji.dualwjgl.inject.Generated;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

@Generated
public final class EXTVertexShader {
	public static final int GL_VERTEX_SHADER_EXT = 0x8780;
	public static final int GL_VERTEX_SHADER_BINDING_EXT = 0x8781;
	public static final int GL_OP_INDEX_EXT = 0x8782;
	public static final int GL_OP_NEGATE_EXT = 0x8783;
	public static final int GL_OP_DOT3_EXT = 0x8784;
	public static final int GL_OP_DOT4_EXT = 0x8785;
	public static final int GL_OP_MUL_EXT = 0x8786;
	public static final int GL_OP_ADD_EXT = 0x8787;
	public static final int GL_OP_MADD_EXT = 0x8788;
	public static final int GL_OP_FRAC_EXT = 0x8789;
	public static final int GL_OP_MAX_EXT = 0x878A;
	public static final int GL_OP_MIN_EXT = 0x878B;
	public static final int GL_OP_SET_GE_EXT = 0x878C;
	public static final int GL_OP_SET_LT_EXT = 0x878D;
	public static final int GL_OP_CLAMP_EXT = 0x878E;
	public static final int GL_OP_FLOOR_EXT = 0x878F;
	public static final int GL_OP_ROUND_EXT = 0x8790;
	public static final int GL_OP_EXP_BASE_2_EXT = 0x8791;
	public static final int GL_OP_LOG_BASE_2_EXT = 0x8792;
	public static final int GL_OP_POWER_EXT = 0x8793;
	public static final int GL_OP_RECIP_EXT = 0x8794;
	public static final int GL_OP_RECIP_SQRT_EXT = 0x8795;
	public static final int GL_OP_SUB_EXT = 0x8796;
	public static final int GL_OP_CROSS_PRODUCT_EXT = 0x8797;
	public static final int GL_OP_MULTIPLY_MATRIX_EXT = 0x8798;
	public static final int GL_OP_MOV_EXT = 0x8799;
	public static final int GL_OUTPUT_VERTEX_EXT = 0x879A;
	public static final int GL_OUTPUT_COLOR0_EXT = 0x879B;
	public static final int GL_OUTPUT_COLOR1_EXT = 0x879C;
	public static final int GL_OUTPUT_TEXTURE_COORD0_EXT = 0x879D;
	public static final int GL_OUTPUT_TEXTURE_COORD1_EXT = 0x879E;
	public static final int GL_OUTPUT_TEXTURE_COORD2_EXT = 0x879F;
	public static final int GL_OUTPUT_TEXTURE_COORD3_EXT = 0x87A0;
	public static final int GL_OUTPUT_TEXTURE_COORD4_EXT = 0x87A1;
	public static final int GL_OUTPUT_TEXTURE_COORD5_EXT = 0x87A2;
	public static final int GL_OUTPUT_TEXTURE_COORD6_EXT = 0x87A3;
	public static final int GL_OUTPUT_TEXTURE_COORD7_EXT = 0x87A4;
	public static final int GL_OUTPUT_TEXTURE_COORD8_EXT = 0x87A5;
	public static final int GL_OUTPUT_TEXTURE_COORD9_EXT = 0x87A6;
	public static final int GL_OUTPUT_TEXTURE_COORD10_EXT = 0x87A7;
	public static final int GL_OUTPUT_TEXTURE_COORD11_EXT = 0x87A8;
	public static final int GL_OUTPUT_TEXTURE_COORD12_EXT = 0x87A9;
	public static final int GL_OUTPUT_TEXTURE_COORD13_EXT = 0x87AA;
	public static final int GL_OUTPUT_TEXTURE_COORD14_EXT = 0x87AB;
	public static final int GL_OUTPUT_TEXTURE_COORD15_EXT = 0x87AC;
	public static final int GL_OUTPUT_TEXTURE_COORD16_EXT = 0x87AD;
	public static final int GL_OUTPUT_TEXTURE_COORD17_EXT = 0x87AE;
	public static final int GL_OUTPUT_TEXTURE_COORD18_EXT = 0x87AF;
	public static final int GL_OUTPUT_TEXTURE_COORD19_EXT = 0x87B0;
	public static final int GL_OUTPUT_TEXTURE_COORD20_EXT = 0x87B1;
	public static final int GL_OUTPUT_TEXTURE_COORD21_EXT = 0x87B2;
	public static final int GL_OUTPUT_TEXTURE_COORD22_EXT = 0x87B3;
	public static final int GL_OUTPUT_TEXTURE_COORD23_EXT = 0x87B4;
	public static final int GL_OUTPUT_TEXTURE_COORD24_EXT = 0x87B5;
	public static final int GL_OUTPUT_TEXTURE_COORD25_EXT = 0x87B6;
	public static final int GL_OUTPUT_TEXTURE_COORD26_EXT = 0x87B7;
	public static final int GL_OUTPUT_TEXTURE_COORD27_EXT = 0x87B8;
	public static final int GL_OUTPUT_TEXTURE_COORD28_EXT = 0x87B9;
	public static final int GL_OUTPUT_TEXTURE_COORD29_EXT = 0x87BA;
	public static final int GL_OUTPUT_TEXTURE_COORD30_EXT = 0x87BB;
	public static final int GL_OUTPUT_TEXTURE_COORD31_EXT = 0x87BC;
	public static final int GL_OUTPUT_FOG_EXT = 0x87BD;
	public static final int GL_SCALAR_EXT = 0x87BE;
	public static final int GL_VECTOR_EXT = 0x87BF;
	public static final int GL_MATRIX_EXT = 0x87C0;
	public static final int GL_VARIANT_EXT = 0x87C1;
	public static final int GL_INVARIANT_EXT = 0x87C2;
	public static final int GL_LOCAL_CONSTANT_EXT = 0x87C3;
	public static final int GL_LOCAL_EXT = 0x87C4;
	public static final int GL_MAX_VERTEX_SHADER_INSTRUCTIONS_EXT = 0x87C5;
	public static final int GL_MAX_VERTEX_SHADER_VARIANTS_EXT = 0x87C6;
	public static final int GL_MAX_VERTEX_SHADER_INVARIANTS_EXT = 0x87C7;
	public static final int GL_MAX_VERTEX_SHADER_LOCAL_CONSTANTS_EXT = 0x87C8;
	public static final int GL_MAX_VERTEX_SHADER_LOCALS_EXT = 0x87C9;
	public static final int GL_MAX_OPTIMIZED_VERTEX_SHADER_INSTRUCTIONS_EXT = 0x87CA;
	public static final int GL_MAX_OPTIMIZED_VERTEX_SHADER_VARIANTS_EXT = 0x87CB;
	public static final int GL_MAX_OPTIMIZED_VERTEX_SHADER_INVARIANTS_EXT = 0x87CC;
	public static final int GL_MAX_OPTIMIZED_VERTEX_SHADER_LOCAL_CONSTANTS_EXT = 0x87CD;
	public static final int GL_MAX_OPTIMIZED_VERTEX_SHADER_LOCALS_EXT = 0x87CE;
	public static final int GL_VERTEX_SHADER_INSTRUCTIONS_EXT = 0x87CF;
	public static final int GL_VERTEX_SHADER_VARIANTS_EXT = 0x87D0;
	public static final int GL_VERTEX_SHADER_INVARIANTS_EXT = 0x87D1;
	public static final int GL_VERTEX_SHADER_LOCAL_CONSTANTS_EXT = 0x87D2;
	public static final int GL_VERTEX_SHADER_LOCALS_EXT = 0x87D3;
	public static final int GL_VERTEX_SHADER_OPTIMIZED_EXT = 0x87D4;
	public static final int GL_X_EXT = 0x87D5;
	public static final int GL_Y_EXT = 0x87D6;
	public static final int GL_Z_EXT = 0x87D7;
	public static final int GL_W_EXT = 0x87D8;
	public static final int GL_NEGATIVE_X_EXT = 0x87D9;
	public static final int GL_NEGATIVE_Y_EXT = 0x87DA;
	public static final int GL_NEGATIVE_Z_EXT = 0x87DB;
	public static final int GL_NEGATIVE_W_EXT = 0x87DC;
	public static final int GL_ZERO_EXT = 0x87DD;
	public static final int GL_ONE_EXT = 0x87DE;
	public static final int GL_NEGATIVE_ONE_EXT = 0x87DF;
	public static final int GL_NORMALIZED_RANGE_EXT = 0x87E0;
	public static final int GL_FULL_RANGE_EXT = 0x87E1;
	public static final int GL_CURRENT_VERTEX_EXT = 0x87E2;
	public static final int GL_MVP_MATRIX_EXT = 0x87E3;
	public static final int GL_VARIANT_VALUE_EXT = 0x87E4;
	public static final int GL_VARIANT_DATATYPE_EXT = 0x87E5;
	public static final int GL_VARIANT_ARRAY_STRIDE_EXT = 0x87E6;
	public static final int GL_VARIANT_ARRAY_TYPE_EXT = 0x87E7;
	public static final int GL_VARIANT_ARRAY_EXT = 0x87E8;
	public static final int GL_VARIANT_ARRAY_POINTER_EXT = 0x87E9;
	public static final int GL_INVARIANT_VALUE_EXT = 0x87EA;
	public static final int GL_INVARIANT_DATATYPE_EXT = 0x87EB;
	public static final int GL_LOCAL_CONSTANT_VALUE_EXT = 0x87EC;
	public static final int GL_LOCAL_CONSTANT_DATATYPE_EXT = 0x87ED;

	private EXTVertexShader() {
	}

	public static void glBeginVertexShaderEXT() {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glEndVertexShaderEXT() {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glBindVertexShaderEXT(int id) {
		throw new IllegalStateException("Function is not supported");
	}

	public static int glGenVertexShadersEXT(int range) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glDeleteVertexShaderEXT(int id) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glShaderOp1EXT(int op, int res, int arg1) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glShaderOp2EXT(int op, int res, int arg1, int arg2) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glShaderOp3EXT(int op, int res, int arg1, int arg2, int arg3) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glSwizzleEXT(int res, int in, int outX, int outY, int outZ, int outW) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glWriteMaskEXT(int res, int in, int outX, int outY, int outZ, int outW) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glInsertComponentEXT(int res, int src, int num) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glExtractComponentEXT(int res, int src, int num) {
		throw new IllegalStateException("Function is not supported");
	}

	public static int glGenSymbolsEXT(int dataType, int storageType, int range, int components) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glSetInvariantEXT(int id, DoubleBuffer pAddr) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glSetInvariantEXT(int id, FloatBuffer pAddr) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glSetInvariantEXT(int id, boolean unsigned, ByteBuffer pAddr) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glSetInvariantEXT(int id, boolean unsigned, IntBuffer pAddr) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glSetInvariantEXT(int id, boolean unsigned, ShortBuffer pAddr) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glSetLocalConstantEXT(int id, DoubleBuffer pAddr) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glSetLocalConstantEXT(int id, FloatBuffer pAddr) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glSetLocalConstantEXT(int id, boolean unsigned, ByteBuffer pAddr) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glSetLocalConstantEXT(int id, boolean unsigned, IntBuffer pAddr) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glSetLocalConstantEXT(int id, boolean unsigned, ShortBuffer pAddr) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glVariantEXT(int id, ByteBuffer pAddr) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glVariantEXT(int id, ShortBuffer pAddr) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glVariantEXT(int id, IntBuffer pAddr) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glVariantEXT(int id, FloatBuffer pAddr) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glVariantEXT(int id, DoubleBuffer pAddr) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glVariantuEXT(int id, ByteBuffer pAddr) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glVariantuEXT(int id, ShortBuffer pAddr) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glVariantuEXT(int id, IntBuffer pAddr) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glVariantPointerEXT(int id, int stride, DoubleBuffer pAddr) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glVariantPointerEXT(int id, int stride, FloatBuffer pAddr) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glVariantPointerEXT(int id, boolean unsigned, int stride, ByteBuffer pAddr) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glVariantPointerEXT(int id, boolean unsigned, int stride, IntBuffer pAddr) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glVariantPointerEXT(int id, boolean unsigned, int stride, ShortBuffer pAddr) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glVariantPointerEXT(int id, int type, int stride, long pAddr_buffer_offset) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glEnableVariantClientStateEXT(int id) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glDisableVariantClientStateEXT(int id) {
		throw new IllegalStateException("Function is not supported");
	}

	public static int glBindLightParameterEXT(int light, int value) {
		throw new IllegalStateException("Function is not supported");
	}

	public static int glBindMaterialParameterEXT(int face, int value) {
		throw new IllegalStateException("Function is not supported");
	}

	public static int glBindTexGenParameterEXT(int unit, int coord, int value) {
		throw new IllegalStateException("Function is not supported");
	}

	public static int glBindTextureUnitParameterEXT(int unit, int value) {
		throw new IllegalStateException("Function is not supported");
	}

	public static int glBindParameterEXT(int value) {
		throw new IllegalStateException("Function is not supported");
	}

	public static boolean glIsVariantEnabledEXT(int id, int cap) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glGetVariantBooleanEXT(int id, int value, ByteBuffer pbData) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glGetVariantIntegerEXT(int id, int value, IntBuffer pbData) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glGetVariantFloatEXT(int id, int value, FloatBuffer pbData) {
		throw new IllegalStateException("Function is not supported");
	}

	public static ByteBuffer glGetVariantPointerEXT(int id, int value, long result_size) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glGetInvariantBooleanEXT(int id, int value, ByteBuffer pbData) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glGetInvariantIntegerEXT(int id, int value, IntBuffer pbData) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glGetInvariantFloatEXT(int id, int value, FloatBuffer pbData) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glGetLocalConstantBooleanEXT(int id, int value, ByteBuffer pbData) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glGetLocalConstantIntegerEXT(int id, int value, IntBuffer pbData) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glGetLocalConstantFloatEXT(int id, int value, FloatBuffer pbData) {
		throw new IllegalStateException("Function is not supported");
	}
}
