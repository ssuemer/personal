package probability;

import java.util.Random;

public class TargetShooting {
	
	private static Random randomgen = new Random();
	
	/**
	 * @param error Relative error to pi.
	 * @param delta Wished probability that return value is atmost error away from pi.
	 * @return Pi,estimated to an error input by the user.
	 * 
	 * @implNote This method calculates pi using the target shooting algorithm.
	 * Note that this is very inefficient and there are much better ways to calculate pi
	 * with high precision. 
	 */
	public static double getPi(double error,double delta) {
		if (error < 0) {
			throw new IllegalArgumentException("Error must be positive");
		}
		
		if (delta < 0) {
			throw new IllegalArgumentException("Delta must be positive");
		}
		
		int N = (int) (6 * (1 / error * error) * Math.log(2 / delta));
		double total = 0;
		for (int i = 0; i < N; i++) {
			double x = randomgen.nextDouble();
			double y = randomgen.nextDouble();
			if (x * x + y * y < 1) {
				total++;
			}
		}
		
		return total / N;
	}
	
	
}
