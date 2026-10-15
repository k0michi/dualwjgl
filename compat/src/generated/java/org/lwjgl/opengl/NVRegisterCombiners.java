package org.lwjgl.opengl;

import com.koyomiji.lwjgl2w3.inject.Generated;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

@Generated
public final class NVRegisterCombiners {
	public static final int GL_REGISTER_COMBINERS_NV = 0x8522;
	public static final int GL_COMBINER0_NV = 0x8550;
	public static final int GL_COMBINER1_NV = 0x8551;
	public static final int GL_COMBINER2_NV = 0x8552;
	public static final int GL_COMBINER3_NV = 0x8553;
	public static final int GL_COMBINER4_NV = 0x8554;
	public static final int GL_COMBINER5_NV = 0x8555;
	public static final int GL_COMBINER6_NV = 0x8556;
	public static final int GL_COMBINER7_NV = 0x8557;
	public static final int GL_VARIABLE_A_NV = 0x8523;
	public static final int GL_VARIABLE_B_NV = 0x8524;
	public static final int GL_VARIABLE_C_NV = 0x8525;
	public static final int GL_VARIABLE_D_NV = 0x8526;
	public static final int GL_VARIABLE_E_NV = 0x8527;
	public static final int GL_VARIABLE_F_NV = 0x8528;
	public static final int GL_VARIABLE_G_NV = 0x8529;
	public static final int GL_CONSTANT_COLOR0_NV = 0x852A;
	public static final int GL_CONSTANT_COLOR1_NV = 0x852B;
	public static final int GL_PRIMARY_COLOR_NV = 0x852C;
	public static final int GL_SECONDARY_COLOR_NV = 0x852D;
	public static final int GL_SPARE0_NV = 0x852E;
	public static final int GL_SPARE1_NV = 0x852F;
	public static final int GL_UNSIGNED_IDENTITY_NV = 0x8536;
	public static final int GL_UNSIGNED_INVERT_NV = 0x8537;
	public static final int GL_EXPAND_NORMAL_NV = 0x8538;
	public static final int GL_EXPAND_NEGATE_NV = 0x8539;
	public static final int GL_HALF_BIAS_NORMAL_NV = 0x853A;
	public static final int GL_HALF_BIAS_NEGATE_NV = 0x853B;
	public static final int GL_SIGNED_IDENTITY_NV = 0x853C;
	public static final int GL_SIGNED_NEGATE_NV = 0x853D;
	public static final int GL_E_TIMES_F_NV = 0x8531;
	public static final int GL_SPARE0_PLUS_SECONDARY_COLOR_NV = 0x8532;
	public static final int GL_SCALE_BY_TWO_NV = 0x853E;
	public static final int GL_SCALE_BY_FOUR_NV = 0x853F;
	public static final int GL_SCALE_BY_ONE_HALF_NV = 0x8540;
	public static final int GL_BIAS_BY_NEGATIVE_ONE_HALF_NV = 0x8541;
	public static final int GL_DISCARD_NV = 0x8530;
	public static final int GL_COMBINER_INPUT_NV = 0x8542;
	public static final int GL_COMBINER_MAPPING_NV = 0x8543;
	public static final int GL_COMBINER_COMPONENT_USAGE_NV = 0x8544;
	public static final int GL_COMBINER_AB_DOT_PRODUCT_NV = 0x8545;
	public static final int GL_COMBINER_CD_DOT_PRODUCT_NV = 0x8546;
	public static final int GL_COMBINER_MUX_SUM_NV = 0x8547;
	public static final int GL_COMBINER_SCALE_NV = 0x8548;
	public static final int GL_COMBINER_BIAS_NV = 0x8549;
	public static final int GL_COMBINER_AB_OUTPUT_NV = 0x854A;
	public static final int GL_COMBINER_CD_OUTPUT_NV = 0x854B;
	public static final int GL_COMBINER_SUM_OUTPUT_NV = 0x854C;
	public static final int GL_NUM_GENERAL_COMBINERS_NV = 0x854E;
	public static final int GL_COLOR_SUM_CLAMP_NV = 0x854F;
	public static final int GL_MAX_GENERAL_COMBINERS_NV = 0x854D;

	private NVRegisterCombiners() {
	}

	public static void glCombinerParameterfNV(int pname, float param) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glCombinerParameterNV(int pname, FloatBuffer params) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glCombinerParameteriNV(int pname, int param) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glCombinerParameterNV(int pname, IntBuffer params) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glCombinerInputNV(int stage, int portion, int variable, int input, int mapping, int componentUsage) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glCombinerOutputNV(int stage, int portion, int abOutput, int cdOutput, int sumOutput, int scale, int bias, boolean abDotProduct, boolean cdDotProduct, boolean muxSum) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glFinalCombinerInputNV(int variable, int input, int mapping, int componentUsage) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glGetCombinerInputParameterNV(int stage, int portion, int variable, int pname, FloatBuffer params) {
		throw new IllegalStateException("Function is not supported");
	}

	public static float glGetCombinerInputParameterfNV(int stage, int portion, int variable, int pname) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glGetCombinerInputParameterNV(int stage, int portion, int variable, int pname, IntBuffer params) {
		throw new IllegalStateException("Function is not supported");
	}

	public static int glGetCombinerInputParameteriNV(int stage, int portion, int variable, int pname) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glGetCombinerOutputParameterNV(int stage, int portion, int pname, FloatBuffer params) {
		throw new IllegalStateException("Function is not supported");
	}

	public static float glGetCombinerOutputParameterfNV(int stage, int portion, int pname) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glGetCombinerOutputParameterNV(int stage, int portion, int pname, IntBuffer params) {
		throw new IllegalStateException("Function is not supported");
	}

	public static int glGetCombinerOutputParameteriNV(int stage, int portion, int pname) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glGetFinalCombinerInputParameterNV(int variable, int pname, FloatBuffer params) {
		throw new IllegalStateException("Function is not supported");
	}

	public static float glGetFinalCombinerInputParameterfNV(int variable, int pname) {
		throw new IllegalStateException("Function is not supported");
	}

	public static void glGetFinalCombinerInputParameterNV(int variable, int pname, IntBuffer params) {
		throw new IllegalStateException("Function is not supported");
	}

	public static int glGetFinalCombinerInputParameteriNV(int variable, int pname) {
		throw new IllegalStateException("Function is not supported");
	}
}
