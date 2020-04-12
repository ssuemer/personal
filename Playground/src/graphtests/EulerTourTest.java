package graphtests;



import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

import graphtheory.EulerTour;
import graphtheory.Reader;

class EulerTourTest {

	@Test
	void simpleGeneric() throws FileNotFoundException {
		for (int i = 0; i < 8; i++) {
			List<Integer>[] adj = Reader.readIntoListU("files\\eulertourtest" + (i + 1) + ".txt");
			assertTrue(verifyTour(adj,EulerTour.find(adj)));
		}
	}
	
	
	
	private static boolean verifyTour(List<Integer>[] adj,LinkedList<Integer> result) {
		int E = 0;
		for (List<Integer> nbourhood : adj) {
			E += nbourhood.size();
		}
		E /= 2;
		Set<Edge> edges = new HashSet<Edge>();
		for (int i = 0; i < result.size() - 1; i++) {
			int u = result.get(i);
			int v = result.get(i + 1);
			if (!edges.add(new Edge(u,v))) {
				return false;
			} 
		}
		return edges.size() == E;
	}
}

class Edge {
	int u;
	int v;
	
	public Edge(int u, int v) {
		this.u = u;
		this.v = v;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Edge) {
			Edge e2 = (Edge) o;
			return u == e2.u && v == e2.v;
		} else {
			return false;
		}
	}
	
}
