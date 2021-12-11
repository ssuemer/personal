package tests;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import algorithms.AdvancedSorts;
import algorithms.CustomVector;
import algorithms.Tools;
import sortables.Point2D;

class MergeSortTest {
	
	private final int TESTBOUND = 2_000;
	private final int VECTORSIZE = 5;
	
	@Test
	void testIntegerRecursive() {
		for (int i = 1; i <= TESTBOUND; i++) {
			Integer[] toSort = Tools.generateRandomArray(i);
			AdvancedSorts.mergeSortRecursive(toSort);
			assertTrue(Tools.isSorted(toSort));
		}
	}
	
	@Test
	void testCustomVectorRecursive() {
		for (int i = 1; i <= TESTBOUND; i++) {
			CustomVector<Integer>[] toSort = Tools.randomIntegerVectorArray(i, VECTORSIZE);
			AdvancedSorts.mergeSortRecursive(toSort);
			assertTrue(Tools.isSorted(toSort));
		}
	}
	
	@Test
	void testPoint2DRecursive() {
		for (int i = 1; i <= TESTBOUND; i++) {
			Point2D[] toSort = Point2D.randomPointArray(i);
			AdvancedSorts.mergeSortRecursive(toSort);
			assertTrue(Tools.isSorted(toSort));
		}
	}
	
	@Test
	void testSimplePoint2DRecursive() {
		Point2D[] toSort = new Point2D[] {new Point2D(0,1),new Point2D(0,0),new Point2D(2,3),new Point2D(-3,-5)};
		AdvancedSorts.mergeSortRecursive(toSort);
		assertTrue(Tools.isSorted(toSort));
	}
	
	@Test
	void testIntegerBottomUp() {
		for (int i = 1; i <= TESTBOUND; i++) {
			Integer[] toSort = Tools.generateRandomArray(i);
			AdvancedSorts.bottomUpMergeSort(toSort);
			assertTrue(Tools.isSorted(toSort));
		}
	}
	
	@Test
	void testCustomVectorBottomUp() {
		for (int i = 1; i <= TESTBOUND; i++) {
			CustomVector<Integer>[] toSort = Tools.randomIntegerVectorArray(i, VECTORSIZE);
			AdvancedSorts.bottomUpMergeSort(toSort);
			assertTrue(Tools.isSorted(toSort));
		}
	}
	
	@Test
	void testPoint2DBottomUp() {
		for (int i = 1; i <= TESTBOUND; i++) {
			Point2D[] toSort = Point2D.randomPointArray(i);
			AdvancedSorts.bottomUpMergeSort(toSort);
			assertTrue(Tools.isSorted(toSort));
		}
	}
	
	@Test
	void testSimplePoint2DBottomUp() {
		Point2D[] toSort = new Point2D[] {new Point2D(0,1),new Point2D(0,0),new Point2D(2,3),new Point2D(-3,-5)};
		AdvancedSorts.bottomUpMergeSort(toSort);
		assertTrue(Tools.isSorted(toSort));
	}
	
	@Test
	void testIntegerNatural() {
		for (int i = 1; i <= TESTBOUND; i++) {
			Integer[] toSort = Tools.generateRandomArray(i);
			AdvancedSorts.naturalMergeSort(toSort);
			assertTrue(Tools.isSorted(toSort));
		}
	}
	
	@Test
	void testCustomVectorNatural() {
		for (int i = 1; i <= TESTBOUND; i++) {
			CustomVector<Integer>[] toSort = Tools.randomIntegerVectorArray(i, VECTORSIZE);
			AdvancedSorts.naturalMergeSort(toSort);
			assertTrue(Tools.isSorted(toSort));
		}
	}
	
	@Test
	void testPoint2DNatural() {
		for (int i = 1; i <= TESTBOUND; i++) {
			Point2D[] toSort = Point2D.randomPointArray(i);
			AdvancedSorts.naturalMergeSort(toSort);
			assertTrue(Tools.isSorted(toSort));
		}
	}
	
	@Test
	void testSimplePoint2DNatural() {
		Point2D[] toSort = new Point2D[] {new Point2D(0,1),new Point2D(0,0),new Point2D(2,3),new Point2D(-3,-5)};
		AdvancedSorts.naturalMergeSort(toSort);
		assertTrue(Tools.isSorted(toSort));
	}
}