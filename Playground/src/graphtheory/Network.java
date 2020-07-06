package graphtheory;

import java.util.LinkedList;

import ds.Queue;

public class Network {
	
	private int n;
	private double[][] capacity;
	private LinkedList<Integer>[] adj; // adjacency list for the graph
	
	private double[][] flow; // flows on edges
	private LinkedList<Integer>[] residualadj; // adjacency list for the residual network
	
	private double[][] residualcapacity; // residual capacities
	
	// helper arrays for BFS subroutine
	private int[] BFSpreds;
	private boolean[] visited;
	private boolean[] active;
	
	// create a new network by specifying the number of vertices
	@SuppressWarnings("unchecked")
	public Network(int n) {
		this.n = n;
		capacity = new double[n][n];
		adj = new LinkedList[n];
		for (int i = 0; i < n; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	// adds the edge (u,v) with capacity c to the network
	public void addEdge(int u,int v,double c) {
		if (u < 0 || u >= n || v < 0 || v >= n || c < 0) {
			throw new IllegalArgumentException("Cant add such an edge");
		}
		
		if (adj[u].contains(v)) {
			if (capacity[u][v] == c) {
				throw new IllegalArgumentException("Edge already present");
			} else {
				capacity[u][v] = c;
			}
		} else {
			adj[u].add(v);
			capacity[u][v] = c;
		}
	}
	
	// Ford-Fulkerson Algorithm
	@SuppressWarnings("unchecked")
	public double computeMaximumFlow(int s,int t) {
		if (s < 0 || s >= n || t < 0 || t >= n) {
			throw new IllegalArgumentException("Source or sink invalid");
		}
		
		double maxflow = 0;
		flow = new double[n][n];
		residualcapacity = new double[n][n];
		
		residualadj = new LinkedList[n];
		for (int i = 0; i < n; i++) {
			residualadj[i] = new LinkedList<Integer>();
		}
	
		for (int u = 0; u < n; u++) {
			for (Integer v: adj[u]) {
				if (flow[u][v] > 0) {
					residualadj[v].add(u);
					residualcapacity[v][u] = flow[u][v];
				}
				if (flow[u][v] < capacity[u][v]) {
					residualadj[u].add(v);
					residualcapacity[u][v] = capacity[u][v] - flow[u][v];
				}
			}
		}
		
		// while an augmenting path exists
		while (BFS(s,t)) {
			
			int cur = t;
			int pred = BFSpreds[t];
			double min = Double.MAX_VALUE;
			while (pred != -1) {
				min = Math.min(min, residualcapacity[pred][cur]);
				cur = pred;
				pred = BFSpreds[cur];
			}
			
			cur = t;
			pred = BFSpreds[t];
			while (pred != -1) {
				residualcapacity[pred][cur] -= min;
				if (residualcapacity[pred][cur] == 0) {
					residualadj[pred].remove((Object) cur);
				}
				
				if (!residualadj[cur].contains(pred)) {
					residualadj[cur].add(pred);
					residualcapacity[cur][pred] = min;
				} else {
					residualcapacity[cur][pred] += min;
				}
				
				
				if (adj[pred].contains(cur)) {
					flow[pred][cur] += min;
				} else {
					flow[cur][pred] -= min;
				}
				cur = pred;
				pred = BFSpreds[cur];
			}
			
			maxflow += min;
		}
		
		return maxflow;
	}
	
	private boolean BFS(int s,int t) {
		BFSpreds = new int[n];
		visited = new boolean[n];
		active = new boolean[n];

		for (int i = 0; i < n; i++) {
			BFSpreds[i] = -1;
		}
		
		Queue<Integer> q = new Queue<Integer>();
		active[s] = true;
		q.enqueue(s);
		while (!q.isEmpty()) {
			int w = q.dequeue();
			visited[w] = true;
			for (Integer x: residualadj[w]) {
				if (!active[x] && !visited[x]) {
					active[x] = true;
					q.enqueue(x);
					BFSpreds[x] = w;
				}
			}
		}
		
		return BFSpreds[t] != -1;
 		
	}
	
}
