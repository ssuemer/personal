package sortables;


import java.util.Random;

public class Point2D implements Comparable<Point2D>{
	
	public double x;
	public double y;
	
	public Point2D(double x,double y) {
		this.x = x;
		this.y = y;
	}
	
	public static Point2D randomPoint() {
		Random randomgen = new Random();
		return new Point2D(randomgen.nextInt(),randomgen.nextInt());
	}
	
	public static Point2D[] randomPointArray(int length) {
		Point2D[] res = new Point2D[length];
		for (int i = 0; i < length; i++) {
			res[i] = randomPoint();
		}
		return res;
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

	@Override
	public int compareTo(Point2D o) {
		// TODO Auto-generated method stub
		return Double.compare(x * x + y * y, o.x * o.x + o.y * o.y);
	}
}
