package sorts;

import java.util.Random;


/**
 * @author Sarp Suemer 17.07.2020
 * @implNote Useful tools used when working with sorting algorithms.
 */

public class Tools {
	
	private static Random randomgen = new Random();
	
	/**
	 * @param <T> Type of the elements to sort,must implement Comparable.
	 * @param i First index to swap
	 * @param j Second index to swap
	 * @param array Array to swap elements in.
	 */
	public static <T extends Comparable<T>> void swap(int i,int j,T[] array) {
		assert i >= 0 : "Index i can not be negative";
		assert j >= 0 : "Index j can not be negative";
		assert i < array.length : "Index i must smaller than array size";
		assert j < array.length : "Index j must smaller than array size";
		T temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	/**
	 * 
	 * @param <T> Type of the elements to sort,must implement Comparable.
	 * @param array Array to search the value in.
	 * @param value Value to search
	 * @return Index of the value int the array,or the index it should be at if value not present in the array.
	 */
	public static <T extends Comparable<T>> int binarySearch(T[] array,T value) {
		return binarySearch(array,value,0,array.length - 1);
	}
	
	public static <T extends Comparable<T>> int binarySearch(T[] array,T value,int left,int right) {
		int middle = (left + right) / 2;
		
		while (left < right) {
			if (value.compareTo(array[middle]) == 0) {
				return middle;
			} else if (value.compareTo(array[middle]) < 0) {
				right = middle - 1;
			} else {
				left = middle + 1;
			}
			middle = (left + right) / 2;
		}
	
		if (value.compareTo(array[middle]) > 0) {
			return middle + 1;
		} else {
			return middle;
		}
	}
	
	/**
	 * @param <T> Type of the elements to sort,must implement Comparable.
	 * @param array Array to search the value in.
	 * @param k Position of the element to be found in the sorted array.
	 * @return Element at the index k of the sorted array.
	 * 
	 * @implNote Quick select algorithm with uniform randomly picked pivot.
	 */
	public static <T extends Comparable<T>> T quickSelect(T[] array,int k) {
		if (k >= array.length || k < 0) {
			throw new IllegalArgumentException("Index out of range");
		}
		return quickSelect(array,0,array.length - 1,k);
	}
	
	private static <T extends Comparable<T>> T quickSelect(T[] array,int left,int right,int k) {
		int p = randrange(left, right);
		int t = partition(array,left,right,p);
		if (k == t) {
			return array[t];
		} else if (k < t) {
			return quickSelect(array,left,t - 1,k);
		} else {
			return quickSelect(array,t + 1,right,k);
		}
	}
	
	static <T extends Comparable<T>> int partition(T[] array,int left,int right,int p) {
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
	
	/**
	 * @param left Left border of the interval (included).
	 * @param right Right border of the interval (excluded).
	 * @return A uniform randomly chosen integer between given intervals.
	 */
	public static int randrange(int left,int right) {
		if (left > right) {
			throw new IllegalArgumentException("Left border can not be larger!");
		}
		return randomgen.nextInt(right - left + 1) + left;
	}
	
	/**
	 * @param n Number of elements in the array.
	 * @return An array of size n filled with uniform randomly chosen integers.
	 */
	public static Integer[] generateRandomArray(int n) {
		Random randomgen = new Random();
		Integer[] toReturn = new Integer[n];
		for (int i = 0; i < toReturn.length; i++) {
			toReturn[i] = randomgen.nextInt();
			if (randomgen.nextBoolean()) {
				toReturn[i] *= -1;
			}
		}
		return toReturn;
	}
	
	/**
	 * @param <T> Type of the elements to sort,must implement Comparable.
	 * @param array Array to check if it is sorted or not.
	 * @return True if the given array is sorted in ascending order,false otherwise.
	 */
	public static <T extends Comparable<T>> boolean isSorted(T[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i].compareTo(array[i + 1]) > 0) {
				return false;
			}
		}
		return true;
	}
	
	public static CustomVector<Integer> randomIntegerVector(int size) {
		Integer[] coords = new Integer[size];
		Random randomgen = new Random();
		for (int i = 0; i < size; i++) {
			coords[i] = randomgen.nextInt();
		}
		return new CustomVector<Integer>(coords);
	}
	
	@SuppressWarnings("unchecked")
	public static CustomVector<Integer>[] randomIntegerVectorArray(int arraylength,int vectorsize) {
		CustomVector<Integer>[] res = new CustomVector[arraylength];
		for (int i = 0; i < arraylength; i++) {
			res[i] = randomIntegerVector(vectorsize);
		}
		return res;
	}
}
