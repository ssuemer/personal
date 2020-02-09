package ds;

public class Stack<T> {
	
	private LLNode<T> first;
	private int size;
	
	void push(T value) {
		LLNode<T> toAdd = new LLNode<T>(value);
		toAdd.next = first;
		first = toAdd;
		size++;
	}
	
	boolean isEmpty() {
		return size == 0;
	}
	
	T pop() {
		if (isEmpty()) {
			throw new IllegalStateException();
		} else {
			T toReturn = first.value;
			first = first.next;
			size--;
			return toReturn;
		}
	}
	
	T peek() {
		if (isEmpty()) {
			throw new IllegalStateException();
		} else {
			return first.value;
		}
	}
	
}
