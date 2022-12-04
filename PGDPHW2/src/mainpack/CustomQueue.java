package mainpack;

import java.util.ArrayDeque;
import java.util.Queue;

public class CustomQueue {
	
	Queue<Integer> q;
	int capacity;
	
	public CustomQueue(int capacity) {
		this.capacity = capacity;
		q = new ArrayDeque<Integer>();
	}
	
	public boolean isEmpty() {
		return q.size() == 0;
	}
	
	public boolean isFull() {
		return q.size() == capacity;
	}
	
	public boolean put(int x) {
		if (isFull())
			return false;
		q.add(x);
		return true;
	}
	
	public int get() {
		if (isEmpty())
			return Integer.MIN_VALUE;
		return q.poll();
	}
}
