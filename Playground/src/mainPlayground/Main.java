package mainPlayground;

import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		double c = 2;
		double x = c;
		for (int i = 0; i < 1000; i++) {
			x = 0.5 * (x + c / x);
		}
		System.out.println(x);
		
	}
}

