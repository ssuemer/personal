package ds;
import java.util.ArrayList;
import java.util.Collection;

public abstract class AbstractHeap<T extends Comparable<T>> {
	
	protected ArrayList<T> heap;
	
	public AbstractHeap() {
		heap = new ArrayList<T>();
	}
	
	public AbstractHeap(Collection<T> coll){
		heap = new ArrayList<T>(coll);
		heapify();
	}
	
	public void insert(T value) {
		heap.add(value);
		siftup(heap.size() - 1);
	}

	public T extract() {
		if (heap.size() == 0) {
			throw new IllegalStateException();
		} else {
			T toReturn = heap.get(0);
			swap(0, heap.size() - 1);
			heap.remove(heap.size() - 1);
			siftdown(0);
			return toReturn;
		}
	}
	
	protected abstract void siftup(int index);
	
	protected abstract void siftdown(int index);
	
	protected void heapify() {
		for (int i = (heap.size() / 2) - 1; i >= 0; i--) {
			siftdown(i);
		}
	}
	
	protected void swap(int i,int j) {
		if (i < 0 || j < 0 || i >= heap.size() || j >= heap.size()) {
			throw new IllegalArgumentException();
		}
		T temp = heap.get(i);
		heap.set(i, heap.get(j));
		heap.set(j, temp);
	}
	
	protected int leftIndex(int index) {
		return 2 * index + 1;
	}
	
	protected int rightIndex(int index) {
		return 2 * index + 2;
	}
	
	protected int parentIndex(int index) {
		return (index - 1) / 2;
	}
}
