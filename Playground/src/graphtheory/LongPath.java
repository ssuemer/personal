package graphtheory;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;

public class LongPath {
	
	private static Random randomgen = new Random();
	private static HashSet<HashSet<Integer>>[][] DP;
	private static int[] color;
	
	
	public static boolean find(LinkedList<Integer>[] adj,int k,double p) {
		int repeat = (int) (Math.ceil(-Math.log(p) * Math.exp(k)));
		for (int i = 0; i < repeat; i++) {
			if (runOnce(adj,k)) {
				return true;
			}
		}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	private static boolean runOnce(LinkedList<Integer>[] adj,int k) {
		// initialize DP table
		DP = new HashSet[k][adj.length];
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < adj.length; j++) {
				DP[i][j] = new HashSet<HashSet<Integer>>();
			}
		}
		
		randomcolors(adj,k); // color the vertices randomly
		
		// set the base cases for DP
		for (int i = 0; i < adj.length; i++) {
			HashSet<Integer> toAdd = new HashSet<Integer>();
			toAdd.add(color[i]);
			DP[0][i].add(toAdd);
		}
		
		// compute all the sets
		for (int i = 1; i < k; i++) {
			for (int v = 0; v < adj.length; v++) {
				for (Integer x: adj[v]) {
					for (HashSet<Integer> R: DP[i - 1][x]) {
						if (!R.contains(color[v])) {
							HashSet<Integer> toAdd = (HashSet<Integer>) R.clone();
							toAdd.add(color[v]);
							DP[i][v].add(toAdd);
						}
					}
				}
			}
		}
	
		for (int v = 0; v < adj.length; v++) {
			if (!DP[k - 1][v].isEmpty()) {
				return true;
			}
		}
		
		return false;
	}
	
	private static void randomcolors(LinkedList<Integer>[] adj,int k) {
		color = new int[adj.length];
		for (int i = 0; i < color.length; i++) {
			color[i] = randomgen.nextInt(k) + 1;
		}
	}
}
