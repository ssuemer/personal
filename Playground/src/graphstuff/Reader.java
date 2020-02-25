package graphstuff;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Reader{
	
	public static List<Integer>[] readIntoListU(String path) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(path));
		int n = scanner.nextInt();
		@SuppressWarnings("unchecked")
		List<Integer>[] adj = new LinkedList[n];
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
}
