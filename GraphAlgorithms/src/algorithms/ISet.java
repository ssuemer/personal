package algorithms;

import java.util.LinkedList;
import java.util.Random;

public class ISet {
	
	private static Random randomgen = new Random();
	
	/**
	 * @param adj Adjacency list of the graph.
	 * @return An independent set in the graph,that is,a set of vertices such that none of them are connected.
	 */
	public static boolean[] find(LinkedList<Integer>[] adj) {
		boolean[] res = new boolean[adj.length];
		int E = 0;
		for (int u = 0; u < adj.length; u++) {
			E += adj[u].size();
		}
		
		double p = Math.min((double) adj.length / E, 1); 
		for (int u = 0; u < adj.length; u++) {
			if (randombool(p)) {
				res[u] = true;
			} 
			for (Integer v: adj[u]) {
				if (res[u] && res[v]) {
					res[randombool(0.5) ? u : v] = false;
				}
			}
		}
		return res;
	}
	
	private static boolean randombool(double p) {
		if (p < 0 || p > 1) {
			throw new IllegalArgumentException("Probability must be between 0 and 1.");
		}
		
		double random = randomgen.nextDouble();
		return random < p;
	}
	
}
