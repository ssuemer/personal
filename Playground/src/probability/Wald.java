package probability;

// Simulation der Waldscher Identitaet
public class Wald extends AbstractSimulation {
	
	@Override
	protected int simulateOne() {
		int N = coinToss1();
		return coinToss2(N);
	}
	
	private int coinToss1() {
		int count = 1;
		while (tossFairCoin().equals("Z")) {
			count++;
		}
		return count;
	}
	
	private int coinToss2(int N) {
		int count = 0;
		for (int i = 0; i < N; i++) {
			if (tossFairCoin().equals("K")) {
				count++;
			}
		}
		return count;
	}
	
	private String tossFairCoin() {
		return (randomgen.nextInt(2) == 0) ? "K" : "Z";
	}
	
	@Override
	public double calc() {
		return 1;
	}
	
}
