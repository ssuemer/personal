package mainPlayground;

import java.io.FileNotFoundException;
import java.util.LinkedList;

public class Main {
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		LinkedList<Integer> l = new LinkedList<Integer>();
		l.add(1);
		l.add(2);
		LinkedList<Integer> k = new LinkedList<Integer>();
		k.add(4);
		k.add(9);
		l.addAll(1, k);
		System.out.println(l);
	}
	
	
}

