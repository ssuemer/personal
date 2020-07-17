package graphtheorytests;

import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import org.junit.jupiter.api.Test;

import graphtheory.EulerTour;
import graphtheory.Reader;

class EulerTourTest {

	@Test
	void simple() throws FileNotFoundException {
		for (int i = 18; i <= 18; i++) {
			assertTrue(readAndProcess(i));
		}
	}
	
	@Test
	void complete() {
		for (int i = 3; i <= 151; i += 2) {
			LinkedList<Integer>[] adj = Reader.completegraph(i);
			assertTrue(verifyTour(adj,EulerTour.find(adj)));
		}
	}
	
	@Test
	void cycle() {
		for (int i = 3; i <= 100; i++) {
			LinkedList<Integer>[] adj = Reader.cycle(i);
			assertTrue(verifyTour(adj,EulerTour.find(adj)));
		}
	}
	
	
	private static boolean verifyTour(LinkedList<Integer>[] adj,LinkedList<Integer> result) {
		int E = 0;
		for (LinkedList<Integer> nbourhood : adj) {
			E += nbourhood.size();
		}
		E /= 2;
		Set<Edge> edges = new HashSet<Edge>();
		for (int i = 0; i < result.size() - 1; i++) {
			int u = result.get(i);
			int v = result.get(i + 1);
			if (!adj[u].contains(v) || edges.contains(new Edge(u,v))) {
				return false;
			} else {
				edges.add(new Edge(u,v));
			}
		}
		return edges.size() == E;
	}
	
	private static boolean readAndProcess(int i) throws FileNotFoundException {
		LinkedList<Integer>[] adj = Reader.readIntoListU("graphs\\" + i + ".txt");
		return verifyTour(adj,EulerTour.find(adj));
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
