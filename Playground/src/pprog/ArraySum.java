package pprog;

import pprog.Tools.ArraySplit;

public class ArraySum extends ArrayOperation {
	
	ArraySum(int[] arr, ArraySplit as) {
		super(arr, as);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		res = 0;
		for (int i = low; i < high; i++) {
			res += arr[i];
		}
	}
	
	@Override
	public String toString() {
		return "Summing from " + low + " to " + high; 
	}
}
