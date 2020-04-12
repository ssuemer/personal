package mainPlayground;

import java.io.FileNotFoundException;

import graphtheory.ArtPoint;
import graphtheory.Reader;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.out.println(ArtPoint.findArtsPoints(Reader.readIntoListU("files\\exdebug.txt"),true));
	}
}

