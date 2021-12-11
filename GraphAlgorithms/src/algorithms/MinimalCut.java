package algorithms;

import java.util.LinkedList;
import java.util.Random;

import tools.Reader;

public class MinimalCut {
	
	private static Random randomgen = new Random();
	
	private static int v1once(LinkedList<Integer>[] adj,int n) {
		LinkedList<Integer>[] adjc = Reader.cloneadj(adj);
		while (n > 2) {
			int[] randomedge = uniformedge(adjc);
			int u = randomedge[0];
			int v = randomedge[1];
			contract(adjc,u,v);
			n--;
		}
		
		for (LinkedList<Integer> nbors: adjc) {
			if (nbors != null) {
				return nbors.size();
			}
		}
		
		return -1;
	}
	
	private static int v1(LinkedList<Integer>[] adj,int n,double lambda) {
		int N = (int) Math.ceil(lambda * n * (n - 1) * 0.5);
		int res = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			res = Math.min(res, v1once(adj,n));
		}
		return res;
	}
	
	private static int v2once(LinkedList<Integer>[] adj,int n) {
		int b = (int) Math.sqrt(n);
		LinkedList<Integer>[] adjc = Reader.cloneadj(adj);
		while (n > b) {
			int[] randomedge = uniformedge(adjc);
			int u = randomedge[0];
			int v = randomedge[1];
			contract(adjc,u,v);
			n--;
		}
		return v1(adjc,n,1);
	}
	
	/**
	 * @param adj Adjacency list of the graph.
	 * @param lambda Probability of success the user wishes to have.Larger values increase running time.Must be between 0 and 1.
	 * @return The size of a minimal cut,that is,the minimal number of edges that have to be removed to make the graph disconnected.
	 * 
	 * @implNote This is a Monte-Carlo algorithm.The user should enter values near 1 for safer computations.
	 */
	public static int v2(LinkedList<Integer>[] adj,double lambda) {
		int N = (int) Math.ceil(lambda * adj.length * (adj.length - 1) * 0.5);
		int res = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			res = Math.min(res, v2once(adj,adj.length));
		}
		return res;
	}
	
	private static int[] uniformedge(LinkedList<Integer>[] adj) {
		int m = 0;
		for (int i = 0; i < adj.length; i++) {
			if (adj[i] != null) {
				m += adj[i].size();
			}
		}
		int e = randomgen.nextInt(m) + 1;
		int u = -1;
		int v = -1;
		for (int i = 0; i < adj.length; i++) {
			if (adj[i] != null) {
				if (e > adj[i].size()) {
					e -= adj[i].size();
				} else {
					u = i;
					v = adj[i].get(e - 1);
					break;
				}
			}
		}
		
		return new int[] {u,v};
	}
	
	private static void contract(LinkedList<Integer>[] adj,int u,int v) {
		while (adj[u].contains(v)) {
			adj[u].remove((Object) v);
		}
		
		for (Integer nbor: adj[v]) {
			if (!nbor.equals(u)) {
				adj[u].add(nbor);
				adj[nbor].add(u);
				adj[nbor].remove((Object) v);
			}
		}
		
		adj[v] = null;
	}
}
