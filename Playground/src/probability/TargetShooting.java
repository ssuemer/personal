package probability;

import java.util.Random;

public class TargetShooting {
	
	private static Random randomgen = new Random();
	
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
