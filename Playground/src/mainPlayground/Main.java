package mainPlayground;

import java.io.FileNotFoundException;
import java.util.LinkedList;

import graphtheory.Components;
import graphtheory.Reader;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		LinkedList<Integer>[] adj = Reader.readIntoListU("graphs\\7.txt");
		System.out.println(Components.get(adj));
	}
}

