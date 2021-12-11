package graphtheorytests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

import algorithms.MinimalCut;
import tools.Reader;

class MinimalCutTest {

	@Test
	void test() throws FileNotFoundException {
		LinkedList<Integer>[] adj = Reader.readIntoListU("graphs\\16.txt");
		int res = MinimalCut.v2(adj,5);
		assertEquals(4, res);
		
		adj = Reader.readIntoListU("graphs\\17.txt");
		res = MinimalCut.v2(adj, 5);
		assertEquals(5, res);
	}

}
