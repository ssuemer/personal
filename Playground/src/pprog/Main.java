package pprog;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numThreads = Runtime.getRuntime().availableProcessors();
		int numTasks = numThreads;
		int[] randomData = Tools.randomData(1_000_000,200);
		
		long startTime = System.nanoTime();
		ArrayOperation[] tasks = Tools.createTasks(randomData, numTasks, ArrayOperation.Type.PRIMECOUNT);
//		for (ArrayOperation task: tasks) {
//			System.out.println(task);
//		}
		ExecutorService exs = Executors.newFixedThreadPool(numThreads);
		for (ArrayOperation task: tasks) {
			exs.submit(task);
		}
		
		int parallelresult = 0;
		
		exs.shutdown();
		try {
			exs.awaitTermination(1, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (ArrayOperation task : tasks) {
			parallelresult += task.res;
		}
		long endTime = System.nanoTime();
		long elapsedNs = endTime - startTime;
		double elapsedMs = elapsedNs / 1.0e6;
		
		System.out.println("Parallel result: " + parallelresult + " calculated in " + elapsedMs + " millisecs.");
		
		long startTime2 = System.nanoTime();
		int seqresult = 0;
		for (Integer i: randomData) {
			if (ArrayPrimeCounter.isPrime(i)) {
				seqresult++;
			}
		}
		
		long endTime2 = System.nanoTime();
		long elapsedNs2 = endTime2 - startTime2;
		double elapsedMs2 = elapsedNs2 / 1.0e6;
		
		System.out.println("Sequential result: " + seqresult + " calculated in " + elapsedMs2 + " millisecs.");
	}
}
