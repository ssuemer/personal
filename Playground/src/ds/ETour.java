package ds;

public class ETour {
	LLNode<Integer> first;
	LLNode<Integer> last;
	private int size;
	
	public void append(int val) {
		LLNode<Integer> toAdd = new LLNode<Integer>(val);
		if (isEmpty()) {
			first = last = toAdd;
		} else {
			last.next = toAdd;
			last = toAdd;
		}
		size++;
	}
	
	public int getSize() {
		return size;
	}
	
	public int get(int index) {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		} else {
			LLNode<Integer> cur = first;
			for (int i = 0; i < index; i++) {
				cur = cur.next;
			}
			return cur.value;
		}
	}
	
	@Override
	public String toString() {
		if (isEmpty()) {
			return " ";
		} else {
			String result = first.value.toString();
			LLNode<Integer> cur = first.next;
			while (cur != null) {
				result += " " + cur.value.toString();
			}
			return result;
		}
	}

	public void merge(ETour othertour) {
		if (othertour.isEmpty()) {
			return;
		}
		
		if (isEmpty()) {
			first = othertour.first;
			last = othertour.last;
			size = othertour.size;
			return;
		}
		
		
		LLNode<Integer> cur = first;
		while (cur.next != null && !cur.next.equals(othertour.first)) {
			cur = cur.next;
			System.out.println("In loop");
		}
		
		if (cur.next == null) {
			throw new IllegalArgumentException("Merge spot not found!");
		}
		
		cur.next = othertour.first;
		if (cur.next == last) {
			last = othertour.last;
		} else {
			othertour.last.next = cur.next.next;
		}
		size += othertour.size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
}