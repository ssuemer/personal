package ds;

public class MinHeap<T extends Comparable<T>> extends AbstractHeap<T> {

	@Override
	protected void siftup(int index) {
		// TODO Auto-generated method stub
		if (index > 0 && heap.get(parentIndex(index)).compareTo(heap.get(index)) > 0) {
			swap(index,parentIndex(index));
			siftup(parentIndex(index));
		}
	}
	
	@Override
	protected void siftdown(int index) {
		// TODO Auto-generated method stub
		if (leftIndex(index) < heap.size()) {
			int min = leftIndex(index);
			if (rightIndex(index) < heap.size() && heap.get(rightIndex(index)).compareTo(heap.get(min)) < 0) {
				min = rightIndex(index);
			}
			swap(index,min);
			siftdown(min);
		}
	}
	
}
