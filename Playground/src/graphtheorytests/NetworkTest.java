package graphtheorytests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import graphtheory.Network;

class NetworkTest {
	
	@Test
	void simplenetworks() {
		Network g = new Network(3);
		g.addEdge(0, 1, 2);
		g.addEdge(1, 2, 3);
		assertEquals(g.computeMaximumFlow(0, 2),2);
	}
	
	
	@Test
	void santaclaus() throws FileNotFoundException {
		Scanner in = new Scanner(new File("networks\\santaclausin.txt"));
		Scanner out = new Scanner(new File("networksout\\santaclausout.txt"));
		
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			String res = out.next();
			boolean solved = solvesantaclaus(in);
			assertTrue((res.equals("yes") && solved) || (res.equals("no") && !solved),"Test case " + i + " failed");
		}
	}
	
	@Test
	void sustainthelifeforce() throws FileNotFoundException {
		Scanner in = new Scanner(new File("networks\\sustainthelifeforcein.txt"));
		Scanner out = new Scanner(new File("networksout\\sustainthelifeforceout.txt"));
		
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			String res = out.next();
			boolean solved = solvesustainthelifeforce(in);
			assertTrue((res.equals("yes") && solved) || (res.equals("no") && !solved),"Test case " + i + " failed");
		}
	}
	
	@Test
	void bicycleauction() throws FileNotFoundException {
		Scanner in = new Scanner(new File("networks\\bicycleauctionin.txt"));
		Scanner out = new Scanner(new File("networksout\\bicycleauctionout.txt"));
		
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			int res = out.nextInt();
			int solved = (int) solvebicycleauction(in);
			assertEquals(res,solved,"Test case " + i + " failed");
		}
	}
	
	private double solvebicycleauction(Scanner in) {
		// TODO Auto-generated method stub
        int c = in.nextInt();
        int b = in.nextInt();
        // 0 = source, 1 to c = cyclists, c + 1 to c + b = bikes, c + b + 1 = sink
        Network g = new Network(c + b + 2);
        
        for (int i = 1; i <= c; i++) {
          g.addEdge(0,i,1);
        }
        for (int j = c + 1; j <= c + b; j++) {
          g.addEdge(j,c + b + 1,1);
        }
        
        for (int i = 1; i <= c; i++) {
          int x = in.nextInt();
          for (int j = 0; j < x; j++) {
            g.addEdge(i,c + in.nextInt(),1);
          }
        }
        
        return g.computeMaximumFlow(0, c + b + 1);
	}


	private boolean solvesustainthelifeforce(Scanner in) {
		int n = in.nextInt();
		int m = in.nextInt();
		int[] plants = new int[n + 1];
		int[] needed = new int[n + 1];
		int totaloutflow = 0;
		
		Network g = new Network(2 * n + 2);
        for (int i = 1; i <= n; i++) {
            plants[i] = in.nextInt();
            needed[i] = in.nextInt();
            if (plants[i] != 0) {
              g.addEdge(0,i,plants[i]);
              g.addEdge(i,i + n,plants[i]);
            }
            
            if (needed[i] != 0) {
              g.addEdge(i,  2 * n + 1, needed[i]);
              totaloutflow += needed[i];
            }
        }
        
        for (int i = 0; i < m; i++) {
            int u = in.nextInt() + 1;
            int v = in.nextInt() + 1;
            if (plants[u] != 0) {
              g.addEdge(u + n,v,plants[u]);
            }
        }
        
        double maxflow = g.computeMaximumFlow(0, 2 * n + 1);
        return maxflow == totaloutflow;
	}
	
	private boolean solvesantaclaus(Scanner in) {
		int n = in.nextInt();
		int m = in.nextInt();
		int deservedsum = 0;
		
		Network g = new Network(n + m + 2);
		
		for (int i = m + 1; i < m + n + 1; i++) { 
	       int deserved = in.nextInt();
	       g.addEdge(i,m + n + 1,deserved);
	       deservedsum += deserved;
	    }
	        
	    // edges from the source to gifts with the amount of gifts santa has as capacity
	    for (int i = 1; i <= m; i++) {
	       g.addEdge(0,i,in.nextInt());
	       // edges from each gift to each child with capacity 1
	       for (int j = m + 1; j < m + n + 1; j++) {
	          g.addEdge(i,j,1);
	       }
	    }
	    
	    double maxflow = g.computeMaximumFlow(0, n + m + 1);
	    return maxflow == deservedsum;
	}

}
