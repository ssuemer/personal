package graphtheorytests;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import graphtheory.BFS;
import graphtheory.Reader;

class BFSTest {

	@Test
	void test() throws FileNotFoundException {
		Scanner out = new Scanner(new File("out\\BFSout.txt"));
		int i = 0;
		while (out.hasNextLine()) {
			String expected = out.nextLine();
			String result = readAndProcess(i++);
			assertEquals("Graph number " + (i - 1) + " failed",expected,result);
		}
		out.close();
	}
	
	private String readAndProcess(int num) throws FileNotFoundException {
		return BFS.run(Reader.readIntoListU("graphs\\" + num + ".txt"));
	}

}
