package tests;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import algorithms.AdvancedSorts;
import algorithms.CustomVector;
import algorithms.Tools;
import sortables.Point2D;

class HeapSortTest {
	
	private final int TESTBOUND = 2_000;
	private final int VECTORSIZE = 5;
	
	@Test
	void testInteger() {
		for (int i = 1; i <= TESTBOUND; i++) {
			Integer[] toSort = Tools.generateRandomArray(i);
			AdvancedSorts.heapSort(toSort);
			assertTrue(Tools.isSorted(toSort));
		}
	}
	
	@Test
	void testCustomVector() {
		for (int i = 1; i <= TESTBOUND; i++) {
			CustomVector<Integer>[] toSort = Tools.randomIntegerVectorArray(i, VECTORSIZE);
			AdvancedSorts.heapSort(toSort);
			assertTrue(Tools.isSorted(toSort));
		}
	}
	
	@Test
	void testPoint2D() {
		for (int i = 1; i <= TESTBOUND; i++) {
			Point2D[] toSort = Point2D.randomPointArray(i);
			AdvancedSorts.heapSort(toSort);
			assertTrue(Tools.isSorted(toSort));
		}
	}
	
	@Test
	void testSimplePoint2D() {
		Point2D[] toSort = new Point2D[] {new Point2D(0,1),new Point2D(0,0),new Point2D(2,3),new Point2D(-3,-5)};
		AdvancedSorts.heapSort(toSort);
		assertTrue(Tools.isSorted(toSort));
	}
}
