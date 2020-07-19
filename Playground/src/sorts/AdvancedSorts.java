package sorts;

/**
 * 
 * @author Sarp Suemer 17.07.2020
 *	Provides sequential advanced sorting algorithms with type arguments.
 *	Implementing using type arguments is more efficient for large data sets compared to
 *  using Comparable as type.Quick sort and heap sort are exceptionally faster compared to
 *  the merge sort variants.
 */
public class AdvancedSorts {
	
	/**
	 * @param <T> Type of the elements to sort,must implement Comparable.
	 * @param array The array to sort,must contain elements of type T.
	 * 
	 * @implNote Simple heap sort algorithm,the underlying heap is implemented in an array.
	 */
	public static <T extends Comparable<T>> void heapSort(T[] array) {
		int heapsize = array.length;
		heapify(array,heapsize);
		
		for (int i = array.length - 1; i >= 1; i--) {
			swap(i,0,array,heapsize--);
			siftdown(array,heapsize,0);
		}
	}
	
	/**
	 * @param <T> Type of the elements to sort,must implement Comparable.
	 * @param array The array to sort,must contain elements of type T.
	 * 
	 * @implNote Recursive merge sort algorithm.
	 */
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
	
	/**
	 * @param <T> Type of the elements to sort,must implement Comparable.
	 * @param array The array to sort,must contain elements of type T.
	 * 
	 * @implNote Bottom-up merge sort algorithm,evades the overhead of method
	 * calls when using the recursive variant.
	 */
	public static <T extends Comparable<T>> void bottomUpMergeSort(T[] array) {
		int length = 1;
		while (length < array.length) {
			int right = -1;
			while (right + length < array.length) {
				int left = right + 1;
				int middle = left + length - 1;
				right = Math.min(array.length - 1, middle + length);
				merge(array,left,middle,right);
			}
			length *= 2;
		}
	}
	
	/**
	 * @param <T> Type of the elements to sort,must implement Comparable.
	 * @param array The array to sort,must contain elements of type T.
	 * 
	 * @implNote Natural merge sort algorithm.Takes advantage of already sorted
	 * parts of the array.
	 */
	public static <T extends Comparable<T>> void naturalMergeSort(T[] array) {
		int left = 0;
		do {
			int right = -1;
			while (right < array.length - 1) {
				left = right + 1;
				int middle = left;
				while (middle < array.length - 1 && array[middle + 1].compareTo(array[middle]) >= 0) {
					middle++;
				}
				if (middle < array.length - 1) {
					right = middle + 1;
					while (right < array.length - 1 && array[right + 1].compareTo(array[right]) >= 0) {
						right++;
					}
					merge(array,left,middle,right);
				} else {
					right = array.length - 1;
				}
			}
		} while (left > 0);
	}
	
	/**
	 * @param <T> Type of the elements to sort,must implement Comparable.
	 * @param array The array to sort,must contain elements of type T.
	 * 
	 * @implNote Quick sort algorithm with uniform randomly chosen pivot.
	 */
	public static <T extends Comparable<T>> void quickSort(T[] array) {
		quickSort(array,0,array.length - 1);
	}

	private static <T extends Comparable<T>> void quickSort(T[] array,int left,int right) {
		if (left < right) {
			int pivot = Tools.randrange(left,right);
			int k = Tools.partition(array,left,right,pivot);
			quickSort(array,left,k - 1);
			quickSort(array,k + 1,right);
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
	
	/**
	 * @param <T> Type of the elements of the array.
	 * @param array Array to merge elements in.
	 * @param left Left boundary of merge interval (inclusive)
	 * @param middle Middle point of the merge interval,also last element of the left merge interval.
	 * @param right Right boundary of the merge interval (inclusive)
	 * 
	 * @implNote Merges the subarray left - middle and middle + 1 - right into one sorted subarray.The two provided subarrays
	 * must be sorted themselves.
	 */
	public static <T extends Comparable<T>> void merge(T[] array,int left,int middle,int right) {
		T[] help = array.clone();
		int i = left;
		int j = middle + 1;
		int k = 0;
		while (i <= middle && j <= right) {
			if (array[i].compareTo(array[j]) < 0) {
				help[k++] = array[i++];
			} else {
				help[k++] = array[j++];
			}
		}
		
		while (i <= middle) {
			help[k++] = array[i++];
		}
	
		while (j <= right) {
			help[k++] = array[j++];
		}
		
		for (int index = left; index <= right; index++) {
			array[index] = help[index - left];
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
