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
		int sqrt = (int) Math.ceil(Math.sqrt((double) n));
		for (int j = 2; j <= sqrt; j++) {
			if (n % j == 0) {
				return false;
			}
		}
		return true;
	}
}
