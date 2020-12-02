package graphtheory;

import java.util.LinkedList;

/* Tests 0 - 14 successful */
public class Connected {
	
	private static int[] dfs;
	private static int num;
	
	/**
	 * @param adj Adjacency list of the graph.
	 * @return True if the graph is connected,false otherwise.
	 */
	public static boolean connected(LinkedList<Integer>[] adj) {
		dfs = new int[adj.length];
		num = 0;
		DFSVisit(adj,1);
		return num == adj.length;
	}
	
	// standard DFS-Visit
	private static void DFSVisit(LinkedList<Integer>[] adj,int s) {
		dfs[s] = ++num;
		for (Integer v : adj[s]) {
			if (dfs[v] == 0) {
				DFSVisit(adj,v);
			}
		}
	}
	
	/**
	 * @param adj Adjacency list of the graph.
	 * @return True if the graph is a tree (connected and acyclic),false otherwise.
	 */
	public static boolean isTree(LinkedList<Integer>[] adj) {
		if (!connected(adj)) {
			return false;
		} else {
			int sum = 0;
			for (LinkedList<Integer> nbourhood : adj) {
				sum += nbourhood.size(); 
			}
			sum /= 2;
			return sum == adj.length - 1;
		}
	}
	
}
