package probabilitytests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import probability.TargetShooting;

class TargetShootingTest {

	@Test
	void test() {
		double error = 0.1;
		double delta = 0.001;
		double res = TargetShooting.getPi(error * Math.PI / 4, delta);
		assertEquals(Math.PI / 4, res , error);
	}

}
