package graphtheorytests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

import graphtheory.ISet;
import graphtheory.Reader;

class ISetTest {

	@Test
	void test() throws FileNotFoundException {
		for (int num = 0; num <= 14; num++) {
			LinkedList<Integer>[] adj = Reader.readIntoListU("graphs\\" + num + ".txt");
			boolean[] res = ISet.find(adj);
			for (int u = 0; u < adj.length; u++) {
				for (Integer v: adj[u]) {
					assertFalse(res[u] && res[v],"Vertex " + u + " and vertex " + v + "are connected.");
				}
			}
		}
	}
}
