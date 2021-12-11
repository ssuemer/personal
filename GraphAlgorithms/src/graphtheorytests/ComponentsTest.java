package graphtheorytests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import algorithms.Components;
import tools.Reader;


class ComponentsTest {

	@Test
	void test() throws FileNotFoundException {
		Scanner out = new Scanner(new File("out\\componentsout.txt"));
		int i = 0;
		while (out.hasNextLine()) {
			Scanner line = new Scanner(out.nextLine());
			ArrayList<HashSet<Integer>> expected = new ArrayList<HashSet<Integer>>();
			while (line.hasNext()) {
				HashSet<Integer> component = new HashSet<Integer>();
				while (line.hasNextInt()) {
					component.add(line.nextInt());
				}
				if (line.hasNext()) {
					line.next();
				}
				expected.add(component);
			}
			line.close();
			assertEquals(expected,readAndProcess(i),"Graph number " + i + " failed.");
			i++;
		}
		out.close();
	}
	
	private ArrayList<HashSet<Integer>> readAndProcess(int num) throws FileNotFoundException {
		LinkedList<Integer>[] adj = Reader.readIntoListU("graphs\\" + num + ".txt");
		return Components.get(adj);
	}

}
