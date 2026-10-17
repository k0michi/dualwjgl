package com.koyomiji.lwjgl2w3.verify;

import org.junit.jupiter.api.Test;
import org.lwjgl.opencl.APPLESetMemObjectDestructor;
import org.lwjgl.opengl.ATIPnTriangles;
import org.lwjgl.opengl.EXTVertexShader;
import org.lwjgl.opengl.NVRegisterCombiners;

import static org.junit.jupiter.api.Assertions.*;

/** Functions LWJGL 3 no longer binds fail like LWJGL 2 does on a driver without them. */
class Lwjgl2UnsupportedFunctionsTest {

	@Test
	void reportFunctionIsNotSupported() {
		assertNotSupported(() -> ATIPnTriangles.glPNTrianglesiATI(ATIPnTriangles.GL_PN_TRIANGLES_POINT_MODE_ATI, 0));
		assertNotSupported(EXTVertexShader::glBeginVertexShaderEXT);
		assertNotSupported(() -> NVRegisterCombiners.glCombinerParameterfNV(0, 0f));
		assertNotSupported(() -> APPLESetMemObjectDestructor.clSetMemObjectDestructorAPPLE(null, null));
	}

	private static void assertNotSupported(org.junit.jupiter.api.function.Executable call) {
		IllegalStateException e = assertThrows(IllegalStateException.class, call);
		assertEquals("Function is not supported", e.getMessage());
	}

}
