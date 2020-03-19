package tests;



import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import graphstuff.Reader;
import graphstuff.Traversals;
import org.junit.jupiter.api.Test;

class ArtPointTest {

	@Test
	void testEmptyGraph() throws FileNotFoundException {
		assertTrue(readAndProcess("emptygraph.txt").isEmpty());
	}
	
	@Test
	void unconnected() throws FileNotFoundException {
		assertTrue(readAndProcess("unconnected1.txt").isEmpty());
		assertTrue(readAndProcess("unconnected2.txt").isEmpty());
	}
	
	@Test
	void generictestset1() throws FileNotFoundException {
		assertTrue(readAndProcess("artpointtest1.txt").equals(new HashSet<Integer>(Arrays.asList(2))));
		assertTrue(readAndProcess("artpointtest2.txt").isEmpty());
		assertTrue(readAndProcess("artpointtest3.txt").equals(new HashSet<Integer>(Arrays.asList(2,5,8,9))));
	}
	
	@Test
	void generictestset2() throws FileNotFoundException {
		assertTrue(readAndProcess("simpletree.txt").equals(new HashSet<Integer>(Arrays.asList(0,1,4,6))));
		assertTrue(readAndProcess("artpointtest4.txt").equals(new HashSet<Integer>(Arrays.asList(1))));
	}
	
	@Test
	void complete() throws FileNotFoundException {
		assertTrue(readAndProcess("complete4.txt").isEmpty());
		assertTrue(readAndProcess("complete6.txt").isEmpty());
	}
	
	String getFilesPath(String filename) {
		return "files\\" + filename;
	}
	
	Set<Integer> readAndProcess(String filename) throws FileNotFoundException {
		List<Integer>[] adj = Reader.readIntoListU(getFilesPath(filename));
		return Traversals.findArtsPoints(adj,false);
	}

}
