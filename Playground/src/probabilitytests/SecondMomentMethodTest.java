package probabilitytests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import probability.SecondMomentMethod;

class SecondMomentMethodTest {

	@Test
	void testExpectation() {
		for (int i = 0; i < 100; i++) {
			SecondMomentMethod sim = new SecondMomentMethod(i);
			assertEquals(sim.calc(),sim.simulate(100000),1.0);
		}
	}

}
