package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;

public class LocalRepair {
	
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
		ArrayList<Point2D> p = new ArrayList<Point2D>(P);
		Collections.sort(p, coordcomp);
		ArrayList<Point2D> q = new ArrayList<Point2D>();
		q.add(p.get(0));
		int n = p.size();
		int h = 0;
		for (int i = 1; i < n; i++) {
			while (h > 0 && lefttest(q.get(h),q.get(h - 1),p.get(i))) {
				h--;
			}
			safeset(q,p.get(i),++h);
		}
		int k = h;
		for (int i = n - 2; i >= 0; i--) {
			while (h > k && lefttest(q.get(h),q.get(h - 1),p.get(i))) {
				h--;
			}
			safeset(q,p.get(i),++h);
		}
		
		if (q.lastIndexOf(q.get(0)) != 0) {
			for (int i = q.lastIndexOf(q.get(0)); i < q.size();) {
				q.remove(i);
			}
		}
		return q;
	}
	
	private static boolean lefttest(Point2D p,Point2D q,Point2D r) {
		return (q.x - p.x) * (r.y - p.y) >= (q.y - p.y) * (r.x - p.x); 
	}
	
	private static void safeset(ArrayList<Point2D> list,Point2D p,int index) {
		if (index == list.size()) {
			list.add(p);
		} else if (index < list.size()) {
			list.set(index, p);
		} else {
			throw new IllegalArgumentException("List index out of bounds!");
		}
	}
	
}
