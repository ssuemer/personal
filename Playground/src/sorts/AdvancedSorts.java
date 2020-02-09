package sorts;

public class AdvancedSorts{
	
	public static <T extends Comparable<T>> void heapSort(T[] array) {
		int heapsize = array.length;
		heapify(array,heapsize);
		
		for (int i = array.length - 1; i >= 1; i--) {
			swap(i,0,array,heapsize--);
			siftdown(array,heapsize,0);
		}
	}
	
	public static <T extends Comparable<T>> void mergeSortRecursive(T[] array) {
		int left = 0;
		int right = array.length - 1;
		int middle = (left + right) / 2;
		if (left < right) {
			mergeSortRecursive(array,left,middle);
			mergeSortRecursive(array,middle + 1,right);
			merge(array,left,middle,right);
		}
	}
	
	private static <T extends Comparable<T>> void mergeSortRecursive(T[] array,int left,int right) {
		int middle = (left + right) / 2;
		if (left < right) {
			mergeSortRecursive(array,left,middle);
			mergeSortRecursive(array,middle + 1,right);
			merge(array,left,middle,right);
		}
	}
	
	private static <T extends Comparable<T>> void merge(T[] array,int left,int middle,int right) {
		T[] helper = array.clone();
		int i = 0;
		int j = middle + 1;
		int k = 0;
		while (i <= middle && j <= right) {
			if (array[i].compareTo(array[j]) < 0) {
				helper[k++] = array[i++];
			} else {
				helper[k++] = array[j++];
			}
		}
		
		while (i <= middle) {
			helper[k++] = array[i++];
		}
		
		while (j <= right) {
			helper[k++] = array[j++];
		}
		
		for (int x = left; x <= right; x++) {
			array[x] = helper[x - left];
		}
	}
	
	
	
	
	
	
	// auxiliary method for <code>heapSort<code> and <code>heapify<code>
	private static <T extends Comparable<T>> void siftdown(T[] heaparray,int heapsize,int index) {
		if (index < 0 || index >= heapsize) {
			throw new IllegalArgumentException();
		}
		
		int leftindex = 2 * index + 1;
		if (leftindex < heapsize) {
			int maxindex = leftindex;
			if (leftindex + 1 < heapsize && heaparray[leftindex + 1].compareTo(heaparray[leftindex]) > 0) {
				maxindex = leftindex + 1;
			}
			if (heaparray[maxindex].compareTo(heaparray[index]) > 0) {
				swap(index,maxindex,heaparray,heapsize);
				siftdown(heaparray,heapsize,maxindex);
			}
		}
	}
	
	// auxiliary method for <code>heapSort<code>
	private static <T extends Comparable<T>> void heapify(T[] heaparray,int heapsize) {
		if (heapsize > heaparray.length) {
			throw new IllegalArgumentException();
		} 
		for (int i = (heapsize / 2) - 1; i >= 0; i--) {
			siftdown(heaparray,heapsize,i);
		}
	}
	
	private static <T extends Comparable<T>> void swap(int i,int j,T[] array,int heapsize) {
		if (heapsize > array.length || i < 0 || j < 0 || i >= heapsize || j >= heapsize) {
			throw new IllegalArgumentException();
		}
		T temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	
}
