package sorts;

public class CustomVector<T extends Comparable<T>> implements Comparable<CustomVector<T>> {
	
	private T[] coords;
	
	public CustomVector(T[] coords) {
		assert coords != null;
		set(coords);
	}
	
	public int getDimension() {
		return coords.length;
	}
	
	public T get(int i) {
		inBounds(i);
		return coords[i];
	}
	
	public void set(T[] coords) {
		this.coords = coords;
	}
	
	public void setSingleCoord(T coord,int i) {
		inBounds(i);
		coords[i] = coord;
	}
	
	private void inBounds(int i) {
		assert i >= 0 && i < coords.length;
	}
	
	
	@Override
	public int compareTo(CustomVector<T> o) {
		// TODO Auto-generated method stub
		assert coords.length == o.coords.length;
		for (int i = 0; i < coords.length; i++) {
			int comp = coords[i].compareTo(o.coords[i]);
			if (comp < 0) {
				return -1;
			} else if (comp > 0) {
				return 1;
			}
		}
		return 0; 
	}

}
