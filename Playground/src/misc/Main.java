package misc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		HashSet<Point2D> points = new HashSet<Point2D>();
		while (true) {
			if (in.hasNextDouble()) {
				points.add(new Point2D(in.nextDouble(),in.nextDouble()));
			} else if (in.hasNext()) {
				break;
			}
		}
		in.close();
		ArrayList<Point2D> hull = LocalRepair.getConvexHull(points);
		System.out.println(hull);
		System.out.println(JarvisWrap.inHull(new Point2D(2,-2), hull));
	}

}
