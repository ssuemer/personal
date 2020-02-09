package ds;

import java.util.ArrayList;

public class ResizableMaxHeap<T extends Comparable<T>> extends MaxHeap<T> {
	
	private ArrayList<T> rest;
	
	public ResizableMaxHeap(T[] array) {
		super();
		for (T t : array) {
			heap.add(t);
		}
		heapify();
		rest = new ArrayList<T>();
	}
	
	public ArrayList<T> getHeap() {
		return heap;
	}
	
	public T get(int index) {
		return heap.get(index);
	}
	
	public void moveMaxToRest() {
		T value = extract();
		rest.add(0,value);
	}
	
	
	
}
