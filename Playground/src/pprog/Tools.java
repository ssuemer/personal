package pprog;

import java.util.Random;

public class Tools {
	
	private static Random randomgen = new Random();
	
	/**
	 * 
	 * @param length: length of the input data structure
	 * @param numPartitions: desired number of partitions
	 * @return An array of ArraySplit objects that each specify the partition.
	 * Divides a given work fairly among a given number of workers.
	 * Maximum work difference = 1.
	 */
	
	public static ArraySplit[] PartitionData(int length, int numPartitions) {

		assert numPartitions > 0 : "numPartitions must be larger than 0";
		int n = numPartitions;
		ArraySplit[] res = new ArraySplit[n];
		assert length >= 0 : "length can not be negative";
		
		// edge case,return dummy result
		if (length == 0) {
			for (int i = 0; i < numPartitions; i++) {
				res[i] = new ArraySplit(0,0);
			}
			return res;
		}
		
		numPartitions = Math.min(length, numPartitions); // make sure there aren't more threads than pieces of data
		double intervalLength = (double) length / numPartitions; 
		/*
		 * Uses the fact that n = roundUp(n / p) * (n % p) + roundDown(n / p) * (p - n % p) for all 0 < p <= n
		 * to make sure that the work is distributed evenly among the partitions
		 */
		int upper = (int) Math.ceil(intervalLength);
		int lower = (int) Math.floor(intervalLength);
		int c = length % numPartitions;
		int start = 0;
		
		
		for (int i = 0; i < c; i++) {
			res[i] = new ArraySplit(start,upper);
			start += upper;
		}
		
		for (int i = c; i < numPartitions; i++) {
			res[i] = new ArraySplit(start,lower);
			start += lower;
		}
		
		for (int i = numPartitions; i < n; i++) {
			res[i] = new ArraySplit(numPartitions,0);
		}
		
		return res;
	}
	
	/**
	 * Element of a partitioned work.
	 */
	public static class ArraySplit {
		public final int startIndex;
		public final int length;
		
		ArraySplit(int startIndex, int length) {
			this.startIndex = startIndex;
			this.length = length;
		}
	}
	
	
	/**
	 * Generates an integer array filled with
	 * pseudorandomly generated values.
	 */
	public static int[] randomData(int N) {
		int[] res = new int[N];
		
		for (int i = 0; i < res.length; i++) {
			res[i] = randomgen.nextInt(100);
		}
		
		return res;
	}
	
	/**
	 * Not intended for actual calls,
	 * code snippet to measure the time 
	 * it takes for a procedure to finish.
	 */
	@SuppressWarnings("unused")
	private static void timeMeasurement() {
		long startTime = System.nanoTime();
		// the code you want to measure time for goes here
		long endTime = System.nanoTime();
		long elapsedNs = endTime - startTime;
		double elapsedMs = elapsedNs / 1.0e6;
	}
	
	public static ArrayOperation[] createTasks (int[] arr,int numtasks,ArrayOperation.Type type) {
		ArraySplit[] partition = PartitionData(arr.length, numtasks);
		ArrayOperation[] tasks = new ArrayOperation[numtasks];
		for (int i = 0; i < tasks.length; i++) {
			if (type == ArrayOperation.Type.SUM) {
				tasks[i] = new ArraySum(arr,partition[i]);
			} else if (type == ArrayOperation.Type.PRIMECOUNT) {
				tasks[i] = new ArrayPrimeCounter(arr, partition[i]);
			}
		}
		return tasks;
	}
	
}
