package com.koyomiji.lwjgl2w3.verify;

import org.junit.jupiter.api.Test;
import org.lwjgl.PointerBuffer;

import static org.junit.jupiter.api.Assertions.*;

class Lwjgl3HandWrittenTest {

	@Test
	void pointerBufferFactoriesStillWork() {
		PointerBuffer pb = PointerBuffer.allocateDirect(2);
		pb.put(1, 5L);
		assertEquals(5L, pb.get(1));
	}

}
