package ds;

public class MaxHeap<T extends Comparable<T>> extends AbstractHeap<T> {
	
	@Override
	protected void siftup(int index) {
		if (index > 0 && heap.get(parentIndex(index)).compareTo(heap.get(index)) < 0) {
			swap(index,parentIndex(index));
			siftup(parentIndex(index));
		}
	}
	
	@Override
	protected void siftdown(int index) {
		if (leftIndex(index) < heap.size()) {
			int max = leftIndex(index);
			if (rightIndex(index) < heap.size() && heap.get(rightIndex(index)).compareTo(heap.get(max)) > 0) {
				max = rightIndex(index);
			}
			if (heap.get(max).compareTo(heap.get(index)) > 0) {
				swap(index,max);
				siftdown(max);
			}
		}
	}
}
