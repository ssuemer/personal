package probabilitytests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import probability.CouponCollector;

class CouponCollectorTest {

	@Test
	void test() {
		for (int i = 0; i <= 100; i++) {
			CouponCollector sim = new CouponCollector(i);
			double calc = sim.calc();
			assertEquals(calc, sim.simulate(10000), calc / 10);
		}
	}

}
