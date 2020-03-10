package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

import graphstuff.Reader;
import graphstuff.Traversals;

class ConnectedTest {

	@Test
	void complete() throws FileNotFoundException {
		assertTrue(readAndProcess("complete4.txt"));
		assertTrue(readAndProcess("complete6.txt"));
	}
	
	@Test
	void empty() throws FileNotFoundException {
		assertFalse(readAndProcess("emptygraph.txt"));
	}
	
	@Test
	void unconnected() throws FileNotFoundException {
		assertFalse(readAndProcess("unconnected1.txt"));
		assertFalse(readAndProcess("unconnected2.txt"));
	}
	
	@Test
	void tree() throws FileNotFoundException {
		assertTrue(readAndProcess("simpletree.txt"));
	}
	
	@Test
	void arttests() throws FileNotFoundException {
		for (int i = 1; i <= 4; i++) {
			assertTrue(readAndProcess("artpointtest" + i + ".txt"));
		}
	}
	
	private boolean readAndProcess(String path) throws FileNotFoundException {
		return Traversals.connected(Reader.readIntoListU("files\\" + path));
	}
	
}
