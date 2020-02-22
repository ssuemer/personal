package graphstuff;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Reader{
	
	public static List<Integer>[] readIntoListU(String path) throws FileNotFoundException{
		Scanner scanner = new Scanner(new File(path));
		int n = scanner.nextInt();
		@SuppressWarnings("unchecked")
		List<Integer>[] adj = new LinkedList[n];
		for (int i = 0; i < n; i++) {
			int u = scanner.nextInt();
			int v = scanner.nextInt();
			if (adj[u] == null) {
				adj[u] = new LinkedList<Integer>();
			}
			if (adj[v] == null) {
				adj[v] = new LinkedList<Integer>();
			}
			adj[u].add(v);
			adj[v].add(u);
		}
		scanner.close();
		return adj;
	}
}
