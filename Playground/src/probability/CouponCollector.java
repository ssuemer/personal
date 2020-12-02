package probability;

/**
 * 
 * @author Sarp Suemer 17.07.2020
 * Simulates the coupon collector process with n coupons and calculates
 * the expected value of time steps to collect all coupons.
 */
public class CouponCollector extends AbstractSimulation {
	
	private int n;
	
	public CouponCollector(int n) {
		this.n = n;
	}

	/**
	 * Simulates the coupon collector process once and returns the number of steps executed.
	 */
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
	
	/**
	 * Returns the expected value of a coupon collector experiment theoretically.
	 */
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
