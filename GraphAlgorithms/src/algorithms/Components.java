package algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class Components {
	
	private static boolean[] visited;
	private static HashSet<Integer> component;
	
	/**
	 * @param adj Adjacency list of the graph.
	 * @return An arraylist of hashsets s.t. the vertex set is partitioned according to their components (each hashset corresponds
	 * to one component).
	 */
	public static ArrayList<HashSet<Integer>> get(LinkedList<Integer>[] adj) {
		ArrayList<HashSet<Integer>> components = new ArrayList<HashSet<Integer>>();
		visited = new boolean[adj.length];
		
		for (int i = 0; i < visited.length; i++) {
			if (!visited[i]) {
				component = new HashSet<Integer>();
				DFSVisit(adj,i);
				components.add(component);
			}
		}
		
		return components;
	}
	
	private static void DFSVisit(LinkedList<Integer>[] adj,int s) {
		visited[s] = true;
		component.add(s);
		for (Integer nbor: adj[s]) {
			if (!visited[nbor]) {
				DFSVisit(adj,nbor);
			}
		}
	}
	
	
}
