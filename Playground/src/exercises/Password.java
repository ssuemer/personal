package exercises;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Password {
	
	private static HashSet<String> visited;
	
	public static boolean readAndSolve(String path) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(path));
		HashSet<String> words = new HashSet<String>();
		HashSet<String>	V = new HashSet<String>();
		HashMap<String,LinkedList<String>> adjdfs = new HashMap<String,LinkedList<String>>();
		HashMap<String,LinkedList<String>> adj = new HashMap<String,LinkedList<String>>();
		HashMap<String,LinkedList<String>> reverseadj = new HashMap<String,LinkedList<String>>();
		
		int n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			String word = scanner.next();
			words.add(word);
		}
		
		for (String word : words) {
			V.add(word.substring(0,2));
			V.add(word.substring(1,3));
		}
		
		for (String vertex : V) {
			adj.put(vertex,new LinkedList<String>());
			reverseadj.put(vertex,new LinkedList<String>());
		}
		
		for (String word : words) {
			String start = word.substring(0,2);
			String end = word.substring(1,3);
			adj.get(start).add(end);
			reverseadj.get(end).add(start);
		}
		
		scanner.close();
		
		
		// initialize undirected graph
		for (String vertex : adj.keySet()) {
			adjdfs.put(vertex, new LinkedList<String>());
		}
		
		for (String vertex : adj.keySet()) {
			for (String nbor : adj.get(vertex)) {
				adjdfs.get(vertex).add(nbor);
				adjdfs.get(nbor).add(vertex);
			}
		}
		
		if (!connected(adjdfs)) {
			System.out.println("xd");
			return false;
		}
		
		int startcount = 0;
		int endcount = 0;
		int intermediate = 0;
		boolean tour = true;
		
		for (String key : adj.keySet()) {
			if (adj.get(key).size() == reverseadj.get(key).size() + 1) {
				++startcount;
				tour = false;
			} else if (adj.get(key).size() + 1 == reverseadj.get(key).size()) {
				++endcount;
				tour = false;
			} else if (adj.get(key).size() == reverseadj.get(key).size()) {
				++intermediate;
			} else {
				return false;
			}
		}
		
		System.out.println(startcount);
		System.out.println(endcount);
		System.out.println(intermediate);
		
		
		return (startcount == 1 && endcount == 1 && intermediate == V.size() - 2) || tour;
	}
	
	private static boolean connected(HashMap<String,LinkedList<String>> adj) {
		visited = new HashSet<String>();
		String s = "";
		for (String x : adj.keySet()) {
			s = x;
			break;
		}
		if (s.equals("")) {
			return true;
		} else {
			DFSVisit(adj,s);
		}
		
		return visited.size() == adj.keySet().size();
	}
	
	private static void DFSVisit(HashMap<String,LinkedList<String>> adj,String s) {
		visited.add(s);
		for (String v: adj.get(s)) {
			if (!visited.contains(v)) {
				DFSVisit(adj,v);
			}
		}
	}
	
}
