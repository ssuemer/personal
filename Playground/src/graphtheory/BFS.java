package graphtheory;

import java.util.Collections;
import java.util.LinkedList;

import ds.Queue;

public class BFS {
	
	private static String preorder;
	private static boolean[] visited;
	private static boolean[] enqueued;
	
	public static String run(LinkedList<Integer>[] adj) {
		for (LinkedList<Integer> nborhood : adj) {
			Collections.sort(nborhood);
		}
		preorder = "";
		visited = new boolean[adj.length];
		enqueued = new boolean[adj.length];
		Queue<Integer> q = new Queue<Integer>();
		if (adj.length == 0) {
			return preorder;
		}
		
		for (int i = 0; i < adj.length; i++) {
			if (!visited[i]) {
				q.enqueue(i);
				enqueued[i] = true;
				while(!q.isEmpty()) {
					int s = q.dequeue();
					preorder += s + " ";
					visited[s] = true;
					for (Integer v : adj[s]) {
						if (!visited[v] && !enqueued[v]) {
							q.enqueue(v);
							enqueued[v] = true;
						}
					}
				}
			}
		}
		
		
		return preorder.substring(0, preorder.length() - 1);
	}
	
}
