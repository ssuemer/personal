package probability;

public class CouponCollector extends AbstractSimulation {
	
	private int n;
	
	
	public CouponCollector(int n) {
		this.n = n;
	}

	@Override
	protected int simulateOne() {
		int count = 0;
		int steps = 0;
		boolean[] acq = new boolean[n];
		while (count < n) {
			int num = randomgen.nextInt(n);
			if (!acq[num]) {
				acq[num] = true;
				count++;
			}
			steps++;
		}
		return steps;
	}
	
	@Override
	public double calc() {
		double sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += 1.0 / i;
		}
		sum *= n;
		return sum;
	}
	
}
