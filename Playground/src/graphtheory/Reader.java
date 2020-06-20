package graphtheory;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Reader{
	
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
}
