package algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import tools.Reader;

public class EulerTour {
	
	/**
	 * @param adj Adjacency list of the graph.
	 * @return A linkedlist representing an arbitrary EulerTour in the graph if it has one,null otherwise.
	 */
	public static LinkedList<Integer> find(LinkedList<Integer>[] adj) {
		
		adj = Reader.cloneadj(adj);
		
		if (!possible(adj)) {
			return null;
		}
		int vstart = -1;
		for (int i = 0; i < adj.length; i++) {
			if (adj[i].size() > 0) {
				vstart = i;
				break;
			}
		}
		
		LinkedList<Integer> W = randomTour(adj,vstart);
		int vslowindex = 0;
		while (vslowindex != W.size() - 1) {
			int v = W.get(vslowindex + 1);
			if (!adj[v].isEmpty()) {
				LinkedList<Integer> W1 = randomTour(adj, v);
				W1.removeFirst();
				W.addAll(vslowindex + 2, W1);
			}
			vslowindex++;
		}
		return W;
		
	}
	
	/**
	 * @param adj Adjacency list of the graph.
	 * @return True if the graph contains an EulerTour,false otherwise.
	 */
	private static boolean possible(LinkedList<Integer>[] adj) {
		boolean flag = false;
		for (List<Integer> nbd : adj) {
			if (nbd.size() % 2 != 0) {
				return false;
			}
			if (nbd.size() > 0) {
				flag = true;
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
		return flag;
	}
	
	private static LinkedList<Integer> randomTour(LinkedList<Integer>[] adj,int v) {
		if (v < 0 || v >= adj.length) {
			throw new IllegalArgumentException("Vertex " + v + " not in graph");
		}
		LinkedList<Integer> tour = new LinkedList<Integer>();
		tour.add(v);
		while (!adj[v].isEmpty()) {
			int x = adj[v].get(0);
			tour.add(x);
			adj[x].remove((Object) v);
			adj[v].remove((Object) x); 
			v = x;
		}
		return tour;
	}
}

