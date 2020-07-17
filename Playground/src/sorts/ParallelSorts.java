package sorts;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

@SuppressWarnings({"rawtypes","unchecked"})
public class ParallelSorts extends RecursiveAction {
	
	public static enum TYPE {
		MERGE,
		QUICK
	}
	
	public static void mergeSort(Comparable[] array) {
		ForkJoinPool fjpool = new ForkJoinPool();
		ParallelSorts firsttask = new ParallelSorts(array, 0, array.length, TYPE.MERGE);
		fjpool.invoke(firsttask);
	}
	private static final long serialVersionUID = 1083684628232869395L;

	private Comparable[] input;
	private int start;
	private int length;
	private static int SEQCUTOFF = 10;
	private TYPE sorttype;
	
	
	private ParallelSorts(Comparable[] input, int start, int length, TYPE sorttype) {
		this.input = input;
		this.start = start;
		this.length = length;
		this.sorttype = sorttype;
	}

	@Override
	protected void compute() {
		// TODO Auto-generated method stub
		assert length > 0: "Length must be positive";
		switch (sorttype) {
		case MERGE:
			if (length == 2 && input[start].compareTo(input[start + 1]) > 0) {
				Tools.swap(start, start + 1, input);
//				insertionSort(input, start, start + length - 1);
			} else {
				int halfSize = length / 2;
				ParallelSorts lefttask = new ParallelSorts(input, start, start + halfSize, TYPE.MERGE);
				lefttask.fork();
				ParallelSorts righttask = new ParallelSorts(input, start + halfSize, length - halfSize, TYPE.MERGE);
				righttask.fork();
				
				// wait for results
				lefttask.join();
				righttask.join();
				
				// conquer
				AdvancedSorts.merge(input, start, start + halfSize - 1, start + length - 1);
			}
			break;
		case QUICK:
			
		default:
			throw new IllegalArgumentException("Unexpected value: " + sorttype);
		}
		
		
	}
	
	public static void insertionSort(Comparable[] array, int left, int right) {
		assert right >= left: "Interval must contain at least one element";
		if (right > left) {
			for (int i = left + 1; i <= right; i++) {
				Comparable value = array[i];
				int indexToInsert = Tools.binarySearch(array, value, left, i - 1);
				for (int j = i - 1; j >= indexToInsert; j--) {
					array[j + 1] = array[j];
				}
				array[indexToInsert] = value;
			}
		}
	}
	
}
