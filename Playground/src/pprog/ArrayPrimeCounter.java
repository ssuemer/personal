package pprog;

import pprog.Tools.ArraySplit;

public class ArrayPrimeCounter extends ArrayOperation {
	
	ArrayPrimeCounter(int[] arr, ArraySplit as) {
		super(arr, as);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		res = 0;
		for (int i = low; i < high; i++) {
			if (isPrime(i)) {
				res++;
			}
		}
	}
	
	public static boolean isPrime (int n) {
		if (n < 2) {
			return false;
		}
		if (n == 2) {
			return true;
		}
		for (int j = 2; j < n; j++) {
			if (n % j == 0) {
				return false;
			}
		}
		return true;
	}
}
