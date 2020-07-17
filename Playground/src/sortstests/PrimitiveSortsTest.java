package sortstests;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import sorts.PrimitiveSorts;
import sorts.Tools;

class PrimitiveSortsTest {
	
	private final int TESTBOUND = 2_000;
	
	@Test
	void testBubbleSort() {
		for (int i = 1; i <= TESTBOUND; i++) {
			Integer[] toSort = Tools.generateRandomArray(i);
			PrimitiveSorts.bubbleSort(toSort);
			assertTrue(Tools.isSorted(toSort));
		}
	}
	
	@Test
	void testSelectionSort() {
		for (int i = 1; i <= TESTBOUND; i++) {
			Integer[] toSort = Tools.generateRandomArray(i);
			PrimitiveSorts.selectionSort(toSort);
			assertTrue(Tools.isSorted(toSort));
		}
	}
	
	@Test
	void testInsertionSort() {
		for (int i = 1; i <= TESTBOUND; i++) {
			Integer[] toSort = Tools.generateRandomArray(i);
			PrimitiveSorts.insertionSort(toSort);
			assertTrue(Tools.isSorted(toSort));
		}
	}

}
