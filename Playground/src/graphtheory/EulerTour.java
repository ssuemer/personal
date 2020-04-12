package graphtheory;

import java.util.LinkedList;
import java.util.List;

public class EulerTour {
	
	public static LinkedList<Integer> find(List<Integer>[] adj) {
		
		return null;
	}
	
	private static boolean possible(List<Integer>[] adj) {
		for (List<Integer> nbd : adj) {
			if (nbd.size() % 2 == 1) {
				return false;
			}
		}
		return false;
	}
}

