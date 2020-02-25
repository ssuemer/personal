package tests;

import static org.junit.Assume.assumeTrue;

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
		assumeTrue(readAndProcess("emptygraph.txt").isEmpty());
	}
	
	@Test
	void unconnected() throws FileNotFoundException {
		assumeTrue(readAndProcess("unconnected1.txt").isEmpty());
		assumeTrue(readAndProcess("unconnected2.txt").isEmpty());
	}
	
	@Test
	void generic() throws FileNotFoundException {
		assumeTrue(readAndProcess("artpointtest1.txt").equals(new HashSet<Integer>(Arrays.asList(2))));
		assumeTrue(readAndProcess("artpointtest2.txt").isEmpty());
		assumeTrue(readAndProcess("artpointtest3.txt").equals(new HashSet<Integer>(Arrays.asList(2,5,8,9))));
	}
	
	String getFilesPath(String filename) {
		return "files\\" + filename;
	}
	
	Set<Integer> readAndProcess(String filename) throws FileNotFoundException {
		List<Integer>[] adj = Reader.readIntoListU(getFilesPath(filename));
		return Traversals.findArtsPoints(adj);
	}

}
