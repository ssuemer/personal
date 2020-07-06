package probability;

import java.util.Random;

// use n <= 30,larger values cause overflow
public class MillerRabin {
	
	private static Random randomgen = new Random();
	
	private static boolean testOnce(int n) {
		if (n == 2) {
			return true;
		} else if (n % 2 == 0 || n == 1) {
			return false;
		}
		
		int a = randomgen.nextInt(n - 3) + 2;
		int d = n - 1;
		int k = 0;
		while (d % 2 == 0) {
			d /= 2;
			k++;
		}
		
		long x = (long) (Math.pow(a, d) % n);
		if (x == 1 || x == n - 1) {
			return true;
		} 
		for (int i = 1; i <= k - 1; i++) {
			x = (x * x) % n;
			if (x == 1) {
				return false;
			} 
			if (x == n - 1) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean test(double delta,int n) {
		int N = (int) Math.ceil((4 * Math.log(1 / delta)));
		for (int i = 0; i < N; i++) {
			if (!testOnce(n)) {
				return false;
			}
		}
		return true;
	}
}
