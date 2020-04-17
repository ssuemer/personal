package sorts;

public class PrimitiveSorts {
	
	public static <T extends Comparable<T>> void bubbleSort(T[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			boolean noswaps = true;
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j + 1].compareTo(arr[j]) < 0) {
					swap(j,j + 1,arr);
					noswaps = false;
				}
			}
			if (noswaps) {
				return;
			}
		}
	}
	
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
			swap(maxindex, array.length - i, array);
		}
	}
	
	public static <T extends Comparable<T>> void insertionSort(T[] array) {
		for (int i = 1; i < array.length; i++) {
			T value = array[i];
			int indexToInsert = binarySearch(array, value, 0, i - 1);
			for (int j = i - 1; j >= indexToInsert; j--) {
				array[j + 1] = array[j];
			}
			array[indexToInsert] = value;
		}
	}
	
	private static void swap(int i,int j,Object[] array) {
		Object temp = array[i];
		array[i] = array[j];
		array[j] = temp;
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
	
}
