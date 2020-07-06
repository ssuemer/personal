package graphtheorytests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
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
	
	@Test
	void importantstops() throws FileNotFoundException {
		Scanner in = new Scanner(new File("in\\importantstopsin.txt"));
		Scanner out = new Scanner(new File("out\\importantstopsout.txt"));
		
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			String res = out.nextLine();
			String solved = solveimportantstops(in);
			assertEquals(res,solved,"Test case " + i + " failed.");
		}
		
		in.close();
		out.close();
	}
	
	@SuppressWarnings("unchecked")
	private String solveimportantstops(Scanner in) {
		int n = in.nextInt();
		int m = in.nextInt();
		
        LinkedList<Integer>[] adj = new LinkedList[n];
        for (int i = 0; i < adj.length; i++){
          adj[i] = new LinkedList<Integer>();
        }
        
        for (int i = 0; i < m; i++){
          int a = in.nextInt();
          int b = in.nextInt();
          adj[a].add(b);
          adj[b].add(a);
        }
        
        ArrayList<Integer> arts = new ArrayList<Integer>(ArtPoint.findArtsPoints(adj, true));
        Collections.sort(arts);
        String res = "";
        if (arts.isEmpty()) {
        	return "-1";
        } else {
        	res += arts.get(0);
        	for (int i = 1; i < arts.size(); i++) {
        		res += " " + arts.get(i);
        	}
        	return res;
        }
	}
	
	private Set<Integer> readAndProcess(int num) throws FileNotFoundException {
		List<Integer>[] adj = Reader.readIntoListU("graphs\\" + num + ".txt");
		return ArtPoint.findArtsPoints(adj,false);
	}

}
