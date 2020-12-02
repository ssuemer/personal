package sortstests;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import sorts.ParallelSorts;
import sorts.Tools;

class ParallelSortsTest {
	
	private final int TESTBOUND = 100;
	
	@Test
	void testMergeSortSimple() {
		Integer[] toSort = new Integer[] {10,9,8,7,6,5,4,3,2,1,11,13,12,14,15,18,17,16,19,20,21,23,22};
		ParallelSorts.mergeSort(toSort);
		assertTrue(Tools.isSorted(toSort));
	}
	
	@Test
	void testMergeSort() {
		for (int i = 1; i <= TESTBOUND; i++) {
			Integer[] toSort = Tools.generateRandomArray(i);
			ParallelSorts.mergeSort(toSort);
			assertTrue(Tools.isSorted(toSort));
		}
	}
}
