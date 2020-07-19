package mainPlayground;

import java.util.Random;

public class Main {
	
<<<<<<< HEAD
	static Random randomgen = new Random();
	
	public static void main(String[] args) {
		int N = 100_000_000;
		int[] a = randomData(N);
		int[] b = new int[N];
		int[] c = new int[N];
		
		long startTime = System.nanoTime();
		// the code you want to measure time for goes here
		for (int i = 1; i < a.length; i++) {
			a[i] = 2 * a[i - 1];
		}
		long endTime = System.nanoTime();
		long elapsedNs = endTime - startTime;
		double elapsedMs = elapsedNs / 1.0e6;
		System.out.println("Rolled: " + elapsedMs + " ms.");
		
		long startTimeR = System.nanoTime();
		// the code you want to measure time for goes here
		for (int i = 0; i < a.length; i += 8) {
			c[i] = 2 * a[i];
			c[i + 1] = 2 * a[i + 1];
			c[i + 2] = 2 * a[i + 2];
			c[i + 3] = 2 * a[i + 3];
			c[i + 4] = 2 * a[i + 4];
			c[i + 5] = 2 * a[i + 5];
			c[i + 6] = 2 * a[i + 6];
			c[i + 7] = 2 * a[i + 7];
		}
		long endTimeR = System.nanoTime();
		long elapsedNsR = endTimeR - startTimeR;
		double elapsedMsR = elapsedNsR / 1.0e6;
		System.out.println("Unrolled: " + elapsedMsR + " ms.");
=======
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.out.println(Runtime.getRuntime().availableProcessors());
>>>>>>> branch 'master' of https://github.com/Surpi5/personal.git
	}
	
	public static int[] randomData(int N) {
		int[] res = new int[N];
		
		for (int i = 0; i < res.length; i++) {
			res[i] = randomgen.nextInt(100);
		}
		
		return res;
	}

}


