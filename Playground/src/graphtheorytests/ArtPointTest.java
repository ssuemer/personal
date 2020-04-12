package graphtheorytests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.junit.jupiter.api.Test;

import graphtheory.ArtPoint;
import graphtheory.Reader;

class ArtPointTest {

	@Test
	void test() throws FileNotFoundException {
		Scanner out = new Scanner(new File("out\\artpointout.txt"));
		int i = 0;
		while (out.hasNextLine()) {
			Scanner line = new Scanner(out.nextLine());
			HashSet<Integer> expected = new HashSet<Integer>();
			while (line.hasNext()) {
				if (line.hasNextInt()) {
					expected.add(line.nextInt());
				} else {
					break;
				}
			}
			line.close();
			Set<Integer> result = readAndProcess(i++);
			assertEquals(expected,result,"Graph number " + (i - 1) + " failed.");
		}
		out.close();
	}
	
	private Set<Integer> readAndProcess(int num) throws FileNotFoundException {
		List<Integer>[] adj = Reader.readIntoListU("graphs\\" + num + ".txt");
		return ArtPoint.findArtsPoints(adj,false);
	}

}
