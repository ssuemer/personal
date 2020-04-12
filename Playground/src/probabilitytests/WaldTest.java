package probabilitytests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import probability.Wald;

class WaldTest {

	@Test
	void test() {
		Wald sim = new Wald();
		assertEquals(sim.calc(),sim.simulate(10000),1.0);
	}

}
