package sortstests;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import sorts.AdvancedSorts;
import sorts.Tools;

class AdvancedSortsTest {
	
	private final int TESTBOUND = 3_000;
	
	@Test
	void testHeapSort() {
		for (int i = 1; i <= TESTBOUND; i++) {
			Integer[] toSort = Tools.generateRandomArray(i);
			AdvancedSorts.heapSort(toSort);
			assertTrue(Tools.isSorted(toSort));
		}
	}
	
	@Test
	void testMergeSortRecursive() {
		for (int i = 1; i <= TESTBOUND; i++) {
			Integer[] toSort = Tools.generateRandomArray(i);
			AdvancedSorts.mergeSortRecursive(toSort);
			assertTrue(Tools.isSorted(toSort));
		}
	}
	
	@Test
	void testBottomUpMergeSort() {
		for (int i = 1; i <= TESTBOUND; i++) {
			Integer[] toSort = Tools.generateRandomArray(i);
			AdvancedSorts.bottomUpMergeSort(toSort);
			assertTrue(Tools.isSorted(toSort));
		}
	}
	
	@Test
	void testNaturalMergeSort() {
		for (int i = 1; i <= TESTBOUND; i++) {
			Integer[] toSort = Tools.generateRandomArray(i);
			AdvancedSorts.naturalMergeSort(toSort);
			assertTrue(Tools.isSorted(toSort));
		}
	}
	
	@Test
	void testQuickSort() {
		for (int i = 1; i <= TESTBOUND; i++) {
			Integer[] toSort = Tools.generateRandomArray(i);
			AdvancedSorts.quickSort(toSort);
			assertTrue(Tools.isSorted(toSort));
		}
	}
	


}
