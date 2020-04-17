package sortstests;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.Random;

import org.junit.jupiter.api.Test;

import sorts.AdvancedSorts;

class AdvancedSortsTest {

	@Test
	void testHeapSort() {
		for (int i = 1; i <= 3000; i++) {
			Integer[] toSortAlg = generateRandomArray(i);
			Integer[] toSortExp = toSortAlg.clone();
			Arrays.sort(toSortExp);
			AdvancedSorts.heapSort(toSortAlg);
			assertArrayEquals(toSortExp, toSortAlg);
		}
	}
	
	@Test
	void testMergeSortRecursive() {
		for (int i = 1; i <= 3000; i++) {
			Integer[] toSortAlg = generateRandomArray(i);
			Integer[] toSortExp = toSortAlg.clone();
			Arrays.sort(toSortExp);
			AdvancedSorts.mergeSortRecursive(toSortAlg);
			assertArrayEquals(toSortExp, toSortAlg);
		}
	}
	
	@Test
	void testBottomUpMergeSort() {
		for (int i = 1; i <= 3000; i++) {
			Integer[] toSortAlg = generateRandomArray(i);
			Integer[] toSortExp = toSortAlg.clone();
			Arrays.sort(toSortExp);
			AdvancedSorts.bottomUpMergeSort(toSortAlg);
			assertArrayEquals(toSortExp, toSortAlg);
		}
	}
	
	@Test
	void testNaturalMergeSort() {
		for (int i = 1; i <= 3000; i++) {
			Integer[] toSortAlg = generateRandomArray(i);
			Integer[] toSortExp = toSortAlg.clone();
			Arrays.sort(toSortExp);
			AdvancedSorts.naturalMergeSort(toSortAlg);
			assertArrayEquals(toSortExp, toSortAlg);
		}
	}
	
	@Test
	void testQuickSort() {
		for (int i = 1; i <= 3000; i++) {
			Integer[] toSortAlg = generateRandomArray(i);
			Integer[] toSortExp = toSortAlg.clone();
			Arrays.sort(toSortExp);
			AdvancedSorts.quickSort(toSortAlg);
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
