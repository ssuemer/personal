package probability;

import java.util.Random;

public abstract class AbstractSimulation {
	
	protected Random randomgen = new Random();
	
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
