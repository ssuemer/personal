package hcpractice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.io.PrintStream;

class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		read_and_solve("a_example");
		read_and_solve("b_small");
		read_and_solve("c_medium");
		read_and_solve("d_quite_big");
		read_and_solve("e_also_big");
	}
	
	public static void read_and_solve(String path) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("C:\\Users\\asus\\git\\personal\\Playground\\src\\hcpractice\\input\\" + path + ".in"));
		int M = scanner.nextInt();
		int N = scanner.nextInt();
		int[] pizzaslices = new int[N];
		for (int i = 0; i < pizzaslices.length; i++) {
			pizzaslices[i] = scanner.nextInt();
		}
		scanner.close();
		
		boolean[][] DP = new boolean[N + 1][M + 1];
		for (int i = 0; i < DP.length; i++) {
			DP[i][0] = true;
		}
		
		for (int j = 1; j < DP[0].length; j++) {
			for (int i = 0; i < DP.length; i++) {
				if (i == 0) {
					continue;
				}
				if (pizzaslices[i - 1] > j) {
					DP[i][j] = DP[i - 1][j];
				} else {
					DP[i][j] = DP[i - 1][j] || DP[i - 1][j - pizzaslices[i]];
				}
			}
		}
		
		int x = 0;
		int y = 0;
		
		outerloop:
		for (int j = M; j >= 0; j--) {
			for (int i = N; i >= 0; i--) {
				if (DP[i][j]) {
					x = i;
					y = j;
					break outerloop;
				}
			}
		}
		
		ArrayList<Integer> pizzaschosen = new ArrayList<>();
		
		while (y > 0) {
			if (DP[x - 1][y - pizzaslices[x]]) {
				y -= pizzaslices[x];
				pizzaschosen.add(x);
				x--;
			} else {
				x--;
			}
		}
		
		Collections.sort(pizzaschosen);
		
		File output = new File("output\\" + path + "_out");
		PrintStream printer = new PrintStream(output);
		printer.println(pizzaschosen);
		printer.print(pizzaschosen.get(0));
		for (int ind = 1; ind < pizzaschosen.size(); ind++) {
			printer.print(" " + pizzaschosen.get(ind));
		}
		printer.close();
	}

}
