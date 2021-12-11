package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Random;

import org.junit.jupiter.api.Test;

import algorithms.Tools;

class OtherTests {

	@Test
	void testrandrange() {
		double count = 0;
		for (int i = 0; i < 10000; i++) {
			int k = Tools.randrange(1, 10000);
			if (k <= 100) {
				count++;
			}
		}
		assertEquals(0.01,count / 10000,0.01);
	}
	
	@Test
	void testquickselect() {
		Random randomgen = new Random();
		for (int i = 0; i < 10000; i++) {
			Integer[] algarr = Tools.generateRandomArray(1000);
			Integer[] exparr = algarr.clone();
			int k = randomgen.nextInt(1000);
			Arrays.sort(exparr);
			assertEquals(exparr[k],Tools.quickSelect(algarr, k));
		}
	}
	


}
