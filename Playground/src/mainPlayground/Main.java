package mainPlayground;

import java.io.FileNotFoundException;
import java.util.LinkedList;

import graphtheory.LongPath;
import graphtheory.Reader;

public class Main {
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		LinkedList<Integer>[] adj = Reader.readIntoListU("graphs\\15.txt");
		System.out.println(LongPath.find(adj,10,0.01));
	}
	
	
}

