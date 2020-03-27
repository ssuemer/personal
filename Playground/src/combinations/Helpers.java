package combinations;

import java.math.BigInteger;

public class Helpers {
	
	public static BigInteger factorial(int n) {
		BigInteger x = BigInteger.ONE;
		
		for (int i = 2; i <= n; i++) {
			x = x.multiply(BigInteger.valueOf(i));
		}
		
		return x;
	}
	
	public static BigInteger binomcoeff(int n,int k) {
		BigInteger num = BigInteger.ONE;
		BigInteger denom = factorial(k);
		
		for (int i = n; i >= n - k + 1; i--) {
			num = num.multiply(BigInteger.valueOf(i));
		}
		
		return num.divide(denom);
	}
}
