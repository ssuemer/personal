package graphtheorytests;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import graphtheory.Components;
import graphtheory.Reader;

// to fix
class ComponentsTest {

	@Test
	void testartpointfiles() throws FileNotFoundException {
		assertTrue(readAndProcess("artpointtest1"));
		assertTrue(readAndProcess("artpointtest2"));
		assertTrue(readAndProcess("artpointtest3"));
		assertTrue(readAndProcess("artpointtest4"));
	}
	
	@Test
	void testcomplete() throws FileNotFoundException {
		assertTrue(readAndProcess("complete4"));
		assertTrue(readAndProcess("complete6"));
	}
	
	@Test
	void testcustom() throws FileNotFoundException {
		assertTrue(readAndProcess("custompath"));
		assertTrue(readAndProcess("disconnectedarts"));
	}
	
	private boolean readAndProcess(String path) throws FileNotFoundException {
		LinkedList<Integer>[] adj = Reader.readIntoListU("files\\" + path + ".txt");
		ArrayList<HashSet<Integer>> components = Components.get(adj);
		Scanner outreader = new Scanner(new File("componentsoutfiles\\" + path + "out.txt"));
		Scanner line;
		boolean[] used = new boolean[components.size()];
		int count = 0;
		while (outreader.hasNextLine()) {
			line = new Scanner(outreader.nextLine());
			int first = line.nextInt();
			count++;
			int component = -1;
			for (int i = 0; i < components.size(); i++) {
				if (components.get(i).contains(first)) {
					component = i;
					break;
				}
			}
			
			if (component == -1 || used[component]) {
				line.close();
				return false;
			}
			
			while (line.hasNextInt()) {
				count++;
				if (!components.get(component).contains(line.nextInt())) {
					line.close();
					return false;
				}
			}
			used[component] = true;
			line.close();
		}
		outreader.close();
		
		return count == adj.length;
	}

}
