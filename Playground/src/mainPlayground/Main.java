package mainPlayground;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;

import graphstuff.GraphReader;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		LinkedList<Integer>[] adjlist = GraphReader.readIntoList("files\\graph.txt");
		for (LinkedList<Integer> linkedList : adjlist) {
			System.out.println(linkedList.toString());
		}
	}	
}

