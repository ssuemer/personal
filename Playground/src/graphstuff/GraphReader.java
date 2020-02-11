package graphstuff;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class GraphReader {
	
	public static boolean[][] readIntoMatrix(String filename) throws FileNotFoundException {
		Scanner filetoscan = new Scanner(new File(filename));
		
		int V;
		boolean undirected = false;
		if (filetoscan.hasNextInt()) {
			V = filetoscan.nextInt();
		} else {
			filetoscan.close();
			throw new IllegalStateException();
		}
		
		if (filetoscan.hasNextInt()) {
			if (filetoscan.nextInt() == 1) {
				undirected = true;
			}
		} else {
			filetoscan.close();
			throw new IllegalStateException();
		}
		
		boolean[][] matrix = new boolean[V][V];
		
		while (filetoscan.hasNext()) {
			int u = filetoscan.nextInt();
			int v = filetoscan.nextInt();
			matrix[u][v] = true;
			if (undirected) {
				matrix[v][u] = true;
			}
		}
		
		filetoscan.close();
		return matrix;
	}
	
	public static LinkedList<Integer>[] readIntoList(String filename) throws FileNotFoundException {
		Scanner filetoscan = new Scanner(new File(filename));
		
		int V;
		boolean undirected = false;
		if (filetoscan.hasNextInt()) {
			V = filetoscan.nextInt();
		} else {
			filetoscan.close();
			throw new IllegalStateException();
		}
		
		if (filetoscan.hasNextInt()) {
			if (filetoscan.nextInt() == 1) {
				undirected = true;
			}
		} else {
			filetoscan.close();
			throw new IllegalStateException();
		}
		
		LinkedList<Integer>[] adjlist = new LinkedList[V];
		for (int i = 0; i < adjlist.length; i++) {
			adjlist[i] = new LinkedList<Integer>();
		}
		
		while (filetoscan.hasNext()) {
			int u = filetoscan.nextInt();
			int v = filetoscan.nextInt();
			adjlist[u].add(v);
			if (undirected) {
				adjlist[v].add(u);
			}
		}
		
		filetoscan.close();
		return adjlist;
	}
	
}
