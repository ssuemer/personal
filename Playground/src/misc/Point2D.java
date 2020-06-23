package misc;

public class Point2D {
	
	public double x;
	public double y;
	
	public Point2D(double x,double y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public boolean equals(Object other) {
		if (getClass() != other.getClass()) {
			return false;
		}
		Point2D o = (Point2D) other;
		return x == o.x && y == o.y;
	}
	
	public Point2D copy() {
		return new Point2D(x,y);
	}
	
	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}
}
