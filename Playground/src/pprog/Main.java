package pprog;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int length = 1_000_000;
		int numthreads = Runtime.getRuntime().availableProcessors();

		int[] data = Tools.randomData(length);
		
		long startTime = System.nanoTime();
		Thread[] workers = new Thread[numthreads];
		ArrayOperation[] tasks = Tools.createTasks(data, numthreads, ArrayOperation.Type.PRIMECOUNT);
		
		for (int i = 0; i < workers.length; i++) {
			workers[i] = new Thread(tasks[i]);
			workers[i].start();
		}
		
		for (Thread worker : workers) {
			try {
				worker.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		int res = 0;
		for (ArrayOperation task : tasks) {
			res += task.get();
		}
		long endTime = System.nanoTime();
		long elapsedNs = endTime - startTime;
		double elapsedMs = elapsedNs / 1.0e6;
		
		System.out.println("Parallel result:   " + res + " found in " + elapsedMs + " ms using " + numthreads + " threads");
		
		long startTimeSeq = System.nanoTime();
		
		int resSeq = 0;
		for (int i = 0; i < data.length; i++) {
			if (ArrayPrimeCounter.isPrime(i)) {
				resSeq++;
			}
		}
		
		long endTimeSeq = System.nanoTime();
		long elapsedNsSeq = endTimeSeq - startTimeSeq;
		double elapsedMsSeq = elapsedNsSeq / 1.0e6;
		
		System.out.println("Sequential result: " + resSeq + " found in " + elapsedMsSeq + " ms");
		
		long startTimeEx = System.nanoTime();
		ExecutorService ex = Executors.newFixedThreadPool(numthreads);
		ArrayOperation[] tasksEx = Tools.createTasks(data, numthreads, ArrayOperation.Type.SUM);
		Future<?>[] results = new Future<?>[numthreads];
		
		for (int i = 0; i < tasksEx.length; i++) {
			results[i] = ex.submit(tasksEx[i]);
		}
		
		int resEx = 0;
		for (int i = 0; i < tasksEx.length; i++) {
			try {
				results[i].get();
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resEx += tasksEx[i].get();
		}
		
		ex.shutdown();
		
		long endTimeEx = System.nanoTime();
		long elapsedNsEx = endTimeEx - startTimeEx;
		double elapsedMsEx = elapsedNsEx / 1.0e6;
		
		System.out.println("ES result:   " + resEx + " found in " + elapsedMsEx + " ms using " + numthreads + " threads");
	}
}
