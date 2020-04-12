package probability;

public class SecondMomentMethod extends AbstractSimulation {
	
	private int n;
	
	public SecondMomentMethod(int n) {
		this.n = n;
	}
	
	@Override
	protected int simulateOne() {
		int first = randomgen.nextInt(2);
		int cur = first;
		int next;
		int count = 0;
		for (int i = 2; i <= n; i++) {
			next = randomgen.nextInt(2);
			if (next != cur) {
				count++;
			}
			cur = next;
		}
		if (cur != first) {
			count++;
		}
		return count;
	}
	
	@Override
	public double calc() {
		return n / 2;
	}
	
}
