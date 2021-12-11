package algorithms;

import java.util.LinkedList;
import java.util.Random;

/*
 * Algorithmen und Wahrscheinlichkeit Extra Aufgabe 7.2 FS20
 */
public class Exploration {
	
	LinkedList<Integer>[] adj;

	public Exploration(LinkedList<Integer>[] adj) {
		this.adj = adj;
		if (!Connected.connected(this.adj)) {
			throw new IllegalArgumentException("Graph must be connected");
		}
	}
	
	public double simulate(int N) {
		double total = 0;
		for (int i = 0; i < N; i++) {
			total += exploreOnce();
		}
		total /= N;
		return total;
	}
	
	private int exploreOnce() {
		boolean[] visited = new boolean[adj.length];
		int visitedcount = 1;
		int steps = 0;
//		int s = 3;
		int s = new Random().nextInt(adj.length);
		visited[s] = true;
		while (visitedcount < adj.length) {
			steps++;
			s = adj[s].get(new Random().nextInt(adj[s].size()));
			if (!visited[s]) {
				visited[s] = true;
				visitedcount++;
			}
		}
		return steps;
	}
	
	
	
	
}
