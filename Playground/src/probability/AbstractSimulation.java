package probability;

import java.util.Random;

public abstract class AbstractSimulation {
	
	protected Random randomgen = new Random();
	
	/**
	 * @param N Number of simulations.
	 * @return Empirical expected value of the experiment after N simulations.
	 */
	public double simulate(int N) {
		double sum = 0;
		for (int i = 0; i < N; i++) {
			sum += simulateOne();
		}
		return sum / N;
	}
	
	protected abstract int simulateOne();
	
	public abstract double calc();
	
}
