package ds;

public class Queue<T> {
	private LLNode<T> first,last;
	private int size;
	
	void enqueue(T value) {
		LLNode<T> toAdd = new LLNode<T>(value);
		if (isEmpty()) {
			first = last = toAdd;
		} else {
			last.next = toAdd;
			last = toAdd;
		}
		size++;
	}
	
	T dequeue() {
		if (isEmpty()) {
			throw new IllegalStateException();
		} else {
			T toReturn = first.value;
			first = first.next;
			size--;
			return toReturn;
		}
	}
	
	boolean isEmpty() {
		return size == 0;
	}
}
