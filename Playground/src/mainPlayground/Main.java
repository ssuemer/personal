package mainPlayground;

import java.io.FileNotFoundException;

import graphstuff.Reader;
import graphstuff.Traversals;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.out.println(Traversals.findArtsPoints(Reader.readIntoListU("files\\exdebug.txt"),true));
	}
}

