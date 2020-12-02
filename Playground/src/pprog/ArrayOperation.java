package pprog;

public abstract class ArrayOperation implements Runnable {
	
	public static enum Type {
		SUM,
		PRIMECOUNT,
	}
	
	protected int[] arr;
	protected int low;
	protected int high;
	protected int res;
	
	ArrayOperation(int[] arr, int low, int high) {
		this.arr = arr;
		if (low < 0) {
			throw new IllegalArgumentException("Lower bound must be positive");
		}
		if (high > arr.length) {
			throw new IllegalArgumentException("Upper bound must be contained in the array");
		}
		
		this.low = low;
		this.high = high;
	}
	
	ArrayOperation(int[] arr,Tools.ArraySplit as) {
		this(arr,as.startIndex,as.startIndex + as.length);
	}
	
	@Override
	public abstract void run();
	
	public int get() {
		return res;
	}

}
