package sortstests;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import misc.Point2D;
import sorts.CustomVector;
import sorts.PrimitiveSorts;
import sorts.Tools;

class SelectionSortTest {
	
	private final int TESTBOUND = 2_000;
	private final int VECTORSIZE = 5;
	
	@Test
	void testInteger() {
		for (int i = 1; i <= TESTBOUND; i++) {
			Integer[] toSort = Tools.generateRandomArray(i);
			PrimitiveSorts.selectionSort(toSort);
			assertTrue(Tools.isSorted(toSort));
		}
	}
	
	@Test
	void testCustomVector() {
		for (int i = 1; i <= TESTBOUND; i++) {
			CustomVector<Integer>[] toSort = Tools.randomIntegerVectorArray(i, VECTORSIZE);
			PrimitiveSorts.selectionSort(toSort);
			assertTrue(Tools.isSorted(toSort));
		}
	}
	
	@Test
	void testPoint2D() {
		for (int i = 1; i <= TESTBOUND; i++) {
			Point2D[] toSort = Point2D.randomPointArray(i);
			PrimitiveSorts.selectionSort(toSort);
			assertTrue(Tools.isSorted(toSort));
		}
	}
	
	@Test
	void testSimplePoint2D() {
		Point2D[] toSort = new Point2D[] {new Point2D(0,1),new Point2D(0,0),new Point2D(2,3),new Point2D(-3,-5)};
		PrimitiveSorts.selectionSort(toSort);
		assertTrue(Tools.isSorted(toSort));
	}
}