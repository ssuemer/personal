package graphtheory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class EulerTour {
	
	public static LinkedList<Integer> find(LinkedList<Integer>[] adj) {
		if (!possible(adj)) {
			return null;
		}
		
		return null;
		
	}
	
	private static boolean possible(LinkedList<Integer>[] adj) {
		for (List<Integer> nbd : adj) {
			if (nbd.size() % 2 == 1) {
				return false;
			}
		}
		
		ArrayList<HashSet<Integer>> components = Components.get(adj);
		int bigcomponentcount = 0;
		for (HashSet<Integer> component : components) {
			if (component.size() > 1) {
				bigcomponentcount++;
			}
			if (bigcomponentcount >= 2) {
				return false;
			}
		}
		
		return true;
	}
}

