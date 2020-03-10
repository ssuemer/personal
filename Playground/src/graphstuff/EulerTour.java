package graphstuff;

import java.util.LinkedList;
import java.util.List;

import ds.LLNode;

public class EulerTour {
	
	public static LinkedList<Integer> find(List<Integer>[] adj) {
		for (List<Integer> nbd : adj) {
			if (nbd.size() % 2 == 1) {
				return null;
			}
		}
		if (!Traversals.connected(adj)) {
			return null;
		}
		

		return null;
	}
}

