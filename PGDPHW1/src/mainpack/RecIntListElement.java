package mainpack;

public class RecIntListElement {
	private int value;
	private RecIntListElement next;
	private RecIntListElement prev;

	public RecIntListElement(int value) {
		this(value, null);
	}

	public RecIntListElement(int value, RecIntListElement prev) {
		this.value = value;
		next = null;
		this.prev = prev;
	}

	public RecIntListElement append(int value) {
		if (next != null) {
			return next.append(value);
		} else {
			next = new RecIntListElement(value, this);
			return next;
		}
	}
	
	// auxillary method for count threshold
	public void auxCT(int threshold, long[] acc) {
		if (value > threshold)
			acc[2] += value;
		else if (value == threshold)
			acc[1] += value;
		else 
			acc[0] += value;
		if (next != null)
			next.auxCT(threshold, acc);
	}
	
	// auxillary method for kinguinSort
	public void auxKS(boolean increasing) {
		clearNext(increasing);
		if (next != null)
			next.auxKS(increasing);
	}
	
	// helper for kinguinSort
	private void clearNext(boolean increasing) {
		if (increasing) {
			if (next != null && next.get(0) < value) {
				next = next.next;
				if (next != null)
					next.prev = this;
				clearNext(increasing);
			}
		} else {
			if (next != null && next.get(0) > value) {
				next = next.next;
				if (next != null)
					next.prev = this;
				clearNext(increasing);
			}
		}
	}
	
	// auxillary method for reverse
	public RecIntListElement auxRev() {
		RecIntListElement temp = prev;
		prev = next;
		next = temp;
		if (prev == null)
			return this;
		else 
			return prev.auxRev();
	}
	
	// auxillary method for zip
	public void auxZip(RecIntListElement other) {
		if (next == null) {
			next = other;
			if (other != null)
				other.prev = this;
		} else if (other != null) {
			RecIntListElement rest = other.next;
			other.next = next;
			other.next.prev = other;
			other.prev = this;
			next = other;
			next.next.auxZip(rest);
		}
	}
	

	public int get(int idx) {
		if (idx == 0) {
			return value;
		}
		if (next == null) {
			System.out.println("Invalid index: list is to short!");
			return Integer.MIN_VALUE;
		}
		return next.get(idx - 1);
	}

	public int size() {
		if (next == null) {
			return 1;
		}
		return 1 + next.size();
	}

	public boolean insert(int value, int idx) {
		if (idx < 0) {
			System.out.println("Cannot insert at negative index!");
			return false;
		}
		if (idx <= 1) {
			RecIntListElement n = new RecIntListElement(value, this);
			n.next = next;
			if (next != null) {
				next.prev = n;
			}
			next = n;
			if (idx == 0) {
				next.value = this.value;
				this.value = value;
			}
			return true;
		}
		if (next == null) {
			System.out.println("List is to short to insert at given index!");
			return false;
		}
		return next.insert(value, idx - 1);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		RecIntListElement tmp = this;
		do {
			sb.append(tmp.value).append(", ");
			tmp = tmp.next;
		} while (tmp != null);
		sb.setLength(sb.length() - 2);
		return sb.toString();
	}

	public String toConnectionString() {
		StringBuilder sb = new StringBuilder();
		RecIntListElement tmp = this;
		do {
			if (tmp.prev != null) {
				sb.append("<-");
			}
			sb.append(tmp.value);
			if (tmp.next != null) {
				sb.append("->");
			}
			tmp = tmp.next;
		} while (tmp != null);
		return sb.toString();
	}
}