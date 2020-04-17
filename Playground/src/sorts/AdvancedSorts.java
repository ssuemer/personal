package sorts;

import java.util.Random;

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
	
	public static <T extends Comparable<T>> void quickSort(T[] array) {
		quickSort(array,0,array.length - 1);
	}
	
	private static <T extends Comparable<T>> void quickSort(T[] array,int left,int right) {
		if (left < right) {
			int pivot = (new Random()).nextInt(right - left + 1) + left;
			int k = partition(array,left,right,pivot);
			quickSort(array,left,k - 1);
			quickSort(array,k + 1,right);
		}
	}
	
	private static <T extends Comparable<T>> int partition(T[] array,int left,int right,int p) {
		swap(p,right,array);
		T piv = array[right];
		int i = left;
		int j = right - 1;
		do {
			while (array[i].compareTo(piv) < 0) {
				i++;
			}
			while (j > left && array[j].compareTo(piv) > 0) {
				j--;
			}
			if (i < j) {
				swap(i, j, array);
			}
		} while (i < j);
		swap(i,right,array);
		return i;
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
	
	private static <T extends Comparable<T>> void swap(int i,int j,T[] array) {
		T temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	
}
