package graphtheory;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ArtPoint {
	
	// fields required for finding articulation points,they are automatically set to default values before the algorithm
	private static int[] dfs;
	private static int[] low;
	private static Set<Integer> arts;
	private static int num;
	private static List<Integer>[] dfstree;
	
	@SuppressWarnings("unchecked")
	public static Set<Integer> findArtsPoints(List<Integer>[] adj,boolean componentsallowed) {
		arts = new HashSet<Integer>();
		dfs = new int[adj.length];
		low = new int[adj.length];
		num = 0;
		dfstree = new LinkedList[adj.length];
		for (int i = 0; i < dfstree.length; i++) {
			dfstree[i] = new LinkedList<Integer>();
		}
		if (!componentsallowed) {
			DFSArt(adj,0); // start at vertex
			if (dfstree[0].size() >= 2) {
				arts.add(0);
			} else {
				arts.remove(0);
			}
			if (num != adj.length) {
				arts.clear();
			}
			return arts;
		} else { // if graph isn't connected,find "local" cut vertices
			for (int i = 0; i < dfs.length; i++) {
				if (dfs[i] == 0) {
					DFSArt(adj,i);
					if (dfstree[i].size() >= 2) {
						arts.add(i);
					} else {
						arts.remove(i);
					}
				}
			}
			return arts;
		}
	}

	private static int DFSArt(List<Integer>[] adj, int v) {
		// TODO Auto-generated method stub
		dfs[v] = ++num; // set dfs number for current vertex
		low[v] = dfs[v]; // set default low number
		for (Integer w: adj[v]) { // iterate over neighbours
			if (dfs[w] == 0) { // if nonvisited
				dfstree[v].add(w); // add to dfs-tree
				int val = DFSArt(adj,w); // get low number of neighbour while visiting
				if (val >= dfs[v]) { // check condition
					arts.add(v);
				}
				low[v] = Math.min(low[v], val); // update low value
			} else if (dfs[w] != 0 && !dfstree[v].contains(w)) {
				low[v] = Math.min(low[v], dfs[w]); // update low value
			}
		}
		return low[v]; 
	}
	
}
