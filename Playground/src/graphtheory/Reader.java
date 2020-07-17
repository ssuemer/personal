package graphtheory;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Reader{
	
	/**
	 * @param path Path to the file to read the graph from.
	 * @return An adjacency list representation of the graph read from location "path".
	 * @throws FileNotFoundException
	 * 
	 * @implNote The file format is:
	 * 			 n
	 * 			 u1 v1
	 * 			 u2 v2
	 * 			 u3 v3
	 * 			 ...
	 * 		
	 * where n is the number of vertices and u1 v1 means that there is a directed edge from u1 to v1.
	 * In particular one must provide both u1 v1 and v1 u1 to indicate that there is an undirected edge between u1 and v1.
	 */
	public static LinkedList<Integer>[] readIntoListU(String path) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(path));
		int n = scanner.nextInt();
		@SuppressWarnings("unchecked")
		LinkedList<Integer>[] adj = new LinkedList[n];
		for (int i = 0; i < adj.length; i++) {
			adj[i] = new LinkedList<Integer>();
		}
		while (scanner.hasNextInt()) {
			int u = scanner.nextInt();
			int v = scanner.nextInt();
			adj[u].add(v);
			adj[v].add(u);
		}
		scanner.close();
		return adj;
	}
	
	/**
	 * @param adj Adjacency list of the graph.
	 * @return A copy of the graph.Creates an independent new object.
	 */
	@SuppressWarnings("unchecked")
	public static LinkedList<Integer>[] cloneadj (LinkedList<Integer>[] adj) {
		LinkedList<Integer>[] cloned = new LinkedList[adj.length];
		for (int i = 0; i < adj.length; i++) {
			if (adj[i] == null) {
				cloned[i] = null;
			} else {
				cloned[i] = (LinkedList<Integer>) adj[i].clone();
			}
		}
		return cloned;
	}
	
	/**
	 * @param n Number of vertices the graph should contain.
	 * @return The complete graph on n vertices.
	 */
	@SuppressWarnings("unchecked")
	public static LinkedList<Integer>[] completegraph(int n) {
		LinkedList<Integer>[] res = new LinkedList[n];
		for (int i = 0; i < res.length; i++) {
			res[i] = new LinkedList<Integer>();
		}
		
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res.length; j++) {
				if (i != j) {
					res[i].add(j);
				}
			}
		}
		
		return res;
	}
	
	/**
	 * @param n Number of vertices the graph should contain.
	 * @return A simple path on n vertices (of length n - 1).
	 */
	@SuppressWarnings("unchecked")
	public static LinkedList<Integer>[] path(int n) {
		LinkedList<Integer>[] res = new LinkedList[n];
		for (int i = 0; i < res.length; i++) {
			res[i] = new LinkedList<Integer>();
			if (i < res.length - 1) {
				res[i].add(i + 1);
			}
			if (i > 0) {
				res[i].add(i - 1);
			}
		}
		return res;
	}
	
	/**
	 * @param n Number of vertices the graph should contain.
	 * @return A cycle graph on n vertices.
	 */
	public static LinkedList<Integer>[] cycle(int n) {
		LinkedList<Integer>[] res = path(n);
		res[n - 1].add(0);
		res[0].add(n - 1);
		return res;
	}
}