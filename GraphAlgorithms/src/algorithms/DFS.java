package algorithms;

import java.util.Collections;
import java.util.LinkedList;

public class DFS {
	
	private static String preorder;
	private static boolean[] visited;
	
	/**
	 * @param adj Adjacency list of the graph.
	 * @return The preorder DFS traversal of the graph as a string. 
	 */
	public static String run(LinkedList<Integer>[] adj) {
		for (LinkedList<Integer> nborhood : adj) {
			Collections.sort(nborhood);
		}
		preorder = "";
		visited = new boolean[adj.length];
		if (adj.length > 0) {
			for (int i = 0; i < adj.length; i++) {
				if (!visited[i]) {
					DFSVisit(adj,i);
				}
			}
			
		}
		return preorder.substring(0, preorder.length() - 1);
		
	}
	
	private static void DFSVisit(LinkedList<Integer>[] adj,int s) {
		visited[s] = true;
		preorder += s + " ";
		for (Integer v : adj[s]) {
			if (!visited[v]) {
				DFSVisit(adj,v);
			}
		}
	}
	
}
