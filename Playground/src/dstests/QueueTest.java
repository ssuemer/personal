package dstests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ds.Queue;

class QueueTest {

	@Test
	void empty() {
		Queue<Integer> q = new Queue<Integer>();
		assertTrue(q.isEmpty());
		q.enqueue(6);
		q.dequeue();
		assertTrue(q.isEmpty());
		for (int i = 0; i < 100; i++) {
			q.enqueue(i);
		}
		for (int i = 0; i < 100; i++) {
			q.dequeue();
		}
		assertTrue(q.isEmpty());
		assertTrue(q.isEmpty());
		q.enqueue(123);
		assertFalse(q.isEmpty());
	}
	
	@Test
	void consistency() {
		Queue<Integer> q = new Queue<Integer>();
		q.enqueue(3);
		assertEquals(3,q.dequeue());
		for (int i = 0; i < 100; i++) {
			q.enqueue(i);
		}
		for (int i = 0; i < 100; i++) {
			assertEquals(i,q.dequeue());
		}
	}

}
