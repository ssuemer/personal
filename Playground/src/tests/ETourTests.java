package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.jupiter.api.Test;

import ds.ETour;

class ETourTests {

	@Test
	void appendFirst() {
		ETour tour1 = new ETour();
		tour1.append(4);
		assertFalse(tour1.isEmpty());
		assertEquals(tour1.getSize(),1);
		tour1.append(5);
		assertEquals(tour1.getSize(),2);
		assertEquals(tour1.get(0), 4);
		assertEquals(tour1.get(1), 5);
	}
	
	@Test
	void merge() {
		ETour tour1 = new ETour();
		ETour tour2 = new ETour();
		tour1.append(3);
		tour1.append(6);
		tour1.append(5);
		tour1.append(3);
		tour2.append(6);
		tour2.append(4);
		tour2.append(9);
		tour2.append(6);
		tour1.merge(tour2);
		assertEquals(tour1.toString(), "3 6 4 9 6 5 3");
	}

}
