package graphtheorytests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import algorithms.Network;

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
		Scanner in = new Scanner(new File("in\\santaclausin.txt"));
		Scanner out = new Scanner(new File("out\\santaclausout.txt"));
		
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			String res = out.next();
			boolean solved = solvesantaclaus(in);
			assertTrue((res.equals("yes") && solved) || (res.equals("no") && !solved),"Test case " + i + " failed");
		}
		
		in.close();
		out.close();
	}
	
	@Test
	void sustainthelifeforce() throws FileNotFoundException {
		Scanner in = new Scanner(new File("in\\sustainthelifeforcein.txt"));
		Scanner out = new Scanner(new File("out\\sustainthelifeforceout.txt"));
		
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			String res = out.next();
			boolean solved = solvesustainthelifeforce(in);
			assertTrue((res.equals("yes") && solved) || (res.equals("no") && !solved),"Test case " + i + " failed");
		}
		in.close();
		out.close();
	}
	
	@Test
	void bicycleauction() throws FileNotFoundException {
		Scanner in = new Scanner(new File("in\\bicycleauctionin.txt"));
		Scanner out = new Scanner(new File("out\\bicycleauctionout.txt"));
		
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			int res = out.nextInt();
			int solved = (int) solvebicycleauction(in);
			assertEquals(res,solved,"Test case " + i + " failed");
		}
		
		in.close();
		out.close();
	}
	
	@Test
	void buylowsellhigh() throws FileNotFoundException {
		Scanner in = new Scanner(new File("in\\buylowsellhighin.txt"));
		Scanner out = new Scanner(new File("out\\buylowsellhighout.txt"));
		
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			int res = out.nextInt();
			int solved = solvebuylowsellhigh(in);
			assertEquals(res,solved,"Test case " + i + " failed");
		}
		
		in.close();
		out.close();
	}
	
	private int solvebuylowsellhigh(Scanner in) {
		// TODO Auto-generated method stub
		final int INF = 10001;
        int n = in.nextInt();
        int m = in.nextInt();
        
        Network G = new Network(n);

        int s = 0, t = n - 1;
        int fragile = 0;
        for (int i = 0; i < m; i++) {
            int u = in.nextInt();
            int v = in.nextInt();

            int c = in.nextInt();
            if (c == 1) { // We can only use wooden bridges once
                fragile++;
                G.addEdge(u, v, 1);
                G.addEdge(v, u, 1);
            } else { // 
                G.addEdge(u, v, INF);
                G.addEdge(v, u, INF);
            }
        }

        int flow = (int) G.computeMaximumFlow(s, t);
        if (flow > fragile) {
            // The only way to get more flow than wooden bridges, is if there
            // is a path that uses only brick bridges between s and t.
            return -1;
        } else {
            // We have to go back and forth, so we divide the total # of paths over 2
            return flow / 2; 
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
