package graphstuff;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		List<Integer>[] adj = Reader.readIntoListU("files\\artpointtest1.txt");
		Set<Integer> artpoints = Traversals.findArtsPoints(adj);
		System.out.println("Cut vertices:");
		for (Integer integer : artpoints) {
			System.out.println(integer);
		}
	}

}
