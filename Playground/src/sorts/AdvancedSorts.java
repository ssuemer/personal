package sorts;

import java.util.ArrayList;

import ds.ResizableMaxHeap;

public class AdvancedSorts {
	
	public static <T extends Comparable<T>> void heapSort(T[] array) {
		ResizableMaxHeap<T> mixedheap = new ResizableMaxHeap<T>(array);
		for (int i = 0; i < array.length; i++) {
			mixedheap.moveMaxToRest();
		}
		
		ArrayList<T> heap = mixedheap.getHeap();
		for (int i = 0; i < heap.size(); i++) {
			array[i] = heap.get(i);
		}
	}
	
}
