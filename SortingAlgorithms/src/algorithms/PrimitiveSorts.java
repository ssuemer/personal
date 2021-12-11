package algorithms;

/**
 * 
 * @author Sarp Suemer 17.07.2020
 *	Provides sequential elementary sorting algorithms with type arguments.
 *	Implementing using type arguments is more efficient for large data sets compared to
 *  using Comparable as type.
 */
public class PrimitiveSorts {
	
	
	/**
	 * @param <T> Type of the elements to sort,must implement Comparable.
	 * @param array The array to sort,must contain elements of type T.
	 * 
	 * @implNote Simple bubble sort algorithm.Stops as soon as the array is sorted.
	 */
	public static <T extends Comparable<T>> void bubbleSort(T[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			boolean noswaps = true;
			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j + 1].compareTo(array[j]) < 0) {
					Tools.swap(j,j + 1,array);
					noswaps = false;
				}
			}
			if (noswaps) {
				return;
			}
		}
	}
	
	/**
	 * @param <T> Type of the elements to sort,must implement Comparable.
	 * @param array The array to sort,must contain elements of type T.
	 * 
	 * @implNote Simple selection sort algorithm.
	 */
	public static <T extends Comparable<T>> void selectionSort(T[] array) {
		for (int i = 1; i < array.length; i++) {
			T max = array[0];
			int maxindex = 0;
			for (int j = 1; j < array.length - i + 1; j++) {
				if (array[j].compareTo(max) > 0) {
					maxindex = j;
					max = array[maxindex];
				}
			}
			Tools.swap(maxindex, array.length - i, array);
		}
	}
	
	/**
	 * @param <T> Type of the elements to sort,must implement Comparable.
	 * @param array The array to sort,must contain elements of type T.
	 * 
	 * @implNote Simple insertion sort algorithm.
	 */
	public static <T extends Comparable<T>> void insertionSort(T[] array) {
		for (int i = 1; i < array.length; i++) {
			T value = array[i];
			int indexToInsert = Tools.binarySearch(array, value, 0, i - 1);
			for (int j = i - 1; j >= indexToInsert; j--) {
				array[j + 1] = array[j];
			} 
			array[indexToInsert] = value;
		}
	}

	
}
