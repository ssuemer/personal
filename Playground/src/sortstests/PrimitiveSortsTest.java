package sortstests;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.Random;

import org.junit.jupiter.api.Test;

import sorts.PrimitiveSorts;

class PrimitiveSortsTest {

	@Test
	void testBubbleSort() {
		for (int i = 1; i <= 1000; i++) {
			Integer[] toSortAlg = generateRandomArray(i);
			Integer[] toSortExp = toSortAlg.clone();
			Arrays.sort(toSortExp);
			PrimitiveSorts.bubbleSort(toSortAlg);
			assertArrayEquals(toSortExp, toSortAlg);
		}
	}
	
	@Test
	void testSelectionSort() {
		for (int i = 1; i <= 1000; i++) {
			Integer[] toSortAlg = generateRandomArray(i);
			Integer[] toSortExp = toSortAlg.clone();
			Arrays.sort(toSortExp);
			PrimitiveSorts.selectionSort(toSortAlg);
			assertArrayEquals(toSortExp, toSortAlg);
		}
	}
	
	@Test
	void testInsertionSort() {
		for (int i = 1; i <= 1000; i++) {
			Integer[] toSortAlg = generateRandomArray(i);
			Integer[] toSortExp = toSortAlg.clone();
			Arrays.sort(toSortExp);
			PrimitiveSorts.insertionSort(toSortAlg);
			assertArrayEquals(toSortExp, toSortAlg);
		}
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
