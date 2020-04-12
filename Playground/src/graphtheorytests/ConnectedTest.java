package graphtheorytests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import graphtheory.Connected;
import graphtheory.Reader;

class ConnectedTest {

	@Test
	void test() throws FileNotFoundException {
		Scanner out = new Scanner(new File("out\\connectedout.txt"));
		int i = 0;
		while (out.hasNext()) {
			String expected = out.next();
			boolean result = readAndProcess(i++);
			boolean condition = result && expected.equals("yes") || !result && expected.equals("no");
			assertTrue(condition,"Graph number " + (i - 1) + " failed");
		}
		out.close();
	}
	
	private boolean readAndProcess(int num) throws FileNotFoundException {
		return Connected.connected(Reader.readIntoListU("graphs\\" + num + ".txt"));
	}
	
}
