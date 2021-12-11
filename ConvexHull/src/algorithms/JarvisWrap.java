package algorithms;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;

public class JarvisWrap {
	
	protected static Comparator<Point2D> coordcomp = new Comparator<Point2D>() {

		@Override
		public int compare(Point2D p1, Point2D p2) {
			// TODO Auto-generated method stub
			if (p1.x < p2.x) {
				return -1;
			} else if (p1.x == p2.x) {
				return Double.compare(p1.y, p2.y);
			} else {
				return 1;
			}
		}
		
	};
	
	public static ArrayList<Point2D> getConvexHull(Set<Point2D> P) {
		Point2D pnow = Collections.min(P, coordcomp);
		ArrayList<Point2D> convexhull = new ArrayList<Point2D>();
		
		do {
			convexhull.add(pnow);
			pnow = findNext(P,pnow);
		} while (!pnow.equals(convexhull.get(0)));
		
		return convexhull;
	}
	
	private static Point2D findNext(Set<Point2D> P,Point2D q) {
		Point2D p0 = null;
		for (Point2D p: P) {
			if (!p.equals(q)) {
				p0 = p;
			}
		}
		Point2D qnext = p0.copy();
		for (Point2D p: P) {
			if (!p.equals(q) && !p.equals(p0) && righttest(p,q,qnext)) {
				qnext = p;
			}
		}
		return qnext;
	}
	
	private static boolean righttest(Point2D p,Point2D q,Point2D r) {
		double det = (q.x - p.x) * (r.y - p.y) - (q.y - p.y) * (r.x - p.x);
		return det < 0 || (det == 0 && distance(q,p) > distance(q,r)); 
	}
	
	private static double distance(Point2D p1,Point2D p2) {
		return Math.sqrt((p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y));
	}
	
	public static boolean inHull(Point2D p,ArrayList<Point2D> convexhull) {
		for (int i = 0; i < convexhull.size() - 1; i++) {
			if (righttest(p,convexhull.get(i),convexhull.get(i + 1))) {
				return false;
			}
		}
		return !righttest(p,convexhull.get(convexhull.size() - 1),convexhull.get(0));
	}
	
}
