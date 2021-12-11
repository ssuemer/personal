package misctests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import misc.HanoiVisual;

class HanoiTest {
	
	private static final int TESTBOUND = 23;
	
	@Test
	void testAll() {
		for (int i = 1; i < TESTBOUND; i++) {
			int[][] exp = expected(i);
			HanoiVisual h = new HanoiVisual(i);
			h.setDisplayMode(false);
			h.setPace(0);
			h.execute();
			assertTrue(Arrays.deepEquals(exp, h.getRods()));
		}
	}
	
	private int[][] expected(int n) {
		int[][] res = new int[n][3];
		for (int i = 0; i < n; i++) {
			res[i][2] = i + 1;
		}
		return res;
	}

}
