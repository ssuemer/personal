package ds;

public class LLNode<T> {
	public T value;
	public LLNode<T> next;
	
	public LLNode(T value){
		this.value = value;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof LLNode<?>) {
			try {
				@SuppressWarnings("unchecked")
				T otherval = (T) ((LLNode<?>) o).value;
				return value.equals(otherval);
			} catch (ClassCastException e) {
				// TODO: handle exception
				return false;
			}
		} else {
			return false;
		}
	}
}


