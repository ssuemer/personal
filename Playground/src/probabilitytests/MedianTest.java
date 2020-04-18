package probabilitytests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

import org.junit.jupiter.api.Test;

import probability.Median;
import sorts.AdvancedSorts;

class MedianTest {

	@Test
	void testKG() {
		Integer[] array = generateRandomArray(999);
		Integer[] copy = array.clone();
		double eps = 0.5;
		int amount = 333;
		int k = AdvancedSorts.quickSelect(copy, (int) Math.floor((1 - eps) * copy.length / 2) - 1);
		int g = AdvancedSorts.quickSelect(copy, (int) Math.ceil((1 + eps) * copy.length / 2) - 1);
		double totalK = 0;
		double totalG = 0;
		Median toTest = new Median(array);
		int sims = 100000;
		for (int i = 0; i < sims; i++) {
			Integer[] result = toTest.pick(amount);
			for (Integer b : result) {
				if (b <= k) {
					totalK++;
				}
				if (b > g) {
					totalG++;
				}
			}
		}
		totalK /= sims;
		totalG /= sims;
		assertEquals(toTest.calcK(amount, eps),totalK,0.1);
		assertEquals(toTest.calcG(amount, eps),totalG,0.1);
	}
	
	
	
	private Integer[] generateRandomArray(int n) {
		Random randomgen = new Random();
		Integer[] toReturn = new Integer[n];
		for (int i = 0; i < toReturn.length; i++) {
			toReturn[i] = randomgen.nextInt();
			if (randomgen.nextBoolean()) {
				toReturn[i] *= -1;
			}
		}
		return toReturn;
	}

}
