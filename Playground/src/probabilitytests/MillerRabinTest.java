package probabilitytests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import probability.MillerRabin;

class MillerRabinTest {

	@Test
	void test() {
		for (int i = 4; i <= 30; i++) {
			assertEquals(trivialPrimalityTest(i),MillerRabin.test(0.001, i),"Problem with: " + i);
		}
	}
	
	private static boolean trivialPrimalityTest(int n) {
		if (n == 2) {
			return true;
		}
		int b = (int) Math.ceil(Math.sqrt(n));
		for (int i = 2; i <= b; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

}
